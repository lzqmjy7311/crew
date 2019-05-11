<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<@CommonQueryMacro.page title="催收管理  &gt;  审核">

<@CommonQueryMacro.CommonQuery id="TPlZxrfInfo" init="true" submitMode="current">
		<@CommonQueryMacro.GroupBox id="box1" label="登记信息">
			<@CommonQueryMacro.Group id="group1" label="" colNm=4
			fieldStr="loanAccount,custCode,custName,productName,guarWay,acctStatus,riskStatus,loanBalance,arrearAmt,arrearInterests,arrearCount,postLoanPer,matureDate,tel,collectionType,arrearReason,situationExplain,receiptInfo,resultInfo,collePersonName,colleDate,registDate,controlMeasure,controlMeasureOth,operator,operBank,remark,taskRemark"/>
		</@CommonQueryMacro.GroupBox>
		<@CommonQueryMacro.Button id= "btnPass" />
	</@CommonQueryMacro.CommonQuery>
<script language="JavaScript">

function initCallGetter_post(dataset) {
	TPlZxrfInfo_dataset.setFieldReadOnly("collectionType",true);
	TPlZxrfInfo_dataset.setFieldReadOnly("situationExplain",true);
	TPlZxrfInfo_dataset.setFieldReadOnly("receiptInfo",true);
	TPlZxrfInfo_dataset.setFieldReadOnly("resultInfo",true);
	TPlZxrfInfo_dataset.setFieldReadOnly("colleDate",true);
	TPlZxrfInfo_dataset.setFieldReadOnly("registDate",true);
	TPlZxrfInfo_dataset.setFieldReadOnly("controlMeasure",true);
	TPlZxrfInfo_dataset.setFieldReadOnly("remark",true);
}




//保存后关闭页面，刷新表格
function btnPass_postSubmit(button) {
	button.url="#";
	top.easyMsg.info("操作成功！");
	window.parent.TPlZxrfInfo_dataset.flushData(window.parent.TPlZxrfInfo_dataset.pageIndex);
	window.parent.tPlZxrfInfoCheckWin.close();
}

function btnPass_onClickCheck(button){
	TPlZxrfInfo_dataset.setParameter("op","two_subbranch_hz");
	TPlZxrfInfo_dataset.setParameter("path","end");
}

</script>
</@CommonQueryMacro.page>