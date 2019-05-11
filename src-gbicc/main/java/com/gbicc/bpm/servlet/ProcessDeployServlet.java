package com.gbicc.bpm.servlet;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.gbicc.bpm.service.ProcessManagerService;
import com.gbicc.common.FileTools;
import com.gbicc.common.FileUpDownProperties;
import com.huateng.ebank.framework.util.DateUtil;

public class ProcessDeployServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ProcessDeployServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

	@SuppressWarnings("rawtypes")
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		FileItemFactory diskFileItemFactory=new DiskFileItemFactory();
		ServletFileUpload diskFileUpload=new ServletFileUpload(diskFileItemFactory);
		try {
			String rootPath = FileUpDownProperties.readValue("rootPath");
			String projectPath = FileUpDownProperties.readValue("projectPath");
			String tempPath = FileUpDownProperties.readValue("tempPath");
			// 日期串
			String dateString = DateUtil.dateToNumber(new Date());// yyyyMMdd
			String year = dateString.substring(0, 4);
			String md = dateString.substring(4);
			String fileRealPath = rootPath + File.separator + projectPath + File.separator + tempPath
					+ File.separator + year + File.separator + md
					+ File.separator ;// 文件真实路径,以文件分隔符结尾
			FileTools.createFolder(fileRealPath);// 创建目录
			List items=diskFileUpload.parseRequest(request);
			Iterator it=items.iterator();
			String deployPath="";
			while(it.hasNext()){
				FileItem item=(FileItem) it.next();
				if(item.getName()!=null && item.getName()!=""){
					String fileName=new String(item.getName());
					deployPath=fileRealPath+fileName;
					File file=new File(fileRealPath+fileName);
					byte dt[]=item.get();
					org.apache.commons.io.FileUtils.writeByteArrayToFile(file, dt);
				}
			}
			ProcessManagerService pms=ProcessManagerService.getInstace();
			pms.deploy(deployPath);
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
	}
}
