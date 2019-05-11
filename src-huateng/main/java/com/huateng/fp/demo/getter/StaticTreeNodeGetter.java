package com.huateng.fp.demo.getter;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.bean.TreeNode;
import com.huateng.ebank.entity.view.RoleBean;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

public class StaticTreeNodeGetter extends BaseGetter {

	public Result call() throws AppException {
		String _id = getCommQueryServletRequest().getParameter("_id");
		if (StringUtils.isBlank(_id)) {
			_id = "1";
		}
		TreeNode root = new TreeNode();
		root.setId(_id);
		root.setText("node");
		//生成数据
		List<TreeNode> list = genChildrenNode(root, 4, 6);

		for (TreeNode n : list) {// 将节点11112设成异步加载节点
			if (n.getId().equals("11112")) {
				n.setHasChild(true);
				break;
			}
		}
		
		//在fillResultByList之前生成HTML
		genTreeHTML(list);
		
		ResultMng.fillResultByList(getCommonQueryBean(), getCommQueryServletRequest(), list, getResult());
		result.setContent(list);
		result.getPage().setTotalPage(1);
		result.init();
		return result;
	}

	/**
	 * 模拟构造树节点数据
	 * 
	 * @param parent
	 *            父节点
	 * @param level
	 *            层次
	 * @param N
	 *            每层节点数
	 */
	public List<TreeNode> genChildrenNode(TreeNode parent, int level, int N) {
		List<TreeNode> list = new ArrayList<TreeNode>();
		if (level < 1)
			return list;
		for (int i = 0; i < N; i++) {
			TreeNode node1 = new TreeNode();
			node1.setId(parent.getId() + (i + 1));
			node1.setText(parent.getText() + (i + 1));
			// node1.appendTo(parent);
			node1.setPid(parent.getId());
			RoleBean b = new RoleBean();
			b.setRolename(node1.getText());
			node1.setAttributes(b);
			list.addAll(genChildrenNode(node1, level - 1, N));
			list.add(node1);
		}
		return list;

	}

}
