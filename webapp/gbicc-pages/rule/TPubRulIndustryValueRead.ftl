<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />

<#assign rulCode=RequestParameters["rulCode"]?default("")>
<#assign industryCode=RequestParameters["industryCode"]?default("")>

<@CommonQueryMacro.page title="规则行业阀值设置列表">
<@CommonQueryMacro.CommonQuery id="TPubRulIndustryValueDtl" init="true" submitMode="all">
<table>
	<tr>
		<td>
			<@CommonQueryMacro.DataTable id="TPubRulIndustryValueDtlDataTable" readonly="true" height="510" 
			fieldStr="rulCode[80],rulName[150],industryCode[80],industryName[150],valueDescView[300],valueCode[80],value[100],desc[150],updateUser[100],updateDt[100]" width="100%" hasFrame="true"/>
		</td>
	</tr>
</table>
</@CommonQueryMacro.CommonQuery>
<script>
	var rulCode='${rulCode}';
	var industryCode='${industryCode}';
	function initCallGetter_post(){
		TPubRulIndustryValueDtl_dataset.setParameter("rulCode",rulCode);
		TPubRulIndustryValueDtl_dataset.setParameter("industryCode",industryCode);
		TPubRulIndustryValueDtl_dataset.setParameter("flag",null);
		TPubRulIndustryValueDtl_dataset.flushData(1);
	}
</script>
</@CommonQueryMacro.page>