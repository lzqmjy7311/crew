<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="���˵�">
	<@CommonQueryMacro.CommonQuery id="LeftAccordionMenu" init="true" submitMode="current" navigate="false">
		<@CommonQueryMacro.AccordionMenu id="leftmenu" aysc="true"/>
	</@CommonQueryMacro.CommonQuery>
	<script>
	<#-- Ҷ�Ӳ˵������¼����AccordionMenu_{id}_onClick -->
	function AccordionMenu_leftmenu_onClick(record, node) {
		if(record.getValue("url")){
			parent.doWork(record.getValue("id"),record.getValue("title"),record.getValue("url"),record.getValue("id"));
		}else{
			 
		}
	}
	</script>
</@CommonQueryMacro.page>