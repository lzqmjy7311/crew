<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="范例3(50个字段的表格)">
	<h2>范例3(50个字段的表格)</h2>
	<@CommonQueryMacro.CommonQuery id="DemoFields2" init="true" submitMode="current" navigate="false">
		<@CommonQueryMacro.DataTable id="demotable" readonly="true" fitColumns="false" fieldStr="t1,t2,t3,t1,t2,t3,t1,t2,t3,t1,t2,t3,t1,t2,t3,t1,t2,t3,n1,n2,n3,n1,n2,s1,s2,s3,s1,s2,s3,s1,s2,s3,s1,d1,d2,d3,d4,date1,date2,date3,date4,date5,date6,date7,date1,date2,date3,radio,check,radio,check,radio,check,radio,check,radio,check" height="400" />
	</@CommonQueryMacro.CommonQuery>
</@CommonQueryMacro.page>