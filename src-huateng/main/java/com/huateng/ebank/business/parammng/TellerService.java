/*
 * ==================================================================
 * The Huateng Software License
 *
 * Copyright (c) 2004-2005 Huateng Software System.  All rights
 * reserved.
 * ==================================================================
 */
package com.huateng.ebank.business.parammng;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.management.relation.RoleInfo;

import org.hibernate.Hibernate;
import org.hibernate.type.Type;

import com.huateng.ebank.business.common.BaseDAOUtils;
import com.huateng.ebank.business.common.ErrorCode;
import com.huateng.ebank.business.common.SystemConstant;
import com.huateng.ebank.entity.data.mng.FunctionInfo;
import com.huateng.ebank.entity.data.mng.TlrRoleRel;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.orm.HQLDAO;
import com.huateng.ebank.framework.util.ApplicationContextUtils;
import com.huateng.ebank.framework.util.ExceptionUtil;

/**
 * @author valley
 * @date 2005-6-8
 * @desc 操作员Service
 */
public class TellerService {

    private static TellerService single = null;

    protected TellerService() {
    }

    /**
     * Get instance of service
     * @return
     */
    public synchronized static TellerService getInstance() {
    	/*
        if (null == single) {
            single = new TellerService();
        }
        return single;
        */
    	return (TellerService)ApplicationContextUtils.getBean("TellerService");
    }


//    /**
//     * 根据指定的用户号和角色id找到对应的机构号.
//     * @param tlrno	用户号
//     * @param roleId 角色Id
//     * @return  机构号
//     * @throws CommonException
//     */
//    public String getBrcodeByTlrRole(String tlrno, int roleId)
//            throws CommonException {
//        TlrRoleRelDAO tlrRoleRelationDAO = DAOUtils
//                .getTlrRoleRelDAO();
//        List list = tlrRoleRelationDAO.queryByCondition(
//                "po.tlrno=? and po.roleId=?", new Object[] { tlrno,
//                        new Integer(roleId) }, new Type[] { Hibernate.STRING,
//                        Hibernate.INTEGER });
//        if (null == list || list.isEmpty()) {
//            ExceptionUtil.throwCommonException("用户" + tlrno + "在任何机构上都没有配置角色"
//                    + roleId, ErrorCode.ERROR_CODE_TLR_ROLE_RELATION_SELECT);
//        }
//        if (list.size() > 1) {
//            ExceptionUtil.throwCommonException("用户" + tlrno + "在多个机构上拥有角色"
//                    + roleId, ErrorCode.ERROR_CODE_TLR_ROLE_RELATION_SELECT);
//        }
//
//        TlrRoleRel tlrRoleRelation = (TlrRoleRel) list.get(0);
//        return tlrRoleRelation.getBrcode();
//    }

//    /**
//     * 获取柜员所属机构
//     * @param tlrno
//     * @param funcCode 交易代码，填0时表示不限交易
//     * @return 如果没找到则返回null
//     * @throws CommonException
//     */
//    public String getTellerBrcode(String tlrno, String funcCode)
//            throws CommonException {
//        String brcode = null;
//        Iterator it = DAOUtils.getHQLDAO().queryByQL(
//                "select distinct po.brcode from TlrRoleRelation po where po.tlrno = '"
//                        + tlrno + "'");
//        if (it.hasNext()) {
//            brcode = ((String) it.next()).trim();
//            if (!it.hasNext())
//                return brcode;
//        } else
//            return null;
//
//        List list = getTellerRoleList(tlrno);
//        String brclass = "9";
///*
//        if (funcCode > 0) {
//            FunctionInfo funcInfo = DAOUtils.getFunctionInfoDAO().query(funcCode);
//            if (funcInfo.getMenuFlag().equals(SystemConstant.FLAG_OFF))
//                funcCode = funcInfo.getUpFuncCode();
//        }
//        */
//
//        if (funcCode.equals("0")
//                || DAOUtils.getFunctionInfoDAO().query(Integer.parseInt(funcCode)).getStatus()
//                        .equals(SystemConstant.FLAG_OFF)) {
//            for (int i = 0; i < list.size(); i++) {
//                String brcodei = ((TlrRoleRel) list.get(i)).getBrcode();
//                if (BctlService.getInstance().getBrclass(brcodei).compareTo(
//                        brclass) < 0)
//                    brcode = brcodei;
//            }
//        } else {
//            brcode = null;
//            for (int i = 0; i < list.size(); i++) {
//                TlrRoleRel tlrRoleRelation = (TlrRoleRel) list.get(i);
//                List listi = DAOUtils.getRoleFuncRelationDAO()
//                        .queryByCondition(
//                                "po.roleId = " + tlrRoleRelation.getRoleId()
//                                        + " and po.funcCode = '" + funcCode + "'");
//                if (!listi.isEmpty()) {
//                    String brcodei = tlrRoleRelation.getBrcode();
//                    if (BctlService.getInstance().getBrclass(brcodei)
//                            .compareTo(brclass) < 0)
//                        brcode = brcodei;
//                }
//            }
//        }
//        return brcode;
//    }

    /**
     * 获取指定柜员的角色列表, 角色列表中存放的是roleInfo信息.
     * @param tlrno
     * @return
     * @throws CommonException
     */
    public List getTellerRoleInfoList(String tlrno) throws CommonException {
        HQLDAO hqlDAO = BaseDAOUtils.getHQLDAO();

        Iterator it = hqlDAO
                .queryByQL(
                        "select roleInfo from RoleInfo roleInfo, TlrRoleRel trr where roleInfo.roleId = trr.roleId and trr.tlrno = ?",
                        new String[] { tlrno }, new Type[] { Hibernate.STRING });
        List list = new ArrayList();
        while (it.hasNext()) {
            RoleInfo roleInfo = (RoleInfo) it.next();
            list.add(roleInfo);
        }
        return list;
    }

    /**
     * 获取柜员岗位列表
     * @param tlrno
     * @return 包含TlrRoleRelation的list
     * @throws CommonException
     */
    public List getTellerRoleList(String tlrno) throws CommonException {
        return BaseDAOUtils.getTlrRoleRelDAO().queryByCondition(
                "tlrno = '" + tlrno + "'");
    }

    /**
     * 判断柜员是否可做该交易
     * @param tlrno
     * @return
     * @throws CommonException
     */
    public boolean checkTellerFuncRight(String tlrno, String funcCode)
            throws CommonException {
        if (funcCode.equals("0"))
            return true;

        FunctionInfo funcInfo = BaseDAOUtils.getFunctionInfoDAO().query(funcCode);
        if (funcInfo.getStatus().equals(SystemConstant.VALID_FLAG_INVALID))
            return false;

        if (funcInfo.getFuncClass().equals("2")) {
            //如果是交易
            if (funcInfo.getStatus().equals(SystemConstant.FLAG_OFF)) {
                return checkTellerFuncRight(tlrno, funcInfo.getUpFuncCode());
            } else {
                Iterator it = BaseDAOUtils
                        .getHQLDAO()
                        .queryByQL(
                                "select a from TlrRoleRel a, RoleFuncRel b where a.roleId = b.roleId and a.tlrno = '"
                                        + tlrno
                                        + "' and b.funcCode = "
                                        + funcCode);
                if (it.hasNext())
                    return true;
                else
                    return false;
            }
        } else {
            //如果是菜单
            List list = BaseDAOUtils.getFunctionInfoDAO().queryByCondition(
                    "po.upFuncCode = " + funcCode + " and po.status = '"
                            + SystemConstant.VALID_FLAG_VALID + "'");
            for (int i = 0; i < list.size(); i++) {
                FunctionInfo blnFuncInfo = (FunctionInfo) list.get(i);
                if (checkTellerFuncRight(tlrno, blnFuncInfo.getId()))
                    return true;
            }
        }

        return false;
    }

    /**
     * 获取柜员岗位列表
     * @param tlrno
     * @return 包含role_id的list
     * @throws CommonException
     */
    public List getTellerRoleList(String tlrno, String funcCode)
            throws CommonException {
        FunctionInfo funcInfo = BaseDAOUtils.getFunctionInfoDAO().query(funcCode);
        if (funcInfo.getStatus().equals(SystemConstant.FLAG_OFF))
            funcCode = funcInfo.getUpFuncCode();

        List list = new ArrayList();
        Iterator it = BaseDAOUtils
                .getHQLDAO()
                .queryByQL(
                        "select a.roleId from TlrRoleRel a, RoleFuncRel b where a.roleId = b.roleId and a.tlrno = '"
                                + tlrno + "' and b.funcCode = " + funcCode);
        while (it.hasNext()) {
            list.add((it.next()));
        }
        return list;
    }

//    /**
//     * 根据工作流的角色编号找到对应的角色信息的编号.
//     * @param workflowRole
//     * @throws CommonException
//     */
//    public int getRoleIdByWorkflowRole(String workflowRole)
//            throws CommonException {
//        RoleInfoDAO roleInfoDAO = DAOUtils.getRoleInfoDAO();
//        RoleInfo roleInfo = roleInfoDAO.getRoleInfoByWorkflowRule(workflowRole);
//        if (null == roleInfo) {
//            ExceptionUtil.throwCommonException("",
//                    ErrorCode.ERROR_CODE_ROLE_INFO_SELECT);
//        }
//        return roleInfo.getId();
//    }

    /**
     * 得到岗位类型
     * @param roleId
     * @return
     * @throws CommonException
     */
    public String getRoleType(int roleId) throws CommonException {
        return BaseDAOUtils.getRoleInfoDAO().query(roleId).getRoleType();
    }

    /**
     * 根据岗位类型获取岗位信息
     * @param roleType
     * @return
     * @throws CommonException
     */
    public List getRoleIdByType(String roleType)throws CommonException{
    	try{
    		List result = BaseDAOUtils.getRoleInfoDAO().queryByCondition(" po.roleType = '" + roleType + "'");
    		if( result.isEmpty() ){
    			ExceptionUtil.throwCommonException("没有指定的岗位信息.",
                        ErrorCode.ERROR_CODE_ROLE_INFO_SELECT);
    		}
    		return result;
    	}catch(CommonException commEx){
    		throw commEx;
    	}catch(Exception ex){
    		ExceptionUtil.throwCommonException("获取岗位信息出错.",
                    ErrorCode.ERROR_CODE_ROLE_INFO_SELECT,ex);
    	}
    	return null;

    }

    /**
     * 根据岗位类型和操作员号获取岗位信息
     * @param roleType
     * @return
     * @throws CommonException
     */
    public List getRoleIdByTypeAndTlrno(String roleType,String tlrno)throws CommonException{
    	try{
            List list = new ArrayList();
            Iterator it = BaseDAOUtils
                    .getHQLDAO()
                    .queryByQL(
                            "select b from TlrRoleRel a, RoleInfo b where a.roleId = b.id and a.tlrno = '"
                                    + tlrno + "'");
            while (it.hasNext()) {
                list.add((it.next()));
            }
            return list;
    	}catch(CommonException commEx){
    		throw commEx;
    	}catch(Exception ex){
    		ExceptionUtil.throwCommonException("获取岗位信息出错.",
                    ErrorCode.ERROR_CODE_ROLE_INFO_SELECT,ex);
    	}
    	return null ;

    }
    /**
     * 根据当前角色号获取是否有有角色权限
     * @param roleList,roleId
     * @return boolean
     * @throws CommonException
     */
    public Boolean getIsRolesByRoleIDAndUserRolesList(List RolesList,Integer RoleID) throws CommonException{
    	Boolean flag = false ;
    	for(int i=0;i<RolesList.size();i++){
    		TlrRoleRel tlrRoleRel = (TlrRoleRel)RolesList.get(i);
    		if(tlrRoleRel.getRoleId().equals(RoleID)){
    			flag = true;
    		}
    	}
    	return flag;
    }

//    /**
//     * 设置岗位类型
//     * @param roleType
//     * @return
//     * @throws CommonException
//     */

//	public List setTaskRoleType( String roleType4Task )throws CommonException {
//		for (int i = 0; i < globalInfo.getUserRoles().size(); i++) {
//			int roleId =  Integer.parseInt(globalInfo.getUserRoles().get(i).toString());
//			String roleType = TellerService.getInstance().getRoleType(roleId);
//    	 	if(roleType.equals(roleType4Task)){
//    	 		globalInfo.setRoleType(roleType);
//    	 		globalInfo.setWorkflowRoleId(String.valueOf(roleId));
//    	 }
//    }
//}

//    /**
//     * 随机取得一个电子柜员.
//     * @return
//     * @throws CommonException
//     */
//    public PlTlrctl randomPlTlrctl() throws CommonException {
//        PlTlrctlDAO plTlrctlDAO = DAOUtils.getPlTlrctlDAO();
//        List list = plTlrctlDAO
//                .queryByCondition(" po.status = '1' order by msrno");
//        if (null == list || list.isEmpty()) {
//            ExceptionUtil.throwCommonException("没有找到电子柜员.",
//                    ErrorCode.ERROR_CODE_PL_TLRCTL_SELECT);
//        }
//        PlTlrctl plTlrctl = (PlTlrctl) list.get(0);
//        plTlrctl.setMsrno(plTlrctl.getMsrno() + 1);
//        plTlrctlDAO.update(plTlrctl);
//
//        return plTlrctl;
//    }

//    /**
//     * 根据机构号获得一个电子柜员.
//     * @return
//     * @throws CommonException
//     */
//    public PlTlrctl getPlTlrctlByBrcode(String brcode) throws CommonException {
//        PlTlrctlDAO plTlrctlDAO = DAOUtils.getPlTlrctlDAO();
//        List list = plTlrctlDAO.queryByCondition(
//                " po.status = '1' and po.brcode = ? order by msrno",
//                new String[] { brcode }, new Type[] { Hibernate.STRING });
//        if (null == list || list.isEmpty()) {
//            ExceptionUtil.throwCommonException("没有找到" + brcode + "机构的电子柜员.",
//                    ErrorCode.ERROR_CODE_PL_TLRCTL_SELECT);
//        }
//
//        PlTlrctl plTlrctl = (PlTlrctl) list.get(0);
//        plTlrctl.setMsrno(plTlrctl.getMsrno() + 1);
//        plTlrctlDAO.update(plTlrctl);
//
//        return plTlrctl;
//    }

}