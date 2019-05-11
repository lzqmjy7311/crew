<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />

<#assign warningId=RequestParameters["warningId"]?default("")>

<@CommonQueryMacro.page title="外部工商信息">
<table>
	<@CommonQueryMacro.CommonQuery id="L01" init="true" submitMode="current">
		<@CommonQueryMacro.DataTable id="L01Table" nowrap="true" height="305" readonly="true" fitColumns="false"
		fieldStr="companyName,registorNo,legalName,certNo,cancelDate,enterStatus,busstartDate,busendDate,busscope,registorAmt,shareHolder" width="100%" hasFrame="true"/>
	</@CommonQueryMacro.CommonQuery>
</table>
<script>
	//页面初始化
	function initCallGetter_post(){
		var warningId='${warningId}';
		L01_dataset.setParameter("warningId",warningId);
	}
</script>
</@CommonQueryMacro.page>