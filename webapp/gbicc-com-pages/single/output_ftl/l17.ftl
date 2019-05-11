<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />

<#assign warningId=RequestParameters["warningId"]?default("")>

<@CommonQueryMacro.page title="企业征信未结清承兑汇票信息">
<table>
	<@CommonQueryMacro.CommonQuery id="L17" init="true" submitMode="current">
		<@CommonQueryMacro.DataTable id="L17Table" nowrap="true" height="305" readonly="true" fitColumns="false"
		fieldStr="F_FINANCECODE,F_CONTRACTCODE,F_NUM,F_DAY30,F_DAY60,F_DAY90,F_DAY91,F_TOTAL,FD_ISBAD" width="100%" hasFrame="true"/>
	</@CommonQueryMacro.CommonQuery>
</table>
<script>
	//页面初始化
	function initCallGetter_post(){
		var warningId='${warningId}';
		L17_dataset.setParameter("warningId",warningId);
	}
</script>
</@CommonQueryMacro.page>