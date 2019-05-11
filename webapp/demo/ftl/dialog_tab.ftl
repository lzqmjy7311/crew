<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="对话框">
	<@CommonQueryMacro.FloatWindow id="fw" width="400px" height="200px">
		<div> hello</div>
		<input id="btn2" type="button" value="hide" onclick="hide()"/>
		<input id="btn3" type="button" value="close" onclick="close1()"/>
	</@CommonQueryMacro.FloatWindow>
	<input type="button" onclick="show()" value="显示对话框" />
	<div id="dis" align="left">事件:</div>
	<script>
	function show() {
		subwindow_fw.show();
	}
	function hide() {
		subwindow_fw.hide();
	}
	function close1() {
		subwindow_fw.close();
	}
	function fw_floatWindow_beforeShow(fw) {
		$("#dis").html($("#dis").html() + "<br/>触发打开之前事件.");
	}
	function fw_floatWindow_afterShow(fw) {
		$("#dis").html($("#dis").html() + "<br/>触发打开之后事件.");
	}
	function fw_floatWindow_beforeHide(fw) {
		$("#dis").html($("#dis").html() + "<br/>触发隐藏之前事件.");
	}
	function fw_floatWindow_afterHide(fw) {
		$("#dis").html($("#dis").html() + "<br/>触发隐藏之后事件.");
	}
	function fw_floatWindow_beforeClose(fw) {
		$("#dis").html($("#dis").html() + "<br/>触发关闭之前事件.");
	}
	function fw_floatWindow_afterClose(fw) {
		$("#dis").html($("#dis").html() + "<br/>触发关闭之后事件.");
	}
	</script>
</@CommonQueryMacro.page>