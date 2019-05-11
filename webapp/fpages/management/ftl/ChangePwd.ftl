<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign forceChange = statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstance().isPswdForcedToChange()?default(false)>
<#assign pswdStrength = statics["com.huateng.ebank.business.common.service.CommonService"].getInstance().getSysParamDef("PSWD", "PSWD_STRENGTH", "2")>
<#assign pswdLimit = statics["com.huateng.ebank.business.common.service.CommonService"].getInstance().getSysParamDef("PSWD", "LIMIT", "6")>
<#assign pswdComplexity = statics["com.huateng.ebank.business.common.service.CommonService"].getInstance().getSysParamDef("PSWD", "COMPLEXITY", "1111")>
<#assign type=RequestParameters["type"]?default("")>
<@CommonQueryMacro.page title="����Ա�����޸�">
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
			<@CommonQueryMacro.Group id="group1" label="����Ա�����޸�" fieldStr="oldPassWord,newPassWord,againNewPassWord" colNm=2/>
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
		easyMsg.warn('���ĳ�ʼ����δ���Ļ��ѳ��������,�����¸������룡',{title:"����"});
	}
</#if>
	$('#editor_newPassWord').parent().append($('#strengthtshow')); 
}
function btSave_postSubmit(){
	//changePwd_dataset.flushData(1);
    //alert("�����޸ĳɹ�!");
}
/* add by zhaozhiguo BMS-3153 begin */
//����ĳ���ַ���������һ��. 
function charMode(ch){ 
	if (ch>=48 && ch <=57) {//���� 
		return 1; 
	} else if (ch>=65 && ch <=90) {//��д��ĸ 
		return 2; 
	} else if (ch>=97 && ch <=122) {//Сд��ĸ 
		return 4; 
	} else {//�����ַ� 
		return 8; 
	}
}
//�������ǰ���뵱��һ���ж�����ģʽ 
function bitTotal(num){ 
	modes=0; 
	for (i=0;i<4;i++){ 
		if (num & 1) modes++; 
		num>>>=1; 
	} 
	return modes; 
} 
//���������ǿ�ȼ���
function checkStrong(pwd){ 
	if (pwd.length<${pswdLimit}) {//����̫�� 
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
		var msg = "�������";
		var num = 1;
		do {
			switch(pswdComplexity & num){
				case 1: msg += "[����]";break;
				case 2: msg += "[��д��ĸ]";break;
				case 4: msg += "[Сд��ĸ]";break;
				case 8: msg += "[�����ַ�]";break;
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
		alert("������ĳɹ�,�����µ�½!");
		button.url="/custlogout.do?relogin=true";
	}
}
</#if>
function btSave_onClickCheck(button) {
	var newPasswd = changePwd_dataset.getValue("newPassWord");
	if (newPasswd!=''&& checkStrong(newPasswd) < parseInt('${pswdStrength}')) {
		var msg = '';
		if ('${pswdStrength}' == '1') 
			msg = '��������${pswdLimit}λ�ַ�';
		else if ('${pswdStrength}' == '2') 
			msg = '��������${pswdLimit}λ�ַ�,�����ٰ����������͵��ַ�';
		else if ('${pswdStrength}' == '3') 
			msg = '��������${pswdLimit}λ�ַ�,�����ٰ����������͵��ַ�';
		
		alert("�����������ǿ��̫�������������룡("+msg+")");
		return false;
	}

	if(!checkComplexity(newPasswd)) {
		return false;
	}
	
	var newPasswdSure = changePwd_dataset.getValue("againNewPassWord");
	if(newPasswd!=newPasswdSure){
		alert("��������������벻��ͬ");
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