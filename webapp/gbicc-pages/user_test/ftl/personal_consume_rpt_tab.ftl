<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<@CommonQueryMacro.page title="个人按揭类定期监控报告">

	<@CommonQueryMacro.CommonQuery id="PersonalConsumeRptTab" init="false" submitMode="current">
		<@CommonQueryMacro.GroupBox id="box1" label="客户基本信息">
			<@CommonQueryMacro.Group id="group1" label="" colNm=4
			fieldStr="loanVariety,custName,custCode,certType,certCode,coopObj,coopObjName,loanAmt,loanBalance,issueDate,completeDate,issueAmt,lendCode,guarWay,gageCode,arrearAmt,riskStatus,acctStatus,checkPerCode,checkWay,checkPlace,checkDate,checkType"/>
		</@CommonQueryMacro.GroupBox>
	</@CommonQueryMacro.CommonQuery>
	
	<@CommonQueryMacro.CommonQuery id="PersonalConsumeRptTab" init="false" submitMode="current">
		<@CommonQueryMacro.GroupBox id="box2" label="借款人情况">
			<@CommonQueryMacro.DataTable id="loanPerTable" paginationbar="loanPerAdd,loanPerUpd,loanPerDel" pagination="true"
			fieldStr="healthCond,marriageCond,contactWay,profession,property,income,liabilities,IfInflRepmt" width="100%" hasFrame="true"/>
			<@CommonQueryMacro.FloatWindow id="loanPerFW" modal="true" label="借款人情况" 
			resize="true" minimize="false" maximize="true" closure="true" show="false" defaultZoom="normal">
				<@CommonQueryMacro.Group id="group2" label="" colNm=2
				fieldStr="healthCond,marriageCond,contactWay,contactWayUpd,profession,professionUpd"/>
				<@CommonQueryMacro.Group id="group3" label="家庭资产和负债变化（查询征信）" colNm=2
				fieldStr="property,income,liabilities,IfInflRepmt"/>
				<@CommonQueryMacro.Button id="loanPerConfirm" />
			</@CommonQueryMacro.FloatWindow>
		</@CommonQueryMacro.GroupBox>
	</@CommonQueryMacro.CommonQuery>
		
	<@CommonQueryMacro.CommonQuery id="GuarEntry" init="false" submitMode="current">
		<@CommonQueryMacro.GroupBox id="box3" label="担保情况">
			<@CommonQueryMacro.DataTable id="guarTable" paginationbar="guarAdd,guarUpd,guarDel" pagination="true"
			fieldStr="pledgeAddr,pledgeStatus,pledgeValueChange,pledgeOwner,guarPerName,guarPerLia,guarAbility" width="100%" hasFrame="true"/>
			<@CommonQueryMacro.FloatWindow id="guarFW" modal="true" label="担保情况" 
			resize="true" minimize="false" maximize="true" closure="true" show="false" defaultZoom="normal">
				<@CommonQueryMacro.Group id="group3" label="" colNm=2
				fieldStr="pledgeAddr,pledgeStatus,pledgeValueChange,pledgeValue,pledgeOwner,pledgeOwnerDesc,guarPer,guarPerName,guarPerPhone,guarPerLia,guarPerLiaAmt,guarAbility"/>
				<@CommonQueryMacro.Button id="guarConfirm" />
			</@CommonQueryMacro.FloatWindow>
		</@CommonQueryMacro.GroupBox>
	</@CommonQueryMacro.CommonQuery>
	
	<@CommonQueryMacro.CommonQuery id="PersonalConsumeRptTab" init="false" submitMode="current">
		<@CommonQueryMacro.GroupBox id="box4" label="合作商、合作项目情况">
				<@CommonQueryMacro.Group id="group4" label="" colNm=2
				fieldStr="coopItem,devComp,mediumComp,guarComp,projectEvolve,exceDesc,deliverCond,postpDesc,tranCardCond,tranCardCondDesc"/>
		</@CommonQueryMacro.GroupBox>
	</@CommonQueryMacro.CommonQuery>
	
	<@CommonQueryMacro.CommonQuery id="RiskCtrlMeasEntry" init="false" submitMode="current">
		<@CommonQueryMacro.GroupBox id="box5" label="控制措施">
				<@CommonQueryMacro.Group id="group5" label="" colNm=2
				fieldStr="riskCtrl,otherCtrlDesc,appendCtrl,applyOpin"/>
		</@CommonQueryMacro.GroupBox>
	</@CommonQueryMacro.CommonQuery>
<script>
	//function PersonRptTab_dataset_onSetValue(ds,curretField,val){
		//if(curretField.name=='radio'){
			//return val;
		//}
		//console.log(val);
	//}
	function loanPerAdd_onClick(button) {
		PersonalConsumeRptTab_dataset.insertRecord("end");
		subwindow_loanPerFW.show();
	}
	function loanPerUpd_onClick(button){
		subwindow_loanPerFW.show();
	}
	function loanPerConfirm_onClick(button){
		subwindow_loanPerFW.close();
	}
	
	function guarAdd_onClick(button) {
		GuarEntry_dataset.insertRecord("end");
		subwindow_guarFW.show();
	}
	function guarUpd_onClick(button){
		subwindow_guarFW.show();
	}
	function guarConfirm_onClick(button){
		subwindow_guarFW.close();
	}
</script>
</@CommonQueryMacro.page>