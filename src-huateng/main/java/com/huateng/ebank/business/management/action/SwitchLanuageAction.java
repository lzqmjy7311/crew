package com.huateng.ebank.business.management.action;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.Globals;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.huateng.ebank.framework.util.DataFormat;
import com.huateng.ebank.framework.web.struts.BaseAction;

/**  
 * <P>Filename:    SwitchLanuageAction.java  
 * <P>Description: TODO 
 * <P>Copyright:   Copyright (c)2008
 * <P>Company:     Shanghai Huateng Software Systems Co., Ltd.  
 * @author         shen_antonio  
 * @version      
 * Create at:      2011-12-18 下午5:13:33  
 * <P>Modification History:  
 * <PRE>Date         Author      Version     Description</PRE> 
 * <P>------------------------------------------------------------------  
 * <PRE>2011-12-18   y.nie      1.0         1.0 Version    </PRE>
 */ 
public class SwitchLanuageAction extends BaseAction {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
			String language = request.getParameter("language");
			String country = request.getParameter("country");
			if (!DataFormat.isEmpty(language) && !DataFormat.isEmpty(country)) {
				Locale newLocale = new Locale(language, country);
				request.getSession().setAttribute(Globals.LOCALE_KEY, newLocale);
			}
			return mapping.getInputForward();
	}
}
