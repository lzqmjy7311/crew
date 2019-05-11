/*
 * LoginForm.java
 * Created by yuweihua on 2004-10-18
 */
package com.huateng.ebank.business.management.bean;


import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;

import com.huateng.ebank.framework.struts.HTBaseForm;

/**
 * Form bean for the Login main page.  There are two fields on this
 * form used for authentication
 * <ul>
 * <li>username - the username to login
 * <li>password - the password to authenticate
 * </ul>
 */
public final class ChangePwdForm extends HTBaseForm  {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private String tlrno = null;
	private String oldPassWord = null;
	private String newPassWord = null;
	private String againNewPassWord = null;


	/**
	 * Reset all properties to their default values.
	 *
	 * @param mapping The mapping used to select this instance
	 * @param request The servlet request we are processing
	 */
	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		tlrno = null;
		oldPassWord = null;
		newPassWord = null;
		againNewPassWord = null;
	}

	/**
	 * Validate the properties that have been set from this HTTP request,
	 * and return an <code>ActionErrors</code> object that encapsulates any
	 * validation errors that have been found.  If no errors are found, return
	 * <code>null</code> or an <code>ActionErrors</code> object with no
	 * recorded error messages.
	 *
	 * @param mapping The mapping used to select this instance
	 * @param request The servlet request we are processing
	 */
	@Override
	public ActionErrors validate(ActionMapping mapping,
								 HttpServletRequest request) {
		ActionErrors errors = new ActionErrors();
		return (errors);
	}
	
	/**
	 * @return
	 */
	public String getOldPassWord() {
		return oldPassWord;
	}

	/**
	 * @return
	 */
	public String getNewPassWord() {
		return newPassWord;
	}

	/**
	 * @return
	 */
	public String getAgainNewPassWord() {
		return againNewPassWord;
	}

	public String getTlrno() {
		return tlrno;
	}
	
	/**
	 * @param string
	 */
	public void setOldPassWord(String string) {
		oldPassWord = string;
	}

	/**
	 * @param string
	 */
	public void setNewPassWord(String string) {
		newPassWord = string;
	}

	/**
	 * @param string
	 */
	public void setAgainNewPassWord(String string) {
		againNewPassWord = string;
	}
	
	
	public void setTlrno(String tlrno) {
		this.tlrno = tlrno;
	}

}

