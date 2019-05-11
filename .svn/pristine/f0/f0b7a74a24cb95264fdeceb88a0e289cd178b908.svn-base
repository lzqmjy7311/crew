<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign switch = statics["com.huateng.ebank.business.common.service.CommonService"].getInstance().getSysParamDef("SYS", "SWITCH_RUNNING", "0")>
<#if switch=="0">
<div style="padding-left:8px;line-height:35px;color:red;font-size:12px;">
	请打开系统参数['SYS','SWITCH_RUNNING']设置为1，并重新启动应用。
</div>
<#else>
<@CommonQueryMacro.page title="demo_field">
	<div style="padding-left:8px;line-height:35px;color:#336699;font-size:12px;">
	微交换与FP配置使用，详细参考FP开发手册(2.4版本),配置位于WEB-INF/switch下。
	</div>
	<@CommonQueryMacro.DynamicTabSet id="demo_field_tabs" hasMenu="true" height="600px" selected="tab1">
		<@CommonQueryMacro.DynamicTab id="tab1" title="添加" url="/demo/ftl/switch_add.ftl?type=add"> 
		</@CommonQueryMacro.DynamicTab>
		<@CommonQueryMacro.DynamicTab id="tab2" title="查询" url="/demo/ftl/switch_query.ftl?type=query"> 
		</@CommonQueryMacro.DynamicTab>
	</@CommonQueryMacro.DynamicTabSet>
</@CommonQueryMacro.page>
</#if>