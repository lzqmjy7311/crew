<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
	<@CommonQueryMacro.CommonQuery id="GridFields" init="true" submitMode="current" navigate="false">
		<@CommonQueryMacro.DataTable id="demodatatabale" fitColumns="false" frozens="2" paginationbar="" height="" width="" />
	</@CommonQueryMacro.CommonQuery>