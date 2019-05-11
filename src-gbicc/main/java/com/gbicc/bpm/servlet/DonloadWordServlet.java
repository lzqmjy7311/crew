package com.gbicc.bpm.servlet;

import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.StringEscapeUtils;

import com.gbicc.bpm.pojo.ExtProcessOpinion;
import com.gbicc.bpm.service.ProcessManagerService;
import com.gbicc.common.CommonService;
import com.gbicc.common.TemplateBuilder;
import com.gbicc.person.monitor.entity.TPlControlmeasure;
import com.gbicc.person.monitor.entity.TPlDqReportAj;
import com.gbicc.person.monitor.entity.TPlDqReportJy;
import com.gbicc.person.monitor.entity.TPlDqReportJyCreditBusin;
import com.gbicc.person.monitor.entity.TPlDqReportJyGuarant;
import com.gbicc.person.monitor.entity.TPlDqReportJyMortgage;
import com.gbicc.person.monitor.entity.TPlDqReportJyPartner;
import com.gbicc.person.monitor.entity.TPlDqReportXf;
import com.gbicc.person.monitor.entity.TPlReportRelation;
import com.gbicc.person.monitor.entity.TPlTask;
import com.gbicc.person.monitor.entity.TPlYjReport;
import com.gbicc.person.monitor.entity.TPlYtReport;
import com.gbicc.person.monitor.service.TPlDqMonitorService;
import com.gbicc.person.monitor.service.TPlDqReportAjService;
import com.gbicc.person.monitor.service.TPlDqReportJyService;
import com.gbicc.person.monitor.service.TPlDqReportXfService;
import com.gbicc.person.monitor.service.TPlYjReportService;
import com.gbicc.person.monitor.service.TPlYtReportService;
import com.gbicc.person.zxrf.entity.TPlZxrfInfo;
import com.gbicc.person.zxrf.service.TPlZxrfInfoService;
import com.gbicc.rule.entity.TRulDefinition;
import com.gbicc.rule.service.TRulDefinitionService;
import com.gbicc.util.DateUtils;
import com.gbicc.warn.entity.TWarnSignal;
import com.huateng.ebank.business.common.service.BctlService;
import com.huateng.ebank.business.management.service.TlrInfoService;
import com.huateng.ebank.entity.dao.mng.ROOTDAO;
import com.huateng.ebank.entity.dao.mng.ROOTDAOUtils;
import com.huateng.ebank.entity.data.mng.DataDic;
import com.huateng.ebank.entity.data.mng.TlrInfo;
import com.huateng.ebank.framework.exceptions.CommonException;

import freemarker.template.Template;

public class DonloadWordServlet extends HttpServlet {
	private static final long serialVersionUID = -6901003787476793848L;
	private static Integer maxFileSize = 0;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String reportType = req.getParameter("reportType");
		String reportId = req.getParameter("reportId");
		String businessId = req.getParameter("businessId");
		String loanAcct = req.getParameter("loanAcct");
		String name = DateUtils.formatYmdDate(new Date()) + ".doc";
		resp.addHeader("Content-Disposition", "attachment;filename=" + name);
		resp.setContentType("application/octet-stream");
		resp.setCharacterEncoding("UTF-8");
		Writer writer =resp.getWriter();
		try {
			Map<String, Object> map = this.getMapOfReport(reportType, reportId,
					businessId,loanAcct);
			for(Entry<String,Object> entry:map.entrySet()){
				if(entry.getValue() instanceof String && entry.getKey()!=null){
					entry.setValue(StringEscapeUtils.escapeXml11(entry.getValue().toString()));
				}
			}
			Template temp = TemplateBuilder.getInstance().getTemplate(
					(String) map.get("ftlname"));
			temp.process(map, writer);
			name = new String(name.getBytes("gbk"), "iso-8859-1");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (writer != null) {
				writer.close();
			}
		}
	}

	/**
	 * 给map赋值
	 * 
	 * @param reportType
	 * @param reportId
	 * @return
	 * @throws Exception 
	 */
	private Map<String, Object> getMapOfReport(String reportType,
			String reportId, String businessId,String loanAcct) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		if ("RF".equals(reportType)) {
			if (reportId == null || reportId == "") {
				return map;
			}
			TPlZxrfInfo info = TPlZxrfInfoService.getInstance().get(reportId);
			if (info == null) {
				return map;
			}
			// 模板名称 (必须)
			if ("10".equals(info.getProductType())) {// 个人消费类
				map.put("ftlname", "RFB.xml");
			} else {// 经营类
				map.put("ftlname", "RFA.xml");
			}
			this.setRFMapValue(map, info);
		} else if ("YJ".equals(reportType)) {// 个贷预警处置
			TPlYjReport yjReport = TPlYjReportService.getInstance().get(
					reportId);
			map.put("ftlname", "PL_YJ_REPORT.xml");
			this.setYjMapValue(map, yjReport, businessId);
		} else if ("YTR".equals(reportType)) {// 用途监控报告模板
			map.put("ftlname", "YTR.xml");
			this.setYtMapValue(map, reportId, businessId);
		} else if ("AJ".equals(reportType)) {// 按揭类监控报告
			map.put("ftlname", "aj_report.xml");
			this.setAjMapValue(map,reportId,loanAcct);
		} else if ("XF".equals(reportType)) {// 消费类监控报告
			map.put("ftlname", "xf_report.xml");
			this.setXfMapValue(map, reportId);
		} else if ("JY".equals(reportType)) {// 经营类监控报告
			map.put("ftlname", "jy_report.xml");
			this.setJyMapValue(map, reportId);
		}
		//审核意见
		List<ExtProcessOpinion> opinions=
				ProcessManagerService.getInstace().findProcessHistoryOpinions(businessId);
		if(opinions==null||opinions.isEmpty()){
			map.put("opinions",new ArrayList<ExtProcessOpinion>());
		}else{
			map.put("opinions",opinions);
		}
		return map;
	}

	private String getStringBool(String f) {
		return "1".equals(f) ? "是" : "否";
	}

	private void setYtMapValue(Map<String, Object> map, String reportId,
			String businessId) throws CommonException {
		TPlYtReport plYtReport = TPlYtReportService.getInstance().get(reportId);
		map.put("lendCode", plYtReport.getLendCode());
		map.put("custCode", plYtReport.getCustCode());
		map.put("custAddress", plYtReport.getCustAddress());
		map.put("custPhone",plYtReport.getCustPhone());
		map.put("custName", plYtReport.getCustName());
		map.put("custTrade", plYtReport.getCustTrade());// 所属行业
		this.setDateDicVal("93", map, "custTrade");
		map.put("loanAmt", plYtReport.getLoanAmt());
		map.put("productCode", plYtReport.getProductCode());
		this.setDateDicVal("900", map, "productName");
		map.put("loanBalance", plYtReport.getLoanBalance());
		map.put("checkWay", plYtReport.getCheckWay());
		this.setDateDicVal("12585", map, "checkWay");
		map.put("checkAddress", plYtReport.getCheckAddress());
		map.put("mainSurvPer", plYtReport.getMainSurvPer());
		map.put("assistSurvPer", plYtReport.getAssistSurvPer());
		map.put("surveyDate",plYtReport.getSurveyDate());
		map.put("operResult", getStringBool(plYtReport.getOperResult()));
		map.put("buesResult", getStringBool(plYtReport.getBuesResult()));
		map.put("guarResult", getStringBool(plYtReport.getGuarResult()));
		map.put("earnResult", getStringBool(plYtReport.getEarnResult()));
		map.put("hasCert", getStringBool(plYtReport.getHasCert()));
		map.put("loanResult", getStringBool(plYtReport.getLoanResult()));
		map.put("applyOpin", plYtReport.getApplyOpin());
		if(!org.springframework.util.StringUtils.hasText(plYtReport.getFrequency())){
			map.put("frequency", "");
		}else{
			map.put("frequency", plYtReport.getFrequency()+"月");
		}
		// 预警信息
		List<TWarnSignal> warnList = (List<TWarnSignal>) CommonService
				.getInstance().queryListHQL(
						"from TWarnSignal t where loanAccount='"
								+ plYtReport.getLoanNo() + "' ");
		if (warnList != null && !warnList.isEmpty()) {
			TWarnSignal t = warnList.get(0);
			map.put("hasWarn", "1");
			map.put("warncode", t.getWarnCode());
			map.put("warnpoint", getDataNameBy("200",t.getWarnLEvel()));
			map.put("warnresult", getDataNameBy("200",t.getWarnLEvel()));
			map.put("chazhengqk", getDataNameBy("211",t.getCheckStatus()));
			map.put("chazhengsh", t.getCheckDesc());
			if(t.getRuleId()!=null){
				TRulDefinition df=TRulDefinitionService.getInstance().get(t.getRuleId());
				if(df!=null){
					map.put("warntype", getDataNameBy("199",df.getRuleType()));
				}
			}
		}
		// 控制措施
		String apdCtrl = "";
		String riskCtrl = "";
		List<TPlControlmeasure> controlmeasures = (List<TPlControlmeasure>) CommonService
				.getInstance().queryListHQL(
						"from TPlControlmeasure where taskId='" + businessId
								+ "' ");
		if (controlmeasures != null && !controlmeasures.isEmpty()) {
			for (TPlControlmeasure contro : controlmeasures) {
				if (contro.getCtrlType().equals("1")) {
					map.put("lmtCtrl", contro.getConmeasCode());
				} else if (contro.getCtrlType().equals("2")) {
					riskCtrl=contro.getConmeasCode();
					map.put("otherCtrlDesc", contro.getOtherCtrlDesc());
				} else if (contro.getCtrlType().equals("3")) {
					apdCtrl = apdCtrl
							+ getDataNameBy("115", contro.getConmeasCode())
							+ ",";
				}
			}
			if (!apdCtrl.equals("")) {
				apdCtrl = apdCtrl.substring(0, apdCtrl.length() - 1);
			}
			this.setDateDicVal("113", map, "lmtCtrl");
			StringBuilder sbf=new StringBuilder();
			if(!riskCtrl.equals("")){
				String arys[]=riskCtrl.split(",");
				if(arys!=null){
					for(String k:arys){
						sbf.append(getDataNameBy("114", k)).append(",");
					}
				}
				if (!apdCtrl.equals("")) {
					riskCtrl = sbf.substring(0, sbf.length() - 1);
				}
			}
			map.put("riskCtrl",riskCtrl);
			map.put("appendCtrl", apdCtrl);
		}
	}

	/**
	 * 中小融辅 赋值
	 * 
	 * @param map
	 * @param info
	 * @throws CommonException
	 */
	private void setRFMapValue(Map<String, Object> map, TPlZxrfInfo info)
			throws CommonException {
		CommonService comService = CommonService.getInstance();
		 TPlTask  task=(TPlTask)comService.queryOneHQL("from TPlTask where 1=1 and id=(select businessId from TPlReportRelation where reportId='"+info.getId()+"')");

		Field[] fieldList = info.getClass().getDeclaredFields();
		String[] yesOrNo = { "contactDiff", "loanperMeet", "loanperCooperate",
				"loanperEnforce", "perPostchange", "perNewjob", "perHavework",
				"perOverwages", "perComover", "perOthfamloan", "perChangeadd",
				"perHaveguarantor", "perHralthstatus", "perSpouseinvite",
				"perIllegal", "guaContactch", "guaBadaccount", "opsChangeper",
				"opsAddstaff", "opsAddsupp", "opsAdddeal", "opsComstop",
				"finNeedmoney", "finChangebank", "finOthloan",
				"finOthbankloan", "finStock" };
		for (Field field : fieldList) {
			field.setAccessible(true);
			try {
				if (field.get(info) == null) {
					map.put(field.getName(), " ");
				} else {
					map.put(field.getName(), field.get(info));
				}
				for (int i = 0; i < yesOrNo.length; i++) {
					if (yesOrNo[i].equals(field.getName())) {
						if ("1".equals(field.get(info))) {
							map.put(field.getName(), "是");
						} else if ("0".equals(field.get(info))) {
							map.put(field.getName(), "否");
						} else {
							map.put(field.getName(), "--");
						}
						break;
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
				continue;
			}
		}
		StringBuffer warnSignalStr = new StringBuffer("");
		List<TWarnSignal> warnList = (List<TWarnSignal>) comService
				.queryListHQL("from TWarnSignal t where 1=1 and reportId='"
						+ info.getId() + "' ");
		for (TWarnSignal tWarnSignal : warnList) {
			warnSignalStr.append("	预警信号：" + tWarnSignal.getWarnCode() + " ,");
			warnSignalStr.append("预警名称：" + tWarnSignal.getAffPerDesc() + " ,");

			if ("0".equals(tWarnSignal.getWarnLEvel())) {
				warnSignalStr.append("预警级别：绿 ,");
			} else if ("1".equals(tWarnSignal.getWarnLEvel())) {
				warnSignalStr.append("预警级别：黄 ,");
			} else if ("2".equals(tWarnSignal.getWarnLEvel())) {
				warnSignalStr.append("预警级别：橙 ,");
			} else if ("3".equals(tWarnSignal.getWarnLEvel())) {
				warnSignalStr.append("预警级别：红 ,");
			} else {
				warnSignalStr.append("预警级别：无  ,");
			}
			if ("1".equals(tWarnSignal.getCheckStatus())) {
				warnSignalStr.append("查证情况：情况属实 ");
			} else {
				warnSignalStr.append("查证情况：其他说明 ");
			}
			warnSignalStr.append("；	");
		}
		map.put("warnSignalStr", warnSignalStr.toString());
		map.put("warnProcessRemarkStr", this.findProcessRemarkByBusinessId(task.getId()));
		// 有无随行人
		this.setDateDicVal("12589", map, "havePer");
		// 查访方式
		this.setDateDicVal("12585", map, "visitway");
		// 调查方式
		this.setDateDicVal("12583", map, "surveyType");
		// 调查地点
		this.setDateDicVal("12586", map, "surveyAdd");
		this.setDateDicVal("12587", map, "perWorkstatus");
		this.setDateDicVal("12591", map, "finMobthreport");
		this.setDateDicVal("12586", map, "surveyAdd");

		if (info.getOperator() != null) {
			TlrInfo tlrInfo = TlrInfoService.getInstance().getTlrInfoByTlrno(
					info.getOperator());
			if (tlrInfo != null) {
				info.setOperatorNam(tlrInfo.getTlrName());
				map.put("operator", tlrInfo.getTlrName());
			}
		}
		if (info.getOperBank() != null) {
			String brname = BctlService.getInstance().getBranchName(
					info.getOperBank());
			if (brname != null) {
				info.setOperBankNam(brname);
				map.put("operBank", brname);
			}
		}

	}

	/**
	 * 设置预警处置 报告的映射内容（取保存在报告实体表中的内容）
	 * 
	 * @param map
	 * @param info
	 */
	private void setYjMapValue(Map<String, Object> map, TPlYjReport info,
			String businessId) {
		CommonService comService = CommonService.getInstance();

		Field[] fieldList = info.getClass().getDeclaredFields();
		String[] yesOrNo = { "contactDiff", "loanperMeet" };// 需要 是否翻译字段
		for (Field field : fieldList) {
			field.setAccessible(true);
			try {
				if (field.get(info) == null) {
					map.put(field.getName(), " ");
				} else {
					map.put(field.getName(), field.get(info));
				}
				for (int i = 0; i < yesOrNo.length; i++) {
					if (yesOrNo[i].equals(field.getName())) {
						if ("1".equals(field.get(info))) {
							map.put(field.getName(), "是");
						} else if ("0".equals(field.get(info))) {
							map.put(field.getName(), "否");
						} else {
							map.put(field.getName(), "--");
						}
						break;
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
				continue;
			}
		}
		StringBuffer warnSignalStr = new StringBuffer(" ");
		List<TWarnSignal> warnList = (List<TWarnSignal>) comService
				.queryListHQL("from TWarnSignal t where 1=1 and reportId='"
						+ info.getFdId() + "' ");
		// ------预警信号处理
		for (TWarnSignal tWarnSignal : warnList) {
			map.put("warnCode", tWarnSignal.getWarnCode());// 预警信号编号
			map.put("affPerDesc", tWarnSignal.getAffPerDesc());// 预警名称
			map.put("checkDesc", tWarnSignal.getCheckDesc());// 查证说明
			map.put("warnLEvel", tWarnSignal.getWarnLEvel());// 预警等级

			if ("1".equals(tWarnSignal.getCheckStatus())) {
				map.put("checkStatus", "情况属实");// 查证情况
			} else {
				map.put("checkStatus", "其他说明");// 查证情况
			}

		}
		// -----控制措施处理
		String apdCtrl = "";
		List<TPlControlmeasure> controlmeasures = (List<TPlControlmeasure>) comService
				.queryListHQL("from TPlControlmeasure where taskId='"
						+ businessId + "' ");
		for (TPlControlmeasure contro : controlmeasures) {
			if (contro.getCtrlType().equals("1")) {
				map.put("fdCreLimconMeasures", contro.getConmeasCode());
			} else if (contro.getCtrlType().equals("2")) {
				map.put("fdOtherConMeasures", contro.getConmeasCode());
				map.put("fdOtherConMeasuresDesc", contro.getOtherCtrlDesc());

			} else if (contro.getCtrlType().equals("3")) {
				apdCtrl = apdCtrl
						+ getDataNameBy("115", contro.getConmeasCode()) + ",";
			}

		}
		if (!apdCtrl.equals("")) {
			apdCtrl = apdCtrl.substring(0, apdCtrl.length() - 1);// 取出 字符串后的 ","
		}
		map.put("fdAddConMeasures", apdCtrl);

		// 预警等级
		this.setDateDicVal("200", map, "warnLEvel");
		// 查访方式
		this.setDateDicVal("12585", map, "fdVisitWay");
		// 行业
		this.setDateDicVal("93", map, "fdIndustry");
		// 风险分类
		this.setDateDicVal("122", map, "fdRiskClass");
		// 担保方式
		this.setDateDicVal("123", map, "fdGuarWay");
		// 账号状态
		this.setDateDicVal("120", map, "fdAcctStatus");

		// 收信额度
		this.setDateDicVal("113", map, "fdCreLimconMeasures");
		// 其他控制措施
		this.setDateDicVal("114", map, "fdOtherConMeasures");

	}

	@SuppressWarnings("rawtypes")
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		FileItemFactory diskFileItemFactory = new DiskFileItemFactory();
		ServletFileUpload diskFileUpload = new ServletFileUpload(
				diskFileItemFactory);
		diskFileUpload.setSizeMax(maxFileSize);

	}

	/**
	 * 根据字典码 与值 找到名称
	 * 
	 * @param dataTypeNo
	 * @param dataNo
	 * @return
	 */
	private void setDateDicVal(String dataTypeNo, Map<String, Object> dataMap,
			String praName) {

		String dataNo = (String) dataMap.get(praName);
		if (StringUtils.isBlank(dataTypeNo) || StringUtils.isBlank(dataNo)
				|| " ".equals(dataNo)) {
			dataMap.put(praName, " ");
		}
		CommonService comService = CommonService.getInstance();
		List<DataDic> list = (List<DataDic>) comService
				.queryListHQL("from DataDic t where dataTypeNo=" + dataTypeNo
						+ " and dataNo='" + dataNo + "' ");
		if (list != null && list.size() > 0) {
			DataDic dic = list.get(0);
			if (StringUtils.isNotBlank(dic.getDataName())) {
				dataMap.put(praName, dic.getDataName());
			} else {
				dataMap.put(praName, " ");
			}
		} else {
			dataMap.put(praName, " ");
		}
	}

	/**
	 * 根据字典码 与值 找到名称
	 * 
	 * @param dataTypeNo
	 * @param dataNo
	 * @return
	 */
	private String getDataNameBy(String dataTypeNo, String dataNo) {

		String dataName = "";
		CommonService comService = CommonService.getInstance();
		List<DataDic> list = (List<DataDic>) comService
				.queryListHQL("from DataDic t where dataTypeNo=" + dataTypeNo
						+ " and dataNo='" + dataNo + "' ");
		if (list != null && list.size() > 0) {
			DataDic dic = list.get(0);
			if (StringUtils.isNotBlank(dic.getDataName())) {
				dataName = dic.getDataName();
			}
		}
		return dataName;
	}

	public void setJyMapValue(Map<String, Object> map, String reportId)
			throws CommonException {
		ROOTDAO rootDao = ROOTDAOUtils.getROOTDAO();
		List<TPlReportRelation> list = rootDao
				.queryByCondition(" from TPlReportRelation where businessId='"
						+ reportId + "'");
		TPlDqReportJy report = TPlDqReportJyService.getInstance().get(
				list.get(0).getReportId());
		// 反射put到map中
		try {
			Field[] fields = report.getClass().getFields();
			for (int i = 0; i < fields.length; i++) {
				System.out.println(fields[i].getName()+"-------"+fields[i].get(report));
				map.put(fields[i].getName(), fields[i].get(report));
			}
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		this.setDateDicVal("120", map, "acctStatus");
		this.setDateDicVal("122", map, "riskType");
		this.setDateDicVal("123", map, "guarWay");
		if (StringUtils.isNotEmpty(report.getRegiCapiChange()) && report.getRegiCapiChange().equals("1")) {
			map.put("regiCapiChange", "增加");
		} else if (StringUtils.isNotEmpty(report.getRegiCapiChange()) && report.getRegiCapiChange().equals("2")) {
			map.put("regiCapiChange", "未变");
		} else if (StringUtils.isNotEmpty(report.getRegiCapiChange()) && report.getRegiCapiChange().equals("3")) {
			map.put("regiCapiChange", "减少");
		}
		if (StringUtils.isNotEmpty(report.getIfHaveCapiRpt())) {
			map.put("ifHaveCapiRpt", getStringBool(report.getIfHaveCapiRpt()));
		}
		if (StringUtils.isNotEmpty(report.getSharStruIfChange())) {
			map.put("sharStruIfChange",
					getIfChange(report.getSharStruIfChange()));
		}
		if (StringUtils.isNotEmpty(report.getRealCtrlPerIfChange())) {
			map.put("realCtrlPerIfChange",
					getIfChange(report.getRealCtrlPerIfChange()));
		}
		if (StringUtils.isNotEmpty(report.getEnteNameIfChange())) {
			map.put("enteNameIfChange",
					getIfChange(report.getEnteNameIfChange()));
		}
		if (StringUtils.isNotEmpty(report.getOrgCodeIfChange())) {
			map.put("orgCodeIfChange", getIfChange(report.getOrgCodeIfChange()));
		}
		if (StringUtils.isNotEmpty(report.getBusiLiceIfChange())) {
			map.put("busiLiceIfChange",
					getIfChange(report.getBusiLiceIfChange()));
		}
		if (StringUtils.isNotEmpty(report.getTaxRegiCodeIfChange())) {
			map.put("taxRegiCodeIfChange",
					getIfChange(report.getTaxRegiCodeIfChange()));
		}
		if (StringUtils.isNotEmpty(report.getLoanCardIfChange())) {
			map.put("loanCardIfChange",
					getIfChange(report.getLoanCardIfChange()));
		}
		if (StringUtils.isNotEmpty(report.getSpecOperCodeIfChange())) {
			map.put("specOperCodeIfChange",
					getIfChange(report.getSpecOperCodeIfChange()));
		}
		if (StringUtils.isNotEmpty(report.getInduClassIfChange())) {
			map.put("induClassIfChange",
					getIfChange(report.getInduClassIfChange()));
		}
		if (StringUtils.isNotEmpty(report.getEnteIdentIfLose()) && report.getEnteIdentIfLose().equals("1")) {
			map.put("enteIdentIfLose", "存在");
		} else if (StringUtils.isNotEmpty(report.getEnteIdentIfLose()) && report.getEnteIdentIfLose().equals("2")) {
			map.put("enteIdentIfLose", "不存在");
		}
		if (StringUtils.isNotEmpty(report.getFinaRptIfCredible()) && report.getFinaRptIfCredible().equals("1")) {
			map.put("finaRptIfCredible", "基本可信");
		} else if (StringUtils.isNotEmpty(report.getFinaRptIfCredible()) && report.getFinaRptIfCredible().equals("2")) {
			map.put("finaRptIfCredible", "不可信");
		}
		if (StringUtils.isNotEmpty(report.getLoanPerFinaCond()) && report.getLoanPerFinaCond().equals("1")) {
			map.put("loanPerFinaCond", "向好");
		} else if (StringUtils.isNotEmpty(report.getLoanPerFinaCond()) && report.getLoanPerFinaCond().equals("2")) {
			map.put("loanPerFinaCond", "持平");
		} else if (StringUtils.isNotEmpty(report.getLoanPerFinaCond()) && report.getLoanPerFinaCond().equals("3")) {
			map.put("loanPerFinaCond", "向差");
		} else if (StringUtils.isNotEmpty(report.getLoanPerFinaCond()) && report.getLoanPerFinaCond().equals("4")) {
			map.put("loanPerFinaCond", "无法判断");
		}
		if (StringUtils.isNotEmpty(report.getEnteAmtIfChange()) && report.getEnteAmtIfChange().equals("1")) {
			map.put("enteAmtIfChange", "正常");
		} else if (StringUtils.isNotEmpty(report.getEnteAmtIfChange()) && report.getEnteAmtIfChange().equals("2")) {
			map.put("enteAmtIfChange", "不正常");
		}
		if (StringUtils.isNotEmpty(report.getPredRepmtSrc()) && report.getPredRepmtSrc().equals("1")) {
			map.put("predRepmtSrc", "经营活动现金流");
		} else if (StringUtils.isNotEmpty(report.getPredRepmtSrc()) && report.getPredRepmtSrc().equals("2")) {
			map.put("predRepmtSrc", "投资活动现金流");
		} else if (StringUtils.isNotEmpty(report.getPredRepmtSrc()) && report.getPredRepmtSrc().equals("3")) {
			map.put("predRepmtSrc", "筹资活动现金流");
		}
		String str = "";
		if (StringUtils.isNotEmpty(report.getRelaPer()) && report.getRelaPer().equals("1")) {
			map.put("relaPer", "保证人本人");
		} else if (StringUtils.isNotEmpty(report.getRelaPer()) && report.getRelaPer().equals("2")) {
			map.put("relaPer", "配偶");
		} else if (StringUtils.isNotEmpty(report.getRelaPer()) && report.getRelaPer().equals("3")) {
			map.put("relaPer", "亲属");
		} else if (StringUtils.isNotEmpty(report.getRelaPer()) && report.getRelaPer().equals("4")) {
			map.put("relaPer", "单位同事");
		} else if (StringUtils.isNotEmpty(report.getRelaPer()) && report.getRelaPer().equals("5")) {
			str = report.getOthRelaPer() != null ? report.getOthRelaPer() : "";
			map.put("relaPer", "其他相关人（其他联系人：" + str + "）");
		}
		if (StringUtils.isNotEmpty(report.getGuarantorWorkChange()) && report.getGuarantorWorkChange().equals("1")) {
			map.put("guarantorWorkChange", "无变化");
		} else if (StringUtils.isNotEmpty(report.getGuarantorWorkChange()) && report.getGuarantorWorkChange().equals("2")) {
			str = report.getNewCompName() != null ? report.getNewCompName()
					: "";
			map.put("guarantorWorkChange", "新单位（新单位名称：" + str + "）");
		} else if (StringUtils.isNotEmpty(report.getGuarantorWorkChange()) && report.getGuarantorWorkChange().equals("3")) {
			map.put("guarantorWorkChange", "失业");
		}
		if (StringUtils.isNotEmpty(report.getGuarantorPhoneChange()) && report.getGuarantorPhoneChange().equals("1")) {
			map.put("guarantorPhoneChange", "无变化");
		} else if (StringUtils.isNotEmpty(report.getGuarantorPhoneChange()) && report.getGuarantorPhoneChange().equals("2")) {
			str = report.getGuarantorNewPhone() != null ? report
					.getGuarantorNewPhone() : "";
			map.put("guarantorPhoneChange", "新电话（新电话：" + str + "）");
		}
		if (StringUtils.isNotEmpty(report.getGuarantorAddrChange()) && report.getGuarantorAddrChange().equals("1")) {
			map.put("guarantorAddrChange", "无变化");
		} else if (StringUtils.isNotEmpty(report.getGuarantorAddrChange()) && report.getGuarantorAddrChange().equals("2")) {
			str = report.getGuarantorNewAddr() != null ? report
					.getGuarantorNewAddr() : "";
			map.put("guarantorAddrChange", "新住址（新住址：" + str + "）");
		}
		if (StringUtils.isNotEmpty(report.getGuarantorIncomeChange()) && report.getGuarantorIncomeChange().equals("1")) {
			map.put("guarantorIncomeChange", "无变化");
		} else if (StringUtils.isNotEmpty(report.getGuarantorIncomeChange()) && report.getGuarantorIncomeChange().equals("2")) {
			map.put("guarantorIncomeChange", "收入下降");
		} else if (StringUtils.isNotEmpty(report.getGuarantorIncomeChange()) && report.getGuarantorIncomeChange().equals("3")) {
			map.put("guarantorIncomeChange", "收入增加");
		}
		if (StringUtils.isNotEmpty(report.getGuarantorPosiChange()) && report.getGuarantorPosiChange().equals("1")) {
			map.put("guarantorPosiChange", "无变化");
		} else if (StringUtils.isNotEmpty(report.getGuarantorPosiChange()) && report.getGuarantorPosiChange().equals("2")) {
			str = report.getGuarantorNewPosi() != null ? report
					.getGuarantorNewPosi() : "";
			map.put("guarantorPosiChange", "发生变动（新职务：" + str + "）");
		}
		if (StringUtils.isNotEmpty(report.getGuarantorOperChange()) && report.getGuarantorOperChange().equals("1")) {
			map.put("guarantorOperChange", "经营正常");
		} else if (StringUtils.isNotEmpty(report.getGuarantorOperChange()) && report.getGuarantorOperChange().equals("2")) {
			map.put("guarantorOperChange", "经营遇到困难");
		} else if (StringUtils.isNotEmpty(report.getGuarantorOperChange()) && report.getGuarantorOperChange().equals("3")) {
			map.put("guarantorOperChange", "其他");
		}
		if (StringUtils.isNotEmpty(report.getGuarantorWishChange()) && report.getGuarantorWishChange().equals("1")) {
			map.put("guarantorWishChange", "无变化");
		} else if (StringUtils.isNotEmpty(report.getGuarantorWishChange()) && report.getGuarantorWishChange().equals("2")) {
			map.put("guarantorWishChange", "有变化");
		}
		if (StringUtils.isNotEmpty(report.getGuarantorGuarStre()) && report.getGuarantorGuarStre().equals("1")) {
			map.put("guarantorGuarStre", "不变");
		} else if (StringUtils.isNotEmpty(report.getGuarantorGuarStre()) && report.getGuarantorGuarStre().equals("2")) {
			map.put("guarantorGuarStre", "下降");
		}
		if (StringUtils.isNotEmpty(report.getMortCond()) && report.getMortCond().equals("1")) {
			map.put("mortCond", "完好");
		} else if (StringUtils.isNotEmpty(report.getMortCond()) && report.getMortCond().equals("2")) {
			map.put("mortCond", "毁损");
		} else if (StringUtils.isNotEmpty(report.getMortCond()) && report.getMortCond().equals("3")) {
			map.put("mortCond", "被转移");
		} else if (StringUtils.isNotEmpty(report.getMortCond()) && report.getMortCond().equals("4")) {
			map.put("mortCond", "被变卖");
		} else if (StringUtils.isNotEmpty(report.getMortCond()) && report.getMortCond().equals("5")) {
			map.put("mortCond", "被再抵押");
		} else if (StringUtils.isNotEmpty(report.getMortCond()) && report.getMortCond().equals("6")) {
			map.put("mortCond", "被有关机关依法查封、冻结、扣押");
		}
		if (StringUtils.isNotEmpty(report.getMortIfDevalue())) {
			map.put("mortIfDevalue", getStringBool(report.getMortIfDevalue()));
		}
		if (StringUtils.isNotEmpty(report.getMortAsseInsuIfExpire())) {
			map.put("mortAsseInsuIfExpire",
					getStringBool(report.getMortAsseInsuIfExpire()));
		}
		if (StringUtils.isNotEmpty(report.getCollatCond()) && report.getCollatCond().equals("1")) {
			map.put("collatCond", "无变化");
		} else if (StringUtils.isNotEmpty(report.getCollatCond()) && report.getCollatCond().equals("2")) {
			str = report.getCollatCondDesc() != null ? report
					.getCollatCondDesc() : "";
			map.put("collatCond", "有变化（变化情况说明：" + str + "）");
		}
		if (StringUtils.isNotEmpty(report.getCollatIfDevalue())) {
			map.put("collatIfDevalue",
					getStringBool(report.getCollatIfDevalue()));
		}
		if (StringUtils.isNotEmpty(report.getCollatImelIfExpire())) {
			map.put("collatImelIfExpire",
					getStringBool(report.getCollatImelIfExpire()));
		}
		if (StringUtils.isNotEmpty(report.getCollatIfLoseLawPote())) {
			map.put("collatIfLoseLawPote",
					getStringBool(report.getCollatIfLoseLawPote()));
		}
		// 控制措施
		List ctrlList = rootDao.getHibernateTemplate().find(
				"from TPlControlmeasure where taskId='" + reportId + "'");
		if (ctrlList != null && ctrlList.size() > 0) {
			String apdCtrl = "";
			for (int i = 0; i < ctrlList.size(); i++) {
				TPlControlmeasure ctrl = (TPlControlmeasure) ctrlList.get(i);
				if (ctrl.getCtrlType().equals("1")) {
					map.put("lmtCtrl", ctrl.getConmeasCode());
					this.setDateDicVal("113", map, "lmtCtrl");
				} else if (ctrl.getCtrlType().equals("2")) {
					map.put("riskCtrl", ctrl.getConmeasCode());
					this.setDateDicVal("114", map, "riskCtrl");
					if (ctrl.getConmeasCode().equals("SS")
							&& StringUtils.isNotEmpty(ctrl.getOtherCtrlDesc())) {
						map.put("riskCtrl",
								"其他措施（其他措施说明：" + ctrl.getOtherCtrlDesc() + "）");
					}
				} else if (ctrl.getCtrlType().equals("3")) {
					apdCtrl = apdCtrl + ctrl.getConmeasCode() + ",";
				}
			}
			if (StringUtils.isNotEmpty(apdCtrl)) {
				map.put("appendCtrl", apdCtrl);
				setDateDicVals("115", map, "appendCtrl");
			}
		}
		if (StringUtils.isNotEmpty(report.getApplyOpin())) {
			map.put("applyOpin", report.getApplyOpin());
		}
		// 预警信息
		List<Map<String, Object>> warnList = TPlDqMonitorService.getInstance()
				.dwrGetReportWarnInfo(report.getLoanAcct());
		if (warnList != null && warnList.size() > 0) {
			for (int i = 0; i < warnList.size(); i++) {
				String warnLevel = warnList.get(i).get("WARN_LEVEL").toString();
				if (warnLevel.equals(TPlDqMonitorService.RED_WARN_LEVEL)) {
					map.put("redWarnCount", warnList.get(i).get("COUNT_"));
				} else if (warnLevel
						.equals(TPlDqMonitorService.ORANGE_WARN_LEVEL)) {
					map.put("orangeWarnCount", warnList.get(i).get("COUNT_"));
				} else if (warnLevel
						.equals(TPlDqMonitorService.YELLOW_WARN_LEVEL)) {
					map.put("yellowWarnCount", warnList.get(i).get("COUNT_"));
				}
			}
		}
		// 股东信息
		List<TPlDqReportJyPartner> partnerList = rootDao
				.queryByCondition("from TPlDqReportJyPartner t where 1=1 and businessid='"
						+ reportId + "' ");
		if (partnerList != null && partnerList.size() > 0) {
			map.put("partnerList", partnerList);
		}
		// 在本行授信业务列表
		List<TPlDqReportJyCreditBusin> creditBusinList = rootDao
				.queryByCondition("from TPlDqReportJyCreditBusin t where 1=1 and businessid='"
						+ reportId + "' ");
		if (creditBusinList != null && creditBusinList.size() > 0) {
			map.put("creditBusinList", creditBusinList);
		}
		// 在本行担保信息列表
		List<TPlDqReportJyGuarant> guarantList = rootDao
				.queryByCondition("from TPlDqReportJyGuarant t where 1=1 and businessid='"
						+ reportId + "' ");
		if (guarantList != null && guarantList.size() > 0) {
			map.put("guarantList", guarantList);
		}
		// 借款人抵押物明细
		List<TPlDqReportJyMortgage> mortgageList = rootDao
				.queryByCondition("from TPlDqReportJyMortgage t where 1=1 and assusort='D' and businessid='"
						+ reportId + "' ");
		if (mortgageList != null && mortgageList.size() > 0) {
			map.put("mortgageList", mortgageList);
		}
		// 借款人质押物明细
		List<TPlDqReportJyMortgage> zyList = rootDao
				.queryByCondition("from TPlDqReportJyMortgage t where 1=1 and assusort='Z' and businessid='"
						+ reportId + "' ");
		if (zyList != null && zyList.size() > 0) {
			map.put("zyList", zyList);
		}
	}

	private String getIfChange(String f) {
		return "1".equals(f) ? "发生变化" : "未发生变化";
	}

	@SuppressWarnings("unchecked")
	public void setXfMapValue(Map<String, Object> map, String reportId)
			throws CommonException {
		ROOTDAO rootDao = ROOTDAOUtils.getROOTDAO();
		List<TPlReportRelation> list = rootDao
				.queryByCondition(" from TPlReportRelation where businessId='"
						+ reportId + "'");
		TPlDqReportXf report = TPlDqReportXfService.getInstance().get(
				list.get(0).getReportId());
		map.put("mobilecall",report.getMobilecall());
		map.put("contaddr",report.getContaddr());
		map.put("loanVariety", report.getLoanVariety());
		map.put("custCode", report.getCustCode());
		map.put("custName", report.getCustName());
		map.put("certType", report.getCertType());
		this.setDateDicVal("21", map, "certType");
		map.put("certCode", report.getCertCode());
		map.put("coopObj", report.getCoopObj());
		map.put("coopObjName", report.getCoopObjName());
		map.put("loanAmt", report.getLoanAmt());
		map.put("loanBalance", report.getLoanBalance());
		map.put("issueDate", report.getIssueDate());
		map.put("completeDate", report.getCompleteDate());
		map.put("issueAmt", report.getIssueAmt());
		map.put("guarWay", report.getGuarWay());
		this.setDateDicVal("123", map, "guarWay");
		map.put("gageCode", report.getGageCode());
		map.put("arrearAmt", report.getArrearAmt());
		map.put("arrearInte", report.getArrearInte());
		map.put("riskStatus", report.getRiskStatus());
		this.setDateDicVal("122", map, "riskStatus");
		map.put("acctStatus", report.getAcctStatus());
		this.setDateDicVal("120", map, "acctStatus");
		map.put("checkPerCode", report.getCheckPerCode());
		map.put("lendCode", report.getLendCode());
		

		String str = "";
		if (StringUtils.isNotEmpty(report.getCheckWay()) && report.getCheckWay().equals("1")) {
			str = report.getCheckPlace() != null ? report.getCheckPlace() : "";
			String str1 = report.getCheckDate() != null ? report.getCheckDate()
					.toString() : "";
			map.put("checkWay", "现场（场所：" + str + " 时间：" + str1 + " ）");
		} else if (StringUtils.isNotEmpty(report.getCheckWay()) && report.getCheckWay().equals("2")) {
			str = report.getCheckType() != null ? report.getCheckType() : "";
			map.put("checkWay", "非现场（检查方式：" + str + "）");
		}
		if (StringUtils.isNotEmpty(report.getHealthCond()) && report.getHealthCond().equals("1")) {
			map.put("healthCond", "良好");
		} else if (StringUtils.isNotEmpty(report.getHealthCond()) && report.getHealthCond().equals("2")) {
			map.put("healthCond", "较差");
		} else if (StringUtils.isNotEmpty(report.getHealthCond()) && report.getHealthCond().equals("3")) {
			map.put("healthCond", "死亡");
		}
		if (StringUtils.isNotEmpty(report.getMarriageCond()) && report.getMarriageCond().equals("1")) {
			map.put("marriageCond", "未婚");
		} else if (StringUtils.isNotEmpty(report.getMarriageCond()) && report.getMarriageCond().equals("2")) {
			map.put("marriageCond", "已婚");
		} else if (StringUtils.isNotEmpty(report.getMarriageCond()) && report.getMarriageCond().equals("3")) {
			map.put("marriageCond", "离异");
		}
		if (StringUtils.isNotEmpty(report.getContactWay()) && report.getContactWay().equals("1")) {
			map.put("contactWay", "无变化");
		} else if (StringUtils.isNotEmpty(report.getContactWay()) && report.getContactWay().equals("2")) {
			str = report.getContactWayUpd() != null ? report.getContactWayUpd()
					: "";
			map.put("contactWay", "已变更（地址/电话更新：" + str + "）");
		}
		if (StringUtils.isNotEmpty(report.getProfession()) && report.getProfession().equals("1")) {
			map.put("profession", "无变化");
		} else if (StringUtils.isNotEmpty(report.getProfession()) && report.getProfession().equals("2")) {
			str = report.getProfessionUpd() != null ? report.getProfessionUpd()
					: "";
			map.put("profession", "已变更（单位更新：" + str + "）");
		}
		if (StringUtils.isNotEmpty(report.getProperty()) && report.getProperty().equals("1")) {
			map.put("property", "无变化");
		} else if (StringUtils.isNotEmpty(report.getProperty()) && report.getProperty().equals("2")) {
			map.put("property", "减少");
		} else if (StringUtils.isNotEmpty(report.getProperty()) && report.getProperty().equals("3")) {
			map.put("property", "增加");
		}
		if (StringUtils.isNotEmpty(report.getIncome()) && report.getIncome().equals("1")) {
			map.put("income", "无变化");
		} else if (StringUtils.isNotEmpty(report.getIncome()) && report.getIncome().equals("2")) {
			map.put("income", "减少");
		} else if (StringUtils.isNotEmpty(report.getIncome()) && report.getIncome().equals("3")) {
			map.put("income", "增加");
		}
		if (StringUtils.isNotEmpty(report.getLiabilities()) && report.getLiabilities().equals("1")) {
			map.put("liabilities", "无变化");
		} else if (StringUtils.isNotEmpty(report.getLiabilities()) && report.getLiabilities().equals("2")) {
			map.put("liabilities", "减少");
		} else if (StringUtils.isNotEmpty(report.getLiabilities()) && report.getLiabilities().equals("3")) {
			map.put("liabilities", "增加");
		}
		if (StringUtils.isNotEmpty(report.getIfinflrepmt())) {
			map.put("ifinflrepmt", getStringBool(report.getIfinflrepmt()));
		}
		map.put("pledgeAddr", report.getPledgeAddr());
		if (StringUtils.isNotEmpty(report.getPledgeStatus()) && report.getPledgeStatus().equals("1")) {
			map.put("pledgeStatus", "完好");
		} else if (StringUtils.isNotEmpty(report.getPledgeStatus()) && report.getPledgeStatus().equals("2")) {
			map.put("pledgeStatus", "残损");
		} else if (StringUtils.isNotEmpty(report.getPledgeStatus()) && report.getPledgeStatus().equals("3")) {
			map.put("pledgeStatus", "灭失");
		}
		if (StringUtils.isNotEmpty(report.getPledgeValueChange()) && report.getPledgeValueChange().equals("1")) {
			map.put("pledgeValueChange", "未变");
		} else if (StringUtils.isNotEmpty(report.getPledgeValueChange()) && report.getPledgeValueChange().equals("2")) {
			map.put("pledgeValueChange", "减少");
		} else if (StringUtils.isNotEmpty(report.getPledgeValueChange()) && report.getPledgeValueChange().equals("3")) {
			map.put("pledgeValueChange", "增加");
		}
		if (StringUtils.isNotEmpty(report.getPledgeValue())) {
			map.put("pledgeValue", report.getPledgeValue());
		}
		if (StringUtils.isNotEmpty(report.getPledgeOwner()) && report.getPledgeOwner().equals("1")) {
			map.put("pledgeOwner", "自用");
		} else if (StringUtils.isNotEmpty(report.getPledgeOwner()) && report.getPledgeOwner().equals("2")) {
			map.put("pledgeOwner", "出租");
		} else if (StringUtils.isNotEmpty(report.getPledgeOwner()) && report.getPledgeOwner().equals("3")) {
			map.put("pledgeOwner", "空置");
		} else if (StringUtils.isNotEmpty(report.getPledgeOwner()) && report.getPledgeOwner().equals("4")) {
			map.put("pledgeOwner", "其他异常");
		}
		if (StringUtils.isNotEmpty(report.getPledgeOwnerDesc())) {
			map.put("pledgeOwnerDesc", report.getPledgeOwnerDesc());
		}
		if (StringUtils.isNotEmpty(report.getGuarPerson()) && report.getGuarPerson().equals("1")) {
			map.put("guarPerson", "无变动");
		} else if (StringUtils.isNotEmpty(report.getGuarPerson()) && report.getGuarPerson().equals("2")) {
			str = report.getGuarPerName() != null ? report.getGuarPerName()
					: "";
			String str2 = report.getGuarPerPhone() != null ? report
					.getGuarPerPhone() : "";
			map.put("guarPerson", "变动（保证人姓名/名称变动：" + str + "，保证人地址/电话变动："
					+ str2 + "）");
		}
		if (StringUtils.isNotEmpty(report.getGuarPerLia()) && report.getGuarPerLia().equals("1")) {
			map.put("guarPerLia", "未变");
		} else if (StringUtils.isNotEmpty(report.getGuarPerLia()) && report.getGuarPerLia().equals("2")) {
			map.put("guarPerLia", "减少");
		} else if (StringUtils.isNotEmpty(report.getGuarPerLia()) && report.getGuarPerLia().equals("3")) {
			map.put("guarPerLia", "增加");
		}
		if (report.getGuarPerLiaAmt() != null) {
			map.put("guarPerLiaAmt", report.getGuarPerLiaAmt());
		}
		if (StringUtils.isNotEmpty(report.getGuarAbility()) && report.getGuarAbility().equals("1")) {
			map.put("guarAbility", "强");
		} else if (StringUtils.isNotEmpty(report.getGuarAbility()) && report.getGuarAbility().equals("2")) {
			map.put("guarAbility", "中");
		} else if (StringUtils.isNotEmpty(report.getGuarAbility()) && report.getGuarAbility().equals("3")) {
			map.put("guarAbility", "弱");
		} else if (StringUtils.isNotEmpty(report.getGuarAbility()) && report.getGuarAbility().equals("4")) {
			map.put("guarAbility", "无");
		}
		List ctrlList = rootDao.getHibernateTemplate().find(
				"from TPlControlmeasure where taskId='" + reportId + "'");
		if (ctrlList != null && ctrlList.size() > 0) {
			String apdCtrl = "";
			for (int i = 0; i < ctrlList.size(); i++) {
				TPlControlmeasure ctrl = (TPlControlmeasure) ctrlList.get(i);
				if (ctrl.getCtrlType().equals("1")) {
					map.put("lmtCtrl", ctrl.getConmeasCode());
					this.setDateDicVal("113", map, "lmtCtrl");
				} else if (ctrl.getCtrlType().equals("2")) {
					map.put("riskCtrl", ctrl.getConmeasCode());
					this.setDateDicVal("114", map, "riskCtrl");
					if (ctrl.getConmeasCode().equals("SS")
							&& StringUtils.isNotEmpty(ctrl.getOtherCtrlDesc())) {
						map.put("riskCtrl",
								"其他措施（其他措施说明：" + ctrl.getOtherCtrlDesc() + "）");
					}
				} else if (ctrl.getCtrlType().equals("3")) {
					apdCtrl = apdCtrl + ctrl.getConmeasCode() + ",";
				}
			}
			if (StringUtils.isNotEmpty(apdCtrl)) {
				map.put("appendCtrl", apdCtrl);
				setDateDicVals("115", map, "appendCtrl");
			}
		}
		if (StringUtils.isNotEmpty(report.getApplyOpin())) {
			map.put("applyOpin", report.getApplyOpin());
		}
	}

	@SuppressWarnings("unchecked")
	public void setAjMapValue(Map<String, Object> map, String reportId,String loanAcct)
			throws CommonException {
		ROOTDAO rootDao = ROOTDAOUtils.getROOTDAO();
		List<TPlReportRelation> list = rootDao
				.queryByCondition(" from TPlReportRelation where businessId='"
						+ reportId + "'");
		TPlDqReportAj report = TPlDqReportAjService.getInstance().get(
				list.get(0).getReportId());
		report.setLoanId(loanAcct);
		map.put("mobilecall",report.getMobilecall());
		map.put("contaddr",report.getContaddr());
		map.put("loanVariety", report.getLoanVariety());
		map.put("custCode", report.getCustCode());
		map.put("custName", report.getCustName());
		map.put("certType", report.getCertType());
		this.setDateDicVal("21", map, "certType");
		map.put("certCode", report.getCertCode());
		map.put("coopObj", report.getCoopObj());
		map.put("coopObjName", report.getCoopObjName());
		map.put("loanAmt", report.getLoanAmt());
		map.put("loanBalance", report.getLoanBalance());
		map.put("issueDate", report.getIssueDate());
		map.put("completeDate", report.getCompleteDate());
		map.put("issueAmt", report.getIssueAmt());
		map.put("guarWay", report.getGuarWay());
		this.setDateDicVal("123", map, "guarWay");
		map.put("gageCode", report.getGageCode());
		map.put("arrearAmt", report.getArrearAmt());
		map.put("arrearInte", report.getArrearInte());
		map.put("riskStatus", report.getRiskStatus());
		this.setDateDicVal("122", map, "riskStatus");
		map.put("acctStatus", report.getAcctStatus());
		this.setDateDicVal("120", map, "acctStatus");
		map.put("checkPerCode", report.getCheckPerCode());
		map.put("lendCode", report.getLendCode());
		map.put("loanId", report.getLoanId());

		String str = "";
		if (StringUtils.isNotEmpty(report.getCheckWay()) && report.getCheckWay().equals("1")) {
			str = report.getCheckPlace() != null ? report.getCheckPlace() : "";
			String str1 = report.getCheckDate() != null ? report.getCheckDate()
					.toString() : "";
			map.put("checkWay", "现场（场所：" + str + " 时间：" + str1 + " ）");
		} else if (StringUtils.isNotEmpty(report.getCheckWay()) && report.getCheckWay().equals("2")) {
			str = report.getCheckType() != null ? report.getCheckType() : "";
			map.put("checkWay", "非现场（检查方式：" + str + "）");
		}
		if (StringUtils.isNotEmpty(report.getHealthCond()) && report.getHealthCond().equals("1")) {
			map.put("healthCond", "良好");
		} else if (StringUtils.isNotEmpty(report.getHealthCond()) && report.getHealthCond().equals("2")) {
			map.put("healthCond", "较差");
		} else if (StringUtils.isNotEmpty(report.getHealthCond()) && report.getHealthCond().equals("3")) {
			map.put("healthCond", "死亡");
		}
		if (StringUtils.isNotEmpty(report.getMarriageCond()) && report.getMarriageCond().equals("1")) {
			map.put("marriageCond", "未婚");
		} else if (StringUtils.isNotEmpty(report.getMarriageCond()) && report.getMarriageCond().equals("2")) {
			map.put("marriageCond", "已婚");
		} else if (StringUtils.isNotEmpty(report.getMarriageCond()) && report.getMarriageCond().equals("3")) {
			map.put("marriageCond", "离异");
		}
		if (StringUtils.isNotEmpty(report.getContactWay()) && report.getContactWay().equals("1")) {
			map.put("contactWay", "无变化");
		} else if (StringUtils.isNotEmpty(report.getContactWay()) && report.getContactWay().equals("2")) {
			str = report.getContactWayUpd() != null ? report.getContactWayUpd()
					: "";
			map.put("contactWay", "已变更（地址/电话更新：" + str + "）");
		}
		if (StringUtils.isNotEmpty(report.getProfession()) && report.getProfession().equals("1")) {
			map.put("profession", "无变化");
		} else if (StringUtils.isNotEmpty(report.getProfession()) && report.getProfession().equals("2")) {
			str = report.getProfessionUpd() != null ? report.getProfessionUpd()
					: "";
			map.put("profession", "已变更（单位更新：" + str + "）");
		}
		if (StringUtils.isNotEmpty(report.getProperty()) && report.getProperty().equals("1")) {
			map.put("property", "无变化");
		} else if (StringUtils.isNotEmpty(report.getProperty()) && report.getProperty().equals("2")) {
			map.put("property", "减少");
		} else if (StringUtils.isNotEmpty(report.getProperty()) && report.getProperty().equals("3")) {
			map.put("property", "增加");
		}
		if (StringUtils.isNotEmpty(report.getIncome()) && report.getIncome().equals("1")) {
			map.put("income", "无变化");
		} else if (StringUtils.isNotEmpty(report.getIncome()) && report.getIncome().equals("2")) {
			map.put("income", "减少");
		} else if (StringUtils.isNotEmpty(report.getIncome()) && report.getIncome().equals("3")) {
			map.put("income", "增加");
		}
		if (StringUtils.isNotEmpty(report.getLiabilities()) && report.getLiabilities().equals("1")) {
			map.put("liabilities", "无变化");
		} else if (StringUtils.isNotEmpty(report.getLiabilities()) && report.getLiabilities().equals("2")) {
			map.put("liabilities", "减少");
		} else if (StringUtils.isNotEmpty(report.getLiabilities()) && report.getLiabilities().equals("3")) {
			map.put("liabilities", "增加");
		}
		if (StringUtils.isNotEmpty(report.getIfinflrepmt())) {
			map.put("ifinflrepmt", getStringBool(report.getIfinflrepmt()));
		}
		map.put("pledgeAddr", report.getPledgeAddr());
		if (StringUtils.isNotEmpty(report.getPledgeStatus()) && report.getPledgeStatus().equals("1")) {
			map.put("pledgeStatus", "完好");
		} else if (StringUtils.isNotEmpty(report.getPledgeStatus()) && report.getPledgeStatus().equals("2")) {
			map.put("pledgeStatus", "残损");
		} else if (StringUtils.isNotEmpty(report.getPledgeStatus()) && report.getPledgeStatus().equals("3")) {
			map.put("pledgeStatus", "灭失");
		}
		if (StringUtils.isNotEmpty(report.getPledgeValueChange()) && report.getPledgeValueChange().equals("1")) {
			map.put("pledgeValueChange", "未变");
		} else if (StringUtils.isNotEmpty(report.getPledgeValueChange()) && report.getPledgeValueChange().equals("2")) {
			map.put("pledgeValueChange", "减少");
		} else if (StringUtils.isNotEmpty(report.getPledgeValueChange()) && report.getPledgeValueChange().equals("3")) {
			map.put("pledgeValueChange", "增加");
		}
		if (StringUtils.isNotEmpty(report.getPledgeValue())) {
			map.put("pledgeValue", report.getPledgeValue());
		}
		if (StringUtils.isNotEmpty(report.getPledgeOwner()) && report.getPledgeOwner().equals("1")) {
			map.put("pledgeOwner", "自用");
		} else if (StringUtils.isNotEmpty(report.getPledgeOwner()) && report.getPledgeOwner().equals("2")) {
			map.put("pledgeOwner", "出租");
		} else if (StringUtils.isNotEmpty(report.getPledgeOwner()) && report.getPledgeOwner().equals("3")) {
			map.put("pledgeOwner", "空置");
		} else if (StringUtils.isNotEmpty(report.getPledgeOwner()) && report.getPledgeOwner().equals("4")) {
			map.put("pledgeOwner", "其他异常");
		}
		if (StringUtils.isNotEmpty(report.getPledgeOwnerDesc())) {
			map.put("pledgeOwnerDesc", report.getPledgeOwnerDesc());
		}
		if (StringUtils.isNotEmpty(report.getGuarPerson()) && report.getGuarPerson().equals("1")) {
			map.put("guarPerson", "无变动");
		} else if (StringUtils.isNotEmpty(report.getGuarPerson()) && report.getGuarPerson().equals("2")) {
			str = report.getGuarPerName() != null ? report.getGuarPerName()
					: "";
			String str2 = report.getGuarPerPhone() != null ? report
					.getGuarPerPhone() : "";
			map.put("guarPerson", "变动（保证人姓名/名称变动：" + str + "，保证人地址/电话变动："
					+ str2 + "）");
		}
		if (StringUtils.isNotEmpty(report.getGuarPerLia()) && report.getGuarPerLia().equals("1")) {
			map.put("guarPerLia", "未变");
		} else if (StringUtils.isNotEmpty(report.getGuarPerLia()) && report.getGuarPerLia().equals("2")) {
			map.put("guarPerLia", "减少");
		} else if (StringUtils.isNotEmpty(report.getGuarPerLia()) && report.getGuarPerLia().equals("3")) {
			map.put("guarPerLia", "增加");
		}
		if (report.getGuarPerLiaAmt() != null) {
			map.put("guarPerLiaAmt", report.getGuarPerLiaAmt());
		}
		if (StringUtils.isNotEmpty(report.getGuarAbility()) && report.getGuarAbility().equals("1")) {
			map.put("guarAbility", "强");
		} else if (StringUtils.isNotEmpty(report.getGuarAbility()) && report.getGuarAbility().equals("2")) {
			map.put("guarAbility", "中");
		} else if (StringUtils.isNotEmpty(report.getGuarAbility()) && report.getGuarAbility().equals("3")) {
			map.put("guarAbility", "弱");
		} else if (StringUtils.isNotEmpty(report.getGuarAbility()) && report.getGuarAbility().equals("4")) {
			map.put("guarAbility", "无");
		}
		if (StringUtils.isNotEmpty(report.getCoopItem())) {
			if (report.getCoopItem().indexOf(",") > -1) {
				String[] coopItems = report.getCoopItem().split(",");
				String coopItem = "";
				for (int i = 0; i < coopItems.length; i++) {
					coopItem = coopItem + getCoopItemValue(coopItems[i]) + ",";
				}
				coopItem = coopItem.substring(0, coopItem.length() - 1);
				map.put("coopItem", coopItem);
			} else {
				map.put("coopItem", getCoopItemValue(report.getCoopItem()));
			}
		}
		if (StringUtils.isNotEmpty(report.getDevComp())) {
			map.put("devComp", report.getDevComp());
		}
		if (StringUtils.isNotEmpty(report.getMediumComp())) {
			map.put("mediumComp", report.getMediumComp());
		}
		if (StringUtils.isNotEmpty(report.getGuarComp())) {
			map.put("guarComp", report.getGuarComp());
		}
		if (StringUtils.isNotEmpty(report.getProjectEvolve()) && report.getProjectEvolve().equals("1")) {
			map.put("projectEvolve", "正常");
		} else if (StringUtils.isNotEmpty(report.getProjectEvolve()) && report.getProjectEvolve().equals("2")) {
			str = report.getExceDesc() != null ? report.getExceDesc() : "";
			map.put("projectEvolve", "异常（异常情况说明：" + str + "）");
		}
		if (StringUtils.isNotEmpty(report.getDeliverCond()) && report.getDeliverCond().equals("1")) {
			map.put("deliverCond", "正常");
		} else if (StringUtils.isNotEmpty(report.getDeliverCond()) && report.getDeliverCond().equals("2")) {
			str = report.getPostpDesc() != null ? report.getPostpDesc() : "";
			map.put("deliverCond", "延期（延期情况说明：" + str + "）");
		}
		if (StringUtils.isNotEmpty(report.getTranCardCond()) && report.getTranCardCond().equals("1")) {
			map.put("tranCardCond", "已办理");
		} else if (StringUtils.isNotEmpty(report.getTranCardCond()) && report.getTranCardCond().equals("2")) {
			map.put("tranCardCond", "未办理");
		} else if (StringUtils.isNotEmpty(report.getTranCardCond()) && report.getTranCardCond().equals("3")) {
			str = report.getTranCardCondDesc() != null ? report
					.getTranCardCondDesc() : "";
			map.put("tranCardCond", "长期无法办理（情况说明：" + str + "）");
		}
		List ctrlList = rootDao.getHibernateTemplate().find(
				"from TPlControlmeasure where taskId='" + reportId + "'");
		if (ctrlList != null && ctrlList.size() > 0) {
			String apdCtrl = "";
			for (int i = 0; i < ctrlList.size(); i++) {
				TPlControlmeasure ctrl = (TPlControlmeasure) ctrlList.get(i);
				if (ctrl.getCtrlType().equals("1")) {
					map.put("lmtCtrl", ctrl.getConmeasCode());
					this.setDateDicVal("113", map, "lmtCtrl");
				} else if (ctrl.getCtrlType().equals("2")) {
					map.put("riskCtrl", ctrl.getConmeasCode());
					this.setDateDicVal("114", map, "riskCtrl");
					if (ctrl.getConmeasCode().equals("SS")
							&& StringUtils.isNotEmpty(ctrl.getOtherCtrlDesc())) {
						map.put("riskCtrl",
								"其他措施（其他措施说明：" + ctrl.getOtherCtrlDesc() + "）");
					}
				} else if (ctrl.getCtrlType().equals("3")) {
					apdCtrl = apdCtrl + ctrl.getConmeasCode() + ",";
				}
			}
			if (StringUtils.isNotEmpty(apdCtrl)) {
				map.put("appendCtrl", apdCtrl);
				setDateDicVals("115", map, "appendCtrl");
			}
		}
		if (StringUtils.isNotEmpty(report.getApplyOpin())) {
			map.put("applyOpin", report.getApplyOpin());
		}
	}

	private String getCoopItemValue(String coopItem) {
		if (coopItem.equals("1")) {
			return "楼盘开发商";
		} else if (coopItem.equals("2")) {
			return "中介公司";
		} else if (coopItem.equals("3")) {
			return "担保公司";
		} else if (coopItem.equals("4")) {
			return "其他";
		}
		return "";
	}

	/**
	 * 根据字典码 与值 找到名称
	 * 
	 * @param dataTypeNo
	 * @param dataNo
	 * @return
	 */
	private void setDateDicVals(String dataTypeNo, Map<String, Object> dataMap,
			String praNames) {
		String dataNo = (String) dataMap.get(praNames);
		if (StringUtils.isBlank(dataTypeNo) || StringUtils.isBlank(dataNo)
				|| " ".equals(dataNo)) {
			dataMap.put(praNames, " ");
		}
		CommonService comService = CommonService.getInstance();
		List<DataDic> list = (List<DataDic>) comService
				.queryListHQL("from DataDic t where dataTypeNo=" + dataTypeNo);
		if (list != null && list.size() > 0) {
			String names = "";
			if (dataNo.indexOf(",") > -1) {
				String[] dataNos = dataNo.split(",");
				for (int i = 0; i < dataNos.length; i++) {
					for (DataDic dic : list) {
						if (dataNos[i].equals(dic.getDataNo())) {
							names = names + dic.getDataName() + ",";
							break;
						}
					}
				}
				if (StringUtils.isNotEmpty(names)) {
					names = names.substring(0, names.length() - 1);
				}
				dataMap.put(praNames, names);
			} else {
				for (DataDic dic : list) {
					if (dic.getDataNo().equals(praNames)) {
						dataMap.put(praNames, dic.getDataName());
						break;
					}
				}
			}
		} else {
			dataMap.put(praNames, " ");
		}
	}

	/**
	 * 根据业务ID获取流程审批信息
	 * @param businessId
	 * @return
	 */
	private String findProcessRemarkByBusinessId(String businessId){
		String processRemarkStr="";
		try {
			List<ExtProcessOpinion> list=ProcessManagerService.getInstace().findProcessHistoryOpinions(businessId);
			for (ExtProcessOpinion extProcessOpinion : list) {
				String str="	"+extProcessOpinion.getTaskName();
				str+=","+extProcessOpinion.getAssignee();
				str+=","+extProcessOpinion.getStartTime();
				str+=","+extProcessOpinion.getEndTime();
				str+=","+extProcessOpinion.getOperation();
				str+=","+extProcessOpinion.getOpinion()+";	 ";
				processRemarkStr+=str;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return processRemarkStr;
	}
	public static void main(String[] args) {
		Map<String, Object> map = new HashMap<String, Object>();
		TPlZxrfInfo info = new TPlZxrfInfo();
		info.setId("111");
		Class cla = info.getClass();

		Field[] fieldList = info.getClass().getDeclaredFields();

		for (Field field : fieldList) {
			field.setAccessible(true);
			try {

				map.put(field.getName(), field.get(info));
			} catch (Exception e) {
				e.printStackTrace();
				continue;
			}
		}

		for (Entry<String, Object> mapEn : map.entrySet()) {

			System.out
					.println(mapEn.getKey() + "----------" + mapEn.getValue());
		}

	}

}
