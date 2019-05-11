package com.gbicc.bpm.getter;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.jdbc.core.JdbcTemplate;

import com.gbicc.bpm.SpringContextHolder;
import com.gbicc.common.FileUpDownProperties;
import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

/**
 * 根据机构ID查找所有客户经理
 * @author likm
 *
 */
public class SelectCheckUserGetter extends BaseGetter {

	@Override
	public Result call() throws AppException {
		try {
			PageQueryResult pageResult = getData();
			ResultMng.fillResultByList(getCommonQueryBean(),getCommQueryServletRequest(), pageResult.getQueryResult(),getResult());
			result.setContent(pageResult.getQueryResult());
			result.getPage().setTotalPage(pageResult.getPageCount(getResult().getPage().getEveryPage()));
			result.init();
			return result;
		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}

	protected PageQueryResult getData() throws Exception {
		String orgId = (String) getCommQueryServletRequest().getParameterMap().get("orgId");
		String checkUserIds = (String) getCommQueryServletRequest().getParameterMap().get("checkUserIds");
		PageQueryResult result = new PageQueryResult();
		if(StringUtils.isNotEmpty(orgId)){
			String roleId=FileUpDownProperties.readValue(SubAutoUserAndOrgGetter.SUBBRANCH_MNG);
			String sql="SELECT B.BRCODE,B.BRNAME,TLR.TLRNO,TLR.TLR_NAME AS TLRNAME FROM TLR_INFO TLR "+
			" JOIN T_USER_ORGROLE_REL REL ON TLR.TLRNO=REL.F_USER_ID "+
			" LEFT JOIN BCTL B "+
			" ON REL.F_ORG_ID=B.BRCODE "+
			" WHERE REL.F_ROLE_ID='"+roleId+"' "+
			" AND REL.F_ORG_ID='"+orgId+"' ";
			if(StringUtils.isNotEmpty(checkUserIds)){
				String userStr="";
				if(checkUserIds.indexOf(",")>-1){
					String[] users=checkUserIds.split(",");
					for(String user:users){
						userStr=userStr+"'"+user+"',";
					}
					userStr=userStr.substring(0,userStr.length()-1);
				}else{
					userStr="'"+checkUserIds+"'";
				}
				sql+="AND TLR.TLRNO NOT IN ("+userStr+")";
			}
			JdbcTemplate jdbcTemplate=SpringContextHolder.getBean(JdbcTemplate.class);
			List<Map<String,Object>> resultList=jdbcTemplate.queryForList(sql);
			result.setQueryResult(resultList);
			result.setTotalCount(resultList.size());
		}
		return result;
	}
}
