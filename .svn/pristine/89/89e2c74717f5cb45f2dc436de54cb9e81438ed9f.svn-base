<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<@CommonQueryMacro.page title="" >
	<table align="left" width="90%">
		<tr>
			<td>
				<@CommonQueryMacro.CommonQuery id="SupplyEnterVerifyStateQueryEntry" init="false" submitMode="current">
					<table width="100%">
						<tr>
							<td colspan="2" valign="top">
								<@CommonQueryMacro.Interface id="interface1" label="请输入查询条件" colNm="6"/>
							</td>
						</tr>

						<tr>
							<td>
								<@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="15" showArrow="true" pageCache="false"/>
							</td>
						</tr>

						<tr>
							<td colspan="2">
								<@CommonQueryMacro.DataTable id = "datatable1" fieldStr="brNo[100],brNoName[120],workDate[80],apptype,fileType,noedit,editWaitConfirm,confirmWaitAudit,auditWaitConfirm,confirmPass,sendreport" width="100%"/>
							</td>
						</tr>
					</table>
				</@CommonQueryMacro.CommonQuery>
			</td>
		</tr>
	</table>
	<script language="JavaScript">
	    function initCallGetter_post(){
			//工作日期默认当天日期
			SupplyEnterVerifyStateQueryEntry_interface_dataset.setValue("qworkDateStart", _today_date);
			SupplyEnterVerifyStateQueryEntry_interface_dataset.setValue("qworkDateEnd", _today_date);
			SupplyEnterVerifyStateQueryEntry_interface_dataset.setValue("qbusiType",defaultType);
			
	     }
		

		function qappType_DropDown_beforeOpen(dropDown){
		     var type=SupplyEnterVerifyStateQueryEntry_interface_dataset.getValue("qbusiType");
		     if(type.length>0){
		     	AppTypeSelect_DropDownDataset.setParameter("type",type);
		     }
		     qappType_DropDown.cached=false;
		}

		function qfileType_DropDown_beforeOpen(dropDown){
			 var type=SupplyEnterVerifyStateQueryEntry_interface_dataset.getValue("qbusiType");
			 var apptype = SupplyEnterVerifyStateQueryEntry_interface_dataset.getValue("qappType");
			 FileTypeSelect_DropDownDataset.setParameter("show","file");
			 if(type.length>0 && apptype.length>0){
			 	FileTypeSelect_DropDownDataset.setParameter("type",type);
			 	FileTypeSelect_DropDownDataset.setParameter("appType",apptype);
			 }
			 qfileType_DropDown.cached=false;
		}

		function qbusiType_DropDown_onSelect(dropDown,record,editor){
		    var selId=record.getValue("data");
		    var oldId = SupplyEnterVerifyStateQueryEntry_interface_dataset.getValue("qbusiType");
		    if(selId!=oldId){
		    	SupplyEnterVerifyStateQueryEntry_interface_dataset.setValue2("qappType","");
		    	SupplyEnterVerifyStateQueryEntry_interface_dataset.setValue2("qfileType","");
		   	}
		    return true;
		}

		function qappType_DropDown_onSelect(dropDown,record,editor){
		    var selId=record.getValue("dataNo");
		    var oldId = SupplyEnterVerifyStateQueryEntry_interface_dataset.getValue("qappType");
		    if(selId!=oldId){
		    	SupplyEnterVerifyStateQueryEntry_interface_dataset.setValue2("qfileType","");
		   	}
		    return true;
		}


	</script>
</@CommonQueryMacro.page>