package com.gbicc.person.product.operation;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.gbicc.person.product.entity.Product;
import com.gbicc.person.product.service.ProductService;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;


/**
 * @author likm
 * @time   2015年10月27日16:08:51
 * @desc   产品管理操作类
 */
public class ProductOperation extends BaseOperation {
	public static final String ID = "ProductOperation";
	public static final String CMD = "CMD";
	public static final String CMD_QUERY = "CMD_QUERY";
	public static final String CMD_INSERT = "CMD_INSERT";
	public static final String CMD_UPDATE = "CMD_UPDATE";
	public static final String CMD_DELETE = "CMD_DELETE";
	public static final String IN_PARAM = "IN_PARAM";
	
	@Override
	public void afterProc(OperationContext context) throws CommonException {
	}

	@Override
	public void beforeProc(OperationContext context) throws CommonException {
	}

	@SuppressWarnings("unchecked")
	@Override
	public void execute(OperationContext context) throws CommonException {
		List<Product> list = (List<Product>) context.getAttribute("list");
		ProductService service = ProductService.getInstance();
		for(Product p:list){
			if(StringUtils.isNotEmpty(p.getId())){
				service.update(p);
			}else{
				service.save(p);
			}
		}
	}
}
