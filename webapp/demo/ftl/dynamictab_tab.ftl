<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="DynamicTabSet">

<@CommonQueryMacro.LayoutPanel id="cc" >
	<@CommonQueryMacro.LayoutWest width="200" split="false">
			<ul><a href="#" onclick="f(1)">新增</a></ul>
			<ul><a href="#" onclick="f(2)">关闭当前</a></ul>
			<ul><a href="#" onclick="f(3)">关闭所有</a></ul>
			<ul><a href="#" onclick="f(4)">更新图标</a></ul>
			<ul><a href="#" onclick="f(5)">更新title</a></ul>
			<ul><a href="#" onclick="f(8)">取消图标</a></ul>
			<ul><a href="#" onclick="f(9)">可关闭</a></ul>
			<ul><a href="#" onclick="f(10)">不可关闭</a></ul>
			<ul><a href="#" onclick="f(6)">打开第1个标签页</a></ul>
			<ul><a href="#" onclick="f(7)">刷新第1个标签页</a></ul>
			<ul><a href="#" onclick="f(12)">添加右键菜单</a></ul>
			<ul><a href="#" onclick="f(13)">移除右键菜单</a></ul>
			<ul><a href="#" onclick="f(11)">可用</a></ul>
			<ul><a href="#" onclick="f(14)">禁用</a></ul>
		</div>
	</@CommonQueryMacro.LayoutWest>
	<@CommonQueryMacro.LayoutCenter>
		<div id="tt"></div>
	</@CommonQueryMacro.LayoutCenter>
</@CommonQueryMacro.LayoutPanel>

<script>
	var dts;
	var j=0;
	$(function(){
		var jsonstr = '[{"id":"a","title":"","closable":true,"url":"/demo/ftl/validate_tab.ftl","width":"500px"},{"id":"b","title":"title2","url":"/demo/ftl/messagebox_tab.ftl","selected":true,"iconCls":"icon-ok","width":"300px"},{"id":"cc","url":"/demo/ftl/dialog_tab.ftl"},{"id":"e","url":"http://www.126.com"}]';
		if(!dts) 
			dts = new DynamicTabSet(document.getElementById("tt"));
		dts.init(eval("("+jsonstr+")")); 
	});
	var k = 1;
	function f(i) {
		if(i==1) {
			dts.add({id:"id"+k, title:"Title " + k,content:"test"+k});
			k++;
		}else if(i==2){
			dts.close();
		}else if(i==3){
			dts.closeAll();
		}else if(i==4){
			var d = dts.getSelectedId();
			dts.setIconCls(d, "icon-ok");
		}else if(i==5){
			var d = dts.getSelectedId();
			dts.setTitle(d,"随便你"+k++);
		}else if(i==6){
			dts.select(0);
		}else if(i==7){
			dts.refresh(0, "/demo/ftl/validate_tab.ftl");
		}else if(i==8){
			var d = dts.getSelectedId();
			dts.setIconCls(d, "");
		}else if(i==9){
			var d = dts.getSelectedId();
			dts.setClosable(d, true);
		}else if(i==10){
			var d = dts.getSelectedId();
			dts.setClosable(d, false);
		}else if(i==11){
			var d = dts.getSelectedId();
			dts.setEnable(d,true);
		}else if(i==14){
			var d = dts.getSelectedId();
			dts.setEnable(d,false);
		}else if(i==12){
			dts.setContextMenu(true);
		}else if(i==13){
			dts.setContextMenu(false);
		}
	}
</script>
</@CommonQueryMacro.page>