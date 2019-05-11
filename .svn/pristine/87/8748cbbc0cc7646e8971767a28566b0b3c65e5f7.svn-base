<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<@CommonQueryMacro.page title="流程管理  &gt;  部署管理">
	<@CommonQueryMacro.CommonQuery id="ProcessDeploy" init="true" submitMode="current">
		<@CommonQueryMacro.DataTable id="productTable" readonly="true" paginationbar="btAdd,btDel,btProcDiag" 
		fieldStr="deploymentId,id,name,version,key,resourceName,diagramResourceName" width="100%" hasFrame="true"/>
		<@CommonQueryMacro.FloatWindow id="deployFW" modal="true" label="上传部署文件" 
		resize="true" minimize="false" maximize="true" closure="true" show="false" defaultZoom="normal">
		<form id="uploadForm" action="${contextPath}/common/ProcessDeployServlet" method="post" enctype="multipart/form-data">
			文件：<input id="fileUpload" name="file" type="file"/>
			<@CommonQueryMacro.Button id= "btUpload"/>
		</form>
		</@CommonQueryMacro.FloatWindow>
		<@CommonQueryMacro.FloatWindow id="diagramFW" modal="true" label="流程图查看" 
		resize="true" minimize="false" width="1000" height="700" maximize="true" closure="true" show="false" defaultZoom="normal">
		<img id="img" data="${contextPath}/common/ProcessDiagramServlet">
		</@CommonQueryMacro.FloatWindow>
	</@CommonQueryMacro.CommonQuery>
<script>
	//上传文件
	function btUpload_onClickCheck(button) { 
		if (checkFile()) {
			//异步提交表单
			$('#uploadForm').ajaxSubmit({
				type:"post",
				success:function(data){
					subwindow_deployFW.close();
					top.easyMsg.info("操作成功！");
					flushCurrentPage();
				}
			});
		}
	}
	//检查上传文件
	function checkFile() {
	   var file=$("#fileUpload");
	   var filename=file.val();
	   if (filename == "") {
	   	  alert('请选择要导入数据的文件','错误提示');
	      file.focus();
	      return false;
	   }
	  return true;
	} 
	
	
	function btAdd_onClick(button) {
		ProcessDeploy_dataset.insertRecord("end");
		subwindow_deployFW.show();
	}
	//流程图
	function btProcDiag_onClick(button) {
		subwindow_diagramFW.show();
		var src=$("#img").attr("data")+"?flag=deploy&key="+ProcessDeploy_dataset.getValue("key")+"&version="+ProcessDeploy_dataset.getValue("version");
		$("#img").attr("src",src);
	}
	//删除确认
  	function btDel_onClickCheck(button) {
		return confirm("确认删除该条记录？");
	}
	//删除后刷新当前页
	function btDel_postSubmit(button) {
		button.url="#";
		top.easyMsg.info("删除成功！");
		flushCurrentPage();
	}
	//刷新当前页
	function flushCurrentPage() {
		ProcessDeploy_dataset.flushData(ProcessDeploy_dataset.pageIndex);
	}
</script>
<script type="text/javascript" src="${contextPath}/gbicc-pages/jquery-form.js"></script>
</@CommonQueryMacro.page>