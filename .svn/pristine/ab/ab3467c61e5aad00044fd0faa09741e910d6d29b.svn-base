package com.huateng.ebank.business.dataquery.service;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.huateng.ebank.entity.dao.mng.BctlDAO;
import com.huateng.ebank.entity.dao.mng.ROOTDAOUtils;
import com.huateng.ebank.entity.data.mng.Bctl;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ApplicationContextUtils;

public class ExecuteStateQueryService {
//	private List<ExecuteStateQueryBean> list = new ArrayList<ExecuteStateQueryBean>();
//	{
//		ExecuteStateQueryBean bean1 = new ExecuteStateQueryBean("999999", "总行",
//				new SimpleDateFormat("yyyyMMdd").format(new Date()), "数据导入", "上报数据", new Date(System.currentTimeMillis()-24*60*60*1000), new Date(System.currentTimeMillis()-1000));
//		ExecuteStateQueryBean bean2 = new ExecuteStateQueryBean("111111", "分行", new SimpleDateFormat("yyyy-MM-dd").format(new Date()), "补录", "补录数据", new Date(System.currentTimeMillis()-24*60*60*1000), new Date(System.currentTimeMillis()-1000));
//		list.add(bean1);
//		list.add(bean2);
//	}
	/*
	 * 获得自身实例
	 */
	public synchronized static ExecuteStateQueryService getInstance() {
		return (ExecuteStateQueryService) ApplicationContextUtils.getBean(ExecuteStateQueryService.class.getName());
	}

//	/*
//	 * 分页服务
//	 */
//	public List<ExecuteStateQueryBean> pageQueryByHql(String hql) {
//		// TODO Auto-generated method stub
//		return getTestDataSet();
//	}


	/*
	 * 根据机构号brno查询机构名称brname
	 *
	 */
	public String getBrno(String brname) {
		BctlDAO dao = ROOTDAOUtils.getBctlDAO();
		try {
			List<Bctl> list = null;
			brname = StringUtils.trim(brname);
			if(StringUtils.isNotBlank(brname)) {
				list = dao.queryByCondition(" po.brname LIKE '%" + brname+ "%' ");
			}
			if(list.size() == 0 ) {
				return null;
			}
			return list.get(0).getBrno();
		} catch (CommonException e) {
			e.printStackTrace();
		}
		return null;
	}

//	public List<ExecuteStateQueryBean> getTestDataSet() {
//		return list;
//	}
}
