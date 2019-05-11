package com.gbicc.person.frequency.service;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.gbicc.person.frequency.entity.TPlTriggerFrequencyAcct;
import com.gbicc.warn.ComninationWarn.entity.TCwCreditAssetsMonitor;
import com.huateng.ebank.entity.dao.mng.ROOTDAO;
import com.huateng.ebank.entity.dao.mng.ROOTDAOUtils;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ApplicationContextUtils;

public class TPlTriggerFrequencyAcctService {
	protected TPlTriggerFrequencyAcctService() {
	}

	public synchronized static TPlTriggerFrequencyAcctService getInstance() {
		return (TPlTriggerFrequencyAcctService) ApplicationContextUtils
				.getBean(TPlTriggerFrequencyAcctService.class.getSimpleName());
	}
	
	public ROOTDAO dao(){
		return  ROOTDAOUtils.getROOTDAO();
	}
	
	public TPlTriggerFrequencyAcct get(String id) throws CommonException{
		return dao().query(TPlTriggerFrequencyAcct.class, id);
	}
	public String getByAcc(String accId) throws CommonException{
		JdbcTemplate jdbcTemplate=(JdbcTemplate) ApplicationContextUtils.getBean("JdbcTemplate");
		TPlTriggerFrequencyAcct tPlTriggerFrequencyAcct=null;
		String sql=null;
		sql="  SELECT T.FD_ID AS id,T.FD_LOAN_ACCT AS loanAcct,T.FD_CUST_NAME AS custName,FD_WARN_LEVEL AS warnLevel,T.FD_WARN_DATE AS warnDate,T.FD_LOAN_VARIETY AS loanVariety,T.FD_FREQUENCY AS frequency,"
            +"  T.FD_LOAN_AMT AS loanAmt,T.FD_LOAN_BALANCE AS loanBalance,T.FD_LOAN_TERM AS loanTerm,T.FD_STATUS AS status,T.FD_LAUNCHPER AS launchPer,T.FD_LAUNCHP_BANK AS launchBank,T.FD_SYS_FREQUENCY AS sysFrequency"
           +"  FROM  T_PL_TRIGGER_FREQUENCY_ACCT T WHERE T.FD_LOAN_ACCT='"+accId+"' ORDER BY T.FD_WARN_DATE DESC";
		List<TPlTriggerFrequencyAcct> listT=jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(TPlTriggerFrequencyAcct.class));
		if(listT.size()>0){
			tPlTriggerFrequencyAcct=listT.get(0);
		}
		return tPlTriggerFrequencyAcct.getId();
	}
	
	public void save(TPlTriggerFrequencyAcct tpltriggerfrequencyacct) throws CommonException{
		dao().save(tpltriggerfrequencyacct);
	}
	
	public void update(TPlTriggerFrequencyAcct tpltriggerfrequencyacct) throws CommonException{
		dao().update(tpltriggerfrequencyacct);
	}
	
	public void delete(String id) throws CommonException{
		dao().delete(id);
	}
}
