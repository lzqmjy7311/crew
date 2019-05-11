<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<@CommonQueryMacro.page title="���̹���  &gt;  �������">
	<@CommonQueryMacro.CommonQuery id="ProcessDeploy" init="true" submitMode="current">
		<@CommonQueryMacro.DataTable id="productTable" readonly="true" paginationbar="btAdd,btDel,btProcDiag" 
		fieldStr="deploymentId,id,name,version,key,resourceName,diagramResourceName" width="100%" hasFrame="true"/>
		<@CommonQueryMacro.FloatWindow id="deployFW" modal="true" label="�ϴ������ļ�" 
		resize="true" minimize="false" maximize="true" closure="true" show="false" defaultZoom="normal">
		<form id="uploadForm" action="${contextPath}/common/ProcessDeployServlet" method="post" enctype="multipart/form-data">
			�ļ���<input id="fileUpload" name="file" type="file"/>
			<@CommonQueryMacro.Button id= "btUpload"/>
		</form>
		</@CommonQueryMacro.FloatWindow>
		<@CommonQueryMacro.FloatWindow id="diagramFW" modal="true" label="����ͼ�鿴" 
		resize="true" minimize="false" width="1000" height="700" maximize="true" closure="true" show="false" defaultZoom="normal">
		<img id="img" data="${contextPath}/common/ProcessDiagramServlet">
		</@CommonQueryMacro.FloatWindow>
	</@CommonQueryMacro.CommonQuery>
<script>
	//�ϴ��ļ�
	function btUpload_onClickCheck(button) { 
		if (checkFile()) {
			//�첽�ύ��
			$('#uploadForm').ajaxSubmit({
				type:"post",
				success:function(data){
					subwindow_deployFW.close();
					top.easyMsg.info("�����ɹ���");
					flushCurrentPage();
				}
			});
		}
	}
	//����ϴ��ļ�
	function checkFile() {
	   var file=$("#fileUpload");
	   var filename=file.val();
	   if (filename == "") {
	   	  alert('��ѡ��Ҫ�������ݵ��ļ�','������ʾ');
	      file.focus();
	      return false;
	   }
	  return true;
	} 
	
	
	function btAdd_onClick(button) {
		ProcessDeploy_dataset.insertRecord("end");
		subwindow_deployFW.show();
	}
	//����ͼ
	function btProcDiag_onClick(button) {
		subwindow_diagramFW.show();
		var src=$("#img").attr("data")+"?flag=deploy&key="+ProcessDeploy_dataset.getValue("key")+"&version="+ProcessDeploy_dataset.getValue("version");
		$("#img").attr("src",src);
	}
	//ɾ��ȷ��
  	function btDel_onClickCheck(button) {
		return confirm("ȷ��ɾ��������¼��");
	}
	//ɾ����ˢ�µ�ǰҳ
	function btDel_postSubmit(button) {
		button.url="#";
		top.easyMsg.info("ɾ���ɹ���");
		flushCurrentPage();
	}
	//ˢ�µ�ǰҳ
	function flushCurrentPage() {
		ProcessDeploy_dataset.flushData(ProcessDeploy_dataset.pageIndex);
	}
</script>
<script type="text/javascript" src="${contextPath}/gbicc-pages/jquery-form.js"></script>
</@CommonQueryMacro.page>