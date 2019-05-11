package com.huateng.fp.demo.getter;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;

import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.bean.MenuItem;
import com.huateng.ebank.business.common.bean.TreeNode;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;
import com.huateng.fp.demo.bean.NodeAttribute;

public class AccordionMenuGetter extends BaseGetter {


	@Override
	public Result call() throws AppException {
		List<TreeNode> list = new ArrayList<TreeNode>();
		list = initStaticData().getChildren();

		ResultMng.fillResultByList(getCommonQueryBean(), getCommQueryServletRequest(), list, getResult());
		result.setContent(list);
		result.getPage().setTotalPage(1);
		result.init();
		return result;
	}
	
	public static String getContextMenuString() {
		 MenuItem root = new MenuItem();
	        root.setId("0");
	        root.setText("root");
	        
	        String otherAttr = "a=1";
	        
	        
	        MenuItem node = new MenuItem();
	        node.setId("1");
	        node.setText("菜单一");
	        node.appendTo(root);
	        
	        MenuItem node1 = new MenuItem();
	        node1.setId("11");
	        node1.setText("子菜单1");
	        node1.appendTo(node);
	        
	        node1 = new MenuItem();
	        node1.setId("12");
	        node1.setText("子菜单2");
	        node1.appendTo(node);
	        
	        node = new MenuItem();
	        node.setId("2");
	        node.setText("菜单二");
	        node.appendTo(root);
	        
	        node1 = new MenuItem();
	        node1.setId("21");
	        node1.setText("子菜单3");
	        node1.appendTo(node);
	        
	        node1 = new MenuItem();
	        node1.setId("22");
	        node1.setText("子菜单4");
	        node1.appendTo(node);
	        
	        MenuItem node2 = new MenuItem();
	        node2.setId("221");
	        node2.setText("子菜单4-1-URL有图标");
	        node2.setIconCls("icon-add");
	        node2.appendTo(node1);
	        node2.setAttributes(otherAttr);
	        
	        node2 = new MenuItem();
	        node2.setId("222");
	        node2.setText("子菜单4-1-URL");
	        node2.setAttributes(otherAttr);
	        node2.appendTo(node1);
	        
	        node2 = new MenuItem();
	        node2.setId("223");
	        node2.setText("子菜单4-2");
	        node2.appendTo(node1);
	        
	        node = new MenuItem();
	        node.setId("3");
	        node.setText("带图标菜单");
	        node.setIconCls("icon-add");
	        node.appendTo(root);
	        
		String res = JSONArray.fromObject(root.getChildren()).toString();
		System.out.println(res);
		return res;
	}
	
	
    public TreeNode initStaticData() {
        TreeNode root = new TreeNode();
        root.setId("0");
        root.setText("root");
        
        NodeAttribute otherAttr = new NodeAttribute();
        
        
        TreeNode node = new TreeNode();
        node.setId("1");
        node.setText("目录一");
        node.appendTo(root);
        
        TreeNode node1 = new TreeNode();
        node1.setId("11");
        node1.setText("子目录1");
        node1.appendTo(root);
        node1.setPid(node.getId());
        
        node1 = new TreeNode();
        node1.setId("12");
        node1.setText("子目录2");
        node1.appendTo(root);
        node1.setPid(node.getId());
        
        node = new TreeNode();
        node.setId("2");
        node.setText("目录二");
        node.appendTo(root);
        
        node1 = new TreeNode();
        node1.setId("21");
        node1.setText("子目录3");
        node1.appendTo(root);
        node1.setPid(node.getId());
        
        node1 = new TreeNode();
        node1.setId("22");
        node1.setText("子目录4");
        node1.appendTo(root);
        node1.setPid(node.getId());
        
        TreeNode node2 = new TreeNode();
        node2.setId("221");
        node2.setText("子目录4-1-URL有图标");
        node2.setIconCls("icon-add");
        node2.appendTo(root);
        node2.setPid(node1.getId());
        otherAttr = new NodeAttribute();
        otherAttr.setUrl("/demo/ftl/textinput_tab.ftl");
        node2.setAttributes(otherAttr);
        
        node2 = new TreeNode();
        node2.setId("222");
        node2.setText("子目录4-1-URL");
        otherAttr = new NodeAttribute();
        otherAttr.setUrl("/demo/ftl/datagrid_default_tab.ftl");
        node2.setAttributes(otherAttr);
        node2.appendTo(root);
        node2.setPid(node1.getId());
        
        node2 = new TreeNode();
        node2.setId("223");
        node2.setText("子目录4-2");
        node2.appendTo(root);
        node2.setPid(node1.getId());
        
        node = new TreeNode();
        node.setId("3");
        node.setText("带图标目录");
        node.setIconCls("icon-add");
        node.appendTo(root);
        
        return root;
    }
}
