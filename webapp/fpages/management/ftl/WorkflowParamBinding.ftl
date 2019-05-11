<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>

<@CommonQueryMacro.page title="审核路线绑定">
<table>
<tr>
<td>
<@CommonQueryMacro.CommonQuery id="workflowParamBinding" init="true" submitMode="all" mode="2" navigate="false">
	<table align="left">
      	<tr>
      		<td valign="top">
					<@CommonQueryMacro.PagePilot id="ddresult" maxpagelink="9999"/>
					<@CommonQueryMacro.DataTable id ="datatable1" fieldStr="typeClassName,maxAmt,startBrhidName,brhClass,workflowRoleName"  readonly="true"/>
			</td>
      		<td valign="top">
				<FIELDSET style="width:200">
					<LEGEND>判断条件</LEGEND>
					<@CommonQueryMacro.Group id="group1" showGroupLine="false" label=" " fieldStr="typeClassName,maxAmt" colNm=2/>
					<table>
						<tr>
							<td align="left">
								<input type="radio" name="type" id="rd_brclass" checked="true" value="1" onclick="freshData()">指定机构级别&nbsp;&nbsp;
								<input type="radio" name="type" id="rd_brcode" value="2" onclick="freshData()">指定机构
							</td>
						</tr>
						<tr>
							<td align="left">
								<span id="span_startBrhid" style="display:none">
									<@CommonQueryMacro.Group id ="group1" showGroupLine="false" label="" fieldStr="startBrhName" colNm=4/>
								</span>
								<span id="span_startBrhClass">
									<@CommonQueryMacro.Group id ="group2" showGroupLine="false"  label="" fieldStr="startBrhLevel" colNm=4/>
								</span>
							</td>
						</tr>
					</table>
				</FIELDSET>
		  		<table>
		        	<tr>
		  				 <td>
							<@CommonQueryMacro.Group id ="group2" label="绑定" showGroupLine="true" fieldStr="brhClass,workflowRoleName" colNm=2/>
	      				</td>
      				</tr>
	        		<tr>
		  				 <td align="center">
	      					<@CommonQueryMacro.Button id= "btNew" />&nbsp;&nbsp;
	      					<@CommonQueryMacro.Button id= "btDelete"/>&nbsp;&nbsp;
	      					<@CommonQueryMacro.Button id= "btnSave"/>&nbsp;&nbsp;
	      				</td>
      				</tr>
	      		</table>
      		</td>
		 </tr>
	 </table>
</@CommonQueryMacro.CommonQuery>
	</td>
 </tr>
 <tr>
 <td>
 <@CommonQueryMacro.CommonQuery id="SelectTempCreditinfo" init="false" navigate="false"/>
 </td>
 </tr>
 </table>
<script language="javascript">
function btNew_onClick(){
	workflowParamBinding_dataset.setValue("processTemplate", workflowParamBinding_dataset.getParameter("templetName"));
	workflowParamBinding_dataset.setValue("taskName", workflowParamBinding_dataset.getParameter("nodeName"));
}

function btnSave_needCheck(){
	dataset = workflowParamBinding_dataset;
	if(dataset && dataset.length > 0){
		var discard = true;
		var v_rec = dataset.firstUnit;
		while(v_rec){
			if(v_rec.recordState == "none" || v_rec.recordState == "insert" || v_rec.recordState == "modify" || v_rec.recordState == "new"){
				discard = false;
				break;
			}
			v_rec = v_rec.nextUnit;
		}
		if(discard){
			return false;
		}
	}
	return true;
}



function workflowParamBinding_dataset_afterScroll(dataset){
	if(dataset && dataset.length > 0){
		var discard = true;
		var v_rec = dataset.firstUnit;
		while(v_rec){
			if(v_rec.recordState == "none" || v_rec.recordState == "insert" || v_rec.recordState == "modify" || v_rec.recordState == "new"){
				discard = false;
				break;
			}
			v_rec = v_rec.nextUnit;
		}
		if(discard){
			return;
		}
		var v_startBrhid = workflowParamBinding_dataset.getValue("startBrhid");
		var v_rd_brclass = document.getElementById("rd_brclass");
		var v_rd_brcode = document.getElementById("rd_brcode");
		if(v_startBrhid < 0){
			v_rd_brclass.checked = true;
		} else{
			v_rd_brcode.checked = true;
		}
		if(v_rd_brclass.checked){
			workflowParamBinding_dataset.getField("startBrhid").required = false;
			workflowParamBinding_dataset.getField("startBrhName").required = false;
			workflowParamBinding_dataset.getField("startBrhNameName").required = false;
			workflowParamBinding_dataset.getField("startBrhLevel").required = true;
			document.getElementById("span_startBrhClass").style.display="";
			document.getElementById("span_startBrhid").style.display="none";
			workflowParamBinding_dataset.setValue("startBrhName","");
			workflowParamBinding_dataset.setValue("startBrhNameName","");
		}
		if(v_rd_brcode.checked){
			workflowParamBinding_dataset.getField("startBrhLevel").required = false;
			workflowParamBinding_dataset.getField("startBrhLevelName").required = false;
			workflowParamBinding_dataset.getField("startBrhid").required = true;
			document.getElementById("span_startBrhClass").style.display="none";
			document.getElementById("span_startBrhid").style.display="";
			workflowParamBinding_dataset.setValue("startBrhLevel","");
			workflowParamBinding_dataset.setValue("startBrhLevelName","");

		}

		refreshStartBrhId();
	}
}

function workflowParamBinding_dataset_flushDataPost(dataset){
	if(dataset.length == 0){
		dataset.insertRecord();
		dataset.setValue("processTemplate", dataset.getParameter("templetName"));
		dataset.setValue("taskName", dataset.getParameter("nodeName"));
	}
	var v_startBrhid = workflowParamBinding_dataset.getValue("startBrhid");
	var v_rd_brclass = document.getElementById("rd_brclass");
	var v_rd_brcode = document.getElementById("rd_brcode");
	if(v_startBrhid < 0){
		v_rd_brclass.checked = true;
	} else{
		v_rd_brcode.checked = true;
	}
	if(v_rd_brclass.checked){
		workflowParamBinding_dataset.getField("startBrhid").required = false;
		workflowParamBinding_dataset.getField("startBrhName").required = false;
		workflowParamBinding_dataset.getField("startBrhNameName").required = false;
		workflowParamBinding_dataset.getField("startBrhLevel").required = true;
		document.getElementById("span_startBrhClass").style.display="";
		document.getElementById("span_startBrhid").style.display="none";
		workflowParamBinding_dataset.setValue("startBrhName","");
		workflowParamBinding_dataset.setValue("startBrhNameName","");
	}
	if(v_rd_brcode.checked){
		workflowParamBinding_dataset.getField("startBrhLevel").required = false;
		workflowParamBinding_dataset.getField("startBrhLevelName").required = false;
		workflowParamBinding_dataset.getField("startBrhid").required = true;
		document.getElementById("span_startBrhClass").style.display="none";
		document.getElementById("span_startBrhid").style.display="";
		workflowParamBinding_dataset.setValue("startBrhLevel","");
		workflowParamBinding_dataset.setValue("startBrhLevelName","");

	}

	SelectTempCreditinfo_dataset.setParameter("typeNo", "3");
	SelectTempCreditinfo_dataset.flushData();
	typeClassName_DropDownDataset.insertRecord();
	typeClassName_DropDownDataset.setValue("data", "0000");
	typeClassName_DropDownDataset.setValue("dataName", "不限");
	var v_rec = SelectTempCreditinfo_dataset.firstUnit;
	while(v_rec){
		typeClassName_DropDownDataset.insertRecord();
		typeClassName_DropDownDataset.setValue("data", v_rec.getValue("code"));
		typeClassName_DropDownDataset.setValue("dataName", v_rec.getValue("name"));
		v_rec = v_rec.nextUnit;
	}
}

function freshData(){
	workflowParamBinding_dataset.setValue("startBrhid","");
	workflowParamBinding_dataset.setValue("startBrhName","");
	workflowParamBinding_dataset.setValue("startBrhNameName","");
	workflowParamBinding_dataset.setValue("startBrhLevel","");
	workflowParamBinding_dataset.setValue("startBrhLevelName","");
	var v_rd_brclass = document.getElementById("rd_brclass");
	var v_rd_brcode = document.getElementById("rd_brcode");
	if(v_rd_brclass.checked){
		workflowParamBinding_dataset.getField("startBrhid").required = false;
		workflowParamBinding_dataset.getField("startBrhName").required = false;
		workflowParamBinding_dataset.getField("startBrhNameName").required = false;
		workflowParamBinding_dataset.getField("startBrhLevel").required = true;
		document.getElementById("span_startBrhClass").style.display="";
		document.getElementById("span_startBrhid").style.display="none";
	}
	if(v_rd_brcode.checked){
		workflowParamBinding_dataset.getField("startBrhLevel").required = false;
		workflowParamBinding_dataset.getField("startBrhid").required = true;
		document.getElementById("span_startBrhClass").style.display="none";
		document.getElementById("span_startBrhid").style.display="";


	}
	workflowParamBinding_dataset.loadDetail();
	workflowParamBinding_dataset.refreshControls();
}

function btnSave_postSubmit(){
	alert("配置成功");
	workflowParamBinding_dataset.flushData(workflowParamBinding_dataset.pageIndex);
}

function btBack_onClickCheck(){
	unloadPageWindows("userWin");
	return false;
}

function startBrhLevel_DropDown_onSelect(dropdown,record,editor){
	workflowParamBinding_dataset.setValue("startLevelName",record.getValue("dataName"));
	return true;
}

function workflowParamBinding_dataset_afterChange(dataset,field){
	if(field.name == "startbrhname" || field.name == "startbrhlevel"){
		refreshStartBrhId();
	}
}



function refreshStartBrhId(){
	var v_rec = workflowParamBinding_dataset.firstUnit;
	while(v_rec){
		if(getInt(v_rec.getValue("startBrhid")) > 0){
			v_rec.setValue("startBrhidName",v_rec.getValue("startBrhName"));
		} else{
			v_rec.setValue("startBrhidName",v_rec.getValue("startLevelName"));
		}
		v_rec = v_rec.nextUnit;
	}
}

</script>

</@CommonQueryMacro.page>
