package com.gbicc.company.single.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

import com.gbicc.bpm.SpringContextHolder;
import com.gbicc.common.CommonService;
import com.gbicc.company.single.entity.TCmSingleRulWarning;
import com.huateng.ebank.entity.dao.mng.ROOTDAO;
import com.huateng.ebank.entity.dao.mng.ROOTDAOUtils;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ApplicationContextUtils;

public class TCmSingleRulWarningService {
	protected TCmSingleRulWarningService() {
	}

	public synchronized static TCmSingleRulWarningService getInstance() {
		return (TCmSingleRulWarningService) ApplicationContextUtils
				.getBean(TCmSingleRulWarningService.class.getSimpleName());
	}
	
	public ROOTDAO dao(){
		return  ROOTDAOUtils.getROOTDAO();
	}
	
	public TCmSingleRulWarning get(String id) throws CommonException{
		return dao().query(TCmSingleRulWarning.class, id);
	}
	
	public void save(TCmSingleRulWarning tcmsinglerulwarning) throws CommonException{
		dao().save(tcmsinglerulwarning);
	}
	
	public void update(TCmSingleRulWarning tcmsinglerulwarning) throws CommonException{
		dao().update(tcmsinglerulwarning);
	}
	
	public void delete(String id) throws CommonException{
		dao().delete(id);
	}
	
	/**
	 * 删除生成任务相关表
	 * @param businessId
	 * @throws CommonException
	 */
	public void clean(String businessId) throws CommonException{
		CommonService service=CommonService.getInstance();
		service.executeHQL("delete TCmSingleRulWarning where id='"+businessId+"' ");
	}
	
	/**
	 * 获取当天最新产生的单规则预警的taskcode
	 */
	public String getFdTaskCode(){
		Date date=new Date();
		Integer count=0;
		String countString="";
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		String dateString=format.format(date);
		String drString="DR"+dateString.replace("-", "");
		//获取当天最新产生的单规则预警的taskcode
		String sql="select max(fd_task_code) fd_task_code  from T_CM_SINGLE_RUL_warning where fd_warn_dt='"+dateString+"' and fd_task_code is not null";
		JdbcTemplate jdbcTemplate=SpringContextHolder.getBean(JdbcTemplate.class);
		List<Map<String,Object>> resultList=jdbcTemplate.queryForList(sql);
		Map fdTaskCode=resultList.get(0);
		for(Object object:fdTaskCode.values()){
			if(object==null){
				count=1;
				countString=String.format("%06d", count);
				/*warning.setTaskCode(drString+countString);
				warning.setWarnDt(date);
				tCmSingleRulWarningService.save(warning);*/
			}else{
				String string=object.toString();
				//截取转到string
				countString=string.substring(10);
				count=Integer.valueOf(countString);
				count+=1;
				//转回到integer
				countString=String.format("%06d", count);
				/*warning.setTaskCode(drString+countString);
				warning.setWarnDt(date);
				tCmSingleRulWarningService.save(warning);*/
			}
		}
		return countString;
	}
}
