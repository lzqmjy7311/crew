<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<@CommonQueryMacro.page title="规则行业阀值设置列表">

<@CommonQueryMacro.CommonQuery id="TOdsCmsCodeIndustry" init="true" submitMode="current">
<table>
	<tr>
		<td>
			<@CommonQueryMacro.Interface id="intface" label="请输入查询条件" showButton="false" labelwidth="100" colNm=8/>
		</td>
	</tr>
	<tr>
		<td>
			<div align="center" style="margin-bottom:5px">
				<@CommonQueryMacro.InterfaceButton desc="查询" />
				<@CommonQueryMacro.SimpleButton id="btnReset" desc="重置" icon="icon-reload" />
			</div>
		</td>
	</tr>
	<tr>
		<td>
			<@CommonQueryMacro.DataTable id="TOdsCmsCodeIndustryDataTable" paginationbar="btnSave"  height="310" 
			fieldStr="TYPE_CD,TYPE_VALUE,LEVEL_CD" width="100%" hasFrame="true"/>
		</td>
	</tr>
</table>
</@CommonQueryMacro.CommonQuery>
<script>
	function btnReset_onClick(){
		TOdsCmsCodeIndustry_interface_dataset.clearData();
	}
	function TOdsCmsCodeIndustryDataTable_onDbClick(){
		btnSave_onClick();
	}
	function btnSave_onClick(){
		var typeCd=TOdsCmsCodeIndustry_dataset.getValue("TYPE_CD");
		var typeValue=TOdsCmsCodeIndustry_dataset.getValue("TYPE_VALUE");
		if(!typeCd || typeCd==""){
			top.easyMsg.info("请先选择行业！");
			return;
		}
		window.parent.saveIndustryFun(typeCd,typeValue);
	}
</script>
</@CommonQueryMacro.page>