package com.gbicc.bpm.servlet;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gbicc.bpm.service.ProcessManagerService;

public class ProcessDiagramServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ProcessDiagramServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			String key=request.getParameter("key");
			String version=request.getParameter("version");
			String flag=request.getParameter("flag");
			String executionId=request.getParameter("executionId");
			ProcessManagerService managerService=ProcessManagerService.getInstace();
			InputStream is=null;
			if(flag.equals("deploy")){
				is=managerService.viewDefinitionDiagram(key, version);
			}else{
				is=managerService.viewRunTimeDiagram(executionId);
			}
			response.setContentType("image/png");
			BufferedInputStream bis=new BufferedInputStream(is);
			OutputStream output=response.getOutputStream();
			BufferedOutputStream bos=new BufferedOutputStream(output);
			byte data[]=new byte[4096];
			int size=0;
			size=bis.read(data);
			while(size!=-1){
				bos.write(data,0,size);
				size=bis.read(data);
			}
			bis.close();
			bos.flush();
			bos.close();
			output.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
