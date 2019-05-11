<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign forceChange = statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstance().isPswdForcedToChange()?default(false)>
<#assign pswdStrength = statics["com.huateng.ebank.business.common.service.CommonService"].getInstance().getSysParamDef("PSWD", "PSWD_STRENGTH", "2")>
<#assign pswdLimit = statics["com.huateng.ebank.business.common.service.CommonService"].getInstance().getSysParamDef("PSWD", "LIMIT", "6")>
<#assign pswdComplexity = statics["com.huateng.ebank.business.common.service.CommonService"].getInstance().getSysParamDef("PSWD", "COMPLEXITY", "1111")>
<#assign type=RequestParameters["type"]?default("")>
<@CommonQueryMacro.page title="操作员密码修改">
<style>
	.password-strength span{
		height:15px;
		width:30px;
		background-color:#eeeeee;
		display:inline-block;
	}
</style>
<@CommonQueryMacro.CommonQuery id="changePwd">
<table width="600">
<tr>
<td>
			<@CommonQueryMacro.Group id="group1" label="操作员密码修改" fieldStr="oldPassWord,newPassWord,againNewPassWord" colNm=2/>
</td>
</tr>
<tr>
<td align="center">
			<@CommonQueryMacro.Button id= "btSave"/>
</td>
</tr>
</table>
<#-- add by zhaozhiguo BMS-3153 begin -->
<span id="strengthtshow" class="password-strength"><span id="strength_L"></span><span id="strength_M"></span><span id="strength_H"></span><code id="strength_text"></code></span>
<#-- add by zhaozhiguo BMS-3153 end -->
</@CommonQueryMacro.CommonQuery>
<script language="JavaScript">
function initCallGetter_post(){
<#if forceChange>
	if (window.self == window.top) {
		easyMsg.warn('您的初始密码未更改或已超过间隔期,请重新更改密码！',{title:"警告"});
	}
</#if>
	$('#editor_newPassWord').parent().append($('#strengthtshow')); 
}
function btSave_postSubmit(){
	//changePwd_dataset.flushData(1);
    //alert("密码修改成功!");
}
/* add by zhaozhiguo BMS-3153 begin */
//测试某个字符是属于哪一类. 
function charMode(ch){ 
	if (ch>=48 && ch <=57) {//数字 
		return 1; 
	} else if (ch>=65 && ch <=90) {//大写字母 
		return 2; 
	} else if (ch>=97 && ch <=122) {//小写字母 
		return 4; 
	} else {//特殊字符 
		return 8; 
	}
}
//计算出当前密码当中一共有多少种模式 
function bitTotal(num){ 
	modes=0; 
	for (i=0;i<4;i++){ 
		if (num & 1) modes++; 
		num>>>=1; 
	} 
	return modes; 
} 
//返回密码的强度级别
function checkStrong(pwd){ 
	if (pwd.length<${pswdLimit}) {//密码太短 
		return 0; 
	}
	modes=0; 
	for (i=0;i<pwd.length;i++){ 
		modes|=charMode(pwd.charCodeAt(i)); 
	} 
	return bitTotal(modes); 
} 

function getComplexity(pwd) {
	var modes=0; 
	for (i=0;i<pwd.length;i++){ 
		modes|=charMode(pwd.charCodeAt(i)); 
	}
	return modes;
}
function checkComplexity(pwd) {
	var pswdComplexity = parseInt('${pswdComplexity}',2);
	var complex = getComplexity(pwd);
	if(pswdComplexity&complex!=pswdComplexity) {
		var msg = "必须包含";
		var num = 1;
		do {
			switch(pswdComplexity & num){
				case 1: msg += "[数字]";break;
				case 2: msg += "[大写字母]";break;
				case 4: msg += "[小写字母]";break;
				case 8: msg += "[特殊字符]";break;
				default:break;
			}
			num <<= 1;
		} while(num < 9);
		alert(msg);
		return false;
	}
	return true;
}

function pwdStrength(pwd){ 
	O_color="#eeeeee"; 
	L_color="#FF0000"; 
	M_color="#FF9900"; 
	H_color="#33CC00"; 
	if (pwd==null||pwd==''){ 
		Lcolor=Mcolor=Hcolor=O_color; 
	} else{ 
		S_level=checkStrong(pwd); 
		switch(S_level) { 
			case 0: 
				Lcolor=Mcolor=Hcolor=O_color;
				break;
			case 1: 
				Lcolor=L_color; 
				Mcolor=Hcolor=O_color; 
				break; 
			case 2: 
				Lcolor=Mcolor=M_color; 
				Hcolor=O_color; 
				break; 
			default: 
				Lcolor=Mcolor=Hcolor=H_color; 
		} 
	} 
	$('#strength_L').css('background-color',Lcolor);
	$('#strength_M').css('background-color',Mcolor);
	$('#strength_H').css('background-color',Hcolor);
	return; 
}
<#if forceChange>
function btSave_postSubmit(button) {
	if (window.self == window.top) {
		changePwd_dataset.setReadOnly(true);
		btSave.disable(true);
		alert("密码更改成功,请重新登陆!");
		button.url="/custlogout.do?relogin=true";
	}
}
</#if>
function btSave_onClickCheck(button) {
	var newPasswd = changePwd_dataset.getValue("newPassWord");
	if (newPasswd!=''&& checkStrong(newPasswd) < parseInt('${pswdStrength}')) {
		var msg = '';
		if ('${pswdStrength}' == '1') 
			msg = '至少输入${pswdLimit}位字符';
		else if ('${pswdStrength}' == '2') 
			msg = '至少输入${pswdLimit}位字符,且至少包含两种类型的字符';
		else if ('${pswdStrength}' == '3') 
			msg = '至少输入${pswdLimit}位字符,且至少包含三种类型的字符';
		
		alert("您输入的密码强度太弱，请重新输入！("+msg+")");
		return false;
	}

	if(!checkComplexity(newPasswd)) {
		return false;
	}
	
	var newPasswdSure = changePwd_dataset.getValue("againNewPassWord");
	if(newPasswd!=newPasswdSure){
		alert("两次输入的新密码不相同");
		return false;
	}
	return true;
	
}
function editor_newPassWord_onSetValue() {
	var foo = $('#editor_newPassWord').val();
	pwdStrength(foo);
}
/* add by zhaozhiguo BMS-3153 end */
</script>
</@CommonQueryMacro.page>