<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro >
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<@CommonQueryMacro.page title="������Ϣά��">
   <table align="left">
   <tr>
      <td>
      	<@CommonQueryMacro.CommonQuery id="CurrencyManEntry" init="false" submitMode="current">
      		<table width="100%">

      			<tr>
      			  <td colspan="2" valign="top">
      			    <@CommonQueryMacro.Interface id="interface" label="�������ѯ����"  colNm="8"/>
      			  </td>
      			</tr>

      			<tr>

      			  <td>
      			    <@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" pageCache="false" showArrow="true"/>
      			  </td>

      			</tr>

      			<tr>
      			  <td colspan="2">
      			     <@CommonQueryMacro.DataTable id="datatable1" paginationbar="btNew" fieldStr="id,curno,cnname,enname,cursymBol,dratedays,isUsd,st,opr[120]" width="100%" hasFrame="true" readonly="true" />
      			  </td>
      			 </tr>
      			 <tr>
		      		<td colspan="2">
		      		<@CommonQueryMacro.FloatWindow id="signWindow" label="" width="" resize="true" defaultZoom="normal" minimize="false" maximize="false" closure="true" float="true" exclusive="true" position="center" show="false" >
		      			<div align="center">
		      				<@CommonQueryMacro.Group id="group1" label="������Ϣά��"
		        			  fieldStr="id,curno,cnname,enname,cursymBol,dratedays,baseunit,minunit,curedicd,curediname,isUsd,showSeq" colNm=4/>
		        			 </br>
		      				<@CommonQueryMacro.Button id= "btSave"/>
		      			</div>
		     		 </@CommonQueryMacro.FloatWindow>

		  			</td>
  				</tr>
      			 <tr style="display:none">
					<td colspan="2">
						<@CommonQueryMacro.Button id= "btDel"/>&nbsp;&nbsp;
						<@CommonQueryMacro.Button id= "btMod"/>&nbsp;&nbsp;
					</td>
				</tr>
				<tr>
					<td>
						<span id="size"> </span>&nbsp;&nbsp;<span id="show"> </span>
					</td>
				</tr>
      		</table>
      	</@CommonQueryMacro.CommonQuery>
      </td>
   </tr>
   </table>
<script language="javascript">



	function btSave_postSubmit(button){
		subwindow_signWindow.hide();
		CurrencyManEntry_dataset.flushData(CurrencyManEntry_dataset.pageIndex);
		alert("����ɹ���");
	}


	function btDel_postSubmit(button){
		CurrencyManEntry_dataset.flushData(CurrencyManEntry_dataset.pageIndex);
	}

	//��ϵͳˢ�µ�Ԫ�������ʱ������
	function datatable1_opr_onRefresh(cell,value,record) {
		if (record) {//�����ڼ�¼ʱ
			var lock = record.getValue("lock");
			if(isTrue(lock)){
				cell.innerHTML = "<center><a href=\"Javascript:void(0);\" style=\"color:#666666\" title=\"��¼�����������ܲ���\">�޸�</a> &nbsp; <a href=\"Javascript:void(0);\" style=\"color:#666666\" title=\"��¼�����������ܲ���\">ɾ��</a></center>";
			}else{
				cell.innerHTML="<center><a href=\"JavaScript:doModify('"+value+"')\">�޸�</a> &nbsp; <a href=\"JavaScript:doDelete('"+value+"')\">ɾ��</a></center>";
			}
		} else {//�������ڼ�¼ʱ
		 cell.innerHTML="&nbsp;";
		}
	}

	//��λһ����¼
	function locate(id) {

		var record = CurrencyManEntry_dataset.find(["id"],[id]);
		if (record) {
			CurrencyManEntry_dataset.setRecord(record);
		}
	}

	//�޸�
	function doModify(id) {
		locate(id);

		 CurrencyManEntry_dataset.setFieldReadOnly("id",true);
		 CurrencyManEntry_dataset.setFieldReadOnly("cnname",false);
		 CurrencyManEntry_dataset.setFieldReadOnly("enname",false);
		 CurrencyManEntry_dataset.setFieldReadOnly("dratedays",false);

		subwindow_signWindow.show();
	}

	//ɾ��
	function doDelete(id) {
		locate(id);

		if(confirm('�Ƿ�ɾ����ǰ��¼'))
		{
			btDel.click();
		}
	}
//չʾ�Աȹ��ܵ�js
	function datatable1_id_onRefresh(cell, value, record){
	if(record!=null){
		var sta = record.getValue("st");
		var id=record.getValue("id");


		cell.innerHTML = "<a href=\"Javascript:showDetail('"+id+"','"+sta+"')\">"+id+"</a>";

	} else {
		cell.innerHTML = ""
	}
}


function showDetail(id,sta){

	var paramMap = new Map();
	paramMap.put("id",id);
	paramMap.put("st",sta);
	paramMap.put("action","detail");
	paramMap.put("flag","0");
	loadPageWindows("partWin", "������Ϣά��","/fpages/basis/ftl/CurrencyManEntryDetail.ftl", paramMap, "winZone");
}

	function btNew_onClick(button){

		  subwindow_signWindow.show();
		  var  v_currencyCode = CurrencyManEntry_dataset.getValue("id");
		  //���ݿ��еļ�¼��

		  if (v_currencyCode!=""  ){
		    CurrencyManEntry_dataset.setFieldReadOnly("id",true);
		    CurrencyManEntry_dataset.setFieldReadOnly("cnname",true);
		    CurrencyManEntry_dataset.setFieldReadOnly("enname",true);
		    CurrencyManEntry_dataset.setFieldReadOnly("cursymbol",true);
		    CurrencyManEntry_dataset.setFieldReadOnly("isusd",true);
		    CurrencyManEntry_dataset.setFieldReadOnly("showSeq",true);
		    CurrencyManEntry_dataset.setFieldReadOnly("dratedays",false);
		  }else{
		    CurrencyManEntry_dataset.setFieldReadOnly("id",false);
		    CurrencyManEntry_dataset.setFieldReadOnly("cnname",false);
		    CurrencyManEntry_dataset.setFieldReadOnly("enname",false);
		     CurrencyManEntry_dataset.setFieldReadOnly("cursymbol",false);
		    CurrencyManEntry_dataset.setFieldReadOnly("isusd",false);
		    CurrencyManEntry_dataset.setFieldReadOnly("showSeq",false);
		    CurrencyManEntry_dataset.setFieldReadOnly("dratedays",false);
		  }
	}

	function signWindow_floatWindow_beforeClose(subwindow){
		 CurrencyManEntry_dataset.cancelRecord();
		 return true;
	}

	function signWindow_floatWindow_beforeHide(subwindow){
		return signWindow_floatWindow_beforeClose(subwindow);
	}

</script>
</@CommonQueryMacro.page>