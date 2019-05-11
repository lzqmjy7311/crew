<#-- 文本输入框 -->
<#macro textinput textinputlabel id name value>
    <label>${textinputlabel}:</label>
    <input value="${value}" id="${id}" name="${name}" size="30" type="text" />
</#macro>

<#-- 密码输入框 -->
<#macro password passwordlabel name id value size maxlength>
    <label>${passwordlabel}：</label>
    <input type="password" name=${name} value="${value}" id="${id}" size="${size}" maxlength="${maxlength}"/>
</#macro>

<#-- 隐藏输入框 -->
<#macro texthidden id name value>
<input type="hidden" name="${name}" value="${value}" id="${id}" class="textinput"/></label>
</#macro>

<#-- 图片按钮 -->
<#macro commonbutton id href imgsrc>
    <a href="${href}"><img src="${imgsrc}" id="${id}></a>
</#macro>

<#-- 重置按钮 -->
<#macro buttonresetI buttonlabel name id>
    <input type="reset" name="${name}" value="${buttonlabel}" id="${id}" />
</#macro>

<#-- 提交按钮 -->
<#macro buttonsubmitI buttonlabel name id>
    <input type="submit" name="${name}" value="${buttonlabel}" id="${id}" />
</#macro>

<#-- 标题 -->
<#macro label label>        
<font class="label">${label}</font>
<hr noshade color="#B9BEC1" size=1 width=98% align="center">
</#macro>

<#-- 文本输入区域 -->
<#macro textarea textarealabel id name textareaid value colnum rownum>
<div class="centerlabel" id="${id}">
${textarealabel}：
</div>
<div>
<textarea name="${name}" value="${value}" id="${textareaid}" class="textarea" cols="${colnum}" rows="${rownum}"/>
</div>
</#macro>

