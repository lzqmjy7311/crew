<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<@CommonQueryMacro.page title="个人按揭类定期监控报告">

	<@CommonQueryMacro.CommonQuery id="plWarnDisposalRep" init="true" submitMode="current">
		<@CommonQueryMacro.GroupBox id="box1" label="客户基本信息">
			<@CommonQueryMacro.Group id="group1" label="" colNm=4
			fieldStr="loanAccount,custCode,custName,industry,productName,loanAmount,loanBalance,guaranteeMethod,slidingScales,accountStatus,riskClass,visitWay,visitAdd,leadInvestigator,assInvestigator,surveyDate"/>
		</@CommonQueryMacro.GroupBox>

		<@CommonQueryMacro.GroupBox id="box2" label="预警信号情况">
			
				<@CommonQueryMacro.Group id="group2" label="" colNm=2
				fieldStr="warnCode,affPerDesc,warnLEvel,checkStatus,checkDesc"/>
									
		</@CommonQueryMacro.GroupBox>

		<@CommonQueryMacro.GroupBox id="box5" label="控制措施">
		<@CommonQueryMacro.Group id="group5" label="风险控制措施" colNm=2
				fieldStr="creLimconMeasures,otherConMeasures"/>
		<@CommonQueryMacro.Group id="group5" label="" colNm=2
				fieldStr="addConMeasures,declarationOpi"/>
		
		
						
		</@CommonQueryMacro.GroupBox>
	

		<@CommonQueryMacro.GroupBox id="box5" label="重大事件说明">
				<@CommonQueryMacro.Group id="group4" label="" colNm=2
				fieldStr="isZdzqzwjfflss,isZdzqzwjfflssDesc,isEytfyhzf,isEytfyhzfDesc,isTdfsbh,isTdfsbhDesc,isTgxjzl,isTgxjzlDesc,isCweh,isCwehDesc,isZyzc,isZyzcDesc,isCzlhhfccg,isCzlhhfccgDesc,isZzdx,isZzdxDesc,isTcbtc,isTcbtcDesc,isPcbpc,isPcbpcDesc,isFmbd,isFmbdDesc,isZdzh,isZdzhDesc,isBsxxycs,isBsxxycsDesc,isXysmsx,isXysmsxDesc"/>
		</@CommonQueryMacro.GroupBox>
	<@CommonQueryMacro.Button id="loanPerUpd" />	
	</@CommonQueryMacro.CommonQuery>
<script>
	//function PersonRptTab_dataset_onSetValue(ds,curretField,val){
		//if(curretField.name=='radio'){
			//return val;
		//}
		//console.log(val);
	//}
	function loanPerAdd_onClick(button) {
		plWarnDisposalRep_dataset.insertRecord("end");
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