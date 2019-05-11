package com.huateng.ebank.business.management.operation;

import java.util.ArrayList;
import java.util.List;

import com.huateng.ebank.business.common.DAOUtils;
import com.huateng.ebank.business.common.service.BctlService;
import com.huateng.ebank.business.management.bean.TlrView;
import com.huateng.ebank.business.management.service.RoleInfoService;
import com.huateng.ebank.business.management.service.TlrInfoExService;
import com.huateng.ebank.entity.data.mng.Bctl;
import com.huateng.ebank.entity.data.mng.TlrInfo;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;

/**
 * Title:
 * com.huateng.ebank.business.management.operation.TlrInfoExOperation.java
 * Description: TODO Copyright (c) 2006 Company: Shanghai Huateng Software
 * Systems Co., Ltd.
 *
 * @author hyurain_yang
 * @version v1.0,2008-7-15
 */
public class TlrInfoExOperation extends BaseOperation {
	public static final String ID = "Management.TlrInfoExOperation";
	public static final String CMD = "CMD";
	public static final String OUT_TLR_INFO_LIST = "OUT_TLR_INFO_LIST";
	public static final String ALL_ROLE_LIST = "ALL_ROLE_LIST";
	public static final String TLR_ROLE_LIST = "TLR_ROLE_LIST";
	public static final String OUT_TLR_JUDGE_LIST = "OUT_TLR_JUDGE_LIST";
	public static final String OUT_TLR_ROLE_CHANGE_LIST = "OUT_TLR_ROLE_CHANGE_LIST";
	public static final String OUT_TLR_PLURALISM_ROLE_LIST = "OUT_TLR_PLURALISM_ROLE_LIST";
	public static final String CMD_DROP_DOWN_CUSTMANAGER_BRNO = "CMD_DROP_DOWN_CUSTMANAGER";
	public static final String CMD_DROP_DOWN_CUSTMANAGER_BRCODE = "CMD_DROP_DOWN_CUSTMANAGER_BRCODE";
	public static final String OUT_CUSTMANAGER_LIST_BRNO = "OUT_CUSTMANAGER_LIST_BRNO";
	public static final String OUT_CUSTMANAGER_LIST_BRCODE = "OUT_CUSTMANAGER_LIST_BRCODE";

	public void afterProc(OperationContext context) throws CommonException {

	}

	public void beforeProc(OperationContext context) throws CommonException {

	}

	public void execute(OperationContext context) throws CommonException {
		TlrInfoExService ties = TlrInfoExService.getInstance();// 获取操作员服务
		BctlService bctlService = BctlService.getInstance();
		String brcode = (String) context.getAttribute("brcode");// 获取操作员内部机构号
		String tlrno = (String) context.getAttribute("tlrno");// 获取内部操作员号
		String extTlrno = (String) context.getAttribute("extTlrno");// 获取外部操作员号(操作员增加时使用)
		String departmentCode = (String) context.getAttribute("departmentCode");// 获取部门编号
		String cmd = (String) context.getAttribute(TlrInfoExOperation.CMD);
		// 操作员信息查询操作
		if (cmd.equals("SELECT_TLR_INFO")) {
			List tlrInfoList = ties.selectTlrInfo(brcode, tlrno, departmentCode);// 获取查询操作员列表
			List tlrViewList = new ArrayList();
			for (int i = 0; i < tlrInfoList.size(); i++) {
				TlrView tlrView = new TlrView();
				TlrInfo tlrInfo = (TlrInfo) tlrInfoList.get(i);
				Bctl bctl = bctlService.getBctlByBrcode(tlrInfo.getBrcode());
				/* 将信息插入tlrView */
				// 插入操作员内部机构号
				tlrView.setBrcode(tlrInfo.getBrcode());
				// 插入操作员对应外部机构号
				tlrView.setBrno(bctl.getBrno());
				tlrView.setBrname(bctl.getBrname());
				tlrView.setTlrno(String.valueOf(tlrInfo.getTlrno()));
//				tlrView.setExtTlrno(tlrInfo.getExtTlrno());
				tlrView.setTlrName(tlrInfo.getTlrName());
				tlrView.setFlag(tlrInfo.getFlag());
				tlrView.setPasswd(tlrInfo.getPassword());
				tlrView.setDefRoleid(DAOUtils.getRoleInfoDAO().query(tlrInfo.getRoleid().intValue()).getRoleName());
				tlrView.setStatus(tlrInfo.getStatus());
				tlrView.setCreatDate(tlrInfo.getCreateDate());
//				tlrView.setEffectDate(tlrInfo.getEffectDate());
//				tlrView.setExpireDate(tlrInfo.getExpireDate());
				tlrView.setLatelyLoginTime(tlrInfo.getLastaccesstm());
				tlrView.setLatelyLogoutTime(tlrInfo.getLastlogouttm());
				tlrView.setLoginIp(tlrInfo.getLoginIp());
//				tlrView.setDepartmentCode(tlrInfo.getDepartmentCode());
//				tlrView.setDepartmentName(DAOUtils.getDepartmentInfoDAO().query(tlrInfo.getDepartmentCode()).getDepartmentName());

				// 将tlrView插入List返回给TlrInfoExGetter
				tlrViewList.add(tlrView);
			}
			context.setAttribute(TlrInfoExOperation.OUT_TLR_INFO_LIST, tlrViewList);
		}
		// 操作员对应操作员岗位操作
		else if (cmd.equals("SELECT_TLR_ROLES")) {
			context.setAttribute(TlrInfoExOperation.TLR_ROLE_LIST, ties.selectRolesByTlr(tlrno));
			context.setAttribute(TlrInfoExOperation.ALL_ROLE_LIST, ties.selectRolesWithoutNullification());
		}
		// 操作员更新操作
		else if (cmd.equals("UPDATE_TLR_INFO")) {
			context.setAttribute("resultList", ties.updateTlrInfo((List) context.getAttribute("insertRoleList"), (List) context
					.getAttribute("deleteRoleList"), (TlrInfo) context.getAttribute("tlrInfo")));
		}
		// 删除操作员操作
		else if (cmd.equals("DELETE_TLR")) {
			ties.deleteTlr((String) context.getAttribute("tlrno"));
		}
		// 激活操作员操作
		else if (cmd.equals("TLR_ACTIVATION")) {
			ties.tlrActivation((String) context.getAttribute("tlrno"));
		}
		// 增加操作员时判断操作员机构,操作员号是否存在操作
		else if (cmd.equals("SELECT_TLR_ADD")) {
			List tlrAddInfoList = ties.selectTlrInfoAdd(brcode, extTlrno, departmentCode);
			TlrInfo tlrInfo = (TlrInfo) tlrAddInfoList.get(0);
			TlrView tiv = new TlrView();
			tiv.setBrcode(tlrInfo.getBrcode());
			tiv.setBrno(DAOUtils.getBctlDAO().query(tlrInfo.getBrcode()).getBrno());
			tiv.setTlrno(tlrInfo.getTlrno());
			tiv.setStatus("1");
			tiv.setDepartmentCode(Long.valueOf(departmentCode));
			//tiv.setDepartmentName(DAOUtils.getDepartmentInfoDAO().query(departmentCode).getDepartmentName());
			tlrAddInfoList.clear();
			tlrAddInfoList.add(tiv);
			context.setAttribute(TlrInfoExOperation.OUT_TLR_JUDGE_LIST, tlrAddInfoList);
		}
		// 在操作员增加页面中显示所有岗位信息
		else if (cmd.equals("SELECT_All_ROLES")) {
			context.setAttribute(TlrInfoExOperation.ALL_ROLE_LIST, RoleInfoService.getInstance().selectAllRoleInfoService());
		}
		// 操作员新增操作
		else if (cmd.equals("INSERT_TLR_INFO")) {
			ties.insertTlrInfo((List) context.getAttribute("insertRoleList"), (TlrInfo) context.getAttribute("tlrInfo"));
		}
		// 操作员岗位切换获得操作员信息操作
//		else if (cmd.equals("TLR_ROLE_CHANGE")) {
////			context.setAttribute(TlrInfoExOperation.OUT_TLR_ROLE_CHANGE_LIST, ties.getTlrRoleChange());
			// 操作员岗位切换获得操作员兼任岗位操作
//		} else if (cmd.equals("TLR_PLURALISM_ROLE")) {
//			context.setAttribute(TlrInfoExOperation.OUT_TLR_PLURALISM_ROLE_LIST, ties.getPluRole());
//		}
		// 报表客户经理下拉列表查询，通过外部机构号(查询省分行下属分行所有客户经理)
//		else if (StringUtils.equals(cmd, CMD_DROP_DOWN_CUSTMANAGER_BRNO)) {
//			String value = (String) context.getAttribute("value");
//			String branchBrno = context.getAttribute("branchBrno").toString();
//			String brno = context.getAttribute("brno").toString();
//			if (StringUtils.isEmpty(value)) {
//				if (StringUtils.isEmpty(brno)) {
//					brcode = bctlService.getBctlByBrno(branchBrno).getBrcode();
////					context.setAttribute(OUT_CUSTMANAGER_LIST_BRNO, ties.getProbranchCustManager(brcode, value));
//				} else if (StringUtils.isEmpty(branchBrno)) {
//					brcode = bctlService.getBctlByBrno(brno).getBrcode();
//					List subBranchList = bctlService.getSubBrcodeList(brcode);
//					String where = "po.brcode = ? order by po.extTlrno";
//					List returnList = new ArrayList();
//					for (int i = 0; i < subBranchList.size(); i++) {
//						Object[] b = new Object[] { ((Bctl) subBranchList.get(i)).getBrcode() };
////						returnList.addAll(ties.getBranchCustManager(where, b));
//					}
//					context.setAttribute(OUT_CUSTMANAGER_LIST_BRNO, returnList);
//				} else {
//					context.setAttribute(OUT_CUSTMANAGER_LIST_BRNO, null);
//				}
//			} else {
//				if (StringUtils.isEmpty(brno)) {
//					brcode = bctlService.getBctlByBrno(branchBrno).getBrcode();
////					context.setAttribute(OUT_CUSTMANAGER_LIST_BRNO, ties.getProbranchCustManager(brcode, value));
//				} else if (StringUtils.isEmpty(branchBrno)) {
//					brcode = bctlService.getBctlByBrno(brno).getBrcode();
//					List subBranchList = bctlService.getSubBrcodeList(brcode);
//					String where = "po.brcode = ? and po.extTlrno like ? order by po.extTlrno";
//					List returnList = new ArrayList();
//					for (int i = 0; i < subBranchList.size(); i++) {
//						Object[] b = new Object[] { ((Bctl) subBranchList.get(i)).getBrcode(), value };
////						returnList.addAll(ties.getBranchCustManager(where, b));
//					}
//					context.setAttribute(OUT_CUSTMANAGER_LIST_BRNO, returnList);
//				} else {
//					context.setAttribute(OUT_CUSTMANAGER_LIST_BRNO, null);
//				}
//			}
//		}
		// 统计分析查询客户经理下拉列表查询，通过内部机构号(查询分行下属所有支行客户经理)
//		else if (StringUtils.equals(cmd, CMD_DROP_DOWN_CUSTMANAGER_BRCODE)) {
//			String value = context.getAttribute("value").toString();
//			brcode = context.getAttribute("brcode").toString();
//			String branchBrcode = context.getAttribute("branchBrcode").toString();
//			// 如果筛选为空
//			if (StringUtils.isBlank(value)) {
//				// 如果分行号为空,机构号不为空
//				if (StringUtils.isBlank(branchBrcode) && StringUtils.isNotBlank(brcode)) {
//					context.setAttribute(OUT_CUSTMANAGER_LIST_BRCODE, ties.getSubBranchCustManager(brcode, value));
//				}
//				// 如果分行号不为空,机构号为空
//				else if (StringUtils.isNotBlank(branchBrcode) && StringUtils.isBlank(brcode)) {
//					List subBranchList = bctlService.getSubBrcodeList(branchBrcode);
//					String where = "po.brcode=? order by po.extTlrno";
//					List returnList = new ArrayList();
//					for (int i = 0; i < subBranchList.size(); i++) {
//						Object[] b = new Object[] { ((Bctl) subBranchList.get(i)).getBrcode() };
////						returnList.addAll(ties.getBranchCustManager(where, b));
//					}
//					context.setAttribute(OUT_CUSTMANAGER_LIST_BRCODE, returnList);
//				}
//				// 如果分行号机构号都不为空
//				else if (StringUtils.isNotBlank(branchBrcode) && StringUtils.isNotBlank(brcode)) {
//					context.setAttribute(OUT_CUSTMANAGER_LIST_BRCODE, ties.getSubBranchCustManager(brcode, value));
//				}
//			}
//			// 如果筛选不为空
//			else {
//				// 如果分行号为空,机构号不为空
//				if (StringUtils.isBlank(branchBrcode) && StringUtils.isNotBlank(brcode)) {
//					context.setAttribute(OUT_CUSTMANAGER_LIST_BRCODE, ties.getSubBranchCustManager(brcode, value));
//				}
//				// 如果分行号不为空,机构号为空
//				else if (StringUtils.isNotBlank(branchBrcode) && StringUtils.isBlank(brcode)) {
//					List subBranchList = bctlService.getSubBrcodeList(branchBrcode);
//					String where = "po.brcode=? and po.extTlrno like ? order by po.extTlrno";
//					List returnList = new ArrayList();
//					for (int i = 0; i < subBranchList.size(); i++) {
//						Object[] b = new Object[] { ((Bctl) subBranchList.get(i)).getBrcode(), value };
////						returnList.addAll(ties.getBranchCustManager(where, b));
//					}
//					context.setAttribute(OUT_CUSTMANAGER_LIST_BRCODE, returnList);
//				}
//				// 如果分行号机构号都不为空
//				else if (StringUtils.isNotBlank(branchBrcode) && StringUtils.isNotBlank(brcode)) {
//					context.setAttribute(OUT_CUSTMANAGER_LIST_BRCODE, ties.getSubBranchCustManager(brcode, value));
//				}
//			}
//		}
	}
}
