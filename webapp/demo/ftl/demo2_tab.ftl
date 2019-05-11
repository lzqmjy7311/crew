<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="范例2(100个字段的表单)">
	<@CommonQueryMacro.CommonQuery id="DemoFields2" init="true" submitMode="allchange" navigate="false">
			<@CommonQueryMacro.Group id="group1"  label="范例2(100个字段的表单)" colNm="4"
				fieldStr="t1,t2,t3,t1,t2,t3,t1,t2,t3,t1,t2,t3,t1,t2,t3,t1,t2,t3,t1,t2,t3,t1,t2,t3,t1,t2,t3,t1,t2,t3,t1,t2,t3,t1,t2,n1,n2,n3,n1,n2,n3,n1,n2,n3,n1,s1,s2,s3,s4,s5,s1,s2,s3,s4,s5,s1,s2,s3,s4,s5,s1,s2,s3,s4,s5,s1,s2,s3,s4,s5,d1,d2,d3,d4,d1,d2,d3,d4,d1,d2,d3,d4,d1,d2,d3,date1,date2,date3,date4,date5,date6,date7,date1,date2,date3,radio,radio,radio,radio,radio,check,check,check,check,check" />
	</@CommonQueryMacro.CommonQuery>
</@CommonQueryMacro.page>