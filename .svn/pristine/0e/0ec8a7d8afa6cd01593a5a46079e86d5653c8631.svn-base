package com.huateng.ebank.business.management.operation;

import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;

import com.huateng.common.CommonFunction;
import com.huateng.ebank.business.common.BaseDAOUtils;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.entity.dao.mng.RelationCodeDAO;
import com.huateng.ebank.entity.data.mng.RelationCode;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.util.DateUtil;

public class RelationCodeOperation extends BaseOperation {
	public static final String CMD = "CMD";
	public static final String ID = "Management.RelationCodeOperation";
	public static final String OUT_RELATION_CODE_LIST = "OUT_RELATION_CODE_LIST";
	public static final String INSERT_LIST = "INSERT_LIST";
	public static final String UPDATE_LIST = "UPDATE_LIST";
	public static final String DELETE_LIST = "DELETE_LIST";
	private static final int TABLE_ID_LEN = 3;
	
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(RelationCodeOperation.class);

	public void afterProc(OperationContext context) throws CommonException {
	}

	public void beforeProc(OperationContext context) throws CommonException {
	}

	public void execute(OperationContext context) throws CommonException {
		RelationCodeDAO dao = BaseDAOUtils.getRelationCodeDAO();
		List delList = (List) context.getAttribute(DELETE_LIST);
		List updateList = (List) context.getAttribute(UPDATE_LIST);
		List insertList = (List) context.getAttribute(INSERT_LIST);
		GlobalInfo gi = GlobalInfo.getCurrentInstanceWithoutException();
		// 删除操作.把状态设置为无效
		for (Iterator it = delList.iterator(); it.hasNext();) {
			RelationCode bean = (RelationCode) it.next();
			//oracle ： 主键位数不足时补足位数
			String id = CommonFunction.fillString(bean.getId(),' ', TABLE_ID_LEN, true);
			
			RelationCode delBean = dao.queryById(id);
			if(delBean != null){
				dao.delete(delBean);
			}else{
				logger.debug("删除失败,记录未找到!\n id=["+bean.getId()+"]");
			}
		}
		BaseDAOUtils.getHQLDAO().flush();
		if(logger.isDebugEnabled()){
			logger.debug("删除完成");
		}
		// 修改操作.
		for (Iterator it = updateList.iterator(); it.hasNext();) {
			RelationCode bean = (RelationCode) it.next();
			//oracle ： 主键位数不足时补足位数
			String id = CommonFunction.fillString(bean.getId(),' ', TABLE_ID_LEN, true);
			bean.setId(id);
			bean.setLastUpdDate(DateUtil.getCurrentDate());
			bean.setLastUpdTlr(gi.getTlrno());
			dao.update(bean);
		}
		BaseDAOUtils.getHQLDAO().flush();
		if(logger.isDebugEnabled()){
			logger.debug("修改完成");
		}

		// 增加操作.
		for (Iterator it = insertList.iterator(); it.hasNext();) {
			RelationCode bean = (RelationCode) it.next();
			bean.setLastUpdDate(DateUtil.getCurrentDate());
			bean.setLastUpdTlr(gi.getTlrno());
			dao.insert(bean);
		}
		if(logger.isDebugEnabled()){
			logger.debug("新增完成");
		}
	}
	
}
