<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>

<@CommonQueryMacro.page title="批量参数设置">
<table align="left" width="100%">

<tr>
<td valign="top" rowspan="1"  valign="top">
<@CommonQueryMacro.CommonQuery id="parammng_BhProcStep" init="true">
	<table align="left" width="100%">
		<tr>
			<td><@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" showArrow="true" pageCache="false"/></td>
			
		</tr>
		<tr>
   			<td colspan="2">
      			<@CommonQueryMacro.DataTable id ="datatable1" paginationbar="btNew" fieldStr="id,jobno,step,sub_step,process_function,runtime,maxproc,opr[100]"  readonly="true" width="100%"/></br>
    		</td>
  		</tr>
		<tr style="display:none">
    		<td colspan="2">
   			
				<@CommonQueryMacro.Button id= "btDelete"/>
    		</td>
    	</tr>
		<tr>
			<td colspan="2">
				<@CommonQueryMacro.FloatWindow id="FW_detail" label="" width="" resize="true" defaultZoom="normal" minimize="false" maximize="false" closure="true" float="true" exclusive="true" position="center" show="false" >
					<div align="center">
						<@CommonQueryMacro.Group id ="group1" label="批量参数设置" fieldStr="jobno,step,sub_step,process_function,process_param,process_tlrno,runtime,sub_flag,report_flag,maxproc,temp_flag,suspend,repeatCnt,desc0,desc1,desc2" colNm=4/>
						<@CommonQueryMacro.Button id= "btSave"/>
					</div>

				</@CommonQueryMacro.FloatWindow>
			</td>
		</tr>
   </table>
   <script language="javascript">
        function btSave_postSubmit(){
        	parammng_BhProcStep_dataset.flushData(parammng_BhProcStep_dataset.pageIndex);
        	subwindow_FW_detail.hide();
        }
        function btNew_onClickCheck(button) {
        	parammng_BhProcStep_dataset.insertRecord("end");
        	subwindow_FW_detail.show();
        	return false;
        }

        function FW_detail_floatWindow_afterClose(fw) {
        	if (isNaN(parammng_BhProcStep_dataset.getValue('id'))) {
        		parammng_BhProcStep_dataset.deleteRecord();
        	} else {
        		parammng_BhProcStep_dataset.setReadOnly(false);
        		btSave.style.display="";
        	}
        }

		//当系统刷新单元格的内容时被触发
		function datatable1_opr_onRefresh(cell,value,record) {
			if (record) {//当存在记录时
				cell.innerHTML="<a href='JavaScript:showDetail("+value+")'>详细</a> &nbsp; <a href='JavaScript:doDelete("+value+")'>删除</a>";
			} else {//当不存在记录时
				cell.innerHTML="&nbsp;";
			}
		}
		function showDetail(id) {
			locate(id);
			parammng_BhProcStep_dataset.setReadOnly(true);
			btSave.style.display="none";
			subwindow_FW_detail.show();
		}
        function btDelete_needCheck(button) {
        	return false;
        }
        function btDelete_postSubmit(){
        	parammng_BhProcStep_dataset.flushData(parammng_BhProcStep_dataset.pageIndex);
        }
		//删除
		function doDelete(id) {
			locate(id);
			parammng_BhProcStep_dataset.deleteRecord();
			window.document.getElementById('btDelete').click();
		}
		//定位一条记录
		function locate(id) {
			var record = parammng_BhProcStep_dataset.find(["id"],[id]);
			if (record) {
				parammng_BhProcStep_dataset.setRecord(record);
			}
		}
	</script>
</@CommonQueryMacro.CommonQuery>
</td>
</tr>


</table>
</@CommonQueryMacro.page>