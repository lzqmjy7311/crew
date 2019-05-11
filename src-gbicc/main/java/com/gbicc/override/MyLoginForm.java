package com.gbicc.override;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;

import com.huateng.ebank.framework.security.SimpleEnc;
import com.huateng.ebank.framework.struts.HTBaseForm;

/**
 * 重写LoginForm
 * @date    2016年1月5日
 * @author  tangdu
 * @desc
 */
public class MyLoginForm extends HTBaseForm {
	private static final long serialVersionUID = 3548284129280393454L;
	private String userName = null;//用户 名
	private String passWord = null;//密码
	private String brCode = null;//核心机构号
	private String secret = null;//签名
	private String source = null;//c为对公p为对私
	
	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}

	public String getBrCode() {
		return brCode;
	}

	public void setBrCode(String brCode) {
		this.brCode = brCode;
	}

	public String getUserName() {
		return (userName);
	}

	public String getPassWord() {
		if (passWord != null) {
			try {
				return new String(new SimpleEnc().decrypt(passWord, null));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return (passWord);
	}

	public void setUserName(String newUserName) {
		userName = newUserName;
	}

	public void setPassWord(String newPassWord) {
		passWord = newPassWord;
	}

	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		userName = null;
		passWord = null;
	}

	@Override
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		ActionErrors errors = new ActionErrors();
		return (errors);
	}
}
