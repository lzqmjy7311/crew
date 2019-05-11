<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="demo_field_1">
<@CommonQueryMacro.CommonQuery id="GroupValidateFields" init="true" submitMode="current" navigate="false">
	<table>
		<tr>
			<td>
				例举一部分，所有的验证规则可在templates/lib/rules.js中获取
				<@CommonQueryMacro.Group id="group1"  label="前台验证" colNm="2" fieldStr="requireField,mail,number,url,chinese,password,numOrWord,multiValidate,currency,textarea" />
				<@CommonQueryMacro.Group id="group1"  label="后台验证" colNm="2" fieldStr="bnumber,burl,bmail" />
				<@CommonQueryMacro.Button id="btSave" />
			</td>
		</tr>
	</table>
</@CommonQueryMacro.CommonQuery>
<script>
</script>
</@CommonQueryMacro.page>