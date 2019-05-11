<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />

<#assign warningId=RequestParameters["warningId"]?default("")>

<@CommonQueryMacro.page title="自然人借据信息">
<table>
	<@CommonQueryMacro.CommonQuery id="B01" init="true" submitMode="current">
		<@CommonQueryMacro.DataTable id="B01Table" nowrap="true" height="305" readonly="true" fitColumns="false" width="100%" hasFrame="true"
		fieldStr="duebillno[130],loanacno[130],begindate[100],custid[100],custname[80],contno[120],listid[100],listtype[80],busitype[80],loanid[100],subjid[80],prodid[80],tcapi[100],tterm[80],enddate[100],saveacno[150],bankid[80],operid[80]" />
	</@CommonQueryMacro.CommonQuery>
</table>
<script>
	//页面初始化
	function initCallGetter_post(){
		var warningId='${warningId}';
		B01_dataset.setParameter("warningId",warningId);
	}
</script>
</@CommonQueryMacro.page>