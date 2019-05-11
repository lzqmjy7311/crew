package com.gbicc.common.Industry.getter;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.gbicc.common.Industry.entity.IndustryInfo;
import com.gbicc.common.Industry.entity.RoleIndustryTreeNode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.BaseDAOUtils;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

@SuppressWarnings("unchecked")
public class AsyncRoleIndustryTreeGetter extends BaseGetter {

	@Override
	public Result call() throws AppException {
		List<RoleIndustryTreeNode> li = null;
		li = this.getAll();
		ResultMng.fillResultByList(getCommonQueryBean(), getCommQueryServletRequest(), li, getResult());
		getResult().setContent(li);
		getResult().getPage().setTotalPage(1);
		getResult().init();
		return getResult();
	}

	private List<RoleIndustryTreeNode> getAll() throws CommonException {
		String pid = this.commQueryServletRequest.getParameter("_id");
		String mode = this.commQueryServletRequest.getParameter("mode");
		List<RoleIndustryTreeNode> re = null;
		String str = "from IndustryInfo func where 1=1 ";
		if (StringUtils.isNotBlank(pid)) {
			str += " and func.lastdirectory='" + pid + "' ";
		}
		str += " order by func.id";
		List<IndustryInfo> tmp = BaseDAOUtils.getHQLDAO().queryByQL2List(str);
		re = new ArrayList<RoleIndustryTreeNode>();
		for (IndustryInfo bar : tmp) {
			re.add(this.convert2Node(bar));
		}
		// Collections.sort(re);
		return re;
	}

	private RoleIndustryTreeNode convert2Node(IndustryInfo fi) {
		RoleIndustryTreeNode result = new RoleIndustryTreeNode(fi);
		return result;
	}
}
