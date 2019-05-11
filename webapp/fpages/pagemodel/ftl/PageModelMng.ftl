<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<@CommonQueryMacro.page title="页面管理">

<@CommonQueryMacro.LayoutPanel id="cc" >
	<@CommonQueryMacro.LayoutWest width="200" split="false">
	   <#assign result = "[{'id':1,'text':'新增','seperator':false,'iconCls':'','attributes':'','href':'','children':[]},{'id':2,'text':'编辑','seperator':false,'iconCls':'','attributes':'','href':'','children':[]},{'id':3,'text':'删除','seperator':false,'iconCls':'','attributes':'','href':'','children':[]}]">
	   <#assign contextMenuResult = "[{'id':1,'text':'新增','seperator':false,'iconCls':'','attributes':'','href':'','children':[]}]">
	   <@CommonQueryMacro.MenuItem id="cmm" json=contextMenuResult/>
       <@CommonQueryMacro.ContextMenu menuref="cmm" />
       <@CommonQueryMacro.MenuItem id="mm" json=result />
       <@CommonQueryMacro.CommonQuery id="PageTree" init="true" submitMode="allchange">
	     <@CommonQueryMacro.DynamicTree id="tree" contextmenu="mm" checkbox="false" />
	          <@CommonQueryMacro.Button id="btNew" />
	          <@CommonQueryMacro.Button id="pbtDel" />
	   </@CommonQueryMacro.CommonQuery>
	</@CommonQueryMacro.LayoutWest>
	<@CommonQueryMacro.LayoutCenter>
	      <iframe id="main" src="" style="width:100%;height:100%"></iframe>
	 <@CommonQueryMacro.CommonQuery id="PageTree" init="false" submitMode="allchange" >
	       <@CommonQueryMacro.FloatWindow id="piFW" label="" width="600" height="300"  >
           <table width="100%">
             <tr>
               <td>
			<@CommonQueryMacro.Group id ="pigroup" label="页面详情"  fieldStr="id,name,descInfo,type,status" colNm=2/>
		       </td>
		     </tr>
		     <tr>
		        <td align="center">
		           <@CommonQueryMacro.Button id="btSave" />
		           &nbsp;&nbsp;&nbsp;&nbsp;
		           <@CommonQueryMacro.Button id="btCancel" />
		        </td>
		      </tr>  
		   </table>    
		</@CommonQueryMacro.FloatWindow>
	</@CommonQueryMacro.CommonQuery>
	</@CommonQueryMacro.LayoutCenter>
</@CommonQueryMacro.LayoutPanel>

<script language="JavaScript">
   
 function Menu_mm_onClick(item, data) {
   if(item.id=="3"){
      delPage(data);
   }else  if(item.id=="1"){
      addPage(data);
   }else if(item.id=="2"){
  	  updatePage(data); 
   }
}
function Menu_cmm_onClick(node){
   addPage();
}
 function DynamicTree_tree_onSelect(tree,node){
    var icon=node.iconCls;
    var id=node.id;
    if(icon=="icon-side-list"){
        $("#main").attr("src",_application_root+"/fpages/pagemodel/ftl/PageItemMng.ftl?typeid="+id);    
    }else if(icon=="icon-development"){
        $("#main").attr("src",_application_root+"/fpages/pagemodel/ftl/PageOptMng.ftl?typeid="+id);    
    }    
 }
 
 function delPage(data){
   easyMsg.confirm("确认删除，将无法恢复?",function(){
       DynamicTree_tree.remove(data.node.id);
       PageTree_dataset.setParameter("op","del");
	   $("#btDel").click();
   },function(){}
   );
 }
 
 function updatePage(data){
	 PageTree_dataset.setRecord(data.node.attributes.record);
       subwindow_piFW.show(); 
 }
 
 function addPage(data){
 	if(data){
 	    var pid=data.node.id;
 	    PageTree_dataset.setParameter("op","add");
 	    PageTree_dataset.setValue("parent",pid);
 	    PageTree_dataset.setFieldReadOnly("type",false);
 	}else{
 		PageTree_dataset.setParameter("op","add");
 	    PageTree_dataset.setValue("parent","0");
 	    PageTree_dataset.setValue("type","0");
 	    PageTree_dataset.setFieldReadOnly("type",true);
 	}
 	subwindow_piFW.show();    
 	PageTree_dataset.setValue("status","1");
 }
 var piFW_flag=true;
 function piFW_floatWindow_afterClose(win){
    if(piFW_flag){
      piFW_floatWindow_afterHide();
    }   	       
  }
 function piFW_floatWindow_afterHide(win){
     PageTree_dataset.cancelRecord();
  }
 function btSave_onClickCheck(){
     piFW_flag=false;
     PageTree_dataset.setParameter("id", PageTree_dataset.getValue("parent"));
     PageTree_dataset.setParameter("name", PageTree_dataset.getValue("name"));
     PageTree_dataset.setParameter("descInfo", PageTree_dataset.getValue("descInfo"));
     PageTree_dataset.setParameter("type", PageTree_dataset.getValue("type"));
     PageTree_dataset.setParameter("status", PageTree_dataset.getValue("status"));
 } 
 function btCancel_onClick(button){
 	PageTree_dataset.cancelRecord();
 	subwindow_piFW.close();
 	piFW_flag=true;
 }
  function btSave_postSubmit(){
      subwindow_piFW.close();
      piFW_flag=true;
      DynamicTree_tree.refresh();
  }
</script>
</@CommonQueryMacro.page>