package com.huateng.fp.demo.getter;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;
import com.huateng.fp.demo.bean.DemoFields;

public class DemoFieldsGetter extends BaseGetter {

	@Override
	public Result call() throws AppException {
		List<DemoFields> li = new ArrayList<DemoFields>();
		String parmId = this.getCommQueryServletRequest().getParameter("id");
		String parmName = this.getCommQueryServletRequest().getParameter("name");
		if (StringUtils.isNotBlank(parmId)) {
			for (DemoFields foo : DemoFields.DATA) {
				if (foo.getId().equals(StringUtils.strip(parmId))) {
					if (StringUtils.isBlank(parmName) && foo.getName().indexOf(StringUtils.strip(parmName)) > -1) {
						li.add(foo);
					}
					break;
				}
			}
		} else if (StringUtils.isNotBlank(parmName)) {
			for (DemoFields foo : DemoFields.DATA) {
				if (foo.getName().indexOf(StringUtils.strip(parmName)) > -1) {
					li.add(foo);
				}
			}
		} else {
			li.addAll(DemoFields.DATA);
		}

		int total = li.size();

		// 分页大小
		int pageSize = getResult().getPage().getEveryPage();
		// 页码
		int pageIndex = getResult().getPage().getCurrentPage();

		li = li.subList(Math.max(0, Math.min((pageIndex - 1) * pageSize, total - 1)),
				Math.max(0, Math.min(pageIndex * pageSize, li.size())));

		ResultMng.fillResultByList(getCommonQueryBean(), getCommQueryServletRequest(), li, getResult());
		result.setContent(li);
		result.getPage().setTotalPage((total - 1) / result.getPage().getEveryPage() + 1);
		result.init();
		return result;
	}

}
