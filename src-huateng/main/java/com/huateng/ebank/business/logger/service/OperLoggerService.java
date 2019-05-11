package com.huateng.ebank.business.logger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import com.huateng.ebank.business.common.DAOUtils;
import com.huateng.ebank.business.common.PageQueryCondition;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.business.logger.bean.OperLoggerBean;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.orm.HQLDAO;
import com.huateng.ebank.framework.util.ApplicationContextUtils;
import com.huateng.exception.AppException;

/**
 * 操作日志信息查询service
 * @author kevin_qin
 *
 */
public class OperLoggerService {

	protected OperLoggerService() {
	}

	public synchronized static OperLoggerService getInstance() {
		return (OperLoggerService) ApplicationContextUtils.getBean(OperLoggerService.class.getName());
	}

	/**
	 * 操作员日志信息查询
	 * @param pageIndex
	 * @param pageSize
	 * @param logBean
	 * @return
	 * @throws CommonException
	 * @throws AppException
	 */
	public PageQueryResult getOperLoggerList(int pageIndex,int pageSize,OperLoggerBean logBean) throws AppException {
		try{
			StringBuffer sb = new StringBuffer();
			List resultList = new ArrayList();
			sb.append("select ll.id,ll.txnDate,ll.brCode,ll.oprCode,ll.ipAdr,ll.oprTxnCd,ll.txnBizLog1,ll.txnStatus from TblCsBizLog ll where 1=1 ");

			if(!logBean.getBrcode().equals("")){
				sb.append(" and ll.brCode = '").append(logBean.getBrcode()).append("'");
			}
			if(!logBean.getOprcode().equals("")){
				sb.append(" and ll.oprCode = '").append(logBean.getOprcode()).append("'");
			}
			if(!logBean.getTxnDate().equals("")){
				sb.append(" and ll.txnDate = '").append(logBean.getTxnDate()).append("'");
			}

			HQLDAO hqlDAO = DAOUtils.getHQLDAO();
			PageQueryCondition queryCondition = new PageQueryCondition();
			queryCondition.setQueryString(sb.toString());
			queryCondition.setPageIndex(pageIndex);
			queryCondition.setPageSize(pageSize);
			PageQueryResult pageQueryResult = hqlDAO.pageQueryByQL(queryCondition);

			List list = pageQueryResult.getQueryResult();
			if(list != null && list.size()>0){
				for(int i=0;i<list.size();i++){
					Object[] obj = (Object[])list.get(i);
					OperLoggerBean log = new OperLoggerBean();
					String oprtxncd=this.getProperty((String)obj[5]);
					log.setId((String)obj[0]);
					log.setTxnDate((String)obj[1]);
					log.setBrcode((String)obj[2]);
					log.setOprcode((String)obj[3]);
					log.setIpAdr((String)obj[4]);
					log.setOprtxncd(oprtxncd);
					log.setTxnBizLog((String)obj[6]);
					log.setTxnStatus((String)obj[7]);
					resultList.add(log);
					pageQueryResult.setQueryResult(resultList);
				}
			}

			return pageQueryResult;

		}catch (Exception ex) {
			throw new AppException("操作日志信息查询失败:"+ex.getMessage(),ex);
		}


	}

	/**
	 *	读取配置文件
	 * @param key
	 * @return
	 * @throws CommonException
	 */
	public static String getProperty(String key) throws CommonException {
		try {
			ResourceBundle resourceBundle = ResourceBundle.getBundle("resources.oprtxncd");
			return resourceBundle.getString(key);
		} catch (MissingResourceException e) {
//			ExceptionUtil.throwCommonException("操作日志配置文件错误，没有找到[" + key + "]属性参数", ErrorCode.ERROR_CODE_INTERNAL_ERROR);
			return key;
		}
	}
}
