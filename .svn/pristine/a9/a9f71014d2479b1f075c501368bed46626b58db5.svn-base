<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="Accordion">
	<@CommonQueryMacro.LayoutPanel id="cc" >
		<@CommonQueryMacro.LayoutWest width="200" >
			<@CommonQueryMacro.CommonQuery id="AccordionMenuAsyc" init="true" submitMode="current" navigate="false" >
				<@CommonQueryMacro.AccordionMenu id="group"  aysc="true"/>
			</@CommonQueryMacro.CommonQuery>
		</@CommonQueryMacro.LayoutWest>
		<@CommonQueryMacro.LayoutCenter>
			<div id="main"></div>
		</@CommonQueryMacro.LayoutCenter>
	</@CommonQueryMacro.LayoutPanel>	
	<script>
	
	<#-- 叶子菜单单击事件句柄AccordionMenu_{id}_onClick -->
	function AccordionMenu_group_onClick(record, node) {
		$('#main').text("you click Record:"+record);
	}
	$(function(){
		AccordionMenu_group.select(0)
	});
	</script>
</@CommonQueryMacro.page>