<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign id="${RequestParameters['id']?default('')}" />
<#assign type="${RequestParameters['type']?default('')}" />
<@CommonQueryMacro.page title="">
<@CommonQueryMacro.CommonQuery id="TOutIndBaseInfo" init="false" submitMode="selected" navigate="false">
	<@CommonQueryMacro.Group id="busscope" label="" colNm="2"fieldStr="busscope2,fdInfoBeforeModify2,fdInfoAfterModify2"  
		 />
</@CommonQueryMacro.CommonQuery>
<script language="JavaScript">
var customerNum='${customerNum}';
function initCallGetter_post(){
	var id='${id}';
	var type='${type}';
	TOutIndBaseInfo_dataset.setParameter("id",id);
	TOutIndBaseInfo_dataset.setFieldHidden('busscope2',true);
	TOutIndBaseInfo_dataset.setFieldHidden('fdInfoBeforeModify2',true);
	TOutIndBaseInfo_dataset.setFieldHidden('fdInfoAfterModify2',true);
	if(type=='busscope'){
		TOutIndBaseInfo_dataset.setFieldHidden('busscope2',false);
	}else if(type=='fdinfobeforemodify'){
		TOutIndBaseInfo_dataset.setFieldHidden('fdInfoBeforeModify2',false);
	}else{
		TOutIndBaseInfo_dataset.setFieldHidden('fdInfoAfterModify2',false);
	}
	TOutIndBaseInfo_dataset.flushData();
}

</script>
</@CommonQueryMacro.page>
