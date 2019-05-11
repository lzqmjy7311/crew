package com.gbicc.company.single.getter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
public class TCmSingleRulInvestigationBranchTreeGetter extends BaseGetter {

	@Override
	public Result call() throws AppException {
		List<TreeNode> list = new ArrayList<TreeNode>();

		GlobalInfo info=GlobalInfo.getCurrentInstance();
		//info.getBrClass()=='';
		//info
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
			/*if (StringUtils.isNotBlank(obj.getBlnUpBrcode())) {
				n.setHasChild(BaseDAOUtils.getHQLDAO().queryByQL("from Bctl where blnUpBrcode ='" + obj.getBrcode() + "'").hasNext());
			}*/
			list.add(n);
		}
		//list = buildTree(list, rootBrcode);

		ResultMng.fillResultByList(getCommonQueryBean(), getCommQueryServletRequest(), list, getResult());
		getResult().setContent(list);
		getResult().getPage().setTotalPage(1);
		getResult().init();
		return getResult();
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
