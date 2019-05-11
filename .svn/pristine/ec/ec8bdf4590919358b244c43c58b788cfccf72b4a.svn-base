package com.gbicc.bpm.servlet;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.springframework.jdbc.core.JdbcTemplate;

import com.gbicc.bpm.SpringContextHolder;
import com.gbicc.common.FileTools;
import com.gbicc.common.FileUpDownProperties;
import com.gbicc.util.DateUtils;
import com.gbicc.warn.ComninationWarn.entity.TCwCreditInexOptRecord;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.entity.dao.mng.ROOTDAO;
import com.huateng.ebank.entity.dao.mng.ROOTDAOUtils;


public class HbImportExcelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public HbImportExcelServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
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
			String fileRealPath = rootPath + File.separator +"HbExcelImporttemp"+File.separator ;// 文件真实路径,以文件分隔符结尾
			FileTools.createFolder(fileRealPath);// 创建目录
			List items=diskFileUpload.parseRequest(request);
			int errorcount=0;
			int sucesscount=0;
			boolean boolflag=true;
			Iterator it1=items.iterator();
			TCwCreditInexOptRecord tcio=new TCwCreditInexOptRecord();
			GlobalInfo info=(GlobalInfo) request.getSession().getAttribute(GlobalInfo.KEY_GLOBAL_INFO);
			String userId=info.getTlrno();
			tcio.setUsername(userId);
			Date date=new Date();
			int id=(int)date.getTime();
			tcio.setId(id);
			Boolean f1=true;
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
			//上传完成       开始处理
			InputStream is=new FileInputStream(file);
			POIFSFileSystem psfs=new POIFSFileSystem(is);
			HSSFWorkbook hssfw=new HSSFWorkbook(psfs);
			HSSFSheet hssfs=hssfw.getSheetAt(0);
			int length=hssfs.getLastRowNum();
			boolean flag=true;
			int flagcount=0;
			HSSFRow row=hssfs.getRow(1);
			short celllength=row.getLastCellNum();
			List<String> rownamelist=new ArrayList<String>();
			for(int j=0;j<celllength;j++){
				HSSFCell cell=row.getCell(j);
				String str=cell.getStringCellValue().trim();
				rownamelist.add(str);
			}
			if(rownamelist.get(0).equals("序号")&&rownamelist.get(1).equals("被处罚人(单位)名称")&&rownamelist.get(2).equals("违法行为类别")&&rownamelist.get(3).equals("处罚依据")&&rownamelist.get(4).equals("处罚措施")&&rownamelist.get(5).equals("作出处罚单位名称")&&rownamelist.get(7).equals("组织机构代码")){
				
			}else{
				flag=false;
			}

		if(flag==true){	
			for(int i=2;i<=length;i++){
				boolflag=true;
			try{
				row=hssfs.getRow(i);
				if(null!=row){
					celllength=row.getLastCellNum();
					HashMap cellmap=new HashMap<String, Object>();
					//获取每一行的cell值，注意：excel表格中的内容为文本格式，如果为123等数字字符，仍会被识别为数字类型，需要做转换。0：数字格式，1：字符格式。
	 				for(int j=0;j<9;j++){
						HSSFCell cell=row.getCell(j);
//						System.out.print(cell.getCellType());
						if(cell!=null){			
//							rowlist.add(cell.getNumericCellValue());
							if(cell.getCellType()==0){
								double num=cell.getNumericCellValue();
								Double d=Double.valueOf(num);
								int tem=d.intValue();
								String numstr=String.valueOf(tem);
//								if("期数".equals(rownamelist.get(j))){
//									int flagint=(int) cell.getNumericCellValue();
//									cellmap.put(rownamelist.get(j),flagint);									
//								}else if("行业编号".equals(rownamelist.get(j))){
//									int flagint=(int) cell.getNumericCellValue();
//									String datastr=String.format("%d",flagint);
//									cellmap.put(rownamelist.get(j),datastr);
//								}else if("机构层级".equals(rownamelist.get(j))){
//									int flagint=(int) cell.getNumericCellValue();
//									if(flagstr.equals("季度")){
//						 				if(flagint==0){
//						 					gathertype="3";
//						 				}else{
//						 					gathertype="4";
//						 				}
//									}else if(flagstr.equals("月度")){
//						 				if(flagint==0){
//						 					gathertype="5";
//						 				}else{
//						 					gathertype="6";
//						 				}
//									}
//					 			
//									String datastr=String.format("%d",flagint);
//									cellmap.put(rownamelist.get(j),datastr);
//								}else{
//									cellmap.put(rownamelist.get(j), cell.getNumericCellValue());
								cellmap.put(rownamelist.get(j),numstr);
								}else{
//								break;
//							case 1:
//								if("指标编号".equals(rownamelist.get(j))){
//									if(listset.contains(cell.getStringCellValue())){
//										boolflag=false;
//										break;
//										
//									}else{
//										listset.add(cell.getStringCellValue());
//									}
//								}
								cellmap.put(rownamelist.get(j), cell.getStringCellValue());
//								break;
//								default:
//									if("行业名称".equals(rownamelist.get(j))){
//										cellmap.put(rownamelist.get(j), "");
//									}else
//										boolflag=false;
							 }
//							
//							}else{
//								if("行业名称".equals(rownamelist.get(j))){
//									cellmap.put(rownamelist.get(j), "");
//								}else
//									boolflag=false;
//							}
//		 				if(boolflag==false){
//		 					errorcount++;
//		 					break;
		 				}
					}
	 				
	 				if(boolflag==true){
	 				if(f1==true){
	 					f1=false;
	 					StringBuffer deletstr=new StringBuffer("DELETE FROM ECUSER.T_ODS_OUT_EIA_ILL_INFO  ");
	 					rootdao.executeSql(deletstr.toString());
	 				}
	 				//删除ECUSER.T_CW_CREDIT_INDEX_VAL之前的相同记录
	 				
		 			Date date1=new Date();
		 			SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
		 			String dateStr=df.format(date1);
		 			//insert CUSER.T_CW_CREDIT_INDEX_VAL  数据
					StringBuffer insertstr=new StringBuffer("INSERT INTO ECUSER.T_ODS_OUT_EIA_ILL_INFO(ID, CUST_NAME, LAW_TYPE, LAW_CONTENT, DEAL_RESULT, DEAL_ORG, DEAL_DATE, CUST_ORG_CODE, CUST_ADDRESS,FD_DATE) "
							+ "VALUES('"+cellmap.get("序号")+"', '"+cellmap.get("被处罚人(单位)名称")+"', '"+cellmap.get("违法行为类别")+"', '"+cellmap.get("处罚依据")+"', '"+cellmap.get("处罚措施")+"','"+cellmap.get("作出处罚单位名称")+"','"+cellmap.get("处罚决定作出时间")+"','"+cellmap.get("组织机构代码")+"','"+cellmap.get("地址")+"','"+dateStr+"')");
					rootdao.executeSql(insertstr.toString());
					sucesscount++;
	 				}
				}else{
					if(flagcount!=i){					//判断flagcount是否等于当前行，如果不等，赋值并使errount加一
						errorcount++;
						flagcount=i;
					}
				}

			}catch(Exception ee){
				ee.printStackTrace();
				if(flagcount!=i){
					errorcount++;
					flagcount=i;
				}
				continue;
					}
			}
			tcio.setErrorcount(errorcount);				//保存操作记录，最后两条，增加成功和失败条数。
			tcio.setSucesscount(sucesscount);			
			is.close();
		if(file.exists()){
			file.delete();
		}
		PrintWriter pw=response.getWriter();
		pw.println("{'success':'true','msg':'操作成功！'}");
		}else{
			PrintWriter pw=response.getWriter();
			pw.println("{'success':'true','msg':'请检查数据表格式，表结构出错！'}");
			if(file.exists()){
				file.delete();
			}
		}	
			
		} catch (Exception e) {
			if(file.exists()){
				file.delete();
			}
			e.printStackTrace();
		}
	}
}
