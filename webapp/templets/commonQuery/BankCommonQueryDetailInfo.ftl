<#--提交页面测试-->
<#import "/templets/commonQuery/CommonQueryMacroNew.ftl" as CommonQuery>

<@CommonQuery.CommonQuery>
		<table align="left">
			<tr>
        		<td align="left" valign="top">
        			<@CommonQuery.Group id="group1" label="基本信息" fieldStr=""  colNm=4/>
        		</td>
      		</tr>
      		<tr>
       			<td align="center">
         			<@CommonQuery.ButtonGroup/>
        		</td>
      	  	</tr>
      	  	</table>
</@CommonQuery.CommonQuery>