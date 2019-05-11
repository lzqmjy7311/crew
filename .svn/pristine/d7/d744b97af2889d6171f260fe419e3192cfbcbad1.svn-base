package com.gbicc.bpm.getter;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.gbicc.common.FileUpDownProperties;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.entity.dao.mng.ROOTDAOUtils;
import com.huateng.ebank.entity.dao.mng.TlrInfoDAO;
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
public class SubAutoUserAndOrgGetter extends BaseGetter {
	
	public static final String SUBBRANCH_MNG="two_subbranch_mng";//二级支行客户经理岗
	
	public Result call() throws CommonException {
		List<TlrInfo> returnList = new ArrayList<TlrInfo>();		
		List<TlrInfo> list = new ArrayList<TlrInfo>();
		try {
			String val = this.getCommQueryServletRequest().getParameter("value");
			String orgId=this.getCommQueryServletRequest().getParameter("orgId");
			String currAssignee=this.getCommQueryServletRequest().getParameter("currAssignee");
			String roleFlag=this.getCommQueryServletRequest().getParameter("roleFlag");
			String roleId=FileUpDownProperties.readValue(SUBBRANCH_MNG);
			if (StringUtils.isNotBlank(val)) {
				list = this.getTlrs(val,orgId,currAssignee,roleId,roleFlag);
			} else {
				list = this.getAllSubList(orgId,currAssignee,roleId,roleFlag);
			}
			returnList = getList(list);
			ResultMng.fillResultByList(getCommonQueryBean(),getCommQueryServletRequest(),returnList,getResult());
		} catch (AppException e) {
			e.printStackTrace();
		}
		result.setContent(returnList);
		int pageSize = result.getPage().getEveryPage();
		int pageCount = (list.size() - 1) / pageSize + 1;
		result.getPage().setTotalPage(pageCount);
		result.init();
		return result;
	}

	@SuppressWarnings("rawtypes")
	public List getAllSubList(String orgId,String currAssignee,String roleId,String roleFlag) throws CommonException {
		TlrInfoDAO tlrInfoDao = ROOTDAOUtils.getTlrInfoDAO();
		String whileStr=" 1=1 ";
		if(StringUtils.isNotBlank(orgId) && StringUtils.isEmpty(roleFlag)){
			whileStr+=" and po.tlrno in (select userId from UserOrgRoleRel where orgId='"+orgId+"' and roleId='"+roleId+"') ";
		}else if(StringUtils.isNotBlank(orgId)){
			whileStr+=" and po.tlrno in (select tlrNo from TlrBctlRel where brNo='"+orgId+"') ";
		}else if(StringUtils.isEmpty(roleFlag)){
			whileStr+=" and po.tlrno in (select tlrno from TlrRoleRel where roleId='"+roleId+"') ";
		}
		if(StringUtils.isNotBlank(currAssignee)){
			whileStr+=" and po.tlrno!='"+currAssignee+"' ";
		}
		List list = tlrInfoDao.queryByCondition(whileStr);
		for(int i=0;i<list.size();i++){
			TlrInfo tlr=(TlrInfo) list.get(i);
			tlr.setTlrName(tlr.getBrcode()+","+tlr.getTlrName()+","+tlr.getTlrno());
		}
		return list;
	}
	
	@SuppressWarnings("rawtypes")
	public List getTlrs(String tlrName,String orgId,String currAssignee,String roleId,String roleFlag) throws CommonException {
		TlrInfoDAO tlrInfoDao = ROOTDAOUtils.getTlrInfoDAO();
		List list = new ArrayList();
		String sql = " 1=1";
		if(StringUtils.isNotBlank(orgId) && StringUtils.isEmpty(roleFlag)){
			sql+=" and po.tlrno in (select userId from UserOrgRoleRel where orgId='"+orgId+"' and roleId='"+roleId+"') ";
		}else if(StringUtils.isNotBlank(orgId)){
			sql+=" and po.tlrno in (select tlrNo from TlrBctlRel where brNo='"+orgId+"') ";
		}else if(StringUtils.isEmpty(roleFlag)){
			sql+=" and po.tlrno in (select tlrno from TlrRoleRel where roleId='"+roleId+"') ";
		}
		if (StringUtils.isNotBlank(tlrName)) {
			sql += " and po.tlrName like '%" + tlrName.trim() + "%'";
		}
		if(StringUtils.isNotBlank(currAssignee)){
			sql+=" and po.tlrno!='"+currAssignee+"' ";
		}
		list = tlrInfoDao.queryByCondition(sql,new Object[] {  }, null);
		for(int i=0;i<list.size();i++){
			TlrInfo tlr=(TlrInfo) list.get(i);
			tlr.setTlrName(tlr.getBrcode()+","+tlr.getTlrName()+","+tlr.getTlrno());
		}
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
