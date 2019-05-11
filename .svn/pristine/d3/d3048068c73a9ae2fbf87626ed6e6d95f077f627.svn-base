<#--
描述：查询结果生成文本表格模板
作者: shen_antonio
创建日期:20080523
-->

<#--引用参数
　　 RESULT-返回结果集合
　　 TYPE-显示方式(1-表格方式;2-组方式)

显示示例如下:
     国内邮政汇兑业务收入统计总表
┏━━━━┯━━━━━━━━━━━┯━━━━━━━━━━━━━━┓
┃　     ｜                     ｜                          ┃
┠────┼───────────┼──────────────┨
┃       ｜                      ｜                            ┃
┠────┼───────────┼──────────────┨
┃        ｜                      ｜                            ┃
┠────┼───────────┼──────────────┨
┃        ｜                      ｜                            ┃
┠────┼───────────┼──────────────┨
┃        ｜                      ｜                            ┃
┖────┴───────────┴──────────────┚
-->
<#--global value-->
<#global rowConS = "┠">
<#global rowConE = "┨">
<#global rowStartLineS = "┏">
<#global rowStartLineE = "┓">
<#global rowStartLineM = "━">
<#global rowEndLineS = "┖">
<#global rowEndLineM = "─">
<#global rowEndLineE = "┚">
<#global row = "─">
<#global rowSColumn="┃">
<#global column = "｜">
<#global space=1>
<#---->

<#--获取通用查询配置-->
<#assign CQId = CommonQueryResult.getCqId()>
<#assign recordCount = CommonQueryResult.getData()?size>
<#assign CommonQueryConfig = statics["com.huateng.commquery.config.CommonQueryUtil"].getCommonQueryBean(CQId)>
<#assign title = CommonQueryConfig.getAnyValueDefault("title","")>
<#--变量-->
<#assign title = ""> <#--表格标题-->
<#assign rowLine = ""> <#--表格行分割线-->
<#assign headLine = ""> <#--表头行-->
<#assign bodyLine = ""> <#--表体行-->
<#assign rowStartLine = ""><#--表格起始行线-->
<#assign groupStr = "">
<#assign groupTitle="">
<#assign tableTitle="">

<#--　文件查询页面模板定义　
title ：标题栏　,可为空,缺省为通用查询配置的标题
-->
<#macro page>
<#if recordCount != 0>
<#nested/>
<#if tableTitle?length != 0>
	<#assign title = tableTitle>
<#else>
	<#assign title = groupTitle>
</#if>
${title}
<#if groupStr?length !=0>
${groupStr?trim}
</#if>
<#if rowStartLine?length !=0>
${rowStartLine}
</#if>
<#if headLine?length !=0>
${headLine}
</#if>
<#if rowLine?length !=0>
${rowLine}
</#if>
<#if bodyLine?length !=0>
${bodyLine?trim}
</#if>
<#else>
没有符合条件的记录
</#if>
</#macro>



<#--
查询报表:用于返回多条记录的信息展现
使用width表标识域宽度(以字节为单位)
列宽度　＝　max(width , 域描述字节长度)
fieldStr : 需要显示的字段集合，以逗号作为分割符号，字段名必须在通用查询配置中必须有定义，可为空，缺省为所有字段
-->
<#macro DataTable fieldStr="${CommonQueryConfig.toFieldString()}">
<#assign headLine = rowSColumn>
<#assign tableWidth = 0> <#--表格宽度-->
<#assign fldCount = 0> <#--显示域个数-->
<#assign rowEndLine=""><#--表格结束行线-->
<#--获取报表头-->
<#assign tableTitle = CommonQueryConfig.getAnyValueDefault("title","")>
<#--获取字段长度集合-->
<#assign fldLthMap = getFieldLengthMap(CQId,fieldStr)>
<#assign fieldMap = CommonQueryConfig.fields>
<#assign fieldSet = fieldMap.keySet()>
<#assign fieldAry = fieldStr?split(",")>
<#--定义报表宽度-->
<#--获取表头行-->
<#assign fldLth = 0>
<#assign fldCount = 0>
<#assign fldIdSet = fldLthMap?keys>
<#assign fldStat = "F">
<#assign fldDesc = "">
<#assign fldDescLength = 0>
<#assign headSpace = "">
<#assign c = 0>
<#list fieldAry as fId>
	<#assign fldLth = fldLthMap[fId]>
	<#assign field = CommonQueryConfig.getField(fId)>
	<#assign fldStat = field.getAnyValue("status","F")>
	<#assign fldDesc = field.getAnyValue("desc","")>
	<#assign tableWidth = tableWidth + fldLth>
	<#assign fldCount = fldCount + 1>
	<#assign dd = statics["java.lang.String"].valueOf(fldDesc).getBytes()>
	<#assign fldDescLength = dd?size>
	<#assign c = (fldLth - fldDescLength)/2>
	<#assign r = (fldLth - fldDescLength)%2>
	<#if c < 0>
		<#assign c = 0?number>
		<#assign headSpace = "">
	<#else>
		<#assign headSpace = ""?left_pad(c," ")>
	</#if>
	<#if r <= 0>
		<#assign headLine = headLine + headSpace + fldDesc + headSpace  + column>
	<#else>
		<#assign rwap = ""?left_pad(r," ")>
		<#assign headLine = headLine + headSpace + fldDesc + headSpace + rwap + column>
	</#if>
</#list>
<#assign po = headLine?last_index_of(column)>
<#assign headLine = headLine?substring(0,po) + rowSColumn>
<#assign tableWidth =  tableWidth +  2 * 2 + (fldCount - 1) * 2>
<#--生成标题行-->
<#assign dd = statics["java.lang.String"].valueOf(tableTitle).getBytes()>
<#assign titleLength = dd?size>
<#assign c = (tableWidth - titleLength)/2>
<#assign r = (tableWidth - titleLength)%2>
<#if c < 0>
	<#assign c = 0?number>
	<#assign titleSpace = "">
<#else>
	<#assign titleSpace = ""?left_pad(c," ")>
</#if>
<#if r <= 0>
	<#assign tableTitle = titleSpace + tableTitle + titleSpace>
<#else>
	<#assign rwap = ""?left_pad(r," ")>
	<#assign tableTitle = titleSpace + tableTitle + titleSpace + rwap>
</#if>
<#--生成起始行线-->
<#assign rowStartLine = rowStartLineS + ""?left_pad(tableWidth/2-2,rowStartLineM) + rowStartLineE>
<#--生成行分割线-->
<#assign rowLine = rowConS + rowLine?left_pad(tableWidth/2-2,row) + rowConE>
<#--生成结束行线-->
<#assign rowEndLine = rowEndLineS + ""?left_pad(tableWidth/2-2,rowEndLineM) + rowEndLineE>
<#--生成表体行-->
<#assign bodySingleLine = column>
<#list 1..recordCount as i>
<#assign rowData = CommonQueryResult.getRow( i - 1 )>
<#assign rowDataMap = rowData.getRowMap()>
<#assign rowDataSet = rowDataMap?keys>
<#assign bodyLine = bodyLine + rowSColumn>
	<#list fieldAry as fId>
		<#assign field = fieldMap[fId]>
		<#assign rowFieldData = rowDataMap[fId]>
		<#assign fieldVal = rowFieldData.getOpr()?default("")>
		<#assign fieldVal = fieldVal?trim>
		<#assign fieldVal = getFieldValue(field,fieldVal)>
		<#assign dd = statics["java.lang.String"].valueOf(fieldVal).getBytes()>
		<#assign fieldValLength = dd?size>
		<#assign fldLth = fldLthMap[fId]>
		<#assign fStatus = field.getAnyValue("status","F")>
		<#assign fdatatype = field.getAnyValue("datatype","string")>
		<#assign c = fldLth - fieldValLength>
		<#if fdatatype == "string" || fdatatype == "date" || fdatatype == "">
			<#assign bodyLine = bodyLine + fieldVal + ""?left_pad(c," ")+ column>
		<#else>
			<#assign bodyLine = bodyLine + ""?left_pad(c," ") + fieldVal + column>
		</#if>
	</#list>
	<#assign po = bodyLine?last_index_of(column)>
	<#assign bodyLine = bodyLine?substring(0,po)>
	<#if i_has_next>
		<#assign bodyLine = bodyLine +  rowSColumn +'\n' + rowLine + '\n'>
	<#else>
		<#assign bodyLine = bodyLine +  rowSColumn +'\n' + rowEndLine>
	</#if>
</#list>
<#--组装表格-->
</#macro>

<#--
组显示模板：用于显示单条信息
缺省为一行显示两个数据域
单个域可以独立占据一行
支持组合域
fieldStr:需要显示的字段集合(以逗号分割)，不可为空
colNm:显示的列数，一定是２的整数倍，可为空，默认为４
-->
<#macro Group fieldStr="${CommonQueryConfig.toFieldString()}" colNm="4">
	<#--对于Group，只能获取记录集合中第一条的信息-->
	<#--获取报表头-->
	<#assign groupTitle = CommonQueryConfig.getAnyValueDefault("title","")>
	<#assign rowData = CommonQueryResult.getRow(0)>
	<#assign rowDataMap = rowData.getRowMap()>
	<#assign list = statics["com.huateng.view.freemarker.CalGroupLayoutMethod"].exec(fieldStr,CQId,colNm)>
	<#assign ro = list.get(0)>
	<#assign col = list.size()-1>
	<#assign rowNm = ro.getRow()>
	<#assign groupLayoutBean = "">
	<#assign titleWidth = 0>
	<#list 0..rowNm as i>
		<#list 0..col as j>
			<#assign groupLayoutBean = 	list.get(j)>
			<#assign width = groupLayoutBean.getWidth()>
			<#if groupLayoutBean.existedRowField(i?string)>
				<#assign fldId = groupLayoutBean.getRowField(i?string)>
				<#assign field = CommonQueryConfig.getField(fldId)>
				<#assign fieldValue = rowDataMap[fldId].getOpr()?default("")>
				<#assign fieldValue = getFieldValue(field,fieldValue)>
				<#assign desc = field.getAnyValue("desc","")>
				<#assign fdatatype = field.getAnyValue("datatype","string")>
				<#assign dd = statics["java.lang.String"].valueOf(desc).getBytes()>
				<#assign c = width - dd?size>
				<#assign dd = statics["java.lang.String"].valueOf(fieldValue).getBytes()>
				<#assign c = c - dd?size>
				<#if fdatatype == "string" || fdatatype == "date" || fdatatype == "">
					<#assign fieldValue =  fieldValue + ""?left_pad(c," ")>
				<#else>
					<#assign fieldValue = ""?left_pad(c," ") + fieldValue >
				</#if>
				<#assign groupStr = groupStr + desc + " [" +  fieldValue + "] ">
			<#else>
				<#assign c = width + (col-1)*3 + 1>
				<#assign groupStr = groupStr +  ""?left_pad(c," ")>
			</#if>
			<#if i == 0>
				<#assign titleWidth = titleWidth + width>
			</#if>
		</#list>
		<#if i_has_next>
			<#assign groupStr = groupStr + '\n'>
		</#if>
	</#list>
	<#--生成标题行-->
	<#assign dd = statics["java.lang.String"].valueOf(groupTitle).getBytes()>
	<#assign titleLength = dd?size>
	<#assign c = (titleWidth - titleLength)/2>
	<#assign r = (titleWidth - titleLength)%2>
	<#if c < 0>
	<#assign c = 0?number>
	<#assign titleSpace = "">
	<#else>
		<#assign titleSpace = ""?left_pad(c," ")>
	</#if>
	<#if r <= 0>
		<#assign groupTitle = titleSpace + groupTitle + titleSpace>
	<#else>
		<#assign rwap = ""?left_pad(r," ")>
		<#assign groupTitle = titleSpace + groupTitle + titleSpace + rwap>
	</#if>
</#macro>



















<#--数据值转换-->
<#function getFieldValue field fieldVal>
	<#assign fdatatype = field.getAnyValue("datatype","string")>
	<#assign feidttype = field.getAnyValue("edittype","text")>
	<#assign fieldValueNew = fieldVal>
<#switch feidttype>
	<#case "select">
		<#assign translated = field.getAnyValue("translated","")>
		<#if translated?starts_with("DATA_DIC")>
			<#assign fieldValueNew = sysDicVal("DATA_DIC",translated?substring(9),fieldVal)>
		</#if>
    <#break>
    <#default>
    <#break>
</#switch>
<#return fieldValueNew>
</#function>