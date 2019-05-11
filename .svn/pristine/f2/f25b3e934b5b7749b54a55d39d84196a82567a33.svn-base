package com.huateng.ebank.business.dataquery.getter;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.CommonFunctions;
import com.huateng.ebank.business.common.DAOUtils;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.business.dataquery.bean.TblCsBizLogView;
import com.huateng.ebank.business.dataquery.service.TblCsBizLogService;
import com.huateng.ebank.entity.dao.mng.BctlDAO;
import com.huateng.ebank.entity.data.mng.Bctl;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.report.common.ReportConstant;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;


/**
 * @Description: 日志查询
 * @Package: com.huateng.ebank.business.custadmin.getter
 * @Company: Shanghai Huateng Software Systems Co., Ltd.
 */
public class TblCsBizLogGetter extends BaseGetter {

	@Override
	public Result call() throws AppException {
		try {
			//this.setValue2DataBus(ReportConstant.QUERY_LOG_BUSI_NAME, "数据查询-系统日志查询");
			CommonFunctions comm =CommonFunctions.getInstance();
			PageQueryResult pageResult = getData();
			List<TblCsBizLogView > list =pageResult.getQueryResult();
			Map<String, String> map = new HashMap<String, String>();
			BctlDAO bctlDAO = DAOUtils.getBctlDAO();
			Iterator it = list.iterator();
			while(it.hasNext()){
				Object[] obs = (Object[]) it.next();
				TblCsBizLogView tbl = (TblCsBizLogView) obs[0];
				tbl.setTxnStartTime(comm.converDate8TO101(tbl.getTxnDate())+" "+comm.converStringTOTime(tbl.getTxnStartTime()));
				tbl.setTxnEndTime(comm.converDate8TO101(tbl.getTxnDate())+" "+comm.converStringTOTime(tbl.getTxnEndTime()));
				if (map.containsKey(tbl.getBrCode())) {
					tbl.setMisc(map.get(tbl.getBrCode()));
				} else {
					Bctl bctl = bctlDAO.query(tbl.getBrCode().trim());
					if (bctl == null) {
						tbl.setMisc(tbl.getBrCode().trim());
					} else {
						tbl.setMisc(bctl.getBrname());
						map.put(tbl.getBrCode(), bctl.getBrname());
					}
				}
			}
			ResultMng.fillResultByList(getCommonQueryBean(),
					getCommQueryServletRequest(), pageResult.getQueryResult(),
					getResult());
			result.setContent(pageResult.getQueryResult());
			result.getPage().setTotalPage(
					pageResult.getPageCount(getResult().getPage()
							.getEveryPage()));
			result.init();
			
			this.setValue2DataBus(ReportConstant.QUERY_LOG_BUSI_NAME, "操作日志查询");
			
			return result;
		} catch (CommonException e) {
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, e.getMessage());
		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}

	private PageQueryResult getData() throws CommonException {
		int pageIndex = getResult().getPage().getCurrentPage();
		int pageSize = getResult().getPage().getEveryPage();


		String oprcode = (String) getCommQueryServletRequest().getParameterMap()
				.get("oprcode1");
		String startDate = (String) getCommQueryServletRequest().getParameterMap()
				.get("startDate");
		String endDate = (String) getCommQueryServletRequest().getParameterMap()
				.get("endDate");

		GlobalInfo info = GlobalInfo.getCurrentInstance();
		TblCsBizLogService tblcsbizlogservice = TblCsBizLogService.getInstance();
		return tblcsbizlogservice.queryBizLOg(pageIndex, pageSize,oprcode,startDate,endDate,info.getBrcode());
	}

}
