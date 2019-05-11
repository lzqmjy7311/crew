package com.huateng.fp.demo.scheduler;

import java.util.HashMap;

import com.huateng.ebank.entity.data.mng.BaseJobDetail;
import com.huateng.ebank.entity.data.mng.JobConstant;
import com.huateng.exception.AppException;



public class testScheduler  extends BaseJobDetail {

	@Override
	public String executeJob(HashMap jobParameters) throws AppException {
		   System.out.println("测试定时任务输出");
		return JobConstant.JOB_EXECUTE_RESULT_SUCCESS;
	}

	@Override
	public void afterExeSuccess(HashMap jobParameters) throws AppException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterExeFail(HashMap jobParameters) throws AppException {
		// TODO Auto-generated method stub
		
	}

}
