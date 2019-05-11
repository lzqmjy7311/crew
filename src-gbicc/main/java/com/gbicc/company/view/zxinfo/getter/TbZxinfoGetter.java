package com.gbicc.company.view.zxinfo.getter;

/**
 *
 */


import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.huateng.commquery.process.call.BaseCallGetter;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.buttonmng.bean.PagePath;
import com.huateng.ebank.business.common.BaseDAOUtils;
import com.huateng.ebank.business.common.bean.TreeNode;
import com.huateng.ebank.entity.data.mng.FunctionInfo;
import com.huateng.ebank.framework.operation.orm.HQLDAO;
import com.huateng.exception.AppException;
import com.huateng.fp.demo.bean.NodeAttribute;


/**
 * Title: HelloWorldHistoryGetter Description: Copyright: Copyright (c) 2008
 * Company: Shanghai Huateng Software Systems Co., Ltd.
 *
 * @author shen_antonio
 * @version 1.1, 2008-5-26
 */
public class TbZxinfoGetter extends BaseCallGetter {
	
	@Override
	public Result call() throws AppException {
		int totalPage = 1;
		int	isdirectory=0;
		List list = new ArrayList();
		List returnList = new ArrayList();
		 String u= Thread.currentThread().getContextClassLoader().getResource("").getPath().substring(1)+"../..";
		File rootDir = new File(u);
		PagePath rootNode = new PagePath();
		rootNode.setState("open");
		String _id=UUID.randomUUID().toString();
		rootNode.setId(_id);
		convert(rootNode, rootDir,list);
		TreeNode node = null;
//		for (int i = 0; i < list.size(); i++) {
//			PagePath p = (PagePath) list.get(i);
//			node = new TreeNode();
//			node.setAttributes(p);
//			node.setId(p.getId());
//			node.set
//			node.setText(p.getPageName());
//			node.setPid(p.getPid());
//			node.setHasChild(p.isDirectory());
		
			node=new TreeNode();
			node.setId("1");
			node.setText("总体信用情况");
			node.setPid("");
			node.setHasChild(true);
			returnList.add(node);
			
			node=new TreeNode();
			node.setId("2");
			node.setText("查询记录");
			node.setPid("");
			node.setHasChild(true);
			returnList.add(node);
			
			node=new TreeNode();
			node.setId("2");
			node.setText("信用卡");
			node.setPid("");
			node.setHasChild(true);
			returnList.add(node);
//		}
		ResultMng.fillResultByList(getCommonQueryBean(), getCommQueryServletRequest(), returnList, getResult());
		List content = new ArrayList();
		content.add(returnList);
		result.setContent(returnList);
		result.getPage().setTotalPage(totalPage);
		result.init();
		return result;
	}
   
	//解析文件夹，并将其转换成树形结构的List
	private static void convert(PagePath node, File dir, List list) {
		node.setPageName(dir.getName());
		node.setDirectory(dir.isDirectory());
//		if(dir.getName().indexOf(".")!=-1||dir.getName().endsWith(".ftl")){
			list.add(node);
//		}
		if (dir.isDirectory()) {
			File[] foo = dir.listFiles();
			for (File bar : foo) {
				if(!bar.getName().equals("applets")&&!bar.getName().equals("common")&&
						!bar.getName().equals("login")&&!bar.getName().equals("META-INF")&&
						!bar.getName().equals("templets")&&!bar.getName().equals("WEB-INF")&&
						!bar.getName().equals(".svn")&&!bar.getName().equals("xml")&&!bar.getName().equals("dropdownxml")){
					PagePath koo = new PagePath();
					String id=UUID.randomUUID().toString();
					koo.setId(id);
					koo.setPid(node.getId());
					convert(koo, bar, list);
				}
			}
		} else {
			return;
		}
	}
	
}
