<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<#-- date with extra js
	lable 显示的lable
	id  为date 的id , 在targetDataset中将会自动生成该id对应的field
	targetDataset  主dataset的id
	defaultValue   默认值
	width      text框的宽度,一般默认不填
	require    是否必输的,必输为 "true"
	maxLength  可以输入的最多位数
	readOnly   是否是只读的, 只读为"true"
 -->
<#macro date id componentId label  targetDataset defaultValue  width labelwidth="" colSpan="2" rowSpan=1  vAlign="center" required="" readonly="" placeholder="" comparemode="" editable="false" isSingle="false">
    <#if labelwidth=="">
      <#assign lwidth="20%">
      <#assign iwidth="style=\"width:20%\"">
    <#else>
      <#assign lwidth=labelwidth+"px">
       <#assign iwidth=" ">
    </#if>
    <#if isSingle!="true">
    <td class="labeltd" id="${id}_TD" valign=${vAlign} align="right" style="width: ${lwidth}" nowrap>
		<label extra="fieldlabel" id="fldlabel_${id}" componentDataset="${targetDataset}" dataField="${id}"  label="${label}"></label>
	</td>
	<td class="datatd"  colspan="${colSpan?number - 1}" valign=${vAlign}  align="left"  ${iwidth} nowrap>
	</#if>	
		<span extra="requiredlabel" class="requiredlabel <#if required=="required">required</#if>" >&nbsp;</span><input extra="editor" id="select_${id}" componentDataset="${targetDataset}"  dataField="${id}"  componentId="${componentId}" editType="datebox" dateType="date" comparemode="${comparemode}" editable="${editable}" type="text"   ${required}  ${readonly} name="${id}"   style="width:${width}px;" placeholder="${placeholder}">
	<#if isSingle!="true">
	</td>
	</#if>
</#macro>

<#macro predate  id componentId label  targetDataset defaultValue  width labelwidth="" colSpan="2" rowSpan=1  vAlign="center" required="" readonly="" placeholder="" comparemode="" editable="false" isSingle="false">
    <#if labelwidth=="">
      <#assign lwidth="20%">
      <#assign iwidth="style=\"width:20%\"">
    <#else>
      <#assign lwidth=labelwidth+"px">
       <#assign iwidth=" ">
    </#if>
    <#if isSingle!="true">
		<td class="labeltd" valign=${vAlign} align="right" style="width:${lwidth}" nowrap>
			<label extra="fieldlabel" id="fldlabel_${id}" componentDataset="${targetDataset}" dataField="${id}"  label="${label}"></label>
		</td>
		<td class="datatd" colspan="${colSpan?number - 1}" valign=${vAlign}  align="left" ${iwidth} nowrap>
	</#if>	
			<span extra="requiredlabel" class="requiredlabel <#if required=="required">required</#if>" >&nbsp;</span><input extra="editor" id="select_${id}" componentDataset="${targetDataset}"  dataField="${id}"  componentId="${componentId}" editType="datebox" dateType="predate" comparemode="${comparemode}"  type="text"  editable="${editable}" ${required}  ${readonly} name="${id}"   style="width:${width}px;" placeholder="${placeholder}">
	<#if isSingle!="true">
		</td>
	</#if>
</#macro>

<#macro postdate  id  componentId label labelwidth  targetDataset defaultValue  width labelwidth="" colSpan="2" rowSpan=1  vAlign="center" required="" readonly="" placeholder="" comparemode="" editable="false" isSingle="false">
    <#if labelwidth=="">
      <#assign lwidth="20%">
      <#assign iwidth="style=\"width:20%\"">
    <#else>
      <#assign lwidth=labelwidth+"px">
       <#assign iwidth=" ">
    </#if>
    <#if isSingle!="true">
		<td class="labeltd"  valign=${vAlign} align="right" style="width:${lwidth}" nowrap>
			<label extra="fieldlabel" id="fldlabel_${id}" componentDataset="${targetDataset}" dataField="${id}"  label="${label}"></label>
		</td>
		<td class="datatd" colspan="${colSpan?number - 1}" valign=${vAlign}  align="left" ${iwidth}  nowrap>
	</#if>	
			<span extra="requiredlabel" class="requiredlabel <#if required=="required">required</#if>" >&nbsp;</span><input extra="editor" id="select_${id}" componentDataset="${targetDataset}" dataField="${id}" componentId="${componentId}"  editType="datebox" dateType="postdate" comparemode="${comparemode}"  type="text" editable="${editable}"  ${required}  ${readonly} name="${id}"   style="width:${width}px;" placeholder="${placeholder}">
    <#if isSingle!="true">
        </td>
    </#if>
</#macro>

<#macro timestamp  id  componentId label  targetDataset defaultValue  width  labelwidth=""  colSpan="2" rowSpan=1  vAlign="center" required="" readonly="" placeholder="" editable="false"  isSingle="false">
    <#if labelwidth=="">
      <#assign lwidth="20%">
      <#assign iwidth="style=\"width:20%\"">
    <#else>
      <#assign lwidth=labelwidth+"px">
       <#assign iwidth=" ">
    </#if>
    <#if isSingle!="true">
    <td class="labeltd" valign=${vAlign} align="right" style="width:${lwidth}" nowrap>
	   <label extra="fieldlabel"  id="fldlabel_${id}" componentDataset="${targetDataset}" dataField="${id}"  label="${label}"></label>
    </td>
    <td class="datatd" colspan="${colSpan?number - 1}"  valign=${vAlign} align="left" ${iwidth}  nowrap>
	</#if>
	   <span extra="requiredlabel" class="requiredlabel <#if required=="required">required</#if>" >&nbsp;</span><input extra="editor" id="select_${id}" componentDataset="${targetDataset}" dataField="${id}"  componentId="${componentId}" editType="datetimebox" dateType="timestamp"  type="text"  editable="${editable}" ${required}  ${readonly} name="${id}" style="width:${width}px;" placeholder="${placeholder}">
    <#if isSingle!="true">
    </td> 
    </#if>
</#macro>

<#macro time  id  componentId label  targetDataset defaultValue  width labelwidth=""  colSpan="2" rowSpan=1  vAlign="center" required="" readonly="">
  <td class="labeltd" valign=${vAlign} align="right"  nowrap>
	 <label extra="fieldlabel"  id="fldlabel_${id}" componentDataset="${targetDataset}" dataField="${id}"  label="${label}"></label>
  </td>
  <td class="datatd" colspan="${colSpan?number - 1}"  valign=${vAlign} align="left"  nowrap >
	<input extra="editor" id="select_${id}" componentDataset="${targetDataset}" dataField="${id}" componentId="${componentId}"  editType="text" dateType="validatebox"   type="text"   ${required}  ${readonly} name="${id}"   style="width:${width}px;">
  </td>
</#macro>

<#macro radioDataDic id fId label colSpan targetDataset width require readOnly defaultValue translated viewField valueField rowLen componentId isSingle="false" labelwidth="">
	<#assign type = "">
	<#assign value = "">
	<#assign transAry = translated?split(":")>
	<#if transAry[0]?exists && transAry[1]?exists>
		<#assign type = transAry[0]>
		<#assign value = transAry[1]>
	</#if>

	<#if type=="LIST">
		<#assign values = value>
		<#assign fMap=fId + "=" + "data">
    	<@radio id=id fId=fId label=label labelwidth=labelwidth colSpan=colSpan selsetValues=values fileMap=fMap targetDataset=targetDataset ddsfiles="data,dataName" defaultValue=defaultValue field="dataName" require=require readOnly=readOnly width=width rowLen = rowLen componentId=componentId isSingle=isSingle/>
    <#else>
        <#assign values = sysDicStr(translated)>
		<#assign fMap=fId + "=" + "data">
    	<@radio id=id fId=fId label=label labelwidth=labelwidth colSpan=colSpan selsetValues=values fileMap=fMap targetDataset=targetDataset ddsfiles="data,dataName" defaultValue=defaultValue field="dataName" require=require readOnly=readOnly width=width rowLen = rowLen componentId=componentId isSingle=isSingle/>
    </#if>
</#macro>

<#--
	id     			为radio 的id , 要求fileMap 中必须包含该id的值映射 , 这样在targetDataset中将会自动生成该id对应的field
	fId             主dataset的fId
	selsetValues    为radio 的所有选项
	targetDataset   主dataset的id
	defaultValue    下拉框的默认值
	fileMap  		值映射 ,格式如"contactmanidtype=datano;contactmanidtypename=dataname"  其中必须包含id的映射,主dataset的字段放=左边,select的值放=右边
	ddsfiles 		下拉选项对应的dataset的所有域
	field    		下拉选项对应的dataset中要显示出来的值
	width    		下拉框的宽度,一般默认不填,下拉框的宽度会被选项值自动撑开
	height   		下拉框的高度,可以指定该值,这样下拉框可以显示更多的下拉选项
	require  		该下拉选项是否必输 ,必输为 "true"
	readOnly 		是否是可读的
	rowLen          一行包含的选项数
 -->
<#macro radio id fId colSpan label  selsetValues  targetDataset defaultValue fileMap ddsfiles field width require readOnly rowLen componentId isSingle="false" labelwidth="">
   <#if labelwidth=="">
      <#assign lwidth="20%">
      <#assign iwidth="style=\"width:20%\"">
    <#else>
      <#assign lwidth=labelwidth+"px">
       <#assign iwidth=" ">
    </#if>
	<#assign fileMapString ="${fileMap}">
	<#assign fileMapString = fileMapString+";${fId}Name=${field}">
	<#if isSingle!="true">
	<td class="labeltd" valign=center align="right" style="width:${lwidth}" nowrap>
    	<label extra="fieldlabel" id="fldlabel_${id}" componentDataset="${targetDataset}" dataField="${id}"  label="${label}"></label>
    </td>
    <td class="datatd" valign=center colspan="${colSpan?number - 1}" align="left" ${iwidth}  nowrap>
    </#if>
        <span extra="requiredlabel" class="requiredlabel <#if require=="required">required</#if>" >&nbsp;</span><div extra="editor" id="editor_${id}" name="${fId}" componentDataset="${targetDataset}" editType="radio" dataField="${fId}" radio="${id}_Radio"  ${require} >
        </div>  
    <#if isSingle!="true">
	</td>	
    </#if>
	  <script language="javascript">
	     _initRadio("${id}_RadioDataset","${selsetValues}","${id}_Radio","${readOnly}","${label}","${ddsfiles}","${fileMapString}","${targetDataset}","${field}","${rowLen}");
	  	 var ${id}_RadioDataset = getDatasetByID("${id}_RadioDataset");
	  	 var ${id}_Radio = RadioRender.getRadioById("${id}_Radio");
	  </script>
</#macro>

<#--
-->
<#macro radioDataHidden id label targetDataset width require readOnly defaultValue translated viewField valueField rowLen>
	<#assign type = "">
	<#assign value = "">
	<#assign transAry = translated?split(":")>
	<#if transAry[0]?exists && transAry[1]?exists>
		<#assign type = transAry[0]>
		<#assign value = transAry[1]>
	</#if>

	<#if type=="LIST">
		<#assign values = value>
		<#assign fMap=id + "=" + "data">
    	<@radioHidden id=id label=label  selsetValues=values fileMap=fMap targetDataset=targetDataset defaultValue=defaultValue ddsfiles="data,dataName" field="dataName" require=require readOnly=readOnly width=width rowLen = rowLen/>
    <#else>
    	<#assign values = sysDicStr(translated)>
		<#assign fMap=id + "=" + "data">
    	<@radioHidden id=id label=label  selsetValues=values fileMap=fMap targetDataset=targetDataset defaultValue=defaultValue ddsfiles="data,dataName" field="dataName" require=require readOnly=readOnly width=width rowLen = rowLen/>
    </#if>
</#macro>

<#--
	id     			为radio 的id , 要求fileMap 中必须包含该id的值映射 , 这样在targetDataset中将会自动生成该id对应的field
	selsetValues    为radio 的所有选项
	targetDataset   主dataset的id
	defaultValue    下拉框的默认值
	fileMap  		值映射 ,格式如"contactmanidtype=datano;contactmanidtypename=dataname"  其中必须包含id的映射,主dataset的字段放=左边,select的值放=右边
	ddsfiles 		下拉选项对应的dataset的所有域
	field    		下拉选项对应的dataset中要显示出来的值
	width    		下拉框的宽度,一般默认不填,下拉框的宽度会被选项值自动撑开
	height   		下拉框的高度,可以指定该值,这样下拉框可以显示更多的下拉选项
	require  		该下拉选项是否必输 ,必输为 "true"
	readOnly 		是否是可读的
 -->
<#macro radioHidden id label  selsetValues  targetDataset defaultValue fileMap ddsfiles field width require readOnly rowLen>
	<#assign fileMapString ="${fileMap}">
	<#assign fileMapString = fileMapString+";${id}Name=${field}">
	<#--
    <input type="hidden" extra="editor" id="editor_${id}"
					name="${id}" componentDataset="${targetDataset}" dataField="${id}" radio="${id}_Radio_hidden" style="width:${width}">
	-->
	  <script language="javascript">
	  <#--
	  if(typeof(${id}_RadioDataset)=="undefined"){
	  	  var ${id}_selectValues = "${selsetValues}";
		  if(${id}_selectValues.length>0&&${id}_selectValues.substring(${id}_selectValues.length-1,${id}_selectValues.length)==";"){
		  	${id}_selectValues  = ${id}_selectValues.substring(0,${id}_selectValues.length-1);
		  }
		  //radio dataset
		  var ${id}_RadioDataset=createDataset("${id}_RadioDataset","",${id}_selectValues);
		  var ${id}dds_t=${id}_RadioDataset,${id}dds_f;${id}dds_t.readOnly="${readOnly}";${id}dds_t.pageSize=1000;
		  ${id}dds_t.pageIndex=1;${id}dds_t.pageCount=1;${id}dds_t.masterDataset="";  ${id}dds_t.type="dropdown";
		  ${id}dds_t.references="";${id}dds_t.submitData="allchange";${id}dds_t.autoLoadPage=true;${id}dds_t.autoLoadDetail=true;
		  ${id}dds_t.downloadUrl=getDecodeStr("~2fextraservice~2fdownloaddata");
		  ${id}dds_t.sessionKey="";${id}dds_t.insertOnEmpty=false;${id}dds_t.tag="";${id}dds_t.initDocumentFlag=false;

		  if ("${ddsfiles}"){
		      var temp = "${ddsfiles}";
		      var temps=temp.split(",");
		      for(var i=0;i<temps.length;i++){
				  ${id}dds_f=${id}dds_t.addField(temps[i],"string");${id}dds_f.label="${label}";${id}dds_f.size=0;${id}dds_f.scale=0;${id}dds_f.readOnly=false;
				  ${id}dds_f.required=false;
				  ${id}dds_f.nullable=true;${id}dds_f.defaultValue=getDecodeStr("");${id}dds_f.updatable=true;${id}dds_f.valueProtected=false;
				  ${id}dds_f.visible=true;${id}dds_f.autoGenId=false;${id}dds_f.tableName="";
				  ${id}dds_f.fieldName=temps[i].split("=")[1];${id}dds_f.tag="";${id}dds_f.editorType="";${id}dds_f.dropDown="";${id}dds_f.mask=getDecodeStr("");
				  ${id}dds_f.maskErrorMessage=getDecodeStr("");
				  ${id}dds_f.toolTip=getDecodeStr("");${id}dds_f.lobDownloadURL=getDecodeStr("");${id}dds_f.lobPopupURL=getDecodeStr("");
		  		}
		     }
			initDataset(${id}dds_t);
		}

	    if(typeof(RadioRender.getRadioById("${id}_Radio"))=="undefined"){
		  //RadioRender
		  var ${id}_Radio =new RadioRender("${id}_Radio");
		  var ${id}dd_t=${id}_Radio;
		  ${id}dd_t.type="dataset";
		  ${id}dd_t.setFieldMap("${fileMapString}");
		  ${id}dd_t.setDataset("${id}_RadioDataset");
		  ${id}dd_t.setTargetDataset("${targetDataset}");
		  ${id}dd_t.fields="${field}";
		  ${id}dd_t.setRowLen(${rowLen});
	     }
	     -->
	     _initRadio("${id}_RadioDataset","${selsetValues}","${id}_Radio","${readOnly}","${label}","${ddsfiles}","${fileMapString}","${targetDataset}","${field}","${rowLen}");
 	  	 var ${id}_RadioDataset = getDatasetByID("${id}_RadioDataset");
	  	 var ${id}_Radio = RadioRender.getRadioById("${id}_Radio");
	  </script>
</#macro>
<#--added by wangpeng 20091202 添加radio end-->

<#-- checkbox      -->
<#macro checkbox  label id  targetDataset required defaultValue width colSpan=colSpan rowSpan=1 vAlign=vAlign componentId=componentId labelwidth="" isSingle="false">
	 <#if labelwidth=="">
      <#assign lwidth="20%">
      <#assign iwidth="style=\"width:20%\"">
    <#else>
      <#assign lwidth=labelwidth+"px">
       <#assign iwidth=" ">
    </#if>
	<#if isSingle!="true">
	<td class="labeltd"  valign=${vAlign} align="right" style="width:${lwidth}" nowrap>
		<label extra="fieldlabel" id="fldlabel_${id}" componentDataset="${targetDataset}" dataField="${id}"  label="${label}"></label>
	</td>
	<td class="datatd" colspan="${colSpan?number - 1}" valign=${vAlign}  align="left" ${iwidth}  nowrap>
	</#if>
		<span extra="requiredlabel" class="requiredlabel <#if required=="required">required</#if>" >&nbsp;</span><input type="checkbox" extra="editor" ${required} editType="checkbox"  id="editor_${id}" componentDataset="${targetDataset}" dataField="${id}"  style="width:${width}">
	<#if isSingle!="true">
	</td>
	</#if>
</#macro>

<#-- checkboxs      -->
<#macro checkboxs id fId label colSpan targetDataset width require readOnly defaultValue translated viewField valueField rowLen componentId isSingle="false" labelwidth="">
	<#assign type = "">
	<#assign value = "">
	<#assign transAry = translated?split(":")>
	<#if transAry[0]?exists && transAry[1]?exists>
		<#assign type = transAry[0]>
		<#assign value = transAry[1]>
	</#if>
	<#if type=="LIST">
		<#assign values = value>
		<#assign fMap=fId + "=" + "data">
    	<@checkboxgroup id=id fId=fId label=label labelwidth=labelwidth colSpan=colSpan selsetValues=values fileMap=fMap targetDataset=targetDataset ddsfiles="data,dataName" defaultValue=defaultValue field="dataName" require=require readOnly=readOnly width=width rowLen = rowLen componentId=componentId isSingle=isSingle/>
    <#else>
        <#assign values = sysDicStr(translated)>
		<#assign fMap=fId + "=" + "data">
    	<@checkboxgroup id=id fId=fId label=label labelwidth=labelwidth colSpan=colSpan selsetValues=values fileMap=fMap targetDataset=targetDataset ddsfiles="data,dataName" defaultValue=defaultValue field="dataName" require=require readOnly=readOnly width=width rowLen = rowLen componentId=componentId isSingle=isSingle/>
    </#if>
</#macro>

<#macro checkboxgroup id fId colSpan label  selsetValues  targetDataset defaultValue fileMap ddsfiles field width require readOnly rowLen componentId isSingle="false" labelwidth="">
   <#if labelwidth=="">
      <#assign lwidth="20%">
      <#assign iwidth="style=\"width:20%\"">
    <#else>
      <#assign lwidth=labelwidth+"px">
       <#assign iwidth=" ">
    </#if>
	<#assign fileMapString ="${fileMap}">
	<#assign fileMapString = fileMapString+";${fId}Name=${field}">
	<#if isSingle!="true">
	<td class="labeltd" valign=center align="right" style="width:${lwidth}" nowrap>
    	<label extra="fieldlabel" id="fldlabel_${id}" componentDataset="${targetDataset}" dataField="${id}"  label="${label}"></label>
    </td>
    <td class="datatd" valign=center colspan="${colSpan?number - 1}" align="left" ${iwidth}  nowrap>
    </#if>
        <span extra="requiredlabel" class="requiredlabel <#if require=="required">required</#if>" >&nbsp;</span><div extra="editor" id="editor_${id}" name="${fId}" componentDataset="${targetDataset}" editType="checkboxs" dataField="${fId}" radio="${id}_Checkboxs"  ${require} >
        </div>  
    <#if isSingle!="true">
	</td>	
    </#if>
	  <script language="javascript">
	     _initRadio("${id}_CheckboxDataset","${selsetValues}","${id}_Radio","${readOnly}","${label}","${ddsfiles}","${fileMapString}","${targetDataset}","${field}","${rowLen}");
	  	 var ${id}_CheckboxDataset = getDatasetByID("${id}_CheckboxDataset");
	  	 
	  </script>
</#macro>

<#--textarea with extra js
	lable               显示的lable
	id  				为textarea 的id , 在targetDataset中将会自动生成该id对应的field
	targetDataset  		主dataset的id
	defaultValue   		默认值
	size				指定size的大小之后可以
	width               text框的宽度,一般默认不填
	require        		是否必输的,必输为 "true"
	readOnly            是否只读 , 只读为"true"
	mask                校验规则, 采用正则表达式 ,参考rule.js
	maskErrorMes        校验出错后弹出来的校验信息
 -->
<#macro textarea  id label  componentId targetDataset defaultValue  width height colSpan="2" rowSpan=1  vAlign="center" required="" readonly="" placeholder="" labelwidth="" isSingle="false">
	 <#-- 如果高度设置为0 则使用默认的50 -->
	 <#assign _height = 50 >
	 <#if height?exists && height!="">
	 <#if height?number gt 0 >
	 	<#assign _height=height >
	 </#if>
	 </#if>
	 <#if labelwidth=="">
      <#assign lwidth="20%">
      <#assign iwidth="style=\"width:20%\"">
    <#else>
      <#assign lwidth=labelwidth+"px">
       <#assign iwidth=" ">
    </#if>
    <#if isSingle!="true">
	 <td class="labeltd" valign=${vAlign} align="right" style="width:${lwidth}" nowrap>
	           <label extra="fieldlabel" id="fldlabel_${id}" componentDataset="${targetDataset}" dataField="${id}" label="${label}"></label>
	 </td>
	 <td class="datatd" colspan="${colSpan?number - 1}" valign=${vAlign} align="left" ${iwidth}  nowrap>
	 </#if>
	 <span extra="requiredlabel" class="requiredlabel <#if required=="required">required</#if>" >&nbsp;</span><textarea extra="editor"  id="editor_${id}" componentId="${componentId}" componentDataset="${targetDataset}" dataField="${id}"  dataType="string" editType="textarea"    ${required}  ${readonly} name="${id}" style="width:${width}px;height:${_height}px" placeholder="${placeholder}"></textarea>
	 <#if isSingle!="true">
	 </td>
	 </#if>
</#macro>

<#--text  with extra js
	lable               显示的lable
	id  				为textarea 的id , 在targetDataset中将会自动生成该id对应的field
	targetDataset  		主dataset的id
	defaultValue   		默认值
	maxLength		    可以输入的最大位数
	width               text框的宽度,一般默认不填
	type            该text的类型,支持的类型有 string,int,float,double
	scale               小数位的位数,如果textType为float,double,可以指定该位数
	require        		是否必输的,必输为 "true"
	readOnly            是否只读 , 只读为"true"
	mask                校验规则, 采用正则表达式 ,参考rule.js
	maskErrorMes        校验出错后弹出来的校验信息
 -->
 <#--建立Field-->
<#macro text id label componentId targetDataset defaultValue  width  colSpan=colSpan rowSpan=1 scale=""  vAlign="center" required="" readonly="" datatype="string"  prefix="" placeholder="" comparemode="" isSingle="false" labelwidth="">
    <#if labelwidth=="">
      <#assign lwidth="20%">
      <#assign iwidth="style=\"width:20%\"">
    <#else>
      <#assign lwidth=labelwidth+"px">
       <#assign iwidth=" ">
    </#if>
<#assign _et = "validatebox">
<#assign _dt = datatype>
<#assign opts = "type=\"text\" ">
<#assign isHave="true">
<#switch datatype>
  <#case "int">
	<#assign _et = "numberbox">
	<#assign opts = " ">
	<#break> 
  <#case "float">
  <#case "double">
	<#assign _et = "numberbox">
	<#assign opts = "precision=\"${scale}\" ">
	<#break> 
   <#case "currency">
	<#assign _et = "numberbox">
	<#assign opts = "precision=\"${scale}\" prefix=\"${prefix}\"  groupSeparator=\",\" ">
	<#break>
   <#case "date">
   <@date id=id componentId=componentId label=label  targetDataset=targetDataset defaultValue=defaultValue width=width colSpan=colSpan required=required
  		labelwidth=labelwidth	readonly=readonly rowSpan=rowSpan vAlign=vAlign placeholder=placeholder comparemode=comparemode isSingle=isSingle/>   
  	<#assign isHave="false">  
    <#break> 
   <#case "timestamp"> 
   <@timestamp id=id componentId=componentId label=label targetDataset=targetDataset defaultValue=defaultValue width=width colSpan=colSpan required=required
  		labelwidth=labelwidth	readonly=readonly  rowSpan=rowSpan vAlign=vAlign placeholder=placeholder isSingle=isSingle/>
  	<#assign isHave="false">    
    <#break> 
   <#case "postdate">
   <@postdate id=id componentId=componentId label=label targetDataset=targetDataset defaultValue=defaultValue width=width colSpan=colSpan required=required
  		labelwidth=labelwidth	readonly=readonly  rowSpan=rowSpan vAlign=vAlign placeholder=placeholder comparemode=comparemode isSingle=isSingle/>
  	<#assign isHave="false">     
    <#break>
   <#case "predate"> 
   <@predate id=id componentId=componentId label=label targetDataset=targetDataset defaultValue=defaultValue width=width colSpan=colSpan required=required
  		labelwidth=labelwidth	readonly=readonly  rowSpan=rowSpan vAlign=vAlign placeholder=placeholder comparemode=comparemode isSingle=isSingle/>
  	<#assign isHave="false">    
    <#break> 
   <#default>
	<#assign _dt = "string">
	<#break>
</#switch>
<#if isHave=="true">
	<#if isSingle!="true">
	 <td class="labeltd" valign=${vAlign} align="right" style="width:${lwidth}" nowrap>
	 		<label extra="fieldlabel" id="fldlabel_${id}" componentDataset="${targetDataset}" dataField="${id}"  label="${label}"></label>
	 </td>
	 <td class="datatd" colspan="${colSpan?number - 1}"  valign=${vAlign} align="left" ${iwidth}  nowrap>
	</#if>
		<span extra="requiredlabel" class="requiredlabel <#if required=="required">required</#if>" >&nbsp;</span><input extra="editor" id="editor_${id}" componentDataset="${targetDataset}" dataField="${id}" componentId="${componentId}" ${required}  ${readonly} name="${id}" style="width:${width}px;" editType="${_et}" dataType="${_dt}" placeholder="${placeholder}"  ${opts} />
	<#if isSingle!="true"> 
	 </td>
	</#if>
</#if>
</#macro>

 <#--建立password-->
<#macro password id componentId label targetDataset defaultValue  width  colSpan=colSpan rowSpan=1  vAlign="center"  required="" readonly="" isSingle="false">
	 <#if isSingle!="true"> 
	 <td class="labeltd"  valign=${vAlign} align="right"  nowrap>
	 	<label extra="fieldlabel" id="fldlabel_${id}" componentDataset="${targetDataset}" dataField="${id}"  label="${label}"></label>
	 </td>
	 <td class="datatd" colspan="${colSpan?number - 1}"  valign=${vAlign} align="left"  nowrap>
	 </#if> 
	 	<span extra="requiredlabel" class="requiredlabel <#if required=="required">required</#if>" >&nbsp;</span><input type="password" extra="editor" editType="password" id="editor_${id}" ${required}  ${readonly}  componentDataset="${targetDataset}" dataField="${id}" style="width:${width};">
	 <#if isSingle!="true"> 
	 </td>
	 </#if>
</#macro>

 <#--建立datalabel-->
<#macro datalabel id label  componentId targetDataset defaultValue  width  colSpan=colSpan rowSpan=1  vAlign="center" labelwidth="" dataType="" isSingle="false">
    <#if labelwidth=="">
      <#assign lwidth="20%">
      <#assign iwidth="style=\"width:20%\"">
    <#else>
      <#assign lwidth=labelwidth+"px">
       <#assign iwidth=" ">
    </#if>
     <#if isSingle!="true"> 
	 <td  class="labeltd" valign=${vAlign} align="right" nowrap style="width:${lwidth}">
	        <label extra="fieldlabel" id="fldlabel_${id}" componentDataset="${targetDataset}" dataField="${id}"  label="${label}"></label>	
	 </td>
	 <td class="datatd" colspan="${colSpan?number - 1}"  valign=${vAlign} align="left" style="width: ${width}px" ${iwidth} nowrap>
	 </#if>
	 	<span extra="requiredlabel" class="requiredlabel" >&nbsp;</span><label extra="datalabel" editType="datalabel" id="datalabel_${id}"  componentDataset="${targetDataset}" dataField="${id}" dataType="${dataType}" componentId="${componentId}"></label>
	 <#if isSingle!="true"> 
	 </td>
	 </#if>
</#macro>

<#--  with extra js
	lable  显示的lable
	id     为select 的id , 要求fileMap 中必须包含该id的值映射 , 这样在targetDataset中将会自动生成该id对应的field
	selsetValues   为select 的所有选项
	targetDataset  主dataset的id
	defaultValue   下拉框的默认值
	fileMap  值映射 ,格式如"contactmanidtype=datano;contactmanidtypename=dataname"  其中必须包含id的映射,主dataset的字段放=左边,select的值放=右边
	ddsfiles 下拉选项对应的dataset的所有域
	field    下拉选项对应的dataset中要显示出来的值
	width    下拉框的宽度,一般默认不填,下拉框的宽度会被选项值自动撑开
	height   下拉框的高度,可以指定该值,这样下拉框可以显示更多的下拉选项
	require  该下拉选项是否必输 ,必输为 "true"
	readOnly 是否是可读的
	colSpan  表格列
 -->
<#macro select lable id type selsetValues componentId CQid targetDataset defaultValue fileMap ddsfiles field width height require readOnly colSpan="2" placeholder="" multiple="false" editable="false" labelwidth="" isSingle="false">
	 <#if labelwidth=="">
      <#assign lwidth="20%">
      <#assign iwidth="style=\"width:20%\"">
    <#else>
      <#assign lwidth=labelwidth+"px">
       <#assign iwidth=" ">
    </#if>
	<#assign fileMapString ="${fileMap}">
	<#assign fileMapString = fileMapString+";${id}Name=${field}">
	<#if multiple=="true">
	  <#assign multi="multiple">
	  <#assign editable="false">
	<#else>
	  <#assign multi="">
	</#if>
	<#if isSingle!="true">
	<td class="labeltd" valign=center align="right" style="width:${lwidth}" nowrap>
    	<label extra="fieldlabel" id="fldlabel_${id}" componentDataset="${targetDataset}" dataField="${id}" label="${lable}"></label>
    </td>
    <td class="datatd" colspan="${colSpan?number - 1}" valign=center align="left"  ${iwidth}  nowrap>
     </#if>
    	<span extra="requiredlabel" class="requiredlabel <#if require=="required">required</#if>" >&nbsp;</span><input  extra="dropDownSelect" editType="dropDownSelect" id="select_${id}"  ${multi}   panelHeight="auto"  datasetName="${id}_DropDownDataset" valueField="id"  textField="text"
		 editable="${editable}"	${require}  ${readOnly}   componentDataset="${targetDataset}"  multi="${multiple}"  dataField="${id}" dropDown="${id}_DropDown" style="width:${width}px" placeholder="${placeholder}">
	<#if isSingle!="true">
	</td>
	</#if>
	  <script language="javascript">
		_initDropDown("${id}_DropDownDataset","${id}_DropDown","${selsetValues}","${ddsfiles}","${lable}","${fileMapString}","${field}","${height}","${readOnly}","${require}","${type}");
		var ${id}_DropDownDataset=getDatasetByID("${id}_DropDownDataset");
		var ${id}_DropDown=getDropDownByID("${id}_DropDown");
		var ${id}_Json=_initSelectJson("${id}","${require}");
	    
	  </script>
</#macro>

<#-- 处理用户自定义 生成的select -->
<#macro select2 lable id CQid componentId targetDataset defaultValue fileMap  field width height require readOnly type colSpan="2" placeholder="" multiple="false"  editable="false" labelwidth="" isSingle="false">
<#--	
        <#if type=="dynamic"||type=="dataset">
	       <#assign class="easyui-combobox">
	       <#assign dataType="dropDown">
	    <#elseif type=="dynamictree">
	       <#assign class="easyui-combotree">
	       <#assign dataType="dropDownTree">
	    </#if>
-->
   <#if labelwidth=="">
      <#assign lwidth="20%">
      <#assign iwidth="style=\"width:20%\"">
    <#else>
      <#assign lwidth=labelwidth+"px">
       <#assign iwidth=" ">
    </#if>
  <#if multiple=="false">
    <#assign multi="">
  <#else>
    <#assign multi="multiple">
    <#assign editable="false">
  </#if>
  	<#if isSingle!="true">
	<td class="labeltd" valign=center align="right" style="width:${lwidth}" nowrap>
    	<label extra="fieldlabel" id="fldlabel_${id}" componentDataset="${targetDataset}" dataField="${id}" label="${lable}"></label>
    </td>
    <td class="datatd" colspan="${colSpan?number - 1}" valign=center align="left" ${iwidth}  nowrap>
    </#if>
    	<span extra="requiredlabel" class="requiredlabel <#if require=="required">required</#if>" >&nbsp;</span><input  extra="dropDownSelect"  editType="dropDownSelect" id="select_${id}"   componentId="${componentId}"  datasetName="${CQid}_DropDownDataset" panelHeight="auto" valueField="text"  textField="text"
			${require} ${readOnly} ${multi} multi="${multiple}" editable="${editable}" componentDataset="${targetDataset}"  dataField="${id}"  dropDown="${id}_DropDown" style="width:${width}px" placeholder="${placeholder}">
	<#if isSingle!="true">
	</td>
	</#if>
	  <script language="javascript">
		 <#assign ddType="dynamic">
		 <#assign viewType="tree">
	    _initDropDown_cust1("${CQid}_DropDownDataset","${id}_DropDown","${type}","${fileMap}","${viewType}","${field}","${height}");
	    var ${id}_DropDown = getDropDownByID("${id}_DropDown");
	  </script>
</#macro>

<#-- 处理用户自定义 生成的select -->
<#macro selectCustom lable id type componentId targetDataset defaultValue fileMap  field width height require readOnly colSpan="2" placeholder="" url="" editable="false" labelwidth="" isSingle="false">
	 <#if labelwidth=="">
      <#assign lwidth="20%">
      <#assign iwidth="style=\"width:20%\"">
    <#else>
      <#assign lwidth=labelwidth+"px">
       <#assign iwidth=" ">
    </#if>
    <#if isSingle!="true">
	<td class="labeltd" valign=center align="right" style="width:${lwidth}" nowrap>
    	<label extra="fieldlabel" id="fldlabel_${id}" componentDataset="${targetDataset}" dataField="${id}" ></label>
    </td>
    <td class="datatd" valign=center align="left" ${iwidth}  nowrap>
    </#if>
    	<span extra="requiredlabel" class="requiredlabel <#if require=="required">required</#if>" >&nbsp;</span><input extra="dropDownSelect"  editType="dropDownSelect" id="select_${id}"   componentId="${componentId}"  datasetName="${id}_DropDownDataset" editable="${editable}" panelHeight="auto" valueField="text"  textField="text"
			${require} ${readOnly}    componentDataset="${targetDataset}"    dataField="${id}"  dropDown="${id}_DropDown" style="width:${width}px" placeholder="${placeholder}">
	<#if isSingle="false">
	</td>
	</#if>
	  <script language="javascript">
	  _initDropDown_cust2("${id}_DropDownDataset","${id}_DropDown","${targetDataset}","${readOnly}","${type}","${fileMap}","${height}","${url}","${id}");
	  var ${id}_DropDownDataset = getDatasetByID("${id}_DropDownDataset");
	  var ${id}_DropDown = getDropDownByID("${id}_DropDown");
	  </script>
</#macro>

<#-- 处理用户自定义 生成的select 该 select 隐藏  -->
<#macro selectGetterHidden lable id targetDataset  width height require readOnly defaultValue CQid   fileMap=""  field="" ddtype="dataset">
	  <input type="hidden" extra="editor" id="editor_${id}"
					name="${id}" componentDataset="${targetDataset}" dataField="${id}" dropDown="${id}_DropDown" style="width:${width}">
	  <script language="javascript">
		  <#if ddtype?string?lower_case=="dynamictree">
		 	<#assign type="dynamic">
		 	<#assign viewType="tree">
	  	  <#else>
	  	  	<#assign type=ddtype>
	  	 	<#assign viewType="table">
	  	  </#if>
	  	_initDropDown_cust1("${CQid}_DropDownDataset","${id}_DropDown","${type}","${fileMap}","${viewType}","${field}","${height}");
	    var ${id}_DropDown = getDropDownByID("${id}_DropDown");
	  </script>
</#macro>

<#macro selectHidden lable id targetDataset width height require readOnly defaultValue translated viewField="" fieldMap="" ddtype="dataset" init="true">
	<#assign type = "">
	<#assign value = "">
	<#assign transAry = translated?split(":")>

	<#if transAry[0]?exists && transAry[1]?exists>
		<#assign type = transAry[0]>
		<#assign value = transAry[1]>
	</#if>
	<#if type=="CQ">
		<#assign CQid = value>
    	<@CommonQueryForSelect id="${CQid}" init=init require="${require}">
	     	<@selectGetterHidden lable=lable id=id targetDataset="${targetDataset}"
	       		 width=width height=height require=require readOnly=readOnly defaultValue=defaultValue  CQid=CQid fileMap=fieldMap field=viewField ddtype=ddtype>
	        </@selectGetterHidden>
        </@CommonQueryForSelect>
	<#elseif type=="LIST">
    	<#assign values = value>
		<#assign fMap=id + "=" + "data">
	    <@selectDataHidden lable=lable id=id  selsetValues=values targetDataset=targetDataset fileMap=fMap ddsfiles="data,dataName" defaultValue=defaultValue field="dataName"   width=width height=height require=require readOnly=readOnly />
	 <#else>
		<#assign fMap=id + "=" + "data">
	    <@selectDataDicHidden lable=lable id=id  translated=translated targetDataset=targetDataset fileMap=fMap ddsfiles="data,dataName" defaultValue=defaultValue field="dataName"   width=width height=height require=require readOnly=readOnly />
	 </#if>
</#macro>

<#--selectHidden 数据下拉,用于处理包含dataTable,但是不包含group,并且dataTable的select是处于可编辑状态的情况 -->
<#macro selectDataHidden lable id  selsetValues targetDataset fileMap  ddsfiles defaultValue  field width height require readOnly >
	<#assign values = selsetValues>
	<#assign fileMapString ="${fileMap}">
	<#assign fileMapString =  fileMapString + ";${id}Name=${field}">

      <input type="hidden" extra="editor" id="editor_${id}"
					name="${id}" componentDataset="${targetDataset}" dataField="${id}" dropDown="${id}_DropDown" style="width:${width}">

	  <script language="javascript">
	
		_initDropDown("${id}_DropDownDataset","${id}_DropDown","${selsetValues}","${ddsfiles}","${lable}","${fileMapString}","${field}","${height}","${readOnly}","${require}");
	  	var ${id}_DropDownDataset=getDatasetByID("${id}_DropDownDataset");
		var ${id}_DropDown=getDropDownByID("${id}_DropDown");
	  </script>

</#macro>

<#--selectDataDicHidden 数据下拉,用于处理包含dataTable,但是不包含group,并且dataTable的select是处于可编辑状态的情况 -->
<#macro selectDataDicHidden lable id  translated targetDataset fileMap  ddsfiles defaultValue  field width height require readOnly >
	<#assign values = sysDicStr(translated)>
	<@selectDataHidden lable=lable id=id  selsetValues=values targetDataset=targetDataset fileMap=fileMap ddsfiles=ddsfiles defaultValue=defaultValue field=field  width=width height=height require=require readOnly=readOnly />
</#macro>

<#--DataDic 数据下拉  -->
<#macro selectDataDic lable id componentId targetDataset width height require readOnly defaultValue translated labelwidth="" multiple="false" viewField="" fieldMap="" ddtype="dataset" init="true" url="" colSpan="2" placeholder="" startyear="2007" yearlength="10" editable="false" isSingle="false">
<#-- modify by shen_antonio 20080121 -->
	<#assign type = "">
	<#assign value = "">
	<#assign transAry = translated?split(":")>
	<#if transAry[0]?exists && transAry[1]?exists>
		<#assign type = transAry[0]>
		<#assign value = transAry[1]>
	</#if>
	<#if ddtype=="dataset">
		<#if type=="CQ">
			<#assign CQid = value>
    		<@CommonQueryForSelect id="${CQid}" init="false" require="${require}">
     			<@selectCQ lable=lable id=id labelwidth=labelwidth targetDataset="${targetDataset}" componentId= componentId  multiple=multiple editable=editable
       				width=width height=height require=require readOnly=readOnly defaultValue=defaultValue  CQid=CQid fieldMap=fieldMap field=viewField type="cq" colSpan=colSpan placeholder=placeholder isSingle=isSingle>
       			</@selectCQ>
        	</@CommonQueryForSelect>
    	<#elseif type=="LIST">
    		<#assign values = value>
			<#assign fMap=id + "=" + "data">
	    	<@select type="list"  multiple=multiple labelwidth=labelwidth lable=lable id=id componentId= componentId CQid=value selsetValues=values targetDataset=targetDataset fileMap=fMap ddsfiles="data,dataName" defaultValue=defaultValue field="dataName"   width=width height=height require=require readOnly=readOnly colSpan=colSpan placeholder=placeholder editable=editable isSingle=isSingle/>
	    <#else>
	    	<#assign values = sysDicStr(translated)>
			<#assign fMap=id + "=" + "data">
	    	<@select type="dic" multiple=multiple lable=lable labelwidth=labelwidth id=id componentId= componentId CQid=value selsetValues=values targetDataset=targetDataset fileMap=fMap ddsfiles="data,dataName" defaultValue=defaultValue field="dataName"   width=width height=height require=require readOnly=readOnly colSpan=colSpan placeholder=placeholder editable=editable isSingle=isSingle/>
	    </#if>
	 <#elseif ddtype=="dynamic">
	 	<#if type=="CQ">
			<#assign CQid = value>
    		<@CommonQueryForSelect id="${CQid}" init="${init}" require="${require}">
     			<@selectCQ lable=lable id=id targetDataset="${targetDataset}" labelwidth=labelwidth  componentId= componentId  multiple=multiple
       				width=width height=height require=require readOnly=readOnly defaultValue=defaultValue  CQid=CQid fieldMap=fieldMap field=viewField type="cq" colSpan=colSpan placeholder=placeholder editable=editable isSingle=isSingle>
       			</@selectCQ>
        	</@CommonQueryForSelect>
        <#else>
        </#if>
     <#elseif ddtype=="dynamictree">
	 	<#if type=="CQ">
			<#assign CQid = value>
    		<@CommonQueryForSelect id="${CQid}" init="${init}" require="${require}">
     			<@selectGetter lable=lable id=id targetDataset="${targetDataset}"  componentId= componentId multiple=multiple editable=editable labelwidth=labelwidth
       				width=width height=height require=require readOnly=readOnly defaultValue=defaultValue  CQid=CQid fieldmap=fieldMap field=viewField type="dynamictree" colSpan=colSpan placeholder=placeholder isSingle=isSingle>
       			</@selectGetter>
        	</@CommonQueryForSelect>
        <#else>
        </#if>
     <#elseif ddtype=="custom">
		<@selectCustom type="custom" lable=lable labelwidth=labelwidth id=id  targetDataset=targetDataset  componentId= componentId  defaultValue=defaultValue fileMap=fieldMap  field=viewField width=width height=height require=require readOnly=readOnly  url=url placeholder=placeholder editable=editable isSingle=isSingle/>
     <#elseif ddtype=="dialog">
     	<@selectCustom type="dialog" lable=lable id=id labelwidth=labelwidth targetDataset=targetDataset  componentId= componentId  defaultValue=defaultValue fileMap=fieldMap  field=viewField width=width height=height require=require readOnly=readOnly  url=url placeholder=placeholder editable=editable isSingle=isSingle/>
    <#elseif ddtype=="img">
       <#assign CQid = value>
       <@CommonQueryForSelect id="${CQid}" init="false" require="${require}">
     	  <@selectCQ lable=lable id=id targetDataset="${targetDataset}" componentId= componentId  multiple=multiple editable=editable
       			labelwidth=labelwidth	width=width height=height require=require readOnly=readOnly defaultValue=defaultValue  CQid=CQid fieldMap=fieldMap field=viewField type="img" colSpan=colSpan placeholder=placeholder isSingle=isSingle>
       	  </@selectCQ>
       </@CommonQueryForSelect>
     </#if>
</#macro>

<#--自定义数据下拉 , 采用getter方法  -->
<#macro selectGetter lable id multiple componentId targetDataset width height require readOnly defaultValue CQid fieldmap field type="dataset" colSpan="2" placeholder="" editable="false" labelwidth="" isSingle="false">
	<@select2 lable=lable id=id multiple=multiple labelwidth=labelwidth componentId= componentId   targetDataset=targetDataset fileMap=fieldmap CQid=CQid  defaultValue=defaultValue field=field   width=width height=height require=require readOnly=readOnly type=type colSpan=colSpan placeholder=placeholder editable=editable isSingle=isSingle/>
</#macro>

<#macro selectCQ lable id multiple componentId targetDataset width height require readOnly defaultValue CQid fieldMap field type colSpan="2" placeholder="" editable="false" labelwidth="" isSingle="false">
    <#if labelwidth=="">
      <#assign lwidth="20%">
      <#assign iwidth="style=\"width:20%\"">
    <#else>
      <#assign lwidth=labelwidth+"px">
       <#assign iwidth=" ">
    </#if>
  <#if multiple=="false">
    <#assign multi="">
  <#else>
    <#assign multi="multiple">
    <#assign editable="false">
  </#if>
  <#if isSingle!="true">  	
	<td class="labeltd" valign=center align="right" style="width: ${lwidth}" nowrap>
    	<label extra="fieldlabel" id="fldlabel_${id}" componentDataset="${targetDataset}" dataField="${id}" label="${lable}"></label>
    </td>
    <td class="datatd" colspan="${colSpan?number - 1}" valign=center align="left" ${iwidth}  nowrap>
  </#if>
  	<span extra="requiredlabel" class="requiredlabel <#if require=="required">required</#if>" >&nbsp;</span><input type="${type}" extra="dropDownSelect" editType="dropDownSelect" id="select_${id}"   componentId="${componentId}"  datasetName="${CQid}_DropDownDataset"  editable="${editable}"
		 ${multi} multi="${multiple}"  ${require} ${readOnly} componentDataset="${targetDataset}" dataField="${id}"  dropDown="${id}_DropDown" style="width:${width}px" placeholder="${placeholder}">
	<#if isSingle!="true">  
	</td>
	</#if>
	  <script language="javascript">
	  	 <#assign viewType="table">           
         _initDropDown_cust1("${CQid}_DropDownDataset","${id}_DropDown","${type}","${fieldMap}","${viewType}","${field}","${height}");
	     var ${id}_DropDown = getDropDownByID("${id}_DropDown");
	     var ${id}_selectCQDropDown=new Array();
	  </script>
</#macro>

<#macro selectCQ2 lable id componentId targetDataset width height require readOnly defaultValue CQid fieldMap field type multiple="false" colSpan="2" placeholder="" editable="false">
  <#if multiple=="false">
    <#assign multi="">
  <#else>
    <#assign multi="multiple">
    <#assign editable="false">
  </#if>  
    	<input type="${type}" extra="dropDownSelect" editType="dropDownSelect" id="select_${id}"   componentId="${componentId}"  datasetName="${CQid}_DropDownDataset"  editable="${editable}"
		 ${multi} multi="${multiple}" ${require} ${readOnly} componentDataset="${targetDataset}" dataField="${id}"   dropDown="${id}_DropDown" style="width:${width}px" placeholder="${placeholder}">
	  <script language="javascript">
	  	 <#assign viewType="table">           
         _initDropDown_cust1("${CQid}_DropDownDataset","${id}_DropDown","${type}","${fieldMap}","${viewType}","${field}","${height}");
	     var ${id}_DropDown = getDropDownByID("${id}_DropDown");
	     var ${id}_selectCQDropDown=new Array();
	  </script>
</#macro>

<#macro hiddenelement id value targetDataset componentId required>
<input type="hidden" extra="editor" editType="hidden" id="editor_${id}" name="${id}" componentDataset="${targetDataset}" dataField="${id}"  ${required}>
</#macro>

<#--按钮
	id
	targetDataset
	desc
	defaultOperation
	submitManager
	autoForm
	url
	updateclass
	nexturl
	plain 
-->
<#-- modify by shen_antonio 20080121 -->
<#macro button id targetDataset desc defaultOperation submitManager="_submitmanager_default" autoForm="dtResult" url="" updateClass="" resultDataset="" submitDataset="" targetFrame="_self" icon=""  plain="false"> 
    <#assign _button_auth= statics["com.huateng.ebank.business.buttonmng.filter.ButtonAuthority"].getButtonAuthority(targetDataset,id)>
    <#if _button_auth?starts_with("true_")>
     <#assign funcId=_button_auth[5..]>
      <a extra="button"  type="button" id="${id}"  resultDataset="${resultDataset}"  plain="${plain}"
        href="javascript:void(0)" iconCls="${icon}" submitManager="${submitManager}" autoForm="${autoForm}" > <@bean.message key="${desc}"/> </a>
      <script language="javascript">
	    _initButton("${id}","${targetDataset}","${url}","${updateClass}","${resultDataset}","${submitDataset}","${targetFrame}","${defaultOperation}","${funcId}");
	    </script>
    <#else>
      <a id="${id}"  />
      <script>
        var a_${id} = document.getElementById("${id}");
        a_${id}.disable=function(){};
      </script>
    </#if>
</#macro>

<#--通用查询头模板 用于用户自定义生成的select-->
<#macro CommonQueryForSelect id init="true" require="false">
<#assign DropDownCommonQueryConfig = statics["com.huateng.commquery.config.CommonQueryUtil"].getCommonQueryBean(id)>
<@DropDownDataSet init=init require=require/>
<#nested>
</#macro>

<#--建立DropDownDataSet模板-->
<#macro DropDownDataSet init="true" require="false">
<#assign specStr="nextPage|everyPage|pageNm|currentPage|fieldString|recordString|recordOrigString">
<script language="javascript">
	var _ds = getDatasetByID("${DropDownCommonQueryConfig.getId()}_DropDownDataset");
	var ${DropDownCommonQueryConfig.getId()}_DropDownDataset=_ds||createDataset("${DropDownCommonQueryConfig.getId()}_DropDownDataset","","");
	if(!_ds){
	<#assign paramString = configParamConver()>
	  <#assign parametersMap=DropDownCommonQueryConfig.getParameters()>
      <#assign parametersKeys=parametersMap.keySet()>
      var pKey=new Array();
      <#list parametersKeys as key>
        <#assign parameter=parametersMap.get(key)>
        <#assign pDesc = parameter.getAnyValue("desc")?default("值")>
        <#assign pRequire = parameter.getAnyValue("require")?default("false")>
        <#assign pWidth = parameter.getAnyValue("width")?default("")>
        <#assign pHeight = parameter.getAnyValue("height")?default("")>
        var Key=new Object();
        Key.name="${key}";
        Key.desc="${pDesc}";
        Key.require="${pRequire}";
        Key.width="${pWidth}";
        Key.height="${pHeight}";
        pKey.push(Key);
      </#list> 
	_initDataset(${DropDownCommonQueryConfig.getId()}_DropDownDataset,"${DropDownCommonQueryConfig.getId()}",${DropDownCommonQueryConfig.getAnyValue("pagesize")?default("10")},""
	,"","","allchange",false,"dd","${paramString}","${init}","dropdown",pKey);
	var _dt = ${DropDownCommonQueryConfig.getId()}_DropDownDataset,_f;
   			<#assign fieldMap = DropDownCommonQueryConfig.fields>
			<#assign fields = fieldMap.keySet()>
 			<#assign field = "">
 			<#assign fDesc = "",fVal = "",fStat = "">
 			<#assign columnInx = 0>
 			<#list fields as fId>
    		<#assign fDesc = getFieldDesc(DropDownCommonQueryConfig.getId(),fId)>
	    <#--dataset,isCQ,isSelect,fId,fType,viewField,CQid,mask,maskErrMsg,toolTip,fDesc,fSize,scale,required,readonly,currencyAlign,tag,dropDown,dropDownDataset,radio,RadioDataset-->
 			 _initField(_dt,"${fId}","string","","null","","","${fDesc}",
		  "","",false,"false","","","","","","");
	 		</#list>
	 		initDataset(${DropDownCommonQueryConfig.getId()}_DropDownDataset);
	 }
</script>
</#macro>

<#function configParamConver>
<#assign paramString = "">
<#assign paramIds = DropDownCommonQueryConfig.getParameters().keySet()>
<#assign paramVal = "">
<#list paramIds as paramId>
	<#assign paramVal = DropDownCommonQueryConfig.getParameter(paramId).getAnyValue("value","")>
	<#assign paramVal = encodeStr(paramVal)>
	<#if paramString!="">
		<#assign paramString = paramString + ";" + paramId + "," + paramVal>
	<#else>
		<#assign paramString = paramId + "," + paramVal>
	</#if>
</#list>
<#return paramString>
</#function>

