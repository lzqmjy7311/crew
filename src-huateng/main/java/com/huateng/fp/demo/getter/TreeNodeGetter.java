package com.huateng.fp.demo.getter;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.bean.TreeNode;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;
import com.huateng.fp.demo.bean.NodeAttribute;

public class TreeNodeGetter extends BaseGetter {
	/**
	 * 同步树：不需要设置hasChild属性，建议带复选框树且节点较多使用该树
	 * 
	 * 同步树前端渲染（2.6以前版本支持）：效率较慢，树节点建议500以内，后台直接返回list<TreeNode>即可
	 * 
	 * 同步树后端渲染（2.6版本开始支持）：由后端渲染生成html，效率较高，（1500 IE8-2秒左右），返回前调用genTreeHTML(list);
	 * （岗位权限设置采用该功能）
	 * 
	 * 异步树：需要自己查询是否有hasChild属性，后台写法需注意
	 * 
	 * 异步树前端渲染（2.6以前版本支持）：效率较高，每次只返回当前层节点，前端点击时触发加载并渲染下一层节点
	 * 
	 * 异步树后端渲染（2.6版本开始支持）：效率最高，每次只返回当前层节点，由后端渲染生成html，前端点击时触发加载并后端渲染html返回前端
	 */
	
	private static List<TreeNode> treeList = new ArrayList<TreeNode>(){
		{
			TreeNode node = new TreeNode();
            node = new TreeNode();
            node.setId("1");
            node.setText("总体使用情况");
            add(node);

            node = new TreeNode();
            node.setId("2");
            node.setText("被选中的目录");
            node.setChecked(true);
            add(node);

            node = new TreeNode();
            node.setId("3");
            node.setText("带图标目录");
            node.setIconCls("icon-add");
            add(node);
            
            TreeNode node1 = new TreeNode();
            node1.setId("11");
            node1.setText("子目录1");
            node1.setPid("1");
            add(node1);

            node1 = new TreeNode();
            node1.setId("12");
            node1.setText("子目录2");
            node1.setPid("1");
            add(node1);

            node1.setId("21");
            node1.setText("子目录3");
            node1.setChecked(true);
            node1.setPid("2");
            add(node1);

            node1 = new TreeNode();
            node1.setId("22");
            node1.setText("子目录4");
            node1.setPid("2");
            add(node1);
            
            TreeNode node2 = new TreeNode();
            node2.setId("221");
            node2.setText("子目录4-1-URL有图标");
            node2.setIconCls("icon-add");
            node2.setPid("22");
            NodeAttribute otherAttr = new NodeAttribute();
            otherAttr.setUrl("/demo/ftl/textinput_tab.ftl");
            node2.setAttributes(otherAttr);
            add(node2);

            node2 = new TreeNode();
            node2.setId("222");
            node2.setText("子目录4-1-URL");
            otherAttr = new NodeAttribute();
            otherAttr.setUrl("/demo/ftl/datagrid_default_tab.ftl");
            node2.setAttributes(otherAttr);
            node2.setPid("22");
            add(node2);

            node2 = new TreeNode();
            node2.setId("223");
            node2.setText("子目录4-2");
            node2.setPid("22");
            add(node2);
		}
	};
	
    @Override
    public Result call() throws AppException {
        List<TreeNode> list = new ArrayList<TreeNode>();

        String id = getCommQueryServletRequest().getParameter("id");
        String pck = getCommQueryServletRequest().getParameter("paramChk");
        //list = initStaticDataAll();//同步树前端渲染
        list = initStaticDataAysc(id);//异步树，前端渲染
        
        //genTreeHTML(list);//后端渲染，同步、异步均支持，必须在此处调用，前端必须配置属性mode="static"
        //<@CommonQueryMacro.DynamicTree id="tree1"  checkbox="true" mode="static"/>
        
        ResultMng.fillResultByList(getCommonQueryBean(), getCommQueryServletRequest(), list, getResult());
        result.setContent(list);
        result.getPage().setTotalPage(1);
        result.init();
        return result;
    }

    public List<TreeNode> initStaticDataAysc(String id) {// 异步方式

        List<TreeNode> list = new ArrayList<TreeNode>();
        if (StringUtils.isBlank(id)) {//为空查询第一级
        	for (TreeNode treeNode : treeList) {
				if(StringUtils.isEmpty(treeNode.getPid())){
					treeNode.setHasChild(this.isHashChild(treeNode.getId()));
					list.add(treeNode);
				}
			}
        }else{
        	for (TreeNode treeNode : treeList) {
				if(StringUtils.isNotBlank(treeNode.getPid()) && StringUtils.equals(id, treeNode.getPid())){
					treeNode.setHasChild(this.isHashChild(treeNode.getId()));
					list.add(treeNode);
				}
			}
        }
        return list;
    }
    
    private boolean isHashChild(String id){
    	boolean bl = false;
    	for (TreeNode treeNode : treeList) {
    		if(StringUtils.isNotBlank(treeNode.getPid()) && StringUtils.equals(id, treeNode.getPid())){
    			bl = true;
    			break;
    		}
    	}
    	return bl;
    }
    

    public List<TreeNode> initStaticDataAll() {// 同步方式
        return treeList;
    }
}
