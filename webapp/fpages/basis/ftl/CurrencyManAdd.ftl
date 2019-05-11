<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>

<@CommonQueryMacro.page title="币种信息维护" >
	<@CommonQueryMacro.CommonQuery id ="CurrencyManInfo" init="true" insertOnEmpty="true">
		<table>
		  <tr>
		    <td>
		     <@CommonQueryMacro.Group id="group1" label="币种信息维护" fieldStr="currencyCode,currencyName,dotNum" colNum="4" /> 
		    </td>
		   </tr>
		   <tr>
				<td>
					<@CommonQueryMacro.Button id= "btSave"/>&nbsp;&nbsp;<@CommonQueryMacro.Button id= "btBack"/>
				</td>
			</tr>
		 </table>
	
	</@CommonQueryMacro.CommonQuery>
	
</@CommonQueryMacro.page >