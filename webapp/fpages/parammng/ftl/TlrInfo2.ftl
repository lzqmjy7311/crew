<#import "/templets/commonQuery/CommonQueryMacroNew.ftl" as CommonQuery>

<@CommonQuery.CommonQuery>
	<table align="left">
			<tr>
       			<td valign="top" rowspan="2"  valign="top">
       				<@CommonQuery.PagePilot id="ddresult" maxpagelink="9"/>

          			<@CommonQuery.DataTable id ="datatable1" fieldStr="selected,roleid,rolename" width="200" readonly="false" />
        		</td>
        		<td align="left" valign="top" width="200">
        			<@CommonQuery.Group id="group1" label="操作员信息1" fieldStr="brcode,tlrno,tlrnoName,status,latelyLogoutTime,latelyLoginTime,effectDate,expireDate,email,misc,creatDate" colNm=4/>

        		</td>

      		</tr>
      		<tr>
       			<td align="center">
         		<@CommonQuery.Button id= "TlrInfo2"/>
        		</td>
      	  	</tr>
   </table>

</@CommonQuery.CommonQuery>