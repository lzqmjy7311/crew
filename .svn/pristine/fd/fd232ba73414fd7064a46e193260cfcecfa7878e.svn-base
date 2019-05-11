package com.gbicc.bpm.servlet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;





import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.gbicc.common.FileTools;
import com.gbicc.common.FileUpDownProperties;
import com.gbicc.person.importtext.entity.Importpersontext;
import com.gbicc.person.importtext.service.ImporttextPersonService;
import com.huateng.ebank.entity.dao.mng.ROOTDAO;
import com.huateng.ebank.entity.dao.mng.ROOTDAOUtils;


public class TxtImportpersonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public TxtImportpersonServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

	@SuppressWarnings("rawtypes")
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
			request.setCharacterEncoding("GBK");
			response.setCharacterEncoding("GBK");
			FileItemFactory diskFileItemFactory=new DiskFileItemFactory();
			ServletFileUpload diskFileUpload=new ServletFileUpload(diskFileItemFactory);
			File file = null;
		try {
			ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
			String rootPath = FileUpDownProperties.readValue("rootPath");
			String fileRealPath = rootPath + File.separator +"temp"+File.separator ;// 文件真实路径,以文件分隔符结尾
			FileTools.createFolder(fileRealPath);// 创建目录
			List items=diskFileUpload.parseRequest(request);
			Iterator it1=items.iterator();
			while(it1.hasNext()){
				FileItem item=(FileItem) it1.next();
				if(item.getName()!=null && item.getName()!=""){
					String fileName=new String(item.getName());
					fileName=fileName.substring((fileName.lastIndexOf("\\")+1), fileName.length());
					file=new File(fileRealPath+fileName);
					InputStream is = item.getInputStream();
					int buffer = 1024; // 定义缓冲区的大小
					int length = 0;
					byte[] b = new byte[buffer];
					FileOutputStream fos = new FileOutputStream(file);
					while ((length = is.read(b)) != -1) {
						fos.write(b, 0, length); // 向文件输出流写读取的数据
					}
					fos.close();
				}
			}

			int len=0;
			FileInputStream fis=new FileInputStream(file);
			InputStreamReader isr=new InputStreamReader(fis,"gbk");
			BufferedReader bf=new BufferedReader(isr);
			String value="";
			PrintWriter pw=response.getWriter();
			ImporttextPersonService importtextPersonService = ImporttextPersonService.getInstance();
			boolean bool=false;
			ArrayList<Importpersontext> listobj=new ArrayList();
			Date importtime=new Date();
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			String importstr=sdf.format(importtime);
			importtime=java.sql.Date.valueOf(importstr);
			while((value=bf.readLine())!=null){						//从txt获取每一行记录，关联Importpersontext对象											
				value=value.replace("\t","");
				value=value.replace("\"", "");
				value=value.trim();
				value=value.substring(0, value.length()-1);
 				len++;
 				String[]str1=value.split(",");
				if(len==1){											//对第一行字段进行匹配判断
					if(str1.length!=6||!str1[0].equals("本机构业务分支机构代码")||!str1[1].equals("姓名")||!str1[2].equals("证件类型")||!str1[3].equals("证件号码")||!str1[4].equals("信息代码")||!str1[5].equals("提示信息生成时间")){
						pw.println("{'success':'false','msg':'字段出错！'}");
						bool=true;
						break;
					}
				}else{
					if(str1.length!=6){								//对每一行记录条数进行匹配判断
						pw.println("{'success':'false','msg':'记录出错！第"+len+"行'}");
						bool=true;
						break;
					}
					Importpersontext it=new Importpersontext();
					it.setBankCode(str1[0]);
					it.setName(str1[1]);
					it.setCardType(str1[2]);
					it.setCardNo(str1[3]);
					it.setInformationCode(str1[4]);
					it.setImportTime(importtime);
					String str=com.gbicc.common.CQMethod.getDateString(str1[5]);
					Date dat1=java.sql.Date.valueOf(str);
					it.setCreatTime(dat1);
					listobj.add(it);
				}
			}
			fis.close();											//关闭流  删除文件
			isr.close();
			bf.close();
			if(file.exists()){
				file.delete();
			}
			if(!bool){												//取出List数据，插入数据库
				Iterator itobj=listobj.iterator();
				while(itobj.hasNext()){
					importtextPersonService.save((Importpersontext)itobj.next());
				}
				String sql="DELETE FROM ECUSER.T_PL_IMPORTPERSON_TABLE t WHERE (t.FD_BANKCODE,t.FD_NAME,t.FD_CARDTYPE,t.FD_CARDNO,t.FD_INFORMATION_CODE,t.FD_CREATTIME) in (select FD_BANKCODE,FD_NAME,FD_CARDTYPE,FD_CARDNO,FD_INFORMATION_CODE,FD_CREATTIME from T_PL_IMPORTPERSON_TABLE group by FD_BANKCODE,FD_NAME,FD_CARDTYPE,FD_CARDNO,FD_INFORMATION_CODE,FD_CREATTIME having count(*)>1 ) and FD_ID not in (select min(FD_ID) from T_PL_IMPORTPERSON_TABLE group by FD_BANKCODE,FD_NAME,FD_CARDTYPE,FD_CARDNO,FD_INFORMATION_CODE,FD_CREATTIME having count(*)>1)";			
				rootdao.executeSql(sql);
				pw.println("{'success':'true','msg':'操作成功！'}");
			}
			listobj.clear();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
