<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>

<@CommonQueryMacro.page title="操作员管理">
	<@CommonQueryMacro.LayoutPanel id="cc" >
	    <@CommonQueryMacro.LayoutCenter title="选择协查人员列表">
			<@CommonQueryMacro.CommonQuery id="SingleRulInvestigationInveUser" init="false" submitMode="current">
				<@CommonQueryMacro.DataTable id ="datatable1" toolbar="mytoolbar" paginationbar="-,btSubmit" fieldStr="tlrno[150],tlrName[200],brname[200]"  readonly="true" width="100%" height="100%" />
			</@CommonQueryMacro.CommonQuery>
			<@CommonQueryMacro.ToolBar id="mytoolbar">
			<div style="text-align:right">
				<@CommonQueryMacro.InterfaceElement elId="qtlrno" />
				<@CommonQueryMacro.InterfaceElement elId="qtlrnoName" />
				<@CommonQueryMacro.InterfaceButton desc="btQuery" />
			</div>
			</@CommonQueryMacro.ToolBar>
	    </@CommonQueryMacro.LayoutCenter>
	    <@CommonQueryMacro.LayoutWest title="机构树" width="200" split="true" >
	    	<@CommonQueryMacro.CommonQuery id="SingleRulInvestigationbranchTree" init="true" submitMode="current" navigate="false">
				<@CommonQueryMacro.DynamicTree id="tree1" />
			</@CommonQueryMacro.CommonQuery>
	    </@CommonQueryMacro.LayoutWest>
	</@CommonQueryMacro.LayoutPanel> 
<script language="javascript">
	var inveOrg=null;
	//左侧机构树点击节点后刷新右侧人员列表
	function DynamicTree_tree1_onSelect(e,node){
		inveOrg=node.id;
		SingleRulInvestigationInveUser_dataset.setParameter('brcode1',node.id);
		SingleRulInvestigationInveUser_interface_dataset.setParameter('brcode1',node.id);
		SingleRulInvestigationInveUser_dataset.flushData(1);
	}
	//确定按钮点击事件
	function btSubmit_onClick(){
		var inveUserId=SingleRulInvestigationInveUser_dataset.getValue("tlrno");
		var tlrName=SingleRulInvestigationInveUser_dataset.getValue("tlrName");
		if(inveOrg==null||inveOrg==""){
			top.easyMsg.info("请选择协查机构！");
			return;
		}
		if(inveUserId==null||inveUserId==""){
			top.easyMsg.info("请选择协查人员！");
			return;
		}else{
			window.parent.SubmitInveOrgAndInveUserId(inveOrg,inveUserId,tlrName);
		}
	}
</script>
</@CommonQueryMacro.page>
