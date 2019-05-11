package com.huateng.ebank.business.dataquery.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

import com.huateng.ebank.business.dataquery.bean.SupplyEnterVerifyStateQueryBean;
import com.huateng.ebank.entity.dao.mng.ROOTDAO;
import com.huateng.ebank.entity.dao.mng.ROOTDAOUtils;
import com.huateng.ebank.entity.data.mng.DataDic;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ApplicationContextUtils;
import com.huateng.report.common.service.ReportCommonService;
import com.huateng.report.constants.TopReportConstants;
import com.huateng.report.utils.ReportUtils;

public class SupplyEntryVerifyStateQueryService {

	private static final String HQL_TABLENAME = "TABLENAME";

	public synchronized static SupplyEntryVerifyStateQueryService getInstance() {
		return (SupplyEntryVerifyStateQueryService) ApplicationContextUtils
				.getBean(SupplyEntryVerifyStateQueryService.class.getName());
	}

	@SuppressWarnings("unchecked")
	public List<SupplyEnterVerifyStateQueryBean> pageQueryByHql(String workdateStart, String workdateEnd, String brno,
			String busiType, String apptype, String currentfile) throws CommonException {

		/**
		 * 并接SQL语句，按照BRNO, APPTYPE, CURRENTFILE, RECSTATUS进行分组，然后取每组的记录数
		 */
		StringBuilder countHql = new StringBuilder();
		countHql.append(" SELECT brNo, apptype, currentfile, recStatus, count(*) AS stacount,workDate FROM ").append(
				HQL_TABLENAME).append(" WHERE repStatus <> ? ");
		List<Object> paralist = new ArrayList<Object>();
		paralist.add(TopReportConstants.REPORT_REPSTATUS_01);
		if (StringUtils.isNotEmpty(workdateStart)) {
			countHql.append(" AND workDate >= ? ");
			paralist.add(workdateStart);
		}
		if (StringUtils.isNotEmpty(workdateEnd)) {
			countHql.append(" AND workDate <= ? ");
			paralist.add(workdateEnd);
		}
		if (StringUtils.isNotEmpty(brno)) {
			countHql.append(" AND brNo = ? ");
			paralist.add(brno);
		}
		if (StringUtils.isNotEmpty(currentfile)) {
			countHql.append(" AND currentfile = ? ");
			paralist.add(currentfile);
		}
		countHql.append(" GROUP BY brNo, apptype, currentfile, recStatus,workDate ORDER BY workDate");

		ReportCommonService reportCommonService = ReportCommonService.getInstance();
		Map<String, List<DataDic>> map = reportCommonService.getAppAndFileTypeByDataDic(busiType, apptype, currentfile);

		Set<String> tablenameSet = ReportUtils.getTableName(map);// 获取表名

		List<SupplyEnterVerifyStateQueryBean> list = new ArrayList<SupplyEnterVerifyStateQueryBean>();

		Map<String, SupplyEnterVerifyStateQueryBean> resultMap = new HashMap<String, SupplyEnterVerifyStateQueryBean>();
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		for (String tablename : tablenameSet) {
			if (tablename!=null) {
				String hql = countHql.toString().replaceAll(HQL_TABLENAME, StringUtils.trim(tablename));
				List<Object[]> groupList = rootdao.queryByQL2List(hql, paralist.toArray(), null);
				getResultMap(resultMap, groupList);
			}
		}
		for (Iterator<String> iterator = resultMap.keySet().iterator(); iterator.hasNext();) {
			String key =  iterator.next();
			list.add(resultMap.get(key));
		}

		return list;

	}

	private void getResultMap(Map<String, SupplyEnterVerifyStateQueryBean> resultMap, List<Object[]> groupList) {
		for (Object[] obj : groupList) {
			String brno = String.valueOf(obj[0]);
			String apptype = String.valueOf(obj[1]);
			String filetype = String.valueOf(obj[2]);
			String recstatus = String.valueOf(obj[3]);
			String workdate = obj[5].toString();
			int count = Integer.parseInt(obj[4].toString());
			String key = brno + "@" + apptype + "@" + filetype + "@" + workdate;
			SupplyEnterVerifyStateQueryBean bean = null;
			if (resultMap.containsKey(key)) {
				bean = resultMap.get(key);
				if (StringUtils.equals(recstatus, TopReportConstants.REPORT_RECSTATUS_01)) {
					bean.setNoedit(count);
				} else if (StringUtils.equals(recstatus, TopReportConstants.REPORT_RECSTATUS_02)) {
					bean.setEditWaitConfirm(count);
				} else if (StringUtils.equals(recstatus, TopReportConstants.REPORT_RECSTATUS_03)) {
					bean.setConfirmWaitAudit(count);
				} else if (StringUtils.equals(recstatus, TopReportConstants.REPORT_RECSTATUS_04)) {
					bean.setAuditWaitConfirm(count);
				} else if (StringUtils.equals(recstatus, TopReportConstants.REPORT_RECSTATUS_05)) {
					bean.setConfirmPass(count);
				} else if (StringUtils.equals(recstatus, TopReportConstants.REPORT_RECSTATUS_06)) {
					bean.setSendreport(count);
				}
			}else{
				bean = createQueryBean(obj);
				resultMap.put(key, bean);
			}
		}
	}

	@SuppressWarnings("unchecked")
	private SupplyEnterVerifyStateQueryBean createQueryBean(Object[] obj) {

		SupplyEnterVerifyStateQueryBean bean = new SupplyEnterVerifyStateQueryBean();
		bean.setBrNo(String.valueOf(obj[0]));
		bean.setApptype(String.valueOf(obj[1]));
		bean.setCurrentfile(String.valueOf(obj[2]));
		String recstatus = String.valueOf(obj[3]);
		int count = Integer.parseInt(obj[4].toString());
		bean.setWorkDate(obj[5].toString());
		if (StringUtils.equals(recstatus, TopReportConstants.REPORT_RECSTATUS_01)) {
			bean.setNoedit(count);
		} else if (StringUtils.equals(recstatus, TopReportConstants.REPORT_RECSTATUS_02)) {
			bean.setEditWaitConfirm(count);
		} else if (StringUtils.equals(recstatus, TopReportConstants.REPORT_RECSTATUS_03)) {
			bean.setConfirmWaitAudit(count);
		} else if (StringUtils.equals(recstatus, TopReportConstants.REPORT_RECSTATUS_04)) {
			bean.setAuditWaitConfirm(count);
		} else if (StringUtils.equals(recstatus, TopReportConstants.REPORT_RECSTATUS_05)) {
			bean.setConfirmPass(count);
		} else if (StringUtils.equals(recstatus, TopReportConstants.REPORT_RECSTATUS_06)) {
			bean.setSendreport(count);
		}
		return bean;
	}

}