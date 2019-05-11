package com.huateng.ebank.business.opermng.getter;

import java.util.ArrayList;
import java.util.List;

import com.gbicc.common.CommonService;
import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.DAOUtils;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.entity.data.mng.RoleInfo;
import com.huateng.ebank.entity.data.mng.TlrRoleRel;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

/**
 * @author zhiguo.zhao
 *
 */
public class OperMngRoleInfoGetter extends BaseGetter {

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

	private PageQueryResult getData() throws CommonException {
		PageQueryResult pageQueryResult = new PageQueryResult();
		String orgId = getCommQueryServletRequest().getParameter("orgId");
		String tlrno = getCommQueryServletRequest().getParameter("tlrno");
		//step1:查询所有岗位
		List<RoleInfo> allRoles = DAOUtils.getRoleInfoDAO().findAll();
		//step2:查询用户默认岗位
		/*TlrRoleRel defaultRole=DAOUtils.getTlrRoleRelDAO().queryDefaultRole(tlrno);
		for (RoleInfo info:allRoles) {
			if(defaultRole!=null && defaultRole.getRoleId().equals(info.getId())){
				info.setIsDefault("1");
			}
		}
		//step3:查询下用户对应机构角色
		String sql="SELECT  t3.ROLE_ID  FROM "+
				"T_USER_ORGROLE_REL t1  "+
				"JOIN TLR_BCTL_REL t2  "+
				"ON t1.f_org_id=t2.ID  "+
		        "JOIN TLR_ROLE_REL t3 "+
				"ON t1.F_ROLE_ID=t3.ID "+
			"WHERE "+
				"t1.f_user_id='"+tlrno+"' AND "+
				"t2.BR_NO='"+orgId+"' ";
		List<Integer> roles = CommonService.getInstance().findSqlSimpleListBySpringJdbc(
			sql,Integer.class);
		//step4:选中用户机构有的岗位
		for (RoleInfo info:allRoles) {
			info.setOrgId(orgId);
			for (Integer it:roles) {
				if(info.getId().equals(it)){
					//info.setSelected("1");
					break;
				}
			}
		}*/
		pageQueryResult.setTotalCount(allRoles.size());
		pageQueryResult.setQueryResult(allRoles);
		return pageQueryResult;
	}
}
