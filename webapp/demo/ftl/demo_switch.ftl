<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign switch = statics["com.huateng.ebank.business.common.service.CommonService"].getInstance().getSysParamDef("SYS", "SWITCH_RUNNING", "0")>
<#if switch=="0">
<div style="padding-left:8px;line-height:35px;color:red;font-size:12px;">
	���ϵͳ����['SYS','SWITCH_RUNNING']����Ϊ1������������Ӧ�á�
</div>
<#else>
<@CommonQueryMacro.page title="demo_field">
	<div style="padding-left:8px;line-height:35px;color:#336699;font-size:12px;">
	΢������FP����ʹ�ã���ϸ�ο�FP�����ֲ�(2.4�汾),����λ��WEB-INF/switch�¡�
	</div>
	<@CommonQueryMacro.DynamicTabSet id="demo_field_tabs" hasMenu="true" height="600px" selected="tab1">
		<@CommonQueryMacro.DynamicTab id="tab1" title="���" url="/demo/ftl/switch_add.ftl?type=add"> 
		</@CommonQueryMacro.DynamicTab>
		<@CommonQueryMacro.DynamicTab id="tab2" title="��ѯ" url="/demo/ftl/switch_query.ftl?type=query"> 
		</@CommonQueryMacro.DynamicTab>
	</@CommonQueryMacro.DynamicTabSet>
</@CommonQueryMacro.page>
</#if>