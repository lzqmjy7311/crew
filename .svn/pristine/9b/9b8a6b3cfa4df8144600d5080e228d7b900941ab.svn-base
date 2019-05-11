<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<@CommonQueryMacro.page title="个人经营类定期监控报告">

	<@CommonQueryMacro.CommonQuery id="PersonalOperateRptTab" init="false" submitMode="current">
		<@CommonQueryMacro.GroupBox id="box1" label="客户基本信息">
			<@CommonQueryMacro.Group id="group1" label="" colNm=4
			fieldStr="custName,custCode,custTrade,grade,creditLmt,canUseLmt,alreUseLmt,ckLmt,surveyDate,mainSurvPer,assistSurvPer"/>
		</@CommonQueryMacro.GroupBox>
	</@CommonQueryMacro.CommonQuery>
	
	<@CommonQueryMacro.CommonQuery id="PersonalOperateRptTab" init="false" submitMode="current">
		<@CommonQueryMacro.GroupBox id="box2" label="借款人经营资质">
			<@CommonQueryMacro.Group id="group2" label="" colNm=4
			fieldStr="estaDate,regiAddr,finaDeptAddr,operAddr,operStartDate,operEndDate,enteProp,induClass,staffQuan,regiCapi,rcvCapi,operScope,enteScale,enteGrade,JuirPerDelegate,JuirPerIdentCode,realCtrlPer,realCtrlPerIdentCode"/>
			<@CommonQueryMacro.Group id="group21" label="合法经营手续" colNm=4
				fieldStr="busiLice,loanCard,orgCode,taxRegiCode,enviFlag,specOperCode"/>
		</@CommonQueryMacro.GroupBox>
	</@CommonQueryMacro.CommonQuery>
	
	<@CommonQueryMacro.CommonQuery id="PersonalOperateRptTab" init="false" submitMode="current">
		<@CommonQueryMacro.GroupBox id="box3" label="注册资本变化情况">
			<@CommonQueryMacro.Group id="group3" label="" colNm=4
			fieldStr="regiCapiChange,ifHaveCapiRpt,regiCapiChangeDesc"/>
		</@CommonQueryMacro.GroupBox>
	</@CommonQueryMacro.CommonQuery>
	
	<@CommonQueryMacro.CommonQuery id="StockStruEntry" init="false" submitMode="current">
		<@CommonQueryMacro.GroupBox id="box4" label="股权结构变化情况">
			<@CommonQueryMacro.DataTable id="stockStruTable" paginationbar="stockAdd,stockUpd,stockDel" pagination="true"
			fieldStr="sharName,sharIdentCode,contriAmt,contriRatio" width="100%" hasFrame="true"/>
			<@CommonQueryMacro.FloatWindow id="stockStruFW" modal="true" label="股东信息" 
			resize="true" minimize="false" maximize="true" closure="true" show="false" defaultZoom="normal">
				<@CommonQueryMacro.Group id="group4" label="" colNm=2
				fieldStr="sharName,sharIdentCode,contriAmt,contriRatio"/>
				<@CommonQueryMacro.Button id="stockConfirm" />
			</@CommonQueryMacro.FloatWindow>
			<@CommonQueryMacro.Group id="group5" label="" colNm=2
			fieldStr="sharStruIfChange,realCtrlPerIfChange,stockStruChangeDesc"/>
		</@CommonQueryMacro.GroupBox>
	</@CommonQueryMacro.CommonQuery>
	
	<@CommonQueryMacro.CommonQuery id="PersonalOperateRptTab" init="false" submitMode="current">
		<@CommonQueryMacro.GroupBox id="box6" label="借款人基本信息变动情况">
			<@CommonQueryMacro.Group id="group6" label="" colNm=4
			fieldStr="enteNameIfChange,orgCodeIfChange,busiLiceIfChange,taxRegiCodeIfChange,loanCardIfChange,specOperCodeIfChange,induClassIfChange,enteIdentIfLose,enteInfoChangeDesc"/>
		</@CommonQueryMacro.GroupBox>
	</@CommonQueryMacro.CommonQuery>
	
	<@CommonQueryMacro.CommonQuery id="PersonalOperateRptTab" init="false" submitMode="current">
		<@CommonQueryMacro.GroupBox id="box7" label="财务分析结论">
			<@CommonQueryMacro.Group id="group7" label="" colNm=4
			fieldStr="finaRptIfCredible,enteAmtIfChange,predRepmtSrc,loanPerFinaCond,finaAnalEval"/>
		</@CommonQueryMacro.GroupBox>
	</@CommonQueryMacro.CommonQuery>
	
	<@CommonQueryMacro.GroupBox id="box8" label="自然人保证人债项及担保信息">
		<@CommonQueryMacro.CommonQuery id="PersonalOperateRptTab" init="false" submitMode="current">
			<@CommonQueryMacro.Group id="group8" label="" colNm=4
				fieldStr="guarantorName,ourbankGuarTotAmt,othbankGuarTotAmt,ourbankLoanBal,othbankLoanBal"/>
		</@CommonQueryMacro.CommonQuery>
		<@CommonQueryMacro.CommonQuery id="OurbankCreditBusiEntry" init="false" submitMode="current">
			<@CommonQueryMacro.DataTable id="ourbankCreditBusiTable" pagination="true"
			fieldStr="contractCode,guarWay,loanAmt,balance,issueDate,matureDate,fiveLvlClass" width="100%" hasFrame="true"/>
		</@CommonQueryMacro.CommonQuery>
		<@CommonQueryMacro.CommonQuery id="OurbankGuarEntry" init="false" submitMode="current">
			<@CommonQueryMacro.DataTable id="ourbankGuarTable" pagination="true"
			fieldStr="loanPer,contractCode,guarWay,loanAmt,balance,issueDate,matureDate,fiveLvlClass" width="100%" hasFrame="true"/>
		</@CommonQueryMacro.CommonQuery>
	</@CommonQueryMacro.GroupBox>
	
	<@CommonQueryMacro.CommonQuery id="PersonalOperateRptTab" init="false" submitMode="current">
		<@CommonQueryMacro.GroupBox id="box9" label="自然人保证人信息变动情况">
			<@CommonQueryMacro.Group id="group9" label="" colNm=4
			fieldStr="relaPer,othRelaPer,guarantorWorkChange,newCompName,guarantorPhoneChange,guarantorNewPhone,guarantorAddrChange,guarantorNewAddr,guarantorIncomeChange,guarantorIncomeChange,guarantorNewPost,guarantorOperChange,guarantorInfoChangeDesc"/>
		</@CommonQueryMacro.GroupBox>
	</@CommonQueryMacro.CommonQuery>
	
	<@CommonQueryMacro.CommonQuery id="PersonalOperateRptTab" init="false" submitMode="current">
		<@CommonQueryMacro.GroupBox id="box10" label="自然人保证人担保能力分析">
			<@CommonQueryMacro.Group id="group10" label="" colNm=4
			fieldStr="guarantorWishChange,guarantorWishChangeDesc,guarantorGuarStre,guarantorGuarStreDesc"/>
		</@CommonQueryMacro.GroupBox>
	</@CommonQueryMacro.CommonQuery>
	
	<@CommonQueryMacro.GroupBox id="box11" label="借款人抵押物">
		<@CommonQueryMacro.CommonQuery id="LoanPerMortgageEntry" init="false" submitMode="current">
			<@CommonQueryMacro.DataTable id="loanPerMortgageTable" pagination="true"
			fieldStr="mortName,mortType,oldOwner,payAmt,asseTolAmt,ourbankConfAmt,validTerm,mortQty,mortRate,mortAddr" width="100%" hasFrame="true"/>
		</@CommonQueryMacro.CommonQuery>
		<@CommonQueryMacro.CommonQuery id="LoanPerMortgageEntry" init="false" submitMode="current">
			<@CommonQueryMacro.Group id="group11" label="" colNm=4
			fieldStr="mortCond,mortIfDevalue,mortAsseInsuIfExpire,mortIssueAndDesc"/>
		</@CommonQueryMacro.CommonQuery>
	</@CommonQueryMacro.GroupBox>
	
	<@CommonQueryMacro.GroupBox id="box12" label="借款人质押物">
		<@CommonQueryMacro.CommonQuery id="LoanPerCollatEntry" init="false" submitMode="current">
			<@CommonQueryMacro.DataTable id="loanPerCollatTable" pagination="true"
			fieldStr="collatName,collatType,oldOwner,payAmt,asseTolAmt,ourbankConfAmt,validTerm,collatQty,collatRate" width="100%" hasFrame="true"/>
		</@CommonQueryMacro.CommonQuery>
		<@CommonQueryMacro.CommonQuery id="LoanPerCollatEntry" init="false" submitMode="current">
			<@CommonQueryMacro.Group id="group12" label="" colNm=4
			fieldStr="collatCond,collatCondDesc,collatIfDevalue,collattImelIfExpire,collattIfLoseLawPote,collatIssueAndDesc"/>
		</@CommonQueryMacro.CommonQuery>
	</@CommonQueryMacro.GroupBox>
	
	<@CommonQueryMacro.GroupBox id="box12" label="预警信号">
		<@CommonQueryMacro.CommonQuery id="WarningEntry11" init="false" submitMode="current">
			<@CommonQueryMacro.DataTable id="warningTable" paginationbar="warnUpd" pagination="true"
			fieldStr="warnCode,warnLeve,warnName,confirmCond,confirmDesc,ifNewWarn" width="100%" hasFrame="true"/>
		</@CommonQueryMacro.CommonQuery>
	</@CommonQueryMacro.GroupBox>
	
	<@CommonQueryMacro.GroupBox id="box13" label="重大事件说明">
		<@CommonQueryMacro.CommonQuery id="PersonalOperateRptTab" init="false" submitMode="current">
			<@CommonQueryMacro.Group id="group13" label="" colNm=2
			fieldStr="loanPerIfInvoLawsuit,loanPerIfInvoLawsuitDesc"/>
		</@CommonQueryMacro.CommonQuery>
	</@CommonQueryMacro.GroupBox>
	
	<@CommonQueryMacro.GroupBox id="box14" label="控制措施">
		<@CommonQueryMacro.CommonQuery id="RiskCtrlMeasEntry" init="false" submitMode="current">
			<@CommonQueryMacro.Group id="group14" label="" colNm=2
			fieldStr="riskCtrl,otherCtrlDesc,appendCtrl,applyOpin"/>
		</@CommonQueryMacro.CommonQuery>
	</@CommonQueryMacro.GroupBox>
<script>
	function stockAdd_onClick(button) {
		StockStruEntry_dataset.insertRecord("end");
		subwindow_stockStruFW.show();
	}
	function stockUpd_onClick(button){
		subwindow_stockStruFW.show();
	}
	function stockConfirm_onClick(button){
		subwindow_stockStruFW.close();
	}
</script>
</@CommonQueryMacro.page>