<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="demo_field_1">
<@CommonQueryMacro.CommonQuery id="GroupValidateFields" init="true" submitMode="current" navigate="false">
	<table>
		<tr>
			<td>
				����һ���֣����е���֤�������templates/lib/rules.js�л�ȡ
				<@CommonQueryMacro.Group id="group1"  label="ǰ̨��֤" colNm="2" fieldStr="requireField,mail,number,url,chinese,password,numOrWord,multiValidate,currency,textarea" />
				<@CommonQueryMacro.Group id="group1"  label="��̨��֤" colNm="2" fieldStr="bnumber,burl,bmail" />
				<@CommonQueryMacro.Button id="btSave" />
			</td>
		</tr>
	</table>
</@CommonQueryMacro.CommonQuery>
<script>
</script>
</@CommonQueryMacro.page>