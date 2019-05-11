<#--Interface 模板　适用了Tag方式-->
<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="">
<@CommonQueryMacro.CommonQuery id=RequestParameters["CQId"] init="false" mode="1">
	<table align="left" width="100%">
			<tr>
       			<td valign="top" rowspan="2"  valign="top">
       				<@CommonQueryMacro.Interface id="intface" colNm=4 defaultOperation="asyncqrysubmit"/>
        		</td>
      	  	</tr>
   </table>
</@CommonQueryMacro.CommonQuery>
</@CommonQueryMacro.page>