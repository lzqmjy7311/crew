<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="��ʱ����">
<@CommonQueryMacro.CommonQuery id="jobmanage" init="true" >
   	<table align="left" width="100%">
       <tr>
      		<td valign="top" width="100%">
      			<@CommonQueryMacro.DataTable id ="datatable1" fieldStr="jobNo,desc0,runTime,isRunning,opr" readonly="true" width="100%" /> 
      		</td>
      	</tr>
      	<tr style="display:none">
      		<td valign="top">
      			<table>
        			<tr align="center">
        		<td>
      				<@CommonQueryMacro.Button id= "btStart"/>
      			</td>
      			<td>
      				<@CommonQueryMacro.Button id= "btStop"/>
      			</td>
      				</tr>
      			</table>
      		</td>
      </tr>
</table>
</@CommonQueryMacro.CommonQuery>
 <script language="javascript">
 <#-- add by henry 20110617 begin-->
function btStart_postSubmit(button){
	alert("�����ɹ���");
	jobmanage_dataset.flushData(jobmanage_dataset.pageIndex);
}
function btStop_postSubmit(button){
	alert("ֹͣ�ɹ���");
	jobmanage_dataset.flushData(jobmanage_dataset.pageIndex);
}
 function btStart_onClickCheck(button){
	var flag = jobmanage_dataset.getValue("isRunning");
	var _runTime = jobmanage_dataset.getValue("runTime");
	if("9N"==_runTime){
		alert('������������������');
		return false;
	}
	if("true"==flag){
		alert('�����Ѿ�������');
		return false;
	}
 }
 function btStop_onClickCheck(button){
	var flag = jobmanage_dataset.getValue("isRunning");
	if("false"==flag){
		alert('�����Ѿ�ֹͣ��');
		return false;
	}
 }
function datatable1_opr_onRefresh(cell, value, record)
{
	if(record&&record!=null){
		var id = record.getValue("jobNo");
		cell.innerHTML = "<center><a href=\"JavaScript:btStartShow("+id+")\">����</a>"+" <a href=\"JavaScript:btStopShow("+id+")\">ֹͣ</a></center>";
	}else{
		cell.innerHTML = "";
	}
}

function btStartShow(jobNo){
	var record = jobmanage_dataset.find(["jobNo"],[jobNo]);
	jobmanage_dataset.setRecord(record);
	jobmanage_dataset.setValue("startFlag",1);
	window.document.getElementById('btStart').click();
}

function btStopShow(jobNo){
	var record = jobmanage_dataset.find(["jobNo"],[jobNo]);
	jobmanage_dataset.setRecord(record);
	jobmanage_dataset.setValue("startFlag",0);
	window.document.getElementById('btStop').click();
}
<#--add by henry 20110617 end-->
 <#-- removed by henry 2011-06-18 ��ʱ������޸�
 function btStart_onClickCheck(button){
    jobmanage_dataset.moveFirst();
	for(var rowIndex=1;rowIndex<=jobmanage_dataset.length;rowIndex++){
	var selected=jobmanage_dataset.getValue("select");

	if(selected){
	jobmanage_dataset.setValue("startFlag",1);
	}
	jobmanage_dataset.moveNext();
	}
 }
 function btStop_onClickCheck(button){
    jobmanage_dataset.moveFirst();
	for(var rowIndex=1;rowIndex<=jobmanage_dataset.length;rowIndex++){
	var selected=jobmanage_dataset.getValue("select");

	if(selected){
	jobmanage_dataset.setValue("startFlag",0);
	}
	jobmanage_dataset.moveNext();
	}
 }
 -->
</script>
</@CommonQueryMacro.page>
