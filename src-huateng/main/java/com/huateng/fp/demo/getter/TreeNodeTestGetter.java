package com.huateng.fp.demo.getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang.RandomStringUtils;

import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.bean.TreeNode;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;
import com.huateng.fp.demo.bean.TreeField;

public class TreeNodeTestGetter extends BaseGetter {
	@Override
	public Result call() throws AppException {
		List<TreeNode> list = new ArrayList<TreeNode>();

		String id = getCommQueryServletRequest().getParameter("_id");
		list = initStaticDataAysc(id);// initStaticDataAysc(id);

		ResultMng.fillResultByList(getCommonQueryBean(), getCommQueryServletRequest(), list, getResult());
		result.setContent(list);
		result.getPage().setTotalPage(1);
		result.init();
		return result;
	}

	private List<TreeNode> createNodes(final String pid, final int N) {
		List<TreeNode> list = new ArrayList<TreeNode>();
		TreeField node = new TreeField();
		for (int i = 0; i < N; i++) {
			node = new TreeField();
			node.setId(RandomStringUtils.randomAlphabetic(8));
			node.setText(RandomStringUtils.randomAlphabetic(8));
			node.setHasChild(true);
			node.setPid(pid);
			node.setFd(generateField(30));
			list.add(node);
		}
		return list;
	}

	private String[] generateField(int N) {
		String[] s = new String[N];
		for (int i = 0; i < s.length; i++) {
			s[i] = RandomStringUtils.randomAlphabetic(8);
		}
		return s;
	}
	public List<TreeNode> initStaticDataAysc(String id) {// 异步方式
		return createNodes(id, id==null?80:10);//new Random().nextInt(10) + 1
	}

}
