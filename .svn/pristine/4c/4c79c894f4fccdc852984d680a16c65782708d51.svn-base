package com.huateng.ebank.business.opermng.getter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.approve.bean.TlrInfoAuditBean;
import com.huateng.ebank.business.common.DAOUtils;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.entity.data.mng.RoleInfo;
import com.huateng.ebank.entity.data.mng.SysTaskLog;
import com.huateng.ebank.entity.data.mng.TlrRoleRel;
import com.huateng.ebank.entity.view.TlrRoleRelationView;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;
import com.huateng.report.common.service.ReportShowDetailService;
import com.huateng.report.utils.ReportTaskUtil;
import com.huateng.report.utils.ReportUtils;

/**
 * @author zhiguo.zhao
 *
 */
public class OperMngRoleInfoComGetter extends BaseGetter {

	public Result call() throws AppException {
		try {
			PageQueryResult pageResult = getData();
			ResultMng.fillResultByList(getCommonQueryBean(),
					getCommQueryServletRequest(), pageResult.getQueryResult(),
					getResult());
			result.setContent(pageResult.getQueryResult());
			result.getPage().setTotalPage(
					pageResult.getPageCount(getResult().getPage()
							.getEveryPage()));
			result.init();
			return result;
		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}

	}

	private PageQueryResult getData() throws CommonException, IOException, ClassNotFoundException {
		PageQueryResult pageQueryResult = new PageQueryResult();

		String tlrno = getCommQueryServletRequest().getParameter("id");
		String flag = (String) getCommQueryServletRequest().getParameterMap().get("flag");
		String tskId = (String) getCommQueryServletRequest().getParameter("tskId");
		String st = (String) getCommQueryServletRequest().getParameter("st");
		
		List tlrRoleViewList = new ArrayList();
		List<Integer> roleIds = new ArrayList<Integer>();
		if (flag.equals("0")) {
			List urrlist = DAOUtils.getTlrRoleRelDAO().queryByCondition(" po.tlrno = '" + tlrno + "' and status <> 0");
			for (Iterator it = urrlist.iterator(); it.hasNext();) {
				TlrRoleRel rr = (TlrRoleRel) it.next();
				roleIds.add(rr.getRoleId());
			}
			
			if(!roleIds.isEmpty()){
				List roleList = DAOUtils.getRoleInfoDAO().queryByCondition(" po.id in" + ReportUtils.toInString(roleIds));
				// 对以有的操作员岗位在岗位列表中显示
				for (int i = 0; i < roleList.size(); i++) {
					RoleInfo roleInfo = (RoleInfo) roleList.get(i);
					TlrRoleRelationView tlrRoleView = new TlrRoleRelationView();
					tlrRoleView.setRoleId(String.valueOf(roleInfo.getId().intValue()));
					tlrRoleView.setRoleName(roleInfo.getRoleName());
					tlrRoleViewList.add(tlrRoleView);
				}
			}

			if (tlrRoleViewList != null && tlrRoleViewList.size() > 0) {
				pageQueryResult.setTotalCount(tlrRoleViewList.size());
			} else {
				pageQueryResult.setTotalCount(0);
			}
			pageQueryResult.setQueryResult(tlrRoleViewList);
		} 
		if(flag.equals("1")) {
			ReportTaskUtil rt=new ReportTaskUtil();
			SysTaskLog  systasklog=ReportShowDetailService.getInstance().selectTaskLog(tskId);
			TlrInfoAuditBean OldValue = null;
			if(systasklog.getOldVal1()!=null){
				OldValue=(TlrInfoAuditBean)rt.getOldObjectByTaskLog(systasklog);	  
			}
			if(OldValue != null){
				for (TlrRoleRel rr : OldValue.getRoleRellist()) {
					roleIds.add(rr.getRoleId());
				}
				List roleList = DAOUtils.getRoleInfoDAO().queryByCondition(" po.id in" + ReportUtils.toInString(roleIds));
				// 对以有的操作员岗位在岗位列表中显示
				for (int i = 0; i < roleList.size(); i++) {
					RoleInfo roleInfo = (RoleInfo) roleList.get(i);
					TlrRoleRelationView tlrRoleView = new TlrRoleRelationView();
					tlrRoleView.setRoleId(String.valueOf(roleInfo.getId().intValue()));
					tlrRoleView.setRoleName(roleInfo.getRoleName());
					tlrRoleViewList.add(tlrRoleView);
				}
				pageQueryResult.setQueryResult(tlrRoleViewList);
				pageQueryResult.setTotalCount(tlrRoleViewList.size());
			}
		}
		return pageQueryResult;
	}
}
