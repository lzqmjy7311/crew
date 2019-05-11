<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="Message">
<pre style="text-align:left">
	<a href="#" onclick="f(1)">警告框</a>
	<a href="#" onclick="f(2)">信息提示框</a>
	<a href="#" onclick="f(3)">错误提示框</a>
	<a href="#" onclick="f(4)">正确提示框</a>
	<a href="#" onclick="f(5)">确认框</a>
	<a href="#" onclick="f(6)">自定义标题</a>
	<a href="#" onclick="f(7)">2秒自动关闭框</a>
</pre>
<script type="text/javascript">
	function f(i) {
		switch(i){
			case 1:
				top.easyMsg.warn("这是一个警告这是一个警告这是一个警告这是一个警告这是一个警告这是一个警告这是一个警告这是一个警告这是一个警告  是一个警告这是一个警告这是一个警告这是一个警告这是一个警告这是一个警告这是一个警告这是一个警告这是一个警告这是一个警告这是一个警告这是一个警告这是一个警告这是一个警告这是一个警告这是一个警告这是一个警告这是一个警告这是一个警告这是一个警告这是一个警告这是一个警告这是一个警告这是一个警告这是一个警告这是一个警告这是一个警告这是一个警告这是一个警告这是一个警告这是一个警告这是一个警告这是一个警告这是一个警告这是一个警告这是一个警告这是一个警告这是一个警告这是一个警告这是一个警告这是一个警告这是一个警告这是一个警告这是一个警告这是一个警告这是一个警告这是一个警告这是一个警告这是一个警告这是一个警告这是一个警告这是一个警告这是一个警告这是一个警告这是一个警告这是一个警告这是一个警告这是一个警告这是一个警告这是一个警告这是一个警告这是一个警告这是一个警告这是一个警告这是一个警告这是一个警告这是一个警告这是一个警告这是一个警告这是一个警告这是一个警告这是一个警告这是一个警告这是一个警告这是一个警告这是一个警告这是一个警告这是一个警告这是一个警告这是一个警告这是一个警告这是一个警告这是一个警告这是一个警告这是一个警告这是一个警告这是一个警告这是一个警告");
				break;
			case 2:
				top.easyMsg.info("这是一个信息提示\n这是一个警告这是一个警告这是一个警告这是一个警告这是一个警告这是一个警告这是一个警告这是一个警告这是一个警告这是一个警告");
				break;
			case 3:
				top.easyMsg.error("这是一个错误提示");
				break;
			case 4:
				top.easyMsg.correct("这是一个正确提示");
				break;
			case 5:
				top.easyMsg.confirm("是否退出?", function(){
					top.easyMsg.info("确定");
				}, function(){
					top.easyMsg.info("取消");
				} );
				break;
			case 6:
				top.easyMsg.info("提示信息",{
					title:"自定义标题"
				});
				break;
			case 7:
				top.easyMsg.error("这是一个错误提示,2秒自动关闭",{timeout:2000});
				break;
			default:
				break;
		}
	}
</script>
</@CommonQueryMacro.page>