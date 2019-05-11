<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="操作员管理">
<@CommonQueryMacro.CommonQuery id="Management_TlrInfoEx" submitMode="current" init="true" navigate="true">
	<table align="left">
			<tr>
       			<td valign="top"  valign="top">
       				<@CommonQueryMacro.PagePilot id="ddresult" maxpagelink="9"/>

          			<@CommonQueryMacro.DataTable id ="datatable1" fieldStr="brno,tlrno,tlrName,status,creatDate,latelyLoginTime,latelyLogoutTime,loginIp,flag" readonly="true" />
        		</td>

      		</tr>
      		<tr>
       			<td align="center">
         		<@CommonQueryMacro.Button id= "btn"/>
        		</td>
      	  	</tr>
   </table>

</@CommonQueryMacro.CommonQuery>
</@CommonQueryMacro.page>