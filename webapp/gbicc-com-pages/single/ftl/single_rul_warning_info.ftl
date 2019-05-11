<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />

<#assign businessId=RequestParameters["businessId"]?default("")>

<@CommonQueryMacro.page title="单规则预警处理">
<table>
	<tr>
		<td>
			<@CommonQueryMacro.CommonQuery id="SingleRulWarningInfo" init="true" submitMode="current">
				<@CommonQueryMacro.Group id="SingleRulWarningGroup" label="" colNm=4 labelwidth="150"
				fieldStr="fcettypecode,fcetname,rulCode,rulType,warnStatus,rulName,warnDt,mainOrg,warnDesc"/>
			</@CommonQueryMacro.CommonQuery>
		</td>
	</tr>
	<tr>
		<td>
			<@CommonQueryMacro.DynamicTabSet id="BusinInfoTab" hasMenu="false" fit="false" height="350" width="1270" selected="A01">
		    </@CommonQueryMacro.DynamicTabSet>
		</td>
	</tr>
	
	
</table>
<script>
	//页面初始化
	function initCallGetter_post(){
		var businessId='${businessId}';
		SingleRulWarningInfo_dataset.setParameter("id",businessId);
		SingleRulWarningInfo_dataset.flushData(SingleRulWarningInfo_dataset.pageIndex);
		
		//添加输出TAB页
		var OUTPUT={
			A01:{id:"A01",title:"帐务交易流水",url:"/gbicc-com-pages/single/output_ftl/a01.ftl?warningId="+businessId},
			A30:{id:"A30",title:"查冻扣登记簿",url:"/gbicc-com-pages/single/output_ftl/a30.ftl?warningId="+businessId},
			A38:{id:"A38",title:"承兑汇票信息",url:"/gbicc-com-pages/single/output_ftl/a38.ftl?warningId="+businessId},
			B01:{id:"B01",title:"自然人借据信息",url:"/gbicc-com-pages/single/output_ftl/b01.ftl?warningId="+businessId},
			C01:{id:"C01",title:"对公贷款借据明细",url:"/gbicc-com-pages/single/output_ftl/c01.ftl?warningId="+businessId},
			C02:{id:"C02",title:"对公贷款还款明细",url:"/gbicc-com-pages/single/output_ftl/c02.ftl?warningId="+businessId},
			C03:{id:"C03",title:"信贷合同",url:"/gbicc-com-pages/single/output_ftl/c03.ftl?warningId="+businessId},
			C05:{id:"C05",title:"对公贴现登记簿",url:"/gbicc-com-pages/single/output_ftl/c05.ftl?warningId="+businessId},
			C06:{id:"C06",title:"信贷支用申请明细",url:"/gbicc-com-pages/single/output_ftl/c06.ftl?warningId="+businessId},
			C08:{id:"C08",title:"对公抵质押物出入库操作流水",url:"/gbicc-com-pages/single/output_ftl/c08.ftl?warningId="+businessId},
			C09:{id:"C09",title:"票据信息",url:"/gbicc-com-pages/single/output_ftl/c09.ftl?warningId="+businessId},
			C11:{id:"C11",title:"跟单背书信息",url:"/gbicc-com-pages/single/output_ftl/c11.ftl?warningId="+businessId},
			C12:{id:"C12",title:"电子票据流转信息",url:"/gbicc-com-pages/single/output_ftl/c12.ftl?warningId="+businessId},
			C13:{id:"C13",title:"关联人信息",url:"/gbicc-com-pages/single/output_ftl/c13.ftl?warningId="+businessId},
			C14:{id:"C14",title:"担保圈信息",url:"/gbicc-com-pages/single/output_ftl/c14.ftl?warningId="+businessId},
			C15:{id:"C15",title:"客户指标信息",url:"/gbicc-com-pages/single/output_ftl/c15.ftl?warningId="+businessId},
			C16:{id:"C16",title:"自然人账户信息",url:"/gbicc-com-pages/single/output_ftl/c16.ftl?warningId="+businessId},
			J02:{id:"J02",title:"对公客户信息",url:"/gbicc-com-pages/single/output_ftl/j02.ftl?warningId="+businessId},
			J04:{id:"J04",title:"对私客户信息",url:"/gbicc-com-pages/single/output_ftl/j04.ftl?warningId="+businessId},
			J09:{id:"J09",title:"员工信息",url:"/gbicc-com-pages/single/output_ftl/j09.ftl?warningId="+businessId},
			J16:{id:"J16",title:"理财账户信息",url:"/gbicc-com-pages/single/output_ftl/j16.ftl?warningId="+businessId},
			J17:{id:"J17",title:"从合同信息",url:"/gbicc-com-pages/single/output_ftl/j17.ftl?warningId="+businessId},
			J18:{id:"J18",title:"信贷公司客户信息",url:"/gbicc-com-pages/single/output_ftl/j18.ftl?warningId="+businessId},
			L01:{id:"L01",title:"外部工商信息",url:"/gbicc-com-pages/single/output_ftl/l01.ftl?warningId="+businessId},
			L02:{id:"L02",title:"工商变更明细",url:"/gbicc-com-pages/single/output_ftl/l02.ftl?warningId="+businessId},
			L03:{id:"L03",title:"工商处罚明细",url:"/gbicc-com-pages/single/output_ftl/l03.ftl?warningId="+businessId},
			L04:{id:"L04",title:"开庭公告信息",url:"/gbicc-com-pages/single/output_ftl/l04.ftl?warningId="+businessId},
			L05:{id:"L05",title:"判决文书信息",url:"/gbicc-com-pages/single/output_ftl/l05.ftl?warningId="+businessId},
			L11:{id:"L11",title:"企业征信信息",url:"/gbicc-com-pages/single/output_ftl/l11.ftl?warningId="+businessId},
			L12:{id:"L12",title:"个人征信信息",url:"/gbicc-com-pages/single/output_ftl/l12.ftl?warningId="+businessId},
			L13:{id:"L13",title:"征信文件信息",url:"/gbicc-com-pages/single/output_ftl/l13.ftl?warningId="+businessId},
			L14:{id:"L14",title:"黑名单信息",url:"/gbicc-com-pages/single/output_ftl/l14.ftl?warningId="+businessId},
			L15:{id:"L15",title:"高能耗信息",url:"/gbicc-com-pages/single/output_ftl/l15.ftl?warningId="+businessId},
			L16:{id:"L16",title:"企业征信未结清贷款信息",url:"/gbicc-com-pages/single/output_ftl/l16.ftl?warningId="+businessId},
			L17:{id:"L17",title:"企业征信未结清承兑汇票信息",url:"/gbicc-com-pages/single/output_ftl/l17.ftl?warningId="+businessId}
		}
		var halfresult=SingleRulWarningInfo_dataset.getValue("halfresult");
		if(halfresult!=null && halfresult!=""){
			var ids=halfresult.split("|");
			for(var i=0;i<ids.length;i++){
				if(ids[i] && OUTPUT[ids[i]]!=null){
					BusinInfoTab_tabset.add(OUTPUT[ids[i]]);
				}
			}
		}	
	}
	
	//刷新当前页
	function flushCurrentPage() {
		SingleRulWarningInfo_dataset.flushData(SingleRulWarningInfo_dataset.pageIndex);
	}

</script>
<script type='text/javascript' src='${contextPath}/dwr/interface/TaskVariable.js'> </script>
<script type="text/javascript" src="${contextPath}/gbicc-pages/jquery-form.js"></script>
</@CommonQueryMacro.page>