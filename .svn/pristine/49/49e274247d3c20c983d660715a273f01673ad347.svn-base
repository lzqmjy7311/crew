<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="Accordion">
	<#assign result = statics["com.huateng.fp.demo.getter.AccordionMenuGetter"].getContextMenuString()>
	<h2>右击显示菜单</h2>
	<@CommonQueryMacro.MenuItem id="mm" json=result />
	<@CommonQueryMacro.ContextMenu menuref="mm" />
	<div>
		<button>aaa</button>
		<#-- iframe无效 -->
		<#-- <iframe scr="http://www.baidu.com" width="200" height="300" /> -->
	</div>
	<script>
		function Menu_mm_onClick(node){
			alert("you click:"+node.text);
		}

	</script>
</@CommonQueryMacro.page>