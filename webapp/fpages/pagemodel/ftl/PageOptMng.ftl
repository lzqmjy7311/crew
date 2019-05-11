<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<#assign st="${RequestParameters['typeid']}" />
<@CommonQueryMacro.page title="页面功能组件项">
<div style="width:100%">
<@CommonQueryMacro.CommonQuery id="PageOptItem" init="true" submitMode="current">
 <br/>
         <@CommonQueryMacro.Button id="ibtNew1"  /> <@CommonQueryMacro.Button id="ibtDel"  />   <@CommonQueryMacro.Button id="ibtEdit"  /> 
         <br/> <br/>
       	 <@CommonQueryMacro.DataTable id="datatable1"  paginationbar="" fieldStr="select,name,descInfo,viewtype,status"  />
       	  <@CommonQueryMacro.FloatWindow id="piFW" label="" width="500" height="300"  >
           <tabl width="100%"e>
             <tr>
               <td>
			<@CommonQueryMacro.Group id ="pigroup" label="页面功能组件项详情" fieldStr="name,descInfo,viewtype,status" colNm=2/>
		       </td>
		     </tr>
		     <tr>
		        <td align="center" id="d2">
		        <@CommonQueryMacro.Button id="ibtSave"  />
		        </td>
		      </tr>  
		   </table>    
		</@CommonQueryMacro.FloatWindow>
</@CommonQueryMacro.CommonQuery>
<br/>
<@CommonQueryMacro.CommonQuery id="PageOptDetail" init="false" submitMode="current">
<br/>
         <@CommonQueryMacro.Button id="btNew1"  /> <@CommonQueryMacro.Button id="btDel"  />   <@CommonQueryMacro.Button id="btEdit"  />  <@CommonQueryMacro.SimpleButton id="btUp" desc="上移" />  <@CommonQueryMacro.SimpleButton id="btDown"  desc="下移"/> 
        <@CommonQueryMacro.Button id="btSaveSort"  /> 
         <br/> <br/>
       	 <@CommonQueryMacro.DataTable id="datatable2"  paginationbar="" fieldStr="select,name,descInfo,operation,optClazz,defaultCqid,status"  />
           <@CommonQueryMacro.FloatWindow id="pdFW" label="" width="500" height="400"  >
           <table width="100%">
             <tr>
               <td>
			<@CommonQueryMacro.Group id ="pigroup" label="组合页面明细项列表" labelwidth="150" fieldStr="name,descInfo,operation,optClazz,optScript,defaultCqid,status,icon" colNm=2/>
		       </td>
		     </tr>
		     <tr>
		        <td align="center" id="pigroupbutton">
		        <@CommonQueryMacro.Button id="btSave"  />
		        </td>
		      </tr>  
		   </table>    
		</@CommonQueryMacro.FloatWindow>
</@CommonQueryMacro.CommonQuery>
</div>
<script language="JavaScript">
    function ibtNew1_onClickCheck(){
      $("#d2").css("display","");
      PageOptItem_dataset.setParameter("op","add");
       subwindow_piFW.show();    
    }
    var piFW_flag=true;
   	function piFW_floatWindow_afterClose(win){
   	       if(piFW_flag){
             piFW_floatWindow_afterHide();
           }   	       
		}
    function piFW_floatWindow_afterHide(win){
    		PageOptItem_dataset.cancelRecord();
    		poiReadStatus(false);
		}
    function ibtSave_onClickCheck(){
        PageOptItem_dataset.setValue("typeid","${st}");
        piFW_flag=false;  
    }
    function ibtSave_postSubmit(button){
       subwindow_piFW.close();
       piFW_flag=true;
       PageOptItem_dataset.flushData();   
    }	
    function ibtDel_onClickCheck(){
    	 var select=getSelect(PageOptItem_dataset);
    	 if(!select){
    		 alert("请勾选需要删除的记录。")
    		 return false;
    	 }
    	 PageOptItem_dataset.setParameter("op","del");
    	 PageOptItem_dataset.setParameter("delStr",select);
    }	
    function ibtDel_postSubmit(button){
       PageOptItem_dataset.flushData();
    }	
    function PageOptItem_dataset_afterScroll(dataset) {
         PageOptDetail_dataset.setParameter("parentid",dataset.getValue("id"));
         PageOptDetail_dataset.flushData();
    }
    <!-- pageoptdetail-->
    function btNew1_onClick(){
    	 PageOptDetail_dataset.setParameter("op","add");
        $("#pigroupbutton").css("display","");
         subwindow_pdFW.show();    
    }
      var pdFW_flag=true;
   	function pdFW_floatWindow_afterClose(win){
   	       if(pdFW_flag){
             pdFW_floatWindow_afterHide();
           }   	       
		}
    function pdFW_floatWindow_afterHide(win){
    		PageOptDetail_dataset.cancelRecord();
    		podReadStatus(false);
		}
    function btSave_onClickCheck(){
        PageOptDetail_dataset.setValue("parent",PageOptItem_dataset.getValue("id"));
        pdFW_flag=false;      
    }
    function btSave_postSubmit(button){
       subwindow_pdFW.close();
       pdFW_flag=true;
      /*  PageOptDetail_dataset.setParameter("parentid",dataset.getValue("id"));
       PageOptDetail_dataset.flushData();     */
    }	
     function btDel_onClickCheck(){
    	 var select=getSelect(PageOptDetail_dataset);
    	 if(!select){
    		 alert("请勾选需要删除的记录。")
    		 return false;
    	 }
    	 PageOptDetail_dataset.setParameter("op","del");
    	 PageOptDetail_dataset.setParameter("delStr",select);
    }	
     function btDel_postSubmit(button){
       PageOptDetail_dataset.flushData();
    }	
    
     function podReadStatus(flag){
         PageOptDetail_dataset.setFieldReadOnly("name",flag);
         PageOptDetail_dataset.setFieldReadOnly("descInfo",flag);
         PageOptDetail_dataset.setFieldReadOnly("operation",flag);
         PageOptDetail_dataset.setFieldReadOnly("optClazz",flag);
         PageOptDetail_dataset.setFieldReadOnly("optScript",flag);
         PageOptDetail_dataset.setFieldReadOnly("defaultCqid",flag);
         PageOptDetail_dataset.setFieldReadOnly("parent",flag);
         PageOptDetail_dataset.setFieldReadOnly("seqid",flag);
         PageOptDetail_dataset.setFieldReadOnly("status",flag);
    } 
     function poiReadStatus(flag){
         PageOptItem_dataset.setFieldReadOnly("name",flag);
         PageOptItem_dataset.setFieldReadOnly("descInfo",flag);
         PageOptItem_dataset.setFieldReadOnly("viewtype",flag);
         PageOptItem_dataset.setFieldReadOnly("typeid",flag);
         PageOptItem_dataset.setFieldReadOnly("status",flag);
    } 
     
    function datatable2_name_onRefresh(cell,value,record){
       if (record) {
		 cell.innerHTML="<a href='JavaScript:showDetail2(\""+record.getValue('id')+"\")'>"+value+"</a>";
	   } else { 
		 cell.innerHTML="&nbsp;";
	   }
    }
     function datatable1_name_onRefresh(cell,value,record){
       if (record) {
		 cell.innerHTML="<a href='JavaScript:showDetail1(\""+record.getValue('id')+"\")'>"+value+"</a>";
	   } else { 
		 cell.innerHTML="&nbsp;";
	   }
    }
    /*  function datatable1_status_onRefresh(cell,value,record){
       if (record) {
		 cell.innerHTML=record.getValue("statusName");
	   } else { 
		 cell.innerHTML="&nbsp;";
	   }
    } */
    function showDetail2(id){
      podReadStatus(true);
      $("#pigroupbutton").css("display","none");
      subwindow_pdFW.show();
    }
    function showDetail1(id){
      poiReadStatus(true);
      $("#d2").css("display","none");
      subwindow_piFW.show();
    }
    
    function ibtEdit_onClickCheck(){
        $("#d2").css("display","");
        PageOptItem_dataset.setParameter("op","update");
        subwindow_piFW.show();    
   }
    function btEdit_onClickCheck(){
        $("#d2").css("display","");
        PageOptDetail_dataset.setParameter("op","update");
        subwindow_pdFW.show();    
   }
    function btSaveSort_postSubmit(button){
    	PageDetailMng_dataset.setParameter("op","");
    }
    function btSaveSort_onClickCheck(){
    	var keys=sortMap.keys();
    	var sortStr="";
    	for(var i=0;i<keys.length;i++){
    		if(i==0){
    		    sortStr=keys[i]+","+sortMap.get(keys[i]);
    		}else{
    	    	sortStr=sortStr+";"+keys[i]+","+sortMap.get(keys[i]);
    		}
    	}
    	PageOptDetail_dataset.setParameter("op","sort");
    	PageOptDetail_dataset.setParameter("sortStr",sortStr);
    }
    //上移
    function btUp_onClick(){
    	var curRecord=PageOptDetail_dataset.record;
    	if(curRecord){
        	var prevRecord=curRecord.getPrevRecord();
    	    recordChange(PageOptDetail_dataset,curRecord,prevRecord);
    	    if(prevRecord){
    	    	PageOptDetail_dataset.setRecord(prevRecord);
      	   }
    	}
    }
    //下移
    function btDown_onClick(){
    	var curRecord=PageOptDetail_dataset.record;
    	if(curRecord){
        	var nextRecord=curRecord.getNextRecord();
        	recordChange(PageOptDetail_dataset,curRecord,nextRecord);
        	if(nextRecord){
        		PageOptDetail_dataset.setRecord(nextRecord);
        	}
    	}
    }
    
    var sortMap=new Map();
    function recordChange(dataset,leftRecord,rightRrecord){
    	if(leftRecord&&rightRrecord){
    		sortMap.put(leftRecord.getValue('id'),rightRrecord.getValue('seqid'));
    		sortMap.put(rightRrecord.getValue('id'),leftRecord.getValue('seqid'));
    		for(var i=0; i<dataset.fields.fieldCount; i++){
    			var fieldName=dataset.getField(i).name;
    			var field=leftRecord.dataset.getField(fieldName);
    			if (field) {
    				var leftValue=leftRecord.getValue(fieldName);
    				var rightValue=rightRrecord.getValue(fieldName);
    				var mValue;
    				if (fieldName!='seqid'&&typeof(leftValue)!="undefined"&&typeof(rightValue)!="undefined") {
    					leftRecord.setValue(fieldName, rightValue);
    					rightRrecord.setValue(fieldName,leftValue);
    				}
    			}
    		}
    	}
    }
    function getSelect(dataset){
    	var record=dataset.getFirstRecord();
    	var selectStr="";
    	while(record){
    		var value=record.getValue("select");
    		if(value=="true"){
    			selectStr=selectStr+";"+record.getValue("id");
    		}
    		record=record.getNextRecord();
    	}
    	return selectStr;
    }
</script>
</@CommonQueryMacro.page>