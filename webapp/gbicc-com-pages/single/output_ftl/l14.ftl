<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />

<#assign warningId=RequestParameters["warningId"]?default("")>

<@CommonQueryMacro.page title="黑名单信息">
<table>
	<@CommonQueryMacro.CommonQuery id="L14" init="true" submitMode="current">
		<@CommonQueryMacro.DataTable id="L14Table" nowrap="true" height="305" readonly="true" fitColumns="false"
		fieldStr="blacklistCustomerName,blacklistOrgnCd,putinCause,putinTime,fstBankName,userNum,blackTypeCd,blackCustomerTypeCd" width="100%" hasFrame="true"/>
	</@CommonQueryMacro.CommonQuery>
</table>
<script>
	//页面初始化
	function initCallGetter_post(){
		var warningId='${warningId}';
		L14_dataset.setParameter("warningId",warningId);
	}
</script>
</@CommonQueryMacro.page>