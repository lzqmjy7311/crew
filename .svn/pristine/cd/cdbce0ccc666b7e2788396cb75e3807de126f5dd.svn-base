<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>

<@CommonQueryMacro.page title="待办任务查询">
<table align="left">
<tr>
<td valign="top" rowspan="1"  valign="top">
<@CommonQueryMacro.CommonQuery id="WaitToHandleTaskEntry" init="true" mode="2">
	<table align="left">
			<tr>
       			<td valign="left" >
					<@CommonQueryMacro.Interface id="intface" label="请输入查询条件" colNm=4  />
				</td>
			</tr>

			<tr>
				<td valign="top" ><#--contractNo,custno,custName,actionName,status,owner,pinstanceTemplate,starter,startTime-->
					<@CommonQueryMacro.PagePilot id="ddresult" maxpagelink="9999"/><#--transNo,bussType,custno,custName,taskName,procName,starter,startTime-->
					<@CommonQueryMacro.DataTable id ="datatable1" fieldStr="transNo,custno,custName,actionName,status,owner,starter,startTime"  readonly="true"/>
	  			</td>
			 </tr>
			 <tr>
	   			<td align="center">
	   			<@CommonQueryMacro.Button id= "btApply"/>
	    		</td>
      	  	</tr>

	 </table>
</@CommonQueryMacro.CommonQuery>

<script language="javascript" src="${contextPath}/js/inquery.js"></script>
<script language="javascript">

//提交前的检查
function btApply_onClickCheck(button){
	if(WaitToHandleTaskEntry_dataset.getValue("transNo")==""){
		alert("列表无记录，不能提交");
		return false;
		}
	}

function datatable1_transNo_onRefresh(cell, value, record)
{
	if(value.substring(0,2)=="gd"||value.substring(0,2)=="sx"){
		cell.innerHTML = "<a href=\"Javascript:openContract('" + value + "')\">" + value + "</a>";
	}else if(value.substring(0,2)=="jj"){
		cell.innerHTML = "<a href=\"Javascript:openCino('" + value + "')\">" + value + "</a>";
	}else{
		cell.innerHTML = "<a href=\"Javascript:openProjectNo('" + value + "')\">" + value + "</a>";
	}
}

function datatable1_custno_onRefresh(cell, value, record)
{

	if((value.substring(0,1).charCodeAt(0)>=65)
			&&(value.substring(0,1).charCodeAt(0)<=90)){
		cell.innerHTML = "<a href=\"Javascript:openCoopCustomer('" + value + "')\">" + value + "</a>";
	}else{
		cell.innerHTML = "<a href=\"Javascript:openCustomerNo('" + value + "')\">" + value + "</a>";
	}
}

</script>

</@CommonQueryMacro.page>
