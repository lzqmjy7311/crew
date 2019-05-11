<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="DataDicEntry.title">
<@CommonQueryMacro.CommonQuery id="DataDicInfo" init="true" insertOnEmpty="true">
	<@CommonQueryMacro.Group id ="group1" label="数据字典信息" fieldStr="dataTypeNo,dataTypeName,dataNo,dataName,dataNoLen" colNm=4/>
	<div style="text-align:center"><@CommonQueryMacro.Button id= "btSave"/></div>
</@CommonQueryMacro.CommonQuery>
<script language="javascript"> 
var op = "${RequestParameters["op"]?default('')}";
//当页面初始化完之后可以调用该方法执行需要处理的操
function initCallGetter_post(dataset) {
	if ("new" == op) {
		
	} else {
		DataDicInfo_dataset.setFieldReadOnly("dataTypeNo",true);
		DataDicInfo_dataset.setFieldReadOnly("dataTypeName",true);
		DataDicInfo_dataset.setFieldReadOnly("dataNoLen",true);
	}
}
function btSave_onClickCheck(button) {
	var dataNoLen = DataDicInfo_dataset.getValue("dataNoLen");
	var len = DataDicInfo_dataset.getValue("dataNo").length;
	if(len != dataNoLen) {
		alert('[字典码]长度和[字典长度]值不符');
		return false;
	}
	return true;
}
function btSave_postSubmit() {
	parent.refreshds();
	parent.pageWin.close();
}

</script>
</@CommonQueryMacro.page>
