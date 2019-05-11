package com.gbicc.person.product.service;

import com.gbicc.person.product.dao.ProductDAO;
import com.gbicc.person.product.entity.Product;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ApplicationContextUtils;

/**
 * 
 * @author likm
 * @time   2015年10月27日16:11:28
 * @desc   产品管理服务类
 */
public class ProductService {
	protected ProductService() {
	}

	public synchronized static ProductService getInstance() {
		return (ProductService) ApplicationContextUtils
				.getBean(ProductService.class.getName());
	}
	
	private ProductDAO getDao(){
		return (ProductDAO) ApplicationContextUtils.getBean("ProductDAO");
	}
	
	public Product get(String id) throws CommonException{
		ProductDAO dao=getDao();
		return dao.getHibernateTemplate().get(Product.class, id);
	}
	
	public void save(Product product) throws CommonException{
		ProductDAO dao=getDao();
		dao.getHibernateTemplate().save(product);
	}
	
	public void update(Product product)throws CommonException{
		ProductDAO dao=getDao();
		dao.getHibernateTemplate().update(product);
	}
	
	public void delete(Product product)throws CommonException{
		ProductDAO dao=getDao();
		dao.getHibernateTemplate().delete(product);
	}
}
