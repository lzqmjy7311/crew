<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="树形表格">
	<table width="100%">
	<@CommonQueryMacro.CommonQuery id="roleFuncTreeAsync" init="false" submitMode="current">
		<tr>
			<td>
				<@CommonQueryMacro.Group id="group1" label="详细属性" fieldStr="id,name,pagepath,location,desc,iconCls,isdirectory,status" />
			</td>
		</tr>
		<tr>
			<td align="center">
				<@CommonQueryMacro.Button id="btnSave"/>
			</td>
		</tr>
	</@CommonQueryMacro.CommonQuery>
	</table>
<script>
function initCallGetter_post(){
}

function btnSave_postSubmit(button) {
	alert("保存成功!");
	window.parent.closeSubWin();
}
</script>
</@CommonQueryMacro.page>