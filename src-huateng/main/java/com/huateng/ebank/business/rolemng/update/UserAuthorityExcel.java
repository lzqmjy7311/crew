package com.huateng.ebank.business.rolemng.update;

import java.io.ByteArrayOutputStream;
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

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import com.huateng.ebank.business.management.bean.UserAuthority;
import com.huateng.ebank.entity.dao.mng.ROOTDAOUtils;
import com.huateng.ebank.framework.exceptions.CommonException;

/**
 * @author UU_Wu
 *
 */
public class UserAuthorityExcel extends HttpServlet {

	@Override
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
			hql.append(trlNo).append("'))  ORDER BY B.LASTDIRECTORY,B.SHOWSEQ");
			Iterator funcName = null;
			try {
				funcName = ROOTDAOUtils.getROOTDAO().queryBySQL(hql.toString());
			} catch (CommonException e) {
				e.printStackTrace();
			}
			List funList = new ArrayList();
			while (funcName.hasNext()) {
				Object[] object = (Object[]) funcName.next();
				funList.add(object);
			}
			authority.put(trlName, funList);
			userName.add(trlName + ":" + trlNo);
		}
		Iterator allFuncName = null;
		try {
			allFuncName = ROOTDAOUtils
					.getROOTDAO()
					.queryBySQL(
							"SELECT FUNCID,FUNCNAME,ISDIRECTORY,LASTDIRECTORY FROM FUNCTION_INFO ORDER BY LASTDIRECTORY,SHOWSEQ");
		} catch (CommonException e) {
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

		 writeExcel(funcList, userName, authority,response);
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

	void writeExcel(List funcList, List userList,Map authority,HttpServletResponse response) {
		WritableWorkbook wwb = null;
		ByteArrayOutputStream ba = new ByteArrayOutputStream();
		try {
			wwb = Workbook.createWorkbook(ba);
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (wwb != null) {
			WritableSheet ws = wwb.createSheet("sheet1", 0);
			for (int i = 0; i < funcList.size(); i++) {
				for (int j = 0; j < userList.size() + 1; j++) {
					// 第一个参数表示列，第二个表示行
					Label labelC = null;
					String funcName = null;
					if (i > 0) {
						funcName = (String) funcList.get(i - 1);
					}
					if (i == 0 && j == 0) {
						labelC = new Label(j, i, " ");
					}
					if (j == 0 && i != 0) {
						labelC = new Label(j, i, funcName);
					}
					if (i == 0 && j != 0) {
						String userName = (String) userList.get(j - 1);
						String nString = userName.split(":")[0] + "("
								+ userName.split(":")[1] + ")";
						labelC = new Label(j, i, nString);
					}
					if (labelC == null) {
						String isHave = " ";
						String uName = (String) userList.get(j - 1);
						if (contains((ArrayList) authority.get(uName.split(":")[0]), funcName)) {
							isHave = "*";
						}
						labelC = new Label(j, i, isHave);
					}
					try {
						ws.addCell(labelC);
					} catch (RowsExceededException e) {
						e.printStackTrace();
					} catch (WriteException e) {
						e.printStackTrace();
					}
				}
			}
			try {
				wwb.write();
				wwb.close();
//				response.setContentType( "application/x-download;charset=utf-8");
				response.setContentType("application/octet-stream;charset=utf-8");
				response.setHeader("Content-Disposition", "attachment;filename=userAuthority.xls");
				ServletOutputStream out = response.getOutputStream();
				ba.writeTo(out);
				out.flush();
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (WriteException e) {
				e.printStackTrace();
			}
		}
	}

	Boolean contains(List list, String funcName) {
		Boolean flag = false;
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
