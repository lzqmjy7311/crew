package com.huateng.ebank.business.management.getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.management.bean.UserAuthority;
import com.huateng.ebank.entity.dao.mng.ROOTDAOUtils;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.report.common.ReportConstant;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

/**
 * @Description: 企业岗位查询
 * @Package: com.huateng.ebank.business.custadmin.getter
 * @author: fubo
 * @date: 2010-7-29 下午04:09:49
 * @Copyright: Copyright (c) 2010
 * @Company: Shanghai Huateng Software Systems Co., Ltd.
 */
public class UserAuthorityGetter extends BaseGetter {

	@Override
	public Result call() throws AppException {
		try {

			this.setValue2DataBus(ReportConstant.QUERY_LOG_BUSI_NAME, "人员角色权限查询");

			int pageIndex = getResult().getPage().getCurrentPage();
			int pageSize = getResult().getPage().getEveryPage();

			String trlNo = getCommQueryServletRequest().getParameter("ptrlno");
			String trlName = getCommQueryServletRequest().getParameter("ptrlname");
			StringBuffer sql = new StringBuffer(
					"SELECT a.TLRNO,a.TLR_NAME,b.ROLE_ID,c.ROLE_NAME FROM TLR_INFO a JOIN TLR_ROLE_REL b ON a.TLRNO=b.TLRNO JOIN ROLE_INFO c ON c.ROLE_ID=b.ROLE_ID WHERE 1=1");
			if (StringUtils.isNotBlank(trlNo)) {
				sql.append(" and a.TLRNO='").append(trlNo + "'");
			}
			if (StringUtils.isNotBlank(trlName)) {
				sql.append(" and a.TLR_NAME='").append(trlName + "'");
			}
			Iterator funList = ROOTDAOUtils.getROOTDAO().queryBySQL(sql.toString());
			Map<String, Set<String>> oMap = new HashMap<String, Set<String>>();
			while (funList.hasNext()) {
				Object[] object = (Object[]) funList.next();
				String tlrNo = (String) object[0];
				String tlrName = (String) object[1];
				String roleName = (String) object[3];

				String key = tlrNo.trim()+"-"+tlrName.trim();

				if (oMap.containsKey(key)) {
					Set<String> set = oMap.get(key);
					set.add(roleName);
				} else {
					Set<String> set = new HashSet<String>();
					set.add(roleName);
					oMap.put(key, set);
				}
			}
			List userList = new ArrayList();
			for (Iterator<String> it = oMap.keySet().iterator(); it.hasNext();) {
				String key = it.next();
				String[] keys = key.split("-");
				UserAuthority ua = new UserAuthority();
				ua.setTrlNo(keys[0]);
				ua.setTrlName(keys[1]);
				Set<String> roleNameSet = oMap.get(key);
				StringBuffer rolename = new StringBuffer();
				int i=0;
				for (Iterator iterator2 = roleNameSet.iterator(); iterator2.hasNext();) {
					String name = (String) iterator2.next();
					i++;
					if(i==roleNameSet.size()){
						rolename.append(name);
					}else{
						rolename.append(name+"，");
					}
				}
				ua.setRoleIdName(rolename.toString());
				userList.add(ua);
			}
			ResultMng.fillResultByList(getCommonQueryBean(), getCommQueryServletRequest(), userList, getResult());
			result.setContent(userList);
			result.getPage().setTotalPage(1);
			result.init();
			return result;
		} catch (CommonException e) {
			throw new AppException(Module.SYSTEM_MODULE, Rescode.DEFAULT_RESCODE, e.getMessage());
		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE, Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}

}
