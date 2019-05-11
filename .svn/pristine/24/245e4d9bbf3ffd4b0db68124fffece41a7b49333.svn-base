package com.huateng.ebank.business.management.service;

import org.apache.log4j.Logger;

import com.huateng.ebank.business.common.DAOUtils;
import com.huateng.ebank.entity.dao.mng.PfSysParamDAO;
import com.huateng.ebank.entity.data.mng.PfSysParam;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ApplicationContextUtils;

public class SystemParamService {
	private static final Logger logger = Logger.getLogger(SystemParamService.class);

	protected SystemParamService() {
	}

	public synchronized static SystemParamService getInstance() {
		return (SystemParamService) ApplicationContextUtils.getBean(SystemParamService.class.getName());
	}

	// /**
	// * 获取押品大类服务
	// * 如果输入押品代码就按押品代码查询，否则返回全部
	// * @return
	// * @throws CommonException
	// */
	// public List getAllBigGageClass(String gageCode) throws CommonException {
	// GageClassDAO gcd = DAOUtils.getGageClassDAO();
	// List returnList = new ArrayList();
	// if(!DataFormat.isEmpty(gageCode)){
	// GageClass gc = gcd.query(gageCode);
	// returnList.add(gc);
	// }else{
	// returnList = gcd.getBigGageClassList();
	// }
	// return returnList;
	// }
	//
	// /**
	// * 根据条件获取押品类型信息 add by Gary.Du
	// *
	// * @return
	// * @throws CommonException
	// */
	// public List getGageClassByCondition(String gageLevel, String gageType)
	// throws CommonException {
	// GageClassDAO gcd = DAOUtils.getGageClassDAO();
	// String whereString = " 1=1";
	// if (gageLevel != null && !"".equals(gageLevel)) {
	// whereString += " and gageLevle ='" + gageLevel + "'";
	// }
	// if (gageType != null && !"".equals(gageType)) {
	// whereString += " and gageType ='" + gageType + "'";
	// }
	// List returnList = gcd.queryByCondition(whereString);
	// return returnList;
	// }
	//
	// /**
	// * 根据条件获取押品类型信息 add by Gary.Du
	// *
	// * @return
	// * @throws CommonException
	// */
	// public GageClass getGageClassByNo(String gageCode) throws CommonException
	// {
	// GageClassDAO gcd = DAOUtils.getGageClassDAO();
	// //GageClass gageClass = gcd.query(gageCode);
	// GageClass gageClass = null;
	// List list = gcd.queryByCondition("po.id = '" + gageCode + "'");
	// if(list != null && list.size() > 0){
	// gageClass = (GageClass)list.get(0);
	// }
	// return gageClass;
	// }
	//
	// /**
	// * 根据押品大类获取押品小类信息 add by Gary.Du
	// *
	// * @param gageUpCode
	// * @return
	// * @throws CommonException
	// */
	// public List getSmallGageClassByCondition(String gageUpCode, String
	// gageLevle)
	// throws CommonException {
	// GageClassDAO gcd = DAOUtils.getGageClassDAO();
	// String whereString = " 1=1";
	// if (gageUpCode != null && !"".equals(gageUpCode)) {
	// whereString += " and gageUpCode ='" + gageUpCode + "'";
	// }
	// if (gageLevle != null && !"".equals(gageLevle)) {
	// whereString += " and gageLevle ='" + gageLevle + "'";
	// }
	// List returnList = gcd.queryByCondition(whereString);
	// return returnList;
	// }
	//
	// /**
	// * 获取押品小类服务
	// *
	// * @param gageUpCode
	// * @return
	// * @throws CommonException
	// */
	// public List getSmallGageClassList(String gageUpCode) throws
	// CommonException {
	// GageClassDAO gcd = DAOUtils.getGageClassDAO();
	// // if (gcd.query(gageUpCode) == null) {
	// // throw new CommonException(
	// // ErrorCode.ERROR_CODE_SET_GAGE_CLASS_AFTER_SAVE);
	// // }
	// List returnList = gcd.getSmallGageClassList(gageUpCode);
	// return returnList;
	// }
	//
	// /**
	// * 新增修改押品大类
	// *
	// * @param insertList
	// * @param updateList
	// * @throws CommonException
	// */
	// public void iuBigGageClass(List insertList, List updateList)
	// throws CommonException {
	// GageClassDAO dao = DAOUtils.getGageClassDAO();
	// // 修改操作.
	// for (Iterator it = updateList.iterator(); it.hasNext();) {
	// GageClass bean = (GageClass) it.next();
	// dao.update(bean);
	// }
	// DAOUtils.getHQLDAO().flush();
	//
	// // 增加操作.
	// for (Iterator it = insertList.iterator(); it.hasNext();) {
	// GageClass bean = (GageClass) it.next();
	// bean.setGageUpCode(bean.getId());
	// bean.setGageLevle("0");
	// bean.setGageSubType("0");
	// dao.insert(bean);
	// }
	// }
	//
	// /**
	// * 新增修改押品小类
	// *
	// * @param insertList
	// * @param updateList
	// * @throws CommonException
	// */
	// public void iuSmallGageClass(List insertList, List updateList)
	// throws CommonException {
	// GageClassDAO dao = DAOUtils.getGageClassDAO();
	// // 修改操作.
	// for (Iterator it = updateList.iterator(); it.hasNext();) {
	// GageClass bean = (GageClass) it.next();
	// dao.update(bean);
	// }
	// DAOUtils.getHQLDAO().flush();
	//
	// // 增加操作.
	// for (Iterator it = insertList.iterator(); it.hasNext();) {
	// GageClass bean = (GageClass) it.next();
	// bean.setGageLevle("1");
	// dao.insert(bean);
	// }
	// }
	//
	// /**
	// *
	// * Description: 查询所有预警信号代码
	// *
	// * @param
	// * @return List
	// * @exception
	// * @author hyurain_yang
	// * @version v1.0,2008-8-12
	// */
	// public List getWarningCodeList() throws CommonException {
	// WarningCodeDAO warningCodeDAO = DAOUtils.getWarningCodeDAO();
	// List warningCodeList = warningCodeDAO
	// .queryByCondition("1=1 order by po.id");
	// return warningCodeList;
	// }
	//
	// /**
	// *
	// * Description: 通过预警信号代码类型获得客户预警信号代码信息列表
	// *
	// * @param warningType
	// * @return List
	// * @exception
	// * @author hyurain_yang
	// * @version v1.0,2008-8-12
	// */
	// public List getWarningCodeListByWarningType(String warningType)
	// throws CommonException {
	// WarningCodeDAO warningCodeDAO = DAOUtils.getWarningCodeDAO();
	// List warningCodeList = warningCodeDAO.queryByCondition(
	// "po.warningType=? ORDER BY po.id",
	// new Object[] { warningType }, new Type[] { Hibernate.STRING });
	// return warningCodeList;
	// }
	//
	// /**
	// *
	// * Description: 增删改预警信号代码
	// *
	// * @param insertList,updateList,deleteList
	// * @return void
	// * @exception
	// * @author hyurain_yang
	// * @version v1.0,2008-8-12
	// */
	// public void modifyWarningCode(List insertList, List updateList,
	// List deleteList) throws CommonException {
	// WarningCodeDAO warningCodeDAO = DAOUtils.getWarningCodeDAO();
	// HQLDAO dao = DAOUtils.getHQLDAO();
	//
	// for (int i = 0; i < insertList.size(); i++) {
	// WarningCode bean = (WarningCode) insertList.get(i);
	// warningCodeDAO.insert(bean);
	// }
	// dao.flush();
	//
	// for (int i = 0; i < updateList.size(); i++) {
	// WarningCode bean = (WarningCode) updateList.get(i);
	// warningCodeDAO.update(bean);
	// }
	// dao.flush();
	//
	// for (int i = 0; i < deleteList.size(); i++) {
	// WarningCode bean = (WarningCode) deleteList.get(i);
	// warningCodeDAO.delete(bean);
	// }
	// }

	/**
	 * 
	 * Description: TODO
	 * 
	 * @param
	 * @return PfSysParam
	 * @exception
	 * @author Administrator
	 * @version v1.0,2008-11-15
	 */
	public PfSysParam getPfSysParamByCondition(String magicId, String paramId) throws CommonException {
		PfSysParamDAO pfSysParamDAO = DAOUtils.getPfSysParamDAO();
		return pfSysParamDAO.query(magicId, paramId);
	}

	public static synchronized String queryParameter(String magicId, String paramId) throws CommonException {
		PfSysParamDAO pfSysParamDAO = DAOUtils.getPfSysParamDAO();
		PfSysParam pf = pfSysParamDAO.query(magicId, paramId);
		return pf.getParamValueTx();
	}

}
