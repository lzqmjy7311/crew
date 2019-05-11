package com.gbicc.job.operation;

import com.huateng.ebank.entity.dao.mng.ROOTDAOUtils;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;

public class TEtlJobDefineOperation extends BaseOperation{

	public static final String ID =TEtlJobDefineOperation.class.getSimpleName();
	
	@Override
	public void afterProc(OperationContext arg0) throws CommonException {
		
	}

	@Override
	public void beforeProc(OperationContext arg0) throws CommonException {
		
	}

	@Override
	public void execute(OperationContext arg0) throws CommonException {
		///将失败的任务重新调起
		ROOTDAOUtils.getROOTDAO()
			.executeSql("update t_etl_job_define set PRO_STATUS='0',"
			+ " IS_SUCCESS=null where IS_SUCCESS='0'");
	}

}
