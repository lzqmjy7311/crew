package com.huateng.ebank.business.parammng.cqGetter;

import java.util.ArrayList;
import java.util.List;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.business.parammng.bean.BhProcStepView;
import com.huateng.ebank.business.parammng.operation.BhProcStepOperation;
import com.huateng.ebank.entity.data.mng.BhProcStep;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

/**
 * @author weikun wang
 * @date 2008-4-10
 * @desc
 */

public class BhProcStepGetter extends BaseGetter{
	//-----------------------------覆盖父类的call()方法-----------------------------------------------------------
	public Result call() throws AppException {
		try{

		PageQueryResult pageResult = getData();


			ResultMng.fillResultByList(
					getCommonQueryBean(),
					getCommQueryServletRequest(),
					pageResult.getQueryResult(),
					getResult());

			result.setContent(pageResult.getQueryResult());
			if(pageResult.getQueryResult().size() == 0){
				result.getPage().setTotalPage(0);
			}else{
				result.getPage().setTotalPage(1);
			}

			result.init();
		return result;



	}catch(AppException appEx){
		throw appEx;
	}catch(Exception ex){
		throw new AppException(Module.SYSTEM_MODULE,
				Rescode.DEFAULT_RESCODE, ex.getMessage(),ex);
	}


	}

//---------------------------------------------------------------------------------------------------------------------
    protected PageQueryResult getData() throws Exception {
    	PageQueryResult pageQueryResult = new PageQueryResult();
		OperationContext oc = new OperationContext();
		oc.setAttribute(BhProcStepOperation.CMD,"SELECT");
		OPCaller.call("parammng.bhProcStepOP", oc);
		List bhProcStepList = (List)OperationContext.getValue(oc,BhProcStepOperation.OUT_BHPROC_LIST);

		List bhProcStepViewList = new ArrayList();
		for (int i = 0; i < bhProcStepList.size(); i++) {
			BhProcStepView bhProcStepView = new BhProcStepView();
			Integer id = ((BhProcStep)bhProcStepList.get(i)).getId();
			bhProcStepView.setId(id.toString());
			bhProcStepView.setJobno(((BhProcStep)bhProcStepList.get(i)).getJobno().toString());
			bhProcStepView.setStep(((BhProcStep)bhProcStepList.get(i)).getStep().toString());
			bhProcStepView.setSubStep(((BhProcStep)bhProcStepList.get(i)).getSubStep().toString());
			bhProcStepView.setProcessFunction(((BhProcStep)bhProcStepList.get(i)).getProcessFunction());
			bhProcStepView.setProcessParam(((BhProcStep)bhProcStepList.get(i)).getProcessParam());
			bhProcStepView.setProcessTlrno(((BhProcStep)bhProcStepList.get(i)).getProcessTlrno());
			bhProcStepView.setRuntime(((BhProcStep)bhProcStepList.get(i)).getRuntime());
			bhProcStepView.setSubFlag(((BhProcStep)bhProcStepList.get(i)).getSubFlag());
			bhProcStepView.setReportFlag(((BhProcStep)bhProcStepList.get(i)).getReportFlag());
			bhProcStepView.setMaxproc(((BhProcStep)bhProcStepList.get(i)).getMaxproc().toString());
			bhProcStepView.setTempFlag(((BhProcStep)bhProcStepList.get(i)).getTempFlag());
			bhProcStepView.setSuspend(((BhProcStep)bhProcStepList.get(i)).getSuspend());
			//bhProcStepView.setSingleFlag(((BhProcStep)bhProcStepList.get(i)).getSingleFlag());
			bhProcStepView.setDesc(((BhProcStep)bhProcStepList.get(i)).getDesc0());
			bhProcStepView.setDesc1(((BhProcStep)bhProcStepList.get(i)).getDesc1());
			bhProcStepView.setDesc2(((BhProcStep)bhProcStepList.get(i)).getDesc2());
			//虚拟字段，没有实际意义，给v_id赋值是为了区分该记录是从数据库中取出来的
			bhProcStepView.setV_id("1");
			bhProcStepViewList.add(bhProcStepView);

		}

        if(bhProcStepList!=null&&bhProcStepList.size()>0){
        	pageQueryResult.setTotalCount(bhProcStepList.size());
        }else{
        	pageQueryResult.setTotalCount(0);
        }
        pageQueryResult.setQueryResult(bhProcStepViewList);

        return pageQueryResult;
    }

}
