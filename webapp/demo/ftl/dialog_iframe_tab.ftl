<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="µ¯³ö¿ò">
<input id="btn1" type="button" value="show(include)" onclick="show1()"/>
<input id="btn2" type="button" value="show(iframe)"  onclick="show2()"/>
<hr/>
<input id="btn3" type="button" value="floatwindow top"  onclick="show3(1)"/>
<input id="btn3" type="button" value="floatwindow current"  onclick="show3(2)"/>
<input id="btn3" type="button" value="floatwindow center"  onclick="show3(3)"/>
<@CommonQueryMacro.FloatWindow id="detailFW1" position="top"  label="" width="" resize="true" defaultZoom="normal" minimize="false" maximize="false" closure="true" float="true" exclusive="true" show="false" >
	<div style="width:500px;height:300px;background-color:gray;">
	</div>
</@CommonQueryMacro.FloatWindow>
<@CommonQueryMacro.FloatWindow id="detailFW2" position="current"  label="" width="" resize="true" defaultZoom="normal" minimize="false" maximize="false" closure="true" float="true" exclusive="true" show="false" >
	<div style="width:500px;height:300px;background-color:gray;">
	</div>
</@CommonQueryMacro.FloatWindow>
<@CommonQueryMacro.FloatWindow id="detailFW3" position="center"  label="" width="" resize="true" defaultZoom="normal" minimize="false" maximize="false" closure="true" float="true" exclusive="true" show="false" >
	<div style="width:500px;height:300px;background-color:gray;">
	</div>
</@CommonQueryMacro.FloatWindow>
<script>
function show1(){
	var paramMap = new Map();
	loadPageWindows("pageWinId1", "show(include)", "/demo/ftl/datagrid_default_tab.ftl",paramMap,"winZone");
}
function show2(){
	openSubWin("pageWinId2", "show(iframe)", "/demo/ftl/datagrid_default_tab.ftl");
}
function show3(i){
	window['subwindow_detailFW'+i].show();
}
</script>
</@CommonQueryMacro.page>