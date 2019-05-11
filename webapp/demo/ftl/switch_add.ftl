<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="微交换添加示例">
	<@CommonQueryMacro.CommonQuery id="SwitchAdd" init="true" submitMode="current" navigate="false">
			<div style="padding:5px;color:#336699">
				此功能为微交换与FP添加功能测试，交易码1001，如果卡号为：1系统返回错误。
			</div>
			<@CommonQueryMacro.Group id="group1"  label="用户信息" colNm="4" fieldStr="pan" />
			<@CommonQueryMacro.Group id="group2"  label="商户信息" colNm="4" fieldStr="acqBIN,merID,password,name,country" />
			<@CommonQueryMacro.Group id="group3"  label="交易信息" colNm="4" fieldStr="purchAmount,currency,exponent,trsFeeAmount" />
			<div style="padding:5px;">
				<@CommonQueryMacro.Button id="btSubmit" />
			</div>
	</@CommonQueryMacro.CommonQuery>
</@CommonQueryMacro.page>
<script>
	function btSubmit_postSubmit(button){
		alert("操作执行成功!");
		SwitchAdd_dataset.flushData(1);
	}
</script>