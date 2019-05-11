package com.gbicc.person.monitor.operation;

import com.gbicc.person.monitor.entity.TPlZxrfMonitor;
import com.gbicc.person.zxrf.service.TPlZxrfInfoService;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;


/**
 * 
 * @author liufei
 *
 * 版本：2015年11月18日 上午9.15
 * 类说明：中小融辅报告dao
 */
public class TPlZxrfMonitorOperation extends BaseOperation {
	public static final String ID = "TPlZxrfMonitorOperation";
	public static final String IN_PARAM = "IN_PARAM";
	
	@Override
	public void afterProc(OperationContext context) throws CommonException {
	}

	@Override
	public void beforeProc(OperationContext context) throws CommonException {
	}

	@Override
	public void execute(OperationContext context) throws CommonException {
		try{
			TPlZxrfMonitor monitor = (TPlZxrfMonitor) context.getAttribute(IN_PARAM);
			TPlZxrfInfoService service = TPlZxrfInfoService.getInstance();
			service.startProcess(monitor);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
