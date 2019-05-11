package com.huateng.ebank.business.management.updater;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.SystemConstant;
import com.huateng.ebank.business.common.service.CommonService;
import com.huateng.ebank.business.management.operation.TlrInfoExOperation;
import com.huateng.ebank.business.management.service.PasswordService;
import com.huateng.ebank.entity.data.mng.TlrInfo;
import com.huateng.ebank.entity.view.TlrRoleRelationView;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.util.DateUtil;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;

/**
 * 操作员增加EX
 *
 * @author hyurain_yang
 *
 */
public class TlrAddUpdate extends BaseUpdate {

	public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean multiUpdateResultBean, HttpServletRequest request,
			HttpServletResponse response) throws AppException {
		try {
			UpdateResultBean tlrRoleBean = multiUpdateResultBean.getUpdateResultBeanByID("Management_AllRole");
			UpdateResultBean tlrInfoBean = multiUpdateResultBean.getUpdateResultBeanByID("Management_TlrAdd");
			List insertRoleList = new ArrayList();
			TlrInfo tlrInfo = new TlrInfo();
			if (tlrInfoBean.hasNext()) {
				tlrInfo = new TlrInfo();
				Map map = tlrInfoBean.next();
				tlrInfo.setBrcode((String) map.get("brcode"));
				tlrInfo.setTlrno((String) map.get("tlrno"));// 暂时将操作员内部操作员号和外部操作员号设置成一样
//				tlrInfo.setExtTlrno((String) map.get("extTlrno"));
				tlrInfo.setTlrName((String) map.get("tlrName"));
				tlrInfo.setRoleid(Integer.valueOf(String.valueOf(map.get("defRoleid"))));
//				tlrInfo.setDepartmentCode(Long.valueOf((String)map.get("departmentCode")));
//				tlrInfo.setEffectDate(new SimpleDateFormat("yyyy-MM-dd").parse(map.get("effectDate").toString()));
//				tlrInfo.setExpireDate(new SimpleDateFormat("yyyy-MM-dd").parse(map.get("expireDate").toString()));
//				tlrInfo.setCurRoleid(tlrInfo.getDefRoleid());// 设置操作员当前岗位就为操作员默认岗位
				tlrInfo.setLoginIp((String) map.get("loginIp"));
				/* modify by shen_antonio 20081010. */
				// 设置默认操作员签退状态
				tlrInfo.setStatus(SystemConstant.TLR_NO_STATE_LOGOUT);
				// 设置有效标志
				tlrInfo.setFlag(SystemConstant.FLAG_ON);
//				tlrInfo.setCreatDate(new Date(GlobalInfo.getCurrentInstance().getTxtime().getTime()));
				String sysDefaultPwd = CommonService.getInstance().getSysParamDef("PSWD", "DEFAULT_PWD", SystemConstant.DEFAULT_PASSWORD);
				String encMethod = CommonService.getInstance().getSysParamDef("PSWD", "ENC_MODE", "AES128");
				String pwd = PasswordService.getInstance().EncryptPassword(sysDefaultPwd, encMethod);
				tlrInfo.setPassword(pwd);// 设置默认操作员密码
				// 为操作员密码错误次数付初始值
				tlrInfo.setTotpswderrcnt(new Integer(0));
				tlrInfo.setPswderrcnt(new Integer(0));
				tlrInfo.setPasswdenc(encMethod);
				tlrInfo.setCreateDate(DateUtil.dateToNumber(GlobalInfo.getCurrentInstance().getTxdate()));
			}
			while (tlrRoleBean.hasNext()) {
				TlrRoleRelationView tlrRoleView = new TlrRoleRelationView();
				mapToObject(tlrRoleView, tlrRoleBean.next());
				tlrRoleView.setTlrno(tlrInfo.getTlrno());

				if (tlrRoleView.isSelected()) {
//					if (isProBranchRoleAddCustManageAndSubBranch(tlrInfo.getBrcode(), tlrRoleView.getRoleId())) {
						insertRoleList.add(tlrRoleView);
//					} else{
//						ExceptionUtil.throwCommonException("只有支行级别的机构可以增加操作员为客户经理或支行行长", ErrorCode.ERROR_CODE_CANNOT_SUBMIT);
//					}
				}
			}
			OperationContext oc = new OperationContext();
			oc.setAttribute("insertRoleList", insertRoleList);
			oc.setAttribute("tlrInfo", tlrInfo);
			oc.setAttribute(TlrInfoExOperation.CMD, "INSERT_TLR_INFO");
			OPCaller.call(TlrInfoExOperation.ID, oc);
			return new UpdateReturnBean();
		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE, Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}

	/**只有支行级别的机构可以增加客户经理和支行行长的操作员
	 * @param brcode
	 * @param roleId
	 * return boolean
	 */
//	public boolean isProBranchRoleAddCustManageAndSubBranch(String brcode,
//				String roleId) throws CommonException {
//		int roleIdInt = Integer.valueOf(roleId).intValue();
//		if ( SystemConstant.ROLE_CUST_MANAGER == roleIdInt || roleIdInt==SystemConstant.SUB_BRANCH_MANAGER) {
//			if (BctlService.getInstance().isSubBrcode(brcode)) {
//				return true;
//			} else
//				return false;
//		}
//		return true;
//	}

}
