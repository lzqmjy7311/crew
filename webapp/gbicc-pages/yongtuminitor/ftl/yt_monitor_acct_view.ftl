<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="ÓÃÍ¾¼à¿Ø">
	<table align="left" width="100%">
    <tr>
		<td>
			<@CommonQueryMacro.CommonQuery id="YtMonitorAcctView" init="true" submitMode="current" navigate="false">
				<@CommonQueryMacro.DataTable id="datatable" 
				paginationbar="BtnAdd"  
				readonly="false"  
				isHiddenScoll="true"
				fieldStr="duebillno,begindate,contno,loanacno,custid,custname,tcapi,tterm,busitype,operid" />
			</@CommonQueryMacro.CommonQuery>
		<td>
	</tr>
	</table>
	
</@CommonQueryMacro.page>