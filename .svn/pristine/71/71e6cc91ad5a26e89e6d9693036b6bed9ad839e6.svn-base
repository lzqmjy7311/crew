package com.huateng.ebank.business.management.getter;

import java.util.ArrayList;
import java.util.List;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.approve.bean.RoleInfoBean;
import com.huateng.ebank.entity.dao.mng.ROOTDAO;
import com.huateng.ebank.entity.dao.mng.ROOTDAOUtils;
import com.huateng.ebank.entity.data.mng.RoleInfo;
import com.huateng.ebank.entity.data.mng.SysTaskInfo;
import com.huateng.ebank.entity.data.mng.SysTaskLog;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;
import com.huateng.report.common.service.ReportShowDetailService;
import com.huateng.report.utils.ReportTaskUtil;

public class RoleFuncRelMngCompareGetter extends BaseGetter {

	@Override
	public Result call() throws AppException {
		try {
			String id=getCommQueryServletRequest().getParameter("id");
			String st=getCommQueryServletRequest().getParameter("st");
			String tskId=getCommQueryServletRequest().getParameter("tskId");
			String flag=getCommQueryServletRequest().getParameter("flag");
			
			ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
			List resultList = new ArrayList();
			ReportTaskUtil  rt=new ReportTaskUtil();
			if(flag.equals("0")){
				RoleInfo roleInfo = rootdao.query(RoleInfo.class, Integer.parseInt(id));
				RoleInfoBean roleInfoBean = new RoleInfoBean();
				roleInfoBean.setRoleNameOld(roleInfo.getRoleName());
				roleInfoBean.setIdOld(roleInfo.getId());
				
				if(st.equals("2")){
					List<SysTaskInfo> taskList = ROOTDAOUtils.getROOTDAO().queryByQL2List("from SysTaskInfo where intInsId='100299' and adtRcdPk='" + id + "'");
					if (taskList.size() > 0) {
						RoleInfo seriBean = (RoleInfo) rt.getObjctBySysTaskInfo(taskList.get(0));
						roleInfoBean.setRoleName(seriBean.getRoleName());
						roleInfoBean.setId(roleInfo.getId());
					}
				}
				resultList.add(roleInfoBean);
			}
			if(flag.equals("1")){
				 SysTaskLog  systasklog=ReportShowDetailService.getInstance().selectTaskLog(tskId);
				 RoleInfo newBean=null;
				 RoleInfo oldbean=null;
				 RoleInfoBean roleInfoBean = new RoleInfoBean();
				 if(systasklog.getOldVal1()!=null){
					 oldbean=(RoleInfo)rt.getOldObjectByTaskLog(systasklog);
				  }
				  if(systasklog.getNewVal1()!=null){
					  newBean= (RoleInfo)rt.getNewObjectByTaskLog(systasklog);
				  }
				  //新增的时候
				  if(st.equals("1")){
					  roleInfoBean.setRoleName(newBean.getRoleName());
					  roleInfoBean.setId(newBean.getId());
				  }
				  //修改的时候
				  else if(st.equals("2")){
					  roleInfoBean.setRoleName(newBean.getRoleName());
					  roleInfoBean.setId(newBean.getId());
					  roleInfoBean.setRoleNameOld(oldbean.getRoleName());
					  roleInfoBean.setIdOld(oldbean.getId());
				  }
				  resultList.add(roleInfoBean);
			}
			ResultMng.fillResultByList(getCommonQueryBean(),
					getCommQueryServletRequest(), resultList,
					getResult());
			result.setContent(resultList);
			result.getPage().setTotalPage(1);
			result.init();
			return result;
		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}
}
