
<#-- select with extra js
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
 -->
<#macro select lable id  selsetValues  targetDataset defaultValue fileMap ddsfiles field width height require readOnly>
	<#assign fileMapString ="${fileMap}">
	<#assign fileMapString =  "${id}_name=${field};"+fileMapString>
    <label extra="fieldlabel" id="fldlabel_${id}" dataset="${targetDataset}" dataField="${id}_name" ></label>
    <input type="text" extra="editor" id="${id}"
					name="${id}" dataset="${targetDataset}" dataField="${id}_name" dropDown="${id}_DropDown" style="width:${width}">
	  <script language="javascript">
	  //dropdown dataset
	  var ${id}_DropDownDataset=createDataset("${id}_DropDownDataset","","${selsetValues}");
	  var ${id}dds_t=${id}_DropDownDataset,${id}dds_f;${id}dds_t.readOnly="${readOnly}";${id}dds_t.pageSize=1000;
	  ${id}dds_t.pageIndex=1;${id}dds_t.pageCount=1;${id}dds_t.masterDataset="";
	  ${id}dds_t.references="";${id}dds_t.submitData="allchange";${id}dds_t.autoLoadPage=false;${id}dds_t.autoLoadDetail=true;
	  ${id}dds_t.downloadUrl=getDecodeStr("~2fextraservice~2fdownloaddata");
	  ${id}dds_t.sessionKey="";${id}dds_t.insertOnEmpty=false;${id}dds_t.tag="";

	  if ("${ddsfiles}"){
	      var temp = "${ddsfiles}";
	      var temps=temp.split(",");
	      for(var i=0;i<temps.length;i++){
			  ${id}dds_f=${id}dds_t.addField(temps[i],"string");${id}dds_f.label="";${id}dds_f.size=0;${id}dds_f.scale=0;${id}dds_f.readOnly=false;
			  ${id}dds_f.required=false;
			  ${id}dds_f.nullable=true;${id}dds_f.defaultValue=getDecodeStr("");${id}dds_f.updatable=true;${id}dds_f.valueProtected=false;
			  ${id}dds_f.visible=true;${id}dds_f.autoGenId=false;${id}dds_f.tableName="";
			  ${id}dds_f.fieldName=temps[i].split("=")[1];${id}dds_f.tag="";${id}dds_f.editorType="";${id}dds_f.dropDown="";${id}dds_f.mask=getDecodeStr("");
			  ${id}dds_f.maskErrorMessage=getDecodeStr("");
			  ${id}dds_f.toolTip=getDecodeStr("");${id}dds_f.lobDownloadURL=getDecodeStr("");${id}dds_f.lobPopupURL=getDecodeStr("");
	  		}
	     }
		initDataset(${id}dds_t);

      //dropdown
	  var ${id}_DropDown =createDropDown("${id}_DropDown");
	  var ${id}dd_t=${id}_DropDown;${id}dd_t.type="dataset";${id}dd_t.cache=true;${id}dd_t.fixed=true;
	  ${id}dd_t.fieldMap="${fileMapString}";
	  ${id}dd_t.autoDropDown=true;${id}dd_t.editable=true;
	  if("${height}") {${id}dd_t.height = "${height}"};
	  else{ ${id}dd_t.height=0};${id}dd_t.tag="";
	  ${id}dd_t.dataset="${id}_DropDownDataset";${id}dd_t.fields="${field}";${id}dd_t.showHeader=false;
	  _array_dropdown[_array_dropdown.length]=${id}dd_t;
	  initDropDown(${id}dd_t);


	  var ${id}_t = getDatasetByID("${targetDataset}"),${id}_f="";

	  if ("${fileMapString}"){
	      var temp1 = "${fileMapString}";
	      var temps1=temp1.split(";");
	      for(var i=0;i<temps1.length;i++){
				  ${id}_f=${id}_t.addField(temps1[i].split("=")[0],"string");
				  ${id}_f.label=getDecodeStr("${lable}");
				  ${id}_f.size=0;${id}_f.scale=0;${id}_f.readOnly=false;
				  if(temps[i].split("=")[0]==${id}) ${id}_f.required="${require}";
				  else ${id}_f.required="false";
				  ${id}_f.nullable=true;${id}_f.defaultValue=getDecodeStr("");${id}_f.updatable=true;${id}_f.valueProtected=false;${id}_f.visible=true;${id}_f.autoGenId=false;
				  ${id}_f.tableName="";${id}_f.fieldName=temps1[i].split("=")[0];${id}_f.tag="";${id}_f.editorType="";${id}_f.dropDown="";${id}_f.mask=getDecodeStr("");
				  ${id}_f.maskErrorMessage=getDecodeStr("");${id}_f.toolTip=getDecodeStr("");
				  ${id}_f.lobDownloadURL=getDecodeStr("");${id}_f.lobPopupURL=getDecodeStr("");
			  }
	     }
	    _paramMap.put("${id}_name","${defaultValue}");


	  </script>
</#macro>

<#-- staticSelect with extra js
	lable 显示的lable
	id  为select 的id , 在targetDataset中将会自动生成该id对应的field
	selsetValues  为select 的所有选项,其格式为"0-否;1-是",这样如果选中了"1-是"就会把"1"赋给targetDataset的id
	targetDataset  主dataset的id
	defaultValue  下拉框的默认值
	width  下拉框的宽度,一般默认不填,下拉框的宽度会被选项值自动撑开
	height 下拉框的高度,可以指定该值,这样下拉框可以显示更多的下拉选项
	require  该下拉选项是否必输 ,必输为 "true"
	readOnly 是否是只读的, 只读为"true"
 -->
<#macro staticSelect lable id  selsetValues  targetDataset  defaultValue width height require readOnly>
    <label extra="fieldlabel" id="fldlabel_${id}" dataset="${targetDataset}" dataField="${id}" ></label>
	<input type="text" extra="editor" id="${id}" dataset="${targetDataset}" dataField="${id}" dropDown="${id}_DropDown" style="width:${width}">
	  <script language="javascript">
      //dropdown
		var ${id}_DropDown=createDropDown("${id}_DropDown");
		var ${id}dd_t=${id}_DropDown;
		${id}dd_t.type="list";${id}dd_t.cache=true;
		${id}dd_t.fixed=true;${id}dd_t.fieldMap="";
		${id}dd_t.autoDropDown=true;
		${id}dd_t.editable=true;
		if("${height}") {${id}dd_t.height = "${height}"};
	    else{ ${id}dd_t.height=0};
	    ${id}dd_t.tag="";${id}dd_t.mapValue="false";
		${id}dd_t.items="${selsetValues}";
		_array_dropdown[_array_dropdown.length]=${id}dd_t;
		initDropDown(${id}dd_t);

	  // targetDataset

      var ${id}_t = getDatasetByID("${targetDataset}"),${id}_f="";
	  ${id}_f=${id}_t.addField("${id}","string");
	  ${id}_f.label=getDecodeStr("${lable}");
	  ${id}_f.size=0;${id}_f.scale=0;${id}_f.readOnly="${readOnly}";${id}_f.required="${require}";
	  ${id}_f.nullable=true;${id}_f.defaultValue=getDecodeStr("");${id}_f.updatable=true;${id}_f.valueProtected=false;${id}_f.visible=true;${id}_f.autoGenId=false;
	  ${id}_f.tableName="";${id}_f.fieldName="${id}";${id}_f.tag="";${id}_f.editorType="";${id}_f.dropDown="";${id}_f.mask=getDecodeStr("");
	  ${id}_f.maskErrorMessage=getDecodeStr("");${id}_f.toolTip=getDecodeStr("");${id}_f.lobDownloadURL=getDecodeStr("");${id}_f.lobPopupURL=getDecodeStr("");

	  </script>
</#macro>


<#--DataDic 数据下拉-->
<#macro selectDataDic lable id  datatype targetDataset width="" height="" require="false" readOnly="false" defaultValue="">
<#assign values = sysDicStr("DATA_DIC" + "." + datatype)>
<#assign fMap=id + "=" + "datano">
<@select lable=lable id=id  selsetValues=values targetDataset=targetDataset fileMap=fMap ddsfiles="datano,dataname" defaultValue=defaultValue field="dataname" width=width height=height require=require readOnly=readOnly/>
</#macro>

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
<#macro date lable id  targetDataset defaultValue  require maxLength width >
		<label extra="fieldlabel" id="fldlabel_${id}" dataset="${targetDataset}" dataField="${id}" ></label>
		<input type="text" extra="editor" id="${id}" name="${id}" dataset="${targetDataset}" dataField="${id}" style="width:${width}">
		<script language="javascript">

		var dropDownDate=createDropDown("dropDownDate");
		var ${id}date_t=dropDownDate;${id}date_t.type="date";
		${id}date_t.cache=true;${id}date_t.fixed=false;${id}date_t.fieldMap="";
		${id}date_t.autoDropDown=true;${id}date_t.editable=false;
		${id}date_t.height=0;${id}date_t.tag="";_array_dropdown[_array_dropdown.length]=${id}date_t;
		initDropDown(${id}date_t);

		var ${id}_t = getDatasetByID("${targetDataset}"),${id}_f="";

		${id}_f=_t.addField("${id}","date");${id}_f.label=getDecodeStr("${lable}");
		${id}_f.size="${maxLength}";${id}_f.scale=0;${id}_f.readOnly=false;${id}_f.required="${require}";
		${id}_f.nullable=true;${id}_f.defaultValue=getDecodeStr("");
		${id}_f.updatable=true;${id}_f.valueProtected=false;${id}_f.visible=true;${id}_f.autoGenId=false;${id}_f.tableName="";
		${id}_f.fieldName="${id}";
		${id}_f.tag="";${id}_f.editorType="";${id}_f.dropDown="";${id}_f.mask=getDecodeStr("");
		${id}_f.maskErrorMessage=getDecodeStr("");${id}_f.toolTip=getDecodeStr("");${id}_f.lobDownloadURL=getDecodeStr("");
		${id}_f.lobPopupURL=getDecodeStr("");
		//_t.setValue("${id}","${defaultValue}");
		</script>
</#macro>


<#--checkbox with extra js
	lable               显示的lable
	checkboxpras   		为该checkbox的所有的可以选的项以及其对应值 , checkboxpras="信用:credit;保证:guarantee;抵押:pledge" ,同样的会在主dataset中生成"credit,guarantee,pledge"这几个域
	targetDataset  		主dataset的id
	defaultValue   		默认值 defaultValues="0,0,1"; 这样就会把第三个checkbox设置为选中状态
	require        		是否必输的,必输为 "true"
	readOnlyIndex       只读的checkbox 的序号,readOnlyIndex="0,2",这样第一和第三个为只读,readOnlyIndex="all"就全部为只读
 -->
<#macro checkbox lable checkboxpras  targetDataset defaultValues require readOnlyIndex>
	<#assign index ="">
	<#assign lableString ="">
	<#assign inputString ="">
	<#assign operationsMap = "${checkboxpras}">
	<#list operationsMap?split(";")  as key>
	     <#assign index =key?index_of(":")>
		 <#assign lableName =key?substring(0,index)>
		 <#assign id =key?substring(index+1)>
		 <#assign inputString = inputString + "<input type=\"checkbox\" extra=\"editor\" id=\"editor_${id}\" dataset=\"${targetDataset}\" dataField=\"${id}\" style=\"\" >" >
		 <#assign inputString = inputString + "<label>${lableName}</lable>" + "&nbsp&nbsp">
	</#list>
	<#if require = "true">
	 <#assign lableString ="<font color=\"red\">*</font>${lable}">
	<#else>
	  <#assign lableString ="${lable}">
	</#if>
		${lableString}
		${inputString}
    <script language="javascript">
		var ${id}_t = getDatasetByID("${targetDataset}"),${id}_f="";
		var readOnlyArraytemp =  "${readOnlyIndex}";
		var readOnlyArray = readOnlyArraytemp.split(",");
		if ("${checkboxpras}"){
	      var temp = "${checkboxpras}";
	      var checkboxpras=temp.split(";");
	      for(var i=0;i<checkboxpras.length;i++){
	      	 	${id}_f=${id}_t.addField(checkboxpras[i].split(":")[1],"boolean");${id}_f.label=getDecodeStr("");
				${id}_f.size=0;${id}_f.scale=0;
				if("${readOnlyIndex}"=="all")
					${id}_f.readOnly=true;
				else{
					for(var j=0;j<readOnlyArray.length;j++){
						if(i.toString()==readOnlyArray[j]){
							${id}_f.readOnly=true;
							break;
						}else{
						    ${id}_f.readOnly=false;
						}
					}
				}
				${id}_f.required=false;${id}_f.nullable=true;
				${id}_f.defaultValue="";${id}_f.updatable=true;${id}_f.valueProtected=false;
				${id}_f.visible=true;${id}_f.autoGenId=false;${id}_f.tableName="";
				${id}_f.fieldName=checkboxpras[i].split(":")[1];
				${id}_f.tag="";${id}_f.editorType="";${id}_f.dropDown="";${id}_f.mask=getDecodeStr("");${id}_f.maskErrorMessage=getDecodeStr("");
				${id}_f.toolTip=getDecodeStr("");${id}_f.lobDownloadURL=getDecodeStr("");${id}_f.lobPopupURL=getDecodeStr("");
	  		}
	     }
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
<#macro textarea lable id  targetDataset defaultValue size width  require readOnly mask maskErrorMes>
	 <label extra="fieldlabel" id="fldlabel_${id}" dataset="${targetDataset}" dataField="${id}" ></label>
	 <textarea extra="editor" id="${id}" dataset="${targetDataset}" dataField="${id}" style="width:${width};"></textarea>
<script language="javascript">
        var ${id}_t = getDatasetByID("${targetDataset}"),${id}_f="";
		${id}_f=${id}_t.addField("${id}","string");${id}_f.label=getDecodeStr("${lable}");
		${id}_f.size="${size}";${id}_f.scale=0;${id}_f.readOnly="false";${id}_f.required="${require}";
		${id}_f.nullable=true;${id}_f.defaultValue=getDecodeStr("${defaultValue}");${id}_f.updatable=true;
		${id}_f.valueProtected=false;${id}_f.visible=true;${id}_f.autoGenId=false;${id}_f.tableName="";
		${id}_f.fieldName="${id}";${id}_f.tag="";${id}_f.editorType="";${id}_f.dropDown="";
		${id}_f.mask= "/" + ${mask} + "/" ;${id}_f.maskErrorMessage=getDecodeStr("${maskErrorMes}");
		${id}_f.toolTip=getDecodeStr("");${id}_f.lobDownloadURL=getDecodeStr("");
		${id}_f.lobPopupURL=getDecodeStr("");

</script>
</#macro>

<#--text    with extra js
	lable               显示的lable
	id  				为textarea 的id , 在targetDataset中将会自动生成该id对应的field
	targetDataset  		主dataset的id
	defaultValue   		默认值
	maxLangth		    可以输入的最大位数
	width               text框的宽度,一般默认不填
	dataType            该text的类型,支持的类型有 string,int,float,double
	scale               小数位的位数,如果textType为float,double,可以指定该位数
	require        		是否必输的,必输为 "true"
	readOnly            是否只读 , 只读为"true"
	mask                校验规则, 采用正则表达式 ,参考rule.js
	maskErrorMes        校验出错后弹出来的校验信息
 -->

<#macro text lable id targetDataset defaultValue maxLangth width dataType scale  require readOnly mask maskErrorMes colSpan="2" rowSpan=1  vAlign="center">
<td  valign=${vAlign} align="right" style="width: 20%" nowrap>
	 <label extra="fieldlabel" id="fldlabel_${id}" dataset="${targetDataset}" dataField="${id}" ></label>
</td>
<td colspan="${colSpan?number - 1}"  valign=${vAlign} align="left" style="width: 20%" nowrap>
	 <input type="text" extra="editor" id="${id}" name="${id}" dataset="${targetDataset}" dataField="${id}" style="width:${width};">
</td>
<script language="javascript">
        var ${id}_t = getDatasetByID("${targetDataset}"),${id}_f="";
		${id}_f=${id}_t.addField("${id}","${dataType}");${id}_f.label=getDecodeStr("${lable}");
		${id}_f.size="${maxLangth}";${id}_f.scale="${scale}";${id}_f.readOnly="false";${id}_f.required="${require}";
		${id}_f.nullable=true;${id}_f.defaultValue=getDecodeStr("");${id}_f.updatable=true;
		${id}_f.valueProtected=false;${id}_f.visible=true;${id}_f.autoGenId=false;${id}_f.tableName="";
		${id}_f.fieldName="${id}";${id}_f.tag="";${id}_f.editorType="";${id}_f.dropDown="";
		if("${mask}"){
			${id}_f.mask= "/" + ${mask} + "/" ;
		}else{
			${id}_f.mask="";
		}
		${id}_f.maskErrorMessage=getDecodeStr("${maskErrorMes}");
		${id}_f.toolTip=getDecodeStr("");${id}_f.lobDownloadURL=getDecodeStr("");
		${id}_f.lobPopupURL=getDecodeStr("");

		if("${defaultValue}")
		_paramMap.put("${id}", "${defaultValue}");
</script>
</#macro>

<#macro button lable id targetDataset defaultValue maxLangth width dataType scale  require readOnly mask maskErrorMes colSpan="2" rowSpan=1  vAlign="center">
<td  valign=${vAlign} align="right" style="width: 20%" nowrap>
	 <label extra="fieldlabel" id="fldlabel_${id}" dataset="${targetDataset}" dataField="${id}" ></label>
</td>
<td colspan="${colSpan?number - 1}"  valign=${vAlign} align="left" style="width: 20%" nowrap>
	 <input type="text" extra="editor" id="${id}" name="${id}" dataset="${targetDataset}" dataField="${id}" style="width:${width};">
</td>
<script language="javascript">
        var ${id}_t = getDatasetByID("${targetDataset}"),${id}_f="";
		${id}_f=${id}_t.addField("${id}","${dataType}");${id}_f.label=getDecodeStr("${lable}");
		${id}_f.size="${maxLangth}";${id}_f.scale="${scale}";${id}_f.readOnly="false";${id}_f.required="${require}";
		${id}_f.nullable=true;${id}_f.defaultValue=getDecodeStr("");${id}_f.updatable=true;
		${id}_f.valueProtected=false;${id}_f.visible=true;${id}_f.autoGenId=false;${id}_f.tableName="";
		${id}_f.fieldName="${id}";${id}_f.tag="";${id}_f.editorType="";${id}_f.dropDown="";
		if("${mask}"){
			${id}_f.mask= "/" + ${mask} + "/" ;
		}else{
			${id}_f.mask="";
		}
		${id}_f.maskErrorMessage=getDecodeStr("${maskErrorMes}");
		${id}_f.toolTip=getDecodeStr("");${id}_f.lobDownloadURL=getDecodeStr("");
		${id}_f.lobPopupURL=getDecodeStr("");

		if("${defaultValue}")
		_paramMap.put("${id}", "${defaultValue}");
</script>
</#macro>
