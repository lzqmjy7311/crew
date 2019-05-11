package com.huateng.ebank.business.remote;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Servlet implementation class TokenCheckServlet
 */
public class TokenCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static Log log = LogFactory.getLog(TokenCheckServlet.class);   
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TokenCheckServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			String tokenId = request.getParameter("tokenId");
			String sessionId = request.getParameter("sessionId");
			
			String result = new TokenCheckUtil().check(sessionId, tokenId);
				
			writeResult(response,result);
			return;
			
		}catch(Exception e){
			log.info(e);
			writeResult(response,"222");
			return;
		}
	}

	private  static void writeResult(HttpServletResponse response,String result) throws IOException{
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		try {
			response.getWriter().write(result);
		} catch (IOException e) {
			log.info(e);
			throw e;
		}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
