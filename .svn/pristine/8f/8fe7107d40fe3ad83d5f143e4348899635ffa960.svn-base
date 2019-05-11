<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="批量监控">
<@CommonQueryMacro.CommonQuery id="BatchStepList"  init="true" navigate="true">
	           <table align="left" width="95%">
	           		 <tr align="left">
			       			<td valign="top" rowspan="1"  width="95%">
			       				<@CommonQueryMacro.Interface id="Interface1" label="查询条件" colNm=4 />
			        		</td>
      				 </tr>
      				 <tr height="10">
      				 <td>
      				 </td>
      				 </tr>
			         <tr>
				          <td valign="top">
				                                         批量运行信息
	                      	    <@CommonQueryMacro.DataTable id ="datatable2" fieldStr="batchstatus,batchcurrentstep,batchsubstepcount,successstepcount,failstepcount" maxRow="1" readonly="true" width="95%"/></br>
				          </td>
				     </tr>
			         <tr>
				          <td valign="top">
				            	<@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" showArrow="true" pageCache="false"/>
	                      	    <@CommonQueryMacro.DataTable id ="datatable1" fieldStr="stepdispname,substepname,starttime,endtime,status" readonly="true" width="95%"/></br>
				          </td>
				     </tr>
        	<tr>
        	</tr>
      			</table>
</@CommonQueryMacro.CommonQuery>
 <script language="javascript">
var finding=false;
var bhDate;
function flushData(){
getRunningStep();
bhDate=BatchStepList_dataset.getValue("bhDate");
setBHDate(bhDate);
///setRowColor();
//setTimeout("flushData();",10000);
}

function setBHDate(bhDate){
if(bhDate!=BatchStepList_interface_dataset.getString("bhdate")){
bhDate=bhDate.substr(0,4)+"-"+bhDate.substr(4,2)+"-"+bhDate.substr(6,2);
BatchStepList_interface_dataset.setValue("bhdate",bhDate);
}
}
function getRunningStep(){
finding=true;
for(var index=1;index<=BatchStepList_dataset.pageCount;index++){
  BatchStepList_dataset.flushData(index);
  var findRunning=false;
  for(var rowIndex=1;rowIndex<=BatchStepList_dataset.pageSize;rowIndex++){
    if(BatchStepList_dataset.getValue("status")=='运行'){
      findRunning=true;
      break;
    }
    BatchStepList_dataset.moveNext();
  }
  if(findRunning) break;
}
finding=false;
}

flushData();

function setRowColor(){
alert(datatable1);
for(var i=1;i<datatable1.rows.length;i++){
datatable1.rows[i].bgColor='red';
}
}

function BatchStepList_dataset_flushDataPost(dataset){
}

function datatable2_successstepcount_onRefresh(cell, value, record)
{
        var bhDate=BatchStepList_interface_dataset.getString("bhdate");
		cell.innerHTML = "<a href=\"Javascript:openBatchDetails('F','"+bhDate+"')\">" + value +"</a>";
}

function datatable2_failstepcount_onRefresh(cell, value, record)
{
        var bhDate=BatchStepList_interface_dataset.getString("bhdate");
		cell.innerHTML = "<a href=\"Javascript:openBatchDetails('E','"+bhDate+"')\">" + value +"</a>";
}

function datatable1_status_onRefresh(cell, value, record){
if(value=='异常中断'){
 cell.style.color="red";
}else if(value=='运行'){
cell.style.color='orange';
}else if(value=='结束'){
cell.style.color='green';
}else{
cell.style.color='blue';
}
 cell.innerHTML=value;
}

function openBatchDetails(statuscode,bhDate){
var path=_application_root+"/fpages/batchmonitor/ftl/BatchStepMonitor.ftl?statuscode="+statuscode+"&bhdate="+bhDate;
window.open(path,"_blank","resizable=1,location=0,scrollbars=1, width=800,height=500 ");
}
</script>
</@CommonQueryMacro.page>
