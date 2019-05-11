<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="机构信息维护">
 <@CommonQueryMacro.LayoutPanel id="cc" >
    <@CommonQueryMacro.LayoutCenter title="">
      <@CommonQueryMacro.CommonQuery id="ButtonMng" init="true" submitMode="current">
				 <@CommonQueryMacro.DataTable id="datatable2" title="禁用按钮列表"  toolbar="mytoolbar"  fieldStr="datasetName,id,desc"  />
	  </@CommonQueryMacro.CommonQuery>
	  <br/>
  </@CommonQueryMacro.LayoutCenter>
  <@CommonQueryMacro.LayoutWest title="页面" width="300" split="true" >    	
        <@CommonQueryMacro.CommonQuery id="PagePath" init="false" submitMode="current" navigate="false">
			<@CommonQueryMacro.DynamicTree id="tree1" />
		</@CommonQueryMacro.CommonQuery>
  </@CommonQueryMacro.LayoutWest>
 </@CommonQueryMacro.LayoutPanel>

<script language="javascript">



function DynamicTree_tree1_onSelect(tree,node){
	ButtonMng_dataset.setParameter("funcId",node.id);
	ButtonMng_dataset.setParameter("op","click");
	ButtonMng_dataset.flushData();
}
function DynamicTree_tree1_onSelect(tree,node){	
	var record=node.attributes.record;
	if(record.getValue("_hasChild_")=="false"){
		var pageName=record.getValue("text");
		var d=null;
		dwr.engine.setAsync(false);
		PrivAction.getPagePath(pageName,function(data){
			d=data;
			ButtonMng_dataset.setParameter("url",d);
	//		ButtonMng_dataset.setParameter("op","click");
			ButtonMng_dataset.flushData();
			return true;
        });
		dwr.engine.setAsync(true);		
	}else{
		return false;
	}
	
}

function dropDown_onGetRecord() {
	return ButtonMng_dataset.record;
}

</script>
</@CommonQueryMacro.page>