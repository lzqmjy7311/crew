package com.huateng.ebank.business.dataquery.service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import com.huateng.common.log.HtLog;
import com.huateng.common.log.HtLogFactory;
import com.huateng.ebank.business.common.BaseDAOUtils;
import com.huateng.ebank.business.common.CommonFunctions;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.PageQueryCondition;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.orm.HQLDAO;
import com.huateng.ebank.framework.util.ApplicationContextUtils;
import com.huateng.ebank.framework.util.DataFormat;

/**
 * @author zhangshishu
 * @date 2012/6/7
 * @desc 日志控制表service
 */
public class TblCsBizLogService {
	private static final HtLog htlog = HtLogFactory.getLogger(TblCsBizLogService.class);

	protected TblCsBizLogService() {
	}

	/**
	 * get instance.
	 *
	 * @return
	 */
	public synchronized static TblCsBizLogService getInstance() {
		return (TblCsBizLogService) ApplicationContextUtils
				.getBean(TblCsBizLogService.class.getName());
	}


	/**
	 * @param pageSize
	 * @param pageIndex
	 * @param endDate
	 * @param statDate
	 * @Description 日志查询
	 * @return
	 * @throws CommonException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	public PageQueryResult queryBizLOg(int pageIndex, int pageSize, String oprcode, String startDate, String endDate,String brcode)
			throws CommonException {

		StringBuffer sb = new StringBuffer("");
		GlobalInfo gi = GlobalInfo.getCurrentInstance();
		CommonFunctions comm = CommonFunctions.getInstance();
		List<Object> list=new ArrayList<Object>();
		sb.append("select new com.huateng.ebank.business.dataquery.bean.TblCsBizLogView(tblCsBizLog.id,tblCsBizLog.txnDate,tblCsBizLog.txnStartTime,tblCsBizLog.txnEndTime," +
				"tblCsBizLog.txnRunTime,tblCsBizLog.brCode,tblCsBizLog.oprCode,tblCsBizLog.ipAdr,tblCsBizLog.funcId,tblCsBizLog.oprTxnCd,tblCsBizLog.txnBizLog1," +
				"tblCsBizLog.txnBizLog2,tblCsBizLog.txnStatus,tblCsBizLog.txnFailLog,tlrinfo.tlrName) from TblCsBizLog tblCsBizLog, TlrInfo tlrinfo " +
				" where trim(tblCsBizLog.oprCode)=tlrinfo.tlrno and trim(tblCsBizLog.brCode) ='" + gi.getBrcode() + "'");
		if(!DataFormat.isEmpty(oprcode)){
			sb.append(" and tlrinfo.tlrName like ? ");
			list.add("%"+oprcode+"%");
		}
		if(!DataFormat.isEmpty(startDate)){
			sb.append(" and tblCsBizLog.txnDate>=? ");
			list.add(comm.converDate12TO8(startDate));
		}
		if(!DataFormat.isEmpty(endDate)){
			sb.append(" and tblCsBizLog.txnDate<=? ");
			list.add(comm.converDate12TO8(endDate));
		}
		sb.append("order by tblCsBizLog.txnDate desc,tblCsBizLog.txnEndTime desc ");

		HQLDAO hqlDAO = BaseDAOUtils.getHQLDAO();
		PageQueryCondition queryCondition = new PageQueryCondition();
		queryCondition.setQueryString(sb.toString());
		queryCondition.setPageIndex(pageIndex);
		queryCondition.setPageSize(pageSize);
		queryCondition.setObjArray(list.toArray());
		PageQueryResult pageQueryResult = hqlDAO.pageQueryByQL(queryCondition);
		return pageQueryResult;
	}

}
