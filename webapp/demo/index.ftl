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
	<@CommonQueryMacro.LayoutWest title="���" width="200" split="true" >
		<@CommonQueryMacro.AccordionGroup id="menu" selected="menu1">
			<@CommonQueryMacro.Accordion id="menu1" title="��(Group)">
				<@CommonQueryMacro.SimpleButton plain="true" onclick="openTab('/demo/ftl/textinput.ftl')" desc="�ı���"/>
				<@CommonQueryMacro.SimpleButton plain="true" onclick="openTab('/demo/ftl/dateinput.ftl')" desc="����ѡ���"/>
				<@CommonQueryMacro.SimpleButton plain="true" onclick="openTab('/demo/ftl/select.ftl')" desc="ѡ����������"/>
				<@CommonQueryMacro.SimpleButton plain="true" onclick="openTab('/demo/ftl/validate.ftl')" desc="����֤"/>
				<@CommonQueryMacro.SimpleButton plain="true" onclick="openTab('/demo/ftl/button.ftl')" desc="��ť"/>
			</@CommonQueryMacro.Accordion>
			<@CommonQueryMacro.Accordion id="menu2" title="���(DataTable)">
				<@CommonQueryMacro.SimpleButton plain="true" onclick="openTab('/demo/ftl/datagrid_default.ftl')" desc="��ͨ���"/>
				<@CommonQueryMacro.SimpleButton plain="true" onclick="openTab('/demo/ftl/datagrid_toolbar.ftl')" desc="��ͨ���-������"/>
				<#-- <@CommonQueryMacro.SimpleButton plain="true" onclick="openTab('/demo/ftl/datagrid_sort.ftl')" desc="�������"/> -->
				<@CommonQueryMacro.SimpleButton plain="true" onclick="openTab('/demo/ftl/datagrid_multiselect.ftl')" desc="��ѡ���"/>
				<@CommonQueryMacro.SimpleButton plain="true" onclick="openTab('/demo/ftl/datagrid_multihead.ftl')" desc="���ͷ���"/>
				<@CommonQueryMacro.SimpleButton plain="true" onclick="openTab('/demo/ftl/datagrid_frozen.ftl')" desc="�����б��"/>
				<@CommonQueryMacro.SimpleButton plain="true" onclick="openTab('/demo/ftl/datagrid_editable.ftl')" desc="�ɱ༭���"/>
				<#-- <@CommonQueryMacro.SimpleButton plain="true" onclick="openTab('/demo/ftl/datagrid_page.ftl')" desc="ǰ̨��ҳ���"/> -->
				<@CommonQueryMacro.SimpleButton plain="true" onclick="openTab('/demo/ftl/datagrid_merge_tab.ftl')" desc="�кϲ����"/>
				<@CommonQueryMacro.SimpleButton plain="true" onclick="openTab('/demo/ftl/datagrid_summary.ftl')" desc="�ϼƱ��(��̨)"/>
				<@CommonQueryMacro.SimpleButton plain="true" onclick="openTab('/demo/ftl/datagrid_cachecount_tab.ftl')" desc="��ҳ������"/>
			</@CommonQueryMacro.Accordion>
			<@CommonQueryMacro.Accordion id="menu3" title="����(Window)">
				<@CommonQueryMacro.SimpleButton plain="true" onclick="openTab('/demo/ftl/messagebox.ftl')" desc="��ʾ��"/>
				<@CommonQueryMacro.SimpleButton plain="true" onclick="openTab('/demo/ftl/dialog.ftl')" desc="�Ի���"/>
				<@CommonQueryMacro.SimpleButton plain="true" onclick="openTab('/demo/ftl/dialog_iframe.ftl')" desc="��������"/>
			</@CommonQueryMacro.Accordion>
			<@CommonQueryMacro.Accordion id="menu4" title="�˵�(Menu)">
				<@CommonQueryMacro.SimpleButton plain="true" onclick="openTab('/demo/ftl/contextmenu.ftl')" desc="�Ҽ��˵�"/>
			</@CommonQueryMacro.Accordion>
			<@CommonQueryMacro.Accordion id="menu5" title="��(Tree)">
				<@CommonQueryMacro.SimpleButton plain="true" onclick="openTab('/demo/tab/dynamictree_tab.ftl')" desc="��̬��"/>
				<@CommonQueryMacro.SimpleButton plain="true" onclick="openTab('/demo/tab/statictree_tab.ftl')" desc="��̬��(��̨����,Ч�ʸ�)"/>
			</@CommonQueryMacro.Accordion>
			<@CommonQueryMacro.Accordion id="menu6" title="����(Layout)">
				<@CommonQueryMacro.SimpleButton plain="true" onclick="openTab('/demo/ftl/basiclayout.ftl')" desc="��ͨ����"/>
				<@CommonQueryMacro.SimpleButton plain="true" onclick="openTab('/demo/ftl/nestedlayout.ftl')" desc="Ƕ�ײ���"/>
				<@CommonQueryMacro.SimpleButton plain="true" onclick="openTab('/demo/ftl/statictab.ftl')" desc="��̬��ǩҳ1"/>
				<@CommonQueryMacro.SimpleButton plain="true" onclick="openTab('/demo/ftl/statictab2.ftl')" desc="��̬��ǩҳ2"/>
				<@CommonQueryMacro.SimpleButton plain="true" onclick="openTab('/demo/ftl/dynamictab.ftl')" desc="��̬��ǩҳ"/>
				<@CommonQueryMacro.SimpleButton plain="true" onclick="openTab('/demo/ftl/accordion.ftl')" desc="�����˵�"/>
				<@CommonQueryMacro.SimpleButton plain="true" onclick="openTab('/demo/ftl/accordionAsyc.ftl')" desc="�����˵�(�첽)"/>
			</@CommonQueryMacro.Accordion>
			<@CommonQueryMacro.Accordion id="menu8" title="���(Component)">
				<@CommonQueryMacro.SimpleButton plain="true" onclick="openTab('/demo/ftl/component1.ftl')" desc="�������1"/>
			</@CommonQueryMacro.Accordion>
			<@CommonQueryMacro.Accordion id="menu7" title="����">
				<@CommonQueryMacro.SimpleButton plain="true" onclick="openTab('/demo/ftl/demo.ftl')" desc="����1"/>
				<@CommonQueryMacro.SimpleButton plain="true" onclick="openTab('/demo/ftl/demo2.ftl')" desc="����2"/>
				<@CommonQueryMacro.SimpleButton plain="true" onclick="openTab('/demo/ftl/demo3.ftl')" desc="����3"/>
				<@CommonQueryMacro.SimpleButton plain="true" onclick="openTab('/demo/ftl/demo_switch.ftl')" desc="΢����ʾ��"/>
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