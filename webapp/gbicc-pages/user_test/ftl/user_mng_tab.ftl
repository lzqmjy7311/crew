<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<@CommonQueryMacro.page title="������Ϣ����  &gt;  �û�">
<@CommonQueryMacro.CommonQuery id="LikmUser" init="false" submitMode="current">
<@CommonQueryMacro.Group id="group1" label="" colNm=4 fieldStr="userName,userDesc" />
</@CommonQueryMacro.CommonQuery>
</@CommonQueryMacro.page>