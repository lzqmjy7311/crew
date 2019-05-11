package com.gbicc.person.product.update;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gbicc.person.product.entity.Product;
import com.gbicc.person.product.operation.ProductOperation;
import com.gbicc.person.product.service.ProductService;
import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;


/**
 * @author likm
 * @time   2015年10月27日16:07:37
 * @desc   产品保存
 */
public class ProductUpdate extends BaseUpdate {
	private static final String DATASET_ID = "ProductEntry";

	@SuppressWarnings("rawtypes")
	@Override
	public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean arg0,
			HttpServletRequest arg1, HttpServletResponse arg2)
			throws AppException {
		try {
			UpdateReturnBean updateReturnBean = new UpdateReturnBean();
			UpdateResultBean updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID(DATASET_ID);
			OperationContext oc = new OperationContext();
			List<Product> list=new ArrayList<Product>();
			while(updateResultBean.hasNext()){
				Product product = new Product();
				Map map = updateResultBean.next();
				String recordState = map.get("recordState").toString();
				if("insert".equals(recordState)) {
					product = new Product();
				} else if ("modify".equals(recordState)) {
					product = ProductService.getInstance().get((String) map.get("id"));
				}
				mapToObject(product,map);
				list.add(product);
			}
			oc.setAttribute("list",list);
			OPCaller.call(ProductOperation.ID, oc);
			return updateReturnBean;
		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,
				Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}
}