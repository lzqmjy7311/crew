package com.gbicc.person.customer.service;


import com.gbicc.person.customer.dao.TCustomerDAO;
import com.gbicc.person.customer.entity.TCustomer;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ApplicationContextUtils;

/**
 * 
 * @author xudongdong
 *
 * 版本：2015年10月21日 上午11:17:41
 * 类说明：客户管理 service
 */
public class TCustomerService {
	protected TCustomerService() {
	}

	public synchronized static TCustomerService getInstance() {
		return (TCustomerService) ApplicationContextUtils
				.getBean(TCustomerService.class.getSimpleName());
	}
	
	private TCustomerDAO getDao(){
		return (TCustomerDAO) ApplicationContextUtils.getBean("TCustomerDAO");
	}
	
	public TCustomer get(String id) throws CommonException{
		TCustomerDAO dao=getDao();
		return dao.query(id);
	}
	
	public void save(TCustomer tCustomer) throws CommonException{
		TCustomerDAO dao=getDao();
		dao.insert(tCustomer);
	}
	
	public void update(TCustomer tCustomer) throws CommonException{
		TCustomerDAO dao=getDao();
		dao.update(tCustomer);
	}
	
	public void delete(String id) throws CommonException{
		TCustomerDAO dao=getDao();
		dao.delete(id);
	}
}
