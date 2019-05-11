package com.gbicc.person.collection.opration;

import com.gbicc.person.collection.entity.TCollectionInfo;
import com.gbicc.person.collection.service.TCollectionInfoService;
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
public class TCollectionInfoStartProcessOperation extends BaseOperation {
	public static final String ID = "TCollectionInfoStartProcessOperation";
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
			TCollectionInfo info = (TCollectionInfo) context.getAttribute(IN_PARAM);
			TCollectionInfoService.getInstance().startProcess(info);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
