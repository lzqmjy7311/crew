<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />

<#assign custId=RequestParameters["custId"]?default("")>

<@CommonQueryMacro.page title="增加重大事件">
	<table>
		<tr>
			<td>
				<@CommonQueryMacro.CommonQuery id="GreatEventDtl" init="true" submitMode="current">
					<@CommonQueryMacro.Group id="GreatEventDtlGroup" label="" colNm=2 labelwidth="150" 
					fieldStr="lawsuit,lawsuitDesc,debt,debtDesc,cooperation,cooperationDesc,falseData,falseDataDesc,worsen,worsenDesc,divertProperty,divertPropertyDesc,gaiZhi,gaiZhiDesc,revokeCert,revokeCertDesc,stopProd,stopProdDesc,bankruptcy,bankruptcyDesc,negaInfluence,negaInfluenceDesc,greatDisaster,greatDisasterDesc,invest,investDesc,otherGreatEvent,otherGreatEventDesc"/>
					<center>
						<@CommonQueryMacro.Button id= "btnSave"/>
					</center>
				</@CommonQueryMacro.CommonQuery>
			</td>
		</tr>
	</table>
<script>
	//页面初始化
	function initCallGetter_post(){
		var custId='${custId}';
		GreatEventDtl_dataset.setParameter("custId",custId);
	}
	//保存后关闭页面，刷新表格
	function btnSave_postSubmit(button) {
		button.url="#";
		top.easyMsg.info("保存成功！");
		window.parent.eventWin_close();
	}
</script>
</@CommonQueryMacro.page>