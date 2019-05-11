<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="我的下载" >
<@CommonQueryMacro.CommonQuery id="pageqryexp_mydownload" navigate="true" init="true" submitMode= "current" >
	<@CommonQueryMacro.Interface id="interface" label="请输入查询条件" />
	<@CommonQueryMacro.DataTable id="datatable1" fieldStr="tskNm,fileNm,tskStartTms[120],tskEndTms[120],expRcdSumNum,expFileSize,tskStat[60],op[35]"  width="100%" hasFrame="true"  readonly="true"/>
	<iframe name="dfrm"  id="dfrm" height="0" width="0" src=""></iframe>
</@CommonQueryMacro.CommonQuery >
<script language="javascript">
//定位一条记录
function locate(id) {
	var record = pageqryexp_mydownload_dataset.find(["id"],[id]);
	if (record) {
		pageqryexp_mydownload_dataset.setRecord(record); 
	}
}
//当系统刷新单元格的内容时被触发 
function datatable1_op_onRefresh(cell,value,record) {
	if (record) {//当存在记录时
		if (record.getValue("tskStat")=="3") {
			cell.innerHTML="<a href='JavaScript:download(\""+value+"\")'>下载</a> ";
		} else {
			cell.innerHTML="<a href='JavaScript:void(0)'>无法下载</a> ";
		}
	} else {//当不存在记录时
		cell.innerHTML="&nbsp;";
	}
}
function download(id) {
	locate(id);
	var filename = pageqryexp_mydownload_dataset.getValue("fileNm");
	var filepath = pageqryexp_mydownload_dataset.getValue("expFileNm");
	//window.open("${contextPath}/pageqryexp/DownloadAction.do?downloadinfo="+encode(filename+"|"+filepath));
	document.getElementById('dfrm').src="${contextPath}/pageqryexp/DownloadAction.do?downloadinfo="+encode(filename+"|"+filepath);
}
</script >
</@CommonQueryMacro.page>