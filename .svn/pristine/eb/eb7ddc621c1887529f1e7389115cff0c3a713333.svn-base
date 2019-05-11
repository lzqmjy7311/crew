<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign id="${RequestParameters['id']?default('')}" />
<@CommonQueryMacro.page title="">
<@CommonQueryMacro.CommonQuery id="TOutCouJudgmentDetail" init="false" submitMode="selected" navigate="false">
		 <div id='content'></div>
</@CommonQueryMacro.CommonQuery>
<script language="JavaScript">
var customerNum='${customerNum}';
function initCallGetter_post(){
	var id='${id}';
	TOutCouJudgmentDetail_dataset.setParameter("id",id);
	TOutCouJudgmentDetail_dataset.flushData();

	//TOutCouJudgmentDetail_dataset.setValue(json.Html)
}
function TOutCouJudgmentDetail_dataset_flushDataPost(){
	var data=TOutCouJudgmentDetail_dataset.getValue("content");
	var data1=data.substring(data.indexOf('\\"Html\\":')+11,data.indexOf('</div>\\"}"')+6);
	var innerhtml=document.getElementById('content');
	if(data1.indexOf('<a')==0){
		innerhtml.innerHTML=data1;
	}else{
		innerhtml.innerHTML=data;
	}

}
function datatable1_content_onRefresh(cell,value,record){
	if (record) {//当存在记录时
		var id=record.getValue("content");
		if(!!id){
			cell.innerHTML='<a href="JavaScript:aclick(\''+record.getValue("id")+'\')">查看详细内容</a>';
		}
	}
}
</script>
</@CommonQueryMacro.page>
