<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="Accordion">
	<@CommonQueryMacro.LayoutPanel id="cc" >
		<@CommonQueryMacro.LayoutWest width="200" >
			<@CommonQueryMacro.CommonQuery id="AccordionMenu" init="true" submitMode="current" navigate="false">
				<@CommonQueryMacro.AccordionMenu id="group" selected="2"/>
			</@CommonQueryMacro.CommonQuery>
		</@CommonQueryMacro.LayoutWest>
		<@CommonQueryMacro.LayoutCenter>
			<iframe id="main" src="" style="width:100%;height:100%"></iframe>
		</@CommonQueryMacro.LayoutCenter>
	</@CommonQueryMacro.LayoutPanel>	
	<script>
	
	<#-- 叶子菜单单击事件句柄AccordionMenu_{id}_onClick -->
	function AccordionMenu_group_onClick(record, node) {
		if(!record.getValue("url")){
			alert("you click:"+node.text);
		}else{
			//openSubWin(node.id, "打开URL", node.attributes.url)
			$('#main').attr('src', _application_root+ record.getValue("url"));
		}
	}
	</script>
</@CommonQueryMacro.page>