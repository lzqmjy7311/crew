<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<script type="text/javascript" src="${contextPath}/gbicc-pages/regular/comm/common.js"></script>
<#assign businessId=RequestParameters["businessId"]?default("")>
<#assign rptStatus=RequestParameters["rptStatus"]?default("")>

<@CommonQueryMacro.page title="基本信息">
	<table>
		 <tr>
			<td>
				<@CommonQueryMacro.CommonQuery id="RiskMontitorRelevanceC" init="true" submitMode="current">
					<@CommonQueryMacro.GroupBox id="RelevanceC" label="关联企业">
						<@CommonQueryMacro.DataTable id="company"  fieldStr="relevanceType,customerNum,chineseName,businessLicenseNum,registeredCapital,foundedDate,outstandingloanNum,loanBal,creditLevel,warningLevel"/>
					</@CommonQueryMacro.GroupBox>
				</@CommonQueryMacro.CommonQuery>
			</td>
		</tr>			
		<tr>
			<td>
				<@CommonQueryMacro.CommonQuery id="RiskMontitorRelevanceP" init="true" submitMode="current">
					<@CommonQueryMacro.GroupBox id="RelevanceP" label="关联自然人">
						<@CommonQueryMacro.DataTable id="person"  fieldStr="relevanceType,customerNum,chineseName,affiliatedCertficateNum,residence,educationBackground,outstandingloanNum,loanBal,creditLevel,warningLevel"/>
					</@CommonQueryMacro.GroupBox>
				</@CommonQueryMacro.CommonQuery>
			</td>
		</tr>		
	</table>
<script>
	function btHandle1_onClick(button){

	}
	//页面初始化-发送post请求之前
	function initCallGetter_post(){

		var customerNum = "${RequestParameters["customerNum"]?default('')}";
		RiskMontitorRelevanceC_dataset.setParameter("customerNum",customerNum);
		RiskMontitorRelevanceP_dataset.setParameter("customerNum",customerNum);

	}  
	function changedata(){
		request.open("GET","",true);
	}
	//设置页面所有字段只读
	function setPageReadOnlyFun(){
		var fieldName="";
		for(var i=0;i<RiskMonitorBaseinfo_dataset.fields.length;i++){
			fieldName=RiskMonitorBaseinfo_dataset.fields[i].name;
			if(fieldName.substring(0,1)!="_"){
				RiskMonitorBaseinfo_dataset.setFieldReadOnly(fieldName,true);
			}
		}
	}

	//保存后关闭页面，刷新表格
	function btnSave_postSubmit(button) {
		button.url="#";
		top.easyMsg.info("保存成功！");
		window.parent.ajMonitorReportWin_close();
	}
	//保存后关闭页面，刷新表格
	function btnSubmit_postSubmit(button) {
		button.url="#";
		top.easyMsg.info("操作成功！");
		window.parent.ajMonitorReportWin_close();
	}
	//退回后关闭页面，刷新表格
	function btnBack_postSubmit(button) {
		button.url="#";
		top.easyMsg.info("操作成功！");
		window.parent.ajMonitorReportWin_close();
	}
</script>
<script type='text/javascript' src='${contextPath}/dwr/interface/TaskVariable.js'> </script>
</@CommonQueryMacro.page>