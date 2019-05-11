package com.gbicc.company.view.accountpage.getter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.jdbc.core.JdbcTemplate;

import com.gbicc.company.view.accountpage.entity.TEdwCorePayAcc;
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
public class AccountlistTreeGetter extends BaseGetter {
	@Override
	public Result call() throws AppException {
		List<TreeNode> list = new ArrayList<TreeNode>();
		ROOTDAO rootdao=ROOTDAOUtils.getROOTDAO();
		StringBuffer hql = new StringBuffer();
		hql.append(" from TEdwCorePayAcc po where 1=1");
//		String coreCustomerNum = getCommQueryServletRequest().getParameter("id");
		String pid = (String) getCommQueryServletRequest().getParameterMap().get("id");
		String id = this.commQueryServletRequest.getParameter("_id");
		String customerNum = (String) getCommQueryServletRequest().getParameterMap().get("customerNum");
		boolean flag;
		if(StringUtils.isNotBlank(id)) {
			hql.append(" and po.customerNo='").append(id).append("'");
		}else hql=new StringBuffer(" from TEdwCorePayAcc po where 0=1");
//		Iterator it = BaseDAOUtils.getHQLDAO().queryByQL(hql.toString());
		Iterator it = rootdao.queryByQL(hql.toString());
//		if(it.hasNext()){
//			flag=false;
//		}else flag=true;
		if(it.hasNext()){
			flag=false;
		}else if(StringUtils.isNotBlank(id)){
					flag=false;
				}else flag=true;
		while(it.hasNext()) {
			TEdwCorePayAcc obj =(TEdwCorePayAcc) it.next();
			TreeNode n = this.convert(obj);
			list.add(n);
			flag=false;
		}
		//list = buildTree(list, rootBrcode);
		if(flag==true){
			String QuerySql="select t.CORE_CUSTOMER_NUM  from T_ODS_CMS_CUSTOMER_RELATION t where 1=1 and t.CUSTOMER_NUM= '"+customerNum+"'";
			
			Iterator<String> itnum=rootdao.queryBySQL(QuerySql);
			while(itnum.hasNext()){
				TreeNode root = new TreeNode();
				root.setHasChild(true);
				String temp=itnum.next();
				root.setId(temp);
				root.setText(temp);
				root.setPid("");
				list.add(root);
			}
			flag=false;
		}
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
	private TreeNode convert(final TEdwCorePayAcc obj) {
		TreeNode node = new TreeNode();
		node.setCanSelected(true);
		node.setId(StringUtils.strip(obj.getMembCustAc()));
		if(obj.getAcctType()!=null&&obj.getIntCat()!=null){
			JdbcTemplate jt=(JdbcTemplate) ApplicationContextUtils.getBean("JdbcTemplate");
			String sql="select l.BRNAME from BCTL l where l.BRCODE='"+obj.getBranchNo()+"'";
			List<Map<String, Object>> list=jt.queryForList(sql);
			String brname="未知";
			if(list.size()>0&&list.get(0)!=null){
				brname=(String) list.get(0).get("BRNAME");
			}
			String sql1="SELECT C.DATA_NO AS DATANO,C.DATA_TYPE_NAME AS DATATYPENAME,C.DATA_NAME AS DATANAME FROM DATA_DIC C WHERE C.DATA_TYPE_NO='227' AND C.DATA_NO='"+obj.getIntCat()+"' AND C.DATA_TYPE_NAME='"+obj.getAcctType()+"'";
			List<Map<String, Object>> list1=jt.queryForList(sql);
			if("3201".equals(obj.getAcctType())&&"0101".equals(obj.getIntCat())){
				node.setText("<span style='font-weight:600' title='"+brname+" 人民币活期基本户'>"+obj.getMembCustAc()+"</span>");
			}else if("3201".equals(obj.getAcctType())&&"0102".equals(obj.getIntCat())){
				node.setText("<span style='font-weight:600' title='"+brname+" 人民币活期一般户'>"+obj.getMembCustAc()+"</span>");
			}else if(obj.getAcctType().equals("3201")&&obj.getIntCat().equals("0106")){
				node.setText("<span style='font-weight:600' title='"+brname+" 人民币活期基本户（不计息）'>"+obj.getMembCustAc()+"</span>");
			}else if(obj.getAcctType().equals("3201")&&obj.getIntCat().equals("0107")){
				node.setText("<span style='font-weight:600' title='"+brname+" 人民币活期一般户（不计息）'>"+obj.getMembCustAc()+"</span>");
			}else if(obj.getAcctType().equals("3203")&&obj.getIntCat().equals("0101")){
				node.setText("<span style='font-weight:600' title='"+brname+" 人民币收入监管'>"+obj.getMembCustAc()+"</span>");
			}else if(obj.getAcctType().equals("3203")&&obj.getIntCat().equals("0102")){
				node.setText("<span style='font-weight:600' title='"+brname+" 人民币支出监管'>"+obj.getMembCustAc()+"</span>");
			}else if(obj.getAcctType().equals("3203")&&obj.getIntCat().equals("0103")){
				node.setText("<span style='font-weight:600' title='"+brname+" 人民币收支监管'>"+obj.getMembCustAc()+"</span>");
			}else{
				node.setText(obj.getMembCustAc());
			}
		}else{
			node.setText(obj.getMembCustAc());
		}
		node.setHasChild(false);
		node.setPid(obj.getCustomerNo());
		node.setAttributes(obj);
		node.setIconCls("icon-search");
		return node;
	}
}
