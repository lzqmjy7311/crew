<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>

<@CommonQueryMacro.page title="�����ֹ�¼��">
<#assign op = RequestParameters["op"]?default('')>
<@CommonQueryMacro.CommonQuery id="CurrrateMng" init="true" >
	<table width="100%">
	<#if op=="modify">
	<tr>
		<td align="left">
			<@CommonQueryMacro.Group id ="group1" label="������Ϣ" fieldStr="curcd,tocurcd,buyrate,exchgrate,sellrate,currrateDate" colNm=4/>
			<p>ע�⣺���׵�λΪ100��</p>
		</td>

	</tr>
	<tr>
		<td align="center">
	        <@CommonQueryMacro.Button id= "btSave"/>
	        <@CommonQueryMacro.SimpleButton id="btReturn" desc="����" onclick="window.parent.roleAuthView.close();" plain="false" icon="icon-back"/>
        </td>
    </tr>
    </#if>
     </table>
      <table width="100%">
    <#if op=="add">
    	<tr>
			<td align="left">
				<@CommonQueryMacro.Group id ="group1" label="����" fieldStr="curcd,tocurcd,buyrate,exchgrate,sellrate" colNm=4/>
				<p>ע�⣺���׵�λΪ100��</p>
			</td>

		</tr>
		<tr>
			<td align="center">
		        <@CommonQueryMacro.Button id= "btAddSave"/>
		     	<@CommonQueryMacro.SimpleButton id="btCancel" desc="ȡ��" onclick="window.parent.roleAuthView.close();" plain="false" icon="icon-no"/>
	        </td>
	    </tr>
    </#if>
    </table>
     <table width="100%">
    <#if op=="find">
    	<tr>
			<td align="left">
				<@CommonQueryMacro.Group id ="group1" label="������Ϣ" fieldStr="curcd,tocurcd,buyrate,exchgrate,sellrate,currrateDate" colNm=4/>

			</td>

		</tr>
		<tr>
			<td align="center">
		        <@CommonQueryMacro.SimpleButton id="btnClose" desc="�ر�" onclick="window.parent.roleAuthView.close();" plain="false" icon="icon-no"/>
	        </td>
	    </tr>
    </#if>
    </table>
</@CommonQueryMacro.CommonQuery>
<script language="javascript"><!--
	var op = "${op}"
	function initCallGetter_post(dataset){
		if(op == "modify"){
			CurrrateMng_dataset.setFieldReadOnly("currrateDate",true);
			CurrrateMng_dataset.setFieldReadOnly("exchgrate",true);
		}
		if(op == "add")	{
			CurrrateMng_dataset.setAllFieldsReadOnly(false);
			CurrrateMng_dataset.setFieldReadOnly("exchgrate",true);
		}
		if(op == "find"){
			CurrrateMng_dataset.setAllFieldsReadOnly(true);
		}
	}


		function curcd_DropDown_beforeOpen(dropDown){
			CurrrateMng_dataset.setValue("tocurcd","");
			CurrrateMng_dataset.setValue("tocurcdName","");
	}
		function tocurcd_DropDown_onSelect(dropdown,record,editor){
			var v_curcd = CurrrateMng_dataset.getValue("curcd");
			if(v_curcd == ""){
				top.easyMsg.info("������д���֣�");
				CurrrateMng_dataset.setValue("tocurcd","");
				CurrrateMng_dataset.setValue("tocurcdName","");
				return false;
			}else{
				var v_tocurcd = record.getValue("curcd");
				if(v_curcd == v_tocurcd){
			top.easyMsg.info("���ֺͶһ����ֲ�����ͬ��")
				CurrrateMng_dataset.setValue("tocurcd","");
			CurrrateMng_dataset.setValue("tocurcdName","");
			return false;
			}else{
			return true;
			}
		}
	}
	function CurrrateMng_dataset_afterChange(dataset,field){
	if(field.name=="buyrate"){
		var buyrate = CurrrateMng_dataset.getValue("buyrate");
		var sellrate = CurrrateMng_dataset.getValue("sellrate");
			if(buyrate!=""&&sellrate!=""){
				var exchgrate = (buyrate+sellrate)/2;
				CurrrateMng_dataset.setValue("exchgrate",exchgrate);
			}
		}
		if(field.name=="sellrate"){
		var buyrate = CurrrateMng_dataset.getValue("buyrate");
		var sellrate = CurrrateMng_dataset.getValue("sellrate");
			if(buyrate!=""&&sellrate!=""){
				var exchgrate = (buyrate+sellrate)/2;
				CurrrateMng_dataset.setValue("exchgrate",exchgrate);
			}
		}


	}

	//�����ɹ���ʾ
	function btAddSave_postSubmit(){
		top.easyMsg.correct("�����ɹ�");
		window.parent.CurrrateMng_dataset.flushData(window.parent.CurrrateMng_dataset.pageIndex);
        window.parent.roleAuthView.close();
	}



	function btSave_postSubmit(){
       top.easyMsg.correct("�޸ĳɹ�");
       window.parent.CurrrateMng_dataset.flushData(window.parent.CurrrateMng_dataset.pageIndex);
       window.parent.roleAuthView.close();
    }


--></script>
</@CommonQueryMacro.page>
