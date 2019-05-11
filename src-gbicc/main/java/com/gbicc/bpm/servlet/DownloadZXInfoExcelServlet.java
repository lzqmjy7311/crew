package com.gbicc.bpm.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.StringUtils;

import com.gbicc.common.FileUpDownProperties;
import com.gbicc.company.view.zxinfo.entity.TCmCompanyCreditIndexView;
import com.gbicc.util.DataToExcel;
import com.huateng.ebank.entity.dao.mng.ROOTDAO;
import com.huateng.ebank.entity.dao.mng.ROOTDAOUtils;
import com.huateng.ebank.framework.util.ApplicationContextUtils;

public class DownloadZXInfoExcelServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws IOException,
			ServletException {
		doPost(httpServletRequest, httpServletResponse);
	}

	@Override
	protected void doPost(HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws ServletException,
			IOException {
		//
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		//
		String loanCardNum = httpServletRequest.getParameter("loanCardNum");
		//
		StringBuffer hql = new StringBuffer(
				" select t.INDEX_VALUE as indexValue,t.INDEX_ID as indexId,t.INDEX_NAME as indexName,t.FD_REPORTDATE as reportdate  from T_CM_COMPANY_CREDIT_INDEX_VIEW t where 1=1 ");
		if (StringUtils.hasText(loanCardNum)) {
			hql.append(" and FD_LOANCARDNO = '" + loanCardNum + "'");
			hql.append(" and t.FD_REPORTDATE = (select FD_REPORTDATE from T_CM_COMPANY_CREDIT_INDEX_VIEW  where FD_REPORTDATE is not null and FD_LOANCARDNO ='"
					+ loanCardNum
					+ "' order by FD_REPORTDATE desc fetch first 1 rows only)");
		} else {
			hql.append(" AND 1=0");
		}
		//获取数据
		JdbcTemplate jdbcTemplate = (JdbcTemplate) ApplicationContextUtils
				.getBean("JdbcTemplate");
		List<TCmCompanyCreditIndexView> listT = jdbcTemplate.query(hql
				.toString(), BeanPropertyRowMapper
				.newInstance(TCmCompanyCreditIndexView.class));
		//将数据写入文件，并在服务器端生成excel文件
		DataToExcel excel=new DataToExcel();
		String rootPath = FileUpDownProperties.readValue("rootPath");
		String fileRealPath = rootPath + File.separator +"expTemp"+File.separator ;// 文件真实路径,以文件分隔符结尾
		excel.setFilePath(fileRealPath);
		String path=excel.generateZXInfoExcel(listT);
		//将服务器端文件传输到客户端，传输完毕后删除文件
		File file=new File(excel.getFullPath());
		if(file.exists()){
			FileInputStream fin=new FileInputStream(file);
			String fileName=URLEncoder.encode(excel.getFileName(),"utf-8");
			byte[] bytes=new byte[fin.available()];
			fin.read(bytes);
			httpServletResponse.setCharacterEncoding("utf-8");
			httpServletResponse.setHeader("Content-type", "application/octet-stream");
			httpServletResponse.addHeader("Content-Disposition", "attachement;filename="+fileName+".xls");
			ServletOutputStream out=httpServletResponse.getOutputStream();
			out.write(bytes);
			out.flush();
			out.close();
			fin.close();
			file.delete();
		}
	}
}
