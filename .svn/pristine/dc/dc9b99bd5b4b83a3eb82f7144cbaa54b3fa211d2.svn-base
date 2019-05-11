package com.gbicc.bpm.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.activiti.engine.impl.util.json.JSONObject;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.gbicc.common.FileUpDownProperties;
import com.gbicc.company.financial.analysis.entity.FinanceIndexData;
import com.gbicc.util.DataToExcel;
import com.gbicc.util.DateUtils;
import com.huateng.ebank.entity.dao.mng.ROOTDAO;
import com.huateng.ebank.entity.dao.mng.ROOTDAOUtils;
import com.huateng.ebank.framework.util.ApplicationContextUtils;

public class DownloadFinIndexExcelServlet extends HttpServlet {

	private static final long serialVersionUID = 684085083209255359L;

	@Override
	protected void doGet(HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws IOException, ServletException {
		doPost(httpServletRequest, httpServletResponse);
	}
	@Override
	protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
			throws ServletException, IOException {
		
		ROOTDAO rootdao=ROOTDAOUtils.getROOTDAO();
		//
		DateUtils dataUtils = new DateUtils();
		//
		//String pck = httpServletRequest.getParameter("paramChk");
		String id = httpServletRequest.getParameter("_id");
		//
		String sjzyear = httpServletRequest.getParameter("jzyear");
		int jzYear = 0;
		if (org.apache.commons.lang3.StringUtils.isNotEmpty(sjzyear)
				|| !"".equals(sjzyear)) {
			jzYear = Integer.valueOf(sjzyear);
		}
		//
		String caliber = httpServletRequest.getParameter("caliber");
		String srepno = httpServletRequest.getParameter("repno");
		int repno = 0;
		if (org.apache.commons.lang3.StringUtils.isNotEmpty(srepno)
				|| !"".equals(srepno)) {
			repno = Integer.valueOf(srepno);
		}
			
		//
		Date firstDeadline;
		Date secondDeadline;
		Date threeDeadline;
		firstDeadline=dataUtils.getFirstDeadline(jzYear, caliber, repno);//本期
		secondDeadline=dataUtils.getSecondDeadline(jzYear, caliber, repno);//上期
		threeDeadline=dataUtils.getThreeDeadline(jzYear, caliber, repno);//上上期
		//
		SimpleDateFormat simple=new SimpleDateFormat("yyyyMMdd ");
		String  firstDeadlines=simple.format(firstDeadline);
		String  secondDeadlines=simple.format(secondDeadline);
		String  threeDeadlines=simple.format(threeDeadline);
		//
		String customerNum = httpServletRequest.getParameter("customerNum");
		//
		try {
			caliber=this.findCaliber(caliber, rootdao);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//
		String sql=  "SELECT                                                                                                                                                                         "
				+"	DISTINCT V1.INDEX_CD INDEX_CD,                                                                                                                                               "
				+"	V1.INDEX_NAME indexName,                                                                                                                                                     "
				+"	V1.INDEX_CD indexCd,                                                                                                                                                         "
				+"	V1.INDEX_TYPE_NAME indexTypeName,                                                                                                                                            "
				+"	V1.INDEX_TYPE indexType ,                                                                                                                                                    "
				+"	V1.REMARKS indexDisp,                                                                                                                                                        "
				+"	V1.INDEX_VALUE_DATA_TYPE AS stringType ,                                                                                                                                     "
				+"	V2.INDEX_VALUE_DATA_TYPE AS sStringType,                                                                                                                                     "
				+"	V3.INDEX_VALUE_DATA_TYPE AS ssStringType,                                                                                                                                    "
				+"	(V2.INDEX_VALUE_DATA_TYPE+V3.INDEX_VALUE_DATA_TYPE)/2 avgStringType,                                                                                                         "
				+"	CASE                                                                                                                                                                         "
				+"		WHEN V1.INDEX_VALUE_DATA_TYPE>MAX(V2.INDEX_VALUE_DATA_TYPE,                                                                                                                "
				+"		V3.INDEX_VALUE_DATA_TYPE)                                                                                                                                                  "
				+"		THEN 'S'                                                                                                                                                                   "
				+"		WHEN V1.INDEX_VALUE_DATA_TYPE<MIN(V2.INDEX_VALUE_DATA_TYPE,                                                                                                                "
				+"		V3.INDEX_VALUE_DATA_TYPE)                                                                                                                                                  "
				+"		THEN 'J'                                                                                                                                                                   "
				+"		ELSE ''                                                                                                                                                                   "
				+"	END                          AS upDown                                                                                                                                       "
				+"FROM                                                                                                                                                                           "
				+"	FIN_INDEX_V V1 LEFT JOIN                                                                                                                                                     "
				+"	FIN_INDEX_V V2 ON  V1.INDEX_CD=V2.INDEX_CD AND V1.INDEX_TYPE=V2.INDEX_TYPE AND V1.CUSTOMER_NUM=V2.CUSTOMER_NUM AND V1.REPORT_TYPE=V2.REPORT_TYPE  AND V2.DEADLINE='"+secondDeadlines+"'  "
				+"	 LEFT JOIN  FIN_INDEX_V V3  ON V1.INDEX_CD=V3.INDEX_CD AND  V1.INDEX_TYPE=V3.INDEX_TYPE AND V1.CUSTOMER_NUM=V3.CUSTOMER_NUM AND V2.REPORT_TYPE=V3.REPORT_TYPE   AND	           "
				+"	V3.DEADLINE='"+threeDeadlines+"'                                                                                                                                                      "
				+"WHERE                                                                                                                                                                          "
				+"	                                                                                                                                                                             "
				+"	                                                                                                                                                                             "
				+"	V1.CUSTOMER_NUM='"+customerNum+"' AND                                                                                                                                           "
				+"	V1.DEADLINE='"+firstDeadlines+"'   AND                                                                                                                                                   "
				+"	V1.REPORT_TYPE='"+caliber+"'                                                                                                                                                      "
				+"  ORDER BY                                                                                                                                                                       "
				+"	V1.INDEX_CD                                                                                                                                                                  ";
		//
		JdbcTemplate jdbcTemplate=(JdbcTemplate) ApplicationContextUtils.getBean("JdbcTemplate");
		List<FinanceIndexData> listT=jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(FinanceIndexData.class));
		//
		DataToExcel excel=new DataToExcel();
		String rootPath = FileUpDownProperties.readValue("rootPath");
		String fileRealPath = rootPath + File.separator +"expTemp"+File.separator ;// 文件真实路径,以文件分隔符结尾
		excel.setFilePath(fileRealPath);
		String path=excel.generateFinIndexExcel(listT);
		//
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
	public String findCaliber(String caliber,ROOTDAO rootDao) throws Exception{
		
		Iterator<String> it=rootDao.queryBySQL("select DATA_NO from data_dic t where t.DATA_TYPE_NO='726' AND T.DATA_NAME='"+caliber+"'");
		while(it.hasNext()){
			String obj=it.next();
			caliber=obj!=null ? obj: "";
		}
		return caliber;
	}
}
