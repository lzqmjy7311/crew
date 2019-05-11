package com.huateng.ebank.business.opermng.update;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gbicc.user.entity.TModifiedRoleid;
import com.gbicc.user.service.TModifiedRoleidService;
import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.business.common.ErrorCode;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.SystemConstant;
import com.huateng.ebank.business.common.service.CommonService;
import com.huateng.ebank.business.opermng.operation.OperMngOperation;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.util.ExceptionUtil;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;

/**
 * @author zhiguo.zhao
 *
 */
public class OperMngResetPwdUpdate extends BaseUpdate {

	@Override
	public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean arg0,
			HttpServletRequest arg1, HttpServletResponse arg2)
			throws AppException {
		try {
			String tlrno="";
			String brname="";
			UpdateReturnBean updateReturnBean = new UpdateReturnBean();
			UpdateResultBean updateResultBean = multiUpdateResultBean
					.getUpdateResultBeanByID("operMngEntry");
			if(updateResultBean.hasNext()) {
				 Map<String, String> map = updateResultBean.next();
				 tlrno=map.get("tlrno");
				brname = map.get("brname");
				OperationContext oc = new OperationContext();
				oc.setAttribute(OperMngOperation.CMD, "resetPwd");
				oc.setAttribute(OperMngOperation.IN_TLRNO, tlrno);
				OPCaller.call(OperMngOperation.ID, oc);
			} else {
				ExceptionUtil.throwAppException("请选择一条记录", ErrorCode.ERROR_CODE_NORMAL);
			}
			String sysDefaultPwd = CommonService.getInstance().getSysParamDef("PSWD", "DEFAULT_PWD", SystemConstant.DEFAULT_PASSWORD);
			updateReturnBean.setParameter("DefaultPWD", sysDefaultPwd);

			GlobalInfo globalInfo = GlobalInfo.getCurrentInstance();
			String roleId=globalInfo.getWorkflowRoleId();
			TModifiedRoleid tmr=new TModifiedRoleid();
			if(!roleId.equals("615")&&!roleId.equals("616")&&!roleId.equals("111")){
					StringBuilder sf=new StringBuilder();
					sf.append("重置密码");
					tmr.setFdRoleidb(sf.toString());
			}
			TModifiedRoleidService trs=TModifiedRoleidService.getInstance();
			tmr.setFdChangedate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
			tmr.setFdOperid(globalInfo.getTlrno());
			tmr.setFdOrgid(null);
			tmr.setFdUserid(tlrno);
			tmr.setFdOrgname(brname);
			trs.save(tmr);
			
			return updateReturnBean;
		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}

}
