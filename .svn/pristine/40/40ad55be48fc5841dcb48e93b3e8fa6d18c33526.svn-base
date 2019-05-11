package com.gbicc.person.zxrf.opration;

import com.gbicc.person.collection.entity.TCollectionInfo;
import com.gbicc.person.collection.service.TCollectionInfoService;
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
public class TPlZxrfInfoStartProcessOperation extends BaseOperation {
	public static final String ID = "TPlZxrfInfoStartProcessOperation";
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
			TPlZxrfMonitor info = (TPlZxrfMonitor) context.getAttribute(IN_PARAM);
			TPlZxrfInfoService.getInstance().startProcess(info);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
