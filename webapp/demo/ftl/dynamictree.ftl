<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="动态树预览">
<div style='color:red;padding:5px;border:1px solid #999;width:90%'>
	 同步树：不需要设置hasChild属性，建议带复选框树且节点较多使用该树</br>
	 同步树前端渲染（2.6以前版本支持）：效率较慢，树节点建议500以内，后台直接返回list&lt;TreeNode&gt;即可</br>
	 同步树后端渲染（2.6版本开始支持）：由后端渲染生成html，效率较高，（1500 IE8-2秒左右），返回前调用genTreeHTML(list);（岗位权限设置采用该功能）</br></br>
	异步树：需要自己查询是否有hasChild属性，后台写法需注意</br>
	异步树前端渲染（2.6以前版本支持）：效率较高，每次只返回当前层节点，前端点击时触发加载并渲染下一层节点</br>
	 异步树后端渲染（2.6版本开始支持）：效率最高，每次只返回当前层节点，由后端渲染生成html，前端点击时触发加载并后端渲染html返回前端
</div>
<br/>
<#assign result = "[{'id':1,'text':'delete','seperator':false,'iconCls':'','attributes':'','href':'','children':[]}]">
<@CommonQueryMacro.MenuItem id="mm" json=result />
<@CommonQueryMacro.CommonQuery id="TreeNode" init="true" submitMode="current" navigate="false">
<@CommonQueryMacro.SimpleButton id="b1" desc="全选" />
<@CommonQueryMacro.SimpleButton id="b2" desc="全不选" />
<@CommonQueryMacro.SimpleButton id="b3" desc="获取选中节点" />
<@CommonQueryMacro.SimpleButton id="b4" desc="刷新选中的节点" />
<@CommonQueryMacro.DynamicTree id="tree1" contextmenu="mm" checkbox="true"/>
<#-- mode="static" 后端渲染配置属性-->

</@CommonQueryMacro.CommonQuery>
<script>
function Menu_mm_onClick(item, data) {
	var t = data.tree;
	var n = data.node;
	DynamicTree_tree1.remove(n.id);
}
function b1_onClick(){
	DynamicTree_tree1.selectAll();
}
function b2_onClick(){
	DynamicTree_tree1.unSelectAll();
}
function b3_onClick(){
	alert(DynamicTree_tree1.getChecked());
}
function b4_onClick(){
	var n = DynamicTree_tree1.getSelected();
	if(n) {
		DynamicTree_tree1.refresh(n.id);
	} else {
		alert("请选择");
	}
}

function DynamicTree_tree1_beforeExpandNode(_target, node){
	//alert(node.status); 0表示未选中 1表示选中 2表示半选中
	TreeNode_dataset.setParameter('paramChk',node.checked);
	return true;
}



</script>
</@CommonQueryMacro.page>