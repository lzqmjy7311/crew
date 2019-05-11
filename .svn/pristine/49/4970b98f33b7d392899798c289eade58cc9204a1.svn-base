<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<@CommonQueryMacro.page title="基础信息管理  &gt;  用户">
<@CommonQueryMacro.CommonQuery id="LikmUser" init="true" submitMode="current">
<@CommonQueryMacro.Interface id="aaaaa" label="请输入查询条件" />
</@CommonQueryMacro.CommonQuery>

<@CommonQueryMacro.DataTable id="usertable" paginationbar="btAdd,btDel" fieldStr="userName,userDesc" width="100%" hasFrame="true"/>
<@CommonQueryMacro.FloatWindow id="detailFW" modal="true" label="详细属性" 
resize="true" width="800" minimize="false" maximize="true" closure="true" show="false" defaultZoom="normal">
	<@CommonQueryMacro.DynamicTabSet id="demotab" hasMenu="true" height="" selected="t2">
        <@CommonQueryMacro.DynamicTab id="t1" title="用户基本信息" url="/gbicc-pages/user_test/ftl/user_mng_tab.ftl">
        </@CommonQueryMacro.DynamicTab>
        <@CommonQueryMacro.DynamicTab id="t2" title="个人按揭类定期监控报告" url="/gbicc-pages/user_test/ftl/personal_consume_rpt_tab.ftl">
        </@CommonQueryMacro.DynamicTab>
        <@CommonQueryMacro.DynamicTab id="t3" title="个人经营类定期监控报告" url="/gbicc-pages/user_test/ftl/personal_operate_rpt_tab.ftl">
        </@CommonQueryMacro.DynamicTab>
    </@CommonQueryMacro.DynamicTabSet>
    <@CommonQueryMacro.Button id="btnSave" />
</@CommonQueryMacro.FloatWindow>
<script>
    function usertable_onDbClick(){
        subwindow_detailFW.show();
    }
    function btAdd_onClick(button) {
    	LikmUser_dataset.insertRecord("end");
		subwindow_detailFW.show();
	}
  	//保存后刷新当前页
	function btnSave_postSubmit(button) {
		button.url="#";
		subwindow_detailFW.close();
	}
  	//删除确认
  	function btDel_onClickCheck(button) {
		return confirm("确认删除该条记录？");
	}
	//删除后刷新当前页
	function btDel_postSubmit(button) {
		button.url="#";
		flushCurrentPage();
	}
	//刷新当前页
	function flushCurrentPage() {
		LikmUser_dataset.flushData(LikmUser_dataset.pageIndex);
	}
</script>
</@CommonQueryMacro.page>