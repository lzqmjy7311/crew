<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>

<@CommonQueryMacro.page title="������������������� ">
<@CommonQueryMacro.CommonQuery id="CreditGradeSwitch" init="true" submitMode="all">
<table align="top" >
  		<tr>
  		<td align="left">
      		<@CommonQueryMacro.Group id="group1" label="�����������ƿ���" fieldStr="switch" colNm=2/>
		</td>
  	  	</tr>

</@CommonQueryMacro.CommonQuery>
<@CommonQueryMacro.CommonQuery id="CreditGradeCondition" init="true" submitMode="all" navigate="false" >
  		<tr>
  		<td align="left">
      		<@CommonQueryMacro.PagePilot id="PagePilot"/>
      		<@CommonQueryMacro.DataTable id ="datatable1" fieldStr="creditType,value1,value2"  width="600"  readonly="false"/></br>
  				<@CommonQueryMacro.Button id= "btnAdd"/>&nbsp;&nbsp;&nbsp;&nbsp;
  				<@CommonQueryMacro.Button id= "btnDel"/>&nbsp;&nbsp;&nbsp;&nbsp;
  				<@CommonQueryMacro.Button id= "btSave"/>
  			</td>
		</tr>
   </table>

</@CommonQueryMacro.CommonQuery>
<script language="javascript">

function btSave_needCheck(button){
	if(CreditGradeCondition_dataset.getFirstRecord()){
			return true;
		}else{
			return false;
		}
}

</script>

</@CommonQueryMacro.page>
