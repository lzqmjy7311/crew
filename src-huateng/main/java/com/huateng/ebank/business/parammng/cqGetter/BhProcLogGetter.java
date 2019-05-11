package com.huateng.ebank.business.parammng.cqGetter;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.ErrorCode;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.framework.util.ExceptionUtil;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

/**
 * @author weikun wang
 * @date 2008-05-05
 * @desc
 */

public class BhProcLogGetter extends BaseGetter {
	// -----------------------------覆盖父类的call()方法-----------------------------------------------------------
	/**
	 * @return Result
	 */
	public Result call() throws AppException {
		try {
			PageQueryResult pageResult = getData();
			/*
			 * List list = pageResult.getQueryResult(); List bhProLogList = new
			 * ArrayList(); com.huateng.ebank.entity.data.BhProcLog bhprolog =
			 * new com.huateng.ebank.entity.data.BhProcLog(); for(int i=0;i<list.size();i++) {
			 * Object []temp = (Object[])list.get(i); for(int j=0;j<temp.length-1;j++) {
			 * bhprolog.setId(Integer.valueOf(temp[0].toString()));
			 * bhprolog.setBhdate(new Date(temp[1].toString())); } }
			 */
			ResultMng.fillResultByList(getCommonQueryBean(),
					getCommQueryServletRequest(), pageResult.getQueryResult(),
					getResult());
			result.setContent(pageResult.getQueryResult());
			result.getPage().setTotalPage(
					pageResult.getPageCount(getResult().getPage()
							.getEveryPage()));// pageResult.getPageCount(getResult().getPage().getEveryPage())
			result.init();
			return result;
		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}

	// ---------------------------------------------------------------------------------------------------------------------
	/**
	 * 获取分页显示的信息
	 *
	 * @return PageQueryResult
	 * @throws Exception
	 */
	protected PageQueryResult getData() throws Exception {
		/*
		 * int pageSize = getResult().getPage().getEveryPage();//the number of
		 * every page int pageIndex =
		 * getResult().getPage().getCurrentPage();//the number of current page
		 *
		 * condition.setPageIndex(pageIndex); condition.setPageSize(pageSize);
		 *
		 * String sql = "select
		 * po.id,po.bhdate,po.jobno,po.step,po.subStep,po.processFunction," +
		 * "po.processid,po.startTime,po.endTime,po.aceSwitchSta,po.status,po.timestamps,po.errMsg,po.desc1,po.desc2
		 * from BhProcLog po where 1=1";
		 * condition.setQueryString(sql.toString()); //执行分页查询操作 --暂不用
		 * PageQueryResult pageQueryResult =
		 * DAOUtils.getHQLDAO().pageQueryByQL(condition);
		 */
		//mod by kangbyron 2011-03-16 解决编译错误
//		List list = DAOUtils.getBhProcLogDAO().queryAll(); // 获取所有批处理状态信息.
//		List bhProLogList = new ArrayList();
//		BhProcLog bhProLog = null;
//		for (int i = 0; i < list.size(); i++) {
//			bhProLog = new BhProcLog();
//			Object[] temp = (Object[]) list.get(i); // 获取数据
//			for (int j = 0; j < temp.length - 1; j++) {
//				if (temp[j] == null) {
//					temp[j] = "";
//				}
//			}
//			bhProLog.setId(Integer.valueOf(temp[0].toString()));
//			bhProLog.setBhdate(DataFormat.ConvertDate(temp[1].toString()));
//			bhProLog.setJobno(Integer.valueOf(temp[2].toString()));
//			bhProLog.setStep(Integer.valueOf(temp[3].toString()));
//			bhProLog.setSubStep(Integer.valueOf(temp[4].toString()));
//			bhProLog.setProcessFunction(temp[5].toString());
//			bhProLog.setProcessid(Integer.valueOf(temp[6].toString()));
//			// bhProLog.setStartTime(DataFormat.ConvertDate(temp[7].toString()));
//			// bhProLog.setEndTime(DataFormat.ConvertDate(temp[8].toString()));
//			// bhProLog.setAceSwitchSta(temp[9].toString());
//			bhProLog.setStatus(temp[10].toString());
//			// bhProLog.setTimestamps(DataFormat.ConvertDate(temp[11].toString()));
//			// bhProLog.setErrMsg(temp[12].toString());
//			// bhProLog.setDesc1(temp[13].toString());
//			// bhProLog.setDesc2(temp[14].toString());
//			bhProLogList.add(bhProLog);
//		}
		PageQueryResult pageQueryResult = new PageQueryResult();
//		pageQueryResult.setQueryResult(bhProLogList);
//		pageQueryResult.setTotalCount(bhProLogList.size());
		if (pageQueryResult.getQueryResult() == null
				|| pageQueryResult.getQueryResult().isEmpty()) {
			ExceptionUtil.throwCommonException("没有符合条件的批处理状态信息",
					ErrorCode.ERROR_CODE_RECORD_NOTFOUND);
		}
		return pageQueryResult;
	}

}
