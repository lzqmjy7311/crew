<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign year = RequestParameters["id"]?default('') />
<#assign flag = RequestParameters["flag"]?default('') />
<#assign st = RequestParameters["st"]?default('') />
<#assign type = RequestParameters["type"]?default('') />
<#assign tskId = RequestParameters["tskId"]?default('') />
<@CommonQueryMacro.page title="工作日期详细">
<script type="text/javascript" src="${contextPath}/js/workdate.js"></script>
<link rel='stylesheet' type="text/css" href="${contextPath}/css/workdate.css" />
<table align="left" width="900px"><tr><td>
<@CommonQueryMacro.CommonQuery id="biWorkDateDetail" init="false" navigate="false">
<table align="left" class="grouptable" width="100%">
	<tr>
		<td class="labeltd" width="100px">
		&nbsp;&nbsp;年份&nbsp;&nbsp;
		</td>
		<td class="datatd" width="100px">
			<@CommonQueryMacro.SingleField fId="biYear"/>
		</td>
		<td align="right"  nowrap="nowrap">
			<span style='height:4px;background-color:#c2dcfc;border:1px solid #ddd'>&nbsp;&nbsp;&nbsp;</span>&nbsp;工作日
			<span style='height:4px;background-color:#ffffff;border:1px solid #ddd'>&nbsp;&nbsp;&nbsp;</span>&nbsp;非工作日
			<span style='height:4px;background-color:#ffffcc;border:1px solid #ddd'>&nbsp;&nbsp;&nbsp;</span>&nbsp;非工作日修改为工作日
			<span style='height:4px;background-color:#abdebe;border:1px solid #ddd'>&nbsp;&nbsp;&nbsp;</span>&nbsp;工作日修改为非工作日
		</td>
	</tr>
</table>
</@CommonQueryMacro.CommonQuery>
</td></tr>
<tr><td>
<table width="100%" cellpadding='10' cellspacing='0' border='1' class='tablerowStyleColor'>
	<tr>
		<td><div id="month1"></div></td>
		<td><div id="month2"></div></td>
		<td><div id="month3"></div></td>
		<td><div id="month4"></div></td>
	</tr>
	<tr>
		<td><div id="month5"></div></td>
		<td><div id="month6"></div></td>
		<td><div id="month7"></div></td>
		<td><div id="month8"></div></td>
	</tr>
	<tr>
		<td><div id="month9"></div></td>
		<td><div id="month10"></div></td>
		<td><div id="month11"></div></td>
		<td><div id="month12"></div></td>
	</tr>
</table>
</td></tr></table>
<script language="javascript">

	if (biWorkDateDetail_dataset.length==0) {
		biWorkDateDetail_dataset.insertRecord("end");
	}
	biWorkDateDetail_dataset.setValue("biYear", "${year}");
	PrivAction.getWorkDateByDetail("${year}","${type}","${tskId}","${flag}","${st}",showBiWorkDate);


	//显示工作日期 并且查询是否已设置
	function showBiWorkDate(data){
		dwr.engine.setAsync(false);
		var newset = null;
		var oldset = null;
		if(data.length>0){
			oldset=data[0];
		}
		if(data.length>1){
			newset = data[1];
		}
		showWorkDate("${year}",oldset,newset);
		dwr.engine.setAsync(true);
	}

	function showWorkDate(year,oldset,newset){
		for(var i = 1; i <=12; i++){
			var str = workdate.createCalendarByDetail(year,i,oldset,newset);
			document.getElementById("month" + i).innerHTML = str;
		}
	}

</script>
</@CommonQueryMacro.page>
