<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign customerNum=RequestParameters["customerNum"]?default("")>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<@CommonQueryMacro.page title="单规则预警处置任务列表">
	<@CommonQueryMacro.CommonQuery id="textout" init="true" submitMode="current">
		<@CommonQueryMacro.Interface id="interface" showButton="false" colNm="2"/>
		<@CommonQueryMacro.Button id="btSave" />
	</@CommonQueryMacro.CommonQuery>
<div id="char"><div>
	
	
	<script type="text/javascript" src="${contextPath}/gbicc-pages/jquery-form.js"></script>
	<script src="${contextPath}/templets/ui/js/chart/highcharts.js"></script>
	<script src="${contextPath}/templets/ui/js/chart/highcharts-more.js"></script>

	<div id="container" style="width: 800px; height: 300px; margin: 0 auto"></div>	
		






	<script language="JavaScript">

	function initCallGetter_post(){

	}
	
	function  btSave_onClick(record,index){
		
		var a=textout_interface_dataset.getValue("a");
		var b=textout_interface_dataset.getValue("b");
//		var id=textout_interface_dataset.getValue("id");
		var zbnum=textout_interface_dataset.getValue("zbnum");
		var zbname=textout_interface_dataset.getValue("zbname");
//		var functionname=textout_interface_dataset.getValue("functionname");
//		var tablename=textout_interface_dataset.getValue("tablename");
//		var by=textout_interface_dataset.getValue("by");
		if(a!=""&&b!=""&&zbnum!=""&&zbname!=""){
			var dataJson;
			//DBCheck(a,b,id,functionname,tablename,by);
			$.messager.progress({title:'请稍候',msg:'正在上传...'});
		 	//异步提交表单
			$.ajax({								
				url :"${contextPath}/char/TestOutServlet",
		        type : "post",
				data:{
					a:a,
					b:b,
					zbname:zbname,
					zbnum:zbnum
				},
				
				success:function(data){
					
				dataJson = eval('('+data+')');
				var str=document.getElementById("char");
				var abc=dataJson.url;
				str.innerHTML=abc;
	            $.messager.progress('close');
				}
			});
		}else{
			alert("请输入完整的查询条件！");
		}
	}

	function DBCheck(){
		 var customerNum='${customerNum}';
		 
	     
	 
	  }

	</script>
</@CommonQueryMacro.page>