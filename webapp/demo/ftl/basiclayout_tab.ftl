<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="demo_field_1">
	<@CommonQueryMacro.LayoutPanel id="cc" >
		<@CommonQueryMacro.LayoutNorth height="60" split="false">
			<h2>north</h2>
		</@CommonQueryMacro.LayoutNorth>
		<@CommonQueryMacro.LayoutCenter title="center">
			<h2>center</h2>
		</@CommonQueryMacro.LayoutCenter>
		<@CommonQueryMacro.LayoutWest title="west" width="200" split="true" >
			<h2>west</h2>
		</@CommonQueryMacro.LayoutWest>
		<@CommonQueryMacro.LayoutSouth height="60" split="false">
			<h2>south</h2>
		</@CommonQueryMacro.LayoutSouth>
		<@CommonQueryMacro.LayoutEast title="east" width="200" split="true">
			<h2>east</h2>
		</@CommonQueryMacro.LayoutEast>
	</@CommonQueryMacro.LayoutPanel>	
</@CommonQueryMacro.page>