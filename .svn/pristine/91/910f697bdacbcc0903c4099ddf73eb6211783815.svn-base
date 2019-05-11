<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="定时任务">
<@CommonQueryMacro.CommonQuery id="jobschedulermanage" init="true" >
   <table align="left" width="100%">
        <tr>
      		<td valign="top" width="100%">
      			<@CommonQueryMacro.DataTable id ="datatable1" fieldStr="jobNo,desc0,isRunning,runTime,dayOfMonth,startTime,endTime,repeatCNT,repeatInterval,processFunc" 
      			  paginationbar="btAdd,-,btMod,-,btDel,-,btSave"
      		   	readonly="true" /></br>
      		</td>
      	</tr>
        <tr>
      	    <td align="center">
      	      	<@CommonQueryMacro.FloatWindow id="detailFW" label="" show="false" defaultZoom="normal" closure="false">
			 	      <@CommonQueryMacro.Group id="group2" label="定时任务配置属性" colNm="4" fieldStr="jobNo,desc0,runTime,dayOfMonth,startTime,endTime,repeatCNT,repeatInterval,processFunc" />
			          <div align="center">
			             <@CommonQueryMacro.Button id="btConfim"/> 
			             <@CommonQueryMacro.Button id="btCancel"/> 
			          </div>
			    </@CommonQueryMacro.FloatWindow>
		    </td>
		</tr>
</table>
</@CommonQueryMacro.CommonQuery>
 <script language="javascript">
 
  function btAdd_onClickCheck(button){
		jobschedulermanage_dataset.setFieldReadOnly('jobNo', false);
      	subwindow_detailFW.show();
  }
   function btMod_onClickCheck(button){
		jobschedulermanage_dataset.setFieldReadOnly('jobNo', true);
      	subwindow_detailFW.show();
  } 
  function btCancel_onClickCheck(button){
     jobschedulermanage_dataset.cancelRecord();
     subwindow_detailFW.close();
  }  
  function detailFW_floatWindow_beforeShow(fw) {
  	var runTime = jobschedulermanage_dataset.getValue("runTime");
	if(runTime=="97"){
	  jobschedulermanage_dataset.setFieldRequired('dayOfMonth',true);
	  jobschedulermanage_dataset.setFieldReadOnly('dayOfMonth',false);
	}else{
	  jobschedulermanage_dataset.setFieldRequired('dayOfMonth',false);
	  jobschedulermanage_dataset.setFieldReadOnly('dayOfMonth',true);
	}
  }
  function detailFW_floatWindow_afterHide(fw) {
       jobschedulermanage_dataset.cancelRecord();
  }

 function btSave_postSubmit(button){
     //subwindow_detailFW.close();
     jobschedulermanage_dataset.flushData(jobschedulermanage_dataset.pageIndex);
 }
 function btConfim_onClickCheck(button){
    if(jobschedulermanage_dataset.validate()) subwindow_detailFW.close(); 
 }
 function runTime_DropDown_onSelect(dropDown,record,editor){
	    if(record[0]=="97"){
	      jobschedulermanage_dataset.setFieldRequired('dayOfMonth',true);
	      jobschedulermanage_dataset.setFieldReadOnly('dayOfMonth',false);
	    }else{
	  	  jobschedulermanage_dataset.setFieldRequired('dayOfMonth',false);
	      jobschedulermanage_dataset.setFieldReadOnly('dayOfMonth',true);
	    }  
	    return true;
 }
</script>
</@CommonQueryMacro.page>
