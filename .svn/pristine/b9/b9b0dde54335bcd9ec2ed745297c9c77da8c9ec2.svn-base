/*
 * ==================================================================
 * The Huateng Software License
 *
 * Copyright (c) 2004-2005 Huateng Software System.  All rights
 * reserved.
 * ==================================================================
 */
package com.huateng.ebank.business.parammng.cqGetter;


import java.util.ArrayList;
import java.util.List;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.DAOUtils;
import com.huateng.ebank.business.common.ErrorCode;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.business.common.SystemConstant;
import com.huateng.ebank.business.common.service.BctlService;
import com.huateng.ebank.business.parammng.bean.TlrBrcodeCondition;
import com.huateng.ebank.entity.dao.mng.BctlDAO;
import com.huateng.ebank.entity.dao.mng.TlrInfoDAO;
import com.huateng.ebank.entity.data.mng.TlrInfo;
import com.huateng.ebank.framework.util.DataFormat;
import com.huateng.ebank.framework.util.ExceptionUtil;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

/**
 * @author fanissac    yjw   modify
 * @date 2007-12-14
 * @desc
 */
public class TlrInfo1Getter extends BaseGetter {


	public Result call() throws AppException {
		// TODO Auto-generated method stub
		try{

			TlrBrcodeCondition tbc = new TlrBrcodeCondition();
			BeanUtilsEx(tbc,getCommQueryServletRequest().getParameterMap());
			tbc.setTlrno((String) getCommQueryServletRequest().getParameterMap().get("tlrno1"));
			tbc.setBrcode((String) getCommQueryServletRequest().getParameterMap().get("brcode1"));
			PageQueryResult pageResult = getData(tbc);


			ResultMng.fillResultByList(
					getCommonQueryBean(),
					getCommQueryServletRequest(),
					pageResult.getQueryResult(),
					getResult());

			result.setContent(pageResult.getQueryResult());
			if(pageResult.getQueryResult()==null||pageResult.getQueryResult().size() == 0){
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

    /*
     * (non-Javadoc)
     *
     * @see com.extra.common.ObjectDataGetter#getData()
     */
    protected PageQueryResult getData(TlrBrcodeCondition tbc) throws Exception {

    	PageQueryResult pageQueryResult = new PageQueryResult();
    	GlobalInfo globalinfo = GlobalInfo.getCurrentInstance();
    	TlrInfoDAO dao = DAOUtils.getTlrInfoDAO();
		String brcode = DataFormat.trim(tbc.getBrcode());
		String tlrno = DataFormat.trim(tbc.getTlrno());
		List tlrInfoList = new ArrayList();
		if(DataFormat.isEmpty(brcode) && DataFormat.isEmpty(tlrno)) {
			ExceptionUtil.throwCommonException("机构号与操作员号必输其一", ErrorCode.ERROR_CODE_CANNOT_SUBMIT);
		}
		if(!DataFormat.isEmpty(brcode)){
			BctlDAO bctlDao = DAOUtils.getBctlDAO();
			try {
				bctlDao.query(brcode);
			} catch (Exception e) {
				ExceptionUtil.throwCommonException("输入机构号不存在", ErrorCode.ERROR_CODE_CANNOT_SUBMIT);
			}
			if (!BctlService.getInstance().isBlnBrcode(brcode, globalinfo.getBrcode())) {
				ExceptionUtil.throwCommonException("输入机构号不为本机构或者下属机构", ErrorCode.ERROR_CODE_CANNOT_SUBMIT);
			}
		}

		if (!DataFormat.isEmpty(brcode) && DataFormat.isEmpty(tlrno)) {
			//只用机构号查询, 可以查询到全部操作员列表
			tlrInfoList = dao.queryByCondition("po.brcode = '" + brcode + "' order by po.status desc, po.extTlrno ");
		} else if (DataFormat.isEmpty(brcode) && !DataFormat.isEmpty(tlrno)) {
			/** modified by junzhong.duan 20110421 LNDN-170 begin*/
			//tlrInfoList = dao.queryByCondition("po.extTlrno = '" + tlrno + "'");
			tlrInfoList = dao.queryByCondition("po.tlrno = '" + tlrno + "'");
			/** modified by junzhong.duan 20110421 LNDN-170 end*/
		} else {
			tlrInfoList = dao.queryByCondition("po.brcode = '" + brcode + "'and po.extTlrno ='" + tlrno + "' and po.status <> '"
					+ SystemConstant.TLR_NO_STATE_QUIT + "'");
		}
		// 获取操作员所在机构的外部机构号
		if (tlrInfoList != null && tlrInfoList.size() > 0) {
			for (int i = 0; i < tlrInfoList.size(); i++) {
				TlrInfo tlrInfo1 = (TlrInfo) tlrInfoList.get(i);
				tlrInfo1.setBrno(BctlService.getInstance().getExtBrno(tlrInfo1.getBrcode()));
			}
			pageQueryResult.setTotalCount(tlrInfoList.size());
		} else {
			pageQueryResult.setTotalCount(0);
		}
		pageQueryResult.setQueryResult(tlrInfoList);

        return pageQueryResult;
    }
}


