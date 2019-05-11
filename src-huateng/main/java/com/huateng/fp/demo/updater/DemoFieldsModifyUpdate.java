package com.huateng.fp.demo.updater;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;
import com.huateng.fp.demo.bean.DemoFields;

public class DemoFieldsModifyUpdate extends BaseUpdate {

	@Override
	public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean multiUpdateResultBean, HttpServletRequest request,
			HttpServletResponse response) throws AppException {
		UpdateReturnBean updateReturnBean = new UpdateReturnBean();
		UpdateResultBean updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID("DemoFields");
		List<DemoFields> updateList = new ArrayList<DemoFields>();
		List<DemoFields> delList = new ArrayList<DemoFields>();
		List<DemoFields> insertList = new ArrayList<DemoFields>();
		DemoFields databean = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
		SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		while (updateResultBean.hasNext()) {
			databean = new DemoFields();
			Map<String, String> map = updateResultBean.next();
			try {
				databean.setAge(Integer.valueOf(map.get("age")));
				databean.setBirthday(sdf.parse(map.get("birthday")));
				databean.setId(map.get("id"));
				databean.setManagerId(map.get("managerId"));
				databean.setName(map.get("name"));
				databean.setPid(map.get("pid"));
				databean.setSalary(Double.valueOf(map.get("salary")));
				databean.setSex(map.get("sex"));
				databean.setWorkEndTime(map.get("workEndTime"));
				databean.setWorkStartTime(Timestamp.valueOf(sdf3.format(sdf2.parse(map.get("workStartTime")))));
				databean.setYyyymm(map.get("yyyymm"));
			} catch (ParseException e) {
				throw new RuntimeException(e);
			}

			switch (updateResultBean.getRecodeState()) {
			case UpdateResultBean.INSERT:
				insertList.add(databean);
				break;
			case UpdateResultBean.DELETE:
				delList.add(databean);
				break;
			case 0:
				delList.add(databean);
				break;
			case UpdateResultBean.MODIFY:
				updateList.add(databean);
				break;
			default:
				break;
			}
		}
		if (insertList.size() > 0) {
			int max = 0;
			for (DemoFields bean : DemoFields.DATA) {
				int tmp = Integer.valueOf(bean.getId());
				if (tmp > max) {
					max = tmp;
				}
			}
			int i = 0;
			for (DemoFields foo : insertList) {
				i++;
				foo.setId(String.valueOf(max + i));
				DemoFields.DATA.add(foo);
			}
		}
		for (DemoFields foo : delList) {
			for (DemoFields bar : DemoFields.DATA) {
				if (bar.getId().equals(foo.getId())) {
					DemoFields.DATA.remove(bar);
					break;
				}
			}
		}
		for (DemoFields foo : updateList) {
			for (DemoFields bar : DemoFields.DATA) {
				if (bar.getId().equals(foo.getId())) {
					try {
						BeanUtils.copyProperties(bar, foo);
					} catch (Exception e) {
						throw new RuntimeException(e);
					}
					break;
				}
			}
		}

		return updateReturnBean;

	}

}
