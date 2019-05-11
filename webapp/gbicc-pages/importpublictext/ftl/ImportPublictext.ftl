<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<@CommonQueryMacro.page title="�������  &gt; ��������ѯ">
	<@CommonQueryMacro.CommonQuery id="TImportpublictext" init="true" submitMode="current" >
			<@CommonQueryMacro.Interface id="interface"label="�������ѯ����" showButton="false"/>
			<tr>
				<td>
					<div align="center" style="margin-bottom:10px">
						<@CommonQueryMacro.InterfaceButton desc="��ѯ" />
						<@CommonQueryMacro.SimpleButton id="btnReset" desc="����" icon="icon-reload" />
					</div>
				</td>
			</tr>
			<@CommonQueryMacro.DataTable id="QualityTable" width="600" fieldStr="bankCode,middleSigncode,organizationCode,informationCode,creatTime" paginationbar="btImport" width="100%" hasFrame="true"/>
		<@CommonQueryMacro.FloatWindow id="TxtFW" modal="true" label="�ϴ�TXT�ļ�" 
		resize="true" minimize="false" maximize="true" closure="true" show="false" defaultZoom="normal">
		<form id="uploadForm" action="${contextPath}/common/TxtImportServlet" method="post" enctype="multipart/form-data">
			�ļ���<input id="fileUpload" name="file" type="file"/>
			<@CommonQueryMacro.Button id= "btUpload"/>
		</form>
		</@CommonQueryMacro.FloatWindow>
 	</@CommonQueryMacro.CommonQuery>
 	<script language="JavaScript">
 	//���ò�ѯ����
	function btnReset_onClick(button){
		TImportpublictext_interface_dataset.clearData();
	}
 	//�ϴ��ļ�
	function btUpload_onClickCheck(button) { 
		if (checkFile()) {
			//�첽�ύ��
			$.messager.progress({title:'���Ժ�',msg:'�����ϴ�...'});
			$('#uploadForm').ajaxSubmit({
				type:"post",
				success:function(data){
					var obj=eval('('+data+')');
					$.messager.progress('close');
					if(obj.success=="true"){
						subwindow_TxtFW.close();
						top.easyMsg.info(obj.msg);
						TImportpublictext_dataset.flushData(TImportpublictext_dataset.pageIndex);
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
	   var filename=file.val();
	   if (filename == "") {
	   	  alert('��ѡ��Ҫ�������ݵ��ļ�','������ʾ');
	      file.focus();
	      return false;
	   }
	   var str=filename.substring(filename.indexOf("."));
	   if(str!='.txt'){
		   alert("�����ļ����ͣ��ϴ���ȷ�������ļ���","������ʾ");
		   return false;
	   }
		   
	  return true;
	}
	function btImport_onClick(button) {
		subwindow_TxtFW.show();
	}
 	</script>
 	<script type="text/javascript" src="${contextPath}/gbicc-pages/jquery-form.js"></script>
</@CommonQueryMacro.page>