<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />

<#assign warningId=RequestParameters["warningId"]?default("")>

<@CommonQueryMacro.page title="自然人账户信息">
<table>
	<@CommonQueryMacro.CommonQuery id="C16" init="true" submitMode="current">
		<@CommonQueryMacro.DataTable id="C16Table" nowrap="true" height="305" readonly="true" fitColumns="false" width="100%" hasFrame="true"
		fieldStr="loanacno[150],loanid[100],custid[100],custname[100],corpcustid[100],prodname[200],tcapi[100],tterm[80],warrno[150],enstroid[120],warrbusidate[100],totalMortgageValue[100],payoffflag[80],begindate[100],enddate[100],operid[80],opername[100],bankid[80],bankname[120],assukind[100],floatinterate[80],acflag[80],acflag2[80],riskflag[80],contno[120],dutyid[80],dutyid2[80],reckday[80],retuday[80],corpid[100],corpname[150],projid[100],corpappid[100],basicinterate[100],interate[100],goodsamt[100],loanhousecount[120],familyhousecount[120],spousecustid[100],bal[100],overbal[100],overinte[100],sumtcapi[100],isOver[80],overStartDate[100],overDays[100],overCount[100],overCountLast12M[120],overCountMaxHis[120],overCountSumHis[120],isDefault[80],defaultStartDate[100],defaultCount[100],defaultCountHis[120]" />
	</@CommonQueryMacro.CommonQuery>
</table>
<script>
	//页面初始化
	function initCallGetter_post(){
		var warningId='${warningId}';
		C16_dataset.setParameter("warningId",warningId);
	}
</script>
</@CommonQueryMacro.page>