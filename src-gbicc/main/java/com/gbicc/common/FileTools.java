package com.gbicc.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
/**
  * 
  * @ClassName: FileTools 
  * @Description: 处理上传下载过程中的文件操作
  * @author Distiny Chen
  * @date 2014-7-25 上午10:41:31 
  *
 */
public class FileTools {
	/**
	  * 
	  * @Title: createFolder 
	  * @Description: 创建文件夹
	  * @param @param path 设定文件 
	  * @return void 返回类型 
	  * @date 2014-7-25 上午10:42:44 
	  * @throws
	 */
	public static void createFolder(String path){
		try{
			File file=new File(path);
			if((!file.isDirectory())||(!file.exists())){
				file.mkdirs();
			}
		}catch(SecurityException e){
			System.out.println("创建文件夹失败，请检查文件路径！");
		}
	}
	/**
	  * 
	  * @Title: saveFile 
	  * @Description: copy 文件到指定目录,把readFile写入到copy到完整路径writeFilePath
	  * @param @param readFile ，有内容的File
	  * @param @param writeFilePath 设定文件 ，一个带后缀的完整路径
	  * @return void 返回类型 
	  * @date 2014-7-25 上午10:44:08 
	  * @throws
	 */
	public static void saveFile(File readFile,String writeFilePath){
		 File writeFile = new File(writeFilePath);//最终形成的文件
		 if(!writeFile.getParentFile().exists()){//检查文件所属文件夹是否存在
			 writeFile.getParentFile().mkdirs();
		 }
		 FileInputStream fis = null;//文件读取流
		 FileOutputStream fos = null;//文件写入流
		 try {
			fis = new FileInputStream(readFile);//构建流
	        fos = new FileOutputStream(writeFile);

	        byte[] bs = new byte[1024];
	        int len = -1;
	        while ((len = fis.read(bs)) != -1) {
	            fos.write(bs, 0, len);//文件写入
	        }
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{//关闭资源
			if(null!=fis){
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(null!=fos){
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	/**
	 * 把流组装成file
	  * @Title: inputStreamToFile 
	  * @Description: TODO
	  * @param @param ins
	  * @param @param file
	  * @param @return 设定文件 
	  * @return File 返回类型 
	  * @date 2014-7-28 下午4:52:29 
	  * @throws
	 */
	public static File inputStreamToFile(InputStream ins, File file) {
		OutputStream os = null;
		try {
			os = new FileOutputStream(file);
			int bytesRead = 0;
			byte[] buffer = new byte[8192];
			while ((bytesRead = ins.read(buffer, 0, 8192)) != -1) {
				os.write(buffer, 0, bytesRead);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (null != os) {
				try {
					os.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (null != ins) {
				try {
					ins.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return file;
	}
	/**
	  * 删除文件
	  * @Title: deleteFile 
	  * @Description: TODO
	  * @param @param filePath 设定文件 
	  * @return void 返回类型 
	  * @date 2014-8-5 下午4:09:29 
	  * @throws
	 */
	public static void  deleteFile(String filePath){
		File file=new File(filePath);
		if(file.exists()){
			file.delete();
		}
	}
	/**
	 * 获取提交的表单中的文件类型域并返回文件列表
	  * @Title: getListFile 
	  * @Description: TODO
	  * @param @param request
	  * @param @param response
	  * @param @return 设定文件 
	  * @return List<File> 返回类型 
	  * @date 2014-7-28 下午4:53:06 
	  * @throws
	 */
	public static List<File> getListFile(HttpServletRequest request, HttpServletResponse response){
			List<File> result=new ArrayList<File>();
		  	String tempPath =FileUpDownProperties.readValue("fileTemp");
		  	createFolder(tempPath);
		  	DiskFileItemFactory factory = new DiskFileItemFactory();  
	        //最大缓存  
	        //factory.setSizeThreshold(5*1024);  
	        //设置临时文件目录  
	        factory.setRepository(new File(tempPath));  
	        ServletFileUpload upload = new ServletFileUpload(factory);  
	        upload.setHeaderEncoding("UTF-8");//
	        try {
				List<FileItem> items = upload.parseRequest(request);
				for (FileItem item : items) {
					if (!item.isFormField()) {// 是否为文件上传域
						File file = new File(item.getName());
						try {
							file = inputStreamToFile(item.getInputStream(), file);
							result.add(file);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							//e.printStackTrace();
						}
					}
				}
			} catch (FileUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
		return result;
	}
	/**
	 * 获取表单中的Item
	  * @Title: getListFileItems 
	  * @Description: TODO
	  * @param @param request
	  * @param @param response
	  * @param @return 设定文件 
	  * @return List<FileItem> 返回类型 
	  * @date 2014-7-28 下午4:53:56 
	  * @throws
	 */
	public static List<FileItem> getListFileItems(HttpServletRequest request, HttpServletResponse response){
		List<FileItem> items=new ArrayList<FileItem>();
	  	String tempPath =FileUpDownProperties.readValue("fileTemp");
	  	createFolder(tempPath);
	  	DiskFileItemFactory factory = new DiskFileItemFactory();  
        //最大缓存  
        //factory.setSizeThreshold(5*1024);  
        //设置临时文件目录  
        factory.setRepository(new File(tempPath));  
        ServletFileUpload upload = new ServletFileUpload(factory);  
        try {
			items = upload.parseRequest(request);
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	return items;
	}
	/**
	 * 获取表单的内容组装成 Map<String,FileItem>
	  * @Title: getMapFileItems 
	  * @Description: TODO
	  * @param @param request
	  * @param @param response
	  * @param @return 设定文件 
	  * @return Map<String,FileItem> 返回类型 
	  * @date 2014-7-28 下午5:05:49 
	  * @throws
	 */
	public static Map<String,FileItem> getMapFileItems(HttpServletRequest request, HttpServletResponse response){
		Map<String,FileItem> mapResult=new HashMap<String,FileItem>();
		List<FileItem> items=new ArrayList<FileItem>();
	  	String tempPath =FileUpDownProperties.readValue("fileTemp");
	  	createFolder(tempPath);
	  	DiskFileItemFactory factory = new DiskFileItemFactory();  
        //最大缓存  
        //factory.setSizeThreshold(5*1024);  
        //设置临时文件目录  
        factory.setRepository(new File(tempPath));  
        ServletFileUpload upload = new ServletFileUpload(factory);  
        try {
			items = upload.parseRequest(request);
			for(int i=0;i<items.size();i++){
				mapResult.put(items.get(i).getFieldName(), items.get(i));
			}
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
        return mapResult;
	}

	/**
	 * 解析后返回错误文件
	 * 
	 * @param file
	 * @param response
	 */
	public static void getResponseResult(HttpServletRequest request,
			HttpServletResponse response, XSSFWorkbook workbook) {
		OutputStream os = null;
		try {
			// 以流的形式下载文件。
			os = response.getOutputStream();
			// 清空response
			response.reset();
			if (workbook == null) {
				return;
			}
			String fileName = "错误信息";
			XSSFSheet sheet = workbook.getSheetAt(0);
			if (sheet != null) {
				fileName = sheet.getSheetName();
			}
			// 设置response的Header
			if (request.getHeader("User-Agent").toLowerCase()
					.indexOf("firefox") > 0) {

				fileName = new String(fileName.getBytes("UTF-8"), "ISO8859-1");// firefox浏览器
			} else if (request.getHeader("User-Agent").toUpperCase().indexOf(
					"MSIE") > 0) {
				fileName = URLEncoder.encode(fileName, "UTF-8");// IE浏览器
			}
			response.addHeader("Content-Disposition", "attachment;filename="
					+ fileName + ".xlsx");
			response.setContentType("application/octet-stream");
			workbook.write(os);
		} catch (Exception e) {
		} finally {
			try {
				if (os != null) {
					os.flush();
					os.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
	
	
	/**
	 * 解析后返回错误文件
	 * 
	 * @param file
	 * @param response
	 */
	public static void getResponseResult(HttpServletRequest request,
			HttpServletResponse response, HSSFWorkbook workbook) {
		OutputStream os = null;
		try {
			// 以流的形式下载文件。
			os = response.getOutputStream();
			// 清空response
			response.reset();
			if (workbook == null) {
				return;
			}
			String fileName = "错误信息";
			HSSFSheet sheet = workbook.getSheetAt(0);
			if (sheet != null) {
				fileName = sheet.getSheetName();
			}
			// 设置response的Header
			if (request.getHeader("User-Agent").toLowerCase()
					.indexOf("firefox") > 0) {

				fileName = new String(fileName.getBytes("UTF-8"), "ISO8859-1");// firefox浏览器
			} else if (request.getHeader("User-Agent").toUpperCase().indexOf(
					"MSIE") > 0) {
				fileName = URLEncoder.encode(fileName, "UTF-8");// IE浏览器
			}
			response.addHeader("Content-Disposition", "attachment;filename="
					+ fileName + ".xls");
			response.setContentType("application/octet-stream");
			workbook.write(os);
		} catch (Exception e) {
		} finally {
			try {
				if (os != null) {
					os.flush();
					os.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
	
	
	
}
