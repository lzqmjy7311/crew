<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="用户登录日志查询">
<#assign cctype="${RequestParameters['type']?default('')}" />
<@CommonQueryMacro.CommonQuery id="GridCacheCount" init="true" submitMode="selected" navigate="false" cacheCount="${cctype}">
<table align="left" width="80%">
	<tr>
		<td>
			<@CommonQueryMacro.DataTable id ="datatable1" fieldStr="tlrNo,brNo,loginAddr,loginSucTm[160],loginOutTm,loginFailTm,loginRemark" readonly="true" width="100%"  hasFrame="true" height="400"/></br>
		</td>
	</tr>
	<tr>
		<td style="color:red;line-height:24px">
			以用户登录日志表查询为示例
			<ul>
				<li>cacheCount="ALLWAYS" 表示：不需要总行数和总页数</li>
				<li>cacheCount="ONCE" 表示：仅第一次查询需要总页数并缓存，之后都不需要计算总页数</li>
				<li>cacheCount=""或不设置  表示：每次查询总行数和总页数</li>
			</ul>
		</td>
	</tr>
</table>
</@CommonQueryMacro.CommonQuery>
</@CommonQueryMacro.page>
