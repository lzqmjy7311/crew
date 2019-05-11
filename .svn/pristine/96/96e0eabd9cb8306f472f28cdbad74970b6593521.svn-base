package com.huateng.ebank.business.rolemng.getter;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.BaseDAOUtils;
import com.huateng.ebank.entity.data.mng.FunctionInfo;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

@SuppressWarnings("unchecked")
public class AsyncRoleFuncTreeGetter extends BaseGetter {

	@Override
	public Result call() throws AppException {
		List<RoleFuncTreeNode> li = null;
		li = this.getAll();
		ResultMng.fillResultByList(getCommonQueryBean(), getCommQueryServletRequest(), li, getResult());
		getResult().setContent(li);
		getResult().getPage().setTotalPage(1);
		getResult().init();
		return getResult();
	}

	private List<RoleFuncTreeNode> getAll() throws CommonException {
		String pid = this.commQueryServletRequest.getParameter("_id");
		String mode = this.commQueryServletRequest.getParameter("mode");
		List<RoleFuncTreeNode> re = null;
		String str = "from FunctionInfo func where 1=1 ";
		if (StringUtils.isNotBlank(pid)) {
			str += " and func.lastdirectory='" + pid + "' ";
		}
		if (StringUtils.isNotBlank(mode)) {
			str += " and func.location=" + mode;
		}
		str += " order by func.showseq,func.id";
		List<FunctionInfo> tmp = BaseDAOUtils.getHQLDAO().queryByQL2List(str);
		re = new ArrayList<RoleFuncTreeNode>();
		for (FunctionInfo bar : tmp) {
			re.add(this.convert2Node(bar));
		}
		// Collections.sort(re);
		return re;
	}

	private RoleFuncTreeNode convert2Node(FunctionInfo fi) {
		RoleFuncTreeNode result = new RoleFuncTreeNode(fi);
		return result;
	}
}
