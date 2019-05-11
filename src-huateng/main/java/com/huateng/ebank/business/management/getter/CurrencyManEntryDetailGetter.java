package com.huateng.ebank.business.management.getter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.management.bean.CurrencyManEntryDetail;
import com.huateng.ebank.business.management.service.SysCurrencyService;
import com.huateng.ebank.entity.data.mng.SysCurrency;
import com.huateng.ebank.entity.data.mng.SysTaskInfo;
import com.huateng.ebank.entity.data.mng.SysTaskLog;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;
import com.huateng.report.common.service.ReportShowDetailService;
import com.huateng.report.utils.ReportTaskUtil;

/**
 *
 * author by 计翔 2012.9.5 币种信息的getter
 */
public class CurrencyManEntryDetailGetter extends BaseGetter {
	public Result call() throws AppException {
		String action = this.getCommQueryServletRequest().getParameter("action");
		String st = this.getCommQueryServletRequest().getParameter("st");
		List list = new ArrayList();

		String id = this.getCommQueryServletRequest().getParameter("id");
		String flag = this.getCommQueryServletRequest().getParameter("flag");
		String tskId = this.getCommQueryServletRequest().getParameter("tskId");

		ReportTaskUtil rt = null;

		try {

			if ("detail".equals(action)) {
				// 从审计任务中获取
				rt = new ReportTaskUtil();

				if ("0".equals(flag)) {
					Iterator it = ReportShowDetailService.getInstance().selectByKey(id);
					Class cls = null;
					CurrencyManEntryDetail ber = new CurrencyManEntryDetail();

					SysCurrency oldbean = SysCurrencyService.getInstance().selectById(id);
					SysCurrency newBean = null;

					ber.setOld_currency(oldbean);
					while (it.hasNext()) {
						SysTaskInfo tem = (SysTaskInfo) it.next();
						Object temp = rt.getObjctBySysTaskInfo(tem);
						cls = temp.getClass();
						if (cls.equals(SysCurrency.class)) {
							newBean = (SysCurrency) temp;
						}

					}
					ber.setCurrency(newBean);
					list.add(ber);

				} else if ("1".equals(flag)) {
					SysTaskLog systasklog = ReportShowDetailService.getInstance().selectTaskLog(tskId);
					SysCurrency newValue = null;
					SysCurrency oldValue = null;
					CurrencyManEntryDetail currency = new CurrencyManEntryDetail();

					if (systasklog.getOldVal1() != null) {

						oldValue = (SysCurrency) rt.getOldObjectByTaskLog(systasklog);
					}
					if (systasklog.getNewVal1() != null) {

						newValue = (SysCurrency) rt.getNewObjectByTaskLog(systasklog);

					}
					if (st.equals("1")) {
						currency.setOld_currency(newValue);

					} else if (st.equals("2")) {
						currency.setCurrency(newValue);
						currency.setOld_currency(oldValue);
					}
					// 删除的时候
					else if (st.equals("3")) {
						currency.setOld_currency(oldValue);
					}

					list.add(currency);

				}

			}

			ResultMng.fillResultByList(getCommonQueryBean(), getCommQueryServletRequest(), list, getResult());
			getResult().setContent(list);
			getResult().getPage().setTotalPage(1);
			getResult().init();
			

			return getResult();
		} catch (CommonException e) {
			throw new AppException(Module.SYSTEM_MODULE, Rescode.DEFAULT_RESCODE, e.getMessage());
		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE, Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}

	}

}
