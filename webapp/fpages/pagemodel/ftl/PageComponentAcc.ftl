<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#import "/templets/commonQuery/FPPageComponent.ftl" as FPPageComponent>
<#macro PageComponentAcc fpPageItem width="100%" height="100%">
		<@CommonQueryMacro.LayoutPanel id="cc" >
		<@CommonQueryMacro.LayoutWest width="220" >
			<table>
				<tr>
					<td height="250" valign="top">
						 <@FPPageComponent.AccordionNavigation fpPageItem=fpPageItem width=width height=height />
					</td>
				</tr>
				<tr>
					<td>
					<P> ´ýÌí¼Ó </P>
					</td>
				</tr>
			</table>
		</@CommonQueryMacro.LayoutWest>
		<@CommonQueryMacro.LayoutCenter>
		<#assign id=fpPageItem.getOpItemId()?default('')>
		<#assign isCoainOpt=FPPageComponent.isContainOpt(id)>
		<#if isCoainOpt>
			<@CommonQueryMacro.LayoutPanel id="cc1" inbody="false">
				 <@CommonQueryMacro.LayoutNorth  height="26" >
					 <@FPPageComponent.ButtonCenter fpPageItem=fpPageItem width=width height=height style="horizontal" position="left"/>
				</@CommonQueryMacro.LayoutNorth>
				<@CommonQueryMacro.LayoutCenter>
					<iframe id="main" src="" style="width:100%;height:100%" frameborder="0"></iframe>
				</@CommonQueryMacro.LayoutCenter>
			</@CommonQueryMacro.LayoutPanel>	
		<#else>
			<iframe id="main" src="" style="width:100%;height:100%" frameborder="0"></iframe>
		</#if>
		</@CommonQueryMacro.LayoutCenter>
	</@CommonQueryMacro.LayoutPanel>	
	<script type="text/javascript">
		function openTab(url) {
			$('#main').attr('src', _application_root + url);
		}
	</script>	
</#macro>