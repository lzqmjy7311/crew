package com.gbicc.rule.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gbicc.rule.service.RuleCallResult;
import com.gbicc.rule.service.TRulDefinitionService;

/**
 * Servlet调用接口
 * @date    2015年10月10日
 * @author  tangdu
 * @desc
 */
public class RuleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger logger=LoggerFactory.getLogger(RuleServlet.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("GBK");
		resp.setCharacterEncoding("GBK");
		final String _rulecode="rulecode";
		final String _rowdate="rowdate";
		String rulecode=req.getParameter(_rulecode);
		String rowdate=req.getParameter(_rowdate);
		logger.debug("----------"+_rulecode);
		
		boolean isSynchronize=true;//默认异步
		if(req.getParameter("isSynchronize")!=null){
			isSynchronize=Boolean.valueOf(req.getParameter("isSynchronize"));
		}
		Enumeration<String> names=req.getParameterNames();
		Map<String,String> ext_params=new HashMap<String, String>();
		while(names.hasMoreElements()){
			String name=names.nextElement();
			if(!_rulecode.equalsIgnoreCase(name)){
				ext_params.put(name, req.getParameter(name));
			}
		}
		RuleCallResult result=TRulDefinitionService
					.getInstance().runRule(rulecode, ext_params, isSynchronize);
		PrintWriter printWriter=resp.getWriter();
		if(result.isSuccess()){//如果调用类不出错，则返回执行ID
			printWriter.write(result.getExecid());
		}else{
			printWriter.write("");
		}
	}
	
}
