package com.huateng.ebank.business.rolemng.update;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.huateng.ebank.business.management.bean.UserAuthority;
import com.huateng.ebank.entity.dao.mng.ROOTDAOUtils;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;


/**
 * @author UU_Wu
 *
 */
public class UserAuthorityPdf extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String param = request.getParameter("param");
		String[] ids = param.split(";");
		List userList = new ArrayList();
		String sql = new String(
				"SELECT FUNCID,FUNCNAME,ISDIRECTORY,LASTDIRECTORY FROM FUNCTION_INFO B"
						+ " WHERE B.FUNCID IN ("
						+ "SELECT FUNCID FROM ROLE_FUNC_REL A "
						+ "WHERE A.ROLE_ID IN (select ROLE_ID from TLR_ROLE_REL WHERE TLRNO='");
		Map authority = new HashMap();
		List userName = new ArrayList();
		for (String id : ids) {
			UserAuthority u = new UserAuthority();
			String trlNo =id;
			Iterator trlN=null;
			try {
				trlN=ROOTDAOUtils.getROOTDAO().queryBySQL("SELECT TLR_NAME FROM TLR_INFO WHERE TLRNO='"+id+"'");
			} catch (CommonException e1) {
				e1.printStackTrace();
			}

			String trlName=(String)trlN.next();
			StringBuffer hql = new StringBuffer(sql);
			hql.append(trlNo).append(
						"'))  ORDER BY B.LASTDIRECTORY,B.SHOWSEQ");
			Iterator funcName=null;
			try {
				funcName = ROOTDAOUtils.getROOTDAO().queryBySQL(
							hql.toString());
			} catch (CommonException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			List funList = new ArrayList();
			while (funcName.hasNext()) {
				Object[] object = (Object[]) funcName.next();
				funList.add(object);
			}
			authority.put(trlName, funList);
			userName.add(trlName+":"+trlNo);
		}
		Iterator allFuncName=null;
		try {
			allFuncName = ROOTDAOUtils
					.getROOTDAO()
					.queryBySQL(
							"SELECT FUNCID,FUNCNAME,ISDIRECTORY,LASTDIRECTORY FROM FUNCTION_INFO ORDER BY LASTDIRECTORY,SHOWSEQ");
		} catch (CommonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List allFuncList = new ArrayList();
		while (allFuncName.hasNext()) {
			Object[] object = (Object[]) allFuncName.next();
			allFuncList.add(object);
		}
		//生成一个树形结构的list  funcList
				List funcList = new ArrayList();
				for (int j = 0; j < allFuncList.size(); j++) {
					Object[] o = (Object[]) allFuncList.get(j);
					String pid = (String) o[3];
					if ((pid).equals(0 + "")) {
						String space = "";
						sort(o, allFuncList, space, funcList);
					}
				}

				 writePdf(funcList, userName, authority,response);
	}

	void sort(Object[] o, List allFuncList, String space, List funcList) {
		String idString = (String) o[0];
		idString = idString.replace(" ", "");
		String funcName = (String) o[1];
		BigDecimal isDirectory = (BigDecimal) o[2];
		String pid = (String) o[3];
		funcList.add(space + funcName);
		if ((isDirectory + "").equals(1 + "")) {
			for (int i = 1; i < allFuncList.size(); i++) {
				Object[] oChild = (Object[]) allFuncList.get(i);
				String pidChild = (String) oChild[3];
				String funcNameChild = (String) oChild[1];
				if ((pidChild).equals(idString)) {
					sort(oChild, allFuncList, space + "   ", funcList);
				}
			}
		}
	}

	void writePdf(List funcList, List userList,Map authority,HttpServletResponse response) {
		Document doc = new Document();
		int row=userList.size()+1;
		float[] widths=new float[row] ;
		widths[0]=0.4f;
		for(int i=0;i<userList.size();i++){
			widths[i+1]=0.6f/userList.size();
		}
		PdfPTable table = new PdfPTable(widths);
		int count=funcList.size()*(row);
		BaseFont bfChinese=null;
		try {
			bfChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
		} catch (DocumentException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	    Font fontChinese = new Font(bfChinese, 8, Font.NORMAL);
		for(int i=0;i<count;i++){
			PdfPCell cell = new PdfPCell();
			String  funcName=null;
			Boolean isP=false;
		   if(i>=row){
			   funcName = (String) funcList.get(i/row-1);
			}
		   if(i==0){
			   cell.addElement(new Paragraph(" "));
			   isP=true;
		   }
		   if(i>0&&i<row){
			   String userName=(String) userList.get(i-1);
			   String nString=userName.split(":")[0]+"("+userName.split(":")[1]+")";
			   cell.addElement(new Paragraph(nString,fontChinese));
			   isP=true;
		   }
		   if(i!=0&&i%row==0){
			   cell.addElement(new Paragraph(funcName,fontChinese));
			   isP=true;
		   }
		   if(!isP){
				String isHave = " ";
				String uName = (String) userList.get(i%row-1);
				if (contains((ArrayList)authority.get(uName.split(":")[0]), funcName)) {
					isHave = "*";
				}
				cell.addElement(new Paragraph(isHave));
		   }
		   table.addCell(cell);
		}
		try {
			ByteArrayOutputStream ba = new ByteArrayOutputStream();
			PdfWriter.getInstance(doc,ba);
			doc.open();
			doc.add(table);
			doc.close();
//			response.setContentType("application/pdf");
			response.setContentType("application/octet-stream;charset=utf-8");
			response.setHeader("Content-Disposition", "attachment;filename=userAuthority.pdf");
//			response.setHeader("Cache-Control", "must-revalidate, post-check=0, pre-check=0");
			ServletOutputStream out = response.getOutputStream();
			ba.writeTo(out);
			out.flush();
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}

	 }

	Boolean contains(List list, String funcName) {
		Boolean flag=false;
		for (int i = 0; i < list.size(); i++) {
			Object[] ob = (Object[]) list.get(i);
			String obName = (String) ob[1];
			obName=obName.replace(" ", "");
			if (obName.equals(funcName.replace(" ", ""))) {
				flag = true;
				break;
			}
		}
		return flag;
	}

}
