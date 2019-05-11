package com.gbicc.bpm.getter;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.gbicc.common.CommonService;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.service.BctlService;
import com.huateng.ebank.entity.data.mng.Bctl;
import com.huateng.ebank.entity.data.mng.TlrInfo;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

/**
 * 带机构的用户下拉框，格式：机构编号，客户名称，客户编号
 * 如：0015，张三，000001
 * 2015年12月10日14:30:18
 *
 */
@SuppressWarnings("unchecked")
public class SubAutoTaskAssigneeGetter extends BaseGetter {
	
	public Result call() throws CommonException {
		List<TlrInfo> returnList = new ArrayList<TlrInfo>();		
		List<TlrInfo> list = new ArrayList<TlrInfo>();
		try {
			String orgId=this.getCommQueryServletRequest().getParameter("orgId");
			String roleId = this.getCommQueryServletRequest().getParameter("roleId");
			String userId = this.getCommQueryServletRequest().getParameter("userId");
			if(StringUtils.isNotEmpty(orgId) && StringUtils.isNotEmpty(roleId)){
				list=getAssigneeList(orgId,roleId,userId);
			}
			returnList = getList(list);
			ResultMng.fillResultByList(getCommonQueryBean(),getCommQueryServletRequest(),returnList,getResult());
		} catch (AppException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		result.setContent(returnList);
		int pageSize = result.getPage().getEveryPage();
		int pageCount = (list.size() - 1) / pageSize + 1;
		result.getPage().setTotalPage(pageCount);
		result.init();
		return result;
	}

	public List<TlrInfo> getAssigneeList(String orgId,String roleId,String userId) throws Exception {
		List<TlrInfo> list=findUserIdByRoleidAll(roleId, orgId,userId);
		for(int i=0;i<list.size();i++){
			TlrInfo tlr=list.get(i);
			tlr.setTlrName(tlr.getTlrName()+"("+tlr.getTlrno()+")");
		}
		return list;
	}
	
	/**
	 * 根据角色ID及机构ID查询当前机构和上级机构用户ID
	 * @param roleId
	 * @param orgId
	 * @return
	 * @throws Exception
	 */
	public List<TlrInfo> findUserIdByRoleidAll(String roleId,String orgId,String userId)throws Exception{
		Bctl bctl=BctlService.getInstance().getBctlByBrcode(orgId);
		String sql="";
		if(StringUtils.isNotEmpty(bctl.getBlnUpBrcode())){
			sql="select * from tlr_info where tlrno in (select F_USER_ID from T_USER_ORGROLE_REL where (f_org_id='"+orgId+"' or f_org_id='"+bctl.getBlnUpBrcode()+"') and f_role_id='"+roleId+"') and tlrno<>'"+userId+"'";
		}else{
			sql="select * from tlr_info where tlrno in (select F_USER_ID from T_USER_ORGROLE_REL where f_org_id='"+orgId+"' and f_role_id='"+roleId+"') and tlrno<>'"+userId+"'";
		}
		List<TlrInfo> list=CommonService.getInstance().findSqlListBySpringJdbc(sql,TlrInfo.class);
		return list;
	}
	
	@SuppressWarnings("rawtypes")
	public List getList(List list) {
		int pageSize = this.getResult().getPage().getEveryPage();
		int pageIndex = this.getResult().getPage().getCurrentPage();
		int startRow = (pageIndex - 1) * pageSize;
		int endRow = startRow + pageSize;
		List tlrs = new ArrayList();
		if (list != null && !list.isEmpty()) {
			for (; startRow < endRow; startRow++) {
				tlrs.add(list.get(startRow));
				if (startRow == list.size() - 1) {
					break;
				}
			}
		}
		return tlrs;
	}
}
