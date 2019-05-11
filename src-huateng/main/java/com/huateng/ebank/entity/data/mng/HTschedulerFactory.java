/**
 * 
 */
package com.huateng.ebank.entity.data.mng;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.TriggerListener;
import org.quartz.impl.StdSchedulerFactory;

import com.huateng.ebank.business.common.service.CommonService;

/**
 * 调度实例工厂
 * 实现持久化可配置
 * @author wangpeng
 *
 */
public class HTschedulerFactory{
	private Scheduler scheduler;//调度器
	private boolean dbStore;
	
	public Scheduler getScheduler()throws SchedulerException{
		String dbstore = CommonService.getInstance().getSysParamDef("SYS", "CRONJOB_DBSTORE", "0");
		if("1".equals(dbstore)){
			((org.quartz.impl.StdScheduler)this.scheduler).start();
			return this.scheduler;
		}else{
			SchedulerFactory schedulerFactory = new StdSchedulerFactory();
			this.scheduler = schedulerFactory.getScheduler();
			TriggerListener triggerlistener = new TriggerListenerImpl("globaltrigger");//触发监听器
	        this.scheduler.addGlobalTriggerListener(triggerlistener);
			this.scheduler.startDelayed(120);//不持久化的，写死延时2分
			return this.scheduler;
		}
	}
	
	public void setScheduler(Scheduler scheduler){
		this.scheduler=scheduler;
	}

	public boolean isDbStore() {
		return dbStore;
	}

	public void setDbStore(boolean dbStore) {
		this.dbStore = dbStore;
	}
	
	
}
