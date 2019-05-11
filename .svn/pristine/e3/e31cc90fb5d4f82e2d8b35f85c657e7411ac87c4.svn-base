package com.huateng.ebank.business.remote;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.remote.base.RemoteSysMap;
import com.huateng.ebank.business.remote.base.SessionFactory;

/**
 * Servlet implementation class PortalMenuServlet
 */
public class PortalMenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String SYS_MENU_PATH = "/FPPortal/menu";

	private static Log log = LogFactory.getLog(PortalMenuServlet.class);

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PortalMenuServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		// 判断session是否过期
		if (session == null) {
			log.info("session is null");
			go2TimeOutPage(request,response);
			return;
		}

		GlobalInfo gd = (GlobalInfo) session
				.getAttribute(GlobalInfo.KEY_GLOBAL_INFO);
		String sessionId = session.getId();

		if (gd == null) {
			log.info("GlobalInfo is null");
			go2TimeOutPage(request,response);
			return;
		}
		String tokenId = gd.getTokenId();
		if (tokenId == null) {// 第一次请求menu,设置tokenInfo

			gd.setTokenId(UUID.randomUUID().toString());

		} else {
			// tokenId存在，则重设置tokenId
			gd.setTokenId(UUID.randomUUID().toString());
		}

		String requestURL = request.getRequestURI();
		String queryStr = request.getQueryString();
		log.info("queryStr:" + queryStr);
		log.info("requestURL:" + requestURL);

		requestURL = requestURL.replaceAll(this.SYS_MENU_PATH, "");

		String sysContextPath = requestURL.split("/")[1];
		log.info("sysContextPath is :" + sysContextPath);
		String sendUrl = RemoteSysMap.getValue(sysContextPath);// 提交的url

		requestURL = requestURL.replace("/" + sysContextPath, "");// 去掉context
																	// path

		String url;// 应用菜单的url
		if (queryStr == null) {
			url = requestURL;
		} else
			url = requestURL + "?" + queryStr;
		log.info("url is:" + url);
		log.info("url sendUrl is:" + sendUrl);

		SessionFactory.getInstance().saveSession(sessionId, session);

		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher("/send.jsp");

		request.setAttribute("_URL", url);
		request.setAttribute("_sendUrl", sendUrl);

		
		
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	
	private void go2TimeOutPage(HttpServletRequest req,
			HttpServletResponse resp) throws ServletException, IOException {
		
			resp.setHeader("Pragma", "No-cache");
			resp.setHeader("Cache-Control", "no-cache,no-store,max-age=0");
			resp.setDateHeader("Expires", 1);
			resp.sendRedirect("/common/expired.jsp");
	}
}
