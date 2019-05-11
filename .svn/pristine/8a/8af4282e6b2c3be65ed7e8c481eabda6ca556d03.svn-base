<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="安全参数">
	<@CommonQueryMacro.CommonQuery id="SysParamsSec" init="false" submitMode="current">
		<table width="100%">
			<tr>
				<td colspan="2">
					<@CommonQueryMacro.Interface id="interface" label="请输入查询条件" />
				</td>
			</tr>
			<tr>
				<td><@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" showArrow="true" pageCache="false"/></td>
			</tr>
			<tr>
				<td colspan="2">
					<@CommonQueryMacro.DataTable id="datatable1" fieldStr="paramId,magicId,paramValueTx,desc0[500],st,opr"  width="100%" hasFrame="true"  height="400"/>
				</td>
			</tr>

			<tr>
				<td valign="top" colspan="2">
					<@CommonQueryMacro.FloatWindow id="signWindow" label="" width="" resize="true" defaultZoom="normal" minimize="false" maximize="false" closure="true" float="true" exclusive="true" position="center" show="false" >
						<div align="center">
							<@CommonQueryMacro.Group id="group1" label="安全参数维护" fieldStr="paramId,magicId,paramValueTx,desc0" colNm=2/>
							</br>
							<@CommonQueryMacro.Button id= "btSubmit"/>
						</div>
					</@CommonQueryMacro.FloatWindow>
				</td>
			</tr>
		</table>
	</@CommonQueryMacro.CommonQuery>

	<script language="JavaScript">

		//定位一条记录
		function locate(paramId,magicId) {
			var record = SysParamsSec_dataset.find(["paramId","magicId"],[paramId,magicId]);
			if (record) {
				SysParamsSec_dataset.setRecord(record);
			}
		}

		function btSubmit_postSubmit(button){
			alert('保存成功！');
			subwindow_signWindow.hide();
			SysParamsSec_dataset.flushData(SysParamsSec_dataset.pageIndex);
		}

		function paModClick(paramId,magicId){
			//alert(id);
			locate(paramId, magicId);
			//var record = SysParamsSec_dataset.find(["magicId"],[magicId]);
			//  alert(record.getValue("magicId"));
			subwindow_signWindow.show();
		}

		function datatable1_opr_onRefresh(cell, value, record)
		{

			if(record){
				var paramId = record.getValue("paramId");
				var magicId = record.getValue("magicId");
				var lock=record.getValue("lock");
				if(isTrue(lock)){
					cell.innerHTML = "<center><a href=\"Javascript:void(0);\" style=\"color:#666666\" title=\"记录已锁定，不能操作\">修改</a> </center>";
				} else {
					cell.innerHTML ="<center><a href=\"JavaScript:paModClick('"+paramId+"','"+magicId+"')\">修改</a></center>";
				}
			}
		}
		function datatable1_magicid_onRefresh(cell, value, record){
			if(record!=null){
				var st = record.getValue("st");
				var id1 = record.getValue("magicId");
				var id2 = record.getValue("paramId");
				var id = id2+"|"+id1;
				cell.innerHTML = "<a href=\"Javascript:showDetail('"+id+"','"+st+"')\">"+id1+"</a>";
		 	} else {
				cell.innerHTML = ""
			}
		}

		function showDetail(id,st){
			var paramMap = new Map();
			paramMap.put("id",id);
			paramMap.put("st",st);
			paramMap.put("action","detail");
			paramMap.put("flag","0");
			loadPageWindows("partWin", "功能系统参数","/fpages/system/ftl/SysParamsSecDetail.ftl", paramMap, "winZone");
		}
	</script>
</@CommonQueryMacro.page>