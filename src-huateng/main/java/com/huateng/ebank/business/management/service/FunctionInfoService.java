package com.huateng.ebank.business.management.service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections.CollectionUtils;
import org.hibernate.Hibernate;
import org.hibernate.type.Type;

import com.huateng.ebank.business.common.BaseDAOUtils;
import com.huateng.ebank.business.common.ErrorCode;
import com.huateng.ebank.business.common.PageQueryCondition;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.business.common.service.BctlService;
import com.huateng.ebank.business.management.bean.FunctionInfoBean;
import com.huateng.ebank.entity.dao.mng.FunctionInfoDAO;
import com.huateng.ebank.entity.data.mng.FunctionInfo;
import com.huateng.ebank.entity.data.mng.RoleFuncRel;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ApplicationContextUtils;
import com.huateng.ebank.framework.util.DataFormat;
import com.huateng.ebank.framework.util.ExceptionUtil;
import common.Logger;

/**
 * Title: FunctionInfoService Description: 锟斤拷源锟斤拷锟斤拷SERVICE Company: Shanghai
 * Huateng Software Systems Co., Ltd.
 * 
 * @author jimmy.peng
 * @date 2010-11-12
 */
public class FunctionInfoService {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(BctlService.class);

	/**
	 * Default constructor
	 */
	protected FunctionInfoService() {
	}

	/**
	 * get instance.
	 * 
	 * @return
	 */
	public synchronized static FunctionInfoService getInstance() {
		return (FunctionInfoService) ApplicationContextUtils.getBean(FunctionInfoService.class.getName());
	}

	public PageQueryResult queryFunctionInfoLst(FunctionInfoBean fiQuerybean, int pageSize, int pageIndex)
			throws CommonException {

		List resultlist = new ArrayList();
		StringBuffer sb = new StringBuffer();
		sb.append("select fi from FunctionInfo fi where 1=1");

		if (!DataFormat.isEmpty(fiQuerybean.getId())) {
			// 锟斤拷锟斤拷锟睫革拷页锟芥，锟斤拷要锟斤拷锟斤拷确锟斤拷询锟斤拷锟斤拷锟斤拷模锟斤拷锟窖�
			if (!DataFormat.isEmpty(fiQuerybean.getOpr()) && "modify".equals(fiQuerybean.getOpr()))
				sb.append(" and fi.id = '" + fiQuerybean.getId() + "'");
			else
				sb.append(" and fi.id like '%" + fiQuerybean.getId() + "%'");
		}
		if (!DataFormat.isEmpty(fiQuerybean.getFuncname())) {
			sb.append(" and fi.funcname like '%" + fiQuerybean.getFuncname() + "%'");
		}
		PageQueryCondition queryCondition = new PageQueryCondition();
		queryCondition.setQueryString(sb.toString());
		queryCondition.setPageIndex(pageIndex);
		queryCondition.setPageSize(pageSize);
		PageQueryResult pageQueryResult = BaseDAOUtils.getHQLDAO().pageQueryByQL(queryCondition);
		Iterator iter = pageQueryResult.getQueryResult().iterator();
		List resultList = new ArrayList();
		FunctionInfoBean fiResultBean = null;
		FunctionInfo fi = null;
		while (iter.hasNext()) {
			fiResultBean = new FunctionInfoBean(); // 目锟斤拷锟斤拷锟�
			fi = new FunctionInfo(); // 源锟斤拷锟斤拷
			Object[] obj = (Object[]) iter.next();
			fi = (FunctionInfo) obj[0];
			try {
				BeanUtils.copyProperties(fiResultBean, fi);
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
			resultList.add(fiResultBean);
		}
		pageQueryResult.setQueryResult(resultList);
		return pageQueryResult;
	}

	public List queryLst() throws CommonException {

		List resultlist = new ArrayList();
		PageQueryResult pageQueryResult = null;
		resultlist = BaseDAOUtils.getFunctionInfoDAO().queryByCondition("1=1");
		return resultlist;
	}

	private void cycleQuery(FunctionInfo fi, List<FunctionInfo> store) throws CommonException {
		store.add(fi);
		List<FunctionInfo> foo = BaseDAOUtils.getFunctionInfoDAO().queryByCondition(" po.lastdirectory=" + fi.getId());
		if (foo.size() > 0) {
			for (FunctionInfo bar : foo) {
				this.cycleQuery(bar, store);
			}
		}
	}

	public void rebuildAll(List<FunctionInfoBean> li, int location) throws CommonException {
		FunctionInfoDAO fidao = BaseDAOUtils.getFunctionInfoDAO();
		List<FunctionInfo> delLi = fidao.queryByCondition(" po.location=" + location + " ");
		for (FunctionInfo bean : delLi) {
			fidao.delete(bean);
		}
		if (CollectionUtils.isNotEmpty(li)) {
			for (FunctionInfoBean foo : li) {
				FunctionInfo bar = this.convert2FunctionInfo(foo);
				fidao.insert(bar);
			}
		}
	}

	/**
	 * 锟斤拷删锟斤拷锟斤拷源锟斤拷息
	 * 
	 * @param delList
	 * @param insertList
	 * @param updateList
	 * 
	 */
	public void saveUpdateDeleteFucInfo(List delList, List insertList, List updateList) throws CommonException {
		FunctionInfoDAO fiInfoDAO = BaseDAOUtils.getFunctionInfoDAO();

		for (Object foo : updateList) {
			FunctionInfoBean fbean = (FunctionInfoBean) foo;
			List<?> fiLst = fiInfoDAO.queryByCondition(" po.id = '" + fbean.getId() + "'");
			if (CollectionUtils.isEmpty(fiLst)) {
				ExceptionUtil.throwCommonException("没有查到id为:" + fbean.getId() + "的信息，请核查", ErrorCode.RECORD_NOT_EXIST);
			}
			FunctionInfo bar = (FunctionInfo) fiLst.get(0);
			org.springframework.beans.BeanUtils.copyProperties(fbean, bar);
			fiInfoDAO.update(bar);
		}

		List<FunctionInfo> newDelList = new ArrayList<FunctionInfo>();
		for (Object foo : delList) {
			FunctionInfoBean bar = (FunctionInfoBean) foo;
			List<FunctionInfo> first = fiInfoDAO.queryByCondition(" po.id='" + bar.getId() + "'");
			if (first.size() == 1) {
				this.cycleQuery(first.get(0), newDelList);
			} else {
				throw new RuntimeException("ID为" + bar.getId() + "的数量防非法：找到" + first.size() + "个");
			}
		}

		for (FunctionInfo foo : newDelList) {
			List<RoleFuncRel> relList = BaseDAOUtils.getRoleFuncRelDAO().queryByCondition(
					" po.funcid='" + foo.getId() + "'");
			for (RoleFuncRel bar : relList) {
				BaseDAOUtils.getRoleFuncRelDAO().delete(bar);
			}
			fiInfoDAO.delete(foo);
		}

		for (Object fibean : insertList) {
			FunctionInfoBean fbean = (FunctionInfoBean) fibean;
			List<?> checklist = BaseDAOUtils.getFunctionInfoDAO().queryByCondition(" po.id = ?",
					new Object[] { fbean.getId() }, new Type[] { Hibernate.STRING });
			if (CollectionUtils.isNotEmpty(checklist)) {
				ExceptionUtil.throwCommonException("id为:" + fbean.getId() + "的记录已存在，请核查", ErrorCode.RECORD_HAS_EXIST);
			}
			fiInfoDAO.insert(this.convert2FunctionInfo(fbean));
		}

	}

	private FunctionInfo convert2FunctionInfo(FunctionInfoBean bean) {
		FunctionInfo result = new FunctionInfo();
		org.springframework.beans.BeanUtils.copyProperties(bean, result);
		result.setFuncname(bean.getFuncname());
		result.setPagepath(bean.getPagepath());
		result.setLocation(bean.getLocation());
		result.setIsdirectory(bean.getIsdirectory());
		result.setLastdirectory(bean.getLastdirectory());
		result.setShowseq(bean.getShowseq());
		result.setFuncDesc(bean.getFuncDesc());
		result.setStatus(bean.getStatus());
		result.setIconCls(bean.getIconCls());
		return result;
	}
}
