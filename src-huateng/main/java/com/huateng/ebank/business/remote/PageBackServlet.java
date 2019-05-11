package com.huateng.ebank.business.remote;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.huateng.ebank.business.common.MapUtil;
import com.huateng.ebank.business.common.TransferConstant;
import com.huateng.ebank.framework.util.encrypt.Base64URLEncode;

/**
 * Servlet implementation class PageBackServlet
 */
public class PageBackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(PageBackServlet.class); 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PageBackServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("ERROR. PageBackServlet's doGet is not used.");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String value_map= request.getParameter("_"+TransferConstant.SEND_VALUE_MAP);
		value_map = base64Process(value_map,request,response);
//		
		HashMap m = MapUtil.string2HashMap(value_map);
		String url = m.get("URL").toString();
		String sessionId = m.get("sessionId").toString();
		String tokenId = m.get("tokenId").toString();
		String result = new TokenCheckUtil().check(sessionId, tokenId);
		if(!result.equals("200")){
			this.go2ErrorPage(request, response);
			return;
		}
		if(!url.startsWith("/")){
			url = "/"+url;
		}
		request.setAttribute(TransferConstant.SEND_VALUE_MAP, m);
		request.getRequestDispatcher(url).forward(
				request, response);
	
	}
	/**
	 * 解密。出错会跳转到出错页面
	 * @param str
	 * @param request
	 * @param response
	 * @return
	 */
	private String base64Process(String str,HttpServletRequest request,
			HttpServletResponse response){
		String result=null;
		try {
			result = Base64URLEncode.byBase64Descode(str);
		} catch (Exception e) {
			logger.info(e);
			go2ErrorPage(request,response);
		}
		return result;
	}
	//出错时处理。
	private void go2ErrorPage(HttpServletRequest req,
			HttpServletResponse resp){
		try{
			resp.setHeader("Pragma", "No-cache");
			resp.setHeader("Cache-Control", "no-cache,no-store,max-age=0");
			resp.setDateHeader("Expires", 1);
			RequestDispatcher rd = ((HttpServletRequest) req)
					.getRequestDispatcher("/common/error.jsp");
			rd.forward(req, resp);   
		}
		catch(Exception e){
			logger.info(e);
		}
	}

}
