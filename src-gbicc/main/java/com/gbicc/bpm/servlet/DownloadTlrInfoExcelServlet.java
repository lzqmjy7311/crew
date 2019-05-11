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

import com.gbicc.bpm.entity.TlrInfoForExcel;
import com.gbicc.common.FileUpDownProperties;
import com.gbicc.util.DataToExcel;
import com.huateng.ebank.framework.util.ApplicationContextUtils;

public class DownloadTlrInfoExcelServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6040047905355524325L;

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
		String brcode = httpServletRequest.getParameter("brcode");
		// 查询的主体语句
		StringBuffer sql = new StringBuffer(
				" SELECT T.TLRNO AS TLRNO, "
						+ " T.TLR_NAME AS TLRNAME, "
						+ " T.FLAG AS STATUS, "
						+ " B.BRCODE AS BRCODE, "
						+ " B.BRNAME AS BRNAME, "
						+ " R.ROLE_ID AS ROLEID, "
						+ " R.ROLE_NAME AS ROLENAME, "
						+ " T.LASTACCESSTM AS LASTLOGINTIME, "
						+ " T.LASTLOGOUTTM AS LASTLOGOUTTIME "
						+ " FROM TLR_INFO T "
						+ " LEFT JOIN T_USER_ORGROLE_REL TBR ON T.TLRNO = TBR.F_USER_ID "
						+ "  JOIN BCTL B ON TBR.F_ORG_ID = B.BRNO "
						+ " LEFT JOIN ROLE_INFO R ON TBR.F_ROLE_ID = R.ROLE_ID "
						+ " WHERE 1 = 1 ");
		// 查询条件
		if (StringUtils.hasText(brcode) && !"00001".equals(brcode)) {
			sql.append(" AND B.BRCODE LIKE '" + brcode + "' or b.BLN_UP_BRCODE='"+ brcode + "'");
		}
		// 排序
		sql.append(" ORDER BY T.TLRNO ASC ");
		// 获取数据集
		JdbcTemplate jdbcTemplate = (JdbcTemplate) ApplicationContextUtils
				.getBean("JdbcTemplate");
		List<TlrInfoForExcel> listT = jdbcTemplate.query(sql.toString(),
				BeanPropertyRowMapper.newInstance(TlrInfoForExcel.class));
		//
		DataToExcel excel = new DataToExcel();
		String rootPath = FileUpDownProperties.readValue("rootPath");
		String fileRealPath = rootPath + File.separator + "expTemp"
				+ File.separator;// 文件真实路径,以文件分隔符结尾
		excel.setFilePath(fileRealPath);
		String path = excel.generateTlrInfoExcel(listT);
		//
		File file = new File(excel.getFullPath());
		if (file.exists()) {
			FileInputStream fin = new FileInputStream(file);
			String fileName = URLEncoder.encode(excel.getFileName(), "utf-8");
			byte[] bytes = new byte[fin.available()];
			fin.read(bytes);
			httpServletResponse.setCharacterEncoding("utf-8");
			httpServletResponse.setHeader("Content-type",
					"application/octet-stream");
			httpServletResponse.addHeader("Content-Disposition",
					"attachement;filename=" + fileName + ".xls");
			ServletOutputStream out = httpServletResponse.getOutputStream();
			out.write(bytes);
			out.flush();
			out.close();
			fin.close();
			file.delete();
		}
	}
}
