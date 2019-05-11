<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<@CommonQueryMacro.page title="任务管理  &gt; 规则排除查询">
	<@CommonQueryMacro.CommonQuery id="ruleeliminatequery" init="true" submitMode="current">
			<div style="margin: 0 0px 0 0"><@CommonQueryMacro.Interface id="eliminatequery" label="规则排除查询" colNm="6" showButton="false"/></div>
			<center><@CommonQueryMacro.Button id="btQuery"/>&nbsp;&nbsp;&nbsp;&nbsp;<@CommonQueryMacro.Button id="btRest"/></center>
			<@CommonQueryMacro.DataTable id="QualityTable222"   fieldStr="warningLevel,loanAcct[150],custName,productName[150],loanAmt,loanBalance,loanTerm,ruleName[150],rulenameEliminate[150],bankname[150],updDate" width="100%" hasFrame="true"/>
 <#--     	<@CommonQueryMacro.FloatWindow id="signWindow" label="" width="" resize="true" defaultZoom="normal" minimize="false" maximize="false" closure="true" float="true" exclusive="true" position="center" show="false" > -->	
			
	</@CommonQueryMacro.CommonQuery>

<script language="JavaScript">

	function btRest_onClick(button){
		ruleeliminatequery_interface_dataset.clearData();
	}

	function btQuery_onClick() {
		
		var custName=ruleeliminatequery_interface_dataset.getValue("custName");
		var bankname=ruleeliminatequery_interface_dataset.getValue("bankname");
		var loanAcct=ruleeliminatequery_interface_dataset.getValue("loanAcct");
		var bankid=ruleeliminatequery_interface_dataset.getValue("bankid");
		var startDate=ruleeliminatequery_interface_dataset.getValue("startDate");
		var endDate=ruleeliminatequery_interface_dataset.getValue("endDate");
		if(startDate==null||endDate==null||(startDate==''&&endDate!='')||(startDate!=''&&endDate=='')){
			alert("请输入完整的日期查询条件");
			return false;
		}
		ruleeliminatequery_dataset.setParameter("custName",custName);
		ruleeliminatequery_dataset.setParameter("bankname",bankname);
		ruleeliminatequery_dataset.setParameter("loanAcct",loanAcct);
		ruleeliminatequery_dataset.setParameter("bankid",bankid);
		ruleeliminatequery_dataset.setParameter("startDate",startDate);
		ruleeliminatequery_dataset.setParameter("endDate",endDate);
		ruleeliminatequery_dataset.flushData();
	}

</script>	
</@CommonQueryMacro.page>