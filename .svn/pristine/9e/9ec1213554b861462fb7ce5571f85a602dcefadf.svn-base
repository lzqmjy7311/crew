package com.huateng.ebank.business.management.getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.BaseDAOUtils;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.bean.TreeNode;
import com.huateng.ebank.entity.data.mng.Bctl;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

@SuppressWarnings("unchecked")
public class AccountlistTreeGetter extends BaseGetter {

	@Override
	public Result call() throws AppException {
		List<TreeNode> list = new ArrayList<TreeNode>();

		StringBuffer hql = new StringBuffer();
		hql.append(" from Bctl po where 1=1");
		
		String id = getCommQueryServletRequest().getParameter("_id");
		String rootBrcode = null;
		if(StringUtils.isNotBlank(id)) {
			hql.append(" and po.blnUpBrcode='").append(id).append("'");
		} else {
			rootBrcode = GlobalInfo.getCurrentInstance().getBrcode();
			hql.append(" and po.brcode='").append(rootBrcode).append("' or po.blnUpBrcode='").append(rootBrcode).append("'");
		}
		Iterator<Bctl> it = BaseDAOUtils.getHQLDAO().queryByQL(hql.toString());

		while (it.hasNext()) {
			Bctl obj = it.next();
			TreeNode n = this.convert(obj);
			if (StringUtils.isNotBlank(obj.getBlnUpBrcode())) {
				n.setHasChild(BaseDAOUtils.getHQLDAO().queryByQL("from Bctl where blnUpBrcode ='" + obj.getBrcode() + "'").hasNext());
			}
			list.add(n);
		}
		//list = buildTree(list, rootBrcode);

		ResultMng.fillResultByList(getCommonQueryBean(), getCommQueryServletRequest(), list, getResult());
		getResult().setContent(list);
		getResult().getPage().setTotalPage(1);
		getResult().init();
		return getResult();
	}

	private List<TreeNode> buildTree(List<TreeNode> li, String rootBrcode) {
		Map<String, List<TreeNode>> m = new HashMap<String, List<TreeNode>>();
		for (TreeNode foo : li) {
			String key = foo.getPid();
			if (!m.containsKey(key)) {
				m.put(key, new ArrayList<TreeNode>());
			}

			m.get(key).add(foo);
		}
		for (TreeNode foo : li) {
			String key = foo.getId();
			if (m.containsKey(key)) {
				for (TreeNode bar : m.get(key)) {
					if (!StringUtils.equalsIgnoreCase(key, bar.getId())) {
						foo.getChildren().add(bar);
					}
				}
			}
			foo.setHasChild(foo.getChildren().size() > 0);
		}
		if (StringUtils.isNotBlank(rootBrcode)) {
			List<TreeNode> t = new ArrayList<TreeNode>();
			for (TreeNode foo : li) {
				if(rootBrcode.equals(foo.getId())) {
					t = getNodes(foo);
					break;
				}
			}
			return t;
		} else {
			return li;
		}
	}
	private List<TreeNode> getNodes(TreeNode node) {
		List<TreeNode> t = new ArrayList<TreeNode>();
		t.add(node);
		for(TreeNode n : node.getChildren()) {
			t.addAll(getNodes(n));
		}
		return t;
	}

	private TreeNode convert(final Bctl obj) {
		TreeNode node = new TreeNode();
		node.setCanSelected(true);
		node.setId(StringUtils.strip(obj.getBrcode()));
		node.setPid(StringUtils.strip(obj.getBlnUpBrcode()));
		if (StringUtils.equalsIgnoreCase(node.getId(), node.getPid())) {
			node.setPid(null);
		}
		node.setText(obj.getBrname());
		node.setHasChild(false);
		return node;
	}

}
