package com.gbicc.person.monitor.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.jdbc.core.JdbcTemplate;

import com.gbicc.common.CommonService;
import com.gbicc.person.monitor.dao.TPlDqMonitorDAO;
import com.gbicc.person.monitor.entity.TPlControlmeasure;
import com.gbicc.person.monitor.entity.TPlDqMonitor;
import com.gbicc.person.monitor.entity.TPlDqReportAj;
import com.gbicc.person.monitor.entity.TPlDqReportJy;
import com.gbicc.person.monitor.entity.TPlDqReportXf;
import com.gbicc.person.monitor.entity.TPlReportRelation;
import com.gbicc.person.monitor.entity.TPlYjReport;
import com.gbicc.person.monitor.entity.TPlYtReport;
import com.gbicc.util.JsonUtils;
import com.huateng.ebank.business.common.service.DataDicService;
import com.huateng.ebank.entity.dao.mng.ROOTDAO;
import com.huateng.ebank.entity.dao.mng.ROOTDAOUtils;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ApplicationContextUtils;

/**
 * 
 * @author likm
 * @time   2015年11月6日09:56:40
 * @desc   定期监控报告服务类
 */
public class TPlDqMonitorService {
	
	/**
	 * 黄色预警等级
	 */
	public static final String YELLOW_WARN_LEVEL="1";
	/**
	 * 橙色预警等级
	 */
	public static final String ORANGE_WARN_LEVEL="2";
	/**
	 * 红色预警等级
	 */
	public static final String RED_WARN_LEVEL="3";
	/**
	 * 监控频率字典码
	 */
	public static final Integer FREQUENCY_DIC=703;
	
	public TPlDqMonitorService() {
	}

	public synchronized static TPlDqMonitorService getInstance() {
		return (TPlDqMonitorService) ApplicationContextUtils
				.getBean(TPlDqMonitorService.class.getName());
	}
	
	private TPlDqMonitorDAO getDao(){
		return (TPlDqMonitorDAO) ApplicationContextUtils.getBean("TPlDqMonitorDAO");
	}
	
	public TPlDqMonitor get(String id) throws CommonException{
		TPlDqMonitorDAO dao=getDao();
		return dao.getHibernateTemplate().get(TPlDqMonitor.class,id);
	}
	
	public void save(TPlDqMonitor monitor) throws CommonException{
		TPlDqMonitorDAO dao=getDao();
		dao.getHibernateTemplate().save(monitor);
	}
	
	public void update(TPlDqMonitor monitor)throws CommonException{
		TPlDqMonitorDAO dao=getDao();
		dao.getHibernateTemplate().update(monitor);
	}
	
	public void delete(TPlDqMonitor monitor)throws CommonException{
		TPlDqMonitorDAO dao=getDao();
		dao.getHibernateTemplate().delete(monitor);
	}
	
	@SuppressWarnings("rawtypes")
	public List<String> dwrFindCtrl(String businessId){
		List<String> arrs=new ArrayList<String>();
		try {
			List list=getDao().getHibernateTemplate().find("from TPlControlmeasure where taskId='"+businessId+"'");
			for(int i=0;i<list.size();i++){
				TPlControlmeasure ctrl= (TPlControlmeasure) list.get(i);
				arrs.add(JsonUtils.toString(ctrl));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return arrs;
	}
	
	@SuppressWarnings("unchecked")
	public String[] dwrFindFrequency(String businessId) throws CommonException{
		ROOTDAO rootDao=ROOTDAOUtils.getROOTDAO();
		List<TPlReportRelation> list=rootDao.queryByCondition(" from TPlReportRelation where businessId='"+businessId+"'");
		String frequency="";
		if(list.get(0).getReportType().equals("AJ")){
			TPlDqReportAj report=TPlDqReportAjService.getInstance().get(list.get(0).getReportId());
			frequency=report.getFrequency();
		}else if(list.get(0).getReportType().equals("XF")){
			TPlDqReportXf report=TPlDqReportXfService.getInstance().get(list.get(0).getReportId());
			frequency=report.getFrequency();
		}else if(list.get(0).getReportType().equals("JY")){
			TPlDqReportJy report=TPlDqReportJyService.getInstance().get(list.get(0).getReportId());
			frequency=report.getFrequency();
		}else if(list.get(0).getReportType().equals("Yj")){
			TPlYjReport report=TPlYjReportService.getInstance().get(list.get(0).getReportId());
			frequency=report.getFrequency();
		}else if(list.get(0).getReportType().equals("YT")){
			TPlYtReport report=TPlYtReportService.getInstance().get(list.get(0).getReportId());
			frequency=report.getFrequency();
		}
		String name=DataDicService.getInstance().getNameByTypeNo(FREQUENCY_DIC,frequency);
		return new String[]{frequency,name};
	}
	
	/**
	 * 获取上次与本次预警时间
	 * @param accountId
	 * @return
	 */
	public String[] getWarnDate(String accountId){
		String sql="SELECT to_char(T1.TASK_CREAT_DATE,'YYYY-MM-DD') as end_date,to_char(T2.TASK_CREAT_DATE,'YYYY-MM-DD') as start_date FROM ("+
		" select RANK() OVER(PARTITION BY loan_acct ORDER BY TASK_CREAT_DATE DESC) AS RM,T.* from "+ 
		" T_PL_TASK T where T.loan_acct='"+accountId+"') T1 LEFT JOIN ( SELECT * FROM ( "+
		" select RANK() OVER(PARTITION BY loan_acct ORDER BY TASK_CREAT_DATE DESC) AS RM,T.* from "+ 
		" T_PL_TASK T where T.loan_acct='"+accountId+"') A WHERE A.RM=2 ) T2 ON T1.LOAN_ACCT=T2.LOAN_ACCT "+
		" WHERE T1.RM=1";
		JdbcTemplate jdbcTemplate=(JdbcTemplate) ApplicationContextUtils.getBean("JdbcTemplate");
		List<Map<String, Object>> list=jdbcTemplate.queryForList(sql);
		String startDate=(String) list.get(0).get("start_date");
		String endDate=(String) list.get(0).get("end_date");
		return new String[]{startDate,endDate};
	}
	
	/**
	 * 获取定期报告预警信息
	 * @param accountId
	 * @return
	 */
	public List<Map<String,Object>> dwrGetReportWarnInfo(String accountId){
		JdbcTemplate jdbcTemplate=(JdbcTemplate) ApplicationContextUtils.getBean("JdbcTemplate");
		String[] dates=getWarnDate(accountId);
		String startDate=dates[0];
		String endDate=dates[1];
		String whStr1="";
		String whStr2="";
		if(StringUtils.isNotEmpty(startDate)){
			whStr1=" and task_creat_date>='"+startDate+"' and task_creat_date<'"+endDate+"' ";
			whStr2=" and fd_process_date>='"+startDate+"' and fd_process_date<'"+endDate+"' ";
		}else{
			whStr1=" and task_creat_date='"+endDate+"' ";
			whStr2=" and fd_process_date='"+endDate+"' ";
		}
		String ruleSql="select WARN_LEVEL,sum(count_) as count_ from (select WARN_LEVEL,count(1) as count_ from t_pl_task "+ 
		" where loan_acct='"+accountId+"' and task_type='YJ' "+whStr1+
		" group by WARN_LEVEL union all select FD_RULE_RANK,count(1) from T_PL_TASK_RULE_TRIG where fd_acc_id='"+accountId+"' "+
		" "+whStr2+" and FD_RULE_RANK='"+YELLOW_WARN_LEVEL+"' "+
		" group by fd_rule_code,FD_RULE_RANK) t group by WARN_LEVEL";
		List<Map<String, Object>> resultList=jdbcTemplate.queryForList(ruleSql);
		return resultList;
	}
	
	/**
	 * 删除定期相关业务表
	 * @param businessId
	 * @throws CommonException 
	 */
	@SuppressWarnings("unchecked")
	public void clean(String businessId) throws CommonException{
		CommonService service=CommonService.getInstance();
		ROOTDAO rootDao = ROOTDAOUtils.getROOTDAO();
		List<TPlReportRelation> list = rootDao.queryByCondition(" from TPlReportRelation where businessId='"+ businessId + "'");
		String reportId="";
		if(null!=list && list.size()>0){
			reportId=list.get(0).getReportId();
		}
		//1.经营类表
		service.executeHQL("delete TPlDqReportJyPartner where businessid='"+businessId+"' ");
		service.executeHQL("delete TPlDqReportJyMortgage where businessid='"+businessId+"' ");
		service.executeHQL("delete TPlDqReportJyGuarant where businessid='"+businessId+"' ");
		service.executeHQL("delete TPlDqReportJyCreditBusin where businessid='"+businessId+"' ");
		service.executeHQL("delete TPlDqReportJy where id='"+reportId+"' ");
		//2.消费类表
		service.executeHQL("delete TPlDqReportXf where id='"+reportId+"' ");
		//3.按揭类表
		service.executeHQL("delete TPlDqReportAj where id='"+reportId+"' ");
		//4.公共类表
		//service.executeHQL("delete TPlReportRelation where businessId='"+businessId+"' ");
		//5.控制措施
		service.executeHQL("delete from TPlControlmeasure where taskId='"+businessId+"' ");
		service.executeHQL("delete TPlTask where id='"+businessId+"' ");
	}
}
