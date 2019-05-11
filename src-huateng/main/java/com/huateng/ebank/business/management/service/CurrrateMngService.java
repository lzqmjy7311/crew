package com.huateng.ebank.business.management.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.huateng.ebank.business.common.ErrorCode;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.PageQueryCondition;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.entity.dao.mng.ROOTDAO;
import com.huateng.ebank.entity.dao.mng.ROOTDAOUtils;
import com.huateng.ebank.entity.data.mng.SysCurrrate;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.orm.HQLDAO;
import com.huateng.ebank.framework.util.ApplicationContextUtils;
import com.huateng.ebank.framework.util.DataFormat;
import com.huateng.ebank.framework.util.DateUtil;
import com.huateng.ebank.framework.util.ExceptionUtil;

/**
 *
 * <PRE>
 * Filename:    CurrrateMngService.java
 * Description: 汇率管理Service
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * </PRE>
 * @author     fan.yang
 * @version     1.0
 * <PRE>
 * Create at:   2014-8-20 下午04:56:13
 * Modification History:
 * Date         Author      Version     Description
 * ------------------------------------------------------------------
 * 2014-8-20      Admin     1.0         新建
 * </PRE>
 */
public class CurrrateMngService {
	@SuppressWarnings("unused")
	private static final Logger logger = Logger.getLogger(CurrrateMngService.class);

	public CurrrateMngService(){

	}

	public synchronized static CurrrateMngService getInstance() {
		return (CurrrateMngService) ApplicationContextUtils.getBean(CurrrateMngService.class.getName());
	}

	/**
	 * @Description: 修改汇率信息
	 * @author fan.yang
	 * @Created 2014年8月21日上午9:27:33
	 * @since 1.0
	 * @param syscurrrate
	 * @return
	 * @throws CommonException
	 */
    public void updateCurrrateMng(List updateList) throws CommonException{
//    	TblCurrrateDAO currrateDAO = DAOUtils.getCurrencyDAO();
    	ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
    	for (int i = 0; i< updateList.size(); i ++){
			SysCurrrate currrate = (SysCurrrate)updateList.get(i);
			StringBuffer hql = new StringBuffer();
			hql.append( "select po from SysCurrrate po where po.curcd = '"+ currrate.getCurcd() +"'");
			hql.append(" and po.id <>'"+ currrate.getId() +"'");
			hql.append(" and tocurcd ='"+ currrate.getTocurcd()+ "'");
			hql.append(" and currrateDate = '"+ currrate.getCurrrateDate() +"'");
			List list = rootdao.queryByCondition(hql.toString());
			if(list.size()!=0){
				ExceptionUtil.throwCommonException("汇率币种重复，请检查",
						ErrorCode.ERROR_CODE_CURRRATE_UPDATE);
			}else{
				currrate.setLastUpdDate(DateUtil.getTXNDate());
				currrate.setLastUpdTlr(GlobalInfo.getCurrentInstance().getTlrno());
				rootdao.update(currrate);
			}
		}
	}

    /**
	 * @Description: 添加汇率信息
	 * @author fan.yang
	 * @Created 2014年8月21日上午9:27:33
	 * @since 1.0
	 * @param syscurrrate
	 * @return
	 * @throws CommonException
	 */
	public void addCurrrateMng(List insertList) throws CommonException {
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		for (int i = 0; i< insertList.size(); i ++){
			SysCurrrate currrate = (SysCurrrate)insertList.get(i);
			currrate.setCurrrateDate(DateUtil.getTXNDate());
			SysCurrrate currrate1 = null;
			List list = new ArrayList();
			list = rootdao.queryByCondition("select po from SysCurrrate po where po.curcd = '"+ currrate.getCurcd() +"'" +
					" and tocurcd ='"+ currrate.getTocurcd()+ "'" +
							" and currrateDate = '"+ currrate.getCurrrateDate() +"'");
			if(list.size()!=0){
				ExceptionUtil.throwCommonException("汇率币种重复，请检查",
					ErrorCode.ERROR_CODE_CURRRATE_INSERT);
			}else{
				rootdao.save(currrate);
			}
		}
	}

	/**
	 * @Description: 删除汇率信息
	 * @author fan.yang
	 * @Created 2014年8月21日上午9:27:33
	 * @since 1.0
	 * @param syscurrrate
	 * @return
	 * @throws CommonException
	 */
	public void delCurrrateMng(List delList) throws CommonException {
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		for (int i = 0; i< delList.size(); i ++){
			SysCurrrate currrate = (SysCurrrate)delList.get(i);
			SysCurrrate currrate1 = rootdao.query(SysCurrrate.class,currrate.getId());
			if(currrate1!=null){
				rootdao.delete(currrate1);
			}
		}
	}

	/**
	 * @Description: 查询汇率信息
	 * @author li_hua
	 * @Created 2014年1月3日上午9:27:33
	 * @since 1.0
	 * @param currrate
	 * @return
	 * @throws CommonException
	 * @throws java.text.ParseException
	 */
	@SuppressWarnings("unchecked")
	public PageQueryResult findCurrrateByParams(int index,int pagesize,Map params) throws CommonException, java.text.ParseException{
		List oparams = new ArrayList();
		StringBuffer hql = new StringBuffer();

		hql.append("select po from SysCurrrate po where 1=1");
		if (!DataFormat.isEmpty((String)params.get("id"))) {
			hql.append(" and po.id = ?" );
			oparams.add((String)params.get("id"));
		}

		if (!DataFormat.isEmpty((String)params.get("curcd"))) {
			hql.append(" and po.curcd = ?" );
			oparams.add((String)params.get("curcd"));
		}
		if (!DataFormat.isEmpty((String)params.get("tocurcd"))) {
			hql.append(" and po.tocurcd = ?" );
			oparams.add((String)params.get("tocurcd"));
		}
//		if(!DataFormat.isEmpty((String)params.get("currrate"))){
//			hql.append(" and po.currrate = ?");
//			BigDecimal currrate = BigDecimal.valueOf(Double.parseDouble((String)params.get("currrate")));
//			oparams.add(currrate);
//		}
		if(!DataFormat.isEmpty((String)params.get("currrateDate"))){
			hql.append(" and po.currrateDate = ?");
			String currrateDate = (String) params.get("currrateDate");
			oparams.add(currrateDate);
		}
		hql.append(" order by po.currrateDate,po.curcd ");

		PageQueryCondition condition = new PageQueryCondition();
		condition.setQueryString(hql.toString());
		condition.setPageIndex(index);
		condition.setPageSize(pagesize);
		condition.setObjArray(oparams.toArray());
		HQLDAO dao = com.huateng.ebank.business.common.DAOUtils.getHQLDAO();
		PageQueryResult pageQueryResult = new PageQueryResult();
		pageQueryResult = dao.pageQueryByQL(condition);
		Iterator iter=pageQueryResult.getQueryResult().iterator();
		List outList = new ArrayList();

		while (iter.hasNext()) {
			Object[] obj = (Object[]) iter.next();
			SysCurrrate cr = (SysCurrrate) obj[0];
			outList.add(cr);
		}
		pageQueryResult.setQueryResult(outList);

		return pageQueryResult;

	}
}
