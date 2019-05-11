<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="demo_field_1">
	<@CommonQueryMacro.LayoutPanel id="cc" >
		<@CommonQueryMacro.LayoutNorth height="60" split="false">
			<h2>north</h2>
		</@CommonQueryMacro.LayoutNorth>
		<@CommonQueryMacro.LayoutCenter title="center">
				<#-- 嵌套时内部面板的inbody值要设定成false -->
				<@CommonQueryMacro.LayoutPanel id="cc2" inbody="false" >
					<@CommonQueryMacro.LayoutNorth height="50" split="false">
						<h3>north2</h3>
					</@CommonQueryMacro.LayoutNorth>
					<@CommonQueryMacro.LayoutCenter title="center2">
						<h3>center2</h3>
					</@CommonQueryMacro.LayoutCenter>
					<@CommonQueryMacro.LayoutWest title="west2" width="200" split="true" >
						<h3>west2</h3>
					</@CommonQueryMacro.LayoutWest>
					<@CommonQueryMacro.LayoutSouth height="50" split="false">
						<h3>south2</h3>
					</@CommonQueryMacro.LayoutSouth>
					<@CommonQueryMacro.LayoutEast title="east2" width="200" split="true">
						<h3>east2</h3>
					</@CommonQueryMacro.LayoutEast>
				</@CommonQueryMacro.LayoutPanel>	
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