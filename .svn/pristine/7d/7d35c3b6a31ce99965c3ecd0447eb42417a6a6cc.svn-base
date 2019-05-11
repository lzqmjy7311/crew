<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />

<#assign custId=RequestParameters["custId"]?default("")>

<@CommonQueryMacro.page title="查看重大事件">
	<@CommonQueryMacro.LayoutPanel id="cc" >
		<@CommonQueryMacro.LayoutNorth height="182" split="false">
			<@CommonQueryMacro.CommonQuery id="GreatEvent" init="true" submitMode="current">
				<@CommonQueryMacro.DataTable id="GreatEventDataTable" paginationbar="" 
				fieldStr="registerUser,registerDate" width="100%" hasFrame="true"/>
			</@CommonQueryMacro.CommonQuery>
		</@CommonQueryMacro.LayoutNorth>
		<@CommonQueryMacro.LayoutCenter title="详细信息">
			<@CommonQueryMacro.CommonQuery id="GreatEventDtl" init="true" submitMode="current">
				<@CommonQueryMacro.Group id="GreatEventDtlGroup" label="" colNm=2 labelwidth="400" 
				fieldStr="lawsuit,lawsuitDesc,debt,debtDesc,cooperation,cooperationDesc,falseData,falseDataDesc,worsen,worsenDesc,divertProperty,divertPropertyDesc,gaiZhi,gaiZhiDesc,revokeCert,revokeCertDesc,stopProd,stopProdDesc,bankruptcy,bankruptcyDesc,negaInfluence,negaInfluenceDesc,greatDisaster,greatDisasterDesc,invest,investDesc,otherGreatEvent,otherGreatEventDesc"/>
			</@CommonQueryMacro.CommonQuery>
		</@CommonQueryMacro.LayoutCenter>
	</@CommonQueryMacro.LayoutPanel>
<script>
	//页面初始化
	function initCallGetter_post(){
		var custId='${custId}';
		GreatEventDtl_dataset.setParameter("custId",custId);
		GreatEvent_dataset.setParameter("custId",custId);
		GreatEventDtl_dataset.setReadOnly(true);
	}
	function GreatEvent_dataset_afterScroll(){
		var record=(GreatEvent_dataset.record);
		if(record){
			GreatEventDtl_dataset.setParameter("eventId",record.getValue("id"));
			GreatEventDtl_dataset.flushData(GreatEventDtl_dataset.pageIndex);
		}
	}
	//保存后关闭窗口，刷新表格
	function btnSave_postSubmit(button) {
		button.url="#";
		top.easyMsg.info("保存成功！");
		window.parent.eventWin_close();
	}
</script>
</@CommonQueryMacro.page>