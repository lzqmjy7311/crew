package com.huateng.ebank.business.management.operation;

import java.io.IOException;
import java.util.Iterator;

import com.huateng.common.DateUtil;
import com.huateng.common.log.HtLog;
import com.huateng.common.log.HtLogFactory;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.management.service.BiNationregionService;
import com.huateng.ebank.entity.data.mng.BiNationregion;
import com.huateng.ebank.entity.data.mng.SysTaskInfo;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.report.utils.ReportEnum;
import com.huateng.report.utils.ReportTaskUtil;

public class BiNationregionOperation extends BaseOperation {
	private static final HtLog htlog=HtLogFactory.getLogger(BiNationregionOperation.class);
	public final static String ID = "biNationregionOperation";
	public final static String CMD = "CMD";
	public final static String CMD_MOD = "CMD_MOD";
	public final static String CMD_DEL = "CMD_DEL";
	public final static String CMD_ADD = "CMD_ADD";
	public final static String IN_PARAM = "IN_PARAM";
	@Override
	public void beforeProc(OperationContext context) throws CommonException {
		// TODO Auto-generated method stub
		
	}

	@Override
	 //author  by  计翔 2012.9.5
	public void execute(OperationContext context) throws CommonException {
		// TODO Auto-generated method stub
		String cmd = (String) context.getAttribute(CMD);
		BiNationregion biNationregion = (BiNationregion) context.getAttribute(IN_PARAM);
		//调用服务类
		BiNationregionService service = BiNationregionService.getInstance();
		if(CMD_DEL.equals(cmd)) {
			 Iterator  it=service.selectByid(biNationregion.getId());
				
			 while(it.hasNext()){
				 BiNationregion sys1=(BiNationregion)it.next();
				  sys1.setSt(ReportEnum.REPORT_ST1.DE.value);
				  sys1.setCrtDt(DateUtil.get8Date());
				   sys1.setLastUpdOper(GlobalInfo.getCurrentInstance().getTlrno());
				   sys1.setLastUpdTms(DateUtil.get14Date());
				  sys1.setLock(true);
				  service.modEntity(sys1);
			 }
			 SysTaskInfo taskInfo;
				try {
					taskInfo = ReportTaskUtil.getSysTaskInfoBean(ReportEnum.REPORT_TASK_FUNCID.TASK_110499.value, ReportEnum.REPORT_TASK_TRANS_CD.DEL.value, biNationregion, biNationregion.getId(), biNationregion.getSt());
					service.addTosystaskinfo(taskInfo);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}   
				GlobalInfo  gi=GlobalInfo.getCurrentInstance();
				gi.addBizLog("Updater.log", new String[]{gi.getTlrno(),gi.getBrcode(),"执行删除国家地区代码维护的信息"});
				htlog.info("Updater.log", new String[]{gi.getBrcode(),gi.getTlrno(),"执行删除国家地区代码维护的信息"});
}
			//删除
		//service.removeEntity(biNationregion);
else if(CMD_ADD.equals(cmd)) {
	biNationregion.setSt(ReportEnum.REPORT_ST1.CR.value);
	biNationregion.setCrtDt(DateUtil.get8Date());
	biNationregion.setLastUpdOper(GlobalInfo.getCurrentInstance().getTlrno());
	biNationregion.setLastUpdTms(DateUtil.get14Date());
	biNationregion.setLock(true);		
	
	service.addEntity(biNationregion);
	 
	
	SysTaskInfo taskInfo;
	try {
		taskInfo = ReportTaskUtil.getSysTaskInfoBean(ReportEnum.REPORT_TASK_FUNCID.TASK_110499.value, ReportEnum.REPORT_TASK_TRANS_CD.NEW.value, biNationregion, biNationregion.getId(), biNationregion.getSt());
		service.addTosystaskinfo(taskInfo);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	GlobalInfo  gi=GlobalInfo.getCurrentInstance();
	gi.addBizLog("Updater.log", new String[]{gi.getTlrno(),gi.getBrcode(),"执行新建国家地区代码维护信息"});
	htlog.info("Updater.log", new String[]{gi.getBrcode(),gi.getTlrno(),"执行新建国家地区代码维护信息"});
	
	//插入或者更新
	//service.addEntity(biNationregion);
	} 
	else if(CMD_MOD.equals(cmd)) {
		//service.modEntity(biNationregion);
		   Iterator  it=service.selectByid(biNationregion.getId());
			//sysCurService.update(sysCurrency);
			 while(it.hasNext()){
				    BiNationregion sys1=(BiNationregion) it.next();
				   
				    sys1.setSt(ReportEnum.REPORT_ST1.ET.value);
				    sys1.setCrtDt(DateUtil.get8Date());
					   sys1.setLastUpdOper(GlobalInfo.getCurrentInstance().getTlrno());
					   sys1.setLastUpdTms(DateUtil.get14Date());
				    sys1.setLock(true);
				    service.modEntity(sys1);
			 }
			 SysTaskInfo taskInfo;
				try {
					taskInfo = ReportTaskUtil.getSysTaskInfoBean(ReportEnum.REPORT_TASK_FUNCID.TASK_110499.value, ReportEnum.REPORT_TASK_TRANS_CD.EDIT.value, biNationregion, biNationregion.getId(), biNationregion.getSt());
					service.addTosystaskinfo(taskInfo);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}   
		
		
	}
		GlobalInfo  gi=GlobalInfo.getCurrentInstance();
		gi.addBizLog("Updater.log", new String[]{gi.getTlrno(),gi.getBrcode(),"执行国家地区代码维护的更新"});
		htlog.info("Updater.log", new String[]{gi.getBrcode(),gi.getTlrno(),"执行国家地区代码维护的更新"});
}
@Override
public void afterProc(OperationContext context) throws CommonException {
	// TODO Auto-generated method stub
	
}

}
