<#import "/templets/commonQuery/CommonQueryMacroNew.ftl" as CommonQuery>

<@CommonQuery.CommonQuery>
	<table align="left">
			<tr>
       			<td valign="top" rowspan="2">
          			<@CommonQuery.PagePilot id="ddresult" maxpagelink="9"/>
          			<@CommonQuery.DataTable id ="datatable1" fieldStr="custcd,idtypename,idtypename" width="350" readonly="false"/>
        		</td>
        		<td align="left" valign="top">
        			<@CommonQuery.Group id="group1" label="group1" fieldStr="custcd,idtypename,idno" colNm=4/>
        		</td>
      		</tr>
      		<tr>
       			<td align="center">
         		<@CommonQuery.Button id= "btAdd"/>
         			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
         		<@CommonQuery.Button id= "btDel"/>
         			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
         		<@CommonQuery.Button id= "btSave"/>
        		</td>
      	  	</tr>
   </table>
</@CommonQuery.CommonQuery>