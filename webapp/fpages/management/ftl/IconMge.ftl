<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="ͼ�����">
<table align="left"><tr><td>
<@CommonQueryMacro.CommonQuery id="IconMge" init="true" >
<table width="800px">
    <tr>
		<td colspan="2">
			<@CommonQueryMacro.DataTable id="datatable1" title="ͼ�����" fieldStr="aid,aurl,bid,burl,cid,curl"  height="500" toolbar="mytoolbar" >
	        </@CommonQueryMacro.DataTable>
		</td>
	</tr>
</table>
</@CommonQueryMacro.CommonQuery>
</td></tr></table>
  <@CommonQueryMacro.ToolBar id="mytoolbar">   
   <div style="text-align:right">    
    <@CommonQueryMacro.InterfaceElement elId="qid" />
    <@CommonQueryMacro.InterfaceButton desc="btQuery" />   
   </div>    
  </@CommonQueryMacro.ToolBar>
  <script>
function datatable1_aurl_onRefresh(cell,value,record) {
 	if (record) {//�����ڼ�¼ʱ
 		if(value) {
			cell.innerHTML= '<div><img src="${contextPath}/templets/ui/themes/'+value+'" /></div>';
		} else {
			cell.innerHTML="&nbsp;";
		}
	} else {//�������ڼ�¼ʱ
		cell.innerHTML="&nbsp;";
	}
  
}
function datatable1_burl_onRefresh(cell,value,record) {
 	if (record) {//�����ڼ�¼ʱ
 		if(value) {
			cell.innerHTML= '<div><img src="${contextPath}/templets/ui/themes/'+value+'" /></div>';
		} else {
			cell.innerHTML="&nbsp;";
		}
	} else {//�������ڼ�¼ʱ
		cell.innerHTML="&nbsp;";
	}
  
}
function datatable1_curl_onRefresh(cell,value,record) {
 	if (record) {//�����ڼ�¼ʱ
 		if(value) {
			cell.innerHTML= '<div><img src="${contextPath}/templets/ui/themes/'+value+'" /></div>';
		} else {
			cell.innerHTML="&nbsp;";
		}
	} else {//�������ڼ�¼ʱ
		cell.innerHTML="&nbsp;";
	}
  
}
</script>
</@CommonQueryMacro.page>