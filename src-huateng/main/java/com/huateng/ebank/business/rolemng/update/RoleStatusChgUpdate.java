package com.huateng.ebank.business.rolemng.update;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.business.common.BaseDAOUtils;
import com.huateng.ebank.business.common.ErrorCode;
import com.huateng.ebank.business.management.operation.RoleMngApplyOperation;
import com.huateng.ebank.entity.dao.mng.ROOTDAO;
import com.huateng.ebank.entity.dao.mng.ROOTDAOUtils;
import com.huateng.ebank.entity.dao.mng.RoleInfoDAO;
import com.huateng.ebank.entity.data.mng.RoleInfo;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.util.ExceptionUtil;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;

public class RoleStatusChgUpdate extends BaseUpdate {

	private final static String PARAM_ACTION = "statu";
	private final static String DATASET_ID = "ebankCustRoleMng";
	private final static String ROLE_ID = "id";

	@Override
	public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean multiUpdateResultBean, HttpServletRequest arg1, HttpServletResponse arg2)
	        throws AppException {
		try {
			ROOTDAO rootdao =ROOTDAOUtils.getROOTDAO();
			UpdateReturnBean updateReturnBean = new UpdateReturnBean();
			UpdateResultBean updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID(DATASET_ID);
			RoleInfo roleInfo = new RoleInfo();
			RoleInfoDAO roleInfoDAO = BaseDAOUtils.getRoleInfoDAO();
			List updateList = new ArrayList();
			List delList = new ArrayList();
			List insertList = new ArrayList();
			if(updateResultBean.hasNext()) {
				String roleId = updateResultBean.next().get(ROLE_ID);
				String status = updateResultBean.getParameter(PARAM_ACTION);
				OperationContext oc = new OperationContext();
				roleInfo = roleInfoDAO.findById(Integer.valueOf(roleId));
				List<String>  rolelist = rootdao.queryByQL2List("select funcid from RoleFuncRel where roleId = '" + roleId + "'");
				String roleListString="";
				for(String func:rolelist){
					roleListString+=",";
					
				}
				roleInfo.setRoleList(roleListString);
				roleInfo.setStatus(status);
				//设为修改状态
				roleInfo.setSt("2");
				roleInfo.setIsLock("1");
				//roleInfo.setStatusModFlag("1");
				//表明是修改操作,防止这个修改和那个修改的值丢失
				updateList.add(roleInfo);
				//oc.setAttribute(RoleMngApplyOperation.IN_DEL, delList);
				oc.setAttribute(RoleMngApplyOperation.IN_INSERT, insertList);
				oc.setAttribute(RoleMngApplyOperation.IN_UPDATE, updateList);
				OPCaller.call(RoleMngApplyOperation.ID, oc);
			} else {
				ExceptionUtil.throwAppException("请选择一条记录", ErrorCode.ERROR_CODE_NORMAL);
			}
			
			return updateReturnBean;
		} catch (CommonException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE, Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}

}
