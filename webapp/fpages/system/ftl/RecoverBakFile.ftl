<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>

<@CommonQueryMacro.page title="工作日期切换">
<table align="left" width="80%">
	<tr>
		<td width="100%">
			主页 &gt; 系统维护 &gt; 系统配置信息 &gt; 业务数据恢复
		</td>
	</tr>
	<tr>
		<td width="100%">
			<hr />
		</td >
	</tr>
	<tr>
		<td align="left" width="100%">
			<@CommonQueryMacro.CommonQuery id="recoverBakFile" init="true" navigate="false" submitMode="current">
				<table width="100%">
					<tr>
						<td>
							<@CommonQueryMacro.Group id ="branchFuncGroup" label="恢复信息" fieldStr="filePath,fileSize,lastModifyTime,exits,recoverReason" colNm=4/>
						</td>
					</tr>
					<tr>
						<td>
							<div style="color: red;font-size: 12px;">* 执行确认前建议先备份数据库！</div><br>
						</td>
					</tr>
					<tr>
						<td><@CommonQueryMacro.Button id= "btDone" /></td>
					</tr>
				</table>
			</@CommonQueryMacro.CommonQuery>
		</td>
	</tr>
</table>
<script language="javascript">

	function initCallGetter_post(){
		var exits = recoverBakFile_dataset.getValue("exits");
		if (exits == "N") {
			document.getElementById("btDone").disabled=true;
		} else {
			document.getElementById("btDone").disabled=false;
		}
	}
	function btDone_onClickCheck(button){
		var f = window.confirm("该操作为不可逆操作，建议先对数据库进行备份！\n确定要进行数据库恢复？");
		return f;
	}
</script>
</@CommonQueryMacro.page>
