<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<@CommonQueryMacro.page title="参数维护  &gt;  产品管理">
	<@CommonQueryMacro.CommonQuery id="ProductEntry" init="true" submitMode="all">
		<@CommonQueryMacro.Interface id="interface1" label="请输入查询条件" colNm=6 />
		<@CommonQueryMacro.DataTable id="productTable" readonly="false" paginationbar="btAdd,btDel,btnSave" fieldStr="prodCode,prodName,prodType" width="100%" hasFrame="true"/>
		<@CommonQueryMacro.Button id="btDataDel" />
	</@CommonQueryMacro.CommonQuery>
<script>
	//页面初始化
	function initCallGetter_post(){
		$("a[id=btDataDel]").hide();
	}
	function btnSave_postSubmit(button) {
		button.url="#";
		top.easyMsg.info("保存成功！");
		flushCurrentPage();
	}
	//删除确认
  	function btDel_onClickCheck(button) {
		var bool=confirm("确认删除该条记录？");
		if(bool){
			ProductEntry_dataset.setParameter("id",ProductEntry_dataset.getValue("id"));
			btDataDel.click();
		}
		return bool;
	}
	//删除后刷新当前页
	function btDataDel_postSubmit(button) {
		button.url="#";
		top.easyMsg.info("删除成功！");
		flushCurrentPage();
	}
	//刷新当前页
	function flushCurrentPage() {
		ProductEntry_dataset.flushData(ProductEntry_dataset.pageIndex);
	}
</script>
</@CommonQueryMacro.page>