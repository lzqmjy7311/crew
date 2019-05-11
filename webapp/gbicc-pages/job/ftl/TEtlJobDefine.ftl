<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro> 
<@CommonQueryMacro.page title="d">

<@CommonQueryMacro.CommonQuery id="TEtlJobDefine" init="true" submitMode="current" >

<table align="left" width="100%">
    <tr>
		<td>
			<@CommonQueryMacro.Interface id="intface" label="�������ѯ����" colNm=4 showButton="false" />
		</td>
	</tr>
    <tr>
			<td>
				<div align="center" style="margin-bottom:10px">
					<@CommonQueryMacro.InterfaceButton desc="��ѯ" />
					<@CommonQueryMacro.SimpleButton id="btnReset" desc="����" icon="icon-reload" />
				</div>
			</td>
		</tr>
	<tr>
		<td>
			<@CommonQueryMacro.DataTable id ="datatable1" fieldStr="jobName[400],proType[140],proStatus[140],beginTime[180],endTime[180],isSuccess[100],des" readonly="true" width="100%" paginationbar="restartJob" /></br>
		</td>
	</tr>
</table>
</@CommonQueryMacro.CommonQuery>
<script language="JavaScript">
function btnReset_onClick(button){
	TEtlJobDefine_interface_dataset.clearData();
	TEtlJobDefine_dataset.flushData();
	var abc=setInterval(function () {		
		if(TEtlJobDefine_dataset.getValue("jobName")){
			alert("ˢ��");
			TEtlJobDefine_dataset.flushData();
		}else{
			clearInterval("abc");
		}
    }, 8000);
	
}

function restartJob_onClickCheck(){
	TEtlJobDefine_dataset.setValue("des","");
}
function restartJob_postSubmit(){
	alert('ִ�гɹ�!');
}
</script>
</@CommonQueryMacro.page>
