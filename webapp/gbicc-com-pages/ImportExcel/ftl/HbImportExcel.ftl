<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<@CommonQueryMacro.page title="�������  &gt; ��������ѯ">
	<@CommonQueryMacro.CommonQuery id="HbImportExcel" init="true" submitMode="current" >
			
			<@CommonQueryMacro.DataTable id="QualityTable33" width="600"  paginationbar="btImport" width="100%" hasFrame="true"/>
		<@CommonQueryMacro.FloatWindow id="TxtFW" modal="true" label="Excel���ݵ���" 
		resize="true" minimize="false" maximize="true" closure="true" show="false" defaultZoom="normal">
		<form id="uploadForm" action="${contextPath}/this/HbImportExcelServlet" method="post" enctype="multipart/form-data" target="aa">
			<div style="margin-left:150px;margin-bottom:5px;margin-top:5px"><label>��ѡ�������ͣ�</label><input type="radio" name="editortype" value="00" id="editortype"/><label>�±�</label>&nbsp;&nbsp;&nbsp;<input type="radio" name="editortype" value="11" id="editortype"/><label>����</label></div>
			<hr>
			<div style="margin-left:50px;margin-bottom:5px;margin-top:5px">�ļ���<input id="fileUpload" name="file" type="file"/><@CommonQueryMacro.Button id= "btUpload"/><@CommonQueryMacro.Button id= "btCancel"/></div>	
		</form>
		</@CommonQueryMacro.FloatWindow>
 	</@CommonQueryMacro.CommonQuery>
 	<script type="text/javascript">
 	//�ϴ��ļ�
	function btUpload_onClickCheck(button) { 
		if (checkFile()) {
			//�첽�ύ����		
			$("btUpload").disabled=true;
			$.messager.progress({title:'���Ժ�',msg:'�����ϴ�...'});
			$('#uploadForm').ajaxSubmit({
				type:"post", 
				data:{editor_type:"type"},
				success:function(data){
					var obj = eval('('+data+')');
					$.messager.progress('close');
					if(obj.success=="true"){
						subwindow_TxtFW.close();
						top.easyMsg.info(obj.msg);
						HbImportExcel_dataset.flushData(HbImportExcel_dataset.pageIndex);
					}else{
						top.easyMsg.error(obj.msg);
					}
				}
			});
		}
	}
	//����ϴ��ļ�
	function checkFile() {
	   var file=$("#fileUpload");
	  var editor=$('input:radio[name="editortype"]').is(":checked");
	   var filename=file.val();
	   if (filename == "") {
	   	  alert('��ѡ��Ҫ�������ݵ��ļ�','������ʾ');
	      file.focus();
	      return false;
	   }
	   if (editor==false) {
		   	  alert('��ѡ��Ҫ�����ļ�������','������ʾ');
		      return false;
		   }
	   var str=filename.substring(filename.indexOf("."));
	   if((str!='.xls')){
		   alert("�����ļ����ͣ�֧��97-2003��EXCEL�ļ�����ʽҪ��XLS��","������ʾ");
		   return false;
	   }
		   
	  return true;
	}
	function btImport_onClick(button) {
		subwindow_TxtFW.show();
	}

	function btCancel_onClickCheck(button){
		subwindow_TxtFW.close();
	}
 	</script>
 	<script type="text/javascript" src="${contextPath}/gbicc-pages/jquery-form.js"></script>
</@CommonQueryMacro.page>