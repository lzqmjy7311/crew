<#import "/templets/commonQuery/BankCommonQueryEditType.ftl" as htmlEditType>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<#--global value-->
<#global contextPath = contextPath>
<#---->

<#--页面宏定义-->
<#--
根据判断_mpf_来判断是否为主页面，还是页面片段
id    页面ID(主页面为master,页面片段的ID
title 页面标题(不允许为空)，对于页面片段为外部框的标题
body  是否显示body(允许为空，默认为"true")，对于页面片段就是外部框是否要显示
-->
<#macro page  title id="master" body="true">
	<#assign _mpf_ = RequestParameters["_mpf_"]?default("true")>
	<#if _mpf_ == "true">
		<@pageMaster title=title body=body>
			<#nested>
		</@pageMaster>
	<#else>
		<@pagelet id=id title=title body=body>
			<#nested>
		</@pagelet>
	</#if>
</#macro>

<#--主页面宏定义-->
<#--
title   页面标题(不允许为空)
body    是否显示body(允许为空，默认为"true")
-->
<#macro pageMaster title body="true">
<#assign globalinfo = statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException()>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <title><@bean.message key="${title}" /></title>
	<META HTTP-EQUIV="Cache-Control" CONTENT="no-cache">
	<META HTTP-EQUIV="Cache-Control" CONTENT="must-revalidate">
	<META HTTP-EQUIV="Content-Type" CONTENT="text/html; charset=GBK">
	<META HTTP-EQUIV="Pragma" CONTENT="no-cache">
	<META HTTP-EQUIV="funccode:needlog" CONTENT="20200:false">
	<META HTTP-EQUIV="X-UA-Compatible" CONTENT="IE=edge,chrome=1">
	<#assign _style=(globalinfo.getExtensbean().getRoleSysType())?default('PL')>
	<#if _style =="CM">
	<link rel="stylesheet" type="text/css" href="${contextPath}/templets/ui/themes/start/easyui.css">
	<#else>
	<link rel="stylesheet" type="text/css" href="${contextPath}/templets/ui/themes/blue/easyui.css">
	</#if>
	<link rel="stylesheet" type="text/css" href="${contextPath}/templets/ui/themes/icon.css">
	<style>
	body {
		 visibility: hidden;
	}
    </style>
    <#assign language=(globalinfo.getLocale().toString())?default('')>
    <#assign _local = "zh_CN">
	<#if language=="en_US" || language=="zh_TW">
		<#assign _local = language>
	</#if>
    <script type="text/javascript" src="${contextPath}/templets/ui/js/jquery-1.8.2.js"></script>
    <script type="text/javascript" src="${contextPath}/templets/ui/js/uicore-min.js" charset="utf-8"></script>
    <script type="text/javascript" src="${contextPath}/templets/ui/locale/lang-${_local}.js"></script>
	<script type="text/javascript" src="${contextPath}/templets/ui/js/rules.js"></script>
	<script type="text/javascript" src="${contextPath}/templets/ui/js/basic.js"></script>
	<script type="text/javascript" src="${contextPath}/templets/ui/js/properties.js"></script>
	<script type="text/javascript" src="${contextPath}/templets/ui/js/uiextend-min.js" charset="utf-8"></script>
	<script type="text/javascript" src="${contextPath}/templets/ui/js/uirender-min.js" charset="utf-8"></script>
	<script type="text/javascript" src="${contextPath}/templets/ui/js/uidata-min.js" charset="utf-8"></script>
	<script type="text/javascript" src="${contextPath}/templets/ui/js/tree.js"></script>
	<script type="text/javascript" src="${contextPath}/templets/ui/js/inquery.js"></script>
	<script type="text/javascript" src="${contextPath}/templets/ui/js/report.js"></script>
    <script type="text/javascript" src='${contextPath}/dwr/engine.js'> </script>
    <script type="text/javascript" src='${contextPath}/dwr/util.js'> </script>
    <script type="text/javascript" src="${contextPath}/templets/ui/js/dwr.js"></script>
	<script type="text/javascript" src='${contextPath}/dwr/interface/CommonQueryResultProcess.js'> </script>
	<script type="text/javascript" src='${contextPath}/dwr/interface/CommonQueryUpdateProcess.js'> </script>
	<script type="text/javascript" src='${contextPath}/dwr/interface/UploadMonitor.js'> </script>
	<script type="text/javascript" src='${contextPath}/dwr/interface/PrivAction.js'> </script>
	<script type="text/javascript">
	var user_info={
		roleId:"${globalinfo.getWorkflowRoleId()}",
		orgId:"${globalinfo.getBrno()}",
		userId:"${globalinfo.getTlrno()}",
		roleType:"${_style}"
	};
	<!-- 
    //document.oncontextmenu=new function(){event.returnValue=false;return false;}
	top.pageloading=true;//取消进度条
	var _extra_library="${contextPath}/templets/lib";
	var _theme_root="${contextPath}/templets/ui/themes/blue/images";
	var _application_root="${contextPath}";
	var _successURL = "${contextPath}"+"/success.ftl";
	var _defaultSubmitUrl=getDecodeStr("~2fextraservice~2fupdate");
	var _checkBrowser=true;
	var _disableSystemContextMenu=false;
	var _processEnterAsTab=true;
	var _enableClientDebug=false;
	var _supportsDatasetMultiSelect=true;
	var _paramMap = new Map();//用于设置默认值
	<#if globalinfo?exists>
	var _today_date = new Date("${globalinfo.getTxdate()?string("yyyy/MM/dd HH:mm:ss")}");//当前会计日期
	var _current_user = "${globalinfo.getTlrno()?default("")}";
	<#else>
	var _today_date = new Date();//当前会计日期
	var _current_user = "";
	</#if>
	switchTheme();
	//-->
	</script>
  </head>
  <#if body=="true">
  <body bgcolor="#FFFFFF" height="100%">
    <#nested>
  </body>
  <#else>
  	<#nested>
  </#if>
</html>
<script type="text/javascript">
	function _setElementsProperties(){};
	var pdate=new Date();
	initDocument();
	document.onreadystatechange = function() {
    	if(document.readyState=="complete"){
    	   document.body.style.visibility="visible";
    	   	_topmask(0);
    	   	top.pageloading=false;//取消进度条
    		initCallGetter();
	    }
	};

	tabNavigate("<@bean.message key="${title}" />",window.location.href);

</script>
</#macro>

<#macro pagelet id title body="true">
<#if body == "true">
<FIELDSET name='${title}' style="padding: 6px;">
	<LEGEND><@bean.message key="${title}"/></LEGEND>
	<#nested>
</FIELDSET>
<#else>
	<#nested>
</#if>
<script type="text/javascript">
	function documentlet_afterInit(){
		initLetCallGetter("${id}");
	}
</script>
</#macro>

<#--通用查询头模板-->
<#--
id                      通用查询id号(不允许为空)
init                    是否初始化标志(允许为空，默认为"false"           "true"-初始化;"false"-不初始化)
navigate　                导航标题是否显示标志(允许为空，默认为"true"        "true"-显示;"false"-不显示)
mode　                     模式标志(允许为空，默认为"0"                     0-生成结果Dataset,1-不生成结果Dataset)
submitMode              数据提交方式(允许为空,默认为"allchange"          all-全部提交,allchange-提交修改部分,current-提交当前的纪录, selected - 只提交所有被选择的纪录 )
paramerters             格外提交参数(允许为空,                          格式为 paramNm=paramVal;...)
readOnly                只读标志(允许为口空,默认为"false"                "true"-只读;"false"-非只读)
masterDataset           主dataset名称(允许为空,默认没有主dataset)
references              相关字段(允许为空,                             只有在设置了maseterDataset参数后才有效，表示于主dataset相关的字段     格式为sFieldName=mFieldName1;....)
show                    是否显示中间内容(允许为空,默认为"true"            "true"-显示;"false"-不显示)
insertOnEmpty           空数据集时是否插入空记录(允许为空,默认为"false"    "true"-插入空记录;"false"-不插入空记录)
cacheCount        缓存记录总数的方式，ALLWAYS:不count;ONCE:只count一次;空:总是count.默认空
-->
<#macro CommonQuery id init="false" navigate="true" mode="0"  submitMode="allchange" parameters="" readOnly="false" masterDataset="" references="" show="true" insertOnEmpty="false" cacheCount="">
<#assign CommonQueryConfig = statics["com.huateng.commquery.config.CommonQueryUtil"].getCommonQueryBean(id)>
<#assign type = CommonQueryConfig.getAnyValueDefault("type","call")>
<script type="text/javascript">
var _transDataActionURL = "${CommonQueryConfig.getAnyValue("transdataactionurl")}";
var _common_query_id = "${CommonQueryConfig.getId()}";
</script>
${CommonQueryConfig.script?default('')}

<#-- shen_antonio 20080118-->
<#if show=="false">
	<@Dataset init=init submitMode=submitMode parameters=parameters  readOnly=readOnly masterDataset=masterDataset references=references insertOnEmpty=insertOnEmpty cacheCount=cacheCount />
	<#return>
</#if>
	<#nested>
<#if mode!="1">
	<@Dataset init=init submitMode=submitMode parameters=parameters  readOnly=readOnly masterDataset=masterDataset references=references insertOnEmpty=insertOnEmpty cacheCount=cacheCount />
</#if>
<#-- yjw add  , fill the dataset -->
<#if mode=="0" && init=="false" &&  type!="form">
<#if CommonQueryResult?exists && CommonQueryResult.getCqId()==id>
<script type="text/javascript">
function ${id}_dataset_requestInit(){
	var _tmp = getDatasetByID("${id}_dataset");
	_tmp.disableControls();
	appendFromDataString(_tmp, "${CommonQueryConfig.toFieldString()}","${CommonQueryResult.getResultOprStr()}", true);
	_tmp.pageIndex=${CommonQueryResult.getPage().getCurrentPage()};
	_tmp.pageCount=${CommonQueryResult.getPage().getTotalPage()};
	/** set param .*/
	//converStr2DataSetParameter("${CommonQueryResult.getParamStr()}",_tmp);
	_tmp.enableControls();
	//_tmp.refreshControls();
	_tmp.loadDetail();
}
</script>
</#if>
</#if>
</#macro>

<#macro CommonQueryForRequest id=CQId navigate="true" submitMode="allchange" parameters="" show="true">
<@CommonQuery id=id init="false" navigate=navigate mode="0" submitMode=submitMode parameters=parameters show=show>
		<#nested>
</@CommonQuery>
<#--
<script type="text/javascript">
	var _tmp = getDatasetByID("${CQId}_dataset");
	_tmp.disableControls();
	appendFromDataString(_tmp, "${CommonQueryConfig.toFieldString()}","${CommonQueryResult.getResultOprStr()}", true);
	_tmp.pageIndex=${CommonQueryResult.getPage().getCurrentPage()};
	_tmp.pageCount=${CommonQueryResult.getPage().getTotalPage()};
	/** set param .*/
	//converStr2DataSetParameter("${CommonQueryResult.getParamStr()}",_tmp);
	/* shen_antonio .*/
	_tmp.enableControls();
	//_tmp.refreshControls();
	_tmp.loadDetail();
</script>
-->
</#macro>

<#macro Navigate>
	${CommonQueryConfig.getAnyValueDefault("navigate","")}
</#macro>

<#--通用Tabs模板-->
<#--
	id                            通用查询CQID(不允许为空)
	currentTab                    当前tab栏CQID(不允许为空)
	navigate                      显示导航栏标志(允许为空，默认为"true"        "true" 显示;"false" 不显示)
	currentUrl                    当前tab栏的URL(允许为空，默认为button对应url)
	width                         宽度(允许为空,默认为"100%")
	height                        高度(允许为空，默认为"100%")
-->
<#macro CommonQueryTab id currentTab   navigate="true" currentUrl="" width="" height="" >
<#assign CommonQueryConfig = statics["com.huateng.commquery.config.CommonQueryUtil"].getCommonQueryBean(id)>
<#assign _tab_ = RequestParameters["_tab_"]?default("")>

	<#nested>
	${CommonQueryConfig.script?default('')}
	<script>
	var ${id}_tabset = parent.${id}_tabset
	//${id}_tabset.select=setActiveTab;
	$(function(){
		/*
		var tabset = getJTabSetById("${id}_tabset");
	    var hisTitle = tabset.tabs('selectHis');
	    var newTitle = hisTitle[hisTitle.length-1];
	    var oldTitle = hisTitle.length>1?hisTitle[hisTitle.length-2]:newTitle;
	    if (newTitle != oldTitle) {
		    var p = tabset.tabs('getTab', oldTitle);
			var eventName="${id}_tabset_afterTabChange";
			try {
				fireUserEvent(eventName, [${id}_tabset, p.panel("options").id, "${currentTab}"]);
			} catch(e){}
		}
		*/
	});
	</script>
</#macro>

<#--建立DataSet模板-->
<#--
init                      初始化标志(允许为空,默认为"true"                "true"-初始化;"false"-不初始化)
submitMode                数据提交方式(允许为空,默认为"allchange"          all-全部提交,allchange-提交修改部分,current-提交当前的纪录, selected - 只提交所有被选择的纪录 )
paramerters               格外提交参数(允许为空,                          格式为 paramNm=paramVal;...)
readOnly                  只读标志(允许为口空,默认为"false"                "true"-只读;"false"-非只读)
masterDataset             主dataset名称(允许为空,默认没有主dataset)
references                相关字段(允许为空,                             只有在设置了maseterDataset参数后才有效，表示于主dataset相关的字段     格式为sFieldName=mFieldName1;....)
insertOnEmpty             空数据集时是否插入空记录(允许为空,默认为"false"    "true"-插入空记录;"false"-不插入空记录)
-->
<#macro Dataset init="true" submitMode="allchange"  parameters="" readOnly="false" masterDataset="" references="" insertOnEmpty="false" cacheCount="">
<#assign specStr="nextPage|everyPage|pageNm|currentPage|fieldString|recordString|recordOrigString">
<#--init request param -->
<#assign paramString = paramConver()>
<script type="text/javascript">
	var _ds = getDatasetByID("${CommonQueryConfig.getId()}_dataset");
	var ${CommonQueryConfig.getId()}_dataset=_ds||createDataset("${CommonQueryConfig.getId()}_dataset","","");
	if(!_ds){
	var _t=${CommonQueryConfig.getId()}_dataset;
	_initDataset(_t,"${CommonQueryConfig.getId()}",${CommonQueryConfig.getAnyValue("pagesize")?default("10")},"${CommonQueryConfig.getAnyValue("databusid")?default("")}"
	,"${masterDataset}","${references}","${submitMode}",${insertOnEmpty},"dd","${paramString}","${init}","result");
	_t.cacheCount='${cacheCount}';
	<#assign parameters = "${parameters}">
	    <#if parameters!="">
			<#list parameters?split(";")  as key>
				 <#assign index =key?index_of("=")>
				 <#assign paraName =key?substring(0,index)>
				 <#assign paraValue =key?substring(index+1)>
			 	 _t.setParameter("${paraName}","${paraValue}");
			</#list>
		</#if>
	<#assign fieldMap = CommonQueryConfig.fields>
			<#assign fields = fieldMap.keySet()>
 			<#assign field = "">
 			<#assign fDesc = "",fVal = "",fStat = "">
 			<#assign columnInx = 0>
 			<#list fields as fId>
   				<#assign field = CommonQueryConfig.getField(fId?string)>
    			<#assign fDesc = getFieldDesc(CommonQueryConfig.getId(),fId)>
    			<#assign fType = field.getAnyValue("datatype","string")>
    			<#assign fEidtType = field.getAnyValue("edittype","text")>
    			<#assign translated = field.getAnyValue("translated")?default('')>
    			<#if fEidtType=="checkbox">
    			   <#if translated=="">
					 <#assign fType = "boolean">
				   <#else>
    			     <#assign fType = "string">
    			   </#if>
				</#if>
      			<#assign fSize = defaultStr(field.getAnyValue("size")?default(''),"")>
      			<#assign readonly = field.getAnyValue("readonly")?default('false')>
      			<#assign required = defaultStr(field.getAnyValue("require")?default("false"),"false")>
      			<#assign mask = field.getAnyValue("rules")?default("null")>
      			<#assign maskErrorMessage = field.getAnyValue("errmsg")?default("")>
      			<#assign translated = field.getAnyValue("translated")?default("")>
      			<#assign scale = field.getAnyValue("scale")?default("")>
      			<#assign multiple = field.getAnyValue("multiple")?default("false")>
      			<#assign toolTip = field.getAnyValue("tip")?default(fDesc)>
      			<#assign translated = field.getAnyValue("translated")?default("")>
			    <#assign viewField = field.getAnyValue("viewfield","")>
      			<#assign prefix = field.getAnyValue("prefix")?default("")>
      			<#assign editable = field.getAnyValue("editable")?default("false")>
			   	<#if mask?length==0>
			    	<#assign mask="null">
			     </#if>
			    <#--modified by wangpeng 20091126 BMS-2274  添加predate和postdate的数据类型支持  begin-->
			    <#--added by wangpeng 20091126 BMS-2269 日期型固定10位  begin-->
			    <#if fType=="date" || fType=="predate" || fType=="postdate">
			        <#assign fSize="10">
			    </#if>
			    <#--added by wangpeng 20091126 BMS-2269 日期型固定10位 end-->
			    <#--modified by wangpeng 20091126 BMS-2274  添加predate和postdate的数据类型支持  end-->
			     <#--modified by wangpeng 20091123 BMS-2274  增加金额型框的对齐方式  begin-->
			     <#assign currencyAlign=field.getAnyValue("currencyalign")?default("right")>
		      	<#switch fEidtType>
				     <#case "select">
				     <#-- 如果是select 先加 fId　字段 ,循环结束后增加带name的字段,为 fId +　name -->
		      			   <#-- 判断是 该select 是 CQ方式，还是dataDic方式 ，如果是 CQ则要获得相应的 CQId 并且不能直接翻译，要到initdocument后翻译-->
			      				<#assign isCQ  = "false">
								<#assign CQid  = "">
								<#assign ddtype  = "select">
								<#list translated?split(":")  as key>
								     <#if key =="CQ">
										<#assign isCQ  = "true">
										<#break>
									</#if>
								</#list>
								<#assign dropdowntype = field.getAnyValue("dropdowntype")?default("dynamic")>
								<#if isCQ ="true">
									<#assign ddtype  = "selectCQ">
								    <#list translated?split(":")  as key>
										<#assign CQid  = key>
									</#list>
									<#if "dynamictree" == dropdowntype>
										<#assign ddtype  = "selectTree">
									</#if>
								<#else>
									<#if "custom" == dropdowntype>
										<#assign ddtype  = "selectCustom">
									<#elseif "dialog" == dropdowntype>
										<#assign ddtype  = "selectDialog">
									</#if>
								</#if>

								 <#if isCQ ="true">
		      			  _initField(_t,"${fId}","string","${viewField}","${mask}","${maskErrorMessage}","${toolTip}","${fDesc}",
		      			  "${fSize}","${scale}",${required},"${readonly}","${currencyAlign}","${ddtype}","${fId}_DropDown","${CQid}_DropDownDataset","","","${fEidtType}","${multiple}","${prefix}","${editable}");
				      			   <#else>
     			 			 _initField(_t,"${fId}","string","","${mask}","${maskErrorMessage}","${toolTip}","${fDesc}",
		      			  "${fSize}","${scale}",${required},"${readonly}","${currencyAlign}","${ddtype}","${fId}_DropDown","${fId}_DropDownDataset","","","${fEidtType}","${multiple}","${prefix}","${editable}");
				      			   </#if>
		      			  <#break>
				    <#default>
     			 			 _initField(_t,"${fId}","${fType}","","${mask}","${maskErrorMessage}","${toolTip}","${fDesc}",
		      			  "${fSize}","${scale}",${required},"${readonly}","${currencyAlign}","","","","","","${fEidtType}","${multiple}","${prefix}","${editable}");
				   	    <#break>
				</#switch>
	 		</#list>
<#-- 循环结束后增加 fId + Name 字段 -->
	<#assign fieldMap = CommonQueryConfig.fields>
			<#assign fields = fieldMap.keySet()>
 			<#assign field = "">
 			<#assign fDesc = "",fVal = "",fStat = "">
 			<#assign columnInx = 0>
	 		<#list fields as fId>
	 				<#assign field = CommonQueryConfig.getField(fId?string)>
	 				<#assign fEidtType = field.getAnyValue("edittype","text")>
	      			<#if fEidtType == "select" >
	      				    <#assign fDesc = getFieldDesc(CommonQueryConfig.getId(),fId)>
			    			<#assign fType = field.getAnyValue("type","string")>
			      			<#assign fSize = defaultStr(field.getAnyValue("size")?default(''),"")>
			      			<#assign readonly = field.getAnyValue("readonly","false")>
			      			<#assign required = defaultStr(field.getAnyValue("require")?default("false"),"false")>
			      			<#assign mask = field.getAnyValue("rules","null")>
			      			<#assign maskErrorMessage = field.getAnyValue("errmsg")?default("")>
			      			<#assign scale = field.getAnyValue("scale")?default("")>
			      			<#assign toolTip = field.getAnyValue("tip")?default(fDesc)>
			      			<#assign translated = field.getAnyValue("translated")?default("")>
			      			<#assign viewField = field.getAnyValue("viewfield","")>
			      			<#if mask?length==0>
			    				<#assign mask="null">
			     			</#if>
			      			    <#-- 判断是 该select 是 CQ方式，还是dataDic方式 ，如果是 CQ则要获得相应的 CQId-->
			      				<#assign isCQ  = "false">
								<#assign CQid  = "">
								<#list translated?split(":")  as key>
								     <#if key =="CQ">
										<#assign isCQ  = "true">
										<#break>
									</#if>
								</#list>
								<#if isCQ ="true">
								    <#list translated?split(":")  as key>
										<#assign CQid  = key>
									</#list>
								</#if>
								
				      			<#if fields?contains(fId+"Name")><#else>
				      			   <#if isCQ ="true">
     			 		 _initField(_t,"${fId}Name","string","${viewField}","${mask}","${maskErrorMessage}","${toolTip}","${fDesc}",
		      			  "${fSize}","${scale}",${required},"${readonly}","","selectName","${fId}_DropDown","${CQid}_DropDownDataset","","");
				      			   <#else>
     			 		 _initField(_t,"${fId}Name","string","","${mask}","${maskErrorMessage}","${toolTip}","${fDesc}",
		      			  "${fSize}","${scale}",${required},"${readonly}","","selectName","${fId}_DropDown","${fId}_DropDownDataset","","");
				      			   </#if>
				      			</#if>
			 			<#elseif fEidtType == "radio" >
	      				    <#assign fDesc = getFieldDesc(CommonQueryConfig.getId(),fId)>
			    			<#assign fType = field.getAnyValue("type","string")>
			      			<#assign fSize = defaultStr(field.getAnyValue("size")?default(''),"")>
			      			<#assign readonly = field.getAnyValue("readonly","false")>
			      			<#assign required = defaultStr(field.getAnyValue("require")?default("false"),"false")>
			      			<#assign mask = field.getAnyValue("rules","null")>
			      			<#assign maskErrorMessage = field.getAnyValue("errmsg")?default("")>
			      			<#assign scale = field.getAnyValue("scale")?default("")>
			      			<#assign toolTip = field.getAnyValue("tip")?default(fDesc)>
			      			<#assign translated = field.getAnyValue("translated")?default("")>
			      			<#assign viewField = field.getAnyValue("viewfield","")>
			      			<#if mask?length==0>
			    				<#assign mask="null">
			     			</#if>
     			 			 _initField(_t,"${fId}Name","string","","${mask}","${maskErrorMessage}","${toolTip}","${fDesc}",
		      			  "${fSize}","${scale}",${required},"${readonly}","","radioName","","","${fId}_Radio","${fId}_RadioDataset");
			 		</#if>
		 		</#list>
				initDataset(_t);
			  <#if readOnly ="true">
  			   	_t.setReadOnly(true);
  			  </#if>
			<#--默认值设置-->
			var  _paramValues = _paramMap.keys();
			for(var i=0;i<_paramValues.length;i++){
				_t.setValue(_paramValues[i],_paramMap.get(_paramValues[i]));
			}
			_paramMap.clear();
	}
</script>
<#-- 导出数据窗口 DIV -- 用于下载CSV,Excel,Pdf文件-->
<#if CommonQueryConfig.getPageExpConf("url")??>
	<@ExpFileDiv id ="${CommonQueryConfig.getId()}"/>
</#if>
</#macro>

<#--建立DropDownDataSet模板-->
<#macro DropDownDataSet init="true">
<#assign specStr="nextPage|everyPage|pageNm|currentPage|fieldString|recordString|recordOrigString">
<script type="text/javascript">
	var ${CommonQueryConfig.getId()}_dataset=createDataset("${CommonQueryConfig.getId()}_DropDownDataset","",";");

	<#--
	_initDataset(dataset,cqId,pageSize,databusId,masterDataset,references,submitData,insertOnEmpty,sessionKey,paramString,init,type)
	-->
	_initDataset(${CommonQueryConfig.getId()}_dataset,"${CommonQueryConfig.getId()}",${CommonQueryConfig.getAnyValue("pagesize")?default("10")},""
	,"","","allchange",false,"dd","","${init}","dropdown");

	var _dt = ${CommonQueryConfig.getId()}_t,_f;
   			<#assign fieldMap = CommonQueryConfig.fields>
			<#assign fields = fieldMap.keySet()>
 			<#assign field = "">
 			<#assign fDesc = "",fVal = "",fStat = "">
 			<#assign columnInx = 0>
 			<#list fields as fId>
		    <#--dataset,isCQ,isSelect,fId,fType,viewField,CQid,mask,maskErrMsg,toolTip,fDesc,fSize,scale,required,readonly,currencyAlign,tag,dropDown,dropDownDataset,radio,RadioDataset-->
     			 			 _initField(_dt,"${fId}","string","","","","","",
		      			  "","",false,"false","","radioName","","","","");
	 		</#list>
	 		initDataset(${CommonQueryConfig.getId()}_t);
</script>
</#macro>

<#--建立PagePilot栏-->
<#--
	id                  页面视图ID(不允许为空)
	maxpagelink         页面显示箭头标志(允许为空,默认为"true"            "true"-显示;"false"-不显示)
	pageCache           页面缓冲标志，默认为"false"  "true"-使用页面缓冲;即页面获取所有的数据记录后在页面进行分页
-->
<#macro PagePilot id width="100%" backgroundColor="#efefef" border="1px" maxpagelink="9" showArrow="true" pageCache="false">
<#--<div extra="pagination" componentDataset="${CommonQueryConfig.getId()}_dataset" name="${id}">
<div id="${id}" style="background:${backgroundColor};border:${border} solid #ccc;width:${width}" ></div>
</div>
-->
</#macro>


<#--查询结果 -- 导出弹出层-->
<#macro ExpFileDiv id fieldStr="${CommonQueryConfig.toFieldString()}"  width="" readonly="">
<#assign maxpage=CommonQueryConfig.getPageExpConf("maxpage")?default(statics["com.huateng.ebank.business.common.ConfigReader"].getProperty("PageQryExp_maxpage"))>
<#-- 弹出层元素：id, na(name)-->
<#assign fs = [ {"id":"s_p", "title":"PageQryExp.start",  "na":"${CommonQueryConfig.getId()}_startPage", "value":"1",  "type":"text",   "defAttr":"","rule":"isNumber","maxChk":"null", "err":"起始页必须是数字,且在有效页码范围内","event":""},
				{"id":"e_p", "title":"PageQryExp.end",  "na":"${CommonQueryConfig.getId()}_endPage",   "value":maxpage,  "type":"text",    "defAttr":"","rule":"isNumber","maxChk":"null","err":"结束页必须是数字,且在有效页码范围内","event":""},
				{"id":"a_p", "title":"PageQryExp.all",  "na":"${CommonQueryConfig.getId()}_allPage",   "value":"1", "type":"checkbox","defAttr":"disabled","rule":"null","maxChk":"null","err":"错误，请重新勾选","event":"onclick='checkAllpage(this,s_p,e_p)'"},
				{"id":"e_a", "title":"PageQryExp.batch","na":"${CommonQueryConfig.getId()}_expAll",   "value":"1", "type":"checkbox","defAttr":"","rule":"null","maxChk":"null","err":"","event":"onclick='checkExpall(this,a_p,s_p,e_p)'"},
				{"id":"c_x", "title":"PageQryExp.zip","na":"${CommonQueryConfig.getId()}_complex",   "value":"1", "type":"checkbox","defAttr":"","rule":"null","maxChk":"null","err":"错误，请重新勾选","event":""},
				{"id":"exp_cls", "title":"PageQryExp.columSelected","na":"${CommonQueryConfig.getId()}_expElements",  "value":"", "type":"mulSelect","defAttr":"","rule":"null","maxChk":"null","err":"","event":""}]>
<#assign fields = fieldStr?split(',')>
<#assign fsjs = "[">
<#list fs as f>
	<#if f_has_next>
		<#assign fsjs = fsjs + "{\"id\":\""+f.id+"\","+ "\"na\":\""+f.na+"\","+ "\"type\":\""+f.type+"\","+ "\"rule\":"+f.rule+","+ "\"maxChk\":"+f.maxChk+","+ "\"err\":\""+f.err+"\"},">
	<#else>
		<#assign fsjs = fsjs + "{\"id\":\""+f.id+"\","+ "\"na\":\""+f.na+"\","+ "\"type\":\""+f.type+"\","+ "\"rule\":"+f.rule+","+ "\"maxChk\":"+f.maxChk+","+ "\"err\":\""+f.err+"\"}">
	</#if>
</#list>
<#assign fsjs = fsjs + "]" >
<div id="newWinFrame${id}" style="display:none" buttontext="<@bean.message key="PageQryExp.btExport"/>">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr><td>
		<table width="100%" border="0" cellspacing="0" cellpadding="0" >
			<tr>
				<td class="labeltd" width="20%" align="left" nowrap><@bean.message key="PageQryExp.page" /></td>
				<td class="datatd" nowrap width="30%">
					<input extra="numberbox" id="s_p" type="text" name="${CommonQueryConfig.getId()}_startPage" min="1" value="1" style="width:40px" size="10" err="起始页必须是数字,且在有效页码范围内"/>&nbsp;~&nbsp;
					<input extra="numberbox" id="e_p" type="text" name="${CommonQueryConfig.getId()}_endPage" min="1" value="${maxpage}" style="width:40px" size="10" err="结束页必须是数字,且在有效页码范围"/>
				</td>
				<td class="labeltd" width="20%" align="left" nowrap><@bean.message key="PageQryExp.all" /></td>
				<td class="datatd" nowrap>
					<input id="a_p" type="checkbox" name="${CommonQueryConfig.getId()}_allPage" value="1" disabled err="错误，请重新勾选" onclick='checkAllpage(this,s_p,e_p)'/>
				</td>
			</tr>
			<tr>
				<td class="labeltd" width="20%" align="left" nowrap><@bean.message key="PageQryExp.batch" /></td>
				<td class="datatd" nowrap>
					<input id="e_a" type="checkbox" name="${CommonQueryConfig.getId()}_expAll" value="1" onclick='checkExpall(this,a_p,s_p,e_p)'/>
				</td>
				<td class="labeltd" width="20%" align="left" nowrap><@bean.message key="PageQryExp.zip" /></td>
				<td class="datatd" nowrap>
					<input id="c_x" type="checkbox" name="${CommonQueryConfig.getId()}_complex" value="1" err="错误，请重新勾选"/>
				</td>
			</tr>
		</table>
	</td></tr>
	<tr><td>
		<div class="exp-mulselect" >
		<div class="exp-col-title"><@bean.message key="PageQryExp.columExported"/></div>
		<#list fields as fId>
	       <#assign field = CommonQueryConfig.getField(fId)>
	       <#assign fDesc = field.getAnyValue("desc")>
		   <#assign fStatus = field.getAnyValue("status")?default("N")>
		   <#if fStatus?upper_case != "N">
		   		<label class="nock" id="l_WebSite_${fId}"><#t/>
		   			<input type="checkbox" name="${CommonQueryConfig.getId()}_expElements" id="i_WebSite_${fId}" CHECKED value="${fId}" class="exp-checkbox" onclick="" onpropertychange=""/><#t/>
		   			<div onclick="mul_move.selectedNode('i_WebSite_${fId}','l_WebSite_${fId}');"><@bean.message key="${fDesc}" /></div><#t/>
		   		</label><#t/>
		   </#if>
		</#list>
		</div>
	</td></tr>
	<tr><td>
		<div class="exp-tip">
		<div><@bean.message key="PageQryExp.tip"/></div>
		<div> <@bean.message key="PageQryExp.tip.1"/>${maxpage}</div>
		<div> <@bean.message key="PageQryExp.tip.2"/></div>
		</div>
	</td></tr>
</table>
<div id="expErrDiv${id}" class="exp-warn"></div>
</div>
<script type="text/javascript">
//字段导出选择，左右上下移动
var mul_move = new mulSelect("${CommonQueryConfig.getId()}_expElements");
/** 查询结果下载对象 **/
var ${CommonQueryConfig.getId()}_dataset_exporter = new exporter("${CommonQueryConfig.getPageExpConf("url")!"#"}",${CommonQueryConfig.pageExportLimit()?string("true", "false")});
/** 设置对象的参数 - Servlet path **/
${CommonQueryConfig.getId()}_dataset_exporter.setContentPath("${contextPath}");
/** 是否能导出CSV **/
${CommonQueryConfig.getId()}_dataset_exporter.setCanExpCsv(${CommonQueryConfig.canExport("CSV")?string("true", "false")},null);
/** 是否能导出Excel **/
${CommonQueryConfig.getId()}_dataset_exporter.setCanExpXls(${CommonQueryConfig.canExport("XLS")?string("true", "false")},null);
/** 是否能导出PDF **/
${CommonQueryConfig.getId()}_dataset_exporter.setCanExpPdf(${CommonQueryConfig.canExport("PDF")?string("true", "false")},null);
/** 数据集查询条件的名字 **/
${CommonQueryConfig.getId()}_dataset_exporter.setDataSetInterface("${CommonQueryConfig.getId()}_interface_dataset");
/** 数据集的名字 **/
${CommonQueryConfig.getId()}_dataset_exporter.setDataSet("${CommonQueryConfig.getId()}_dataset");
//设置显示层的元素集合
${CommonQueryConfig.getId()}_dataset_exporter.setDivEls(${fsjs});
//设置脚本中对象的ID
${CommonQueryConfig.getId()}_dataset_exporter.setExpWinId("#newWinFrame${id}","#expErrDiv${id}");
//设置弹出层的属性
${CommonQueryConfig.getId()}_dataset.ExpFileDiv=${CommonQueryConfig.getId()}_dataset_exporter;
$("#s_p").bind("change",function(){
	if($("#e_p").val()=="")return;
	if(parseInt($("#s_p").val())>parseInt($("#e_p").val())){
	  alert(constExpInfo);
	  $(this).numberbox("setValue","");
	}
});
$("#e_p").bind("change",function(){
	if($("#s_p").val()=="")return;
	if(parseInt($("#s_p").val())>parseInt($("#e_p").val())){
	  alert(constExpInfo);
	  $(this).numberbox("setValue","");
	}
});
</script>
</#macro>

<#macro Thead fId rowspan frozen r=0>
	   <#assign _width = "">
	   <#assign _fId = "">
	   <#if fId?matches(".*\\[.*\\]")>
	        <#assign _startIndex = fId?index_of("[")>
	        <#assign _endIndex = fId?index_of("]")>
	   		<#assign _width = fId?substring(_startIndex+1 ,_endIndex)>
	   		<#assign _fId = fId?substring(0,_startIndex)>
	   <#else>
	   		<#assign _fId = fId>
	   </#if>
       <#assign field = CommonQueryConfig.getField(_fId)>
       <#assign fDesc = getFieldDesc(CommonQueryConfig.getId(),_fId)>
       <#if _width == "">
         <#if _isHiddenScoll=="false">
       	    <#assign fwidth = field.getAnyValue("width")?default('')>
       	 <#else>
       	    <#assign fwidth = _width>  
       	 </#if>   
       <#else>
       	    <#assign fwidth = _width>
       </#if>
       <#assign fedittype = field.getAnyValue("edittype")?default("text")>
       <#assign datatype = field.getAnyValue("datatype")?default('string')>
       <#assign desc = field.getAnyValue("desc")?default('')>
	   <#assign fTip  = field.getAnyValue("tip")?default(desc)>
       <#assign align = field.getAnyValue("align")?default('')>
       <#assign multiple = field.getAnyValue("multiple")?default('')>
    <#if fedittype != "hidden">
      <#if frozen>
	      <#if r==0>
			<#assign forzenhead = forzenhead + "<th field=\"" + _fId + "\" rowspan=\""+ rowspan+"\" width=\""+ fwidth+"\" align=\""+align+"\" title=\""+fTip+"\" multi=\""+multiple+"\" >" +desc+"</th>">
		  <#elseif r==1>
			<#assign forzenhead1 = forzenhead1 + "<th field=\"" + _fId + "\" rowspan=\""+ rowspan+"\" width=\""+ fwidth+"\" align=\""+align+"\" title=\""+fTip+"\" multi=\""+multiple+"\" >" +desc+"</th>">
		  <#elseif r==2>
			<#assign forzenhead2 = forzenhead2 + "<th field=\"" + _fId + "\" rowspan=\""+ rowspan+"\" width=\""+ fwidth+"\" align=\""+align+"\" title=\""+fTip+"\" multi=\""+multiple+"\" >" +desc+"</th>">
		  </#if>
      <#else>
	      <#if r==0>
			<#assign tablehead = tablehead + "<th field=\"" + _fId + "\" rowspan=\""+ rowspan+"\" width=\""+ fwidth+"\" align=\""+align+"\" title=\""+fTip+"\" multi=\""+multiple+"\" >" +desc+"</th>">
		  <#elseif r==1>
			<#assign tablehead1 = tablehead1 + "<th field=\"" + _fId + "\" rowspan=\""+ rowspan+"\" width=\""+ fwidth+"\" align=\""+align+"\" title=\""+fTip+"\" multi=\""+multiple+"\" >" +desc+"</th>">
		  <#elseif r==2>
			<#assign tablehead2 = tablehead2 + "<th field=\"" + _fId + "\" rowspan=\""+ rowspan+"\" width=\""+ fwidth+"\" align=\""+align+"\" title=\""+fTip+"\" multi=\""+multiple+"\" >" +desc+"</th>">
		  </#if>
      </#if>
  
          <#if fedittype=="select">
      	      <#assign translated = field.getAnyValue("translated")?default('')>
    	      <#assign init = defaultStr(field.getAnyValue("init")?default("true"),"true")>
    	      <#assign lable = field.getAnyValue("desc")?default('')>
    	      <#assign require = field.getAnyValue("require")?default("false")>
      	      <#assign transAry = translated?split(":")>
      	      <#assign type = "">
	          <#assign value = "">
	          <#if transAry[1]?exists>
	          	<#if transAry[0]?exists>
		           <#assign type = transAry[0]>
		           <#assign value = transAry[1]>
		        </#if>
		      <#else>
		           <#assign type = "DATA_DIC">
	          </#if>
	        <#switch type>
	         <#case "CQ">
	         	<#assign CQid = value>
	         	<#assign viewField = field.getAnyValue("viewfield","")>
				<#assign fieldMap = field.getAnyValue("fieldmap","")>
				<#assign dropdowntype = defaultStr(field.getAnyValue("dropdowntype")?default("dynamic"),"dynamic")>
				<#if dropdowntype=="dynamic">
					<#assign ddtype = "cq">
				<#elseif dropdowntype=="dynamictree">
					<#assign ddtype = "dynamictree">
				</#if>
	         	<@htmlEditType.CommonQueryForSelect id="${CQid}" init=init require="false">
	         		  <script type="text/javascript">
					 _initDropDown_cust1("${CQid}_DropDownDataset","${_fId}_DropDown","${ddtype}","${fieldMap}","table","${viewField}","0");
					 var ${_fId}_DropDown = getDropDownByID("${_fId}_DropDown");
					 function ${_fId}_cellFormatter(value,rowData,rowIndex,currentField,id,cellJQuery){
			       		var eventName = id + "_" + currentField.toLowerCase() + "_onRefresh";
						if (isUserEventDefined(eventName)) {
							try{fireUserEvent(eventName, [ cellDom, value, record ]);}catch(e){
								return "cell format error";
							}
							return cellDom.innerHTML;
						} else {
		                    return rowData.record.getString(currentField+"Name");
						}
                  	 }
					  </script>
	         	</@htmlEditType.CommonQueryForSelect>
                <#break>
             <#case "LIST">
             <#case "DATA_DIC">
             <#if type=="LIST">
    		     <#assign values = value>
    		  <#else>
	    	     <#assign values = sysDicStr(translated)>
	    	  </#if>
			     <#assign fMap=_fId + "=" + "data">
			     <#assign fileMapString = fMap+";${_fId}Name=dataName">
			     <script>
					<#assign ddtype = defaultStr(field.getAnyValue("dropdowntype")?default("dynamic"),"dynamic")>
					<#if ddtype=='custom'||ddtype=='dialog'>
						<#assign readonly = field.getAnyValue("readonly")?default("false")>
						<#assign fieldMap = field.getAnyValue("fieldmap","")>
						<#assign height = field.getAnyValue("height")?default("")>
						<#assign url = field.getAnyValue("url")?default("")>
						_initDropDown_cust2("${_fId}_DropDownDataset","${_fId}_DropDown","${CommonQueryConfig.getId()}_dataset","${readonly}","${ddtype}","${fieldMap}","${height}","${url}","${_fId}");
						var ${_fId}_DropDownDataset = getDatasetByID("${_fId}_DropDownDataset");
						var ${_fId}_DropDown = getDropDownByID("${_fId}_DropDown");
					<#else>
              	   _initDropDown("${_fId}_DropDownDataset","${_fId}_DropDown","${values}","data,dataName","${lable}","${fileMapString}","dataName","","","${require}");
			       var ${_fId}_DropDownDataset=getDatasetByID("${_fId}_DropDownDataset");
			       var ${_fId}_Json;
			       function ${_fId}_cellFormatter(value,rowData,rowIndex,currentField,id,cellJQuery){
			       		var valueStr = ""+value;
			       		var valueArr = valueStr.split(",");
			       		var result = [];
			       		if(valueArr) {
			       			for(var i=0;i<valueArr.length;i++){
			       				var valueText = "";
			       				for(var j=0;j<${_fId}_Json.length;j++){
			       					if(valueArr[i] == (""+${_fId}_Json[j].id)) {
			       						valueText = ${_fId}_Json[j].text;
			       						break;
			       					}
			       				}
			       				result.push(valueText?valueText:valueArr[i]);
			       			}
			       			value = result.join(",");
			       		}
                     return _cellFormatter(value,rowData,rowIndex,currentField,id,cellJQuery);
                   }
					</#if>
      	         </script>
      	      <#break>
             <#default>
               <#assign targetDataSet = CommonQueryConfig.getId() + "_dataset">
               <#assign readonly = field.getAnyValue("readonly")?default("false")>
               <#assign fieldMap = field.getAnyValue("fieldmap","")>
               <#assign height = field.getAnyValue("height")?default("")>
               <#assign url = field.getAnyValue("url")?default("")>
               <script>
                 _initDropDown_cust2("${_fId}_DropDownDataset","${_fId}_DropDown","${targetDataSet}","${readonly}","custom","${fieldMap}","${height}","${url}","${_fId}");
               </script>

              <#break>
              </#switch>
          <#else>
          </#if>
      </#if>
</#macro>
<#--建立DataTable栏-->
<#--
	id                 页面视图ID(不允许为空)
	frozens            指定固定列的数量，从左边开始数
	fieldStr           显示字段属性(允许为空,默认为显示Fields中所有字段        值格式为：field1_id,field2_id,...)
	                   modify by shen_antonio 20100520 支持每个field增加[width]字段
	                                                 值格式修改为field1_id[width],field2_id[width]......
	moreFieldStr       更多的列,这些列默认是不显示的,格式同fieldStr
	width              表格宽度(允许为空,默认自适应,不写它会撑满整个区域)
	height             表格高度(允许为空,默认自适应)
	sumfieldstr        汇总字段，达到页面小计效果,可为空
	paginationbar      分页栏里工具栏按钮 格式为：按钮ID,按钮ID2,-,按钮ID3  其中-表示分隔竖线
	treeGrid           开启树形grid 默认为false
	treeField          指定树形grid中的根目录，被指定的 可以点击 展开或者合并
	idField
	hasFrame           
	floatwindow        //弹出式window的id,对应于macro SubWindow
	pageCache          是否开启前台分页
	maxRow             最大显示行数（用于pageCache方式时，设置当前表格最大显示的行数，在不使用pagecache方式时，请不要使用该字段)
	printabled         //是否能够打印(允许为空，默认为false)
	readonly           只读标志(允许为空,默认为"false"                     "true"-只读;"false"-可编辑)
	pagination         是否显示分页栏,默认显示
	mergeHead          多表头配置(最多支持三层,最低层字段之间用|分隔,第二层用;分隔)  参考格式: 组合列{data1;列2{textString3|dialog}}  
	rownumbers         是否在第一列 显示序列号 默认true
	remoteSort         是否开启远程排序,传递参数order(asc|desc)和sortField(排序字段id)
	remeberCheck       是否记忆已选择列
	pkid               数据的主键,配合remeberCheck使用
	fitColumns         true:自动调整列宽来填充表格宽度,防止出现横向滚动条;false:无滚动条
	showRefresh        true:显示刷新按钮;false:不显示. 默认:true
	showPageList       是否显示下拉页码,默认true
	isHiddenScoll      是否隐藏预留表格的滚动条位，默认为：false
	sortable           是否允许排序，默认为true。
	headAlign          表头的水平对齐方法，参数有left,center,right. 默认为left.
	mergeCols          合并指定列.多个列用,分隔.
	simpleMode         是否开启精简模式：在精简模式下表格只读并丢失一些高级功能。但当开启冻结功能或编辑功能时，该模式无效. 默认开启
	nowrap             行内容是否自动换行,默认false
	headBar           表头中的工具栏按钮，格式为：按钮ID,按钮ID2,-,按钮ID3  其中-表示分隔竖线
	displayMsg         表总记录信息,如 共{total}条记录，其中{total}是关键字，另支持{form}、{to}
-->
<#macro DataTable id  frozens="0"  fieldStr="${CommonQueryConfig.toFieldString()}" moreFieldStr="" width="" height=""  sumfieldstr="" title=""  paginationbar="" rowStyler="false"  treeGrid="false"  treeField=""
hasFrame="false" isHiddenScoll="false" sortable="true" headAlign="left" floatwindow="" maxRow="" printabled="true" readonly="true"  pagination="true"  mergeHead="" rownumbers="true" remoteSort="false" pageCache="false" pkid="" remeberCheck="false" toolbar=""
 fitColumns="true" showRefresh="true" mergeCols="" simpleMode="true" nowrap="false" showPageList="true" headBar="" displayMsg="">
<#assign _simpleMode = simpleMode>
<#if frozens!="0"||readonly!="true"||treeGrid=="true">
	<#assign _simpleMode = "false">
</#if>
<#assign _qutofirst = fieldStr?index_of(",") >
<#assign _isHiddenScoll=isHiddenScoll>
<#if _qutofirst == -1>
<#assign firstField = fieldStr>
<#else>
<#assign firstField = fieldStr?substring(0, _qutofirst)>
</#if>
<#assign _select = "false">
<#assign _fieldStr = fieldStr>
<#if moreFieldStr != "">
  <#if _fieldStr == "">
    <#assign _fieldStr = moreFieldStr>
  <#else>
    <#assign _fieldStr = _fieldStr + "," + moreFieldStr>
  </#if>
</#if>
<#if firstField?index_of("select") != -1>
	<#assign _select = "true">
	<#assign _ind = firstField?length>
	<#assign _fieldStr = _fieldStr?substring(_ind+1)>
</#if>
<#assign quto = firstField?index_of("[")>
<#if quto != -1>
	<#assign firstField = firstField?substring(0,quto)> 
</#if>
<#assign frozenNo=frozens?number>
<#assign tablehead="">
<#assign forzenhead="">
<#assign tablehead1="">
<#assign forzenhead1="">
<#assign tablehead2="">
<#assign forzenhead2="">
<#assign fCount = 0>
<#assign fieldExp1 = "([a-zA-Z]\\w+(\\[\\d+\\])?(?=[,|};]))|([a-zA-Z]\\w+(\\[\\d+\\])?)$">
<#assign fieldseq = _fieldStr?split(",")>
<#assign fields = _fieldStr?matches(fieldExp1)>
<#assign fCount = fCount + fields?size>
<#assign rowspan = 1>
<#if _fieldStr?contains(";")>
	<#assign rowspan = 3>
<#elseif _fieldStr?contains("|")>
	<#assign rowspan = 2>
</#if>
<#if _select=="true">
  <#assign forzenhead="<th field=\""+firstField+"\" rowspan=\""+rowspan+"\" checkbox=\"true\">"+getFieldDesc(CommonQueryConfig.getId(), firstField)+"</th>">
  <#assign fCount = 1>
</#if>
<#assign _maxRow = defaultStr(maxRow, "10")>
<#list fieldseq as fId>
	<#assign frozen = fId_index < frozenNo >
	<#if fId?contains("{")>
		<#assign ind1 = fId?index_of("{")>
		<#assign combtitle = fId?substring(0,ind1)>
		<#assign combfield = fId?substring(ind1+1,fId?length-1)>
		<#if rowspan ==3 && (fId?contains(";")||fId?contains("}}"))>
			<#assign subcombfields = combfield?split(";")>
			<#assign suballfields = combfield?matches(fieldExp1) >
			<#if frozen>
				<#assign forzenhead=forzenhead+"<th colspan=\""+suballfields?size+"\" sub=\""+combfield+"\">"+combtitle+"</th>">
			<#else>
				<#assign tablehead=tablehead+"<th colspan=\""+suballfields?size+"\" sub=\""+combfield+"\">"+combtitle+"</th>">
			</#if>
			<#list subcombfields as subcombfield>
				<#assign ind1 = subcombfield?index_of("{")>
				<#if ind1 == -1>
					<@Thead fId=subcombfield rowspan=2 frozen=frozen r=1/>
				<#else>
					<#assign combtitle = subcombfield?substring(0,ind1)>
					<#assign subfieldstr = subcombfield?substring(ind1+1,subcombfield?length-1)>
					<#assign subfields = subfieldstr?split("|")>
					<#if frozen>
						<#assign forzenhead1=forzenhead1+"<th colspan=\""+subfields?size+"\" sub=\""+subfieldstr+"\">"+combtitle+"</th>">
					<#else>
						<#assign tablehead1=tablehead1+"<th colspan=\""+subfields?size+"\" sub=\""+subfieldstr+"\">"+combtitle+"</th>">
					</#if>
					<#list subfields as cf>
						<@Thead fId=cf rowspan=1 frozen=frozen r=2/>
					</#list>
				</#if>
			</#list>
		<#else>
			<#assign subfields = combfield?split("|")>
			<#if frozen>
				<#assign forzenhead=forzenhead+"<th rowspan=\""+(rowspan-1)+"\" colspan=\""+subfields?size+"\">"+combtitle+"</th>">
			<#else>
				<#assign tablehead=tablehead+"<th rowspan=\""+(rowspan-1)+"\" colspan=\""+subfields?size+"\">"+combtitle+"</th>">
			</#if>
			<#list subfields as cf>
				<@Thead fId=cf rowspan=1 frozen=frozen r=rowspan-1/>
			</#list>
		</#if>
	<#else>
		<@Thead fId=fId rowspan=rowspan frozen=frozen/>
	</#if>
</#list>

 <#if treeGrid=="false">
   <#assign class="easyui-datagrid">
 <#else>
   <#assign class="easyui-treegrid">
 </#if>
 <#assign twidth= px(width)>
 <#assign theight= px(height)>
<table id="${id}" title="${title}" width="100%" class="rdatagrid" isHiddenScoll="${isHiddenScoll}" style="visibility:hidden;width:${twidth};height:${theight};line-height:${theight}" <#if _select=="true">selectkey="${firstField}"</#if> autoRowHeight="true"  paginationbar="${paginationbar}" frozens="${frozens}" rowStyler="${rowStyler}"  treeGrid="${treeGrid}" mergeHead="" pageSize="${_maxRow}"
     extra="<#if _simpleMode=='true'>rdatagrid<#else>datagrid</#if>" rownumbers="${rownumbers}" sortable="${sortable}" headAlign="${headAlign}" sumfieldstr="${sumfieldstr}" <#if sumfieldstr!="">showFooter="true"</#if> remoteSort="${remoteSort}" fCount="${fCount}" treeField="${treeField}" componentDataset="${CommonQueryConfig.getId()}_dataset" readonly="${readonly}"  tableName="${id}" pagination="${pagination}" pageCache="${pageCache}"
     pkid="${pkid}" remeberCheck="${remeberCheck}" floatwindow="${floatwindow}" toolbar="#ToolBar_${toolbar}" showPageList="${showPageList}" fitColumns="${fitColumns}" showRefresh="${showRefresh}" mergeCols="${mergeCols}" moreFieldStr="${moreFieldStr}" nowrap="${nowrap}" headBar="${headBar}" displayMsg="${displayMsg}">
		<#if _simpleMode!='true'>
		<thead frozen="true">
			<tr>
		       ${forzenhead}
		    </tr>
		    <#if forzenhead1 != "" || forzenhead2 != "">
			<tr>
		       ${forzenhead1}
		    </tr>
		    </#if>
		    <#if forzenhead2 != "">
			<tr>
		       ${forzenhead2}
		    </tr>
		    </#if>
		</thead>
		</#if>
		<thead>
		    <tr>
				<#if _simpleMode=='true'>
				 ${forzenhead}
				</#if>
		       ${tablehead}
		    </tr>
		    <#if tablehead1 != "" || tablehead2 != "">
			<tr>
				<#if _simpleMode=='true'>
				 ${forzenhead1}
				</#if>
		       ${tablehead1}
		    </tr>
		    </#if>
		    <#if tablehead2 != "">
			<tr>
				<#if _simpleMode=='true'>
				 ${forzenhead2}
				</#if>
		       ${tablehead2}
		    </tr>
		    </#if>
		</thead>
</table>
<table id="${id}_paginationbar" style="display:none;width:100%;">
<tr>
<#if CommonQueryConfig.canExport("CSV")>
<td class="pagination-toolbar"><a extra="button" plain="true" iconCls="icon-export-csv" title="CSV" onclick="javascript:${CommonQueryConfig.getId()}_dataset_exporter.openExpWin('CSV');" ></a></td>
</#if>
<#if CommonQueryConfig.canExport("XLS")>
<td class="pagination-toolbar"><a extra="button" plain="true" iconCls="icon-export-xls" title="XLS" onclick="javascript:${CommonQueryConfig.getId()}_dataset_exporter.openExpWin('XLS');" ></a></td>
</#if>
<#if CommonQueryConfig.canExport("PDF")>
<td class="pagination-toolbar"><a extra="button" plain="true" iconCls="icon-export-pdf" title="PDF" onclick="javascript:${CommonQueryConfig.getId()}_dataset_exporter.openExpWin('PDF');" ></a></td>
</#if>
<#if paginationbar != "">
<#assign barBts = paginationbar?split(",")>
<#list barBts as item>
	<#if item=="-">
		<td class="pagination-toolbar"><div class="pagination-btn-separator"></div><td>
	<#else>
        <td class="pagination-toolbar"><@Button id=item plain="true"/></td>
    </#if>
</#list>
</#if>
</tr>
</table>
<#if headBar != "">
<div id="${id}_headBar">
<table style="width:100%;">
<tr>
<td>${title}</td>
<td align="right">
<#assign headBarBts = headBar?split(",")>
<#list headBarBts as item>
 <@Button id=item plain="true"/>
</#list>
</td>
</tr>
</table>
</div>
</#if>
<#nested>
</#macro>

<#macro SimpleGroupField id fId restCol colNm hasNext labelwidth>
	<#assign field = CommonQueryConfig.getField(fId)>
	<#assign fDesc = getFieldDesc(CommonQueryConfig.getId(),fId)>
	<#assign fTip  = field.getAnyValue("tip")?default(fDesc)>
	<#assign status  = field.getAnyValue("status")?default("F")>
	<#assign edittype  = field.getAnyValue("edittype")?default("")>
	<#assign fColSpan = field.getAnyValue("colspan")?default("2")>
	<#assign defaultValue = field.getAnyValue("defaultvalue")?default("")>
	<#assign targetDataSet = CommonQueryConfig.getId() + "_dataset">
	<#assign compositeFlag = field.getAnyValue("compositeflag")?default("false")>
	<#assign compositeIndex  = field.getAnyValue("compositeindex")?default("")>
	<#--assign preLabel  = getFieldDesc(CommonQueryConfig.getId(),fId) -->
	<#assign preLabel  = field.getAnyValue("prelabel")?default(fDesc)>
	<#assign require  = field.getAnyValue("require")?default("false")>
	<#assign fieldId  = field.getAnyValue("id")?default("id")>
	<#if restCol?number == colNm?number >
		<tr id="${fieldId}_TR" fieldId="${fieldId}">
	</#if>
	<#if edittype!="hidden">
		<#if compositeFlag!="true">
			<#assign restCol = restCol?number - fColSpan?number>
			<#if !hasNext && (restCol?number>0) >
				<@GroupField labelwidth=labelwidth componentId=id fId=fId fColSpan=(restCol?number)?string />
			<#else>
				<@GroupField labelwidth=labelwidth componentId=id fId=fId />
			</#if>
		<#else>
			<#-- 兼容以前的定义组合域方式 -->
			<#if compositeIndex=="start">
				<td class="labeltd" valign="center" align="right" style="width: 20%"  nowrap>
				 <label>${preLabel}</label>
				 </td>
				 <td colspan=${fColSpan?number - 1} nowrap valign="center" fieldId="${fieldId}">
				 	<#--<@SingleField fId/>${fDesc}-->
				 	<@SingleField fId=fId componentId=id/>
				 	<#assign restCol = restCol?number - 1>
		    <#elseif compositeIndex=="end">
		            <#--<@SingleField fId/>${fDesc}-->
				 	<@SingleField fId=fId componentId=id/>
		    	 </td>
		    	     <#assign restCol = restCol?number - fColSpan?number +1>
		    <#else>
		    		<#--<@SingleField fId/>${fDesc}-->
				 	<@SingleField fId=fId componentId=id/>
			</#if>
		</#if>
	<#else>
		<@htmlEditType.hiddenelement id=fId value=defaultValue targetDataset=targetDataSet componentId=id required=require/>
   	</#if>
</#macro>


<#--建立Group栏-->
<#--
id                 页面视图ID(不允许为空)
label              group显示标题(不允许为空)
fieldStr           显示字段(不允许为空                  值格式为：field1_id,field2_id,...)
colNm              显示烈数(允许为空  默认为4          值格式为：2*n)
printabled         是否能够打印(允许为空，默认为false)
labelwidth         定义label宽度，如果写了，则label按填写像素来展示，如果没写，则按百分比展示，为20%
-->
<#--modified by wangpeng 20091117 BMS-2274 外边框可设置  begin-->
<#macro Group id label fieldStr colNm="4" showGroupLine="true" printabled="false" labelwidth="" hotkey="">
<#if showGroupLine=="true">
<div name='${id}' class="group"><h5><@bean.message key="${label}"/></h5>
</#if>

  <form id="${id}_Table" method="post" novalidate <#if hotkey=="true">hotkey</#if> >
		<table width="100%" class="grouptable" height="100%" style="table-layout: auto;">
		<#nested>
		 	<#assign fieldMap = CommonQueryConfig.fields>
 		 	<#assign field = "">
			<#assign fDesc = "",fVal = "",fStat = "">
			<#assign restCol = colNm>
		 	<#if fieldStr != "">
	 		 	<#assign fields = fieldStr?split(",")>
	 		<#else>
	 			<#assign fields = fieldMap.keySet()>
	 		</#if>
			<#list fields as fId>
				<#assign _foo1=fId?index_of("{") />
				<#if _foo1!=-1 >
					<#-- 新的组合域定义方式 -->
					<#assign _headlabel=fId?substring(0,_foo1) >
					<#assign _foo2=fId?last_index_of("}") >
					<#assign fColSpan=2 >
					<#if fId?ends_with("]")>
						<#assign fColSpan=(fId?substring(_foo2+2,fId?length-1))?number >
						<#if fColSpan gt colNm?number >
							<#assign fColSpan=colNm?number >
						</#if>
					</#if>
					<#if restCol?number lt fColSpan?number >
						<tr id="${_headlabel}_TR" fieldId="${_headlabel}">
						<#assign restCol=colNm?number >
					</#if>
                    <#if labelwidth=="">
                       <#assign lwidth="20%">
                       <#assign iwidth="style=\"width:20%\"">
                    <#else>
                       <#assign lwidth=labelwidth+"px">
                       <#assign iwidth=" ">
                    </#if>
					<#assign _mainpart=fId?substring(_foo1+1,_foo2) >
					<#assign _allfields=_mainpart?split("|") >
					<td class="labeltd" valign="center" align="right" style="width:${lwidth}"  nowrap>
						 <label>${_headlabel}</label>
					</td>
					<td colspan="${fColSpan?number - 1}" class="datatd" nowrap valign="center" ${iwidth} fieldId="${_headlabel}">
					<#list _allfields as foo >
						<#if foo?starts_with("'") && foo?ends_with("'") >
							<label>${foo?substring(1,foo?length-1)}</label>
						<#else>
							<#assign _bar=foo >
							<#assign _width="" >
							<#if foo?ends_with("]")>
								<#assign _index=foo?index_of("[") >
								<#assign _width=foo?substring(_index+1,foo?length-1) >
								<#assign _bar=foo?substring(0,_index) >
							</#if>

							<#assign field = CommonQueryConfig.getField(_bar) >
							<#assign edittype  = field.getAnyValue("edittype")?default("")>
							<#assign defaultValue = field.getAnyValue("defaultvalue")?default("")>
							<#assign targetDataSet = CommonQueryConfig.getId() + "_dataset">
							<#assign require  = field.getAnyValue("require")?default("false")>
							<#if edittype == "hidden">
								<@htmlEditType.hiddenelement id=_bar value=defaultValue targetDataset=targetDataSet componentId=id required=require/>
							<#else>
								<@SingleField fId=_bar componentId=id _width=_width />
							</#if>
						</#if>
					</#list>
					</td>
		    	    <#assign restCol = restCol?number - fColSpan?number >				
				<#else>
					<#if fId?ends_with("]")>
						<#assign _index = fId?index_of("[") >
						<#assign _width = fId?substring(_index+1,fId?length-1) >
						<#-- TODO width support -->
						<@SimpleGroupField id=id fId=fId?substring(0,_index) restCol=restCol colNm=colNm hasNext=fId_has_next labelwidth=labelwidth/>
					<#else>
    	 				<@SimpleGroupField id=id fId=fId restCol=restCol colNm=colNm hasNext=fId_has_next labelwidth=labelwidth/>
					</#if>
				</#if>
 				<#if restCol?number lte 0>
					<#assign restCol = colNm>
					</tr>
				</#if>
   			</#list>
		</tr>
		</table>
  </form>
<#if showGroupLine=="true">
</div>
</#if>
</#macro>
<#--modified by wangpeng 20091117 BMS-2274 外边框可设置 end-->


<#--建立GroupField栏-->
<#macro GroupField fId fColSpan="" componentId="" labelwidth="">
<#assign field = CommonQueryConfig.getField(fId)>
<#assign fEidtType = field.getAnyValue("edittype")?default('text')>
<#assign label =  getFieldDesc(CommonQueryConfig.getId(),fId)>
<#assign width = defaultStr(field.getAnyValue("width")?default('150'),'150')>
<#if fColSpan == "">
	<#assign colSpan = field.getAnyValue("colspan")?default('2')>
<#else>
	<#assign colSpan = fColSpan?string>
</#if>
<#assign vAlign = field.getAnyValue("valign")?default('center')>
<#assign height = field.getAnyValue("height")?default("")>
<#assign readonly = field.getAnyValue("readonly")?default("false")>
<#if readonly!="true">
	<#assign readonly="">
<#else>
    <#assign readonly="readonly">
</#if>
<#assign defaultValue = field.getAnyValue("defaultvalue")?default("")>
<#assign targetDataSet = CommonQueryConfig.getId() + "_dataset">
<#assign translated = field.getAnyValue("translated")?default('')>
<#assign required = field.getAnyValue("require")?default('false')>
<#if required!="true">
	<#assign required="">
<#else>
    <#assign required="required">
</#if>
<#assign viewField = field.getAnyValue("viewfield","")>
<#assign fieldMap = field.getAnyValue("fieldmap","")>
<#assign url = field.getAnyValue("url")?default('')>
<#assign datatype = field.getAnyValue("datatype")?default('string')>
<#assign scale = field.getAnyValue("scale")?default('')>
<#assign prefix = field.getAnyValue("prefix")?default('')>
<#assign rowSpan = defaultStr(field.getAnyValue("rowspan")?default(1),1)>
<#assign rowSpan = rowSpan?number>
<#assign valueField=field.getAnyValue("valueField")?default("")>
<#assign radioRowLen=field.getAnyValue("radiorowlen")?default("0")>
<#assign height=field.getAnyValue("height")?default("0")>
<#assign placeholder=field.getAnyValue("placeholder")?default("")>
<#assign startyear=field.getAnyValue("startyear")?default("2005")>
<#assign yearlength=field.getAnyValue("yearlength")?default("10")>
<#assign editable=field.getAnyValue("editable")?default("false")>
<#switch fEidtType>
  	<#case "text">
  			<#assign comparemode=field.getAnyValue("comparemode")?default("")>
  			<@htmlEditType.text id=fId componentId=componentId label=label  datatype=datatype targetDataset=targetDataSet defaultValue=defaultValue width=width colSpan=colSpan required=required
  			  labelwidth=labelwidth  readonly=readonly scale=scale  rowSpan=rowSpan vAlign=vAlign  prefix=prefix placeholder=placeholder comparemode=comparemode/>
    	<#break>
    <#case "datalabel">
  			<@htmlEditType.datalabel id=fId  componentId=componentId label=label targetDataset=targetDataSet defaultValue=defaultValue width=width colSpan=colSpan
  			 labelwidth=labelwidth  rowSpan=rowSpan vAlign=vAlign dataType=datatype/>
    	<#break>
    <#case "date">
    <#if datatype=="timestamp">
    	  <@htmlEditType.timestamp id=fId componentId=componentId label=label targetDataset=targetDataSet defaultValue=defaultValue width=width colSpan=colSpan required=required
  		   labelwidth=labelwidth readonly=readonly  rowSpan=rowSpan vAlign=vAlign placeholder=placeholder editable=editable/>
    <#else>
			<#assign comparemode=field.getAnyValue("comparemode")?default("")>
  			<@htmlEditType.date id=fId componentId=componentId label=label  targetDataset=targetDataSet defaultValue=defaultValue width=width colSpan=colSpan required=required
  			 labelwidth=labelwidth  readonly=readonly rowSpan=rowSpan vAlign=vAlign placeholder=placeholder comparemode=comparemode editable=editable/>
    </#if>
    	<#break>
<#case "predate">
			<#assign comparemode=field.getAnyValue("comparemode")?default("")>
  			<@htmlEditType.predate id=fId componentId=componentId label=label targetDataset=targetDataSet defaultValue=defaultValue width=width colSpan=colSpan required=required
  		   labelwidth=labelwidth readonly=readonly  rowSpan=rowSpan vAlign=vAlign placeholder=placeholder comparemode=comparemode editable=editable/>
    	<#break>
    <#case "postdate">
			<#assign comparemode=field.getAnyValue("comparemode")?default("")>
  			<@htmlEditType.postdate id=fId componentId=componentId label=label targetDataset=targetDataSet defaultValue=defaultValue width=width colSpan=colSpan required=required
  			  labelwidth=labelwidth   readonly=readonly  rowSpan=rowSpan vAlign=vAlign placeholder=placeholder comparemode=comparemode editable=editable/>
    	<#break>
    <#case "timestamp">
  			<@htmlEditType.timestamp id=fId componentId=componentId label=label targetDataset=targetDataSet defaultValue=defaultValue width=width colSpan=colSpan required=required
  			  labelwidth=labelwidth   readonly=readonly  rowSpan=rowSpan vAlign=vAlign placeholder=placeholder editable=editable/>
    	<#break>
    <#case "select">
		<#assign isCQ  = "false">
		<#list translated?split(":")  as key>
		     <#if key =="CQ">
				<#assign isCQ  = "true">
				<#break>
			</#if>
		</#list>
		<#if isCQ = "true">
			<#assign dropdowntype = defaultStr(field.getAnyValue("dropdowntype")?default("dynamic"),"dynamic")>
		<#else>
    		<#assign dropdowntype = defaultStr(field.getAnyValue("dropdowntype")?default("dataset"),"dataset")>
    	</#if>
    	<#assign init = defaultStr(field.getAnyValue("init")?default("true"),"true")>
    	<#assign multiple=field.getAnyValue("multiple")?default("false")>
    	<@htmlEditType.selectDataDic lable=label id=fId   targetDataset=targetDataSet componentId=componentId startyear=startyear  yearlength=yearlength multiple=multiple editable=editable
    	         labelwidth=labelwidth   width=width height=height require=required  readOnly=readonly defaultValue=defaultValue translated=translated viewField=viewField fieldMap=fieldMap ddtype=dropdowntype init=init url=url colSpan=colSpan placeholder=placeholder/>
    	<#break>
    <#case "textarea">
    	<@htmlEditType.textarea  id=fId label=label  labelwidth=labelwidth  componentId=componentId readonly=readonly required=required targetDataset=targetDataSet defaultValue=defaultValue width=width height=height colSpan=colSpan rowSpan=rowSpan vAlign=vAlign placeholder=placeholder/>
    	<#break>
    <#case "checkbox">
       <#if translated=="">
           	 <@htmlEditType.checkbox  label=label  labelwidth=labelwidth  componentId=componentId id=fId required=required targetDataset=targetDataSet defaultValue=defaultValue width=width colSpan=colSpan  rowSpan=rowSpan vAlign=vAlign/>
       <#else>
	     	 <@htmlEditType.checkboxs id=fId fId=fId label=label targetDataset=targetDataSet componentId=componentId
    	         labelwidth=labelwidth     width=width require=required  readOnly=readonly defaultValue=defaultValue translated=translated viewField=viewField valueField=valueField rowLen = radioRowLen colSpan = colSpan/>	   
	    </#if>
	    <#break>
    <#case "dyselect">
    	<@htmlEditType.selectDataDic lable=label id=fId   targetDataset=targetDataSet editable=editable
    	          labelwidth=labelwidth    width=width height=height require=required  readOnly=readonly defaultValue=defaultValue translated=translated viewField=viewField fieldMap=fieldMap  ddtype="dynamic" placeholder=placeholder/>
    	<#break>
    <#case "file">
    	<@htmlEditType.file  lable=label id=fId  targetDataset=targetDataSet defaultValue=defaultValue width=width colSpan=colSpan  rowSpan=rowSpan vAlign=vAlign/>
    	<#break>
      <#case "password">
    	<@htmlEditType.password label=label id=fId  componentId=componentId targetDataset=targetDataSet defaultValue=defaultValue width=width colSpan=colSpan  rowSpan=rowSpan vAlign=vAlign readonly=readonly required=required/>
    	<#break>
    <#--added by wangpeng 20091203 radio支持 begin-->
    <#case "radio">
	    <@htmlEditType.radioDataDic id=fId fId=fId label=label targetDataset=targetDataSet componentId=componentId
    	         labelwidth=labelwidth     width=width require=required  readOnly=readonly defaultValue=defaultValue translated=translated viewField=viewField valueField=valueField rowLen = radioRowLen colSpan = colSpan/>
	    <#break>
	<#--added by wangpeng 20091203 radio支持 end-->
    <#default>
  		<@htmlEditType.text id=fId componentId=componentId label=label  datatype=datatype targetDataset=targetDataSet defaultValue=defaultValue width=width colSpan=colSpan required=required
  			 labelwidth=labelwidth    readonly=readonly scale=scale  rowSpan=rowSpan vAlign=vAlign  prefix=prefix placeholder=placeholder/>
    <#break>
</#switch>
</#macro>


<#--建立GroupField栏,不包含td-->
<#macro SingleField fId componentId="" _width="" >
<#assign field = CommonQueryConfig.getField(fId)>
<#assign fEidtType = field.getAnyValue("edittype")?default('text')>
<#assign label =  getFieldDesc(CommonQueryConfig.getId(),fId)>
<#assign width = defaultStr(field.getAnyValue("width")?default('150'),'150')>
<#assign labelwidth="">
<#if (_width?trim)!="" && _width?trim?number gt 0 >
	<#assign width=_width?trim >
</#if>
<#assign colSpan = field.getAnyValue("colspan")?default('2')>
<#assign vAlign = field.getAnyValue("valign")?default('center')>
<#assign height = field.getAnyValue("height")?default("")>
<#assign readonly = field.getAnyValue("readonly")?default("false")>
<#assign startyear=field.getAnyValue("startyear")?default("2005")>
<#assign yearlength=field.getAnyValue("yearlength")?default("10")>
<#if readonly!="true">
	<#assign readonly="">
<#else>
    <#assign readonly="readonly">
</#if>
<#assign defaultValue = field.getAnyValue("defaultvalue")?default("")>
<#assign targetDataSet = CommonQueryConfig.getId() + "_dataset">
<#assign translated = field.getAnyValue("translated")?default('')>
<#assign require = field.getAnyValue("require")?default('false')>
<#if require!="true">
	<#assign required="">
<#else>
    <#assign required="required">
</#if>
<#assign viewField = field.getAnyValue("viewfield","")>
<#assign fieldMap = field.getAnyValue("fieldmap","")>
<#assign url = field.getAnyValue("url")?default('')>
<#--added by wangpeng 20091203 radio begin-->
<#assign valueField=field.getAnyValue("valueField")?default("")>
<#assign radioRowLen=field.getAnyValue("radiorowlen")?default("0")>
<#assign datatype = field.getAnyValue("datatype")?default('string')>
<#assign scale = field.getAnyValue("scale")?default('')>
<#assign prefix = field.getAnyValue("prefix")?default('')>
<#assign rowSpan = defaultStr(field.getAnyValue("rowspan")?default(1),1)>
<#assign placeholder=field.getAnyValue("placeholder")?default("")>
<#assign editable=field.getAnyValue("editable")?default("false")>
<#--added by wangpeng 20091203 radio end-->
<#switch fEidtType>
  	<#case "text">
  	        <#assign comparemode=field.getAnyValue("comparemode")?default("")>
  			<@htmlEditType.text id=fId componentId=componentId label=label  datatype=datatype targetDataset=targetDataSet defaultValue=defaultValue width=width colSpan=colSpan required=required
  			   readonly=readonly scale=scale  rowSpan=rowSpan vAlign=vAlign  prefix=prefix placeholder=placeholder comparemode=comparemode isSingle="true"/>
    	<#break>
   <#case "datalabel">
  			<@htmlEditType.datalabel id=fId componentId=componentId label=label targetDataset=targetDataSet defaultValue=defaultValue width=width colSpan=colSpan
  			 rowSpan=rowSpan vAlign=vAlign dataType=datatype isSingle="true"/>
        <#break>
   <#case "date">
   <#if datatype=="timestamp">
  			<@htmlEditType.timestamp id=fId componentId=componentId label=label targetDataset=targetDataSet defaultValue=defaultValue width=width colSpan=colSpan required=required
  			readonly=readonly  rowSpan=rowSpan vAlign=vAlign placeholder=placeholder editable=editable isSingle="true"/>
   <#else>
			<#assign comparemode=field.getAnyValue("comparemode")?default("")>
  			<@htmlEditType.date id=fId componentId=componentId label=label  targetDataset=targetDataSet defaultValue=defaultValue width=width colSpan=colSpan required=required
  			readonly=readonly rowSpan=rowSpan vAlign=vAlign placeholder=placeholder comparemode=comparemode editable=editable isSingle="true"/>
  </#if>
    	<#break>
   <#case "timestamp">
  			<@htmlEditType.timestamp id=fId componentId=componentId label=label targetDataset=targetDataSet defaultValue=defaultValue width=width colSpan=colSpan required=required
  			readonly=readonly  rowSpan=rowSpan vAlign=vAlign placeholder=placeholder editable=editable isSingle="true"/>
    	<#break>
   <#case "predate">
			<#assign comparemode=field.getAnyValue("comparemode")?default("")>
  			<@htmlEditType.predate id=fId componentId=componentId label=label targetDataset=targetDataSet defaultValue=defaultValue width=width colSpan=colSpan required=required
  			readonly=readonly  rowSpan=rowSpan vAlign=vAlign placeholder=placeholder comparemode=comparemode editable=editable isSingle="true"/>
    	<#break>
   <#case "postdate">
			<#assign comparemode=field.getAnyValue("comparemode")?default("")>
  			<@htmlEditType.postdate id=fId componentId=componentId label=label targetDataset=targetDataSet defaultValue=defaultValue width=width colSpan=colSpan required=required
  			readonly=readonly  rowSpan=rowSpan vAlign=vAlign placeholder=placeholder comparemode=comparemode editable=editable isSingle="true"/>
    	<#break>
   <#case "select">
		<#assign isCQ  = "false">
		<#list translated?split(":")  as key>
		     <#if key =="CQ">
				<#assign isCQ  = "true">
				<#break>
			</#if>
		</#list>
		<#if isCQ = "true">
			<#assign dropdowntype = defaultStr(field.getAnyValue("dropdowntype")?default("dynamic"),"dynamic")>
		<#else>
    		<#assign dropdowntype = defaultStr(field.getAnyValue("dropdowntype")?default("dataset"),"dataset")>
    	</#if>
    	<#assign init = defaultStr(field.getAnyValue("init")?default("true"),"true")>
    	<#assign multiple=field.getAnyValue("multiple")?default("false")>
    	<@htmlEditType.selectDataDic lable=label id=fId   targetDataset=targetDataSet componentId=componentId  startyear=startyear  yearlength=yearlength multiple=multiple editable=editable
    	            editable=editable width=width height=height require=required  readOnly=readonly defaultValue=defaultValue translated=translated viewField=viewField fieldMap=fieldMap ddtype=dropdowntype init=init url=url colSpan=colSpan placeholder=placeholder  isSingle="true"/>
    	<#break>
    <#case "checkbox">
        <#if translated=="">
           	 <@htmlEditType.checkbox  label=label  labelwidth=labelwidth  componentId=componentId id=fId required=required targetDataset=targetDataSet defaultValue=defaultValue width=width colSpan=colSpan  rowSpan=rowSpan vAlign=vAlign isSingle="true"/>
        <#else>
	     	 <@htmlEditType.checkboxs id=fId fId=fId label=label targetDataset=targetDataSet componentId=componentId isSingle="true"
    	         labelwidth=labelwidth     width=width require=required  readOnly=readonly defaultValue=defaultValue translated=translated viewField=viewField valueField=valueField rowLen = radioRowLen colSpan = colSpan/>	   
	    </#if>
	    <#break>   	
   <#case "textarea">
    	<@htmlEditType.textarea  id=fId label=label componentId=componentId readonly=readonly required=required targetDataset=targetDataSet defaultValue=defaultValue width=width height=height colSpan=colSpan rowSpan=rowSpan vAlign=vAlign placeholder=placeholder isSingle="true"/>
    	<#break>
   <#case "dyselect">
   <@htmlEditType.selectDataDic lable=label id=fId   targetDataset=targetDataSet editable=editable
    	            width=width height=height require=required  readOnly=readonly defaultValue=defaultValue translated=translated viewField=viewField fieldMap=fieldMap  ddtype="dynamic" isSingle="true"/>
    	<#break>
    <#case "radio">
	    <@htmlEditType.radioDataDic id=fId fId=fId label=label targetDataset=targetDataSet componentId=componentId isSingle="true"
    	      labelwidth=labelwidth      width=width require=required  readOnly=readonly defaultValue=defaultValue translated=translated viewField=viewField valueField=valueField rowLen = radioRowLen colSpan = colSpan/>
	    <#break>
	<#case "password">
    	<@htmlEditType.password label=label id=fId  componentId=componentId targetDataset=targetDataSet defaultValue=defaultValue width=width colSpan=colSpan rowSpan=rowSpan vAlign=vAlign readonly=readonly required=required isSingle="true"/>
    	<#break>
    <#default>
  			<@htmlEditType.text id=fId componentId=componentId label=label  datatype=datatype targetDataset=targetDataSet defaultValue=defaultValue width=width colSpan=colSpan required=required
  			   readonly=readonly scale=scale  rowSpan=rowSpan vAlign=vAlign  prefix=prefix placeholder=placeholder isSingle="true" />
    <#break>

</#switch>

</#macro>

<#macro SimpleButton id="" desc="" icon="" plain="false" onclick="">
<a id="${id}" extra="button" plain="${plain}" href="javascript:void(0)" iconCls="${icon}" <#if onclick != "">onclick="${onclick}"</#if> ><@bean.message key="${desc}"/></a>
<#if onclick == "">
<script type="text/javascript">_initButton("${id}");</script>
</#if>
</#macro>
<#--建立Button栏-->
<#macro Button id targetDataset=CommonQueryConfig.getId()+"_dataset"   plain="false">
<#assign button = CommonQueryConfig.getOperationsElement(id)>
<#assign desc = button.getAnyValue("desc")?default("")>
<#assign url = button.getAnyValue("url")?default("#")>
<#assign submitDataset = button.getAnyValue("submitdataset")?default("")>
<#assign updateClass = button.getAnyValue("updateclass")?default("")>
<#assign operation = button.getAnyValue("operation")?default("")>
<#assign icon = button.getAnyValue("icon")?default("")>
<#-- modfiy by shen_antonio 20080121 -->
<#assign targetFrame = button.getAnyValue("targetframe")?default("_self")>
<@htmlEditType.button id=id defaultOperation=operation desc=desc targetDataset=targetDataset url=url updateClass=updateClass submitDataset=submitDataset  targetFrame=targetFrame  icon=icon  plain=plain/>
</#macro>

<#macro ButtonGroup targetDataset=CommonQueryConfig.getId()+"_dataset">
<#assign operationsMap = CommonQueryConfig.operations>
<#assign operationsKeys = operationsMap.keySet()>
<#list operationsKeys as id>
	<#assign button = CommonQueryConfig.getOperationsElement(id)>
	<#assign desc = button.getAnyValue("desc")?default("")>
	<#assign url = button.getAnyValue("url")?default("#")>
	<#assign operation = button.getAnyValue("operation")?default("")>
	<#assign url = button.getAnyValue("url")?default("#")>
	<#assign updateClass = button.getAnyValue("updateclass")?default("")>
	<#assign submitDataset = button.getAnyValue("submitdataset")?default("")>
	<#-- modify by shen_antonio 20080121 -->
	<#assign targetFrame = button.getAnyValue("targetframe")?default("_self")>
	<@htmlEditType.button id=id defaultOperation=operation desc=desc targetDataset=targetDataset url=url updateClass=updateClass submitDataset=submitDataset targetFrame=targetFrame />
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
</#list>
</#macro>


<#function defaultStr sv desv>
  <#assign restr = sv?default(desv)>
  <#if restr?trim == "">
  	<#return desv>
  <#else>
  	<#return sv>
  </#if>
</#function>

<#function px value>
	<#if value=="" >
		<#return value>
	</#if>
	<#if value?ends_with("%")>
  		<#return "">
  	</#if>
	<#if value?ends_with("px")>
  		<#return value>
  	</#if>
  	<#return value+"px">
</#function>

<#function reqParamConver>
<#assign paramString = "">
<#assign paramIds = RequestParameters?keys>
<#assign paramVal = "">
<#list paramIds as paramId>
	<#assign paramVal = RequestParameters[paramId]>
	<#--
	<#assign paramVal = encodeStr(paramVal)>
	-->
	<#if paramString!="">
		<#assign paramString = paramString + ";" + paramId + "," + paramVal>
	<#else>
		<#assign paramString = paramId + "," + paramVal>
	</#if>
</#list>
<#return paramString>
</#function>

<#function configParamConver>
<#assign paramString = "">
<#assign paramIds = CommonQueryConfig.getParameters().keySet()>
<#assign paramVal = "">
<#list paramIds as paramId>
	<#assign paramVal = CommonQueryConfig.getParameter(paramId).getAnyValue("value","")>
	<#assign paramVal = encodeStr(paramVal)>
	<#if paramString!="">
		<#assign paramString = paramString + ";" + paramId + "," + paramVal>
	<#else>
		<#assign paramString = paramId + "," + paramVal>
	</#if>
</#list>
<#return paramString>
</#function>

<#function paramConver>
<#assign cParamString = configParamConver()>
<#assign rParamString = reqParamConver()>
<#assign paramString = "">
<#if rParamString != "">
	<#assign paramString = cParamString + ";" + rParamString>
<#else>
	<#assign paramString = cParamString>
</#if>
<#return paramString>
</#function>



<#--建立Interface栏-->
<#--
id    							 cqId (不允许为空）
label　							 Group标题( 允许为空，缺省为XML配置中title参数)
resultDateset　					 结果集Dataset 目标结果数据集(允许为空，缺省为该通用查询结果数据集)
fieldStr                         指定显示的字段,空则全部显示. 可组合,格式如:{textyear[40]|'年'|textmonth[20]|'月'|textday[20]|'日'}
moreFieldStr                     更多的查询字段,默认这些字段不显示
moreFieldBtnDesc                 更多查询条件这个按钮的名字
colNm 							 列数(2的倍数）(允许为空，缺省为4)
width　                              宽度 显示宽度(允许为空，缺省为"100%")
showButton                       显示查询按钮标志(可为空，缺省为"true")
defaultOperation                 默认提交类型 (可为空，缺省asyncqrysubmitflush)
btnNm                            按钮名称(可为空，确认为XML配置中btnNm参数，如果该参数为空，缺省为'查询')
btnInFrame						  按钮是否位于框内(缺省为"false")
-->
<#--modified by wangpeng 20091117 BMS-2274 外边框可设置是否显示  begin-->
<#macro Interface
	id
	label=CommonQueryConfig.getAnyValueDefault("title","")
	resultDataset=CommonQueryConfig.getId()+"_dataset"
	fieldStr=""
	moreFieldStr=""
	moreFieldBtnDesc="更多查询条件"
	colNm=4
	width="100%"
	showButton="true"
	defaultOperation="asyncqrysubmitflush"
	parameters=""
	btnNm=""
	showFrameLine="true"
	btnInFrame="false"
	labelwidth=""
	>
<@IntfaceDataset parameters/>
<#--
<div name="${CommonQueryConfig.getId()}_Interface_${id}_div">
-->
<#if showFrameLine=="true">
<div name='${id}' class="search"><h5><span style="float:left;"><@bean.message key="${label}"/></span><#if moreFieldStr!=""><a style="float:right" href="javascript:void(0);" datasetName="${CommonQueryConfig.getId()}_interface_dataset" onclick="showMoreQueryCondition('${CommonQueryConfig.getId()}_interface_dataset_more')"><@bean.message key="${moreFieldBtnDesc}"/> </a></#if></h5>
</#if>
<#assign buttonName=btnNm>
<#nested>
		<#-- modify by shen_antonio 20080403 -->
		<#if btnNm=="">
			<#assign buttonName = CommonQueryConfig.getAnyValueDefault("btnNm","btQuery")>
		</#if>
		<#-- -->
		<@MoreInterface fieldStr=moreFieldStr width=width colNm=colNm/>
		<table extra="interface"  componentId="${id}" width="${width}" class="grouptable" height="100%" dataset="${CommonQueryConfig.getId()}_interface_dataset" style="table-layout:auto">
			<#assign showIndex = 0>
			<#assign elDesc = "",elVal = "",elStat = "">
			<#assign restCol = colNm>
			<#assign targetDataSet = CommonQueryConfig.getId() + "_interface_dataset">
			<#if fieldStr=="">
			<#assign elementList = CommonQueryConfig.elementList>
			<#assign elementListLength = CommonQueryConfig.elementList.size()>
			<#list elementList as element>
				<#assign elId = element.getAnyValue("id")>
		   	 	<#assign edittype  = element.type?default("")>
		    	<#assign elColSpan = element.getAnyValue("colspan")?default("2")>
		    	<#assign defaultValue = element.getAnyValue("default")?default("")>
		    	<#assign value = element.getAnyValue("value")?default("")>
		       	<#if restCol?number == colNm?number >
		       		<tr>
			 	</#if>
					<#if edittype!="Hidden">
						<#assign showIndex=showIndex + 1>
			       		<#assign restCol = restCol?number - elColSpan?number>
			       		<#if !element_has_next && (restCol?number>0) && showButton!="true" >
			       				<@InterfaceElement elId=elId componentId=id eColSpan=(restCol?number + elColSpan?number)?string labelwidth=labelwidth/>
       					<#else>
			       				<@InterfaceElement elId=elId componentId=id labelwidth=labelwidth/>
       					</#if>
					<#else>

			       	</#if>

		       		<#if restCol?number <= 0>
			 			<#assign restCol = colNm>
			 			<#if element_has_next && element_index+1 != elementListLength>
		       				</tr>
		       			</#if>
		       		</#if>
       		</#list>
       		<#else>
       		<#assign elementList = fieldStr?split(",")>
			<#assign elementListLength = elementList?size>
       		<#list elementList as elId>
				<#if restCol?number == colNm?number >
		       		<tr>
			 	</#if>
       			<#assign _foo1=elId?index_of("{") />
				<#if _foo1!=-1 >
					<#assign showIndex=showIndex + 1>
					<#assign _headlabel=elId?substring(0,_foo1) >
					<#assign _foo2=elId?last_index_of("}") >
					<#assign fColSpan=2 >
					<#if elId?ends_with("]")>
						<#assign fColSpan=(elId?substring(_foo2+2,elId?length-1))?number >
						<#if fColSpan gt colNm?number >
							<#assign fColSpan=colNm?number >
						</#if>
					</#if>
					<#assign restCol = restCol?number - fColSpan?number>
					<#if restCol lt 0>
						</tr><tr>
					</#if>
					<#assign _mainpart=elId?substring(_foo1+1,_foo2) >
					<#assign _allfields=_mainpart?split("|") >
					<td class="labeltd" valign="center" align="right" style="width: 20%"  nowrap>
						 <label>${_headlabel}</label>
					</td>
					<#if !elId_has_next && (restCol?number>0) >
					<td colspan="${fColSpan?number - 1 + restCol}" class="datatd" nowrap valign="center" fieldId="${_headlabel}">
					<#else>
					<td colspan="${fColSpan?number - 1}" class="datatd" nowrap valign="center" fieldId="${_headlabel}">
					</#if>
					<#list _allfields as foo >
						<#if foo?starts_with("'") && foo?ends_with("'") >
							<label>${foo?substring(1,foo?length-1)}</label>
						<#else>
							<#assign _bar=foo >
							<#assign _width="" >
							<#if foo?ends_with("]")>
								<#assign _index=foo?index_of("[") >
								<#assign _width=foo?substring(_index+1,foo?length-1) >
								<#assign _bar=foo?substring(0,_index) >
							</#if>

							<#assign ele = CommonQueryConfig.getWhereElement(_bar) >
		   	 				<#assign edittype = ele.getAnyValue("edittype")?default("")>
							<#if edittype == "Hidden">
							<#else>
								<@InterfaceElement elId=_bar componentId=id isSingle="true" labelwidth=labelwidth/>
							</#if>
						</#if>
					</#list>
					</td>
				<#else>
					<#assign element = CommonQueryConfig.getWhereElement(elId) >
			   	 	<#assign edittype  = element.type?default("")>
			    	<#assign elColSpan = element.getAnyValue("colspan")?default("2")>
			    	<#assign defaultValue = element.getAnyValue("default")?default("")>
			    	<#assign value = element.getAnyValue("value")?default("")>
					<#if edittype!="Hidden">
						<#assign showIndex=showIndex + 1>
			       		<#assign restCol = restCol?number - elColSpan?number>
			       		<#if !elId_has_next && (restCol?number>0) && showButton!="true">
			       				<@InterfaceElement elId=elId componentId=id eColSpan=(restCol?number + elColSpan?number)?string labelwidth=labelwidth/>
	   					<#else>
			       				<@InterfaceElement elId=elId componentId=id labelwidth=labelwidth />
	   					</#if>
					<#else>
	
			       	</#if>
	       		</#if>
       			<#if restCol?number lte 0>
		 			<#assign restCol = colNm>
	       			</tr>
	       		</#if>
       		</#list>
       		</#if>
	       		<#if (showIndex <=1 || btnInFrame == "true") && showButton == "true" >
				 		<td align="left" colspan="2" class="button-qry-td" style="padding-left:6px;">
						 <@InterfaceButton defaultOperation=defaultOperation desc=buttonName resultDataset=resultDataset parameters=parameters/>
						 </td>
						 </tr>
				<#else>
					</tr>
				</#if>
		</table>
<#if showFrameLine=="true">
<div class="searchBotton" ></div>
</div>
</#if>
<#if  1 < showIndex && showButton == "true" && btnInFrame == "false">
			<table width="${width}" height="100%" >
			<tr><td class="button-qry-td" align="center" >
			<@InterfaceButton defaultOperation=defaultOperation desc=buttonName resultDataset=resultDataset parameters=parameters/>
			</td>
			</tr>
			</table>
</#if>
		<#--
</div>
-->
</#macro>
<#--modified by wangpeng 20091117 BMS-2274 外边框可设置是否显示  end-->

<#-- 更多的查询条件 -->
<#macro MoreInterface
	id=CommonQueryConfig.getId() +"_interface_dataset_more"
	fieldStr=""
	colNm=4
	label="更多查询条件"
	width="100%"
	>
	<div id="${id}" noextra="true" style="display:none">
	<#if fieldStr != "" && fieldStr != "#">
		<@Interface id="" fieldStr=fieldStr showButton="false" showFrameLine="false" colNm=colNm width=width/>
	<#else>
		<#nested>
	</#if>
	</div>
</#macro>
<#macro InterfaceButton desc icon="icon-search" defaultOperation="asyncqrysubmitflush" resultDataset=CommonQueryConfig.getId()+"_dataset" parameters="">
<@htmlEditType.button
	id=CommonQueryConfig.getId()+"_interface_dataset_btnSubmit"
	defaultOperation=defaultOperation desc=desc
	targetDataset=CommonQueryConfig.getId()+"_interface_dataset"
	url=CommonQueryConfig.getResultViewURL()  icon=icon
	updateClass="#"  resultDataset=resultDataset/>
</#macro>

<#macro ToolBar id >
<@IntfaceDataset parameters/>
<div id="ToolBar_${id}">
	<#nested>
</div>
</#macro>

<#--建立Intface DataSet模板-->
<#macro IntfaceDataset parameters="">
<#assign specStr="nextPage|everyPage|pageNm|currentPage|fieldString|recordString|recordOrigString">
<#--init request param -->
<#assign paramString = paramConver()>
<script type="text/javascript">
	<#--
	_initDataset(dataset,cqId,pageSize,databusId,masterDataset,references,submitData,insertOnEmpty,sessionKey,paramString,init,type)
		-->
	var _ds = getDatasetByID("${CommonQueryConfig.getId()}_interface_dataset");
	var ${CommonQueryConfig.getId()}_interface_dataset=_ds||createDataset("${CommonQueryConfig.getId()}_interface_dataset","","");
	if(!_ds) {
	_initDataset(${CommonQueryConfig.getId()}_interface_dataset,"${CommonQueryConfig.getId()}",${CommonQueryConfig.getAnyValue("pagesize")?default("10")},""
	,"","","allchange",false,"dd","${paramString}","","interface");
	<#--
	${CommonQueryConfig.getId()}_interface_dataset.flushData=dataset_flushData_new;
	var _t1=${CommonQueryConfig.getId()}_interface_dataset,_f;
	_t1.readOnly=false;
	_t1.pageSize=${CommonQueryConfig.getAnyValue("pagesize")?default("10")};
	_t1.databusId="${CommonQueryConfig.getAnyValue("databusid")?default("")}";
	_t1.pageIndex=1;
	_t1.pageCount=1;
	_t1.masterDataset="";
	_t1.references="";
	_t1.submitData="allchange";
	_t1.autoLoadPage=false;
	_t1.autoLoadDetail=true;
	_t1.downloadUrl=getDecodeStr("~2fextraservice~2fdownloaddata");
	_t1.insertOnEmpty=false;
	_t1.tag="";
	_t1.type="interface";
	_t1.sessionKey="dd";
	_t1.initDocumentFlag = false;
	converStr2DataSetParameter("${paramString}",_t1);
	_t1.setParameter("CQId","${CommonQueryConfig.getId()}","string");
	_t1.setParameter("nextPage",_t1.pageIndex);
	_t1.setParameter("everyPage",_t1.pageSize);
	_t1.setParameter("_session_key",_t1.sessionKey);
	_t1.setParameter("databusId",_t1.databusId);
	_t1.setParameter("_cds_","0");
	-->
	var _t1=${CommonQueryConfig.getId()}_interface_dataset,_f;
		<#assign parameters = "${parameters}">
		<#if parameters!="">
			<#list parameters?split(";")  as key>
				 <#assign index =key?index_of("=")>
				 <#assign paraName =key?substring(0,index)>
				 <#assign paraValue =key?substring(index+1)>
			 	 _t1.setParameter("${paraName}","${paraValue}");
			</#list>
		</#if>

	<#assign elements = CommonQueryConfig.elementList>
 			<#assign columnInx = 0>
 			<#list elements as element>
 				<#assign elId = element.getAnyValue("id")>
    			<#assign elDesc = getElementDesc(CommonQueryConfig.getId(),elId)>
    			<#assign elType = element.getAnyValue("datatype","string")>
    			<#assign elEidtType = element.type?default("text")>
    			<#if elEidtType=="checkbox">
					<#assign elType = "boolean">
				</#if>
      			<#assign elSize = defaultStr(element.getAnyValue("size")?default(''),"")>
      			<#assign readonly = element.getAnyValue("readonly")?default('false')>
      			<#assign required = defaultStr(element.getAnyValue("require")?default("false"),"false")>
      			<#assign mask = element.getAnyValue("rules")?default("null")>
      			<#assign maskErrorMessage = element.getAnyValue("errmsg")?default("")>
      			<#assign scale = element.getAnyValue("scale")?default("")>
      			<#assign toolTip = element.getAnyValue("tip")?default(elDesc)>
      			<#assign translated = element.getAnyValue("translated")?default("")>
			    <#assign viewField = element.getAnyValue("viewfield","")>
			    <#--added by wangpeng 20091208 radio begin-->
			    <#assign dropdownType = element.getAnyValue("dropdowntype")?default("dataset")>
			    <#--added by wangpeng 20091208 radio end-->
      			<#if mask?length==0>
			      	<#assign mask="null">
			    </#if>
			    <#--modified by wangpeng 20091126 BMS-2274  添加predate和postdate的数据类型支持  begin-->
			    <#--added by wangpeng 20091126 BMS-2269 日期型固定10位  begin-->
			    <#if elType=="date" || elType=="predate" || elType=="postdate">
			        <#assign elSize="10">
			    </#if>
			    <#--added by wangpeng 20091126 BMS-2269 日期型固定10位 end-->
			    <#--modified by wangpeng 20091126 BMS-2274  添加predate和postdate的数据类型支持  end-->
      			<#-- shen_antonio -->
      			<#assign defaultValue = element.getAnyValue("default")?default("")>
		      	<#switch elEidtType>
				    <#case "Option">
				          <#--modified by wangpeng 20091208 radio begin-->
				          <#if dropdownType!="radio">
				    	  <#-- 如果是select 先加 带fId 的字段,循环结束后增加　 fId +　name　字段-->
				    	  <#--
				    	  _f=_t1.addField("${elId}","string"); _f.label="${elDesc}";
		      			  _f.size="${elSize}"; _f.scale="${scale}"; _f.readOnly="${readonly}";
		      			  _f.required=${required}; _f.nullable=true; _f.defaultValue=getDecodeStr("${defaultValue}");
		      			  _f.updatable=true; _f.valueProtected=false; _f.visible=true; _f.autoGenId=false;
		      			  _f.tableName=""; _f.fieldName="${elId}"; _f.tag="select"; _f.editorType=""; _f.dropDown="";
		      			  if(typeof(${mask})!="undefined" && "${mask}"!="null")_f.mask="/" + ${mask} + "/";
		      			 _f.maskErrorMessage="${maskErrorMessage}"; _f.toolTip="${toolTip}";
		      			  _f.lobDownloadURL=getDecodeStr(""); _f.lobPopupURL=getDecodeStr("");
		      			  -->
		      			    <#-- 判断是 该select 是 CQ方式，还是dataDic方式 ，如果是 CQ则要获得相应的 CQId 并且不能直接翻译，要到initdocument后翻译-->
			      				<#assign isCQ  = "false">
								<#assign CQid  = "">
								<#list translated?split(":")  as key>
								     <#if key =="CQ">
										<#assign isCQ  = "true">
										<#break>
									</#if>
								</#list>
								<#if isCQ ="true">
								    <#list translated?split(":")  as key>
										<#assign CQid  = key>
									</#list>
								</#if>
								 <#if isCQ ="true">
								 <#--
				      			   	 _f.tag="selectCQ";
				      			   	 _f.viewField="${viewField}";
				      			   	 _f.dropDown="${elId}_DropDown";
				      			   	 _f.dropDownDataset="${CQid}_DropDownDataset";
				      			   	 -->
				      	<#--dataset,isCQ,isSelect,fId,fType,viewField,CQid,mask,maskErrMsg,toolTip,fDesc,fSize,scale,required,readonly,currencyAlign,tag,dropDown,dropDownDataset,radio,RadioDataset-->
		      			  _initField(_t1,"${elId}","string","${viewField}","${mask}","${maskErrorMessage}","${toolTip}","${elDesc}",
		      			  "${elSize}","${scale}",${required},"${readonly}","","selectCQ","${elId}_DropDown","${CQid}_DropDownDataset","","");
				      			   <#else>
				      			   <#--
				      			   	 _f.tag="select";
				      			   	 _f.viewField="";
				      			   	  _f.dropDown="";
				      			   	  -->
				      	 _initField(_t1,"${elId}","string","","${mask}","${maskErrorMessage}","${toolTip}","${elDesc}",
		      			  "${elSize}","${scale}",${required},"${readonly}","","select","","","","");
				      			   </#if>
				      	    <#else>
				      	    <#--
						      	  _f=_t1.addField("${elId}","${elType}"); _f.label="${elDesc}";
				      			  _f.size="${elSize}"; _f.scale="${scale}"; _f.readOnly="${readonly}";
				      			  _f.required=${required}; _f.nullable=true; _f.defaultValue=getDecodeStr("${defaultValue}");
				      			  _f.updatable=true; _f.valueProtected=false; _f.visible=true; _f.autoGenId=false;
				      			  _f.tableName=""; _f.fieldName="${elId}"; _f.tag=""; _f.editorType=""; _f.dropDown="";
				      			  if(typeof(${mask})!="undefined" && "${mask}"!="null")_f.mask="/" + ${mask} + "/";
				      			  _f.maskErrorMessage="${maskErrorMessage}"; _f.toolTip="${toolTip}";
				      			  _f.lobDownloadURL=getDecodeStr(""); _f.lobPopupURL=getDecodeStr("");
				      			  -->
				      	_initField(_t1,"${elId}","${elType}","","${mask}","${maskErrorMessage}","${toolTip}","${elDesc}",
		      			  "${elSize}","${scale}",${required},"${readonly}","","","","","","");
				      	    </#if>
				      	    <#--modified by wangpeng 20091208 radio end-->
				    	<#break>
				    <#default>
				    <#--
				    	  _f=_t1.addField("${elId}","${elType}"); _f.label="${elDesc}";
		      			  _f.size="${elSize}"; _f.scale="${scale}"; _f.readOnly="${readonly}";
		      			  _f.required=${required}; _f.nullable=true; _f.defaultValue=getDecodeStr("${defaultValue}");
		      			  _f.updatable=true; _f.valueProtected=false; _f.visible=true; _f.autoGenId=false;
		      			  _f.tableName=""; _f.fieldName="${elId}"; _f.tag=""; _f.editorType=""; _f.dropDown="";
		      			  if(typeof(${mask})!="undefined" && "${mask}"!="null")_f.mask="/" + ${mask} + "/";
		      			  _f.maskErrorMessage="${maskErrorMessage}"; _f.toolTip="${toolTip}";
		      			  _f.lobDownloadURL=getDecodeStr(""); _f.lobPopupURL=getDecodeStr("");
		      			  -->
		      			_initField(_t1,"${elId}","${elType}","","${mask}","${maskErrorMessage}","${toolTip}","${elDesc}",
		      			  "${elSize}","${scale}",${required},"${readonly}","","","","","","");
				   	    <#break>
				</#switch>
	 		</#list>
<#--循环结束后增加 fId + name 字段 -->
	<#assign elements = CommonQueryConfig.elementList>
 			<#assign columnInx = 0>
	 		<#list elements as element>
	 				<#assign elEidtType = element.type?default("text")>
		 			<#--added by wangpeng 20091208 radio begin-->
				    <#assign dropdownType = element.getAnyValue("dropdowntype")?default("dataset")>
				    <#--added by wangpeng 20091208 radio end-->
	      			<#if elEidtType == "Option" && dropdownType!="radio">
	      					<#assign elId = element.getAnyValue("id")>
	      				    <#assign elDesc = getElementDesc(CommonQueryConfig.getId(),elId)>
			    			<#assign elType = element.getAnyValue("type","string")>
      			            <#assign elSize = defaultStr(element.getAnyValue("size")?default(''),"")>
			      			<#assign readonly = element.getAnyValue("readonly","false")>
			      			<#assign required = defaultStr(element.getAnyValue("require")?default("false"),"false")>
			      			<#assign mask = element.getAnyValue("rules","null")>
			      			<#assign maskErrorMessage = element.getAnyValue("errmsg")?default("")>
			      			<#assign scale = element.getAnyValue("scale")?default("")>
			      			<#assign toolTip = element.getAnyValue("tip")?default(elDesc)>
			      			<#if mask?length==0>
			      				<#assign mask="null">
			      			</#if>
			      			<#-- 判断是 该select 是 CQ方式，还是dataDic方式 ，如果是 CQ则要获得相应的 CQId-->
			      				<#assign isCQ  = "false">
								<#assign CQid  = "">
								<#list translated?split(":")  as key>
								     <#if key =="CQ">
										<#assign isCQ  = "true">
										<#break>
									</#if>
								</#list>
								<#if isCQ ="true">
								    <#list translated?split(":")  as key>
										<#assign CQid  = key>
									</#list>
								</#if>
								<#--
			       				  _f=_t1.addField("${elId}Name","string"); _f.label="${elDesc}";
				      			  _f.size="${elSize}"; _f.scale="${scale}"; _f.readOnly="${readonly}";
				      			  _f.required=${required}; _f.nullable=true; _f.defaultValue=getDecodeStr("");
				      			  _f.updatable=true; _f.valueProtected=false; _f.visible=true; _f.autoGenId=false;
				      			  _f.tableName=""; _f.fieldName="${elId}Name"; _f.tag="selectName"; _f.editorType=""; _f.dropDown="${elId}_DropDown";
				      			   -->
				      			   <#if isCQ ="true">
				      			   <#--
				      			   	 _f.dropDownDataset="${CQid}_DropDownDataset";
				      			   	 _f.viewField="${viewField}";
				      			   	 -->
				      	_initField(_t1,"${elId}Name","string","${viewField}","${mask}","${maskErrorMessage}","${toolTip}","${elDesc}",
		      			  "${elSize}","${scale}",${required},"${readonly}","","selectName","${elId}_DropDown","${CQid}_DropDownDataset","","");
				      			   <#else>
				      			   <#--
				      			   	  _f.dropDownDataset="${elId}_DropDownDataset";
				      			   	  _f.viewField="";
				      			   	  -->
				      	_initField(_t1,"${elId}Name","string","","${mask}","${maskErrorMessage}","${toolTip}","${elDesc}",
		      			  "${elSize}","${scale}",${required},"${readonly}","","selectName","${elId}_DropDown","${elId}_DropDownDataset","","");
				      			   </#if>
				      			   <#--
								  if(typeof(${mask})!="undefined" && "${mask}"!="null")_f.mask="/" + ${mask} + "/";
				      			  _f.maskErrorMessage="${maskErrorMessage}"; _f.toolTip="${toolTip}";
				      			  _f.lobDownloadURL=getDecodeStr(""); _f.lobPopupURL=getDecodeStr("");
				      			  -->
			 		<#elseif elEidtType == "Option" && dropdownType == "radio">
		      					<#assign elId = element.getAnyValue("id")>
		      				    <#assign elDesc = getElementDesc(CommonQueryConfig.getId(),elId)>
				    			<#assign elType = element.getAnyValue("type","string")>
				      		    <#assign elSize = defaultStr(element.getAnyValue("size")?default(''),"")>
				      			<#assign readonly = element.getAnyValue("readonly","false")>
				      			<#assign required = defaultStr(element.getAnyValue("require")?default("false"),"false")>
				      			<#assign mask = element.getAnyValue("rules","null")>
				      			<#assign maskErrorMessage = element.getAnyValue("errmsg")?default("")>
				      			<#assign scale = element.getAnyValue("scale")?default("")>
				      			<#assign toolTip = element.getAnyValue("tip")?default(elDesc)>
				      			<#if mask?length==0>
				      				<#assign mask="null">
				      			</#if>
				      			<#assign viewField = element.getAnyValue("viewfield","")>
				      			<#--
		       				  _f=_t1.addField("${elId}Name","string"); _f.label="${elDesc}";
			      			  _f.size="${elSize}"; _f.scale="${scale}"; _f.readOnly="${readonly}";
			      			  _f.required=${required}; _f.nullable=true; _f.defaultValue=getDecodeStr("");
			      			  _f.updatable=true; _f.valueProtected=false; _f.visible=true; _f.autoGenId=false;
			      			  _f.tableName=""; _f.fieldName="${elId}Name"; _f.tag="radioName"; _f.editorType=""; _f.radio="${elId}_interface_Radio";
			      			  _f.RadioDataset="${elId}_interface_RadioDataset";
			      			  -->
			      		_initField(_t1,"${elId}Name","string","","${mask}","${maskErrorMessage}","${toolTip}","${elDesc}",
		      			  "${elSize}","${scale}",${required},"${readonly}","","radioName","","","${elId}_interface_Radio","${elId}_interface_RadioDataset");
			 		</#if>
		 		</#list>
	initDataset(_t1);
	<#-- shen_antonio -->
	initDefaultDataset(_t1);
	}
//-->
</script>
</#macro>

<#--建立GroupField栏-->
<#macro InterfaceElement elId eColSpan="" componentId="" isSingle="false" labelwidth="">
<#assign element = CommonQueryConfig.getWhereElement(elId) >
<#assign elEidtType = element.type?default('text')>
<#assign label = getElementDesc(CommonQueryConfig.getId(),elId)>
<#assign width = defaultStr(element.getAnyValue("width")?default('150'),"150")>
<#if eColSpan == "">
	<#assign colSpan = element.getAnyValue("colspan")?default('2')>
<#else>
	<#assign colSpan = eColSpan>
</#if>
<#assign vAlign = element.getAnyValue("valign")?default('center')>
<#assign height = element.getAnyValue("height")?default("")>
<#assign readonly = element.getAnyValue("readonly")?default("false")>
<#if readonly!="true">
	<#assign readonly="">
<#else>
    <#assign readonly="readonly">
</#if>
<#assign defaultValue = element.getAnyValue("defaultvalue")?default("")>
<#assign targetDataSet = CommonQueryConfig.getId() + "_interface_dataset">
<#assign translated = element.getAnyValue("translated")?default('')>
<#assign required = element.getAnyValue("require")?default('false')>
<#if required!="true">
	<#assign required="">
<#else>
    <#assign required="required">
</#if>
<#assign viewField = element.getAnyValue("viewfield")?default('')>
<#assign fieldMap = element.getAnyValue("fieldmap")?default('')>
<#assign datatype=element.getAnyValue("datatype")?default('string')>
<#assign scale=element.getAnyValue("scale")?default('')>
<#assign url = element.getAnyValue("url")?default('')>
<#assign placeholder = element.getAnyValue("placeholder")?default('')>
<#-- modify by shen_antonio 20080122 -->
<#assign rowSpan = defaultStr(element.getAnyValue("rowspan")?default(1),1)>
<#assign rowSpan = rowSpan?number>
<#-- -->
<#--added by wangpeng 20091203 radio begin-->
<#assign valueField=element.getAnyValue("valuefield")?default("")>
<#assign radioRowLen=element.getAnyValue("radiorowlen")?default("0")>
<#--added by wangpeng 20091203 radio end-->
<#switch elEidtType>
  	<#case "TextBox">
  			<#assign comparemode=element.getAnyValue("comparemode")?default("")>
  			<@htmlEditType.text id=elId componentId=componentId label=label  datatype=datatype targetDataset=targetDataSet defaultValue=defaultValue width=width colSpan=colSpan required=required
  			  labelwidth=labelwidth  readonly=readonly scale=scale  rowSpan=rowSpan vAlign=vAlign  prefix=prefix placeholder=placeholder comparemode=comparemode isSingle=isSingle />
    	<#break>
    <#case "DateTextBox">
  		<#if datatype=="timestamp">
    	   	<@htmlEditType.timestamp id=elId componentId=componentId label=label targetDataset=targetDataSet defaultValue=defaultValue width=width colSpan=colSpan required=required
  			 	labelwidth=labelwidth readonly=readonly  rowSpan=rowSpan vAlign=vAlign placeholder=placeholder editable=editable isSingle=isSingle/>
	    <#else>
				<#assign comparemode=element.getAnyValue("comparemode")?default("")>
	  			<@htmlEditType.date id=elId componentId=componentId label=label  targetDataset=targetDataSet defaultValue=defaultValue width=width colSpan=colSpan required=required
	  			 labelwidth=labelwidth  readonly=readonly rowSpan=rowSpan vAlign=vAlign placeholder=placeholder comparemode=comparemode editable=editable isSingle=isSingle/>
	    </#if>
    	<#break>
    <#case "Option">
		<#assign isCQ  = "false">
		<#list translated?split(":")  as key>
		     <#if key =="CQ">
				<#assign isCQ  = "true">
				<#break>
			</#if>
		</#list>
		<#if isCQ = "true">
			<#assign dropdowntype = defaultStr(element.getAnyValue("dropdowntype")?default("dynamic"),"dynamic")>
		<#else>
    		<#assign dropdowntype = defaultStr(element.getAnyValue("dropdowntype")?default("dataset"),"dataset")>
    	</#if>
    	<#assign init = defaultStr(element.getAnyValue("init")?default("true"),"true")>
    	<#if dropdowntype=="radio">
	    	<@htmlEditType.radioDataDic id=elId+"_interface" fId=elId label=label targetDataset=targetDataSet componentId=componentId
    	        labelwidth=labelwidth   width=width require=required  readOnly=readonly defaultValue=defaultValue translated=translated viewField=viewField valueField=valueField rowLen = radioRowLen colSpan = colSpan isSingle=isSingle/>
    	<#elseif dropdowntype=="checkbox">
	       <#if translated=="">
	           	 <@htmlEditType.checkbox  label=label  labelwidth=labelwidth  componentId=componentId id=elId required=required targetDataset=targetDataSet defaultValue=defaultValue width=width colSpan=colSpan  rowSpan=rowSpan vAlign=vAlign/>
	       <#else>
		     	 <@htmlEditType.checkboxs id=elId fId=elId label=label targetDataset=targetDataSet componentId=componentId
	    	         labelwidth=labelwidth     width=width require=required  readOnly=readonly defaultValue=defaultValue translated=translated viewField="" valueField="" rowLen = radioRowLen colSpan = colSpan />	   
		    </#if>
    	<#else>
			<#assign editable=element.getAnyValue("editable")?default("false")>
	    	<#assign init = defaultStr(element.getAnyValue("init")?default("true"),"true")>
	    	<#assign multiple=element.getAnyValue("multiple")?default("false")>
	    	<@htmlEditType.selectDataDic lable=label id=elId   targetDataset=targetDataSet componentId=componentId startyear=startyear  yearlength=yearlength multiple=multiple editable=editable
    	        labelwidth=labelwidth   width=width height=height require=required  readOnly=readonly defaultValue=defaultValue translated=translated viewField=viewField fieldMap=fieldMap ddtype=dropdowntype init=init url=url colSpan=colSpan placeholder=placeholder isSingle=isSingle/>
        </#if>
    	<#break>
    <#case "textarea">
    	<@htmlEditType.textarea labelwidth=labelwidth id=fId label=label componentId=componentId readonly=readonly required=required targetDataset=targetDataSet defaultValue=defaultValue width=width height=height colSpan=colSpan rowSpan=rowSpan vAlign=vAlign placeholder=placeholder isSingle=isSingle/>
    	<#break>
    <#case "checkbox">
    	<#assign preLable = element.getAnyValue("prelable")?default("")>
    	<@htmlEditType.checkbox labelwidth=labelwidth preLable=preLable componentId=componentId label=label id=elId required=required targetDataset=targetDataSet defaultValue=defaultValue width=width colSpan=colSpan  rowSpan=rowSpan vAlign=vAlign isSingle=isSingle/>
    	<#break>
    <#case "DataLabel">
    	<@htmlEditType.datalabel id=elId  componentId=componentId label=label targetDataset=targetDataSet defaultValue=defaultValue width=width colSpan=colSpan
  			labelwidth=labelwidth  rowSpan=rowSpan vAlign=vAlign dataType=datatype isSingle=isSingle/>
    	<#break>
    <#-- -->
    <#default>
    	<@htmlEditType.hiddenelement  id=elId value=defaultValue targetDataset=targetDataSet required=required componentId=componentId/>
   		<#break>
</#switch>
</#macro>

<#--
Window建立
skin : window窗口皮肤,可为空,默认为standard
-->
<#macro WindowElement skin="standard">
<!--
<link rel="stylesheet" type="text/css" href="${contextPath}/templets/lib/themes/xwindows/skins/dhtmlxwindows_${skin}.css">
<link rel="stylesheet" type="text/css" href="${contextPath}/templets/lib/themes/xwindows/dhtmlxwindows.css">
<script type="text/javascript" src="${contextPath}/templets/lib/dhtmlxcommon.js"></script>
<script type="text/javascript" src="${contextPath}/templets/lib/dhtmlxwindows.js"></script>
<div id="__WinsDiv" style="display:none; width:100%; height:100%; overflow-y:auto;  overflow-x:auto; border-left:0 gray solid; border-right: 0 gray solid; border-bottom:0 gray solid">
</div>
<script type="text/javascript">
	var dhxWins = new dhtmlXWindows();
	dhxWins.enableAutoViewport(true);
	dhxWins.vp.style.border = "#909090 1px solid";
	_window_skin = "${skin}";
	dhxWins.setSkin(_window_skin);
</script>
-->
</#macro>

<#--
打印按钮
id    							 id (不允许为空,保持界面）
title                            文件标题
datasetId                        指定打印datasetId
fieldStr                         field 串，用逗号分隔
name                             按钮名
-->
<#macro printButton id title datasetId fieldStr name="Print">
<button extra="button" dataset="${datasetId}"  type="button" id="${id}" submitManager="" autoForm="dtResult" > ${name} </button>
<script type="text/javascript" src="${contextPath}/templets/lib/datasettoexcel.js"></script>
<script type="text/javascript">
	var element = document.getElementById("${id}");
	element.onclick=_printButton_onclick;
	element.componentDataset = "${datasetId}";
	element.url = "#";
	element.headTitle = "<@bean.message key="${title}"/>";
	element.updateclass = "";
	element.resultDataset = "";
	element.submitDataset = "";
	element.targetFrame = "_self";
	element.fieldStr = "${fieldStr}";
</script>
</#macro>

<#--added by wangpeng 20091117 BMS-2274 新增宏groupbox begin-->
<#--
lable                              groupbox标题
expand                             是否展开， true-展开；false-折叠；
-->
<#macro GroupBox id label="" expand="true">
<FIELDSET name='${id}' style="padding: 6px;" extra="groupbox" expand="${expand}">
	<LEGEND extra="groupboxtitle"><@bean.message key="${label}"/></LEGEND>
	     <div style="width:100%;">
        <div style="">
        <#nested>
        </div>
		</div>
</FIELDSET>
</#macro>
<#--added by wangpeng 20091117 BMS-2274 新增宏groupbox end-->

<#--modified by wangpeng 20091208 增加浮动式和排它属性支持 begin-->
<#--added by wangpeng 20091118 BMS-2274 新增宏子窗体   begin-->
<#--
label                              子窗体标题
defaultZoom                        默认缩放模式   normal-一般模式;min-最小化;max-最大化(暂未支持)
width                              zoom=normal、min情况下的宽度
height                             zoom=normal情况下的高度
minimize                           是否可最小化  true;false
maximize                           是否可最大化  true;false
resize                             是否可拖动边框调整大小 true;false(暂未支持)
float                              是否浮动 true;false(default);
exclusive                          是否排他 true;false(default);
position                           显示位置  current-当前位置;center-居中
show                               默认是否显示 true(default);false;
-->
<#macro SubWindow id width="" height="" label="" resize="false" defaultZoom="normal" minimize="true" maximize="false">
<#--
<div id="${id}" label="${label}" style="width: ${width};height:${height};"
	defaultWidth="${width}" defaultHeight="${height}"
	defaultZoom="${defaultZoom}" resize="${resize}" extra="subwindow">
<table extra="subwindow_inner_table" cellSpacing=0 cellPadding=0>
<tbody>
	<tr>
		<td extra="subwindowtitle" label="${label}" minimize="${minimize}"
			maximize="${maximize}" defaultZoom="${defaultZoom}">
		<table style="width:100%" cellSpacing=0 cellPadding=0>
		<tbody>
			<tr extra="subwindow_bar">
				<td
					style="width: 100%; WHITE-SPACE: nowrap;">${label}
				</td>
			</tr>
		</tbody>
		</table>
		</td>
	</tr>
	<tr style="height: 100%">
		<td>
		<div style="width: ${width};height:${height};overflow:auto;padding:6px;"><#nested></div>
		</td>
	</tr>
</tbody>
</table>
</div>
-->
<@FloatWindow id = id width = width height = height label= label resize = resize defaultZoom = defaultZoom minimize = minimize maximize = maximize>
<#nested>
</@FloatWindow>
</#macro>
<#--added by wangpeng 20091118 BMS-2274 新增宏子窗体   end-->
<#--modified by wangpeng 20091208 增加浮动式和排它属性支持 end-->

<#--modified by wangpeng 20091208 增加浮动式和排它属性支持 begin-->
<#--added by wangpeng 20091118 BMS-2274 新增宏子窗体   begin-->
<#--
label                              子窗体标题
defaultZoom                        默认缩放模式   normal-一般模式;min-最小化;max-最大化(暂未支持)
width                              zoom=normal、min情况下的宽度
height                             zoom=normal情况下的高度
minimize                           是否可最小化  true(default);false
maximize                           是否可最大化  true;false(default)
closure                            是否可关闭       true;false(default)
resize                             是否可拖动边框调整大小 true;false(暂未支持)
float                              是否浮动 true;false(default);
exclusive                          是否排他 true;false(default);
position                           显示位置  current-当前位置;center-居中
show                               默认是否显示 true(default);false;
drag                               是否可拖动 true;默认true
modal                              是否模态化,默认false
-->
<#macro FloatWindow id width="600" height="" label="" resize="false" defaultZoom="normal" minimize="false" maximize="false" closure="false" float="false" exclusive="false" position="center" show="true" collapsible="true" inline="false" drag="true" modal="false">
<#assign title = label >
<#assign twidth= px(width)>
<#assign theight= px(height)>
<#if label=="" >
	<#assign title = "&nbsp;">
</#if>
<div id="${id}" extra="floatwindow" title="${title}" style="width:${twidth};height:${theight}" shadow="true" resizable="${resize}" minimizable="${minimize}" maximizable="${maximize}" collapsible="${collapsible}" closable="${closure}" inline="${inline}" drag="${drag}" show="${show}" ismodal="${modal}" position="${position}">
	<#nested>
</div>
<script type="text/javascript">
	var subwindow_${id} = {};
</script>
</#macro>
<#--added by wangpeng 20091118 BMS-2274 新增宏子窗体   end-->
<#--modified by wangpeng 20091208 增加浮动式和排它属性支持 end-->

<#--modified by wangpeng 2009/11/04 BMS-2179 begin-->
<#--modified by wangpeng 2009/11/01 BMS-2171 begin-->
<#--added by wangpeng 2009/09/21 BMS-1990 begin-->
<#--
报表Applet
objectName                  对象名，允许为空，默认为PrintApplet
-->
<#macro reportApplet objectName="PrintApplet">
    <OBJECT classid="clsid:8AD9C840-044E-11D1-B3E9-00805F499D93" width="0px" height="0px" style="" id="${objectName}" name="${objectName}" codebase="http://java.sun.com/update/1.5.0/jinstall-1_5-windows-i586.cab#Version=1,5,0,0">
        <PARAM NAME = CODE VALUE  = "ReporterApplet.class" >
        <PARAM NAME = CODEBASE VALUE  = "${contextPath}/applets/report" >
        <PARAM NAME = ARCHIVE VALUE  = "jasperreports-2.0.5-applet.jar,jasperreports-2.0.5.jar,itext-1.3.1.jar,iTextAsian.jar,iTextAsianCmaps.jar" >
        <PARAM NAME = "type" VALUE ="application/x-java-applet;version=1.2.2">
        <PARAM NAME = "scriptable" VALUE ="true">
    </OBJECT>
</#macro>
<#--added by wangpeng 2009/09/21 BMS-1990 end-->
<#--modified by wangpeng 2009/11/01 BMS-2171 end-->
<#--modified by wangpeng 2009/11/04 BMS-2179 end-->


<#--added by zhaozhiguo -->
<#macro AccordionGroup id width="" height="" fit="true" selected="">
	<#assign _w = px(width)>
	<#assign _h = px(height)>
	<#assign _selected = selected/>
	<div id="AccordionGroup_${id}" extra="accordionGroup" fit="${fit}" style="width:${_w};height:${_h};text-align:left;">
		<#nested>
	</div>
</#macro>
<#macro Accordion id title selected="${_selected}" url="" width="" height="" iconClass="">
	<div id="Accordion_${id}" <#if id==selected>selected="true"</#if> iconCls="${iconClass}" title="${title}" style="overflow:auto;padding:10px;">
	<#if url == "">
		<#nested>
	<#else>
		<iframe scrolling="auto" frameborder="0" src="${url}" style="width:100%;height:100%;"></iframe>
	</#if>
	</div>
</#macro>

<#macro AccordionMenu id width="" height="" selected="" contextmenu="" aysc="false">
	<#if width == "" && height == "">
		<#assign fit = "true">
	<#else>
		<#assign fit = "false">
	</#if>
	<#assign _selected = selected />
	<div id="AccordionMenu_${id}" extra="accordionMenu" componentDataset="${CommonQueryConfig.getId()}_dataset" contextmenu="#Menu_${contextmenu}" aysc="${aysc}" fit="${fit}" style="width:${width}px;height:${height}px;text-align:left;" selectedId="${selected}" >
	</div>
	<script>
		var AccordionMenu_${id} = {};
	</script>
</#macro>

<#--
<#macro GroupButton id buttons json="" default="" tip="请选择" width="100px" plain="false">
	<#if json=="">
	<#assign bts = buttons?split(",")>

	<#if bts?size == 0>
	<#else>
	<div style="display:none">
		<#list bts as item>
			<#assign button = CommonQueryConfig.getOperationsElement(item)>
			<#assign desc = button.getAnyValue("desc")?default("")>
			<#assign url = button.getAnyValue("url")?default("#")>
			<#assign submitDataset = button.getAnyValue("submitdataset")?default("")>
			<#assign updateClass = button.getAnyValue("updateclass")?default("")>
			<#assign operation = button.getAnyValue("operation")?default("")>
			<#assign targetFrame = button.getAnyValue("targetframe")?default("_self")>
			<@htmlEditType.button id="Button_"+id+"_"+item defaultOperation=operation desc=desc targetDataset=CommonQueryConfig.getId()+"_dataset" url=url updateClass=updateClass submitDataset=submitDataset  targetFrame=targetFrame plain=plain/>
		</#list>
	</div>
	<span id="GroupButton_${id}">
	<#assign _f = false>
	<#list bts as item>
		<#assign button = CommonQueryConfig.getOperationsElement(item)>
		<#assign desc = button.getAnyValue("desc")?default("")>
		<#if default==item>
		<#assign _f = true>
		<a id="GroupButton_${id}_${item}" href="javascript:void(0)" class="easyui-splitbutton" plain="${plain}" menu="#_MM_${id}" ref="#Button_${id}_${item}" onclick="$(this.ref).click();"><@bean.message key="${desc}"/></a>
		<#else>
		<a style="display:none" id="GroupButton_${id}_${item}" href="javascript:void(0)" class="easyui-splitbutton" plain="${plain}" menu="#_MM_${id}" ref="#Button_${id}_${item}" onclick="$(this.ref).click();"><@bean.message key="${desc}"/></a>
		</#if>
	</#list>
	<#if _f==false>
	<a href="javascript:void(0)" class="easyui-splitbutton" plain="${plain}" menu="#_MM_${id}" >${tip}</a>
	</#if>
	</span>
	<div id="_MM_${id}" style="width:${width};">
		<#list bts as item>
		<#assign button = CommonQueryConfig.getOperationsElement(item)>
		<#assign desc = button.getAnyValue("desc")?default("")>
		<div id="Button_${id}_${item}_copy" ref="#GroupButton_${id}_${item}" onclick="GroupButton_${id}.show(this.ref);" title="<@bean.message key="${desc}"/>"><@bean.message key="${desc}"/></div>
		</#list>
	</div>
	</#if>
	<script>
	var GroupButton_${id} = {};
	GroupButton_${id}.show=function(group){
		$("#GroupButton_${id}").find('a:visible').hide();
		$(group).show().click();
	}
	</script>
	<#else>
		<@MenuItem id="_MM_"+id json=json />
	</#if>
</#macro>
-->
<#--
    mode  模式，可选static或空，其中static表示后台生成树html，提交效率
-->
<#macro DynamicTree id checkbox="false" contextmenu="" mode="">
<ul id="DynamicTree_${id}" extra="tree" componentDataset="${CommonQueryConfig.getId()}_dataset" checkbox="${checkbox}"
	contextmenu="#Menu_${contextmenu}" mode="${mode}"/>
<script>
	var DynamicTree_${id};
</script>
</#macro>
<#macro MenuItem id json="" width="150px" _data="" _level=1 >
<#if json!="">
<#assign data = json?eval/>
<#else>
<#assign data = _data/>
</#if>
<#if _level==1>
<div id="Menu_${id}" extra="menuitem" style="width:${width};">
<#else>
<div style="width:${width};">
</#if>
	<#list data as item>
	<#if item.seperator==true>
		<div class="menu-sep"></div>
	<#else>
		<div id="${item.id}" title="${item.text}" href="${item.href}" iconCls="${item.iconCls}" attributes="${item.attributes}">
		<#assign size = item.children?size >
		<#if size != 0>
		<span>${item.text}</span>
		<@MenuItem id=item.id _data=item.children _level=2/>
		<#else>
		${item.text}
		</#if>
		</div>
	</#if>
	</#list>
</div>
<#if _level==1>
	<script>
	<#--
		$('#Menu_${id}').menu({
			onClick:function(item){
				fireUserEvent("Menu_${id}_onClick", [item]);
			},
			onShow:function(item){
				fireUserEvent("Menu_${id}_onShow", [item]);
			},
			onHide:function(item){
				fireUserEvent("Menu_${id}_onHide", [item]);
			}
		});-->
	</script>
</#if>
</#macro>
<#--
	通用标签页
	id              通用查询CQID(不允许为空)
	currentTab      当前选中的tab栏ID(不允许为空)
	width           宽度 
	height          高度 
	tabsCtl         是否显示的控件参数,格式10101, 1表示显示,0表示不显示
	hasMenu         是否显示右键菜单
	border          是否显示边框
	fit             是否填满当前窗口
-->
<#macro CommonQueryTabSet id currentTab width="" height="" tabsCtl="" hasMenu="false" border="false" fit="true" tabsCtl="">
<#assign CommonQueryConfig = statics["com.huateng.commquery.config.CommonQueryUtil"].getCommonQueryBean(id)>
<#assign _tabsCtl = tabsCtl>
<#assign _show = true>
<#assign operationsMap = CommonQueryConfig.getOperations()>
<#assign operationsKeys = operationsMap.keySet()>
<@DynamicTabSet id=id width=width height=height hasMenu=hasMenu selected=currentTab border=border fit=fit >
	<#list operationsKeys as key>
		<#assign button = operationsMap.get(key)>
		<#assign desc = button.attributes["desc"]?default("")>
		<#assign tid = button.attributes["id"]?default("")>
		<#assign url  = button.attributes["url"]?default("")>
	
	 	<#-- 判断是否显示该 tab  -->
	 	<#if _tabsCtl!="" && (_tabsCtl?length >= (key_index+1)) >
			<#if _tabsCtl?substring(key_index,key_index+1)=="1">
				<#assign _show = true>
			<#else>
				<#assign _show = false>
			</#if>
	 	</#if>
	 	<#if _show>
			<@DynamicTab id=tid title=desc url=url />
		</#if>
	</#list>
	<#nested>
</@DynamicTabSet>
</#macro>
<#-- 
	动态标签页集
	id              唯一标识
	width           宽度 
	height          高度 
	hasMenu         是否显示右键菜单
	selected        当前选中的tab的ID
	border          是否显示边框
	fit             是否填满当前窗口
-->
<#macro DynamicTabSet id width="" height="" hasMenu="false" selected="" border="false" fit="true">
	<#assign _w = px(width)>
	<#assign _h = px(height)>
	
	<#assign selectedId = selected>
	<div id="${id}_tabset" extra="tabs" fit="${fit}" border="${border}" style="width:${_w};height:${_h};" hasMenu="${hasMenu}" selectedId="${selectedId}">
		<#nested>
	</div>
	<script>
	var ${id}_tabset = null;
	var ${id}_tabset_params = {};
	<#assign paramIds = RequestParameters?keys>
	<#assign paramVal = "">
	<#list paramIds as paramId>
		<#assign paramVal = RequestParameters[paramId]>
		${id}_tabset_params['${paramId}']='${paramVal}';
	</#list>
	//$(function(){
	/*
		if(!${id}_tabset) {
			${id}_tabset = new DynamicTabSet("${id}");
			<#assign paramIds = RequestParameters?keys>
			<#assign paramVal = "">
			<#list paramIds as paramId>
				<#assign paramVal = RequestParameters[paramId]>
				${id}_tabset.addParams({${paramId}:'${paramVal}'});
			</#list>
			${id}_tabset.setContextMenu(${hasMenu});
			${id}_tabset.select("${selectedId}");
		}
	*/
	//});
	</script>
</#macro>

<#-- 
	动态标签页
	id              唯一标识
	title           标题,不能为空
	url             页面URL 
	scroll          是否有滚动条
-->
<#macro DynamicTab id title tools="" url="" scroll="auto">
	<#if selectedId == "">
		<#assign selectedId = id>
	</#if>
	<#if url=="">
	<div id="${id}" title="${title}" border="true" tools="#${tools}" style="padding:5px;margin:0px">
		<#nested>
	<#else>
	<div id="${id}" title="${title}" border="true" tools="#${tools}" style="overflow:hidden;margin:0px">
		<div class="tabcontent-iframe" style="display:none" url="${url}">&nbsp;</div>
		<#--
		<#if url?index_of("http://")==0>
			<iframe scrolling="${scroll}" frameborder="0" url="${url}" style="width:100%;height:100%;padding:0px;margin:0px"></iframe>
		<#else>
			<iframe scrolling="${scroll}" frameborder="0" url="${contextPath}${url}" style="width:100%;height:100%;padding:0px;margin:0px"></iframe>
		</#if>
		-->
	</#if>
	</div>
</#macro>

<#macro LayoutPanel id width="" height="" inbody="true">
<#if inbody != "true">
<div id="${id}" extra="layout" style="width:${width}px;height:${height}px;" fit="true">
	<#nested>
</div>
<#else>
<#nested>
<script>
$('body').layout({
	fit:true
});
</script>
</#if>
</#macro>
<#macro LayoutCenter id="" title="" iconCls="" border="true" collapsed="false" url="">
	<@LayoutRegion id=id title=title region="center" border=border iconCls=iconCls collapsed=collapsed url=url>
		<#nested>
	</@LayoutRegion>
</#macro>
<#macro LayoutEast width id="" title="" width="" height="" border="true" split="false" iconCls="" collapsed="false" url="">
	<@LayoutRegion id=id title=title region="east" width=width height=height border=border split=split iconCls=iconCls collapsed=collapsed url=url>
		<#nested>
	</@LayoutRegion>
</#macro>
<#macro LayoutWest width id="" title="" height="" border="true" split="false" iconCls="" collapsed="false" url="">
	<@LayoutRegion id=id title=title region="west" width=width height=height border=border split=split iconCls=iconCls collapsed=collapsed url=url>
		<#nested>
	</@LayoutRegion>
</#macro>
<#macro LayoutSouth height id="" title="" width="" border="true" split="false" iconCls="" collapsed="false" url="">
	<@LayoutRegion id=id title=title region="south" width=width height=height border=border split=split iconCls=iconCls collapsed=collapsed url=url>
		<#nested>
	</@LayoutRegion>
</#macro>
<#macro LayoutNorth height id="" title="" width="" border="true" split="false" iconCls="" collapsed="false" url="">
	<@LayoutRegion id=id title=title region="north" width=width height=height border=border split=split iconCls=iconCls collapsed=collapsed url=url>
		<#nested>
	</@LayoutRegion>
</#macro>
<#macro LayoutRegion id="" title="" region="center" width="" height="" border="true" split="false" iconCls="" collapsed="false" url="">
	<#if url=="">
	<div id="LayoutRegion_${id}" title="${title}" region="${region}" iconCls="${iconCls}" split="${split}" border="${border}" collapsed="${collapsed}" style="width:${width}px;height:${height}px;">
		<#nested>
	<#else>
	<div id="LayoutRegion_${id}" title="${title}" region="${region}" iconCls="${iconCls}" split="${split}" border="${border}" collapsed="${collapsed}" style="width:${width}px;height:${height}px;padding:0px 0px 4px 0px;">
		<#if url?index_of("http://")==0>
			<iframe id="LayoutRegion_${id}_f" scrolling="auto" frameborder="0" src="${url}" style="width:100%;height:100%;padding:0px;margin:0px"></iframe>
		<#elseif url?index_of("/")==0>
			<iframe id="LayoutRegion_${id}_f" scrolling="auto" frameborder="0" src="${contextPath}${url}" style="width:100%;height:100%;;padding:0px;margin:0px"></iframe>
		<#else>
			<iframe id="LayoutRegion_${id}_f" scrolling="auto" frameborder="0" src="${contextPath}/${url}" style="width:100%;height:100%;;padding:0px;margin:0px"></iframe>
		</#if>
	</#if>
	</div>
</#macro>

<#macro PortalWin id cookied="true">
	<#assign colIndex = 0>
	<#assign panels = "[">
	<div region="center" style="overflow:hidden;">
	<div id="${id}" style="overflow-x:hidden;overflow-y:auto;">
	<#nested>
	</div>
	</div>
	<#assign panels = panels+"]">
	<script>
	$('body').layout({fit:true});
	$('#${id}').portal({
		fit:true,
		border:false,
		cookied:${cookied}
	});
	$('#${id}').portal('addPanels',${panels});
	</script>
</#macro>
<#macro PortalGroup width="100%">
	<#assign rowIndex = 0>
	<#if width?ends_with("%")>
		<#assign w = width>
	<#else>
		<#assign w = px(width)>
	</#if>
	<div style="width:${w};height:100%">
	<#nested>
	</div>
	<#assign colIndex = colIndex + 1>
</#macro>
<#macro Portal id title url height="100" collapsible="true" draggable="true" refresh="false" include="false" icon="">
	<#assign href="">
	<#if include=="true">
		<#assign href="href">
	<#else>
		<#assign href="url">
	</#if>
	<#if panels=="[">
	<#else>
		<#assign panels=panels+",">
	</#if>
	<#assign panels=panels+ "{id:'"+id+"',title:'"+title+"',columnIndex:"+colIndex+",rowIndex:"+rowIndex+",height:'"+height+"',collapsible:"+collapsible+",draggable:"+draggable+",refresh:"+refresh+",${href}:'"+url+"',iconCls:'"+icon+"'}">
	<#assign rowIndex = rowIndex + 1>
</#macro>
<#macro ContextMenu menuref>
<script>
	$(function(){
		$(document).bind('contextmenu',function(e){
			$('#Menu_${menuref}').menu('show', {
				left: e.pageX,
				top: e.pageY
			});
			return false;
		});
	});
</script>
</#macro>

<#--
组件引用宏
showLine        是否显示边框，默认为false
label               边框标题，默认为空
-->
<#macro Component id showLine="false" label="">
<#assign CommonQueryComponent = statics["com.huateng.commquery.config.CommonQueryUtil"].getCommonQueryComponent(id)>
<#if showLine=="true">
<div id="${id}_div" class="search"><h5><@bean.message key="${label}"/></h5>
</#if>
<#include CommonQueryComponent.getPath()>
<#nested>
<#if showLine=="true">
</div>
</#if>
</#macro>


