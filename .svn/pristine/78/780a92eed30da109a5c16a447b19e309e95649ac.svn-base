package com.huateng.ebank.business.management.service;

import java.util.ArrayList;
import java.util.List;

import com.huateng.ebank.business.common.DAOUtils;
import com.huateng.ebank.business.common.ErrorCode;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.SystemConstant;
import com.huateng.ebank.entity.dao.mng.BctlDAO;
import com.huateng.ebank.entity.dao.mng.RoleInfoDAO;
import com.huateng.ebank.entity.dao.mng.TlrInfoDAO;
import com.huateng.ebank.entity.dao.mng.TlrRoleRelDAO;
import com.huateng.ebank.entity.data.mng.RoleInfo;
import com.huateng.ebank.entity.data.mng.TlrInfo;
import com.huateng.ebank.entity.data.mng.TlrRoleRel;
import com.huateng.ebank.entity.view.TlrRoleRelationView;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ApplicationContextUtils;
import com.huateng.ebank.framework.util.DataFormat;
import com.huateng.ebank.framework.util.DateUtil;
import com.huateng.ebank.framework.util.ExceptionUtil;

/**
 * Title: com.huateng.ebank.business.management.service.TlrInfoExService.java
 * Description: TODO Copyright (c) 2006 Company: Shanghai Huateng Software
 * Systems Co., Ltd.
 *
 * @author hyurain_yang
 * @version v1.0,2008-7-15
 */
public class TlrInfoExService {
	protected TlrInfoExService() {
	}

	/**
	 * get instance.
	 *
	 * @return
	 */
	public synchronized static TlrInfoExService getInstance() {
		return (TlrInfoExService) ApplicationContextUtils.getBean(TlrInfoExService.class.getName());
	}

	/**
	 * 查询操作员信息
	 *
	 * @param brcode
	 * @param tlrno
	 * @return
	 * @throws CommonException
	 */
	public List selectTlrInfo(String brcode, String tlrno) throws CommonException {
		if (DataFormat.isEmpty(brcode) && DataFormat.isEmpty(tlrno)) {
			ExceptionUtil.throwCommonException("机构号与操作员号必输其一", ErrorCode.ERROR_CODE_CANNOT_SUBMIT);
		}
		List tlrInfoList = new ArrayList();
		if (!DataFormat.isEmpty(brcode)) {
			BctlDAO bctlDao = DAOUtils.getBctlDAO();
			try {
				bctlDao.query(brcode);
			} catch (Exception e) {
				ExceptionUtil.throwCommonException("输入机构号不存在", ErrorCode.ERROR_CODE_CANNOT_SUBMIT);
			}
		}

		TlrInfoDAO dao = DAOUtils.getTlrInfoDAO();
		// 输入了机构号，没有输入操作员号
		if (!DataFormat.isEmpty(brcode) && DataFormat.isEmpty(tlrno)) {
			// 机构号不为空操作员为空返回该机构下的操作员列表
			tlrInfoList = dao.queryByCondition("po.brcode = '" + brcode + "'");
			// 输入了操作员号 ，没有输入机构号
		} else if (DataFormat.isEmpty(brcode) && !DataFormat.isEmpty(tlrno)) {
			TlrInfo tlrInfo = dao.queryById(tlrno);
			if (tlrInfo != null) {
				tlrInfoList.add(tlrInfo);
			}
			// 都输入了
		} else {
			tlrInfoList = dao.queryByCondition("po.brcode = '" + brcode + "'and po.tlrno ='" + tlrno + "'");

		}
		return tlrInfoList;
	}


	/**
	 * 查询操作员信息
	 *
	 * @param brcode
	 * @param tlrno
	 * @param departmentCode
	 * @return
	 * @throws CommonException
	 */
	public List selectTlrInfo(String brcode, String tlrno, String departmentCode) throws CommonException {
		if (DataFormat.isEmpty(brcode) && DataFormat.isEmpty(tlrno) && DataFormat.isEmpty(departmentCode)) {
			ExceptionUtil.throwCommonException("机构号、部门号与操作员号必输其一", ErrorCode.ERROR_CODE_CANNOT_SUBMIT);
		}
		List tlrInfoList = new ArrayList();
		if (!DataFormat.isEmpty(brcode)) {
			BctlDAO bctlDao = DAOUtils.getBctlDAO();
			try {
				bctlDao.query(brcode);
			} catch (Exception e) {
				ExceptionUtil.throwCommonException("输入机构号不存在", ErrorCode.ERROR_CODE_CANNOT_SUBMIT);
			}
		}

		TlrInfoDAO dao = DAOUtils.getTlrInfoDAO();
		StringBuffer hql = new StringBuffer();
		hql.append("po.brcode = '" + brcode + "'");
		if(!DataFormat.isEmpty(tlrno)){
			hql.append(" and po.tlrno ='" + tlrno + "'");
		}
		tlrInfoList = dao.queryByCondition(hql.toString());
		/*// 输入了机构号，没有输入操作员号
		if (!DataFormat.isEmpty(brcode) && DataFormat.isEmpty(tlrno)) {
			if(DataFormat.isEmpty(departmentCode)){//部门号为空
				// 机构号不为空操作员为空返回该机构下的操作员列表
				tlrInfoList = dao.queryByCondition("po.brcode = '" + brcode + "'");
				// 输入了操作员号 ，没有输入机构号
			}
			else{//部门不为空
				// 机构号不为空操作员为空返回该机构下的操作员列表
				tlrInfoList = dao.queryByCondition("po.brcode = '" + brcode + "' and po.departmentCode = "+departmentCode);
				// 输入了操作员号 ，没有输入机构号
			}
		} else if (DataFormat.isEmpty(brcode) && !DataFormat.isEmpty(tlrno)) {
			TlrInfo tlrInfo = dao.queryById(tlrno);
			if (tlrInfo != null) {
				tlrInfoList.add(tlrInfo);
			}
			// 都输入了
		} else {
			if(DataFormat.isEmpty(departmentCode)){//部门号为空
			tlrInfoList = dao.queryByCondition("po.brcode = '" + brcode + "' and po.departmentCode = "+departmentCode +" and po.tlrno ='" + tlrno + "'");

		}*/
		return tlrInfoList;
	}


	/**
	 * 查询所有岗位信息
	 *
	 * @return
	 * @throws CommonException
	 */
//	public List selectAllRoles() throws CommonException {
//		RoleInfoDAO roleDAO = DAOUtils.getRoleInfoDAO();
//		List allRoleList = roleDAO.queryByCondition("1=1");
//		return allRoleList;
//	}

	/**
	 * 查询有效岗位信息
	 *
	 * @return
	 * @throws CommonException
	 */
	public List selectRolesWithoutNullification() throws CommonException {
		RoleInfoDAO roleDAO = DAOUtils.getRoleInfoDAO();
		List allRoleList = roleDAO.queryByCondition("po.status='1'");
		return allRoleList;
	}

	public List selectRolesByTlr(String tlrno) throws CommonException {
		TlrRoleRelDAO relationDAO = (TlrRoleRelDAO) ApplicationContextUtils.getBean("TlrRoleRelDAO");
		RoleInfoDAO roleDAO = DAOUtils.getRoleInfoDAO();
		List roleList = new ArrayList();

		List tlrRoleList = new ArrayList();
		tlrRoleList = relationDAO.queryByCondition("po.tlrno ='" + tlrno + "'");
		if (tlrRoleList.size() == 0) {
			tlrRoleList = new ArrayList();
		}
		for (int i = 0; i < tlrRoleList.size(); i++) {
			TlrRoleRel tlrRoleRelation = (TlrRoleRel) tlrRoleList.get(i);
			RoleInfo roleInfo = roleDAO.query(tlrRoleRelation.getRoleId().intValue());
			roleList.add(roleInfo);
		}
		return roleList;
	}

//	public List selectTlrRolesInfo(String brcode, String tlrno) throws CommonException {
//		List tlrInfoList = new ArrayList();
//		TlrInfoDAO dao = DAOUtils.getTlrInfoDAO();
//		tlrInfoList = dao.queryByCondition("po.brcode = '" + brcode + "'and po.tlrno ='" + tlrno + "'");
//		if (tlrInfoList.size() == 0) {
//			TlrInfo tlrInfo = new TlrInfo();
//			tlrInfo = new TlrInfo();
//			tlrInfo.setBrcode(brcode);
//			tlrInfo.setTlrno(tlrno);
////			tlrInfo.setCreatDate(GlobalInfo.getCurrentInstance().getTxdate());
//			tlrInfo.setFlag(SystemConstant.FLAG_ON);
//			tlrInfo.setStatus(SystemConstant.TLR_NO_STATE_LOGOUT);
//			tlrInfoList.add(tlrInfo);
//		}
//		return tlrInfoList;
//	}

//	public List selectTlrRolesInfo2(String brcode, String tlrno) throws CommonException {
//		List tlrInfoList = new ArrayList();
//		TlrInfoDAO dao = DAOUtils.getTlrInfoDAO();
//		tlrInfoList = dao.queryByCondition("po.brcode = '" + brcode + "'and po.tlrno ='" + tlrno + "'");
//		if (tlrInfoList.size() == 0) {
//			TlrInfo tlrInfo = new TlrInfo();
//			tlrInfo = new TlrInfo();
//			tlrInfo.setBrcode(brcode);
//			tlrInfo.setTlrno(tlrno);
////			tlrInfo.setCreatDate(GlobalInfo.getCurrentInstance().getTxdate());
//			tlrInfo.setFlag(SystemConstant.FLAG_ON);
//			tlrInfo.setStatus(SystemConstant.TLR_NO_STATE_LOGOUT);
//			tlrInfo.setPassword("123456");
//			tlrInfoList.add(tlrInfo);
//		}
//		return tlrInfoList;
//	}

	/**
	 * 操作员增加查询
	 *
	 * @param brcode
	 * @param insertTlrno
	 * @return
	 * @throws CommonException
	 */
	public List selectTlrInfoAdd(String brcode, String insertTlrno) throws CommonException {
		if (DataFormat.isEmpty(brcode) || DataFormat.isEmpty(insertTlrno)) {
			ExceptionUtil.throwCommonException("机构号与操作员号必须输入", ErrorCode.ERROR_CODE_CANNOT_SUBMIT);
		}

		if (!DataFormat.isEmpty(brcode)) {
			BctlDAO bctlDao = DAOUtils.getBctlDAO();
			try {
				bctlDao.query(brcode);
			} catch (Exception e) {
				ExceptionUtil.throwCommonException("输入机构号不存在", ErrorCode.ERROR_CODE_CANNOT_SUBMIT);
			}
			/*
			 * modify by shen_antonio 20080916
			 * GlobalInfo globalInfo = GlobalInfo.getCurrentInstance();
			 * String bctlList = BctlService.getInstance().getAllBlnBrcodeStr( globalInfo.getBrcode());
			 * if (bctlList.indexOf(brcode) < 0) {
			 * ExceptionUtil.throwCommonException("输入机构号不为本机构或者下属机构",ErrorCode.ERROR_CODE_CANNOT_SUBMIT);
			 * }
			 */
		}

		TlrInfoDAO dao = DAOUtils.getTlrInfoDAO();
		List tlrInfoList = dao.queryByCondition("po.tlrno='" + insertTlrno + "'");
		if (tlrInfoList.size() != 0) {
			ExceptionUtil.throwCommonException("该操作员已经存在，不能新增", ErrorCode.ERROR_CODE_CANNOT_SUBMIT);
		} else {
			TlrInfo tlrInfo = new TlrInfo();
			tlrInfo.setBrcode(brcode);
			tlrInfo.setTlrno(insertTlrno);
			tlrInfoList.add(tlrInfo);
		}
		return tlrInfoList;
	}


	/**
	 * 操作员增加查询
	 *
	 * @param brcode
	 * @param insertTlrno
	 * @param departmentCode
	 * @return
	 * @throws CommonException
	 */
	public List selectTlrInfoAdd(String brcode, String insertTlrno,String departmentCode) throws CommonException {
		if (DataFormat.isEmpty(brcode) || DataFormat.isEmpty(insertTlrno) || DataFormat.isEmpty(departmentCode)) {
			ExceptionUtil.throwCommonException("机构号、部门号与操作员号必须输入", ErrorCode.ERROR_CODE_CANNOT_SUBMIT);
		}

		if (!DataFormat.isEmpty(brcode)) {
			BctlDAO bctlDao = DAOUtils.getBctlDAO();
			try {
				bctlDao.query(brcode);
			} catch (Exception e) {
				ExceptionUtil.throwCommonException("输入机构号不存在", ErrorCode.ERROR_CODE_CANNOT_SUBMIT);
			}
		}
//		if (!DataFormat.isEmpty(departmentCode)) {
//			DepartmentInfoDAO departmentInfoDAO = DAOUtils.DepartmentInfoDAO();
//			try {
//				departmentInfoDAO.query(departmentCode);
//			} catch (Exception e) {
//				ExceptionUtil.throwCommonException("输入部门号不存在", ErrorCode.ERROR_CODE_CANNOT_SUBMIT);
//			}
//		}

		TlrInfoDAO dao = DAOUtils.getTlrInfoDAO();
		List tlrInfoList = dao.queryByCondition("po.tlrno='" + insertTlrno + "'");
		if (tlrInfoList.size() != 0) {
			ExceptionUtil.throwCommonException("该操作员已经存在，不能新增", ErrorCode.ERROR_CODE_CANNOT_SUBMIT);
		} else {
			TlrInfo tlrInfo = new TlrInfo();
			tlrInfo.setBrcode(brcode);
			tlrInfo.setTlrno(insertTlrno);
//			tlrInfo.setDepartmentCode(Long.valueOf(departmentCode));
			tlrInfoList.add(tlrInfo);
		}
		return tlrInfoList;
	}

	/**
	 * 新增操作员
	 *
	 * @param insertRoleList
	 * @param tlrInfo
	 * @return
	 * @throws CommonException
	 */
	public void insertTlrInfo(List insertRoleList, TlrInfo tlrInfo) throws CommonException {
		GlobalInfo gi = GlobalInfo.getCurrentInstance();
		String ownerBrcode = gi.getBrcode();
		boolean flag = false;
//		for (int i = 0; i < insertRoleList.size(); i++) {
//			if (StringUtils.equals(gi.getBrClass(), SystemConstant.BRCODE_CLASS_HEAD))
//				break;
//			TlrRoleRelationView trv = (TlrRoleRelationView) insertRoleList.get(i);
//			if (StringUtils.equals(ownerBrcode, tlrInfo.getBrcode()) && StringUtils.equals(trv.getRoleId(), "111")) {
//				flag = true;
//			} else if (StringUtils.equals(ownerBrcode, tlrInfo.getBrcode()) && StringUtils.equals(trv.getRoleId(), "201")) {
//				flag = true;
//			}
//		}
//		if (flag) {
//			ExceptionUtil.throwCommonException("系统管理员岗位、征信岗位只有上级机构系统管理员才能新增", "权限错误");
//		}
		TlrInfoDAO dao = DAOUtils.getTlrInfoDAO();
//		if (!this.curDateJudge(tlrInfo.getEffectDate()))
//			ExceptionUtil.throwCommonException("生效日期必须在会计日期之前", "日期错误");
//		if (!this.dateJudge(tlrInfo.getEffectDate(), tlrInfo.getExpireDate()))
//			ExceptionUtil.throwCommonException("失效日期必须在生效日期之后", "日期错误");
		tlrInfo.setMsrno(0);//机构流水号为0
		dao.insert(tlrInfo);
		TlrRoleRelDAO tlrRoleDAO = DAOUtils.getTlrRoleRelDAO();
		for (int i = 0; i < insertRoleList.size(); i++) {
			TlrRoleRelationView tlrRoleView = (TlrRoleRelationView) insertRoleList.get(i);
			TlrRoleRel tlrRole = new TlrRoleRel();
			tlrRole.setRoleId(new Integer(tlrRoleView.getRoleId()));
			tlrRole.setTlrno(tlrRoleView.getTlrno());
			tlrRoleDAO.insert(tlrRole);
		}
	}

	/**
	 * 修改操作员信息
	 *
	 * @param insertRoleList
	 * @param deleteRoleList
	 * @param tlrInfo
	 * @return
	 * @throws CommonException
	 */
	public List updateTlrInfo(List insertRoleList, List deleteRoleList, TlrInfo tlrInfo) throws CommonException {
		TlrInfoDAO dao = DAOUtils.getTlrInfoDAO();
		GlobalInfo gi = GlobalInfo.getCurrentInstance();
		TlrInfo ti = dao.queryById(tlrInfo.getTlrno());
		ti.setTlrName(tlrInfo.getTlrName());
//		ti.setEffectDate(tlrInfo.getEffectDate());
//		ti.setExpireDate(tlrInfo.getExpireDate());
		ti.setRoleid(tlrInfo.getRoleid());
		ti.setLoginIp(tlrInfo.getLoginIp());
//		if (!this.curDateJudge(tlrInfo.getEffectDate()))
//			ExceptionUtil.throwCommonException("生效日期必须在会计日期之后", "日期错误");
//		if (!this.dateJudge(tlrInfo.getEffectDate(), tlrInfo.getExpireDate()))
//			ExceptionUtil.throwCommonException("失效日期必须在生效日期之后", "日期错误");
		dao.saveOrUpdate(ti);
		TlrRoleRelDAO tlrRoleDAO = DAOUtils.getTlrRoleRelDAO();
		for (int i = 0; i < insertRoleList.size(); i++) {
			TlrRoleRelationView tlrRoleView = (TlrRoleRelationView) insertRoleList.get(i);
			TlrRoleRel tlrRole = new TlrRoleRel();
			if (tlrRoleDAO.queryByCondition("po.tlrno=? and po.roleId=?",
					new Object[] { tlrRoleView.getTlrno(), new Integer(tlrRoleView.getRoleId()) }, null).size() != 0) {
				continue;
			}
			tlrRole.setRoleId(new Integer(tlrRoleView.getRoleId()));
			tlrRole.setTlrno(tlrRoleView.getTlrno());
			tlrRoleDAO.insert(tlrRole);
		}
		for (int i = 0; i < deleteRoleList.size(); i++) {
			TlrRoleRelationView tlrRoleView = (TlrRoleRelationView) deleteRoleList.get(i);
			List dellist = tlrRoleDAO.queryByCondition("po.tlrno=? and po.roleId=?",
					new Object[] { tlrRoleView.getTlrno(), new Integer(tlrRoleView.getRoleId()) }, null);
//			TlrRoleRel tlrRole = new TlrRoleRel();
//			tlrRole.setRoleId(new Integer(tlrRoleView.getRoleId()));
//			tlrRole.setTlrno(tlrRoleView.getTlrno());
			for(int j=0;j<dellist.size();j++){
				tlrRoleDAO.delete((TlrRoleRel)dellist.get(j));
			}
		}
		return new ArrayList();
	}

	/**
	 * 删除操作员
	 *
	 * @param tlrInfo
	 * @throws CommonException
	 */
	public void deleteTlr(String tlrno) throws CommonException {
		TlrInfoDAO tid = DAOUtils.getTlrInfoDAO();
		TlrInfo tlrInfo = tid.query(tlrno);
		/* modify by shen_antonio 20081010. */
		tlrInfo.setFlag(SystemConstant.FLAG_OFF);
		tid.saveOrUpdate(tlrInfo);
	}

	/**
	 * 操作员激活
	 *
	 * @param TlrInfo
	 * @throws CommonException
	 */
	public void tlrActivation(String tlrno) throws CommonException {
		TlrInfoDAO tid = DAOUtils.getTlrInfoDAO();
		TlrInfo tlrInfo = tid.query(tlrno);
		/* modify by shen_antonio 20081010. */
		tlrInfo.setFlag(SystemConstant.FLAG_ON);
		tid.saveOrUpdate(tlrInfo);
	}

	/**
	 * 判断失效日期是否大于生效日期
	 */
//	private boolean dateJudge(Date effectDate, Date ExpireDate) {
//		if (effectDate.before(ExpireDate))
//			return true;
//		return false;
//	}

	/**
	 * 判断生效日期是否大于当日
	 *
	 * @throws CommonException
	 */
//	private boolean curDateJudge(Date effectDate) throws CommonException {
//		if (!effectDate.before(GlobalInfo.getCurrentInstance().getTxdate()))
//			return true;
//		return false;
//	}

	/**
	 * 查询当前岗位信息
	 */
//	public List getTlrRoleChange() throws CommonException {
//		List tlrRoleChangeList = new ArrayList();
//		TlrRoleChangeView tcv = new TlrRoleChangeView();
//		GlobalInfo gi = GlobalInfo.getCurrentInstance();
//		TlrInfo ti = DAOUtils.getTlrInfoDAO().queryById(gi.getTlrno());
//		tcv.setTlrno(GlobalInfo.getCurrentInstance().getTlrno());
//		tcv.setRolename(DAOUtils.getRoleInfoDAO().query(ti.getCurRoleid().intValue()).getRoleName());
//		tcv.setBrname(DAOUtils.getBctlDAO().query(gi.getBrcode()).getBrname());
//		tlrRoleChangeList.add(tcv);
//		return tlrRoleChangeList;
//	}

	/**
	 * 查询兼任岗位信息
	 */
//	public List getPluRole() throws CommonException {
//		List pluRoleList = new ArrayList();
//		TlrInfo ti = DAOUtils.getTlrInfoDAO().queryById(GlobalInfo.getCurrentInstance().getTlrno());
//		List tlrRoleRelationList = DAOUtils.getTlrRoleRelDAO().queryByCondition(
//				"po.tlrno='" + GlobalInfo.getCurrentInstance().getTlrno() + "'");
//		for (int i = 0; i < tlrRoleRelationList.size(); i++) {
//			TlrRoleRel trr = (TlrRoleRel) tlrRoleRelationList.get(i);
//			RoleInfo ri = DAOUtils.getRoleInfoDAO().query(trr.getRoleId().intValue());
////			if (ri.getRoleId().compareTo(ti.getCurRoleid()) == 0) {
////				continue;
////			}
//			pluRoleList.add(ri);
//		}
//		return pluRoleList;
//	}

//	/**
//	 *
//	 * Description: 通过内部操作员号获得外部操作员号
//	 *
//	 * @param
//	 * @return String
//	 * @exception
//	 * @author hyurain_yang
//	 * @version v1.0,2008-8-18
//	 */
//	public String getExtTlrno(String tlrno) throws CommonException {
//		TlrInfoDAO tlrInfoDAO = DAOUtils.getTlrInfoDAO();
//		TlrInfo tlrInfo = tlrInfoDAO.query(tlrno);
//		return tlrInfo.getExtTlrno();
//	}

//	/**
//	 *
//	 * Description: 通过外部操作员号获得内部操作员号
//	 *
//	 * @param
//	 * @return String
//	 * @exception
//	 * @author hyurain_yang
//	 * @version v1.0,2008-8-18
//	 */
//	public String getTlrno(String extTlrno) throws CommonException {
//		TlrInfoDAO tlrInfoDAO = DAOUtils.getTlrInfoDAO();
//		List tlrInfoList = tlrInfoDAO.queryByCondition("po.extTlrno=?", new Object[] { extTlrno }, new Type[] { Hibernate.STRING });
//		String tlrno = null;
//		if (tlrInfoList.size() != 0) {
//			tlrno = ((TlrInfo) tlrInfoList.get(0)).getTlrno();
//			return tlrno;
//		} else {
//			ExceptionUtil.throwCommonException("没有该操作员");
//		}
//		return tlrno;
//	}

	/**
	 *
	 * Description: 输入内部机构号 内部操作员号 判断该操作员是否属于该机构
	 *
	 * @param
	 * @return boolean
	 * @exception
	 * @author hyurain_yang
	 * @version v1.0,2008-8-18
	 * @throws CommonException
	 */
//	public boolean judgeTlrAttach(String tlrno, String brcode) throws CommonException {
//		TlrInfoDAO tlrInfoDAO = DAOUtils.getTlrInfoDAO();
//		TlrInfo tlrInfo = tlrInfoDAO.query(tlrno);
//		if (StringUtils.equals(tlrInfo.getBrcode(), brcode)) {
//			return true;
//		} else {
//			return false;
//		}
//	}

	/**
	 *
	 * Description: 输入内部机构号 内部操作员号 判断该操作员是否属于该分行
	 *
	 * @param
	 * @return boolean
	 * @exception
	 * @author hyurain_yang
	 * modify by shen_antonio 2008-11-13
	 * 如果是总行总行操作员，只能选取总行或者所有分行的操作员信息
	 * 如果是省分行\直属分行操作员,只能选取本分行和本分行下属机构(省瞎分行\支行):管理分行为该分行
	 * 如果是省瞎分行操作员,只能选取本分行和本分行下属机构支行
	 * 如果是支行操作员,只能是本机构操作员
	 * @version v1.0,2008-10-21
	 */
//	public boolean judgeTlrAttachBranch(String extTlrno) throws CommonException {
//		GlobalInfo gi = GlobalInfo.getCurrentInstance();
//		TlrInfoDAO tlrInfoDAO = DAOUtils.getTlrInfoDAO();
//		List tlrInfoList = tlrInfoDAO.queryByCondition("po.extTlrno=?", new Object[] { extTlrno }, null);
//		TlrInfo tlrInfo = null;
//		if (tlrInfoList.size() != 0) {
//			tlrInfo = (TlrInfo) tlrInfoList.get(0);
//		} else {
//			ExceptionUtil.throwCommonException("输入的操作员不存在",ErrorCode.ERROR_CODE_CHECK_AUTH_FAIL);
//		}
//		BctlService bctlService = BctlService.getInstance();
//		Bctl tlrBctl = bctlService.getBctlByBrcode(tlrInfo.getBrcode());
//		if(gi.isHeadBrcode()){
//			if(tlrBctl.getBrclass().equals(SystemConstant.BRCODE_CLASS_BRANCH)||
//					tlrBctl.getBrclass().equals(SystemConstant.BRCODE_CLASS_HEAD)){
//				return true;
//			}else{
//				return false;
//			}
//		}else if(gi.getBrClass().equals(SystemConstant.BRCODE_CLASS_BRANCH)){
//			if(gi.getBranchClass().equals(SystemConstant.BRCODE_BRANCH_CLASS_1) ||
//					gi.getBranchClass().equals(SystemConstant.BRCODE_BRANCH_CLASS_2)){
//				if(gi.getBrcode().equals(tlrBctl.getBlnManageBrcode())){
//					return true;
//				}else{
//					return false;
//				}
//			}else{
//				if(gi.getBrcode().equals(tlrBctl.getBlnBranchBrcode())){
//					return true;
//				}else{
//					return false;
//				}
//			}
//		}else{
//			if(gi.getBrcode().equals(tlrBctl.getBrcode())){
//				return true;
//			}else{
//				return false;
//			}
//		}
//	}

	/**
	 *
	 * Description: 查询所有客户经理信息
	 *
	 * @param
	 * @return List
	 * @exception
	 * @author hyurain_yang
	 * @version v1.0,2008-8-25
	 */
//	public List getAllCustManager() throws CommonException {
//		TlrInfoDAO tlrInfoDAO = DAOUtils.getTlrInfoDAO();
//		TlrRoleRelDAO TlrRoleRelDAO = DAOUtils.getTlrRoleRelDAO();
//		List tlrInRoleList = TlrRoleRelDAO.queryByCondition("po.roleId=?", new Object[] { "101" }, new Type[] { Hibernate.STRING });
//		List custManagerList = new ArrayList();
//		for (int i = 0; i < tlrInRoleList.size(); i++) {
//			TlrRoleRel trr = (TlrRoleRel) tlrInRoleList.get(i);
//			TlrInfo tlrInfo = tlrInfoDAO.query(trr.getTlrno());
//			custManagerList.add(tlrInfo);
//		}
//		return custManagerList;
//	}

	/**
	 *
	 * Description: 模糊查询客户经理信息
	 *
	 * @param
	 * @return List
	 * @exception
	 * @author hyurain_yang
	 * @version v1.0,2008-8-25
	 */
//	public List getCustManagerListByValue(String value) throws CommonException {
//		TlrInfoDAO tlrInfoDAO = DAOUtils.getTlrInfoDAO();
//		TlrRoleRelDAO TlrRoleRelDAO = DAOUtils.getTlrRoleRelDAO();
//		List tlrInRoleList = TlrRoleRelDAO.queryByCondition("po.roleId=?", new Object[] { "101" }, new Type[] { Hibernate.STRING });
//		List custManagerList = new ArrayList();
//		for (int i = 0; i < tlrInRoleList.size(); i++) {
//			TlrRoleRel trr = (TlrRoleRel) tlrInRoleList.get(i);
//			TlrInfo tlrInfo = (TlrInfo) tlrInfoDAO.queryByCondition("po.tlrno=? AND po.extTlrno LIKE ?", new Object[] { trr.getTlrno(),
//					value }, new Type[] { Hibernate.STRING, Hibernate.STRING });
//			custManagerList.add(tlrInfo);
//		}
//		return custManagerList;
//	}

	/**
	 *
	 * Description: 获取省分行下所属所有管辖分行下的客户经理
	 *
	 * @param
	 * @return List
	 * @exception
	 * @author hyurain_yang
	 * @version v1.0,2008-10-11
	 */
//	public List getProbranchCustManager(String brcode, String value) throws CommonException {
//		List custManagerList = new ArrayList();
//		BctlService bctlService = BctlService.getInstance();
//		List bctlList = bctlService.getRptBeMngBctlList(brcode);// 获取省分行下属分行列表
//		List subBranchList = new ArrayList();
//		for (int i = 0; i < bctlList.size(); i++) {
//			List subList = bctlService.getAllDownBrcodeList(((Bctl) bctlList.get(i)).getBrcode());
//			subBranchList.addAll(subList);// 获取分行下属支行列表(包含自己)
//		}
//		boolean flag;
//		TlrInfoDAO tlrInfoDAO = DAOUtils.getTlrInfoDAO();
//		TlrRoleRelDAO TlrRoleRelDAO = DAOUtils.getTlrRoleRelDAO();
//		for (int i = 0; i < subBranchList.size(); i++) {
//			if (StringUtils.isEmpty(value)) {
//				Bctl bctl = (Bctl) subBranchList.get(i);
//				List tlrInfoList = tlrInfoDAO.queryByCondition("po.brcode = ? order by po.extTlrno", new Object[] { bctl.getBrcode() },
//						null);
//				for (int j = 0; j < tlrInfoList.size(); j++) {
//					TlrInfo tlrInfo = (TlrInfo) tlrInfoList.get(j);
//					List tlrRoleRelationList = TlrRoleRelDAO.queryByCondition("po.tlrno=?", new Object[] { DataFormat.trim(tlrInfo
//							.getTlrno()) }, null);
//					TlrRoleRelation tlrRoleRelation = null;
//					if (tlrRoleRelationList.size() != 0) {
//						tlrRoleRelation = (TlrRoleRelation) tlrRoleRelationList.get(0);
//					} else {
//						continue;
//					}
//					if (StringUtils.equals(tlrRoleRelation.getRoleId().toString(), "101")) {
//						flag = true;
//					} else {
//						flag = false;
//					}
//					if (flag) {
//						custManagerList.add(tlrInfo);
//					}
//				}
//			} else {
//				Bctl bctl = (Bctl) subBranchList.get(i);
//				List tlrInfoList = tlrInfoDAO.queryByCondition("po.brcode = ? and po.extTlrno like ? order by po.extTlrno", new Object[] {
//						bctl.getBrcode(), value }, null);
//				for (int j = 0; j < tlrInfoList.size(); j++) {
//					TlrInfo tlrInfo = (TlrInfo) tlrInfoList.get(j);
//					List tlrRoleRelationList = TlrRoleRelDAO.queryByCondition("po.tlrno=?", new Object[] { DataFormat.trim(tlrInfo
//							.getTlrno()) }, null);
//					TlrRoleRelation tlrRoleRelation = null;
//					if (tlrRoleRelationList.size() != 0) {
//						tlrRoleRelation = (TlrRoleRelation) tlrRoleRelationList.get(0);
//					} else {
//						continue;
//					}
//					if (StringUtils.equals(tlrRoleRelation.getRoleId().toString(), "101")) {
//						flag = true;
//					} else {
//						flag = false;
//					}
//					if (flag) {
//						custManagerList.add(tlrInfo);
//					}
//				}
//			}
//		}
//		return custManagerList;
//	}

	/**
	 *
	 * Description: 查询客户经理
	 *
	 * @param String
	 *            where
	 * @param Object[]
	 *            b
	 * @return List
	 * @exception CommonException
	 * @author hyurain_yang
	 * @version v1.0,2008-10-11
	 * @throws CommonException
	 */
//	public List getBranchCustManager(String where, Object[] b) throws CommonException {
//		List custManagerList = new ArrayList();
//		TlrInfoDAO tlrInfoDAO = DAOUtils.getTlrInfoDAO();
//		TlrRoleRelDAO TlrRoleRelDAO = DAOUtils.getTlrRoleRelDAO();
//		List tlrInfoList = tlrInfoDAO.queryByCondition(where, b, null);
//		for (int i = 0; i < tlrInfoList.size(); i++) {
//			boolean flag = false;
//			TlrInfo tlrInfo = (TlrInfo) tlrInfoList.get(i);
//			List tlrRoleRelationList = TlrRoleRelDAO.queryByCondition("po.tlrno=?", new Object[] { tlrInfo.getTlrno() }, null);
//			TlrRoleRelation tlrRoleRelation = null;
//			for (int j = 0; j < tlrRoleRelationList.size(); j++) {
//				tlrRoleRelation = (TlrRoleRelation) tlrRoleRelationList.get(j);
//				if (StringUtils.equals(tlrRoleRelation.getRoleId().toString(), "101")) {
//					flag = true;
//					continue;
//				} else {
//					flag = false;
//				}
//			}
//			if (flag) {
//				custManagerList.add(tlrInfo);
//			}
//		}
//		return custManagerList;
//	}

	/**
	 *
	 * Description: 输入支行号获得支行客户经理
	 *
	 * @param brcode
	 * @return List
	 * @exception
	 * @author hyurain_yang
	 * @version v1.0,2008-10-16
	 * @throws CommonException
	 */
//	public List getSubBranchCustManager(String brcode, String value) throws CommonException {
//		TlrInfoDAO tlrInfoDAO = DAOUtils.getTlrInfoDAO();
//		TlrRoleRelDAO TlrRoleRelDAO = DAOUtils.getTlrRoleRelDAO();
//		List custManagerList = new ArrayList();
//		if (StringUtils.isBlank(value)) {
//			List tlrInfoList = tlrInfoDAO.queryByCondition("po.brcode=? order by po.extTlrno", new Object[] { brcode }, null);
//			for (int i = 0; i < tlrInfoList.size(); i++) {
//				boolean flag = false;
//				TlrInfo tlrInfo = (TlrInfo) tlrInfoList.get(i);
//				List tlrRoleRelationList = TlrRoleRelDAO.queryByCondition("po.tlrno=?", new Object[] { tlrInfo.getTlrno() }, null);
//				TlrRoleRel tlrRoleRelation = null;
//				for (int j = 0; j < tlrRoleRelationList.size(); j++) {
//					tlrRoleRelation = (TlrRoleRel) tlrRoleRelationList.get(j);
//					if (StringUtils.equals(tlrRoleRelation.getRoleId().toString(), "101")) {
//						flag = true;
//						continue;
//					} else {
//						flag = false;
//					}
//				}
//				if (flag) {
//					custManagerList.add(tlrInfo);
//				}
//			}
//			return custManagerList;
//		} else {
//			List tlrInfoList = tlrInfoDAO.queryByCondition("po.brcode=? and po.extTlrno like ? order by po.extTlrno",
//					new Object[] { brcode }, null);
//			for (int i = 0; i < tlrInfoList.size(); i++) {
//				boolean flag = false;
//				TlrInfo tlrInfo = (TlrInfo) tlrInfoList.get(i);
//				List tlrRoleRelationList = TlrRoleRelDAO.queryByCondition("po.tlrno=?", new Object[] { tlrInfo.getTlrno(), value },
//						null);
//				TlrRoleRel tlrRoleRelation = null;
//				for (int j = 0; j < tlrRoleRelationList.size(); j++) {
//					tlrRoleRelation = (TlrRoleRel) tlrRoleRelationList.get(j);
//					if (StringUtils.equals(tlrRoleRelation.getRoleId().toString(), "101")) {
//						flag = true;
//						continue;
//					} else {
//						flag = false;
//					}
//				}
//				if (flag) {
//					custManagerList.add(tlrInfo);
//				}
//			}
//			return custManagerList;
//		}
//	}

	/**
	 *
	 * Description: 通过内部操作员号，获取操作员对象
	 *
	 * @param
	 * @return TlrInfo
	 * @exception
	 * @author hyurain_yang
	 * @version v1.0,2008-9-2
	 */
	public TlrInfo getTlrInfoByTlrno(String tlrno) throws CommonException {
		TlrInfoDAO dao = DAOUtils.getTlrInfoDAO();
		TlrInfo tlrInfo = dao.query(tlrno);
		return tlrInfo;
	}

	/**
	 * Description: 判断操作员是否已经登录,判断操作员登录的Session Id是否一致
	 *
	 * @param tlrno
	 *            内部操作员号 sessionId 会话ID号
	 * @return boolean
	 * @exception
	 * @author shen_antonio
	 * @version v1.0,2008-10-7
	 */
//	public boolean isLogin(String tlrno, String sessionId) throws CommonException {
//		TlrInfo tlrInfo = getTlrInfoByTlrno(tlrno);
//		if (tlrInfo.getStatus().equals(SystemConstant.TLR_NO_STATE_LOGIN) && tlrInfo.getSessionId().equals(sessionId)) {
//			return true;
//		}
//		return false;
//	}

}
