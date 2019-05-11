<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="Demo">
<@CommonQueryMacro.LayoutPanel id="cc" >
	<@CommonQueryMacro.LayoutNorth height="50" split="false">
		<div class="demo-header" ><div class="demo-header-banner" >&nbsp;</div></div>
	</@CommonQueryMacro.LayoutNorth>
	<@CommonQueryMacro.LayoutCenter>
		<@CommonQueryMacro.DynamicTabSet id="tabs" hasMenu="true" selected="b">
		</@CommonQueryMacro.DynamicTabSet>
	</@CommonQueryMacro.LayoutCenter>
	<@CommonQueryMacro.LayoutWest title="组件" width="200" split="true" >
		<@CommonQueryMacro.AccordionGroup id="menu" selected="menu1">
			<@CommonQueryMacro.Accordion id="menu1" title="表单(Group)">
				<@CommonQueryMacro.SimpleButton plain="true" onclick="openTab('/demo/ftl/textinput.ftl')" desc="文本框"/>
				<@CommonQueryMacro.SimpleButton plain="true" onclick="openTab('/demo/ftl/dateinput.ftl')" desc="日期选择框"/>
				<@CommonQueryMacro.SimpleButton plain="true" onclick="openTab('/demo/ftl/select.ftl')" desc="选择与下拉框"/>
				<@CommonQueryMacro.SimpleButton plain="true" onclick="openTab('/demo/ftl/validate.ftl')" desc="表单验证"/>
				<@CommonQueryMacro.SimpleButton plain="true" onclick="openTab('/demo/ftl/button.ftl')" desc="按钮"/>
			</@CommonQueryMacro.Accordion>
			<@CommonQueryMacro.Accordion id="menu2" title="表格(DataTable)">
				<@CommonQueryMacro.SimpleButton plain="true" onclick="openTab('/demo/ftl/datagrid_default.ftl')" desc="普通表格"/>
				<@CommonQueryMacro.SimpleButton plain="true" onclick="openTab('/demo/ftl/datagrid_toolbar.ftl')" desc="普通表格-工具栏"/>
				<#-- <@CommonQueryMacro.SimpleButton plain="true" onclick="openTab('/demo/ftl/datagrid_sort.ftl')" desc="表格排序"/> -->
				<@CommonQueryMacro.SimpleButton plain="true" onclick="openTab('/demo/ftl/datagrid_multiselect.ftl')" desc="多选表格"/>
				<@CommonQueryMacro.SimpleButton plain="true" onclick="openTab('/demo/ftl/datagrid_multihead.ftl')" desc="多表头表格"/>
				<@CommonQueryMacro.SimpleButton plain="true" onclick="openTab('/demo/ftl/datagrid_frozen.ftl')" desc="冻结列表格"/>
				<@CommonQueryMacro.SimpleButton plain="true" onclick="openTab('/demo/ftl/datagrid_editable.ftl')" desc="可编辑表格"/>
				<#-- <@CommonQueryMacro.SimpleButton plain="true" onclick="openTab('/demo/ftl/datagrid_page.ftl')" desc="前台分页表格"/> -->
				<@CommonQueryMacro.SimpleButton plain="true" onclick="openTab('/demo/ftl/datagrid_merge_tab.ftl')" desc="行合并表格"/>
				<@CommonQueryMacro.SimpleButton plain="true" onclick="openTab('/demo/ftl/datagrid_summary.ftl')" desc="合计表格(后台)"/>
				<@CommonQueryMacro.SimpleButton plain="true" onclick="openTab('/demo/ftl/datagrid_cachecount_tab.ftl')" desc="分页缓存表格"/>
			</@CommonQueryMacro.Accordion>
			<@CommonQueryMacro.Accordion id="menu3" title="窗口(Window)">
				<@CommonQueryMacro.SimpleButton plain="true" onclick="openTab('/demo/ftl/messagebox.ftl')" desc="提示框"/>
				<@CommonQueryMacro.SimpleButton plain="true" onclick="openTab('/demo/ftl/dialog.ftl')" desc="对话框"/>
				<@CommonQueryMacro.SimpleButton plain="true" onclick="openTab('/demo/ftl/dialog_iframe.ftl')" desc="弹出窗口"/>
			</@CommonQueryMacro.Accordion>
			<@CommonQueryMacro.Accordion id="menu4" title="菜单(Menu)">
				<@CommonQueryMacro.SimpleButton plain="true" onclick="openTab('/demo/ftl/contextmenu.ftl')" desc="右键菜单"/>
			</@CommonQueryMacro.Accordion>
			<@CommonQueryMacro.Accordion id="menu5" title="树(Tree)">
				<@CommonQueryMacro.SimpleButton plain="true" onclick="openTab('/demo/tab/dynamictree_tab.ftl')" desc="动态树"/>
				<@CommonQueryMacro.SimpleButton plain="true" onclick="openTab('/demo/tab/statictree_tab.ftl')" desc="静态树(后台生成,效率高)"/>
			</@CommonQueryMacro.Accordion>
			<@CommonQueryMacro.Accordion id="menu6" title="布局(Layout)">
				<@CommonQueryMacro.SimpleButton plain="true" onclick="openTab('/demo/ftl/basiclayout.ftl')" desc="普通布局"/>
				<@CommonQueryMacro.SimpleButton plain="true" onclick="openTab('/demo/ftl/nestedlayout.ftl')" desc="嵌套布局"/>
				<@CommonQueryMacro.SimpleButton plain="true" onclick="openTab('/demo/ftl/statictab.ftl')" desc="静态标签页1"/>
				<@CommonQueryMacro.SimpleButton plain="true" onclick="openTab('/demo/ftl/statictab2.ftl')" desc="静态标签页2"/>
				<@CommonQueryMacro.SimpleButton plain="true" onclick="openTab('/demo/ftl/dynamictab.ftl')" desc="动态标签页"/>
				<@CommonQueryMacro.SimpleButton plain="true" onclick="openTab('/demo/ftl/accordion.ftl')" desc="滑动菜单"/>
				<@CommonQueryMacro.SimpleButton plain="true" onclick="openTab('/demo/ftl/accordionAsyc.ftl')" desc="滑动菜单(异步)"/>
			</@CommonQueryMacro.Accordion>
			<@CommonQueryMacro.Accordion id="menu8" title="组件(Component)">
				<@CommonQueryMacro.SimpleButton plain="true" onclick="openTab('/demo/ftl/component1.ftl')" desc="组件范例1"/>
			</@CommonQueryMacro.Accordion>
			<@CommonQueryMacro.Accordion id="menu7" title="范例">
				<@CommonQueryMacro.SimpleButton plain="true" onclick="openTab('/demo/ftl/demo.ftl')" desc="范例1"/>
				<@CommonQueryMacro.SimpleButton plain="true" onclick="openTab('/demo/ftl/demo2.ftl')" desc="范例2"/>
				<@CommonQueryMacro.SimpleButton plain="true" onclick="openTab('/demo/ftl/demo3.ftl')" desc="范例3"/>
				<@CommonQueryMacro.SimpleButton plain="true" onclick="openTab('/demo/ftl/demo_switch.ftl')" desc="微交换示例"/>
			</@CommonQueryMacro.Accordion>
		</@CommonQueryMacro.AccordionGroup>
	</@CommonQueryMacro.LayoutWest>
</@CommonQueryMacro.LayoutPanel>

<script>
	function openTab(url) {
		var target;
		if($.browser.mozilla) {
			target = openTab.caller.arguments[0].currentTarget;
		} else {
			target = event.srcElement;
		}
		tabs_tabset.add({id:$(target).text(),title:$(target).text(),url:url});
	}
</script>
</@CommonQueryMacro.page>