<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<#assign st="${RequestParameters['typeid']}" />
<@CommonQueryMacro.page title=" ">
<div style="width:100%">
<@CommonQueryMacro.CommonQuery id="PageItemMng" init="true" submitMode="current">
         <br/>
         <@CommonQueryMacro.Button id="ibtNew1"  /> <@CommonQueryMacro.Button id="ibtDel"  />  <@CommonQueryMacro.Button id="ibtEdit"  /> 
         <br/> <br/>
       	 <@CommonQueryMacro.DataTable id="datatable1"  paginationbar="" fieldStr="select,name,descInfo,viewtype,opItemId,status"   />
         <@CommonQueryMacro.FloatWindow id="piFW" label="" width="500" height="300"  >
           <table width="100%">
             <tr>
               <td>
			<@CommonQueryMacro.Group id ="pigroup" labelwidth="150" label="组合页面对象详情" fieldStr="name,descInfo,viewtype,opItemId,status" colNm=2/>
		       </td>
		     </tr>
		     <tr>
		        <td align="center" id="t1">
		        <@CommonQueryMacro.Button id="ibtSave"  />
		        </td>
		      </tr>  
		   </table>    
		</@CommonQueryMacro.FloatWindow>
</@CommonQueryMacro.CommonQuery>
<br/><br/>
<@CommonQueryMacro.CommonQuery id="PageDetailMng" init="false" submitMode="current">
         <br/>
         <@CommonQueryMacro.Button id="btNew1"  />  <@CommonQueryMacro.Button id="btDel"  />  <@CommonQueryMacro.Button id="btEdit"  /> <@CommonQueryMacro.SimpleButton id="btUp"  desc="上移"/>  <@CommonQueryMacro.SimpleButton id="btDown" desc="下移" />
       	 <@CommonQueryMacro.Button id="btSaveSort"  />
       	 <br/> <br/>
       	 <@CommonQueryMacro.DataTable id="datatable2" fitColumns="true"  paginationbar="" fieldStr="select,name,descInfo[150],pagfeUrl[350],status[100],defaultno[150]"  width="100%" hasFrame="true" height="100%" readonly="true"/>
         <@CommonQueryMacro.FloatWindow id="pdFW" label="" width="500" height="400"  >
           <table width="100%">
             <tr>
               <td>
			<@CommonQueryMacro.Group id ="pigroup" label="组合页面明细项列表" fieldStr="name,descInfo,pagfeUrl,paramList,status,optDetails" colNm=2/>
		       </td>
		     </tr>
		     <tr>
		        <td align="center" id="t2">
		        <@CommonQueryMacro.Button id="btSave"  />
		        </td>
		      </tr>  
		   </table>    
		</@CommonQueryMacro.FloatWindow>

</@CommonQueryMacro.CommonQuery>
</div>
<script language="JavaScript">
    function ibtNew1_onClickCheck(){
       $("#t1").css("display","");
       PageItemMng_dataset.setParameter("op","add");
       subwindow_piFW.show();    
    }
   function ibtEdit_onClickCheck(){
       $("#t1").css("display","");
       PageItemMng_dataset.setParameter("op","update");
       subwindow_piFW.show();    
  }
    var piFW_flag=true;
   	function piFW_floatWindow_afterClose(win){
   	       if(piFW_flag){
             piFW_floatWindow_afterHide();
           }   	       
		}
    function piFW_floatWindow_afterHide(win){
    		PageItemMng_dataset.cancelRecord();
    		pageItemMngReadStatus(false);
		}
    function ibtSave_onClickCheck(){
        PageItemMng_dataset.setValue("typeid","${st}");
        piFW_flag=false;  
    }
    function ibtSave_postSubmit(button){
    	PageItemMng_dataset.setParameter("op","");
       subwindow_piFW.close();
       piFW_flag=true;
       PageItemMng_dataset.flushData();   
    }	
    function ibtDel_postSubmit(button){
       PageItemMng_dataset.flushData();
    }	
    function datatable1_name_onRefresh(cell,value,record){
       if (record) {
		 cell.innerHTML="<a href='JavaScript:showDetail(\""+record.getValue('id')+"\")'>"+value+"</a>";
	   } else { 
		 cell.innerHTML="&nbsp;";
	   }
    }
    function showDetail(id){
        pageItemMngReadStatus(true);
        subwindow_piFW.show();
        $("#t1").css("display","none");
    } 
    function pageItemMngReadStatus(flag){
         PageItemMng_dataset.setFieldReadOnly("name",flag);
         PageItemMng_dataset.setFieldReadOnly("descInfo",flag);
         PageItemMng_dataset.setFieldReadOnly("typeid",flag);
         PageItemMng_dataset.setFieldReadOnly("viewtype",flag);
         PageItemMng_dataset.setFieldReadOnly("defaultno",flag);
         PageItemMng_dataset.setFieldReadOnly("opItemId",flag);
         PageItemMng_dataset.setFieldReadOnly("status",flag);
         PageItemMng_dataset.setFieldReadOnly("lastUpdTs",flag);
         PageItemMng_dataset.setFieldReadOnly("lastUpdTlr",flag);
    } 
    function PageItemMng_dataset_afterScroll(dataset) {
         PageDetailMng_dataset.setParameter("parentid",dataset.getValue("id"));
         PageDetailMng_dataset.setParameter("defaultNo",dataset.getValue("defaultno"));
         PageDetailMng_dataset.flushData();
    }
   <!-- pageDetial  -->
    function btNew1_onClick(){
         $("#t2").css("display","");
         PageDetailMng_dataset.setParameter("op","add");
         subwindow_pdFW.show();    
    }
      var pdFW_flag=true;
   	function pdFW_floatWindow_afterClose(win){
   	       if(pdFW_flag){
             pdFW_floatWindow_afterHide();
           }   	       
		}
    function pdFW_floatWindow_afterHide(win){
    		PageDetailMng_dataset.cancelRecord();
    		pageDetailMngReadStatus(false);
		}
    function btSave_onClickCheck(){
        PageDetailMng_dataset.setValue("parent",PageItemMng_dataset.getValue("id"));
        pdFW_flag=false;      
    }
    function btSave_postSubmit(button){
       subwindow_pdFW.close();
       pdFW_flag=true;
       PageDetailMng_dataset.setParameter("parentid",dataset.getValue("id"));
       PageDetailMng_dataset.setParameter("op","");
       PageDetailMng_dataset.flushData();    
    }	
     function btDel_onClickCheck(){
    	 var select=getSelect(PageDetailMng_dataset);
    	 if(!select){
    		 alert("请勾选需要删除的记录。")
    		 return false;
    	 }
    	 PageDetailMng_dataset.setParameter("op","del");
    	 PageDetailMng_dataset.setParameter("delStr",select);
    }	
     function ibtDel_onClickCheck(){
    	 var select=getSelect(PageItemMng_dataset);
    	 if(!select){
    		 alert("请勾选需要删除的记录。")
    		 return false;
    	 }
    	 PageItemMng_dataset.setParameter("op","del");
    	 PageItemMng_dataset.setParameter("delStr",select);
    }	
     function btDel_postSubmit(button){
       PageDetailMng_dataset.flushData();
    }	
    
     function pageDetailMngReadStatus(flag){
         PageDetailMng_dataset.setFieldReadOnly("name",flag);
         PageDetailMng_dataset.setFieldReadOnly("descInfo",flag);
         PageDetailMng_dataset.setFieldReadOnly("pagfeUrl",flag);
         PageDetailMng_dataset.setFieldReadOnly("paramList",flag);
         PageDetailMng_dataset.setFieldReadOnly("status",flag);
         PageDetailMng_dataset.setFieldReadOnly("seqid",flag);
         PageDetailMng_dataset.setFieldReadOnly("optDetails",flag);
    } 
    function datatable2_name_onRefresh(cell,value,record){
       if (record) {
		 cell.innerHTML="<a href='JavaScript:showDetail2(\""+record.getValue('id')+"\")'>"+value+"</a>";
	   } else { 
		 cell.innerHTML="&nbsp;";
	   }
    }
    function datatable2_defaultno_onRefresh(cell,value,record){
        if (record) {
        	if(record.getValue("id")==PageDetailMng_dataset.getParameter("defaultNo")){
        		 cell.innerHTML="<div align='center'><input checked onclick='setDefaultNo(\""+record.getValue('id')+"\")' name='defalutNoRadio' type='radio' ></input></div>";
        	}else{
        		 cell.innerHTML="<div align='center'><input onclick='setDefaultNo(\""+record.getValue('id')+"\")' name='defalutNoRadio' type='radio' ></input></div>";
        	}
 	   } else { 
 		 cell.innerHTML="&nbsp;";
 	   }
     }
    function showDetail2(id){
       pageDetailMngReadStatus(true);
       subwindow_pdFW.show();  
        $("#t2").css("display","none");  
    }
    function btEdit_onClickCheck(){
        $("#t2").css("display","");
        PageDetailMng_dataset.setParameter("op","update");
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
    	PageDetailMng_dataset.setParameter("op","sort");
    	PageDetailMng_dataset.setParameter("sortStr",sortStr);
    }
    //上移
    function btUp_onClick(){
    	var curRecord=PageDetailMng_dataset.record;
    	if(curRecord){
    	   var prevRecord=curRecord.getPrevRecord();
    	   recordChange(PageDetailMng_dataset,curRecord,prevRecord);
    	   if(prevRecord){
    	      PageDetailMng_dataset.setRecord(prevRecord);
    	   }
    	}
    }
    //下移
    function btDown_onClick(){
    	var curRecord=PageDetailMng_dataset.record;
    	if(curRecord){
    	  var nextRecord=curRecord.getNextRecord();
    	  recordChange(PageDetailMng_dataset,curRecord,nextRecord);
    	  if(nextRecord){
    	    PageDetailMng_dataset.setRecord(nextRecord);
    	  }
    	}
    }
    function setDefaultNo(id){
    	PageDetailMng_dataset.setParameter("defaultNo",id);
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