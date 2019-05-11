package com.huateng.ebank.business.management.operation;

import java.io.IOException;
import java.util.Iterator;


import com.huateng.common.DateUtil;
import com.huateng.common.log.HtLog;
import com.huateng.common.log.HtLogFactory;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.management.service.SysCurrencyService;
import com.huateng.ebank.entity.data.mng.SysCurrency;
import com.huateng.ebank.entity.data.mng.SysTaskInfo;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.report.utils.ReportEnum;
import com.huateng.report.utils.ReportTaskUtil;

/**
 * do for Dao operation
 * @author cwenao
 * 2012-8-13
 */


public class CurrencyManOperation extends BaseOperation{
	private static final HtLog htlog=HtLogFactory.getLogger(CurrencyManOperation.class);
	public static final String ID = "CurrencyManOperation";
	public static final String CMD = "CMD";
	public static final String CMD_QUERY = "CMD_QUERY";
	public static final String CMD_INSERT = "CMD_INSERT";
	public static final String CMD_UPDATE = "CMD_UPDATE";
	public static final String CMD_DELETE = "CMD_DELETE";
	public static final String IN_PARAM = "IN_PARAM";


	@Override
	public void beforeProc(OperationContext context) throws CommonException {
		// TODO Auto-generated method stub

	}
	 //author  by  计翔 2012.9.5
	@Override
	public void execute(OperationContext context) throws CommonException {
		String cmd = (String)context.getAttribute(CMD);
		SysCurrency sysCurrency = (SysCurrency) context.getAttribute(IN_PARAM);
		SysCurrencyService sysCurService = SysCurrencyService.getInstance();


		if(CMD_INSERT.equalsIgnoreCase(cmd))
		{

			sysCurrency.setSt(ReportEnum.REPORT_ST1.CR.value);
			sysCurrency.setCreateDate(DateUtil.getTXNDate());
			sysCurrency.setLastUpdTlr(GlobalInfo.getCurrentInstance().getTlrno());
			sysCurrency.setLastUpdDate(DateUtil.getTXNDate());
            sysCurrency.setLock(true);
			sysCurService.save(sysCurrency);


			SysTaskInfo taskInfo;
			try {
				taskInfo = ReportTaskUtil.getSysTaskInfoBean(ReportEnum.REPORT_TASK_FUNCID.TASK_110199.value, ReportEnum.REPORT_TASK_TRANS_CD.NEW.value, sysCurrency, sysCurrency.getId(), sysCurrency.getSt());
				sysCurService.addTosystaskinfo(taskInfo);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			GlobalInfo  gi=GlobalInfo.getCurrentInstance();
			gi.addBizLog("Updater.log", new String[]{gi.getTlrno(),gi.getBrcode(),"执行新建币种的信息"});
			htlog.info("Updater.log", new String[]{gi.getBrcode(),gi.getTlrno(),"执行新建币种的信息"});

		}else if(CMD_UPDATE.equalsIgnoreCase(cmd))
		{
	       Iterator  it=sysCurService.selectByid(sysCurrency.getId());
			//sysCurService.update(sysCurrency);
			 while(it.hasNext()){
				  SysCurrency sys1=	(SysCurrency) it.next();
				    sys1.setSt(ReportEnum.REPORT_ST1.ET.value);
				    sys1.setCreateDate(DateUtil.getTXNDate());
				    sys1.setLastUpdTlr(GlobalInfo.getCurrentInstance().getTlrno());
				    sys1.setLastUpdDate(DateUtil.getTXNDate());
				    sys1.setLock(true);
				    sysCurService.update(sys1);
			 }
			 SysTaskInfo taskInfo;
				try {
					taskInfo = ReportTaskUtil.getSysTaskInfoBean(ReportEnum.REPORT_TASK_FUNCID.TASK_110199.value, ReportEnum.REPORT_TASK_TRANS_CD.EDIT.value, sysCurrency, sysCurrency.getId(), sysCurrency.getSt());
					sysCurService.addTosystaskinfo(taskInfo);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				GlobalInfo  gi=GlobalInfo.getCurrentInstance();
				gi.addBizLog("Updater.log", new String[]{gi.getTlrno(),gi.getBrcode(),"执行更新币种的信息"});
				htlog.info("Updater.log", new String[]{gi.getBrcode(),gi.getTlrno(),"执行更新币种的信息"});
		}
			 else if(CMD_DELETE.equalsIgnoreCase(cmd))
		{
			//sysCurService.delete(sysCurrency.getId());
				 Iterator  it=sysCurService.selectByid(sysCurrency.getId());

					 while(it.hasNext()){
						  SysCurrency sys1=	(SysCurrency) it.next();
						  sys1.setSt(ReportEnum.REPORT_ST1.DE.value);
						  sys1.setCreateDate(DateUtil.getTXNDate());
						  sys1.setLastUpdTlr(GlobalInfo.getCurrentInstance().getTlrno());
						  sys1.setLastUpdDate(DateUtil.getTXNDate());
						  sys1.setLock(true);
						  sysCurService.update(sys1);
					 }
					 SysTaskInfo taskInfo;
						try {
							taskInfo = ReportTaskUtil.getSysTaskInfoBean(ReportEnum.REPORT_TASK_FUNCID.TASK_110199.value, ReportEnum.REPORT_TASK_TRANS_CD.DEL.value, sysCurrency, sysCurrency.getId(), sysCurrency.getSt());
							sysCurService.addTosystaskinfo(taskInfo);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		}
		GlobalInfo  gi=GlobalInfo.getCurrentInstance();
		gi.addBizLog("Updater.log", new String[]{gi.getTlrno(),gi.getBrcode(),"执行删除币种的信息"});
		htlog.info("Updater.log", new String[]{gi.getBrcode(),gi.getTlrno(),"执行删除币种的信息"});
	}

	@Override
	public void afterProc(OperationContext context) throws CommonException {
		// TODO Auto-generated method stub
	}
}
