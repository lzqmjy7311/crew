<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<@CommonQueryMacro.page title="指标阈值管理">
<@CommonQueryMacro.CommonQuery  id="thresholdtable" init="true">
	<@CommonQueryMacro.DataTable title="信贷资产监测指标阀值管理" id="table" fieldStr="indexName[400],indexCode,indexType,monitorRpe,threshold1,threshold2,indexType2,thresholdVersion,updateed,updateUser" paginationbar="btModify" />
</@CommonQueryMacro.CommonQuery>
<@CommonQueryMacro.FloatWindow id="datadicdetailFW" label="" width="800" resize="true" defaultZoom="normal" minimize="false" maximize="false" closure="true" float="true" exclusive="true" position="center" show="false">
<div style="margin:0 0 20px 0">
<@CommonQueryMacro.Group id="group1" label="阈值管理" fieldStr="indexCode,indexType,indexName,monitorRpe,thresholdVersion,zbDescripe,gatherTypeHave,gatherType" colNm="4"/>
</div>
<@CommonQueryMacro.Group id="group1" label="阈值区间" fieldStr="indexType2,threshold1,threshold2" colNm="6"/>

<div style="margin-left:42%;margin-bottom:5px"><@CommonQueryMacro.Button id="btSave"/>&nbsp;&nbsp;<@CommonQueryMacro.Button id="btCancel"/></div>
<@CommonQueryMacro.CommonQuery  id="subthresholdtable" >
	<@CommonQueryMacro.DataTable id="subtable" title="历史版本" fieldStr="version,yellow,red,updatetime,operator" />
</@CommonQueryMacro.CommonQuery>
</@CommonQueryMacro.FloatWindow>
<script language="JavaScript">

	var indexCode;
	function initCallGetter_post(){

	}
	function btModify_onClick(){
		indexCode=thresholdtable_dataset.getValue("indexCode");
		subthresholdtable_dataset.setParameter("indexCode",indexCode);
		subwindow_datadicdetailFW.show();
		subthresholdtable_dataset.flushData();
	}
	function btSave_onClickCheck(){
		var threshold1=thresholdtable_dataset.getValue("threshold1");
		var threshold2=thresholdtable_dataset.getValue("threshold2");
		var indexType2=thresholdtable_dataset.getValue("indexType2");
		if(indexType2=="0"){
			if(threshold1<threshold2){
				
			}else{
				easyMsg.error("递减规则要求红色标线数值小于黄色标线数值",{timeout:3000});
				return false;
			}
		}else if (indexType2=="1"){
			if(threshold1>threshold2){
				
			}else{
				easyMsg.error("递增规则要求红色标线数值大于黄色标线数值",{timeout:3000});
				return false;
			}
		}else{
			if(threshold1){
				
			}else{
				if(threshold2){
					alert("请输入完整的修改条件！");
					return false;
				}else{
					//所有选项为空
				}
			}
			if(threshold2){
				
			}else{
				if(threshold1){
					alert("请输入完整的修改条件！");
					return false;
				}else{
					//所有选项为空
				}
			}
			//easyMsg.error("请输入完整的修改条件！",{timeout:2000});
			
		}
	}
	function btSave_postSubmit(button){
//		easyMsg.correct("阈值修改成功！");
		subwindow_datadicdetailFW.close();
		thresholdtable_dataset.flushData();
	}

	function btCancel_onClick(){
		subwindow_datadicdetailFW.close();
		thresholdtable_dataset.flushData();
	}
</script>
</@CommonQueryMacro.page>