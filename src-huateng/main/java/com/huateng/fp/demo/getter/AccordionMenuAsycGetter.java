package com.huateng.fp.demo.getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang.StringUtils;

import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.bean.TreeNode;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

public class AccordionMenuAsycGetter extends BaseGetter {

	@Override
	public Result call() throws AppException {
		List<TreeNode> list = new ArrayList<TreeNode>();
		String pid = getCommQueryServletRequest().getParameter("_id");
		list = getChildrenNode(pid);

		ResultMng.fillResultByList(getCommonQueryBean(), getCommQueryServletRequest(), list, getResult());
		result.setContent(list);
		result.getPage().setTotalPage(1);
		result.init();
		return result;
	}

	public List<TreeNode> getChildrenNode(String pid) {
//		if (StringUtils.isBlank(pid)) {
//			pid = "0";
//		}
		List<TreeNode> list = new ArrayList<TreeNode>();
		TreeNode node = new TreeNode();
		Random r = new Random();
		int N = r.nextInt(15);
		for (int i = 0; i < N; i++) {
			node = new TreeNode();
			node.setId(pid + i);
			node.setPid(pid);
			if (i < 2) {
				node.setHasChild(true);
			}
			node.setText("节点" + i);
			list.add(node);
		}
		return list;
	}
}
