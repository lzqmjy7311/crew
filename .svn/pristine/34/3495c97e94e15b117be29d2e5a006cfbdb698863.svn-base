package com.huateng.ebank.business.management.getter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.gbicc.common.FileUpDownProperties;
import com.huateng.common.DataFormat;
import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.DAOUtils;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.business.common.service.BctlService;
import com.huateng.ebank.entity.dao.mng.ROOTDAO;
import com.huateng.ebank.entity.dao.mng.ROOTDAOUtils;
import com.huateng.ebank.entity.data.mng.Bctl;
import com.huateng.ebank.entity.data.mng.DataDic;
import com.huateng.ebank.framework.report.common.ReportConstant;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;
import com.huateng.report.utils.ReportEnum;

public class BranchManageQueryGetter extends BaseGetter {

	public Result call() throws AppException {
		try {
			this.setValue2DataBus(ReportConstant.QUERY_LOG_BUSI_NAME, "机构管理查询");
			/** 获取查询条件 */
			Map param = this.getCommQueryServletRequest().getParameterMap();
			/** 获取everyPage：每页包含的记录数 */
			int everypage = Integer.parseInt(param.get("everyPage").toString());
			/** 获取nextPage：表示下一页是第几页 */
			int nextpage = Integer.parseInt(param.get("nextPage").toString());
			/** 获取所有查询结果 */
			//String brcode = GlobalInfo.getCurrentInstance().getBrcode();
			//mod by zhaozhiguo 2012/2/16 FPP-9 用户,岗位及机构的管理页面优化调整 begin
			//List list = BctlService.getInstance().getAllEnableBctl();//.getAllDownBrcodeList(brcode);
			String brno = (String) param.get("brhNo");
			String brname = (String) param.get("brhName");
			String upbrcode = (String) param.get("upbrcode");
			String qst = getCommQueryServletRequest().getParameter("st");
			String hql = "from Bctl where del='F' ";
			StringBuilder builder = new StringBuilder();

			if (!DataFormat.isEmpty(brno)) {
				hql += " and brno like '%" + brno + "%'  ";
			}
			if (!DataFormat.isEmpty(brname)) {
				hql += " and brname like '%" + brname + "%'  ";
			}
			if (StringUtils.isNotBlank(upbrcode)) {
				if (GlobalInfo.getCurrentInstance().isHeadBrcode()) {
					hql += " and blnUpBrcode='" + upbrcode + "' ";
				}
			}
			if (qst != null && qst.length() > 0) {
				hql += (" and st ='" + qst + "'");
			} else {
				hql += (" and st<>'" + ReportEnum.REPORT_ST1.N.value + "'");
			}
			builder.append(hql);

			hql += (" order by brclass,brcode");
			PageQueryResult pageQueryResult = ROOTDAOUtils.getROOTDAO()
					.pageQueryByHql(nextpage, everypage, hql);

			ResultMng.fillResultByList(getCommonQueryBean(),
					getCommQueryServletRequest(),
					pageQueryResult.getQueryResult(), getResult());
			result.setContent(pageQueryResult.getQueryResult());
			result.getPage().setTotalPage(
					pageQueryResult.getPageCount(getResult().getPage()
							.getEveryPage()));
			/*
			 * if (pageQueryResult.getQueryResult().size() == 0) {
			 * result.getPage().setTotalPage(0); } else {
			 * result.getPage().setTotalPage(1); }
			 */
			result.init();

			this.setValue2DataBus(ReportConstant.QUERY_LOG_BUSI_NAME, "机构管理查询");
			return result;
		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}

	}

	public static String getTime(String format) {
		SimpleDateFormat df = new SimpleDateFormat(format);
		return df.format(new Date());
	}

	protected PageQueryResult getData() throws Exception {
		PageQueryResult pageQueryResult = new PageQueryResult();

		String brcode = GlobalInfo.getCurrentInstance().getBrcode();

		List list = BctlService.getInstance().getAllDownBrcodeList(brcode);

		pageQueryResult.setQueryResult(list);

		return pageQueryResult;

	}

	protected Class getDataObjectClass() {
		// TODO Auto-generated method stub
		return Bctl.class;
	}

	private String getName(List list, String datano) {
		for (int i = 0; i < list.size(); i++) {
			DataDic dd = (DataDic) list.get(i);
			if (dd.getDataNo().equals(datano)) {
				return dd.getDataName();
			}
		}
		return null;
	}

}
