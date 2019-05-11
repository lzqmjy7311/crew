<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<@CommonQueryMacro.page title="DataDicEntry.title">
<@CommonQueryMacro.CommonQuery id="DataDicEntry" init="false" submitMode="current">
	<@CommonQueryMacro.Interface id="interface" label="DataDicEntry.interface.interface.label" />
	<@CommonQueryMacro.DataTable id="datatable1" paginationbar="btNew,-,btCopyNew" fieldStr="dataTypeNo[80],dataTypeName[150],dataNo[80],dataName,opr[120]"  width="100%" hasFrame="true" height="100%" readonly="true"/>
	<div style="display:none">
	<@CommonQueryMacro.Button id= "btDel"/> 
	</div>
</@CommonQueryMacro.CommonQuery>
<#include "/fpages/datadic/ftl/DataDicDetail.ftl">
<script language="JavaScript">

//当系统刷新单元格的内容时被触发 
function datatable1_opr_onRefresh(cell,value,record) {
	if (record) {//当存在记录时
		cell.innerHTML="<a href='JavaScript:doModify(\""+value+"\")'><@bean.message key="DataDicEntry.button.btMod" /></a> &nbsp; <a href='JavaScript:doDelete(\""+value+"\")'><@bean.message key="DataDicEntry.button.btDel" /></a>";
	} else {//当不存在记录时
		cell.innerHTML="&nbsp;";
	}
}
//定位一条记录
function locate(id) {
	var record = DataDicEntry_dataset.find(["id"],[id]);
	if (record) {
		DataDicEntry_dataset.setRecord(record); 
	}
}
function refreshds() {
	DataDicEntry_dataset.flushData(DataDicEntry_dataset.pageIndex);
}
var pageWin;
function btNew_onClickCheck() {
	pageWin = openSubWin("pageWin", "新增", "/fpages/datadic/ftl/DataDicAdd.ftl?op=new");
	return false;
}
//修改
function doModify(id) {
	pageWin = openSubWin("pageWin", "修改", "/fpages/datadic/ftl/DataDicAdd.ftl?op=mod&id="+id);
}

function doModify_postSubmit(button) {
	refreshds();
}

//删除
function doDelete(id) {
	top.easyMsg.confirm("确认删除该数据？",function(){
		locate(id);
		window.document.getElementById('btDel').click();
	}, function(){ 
        return false;
    }); 
}

//删除后处理
function btDel_postSubmit(button) {
	refreshds();
}

function btCopyNew_onClickCheck(button) {
	if (DataDicEntry_dataset.length==0) {
		alert("无法复制");
		return false;
	}
	pageWin = openSubWin("pageWin", "复制新增", "/fpages/datadic/ftl/DataDicAdd.ftl?op=copynew&id="+DataDicEntry_dataset.getValue("id"));
	return false;
}
function btDel_needCheck(button) {
	return false;
}
function datatable1_dataTypeNo_onHeaderClick(table,cell) {
	//alert(cell)
}


function _dataset_sort(dataset, fields) {
	dataset.sortFields = fields;
	var firstChar = fields.substring(0, 1);
	var ascend = 'asc';
	if ('-' == firstChar) {
		fields = fields.substring(1);
		ascend = 'desc';
	}
	if ('+' == firstChar) {
		fields = fields.substring(1);
		ascend = 'asc';
	}
	var f = dataset.getField(fields);
	var column = f.varname;//这里使用的是XML中field的varname属性,需要在CommonQueryTagMacro.ftl中
	if (column) {
		dataset.setParameter('orderby', column);
		dataset.setParameter('ascend', ascend);
		dataset.flushData(dataset.pageIndex);
	}
}
</script>
</@CommonQueryMacro.page>