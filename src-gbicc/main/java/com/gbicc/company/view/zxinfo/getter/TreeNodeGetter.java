package com.gbicc.company.view.zxinfo.getter;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.StringUtils;

import com.gbicc.company.view.zxinfo.entity.TCmCompanyCreditIndexView;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.BaseDAOUtils;
import com.huateng.ebank.business.common.bean.TreeNode;
import com.huateng.ebank.entity.dao.mng.ROOTDAO;
import com.huateng.ebank.entity.dao.mng.ROOTDAOUtils;
import com.huateng.ebank.framework.util.ApplicationContextUtils;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

@SuppressWarnings("unchecked")
public class TreeNodeGetter extends BaseGetter {
	@Override
	public Result call() throws AppException {
		List<TreeNode> list = new ArrayList<TreeNode>();
		TCmCompanyCreditIndexView obj1=new TCmCompanyCreditIndexView();
		obj1.setIndexName("总体情况");
		TreeNode root = new TreeNode();
		root.setAttributes(obj1);
		root.setHasChild(true);
		root.setId("0");
		root.setText("总体情况");
		root.setPid("");
		list.add(root);
		
//		String fdAcctId = getCommQueryServletRequest().getParameter("id");
		String loanCardNum = (String) getCommQueryServletRequest().getParameterMap().get("loanCardNum");
		boolean flag;
//		if(StringUtils.isNotBlank(fdAcctId)) {
//			hql.append(" and po.fdAcctId='").append(fdAcctId).append("'");
//		}
//		else hql=new StringBuffer(" from TCmCompanyCreditIndexView po where 0=1");
		
		@SuppressWarnings("unused")
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		StringBuffer hql = new StringBuffer(" select t.INDEX_VALUE as indexValue,t.INDEX_ID as indexId,t.INDEX_NAME as indexName,t.FD_REPORTDATE as fdReportdate  from T_CM_COMPANY_CREDIT_INDEX_VIEW t where 1=1 ");
		if(StringUtils.hasText(loanCardNum)){
			hql.append(" and FD_LOANCARDNO = '"+loanCardNum+"'");
		}
		hql.append(" and t.FD_REPORTDATE = (select FD_REPORTDATE from T_CM_COMPANY_CREDIT_INDEX_VIEW  where FD_REPORTDATE is not null and FD_LOANCARDNO ="+loanCardNum+" order by FD_REPORTDATE desc fetch first 1 row only)");
		 JdbcTemplate jdbcTemplate=(JdbcTemplate) ApplicationContextUtils.getBean("JdbcTemplate");
		 List<TCmCompanyCreditIndexView> listT=jdbcTemplate.query(hql.toString(), BeanPropertyRowMapper.newInstance(TCmCompanyCreditIndexView.class));
		Iterator<TCmCompanyCreditIndexView> it = listT.iterator();
		if(it.hasNext()){
			flag=false;
		}else if(loanCardNum.isEmpty())
			{flag=false;}
			else flag=true;
		while (it.hasNext()) {
			TCmCompanyCreditIndexView obj =(TCmCompanyCreditIndexView) it.next();
			TreeNode n = this.convert(obj);
			list.add(n);
			flag=false;
		}
		//list = buildTree(list, rootBrcode);

		ResultMng.fillResultByList(getCommonQueryBean(), getCommQueryServletRequest(), list, getResult());
		getResult().setContent(list);
		getResult().getPage().setTotalPage(1);
		getResult().init();
		return getResult();
	}

	private List<TreeNode> getNodes(TreeNode node) {
		List<TreeNode> t = new ArrayList<TreeNode>();
		t.add(node);
		for(TreeNode n : node.getChildren()) {
			t.addAll(getNodes(n));
		}
		return t;
	}

	private TreeNode convert(final TCmCompanyCreditIndexView obj) {
		TreeNode node = new TreeNode();
		node.setCanSelected(true);
		node.setAttributes(obj);
		node.setId(obj.getIndexName());
		node.setText(obj.getIndexName());
		node.setHasChild(false);
		node.setPid("0");
		return node;
	}

}
