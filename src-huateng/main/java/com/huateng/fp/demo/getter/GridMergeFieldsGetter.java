package com.huateng.fp.demo.getter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.math.RandomUtils;

import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;
import com.huateng.fp.demo.bean.GridFields;

public class GridMergeFieldsGetter extends BaseGetter {

	@Override
	public Result call() throws AppException {
		List<GridFields> li = new ArrayList<GridFields>();
		for (int i = 0; i < 50; i++) {
			GridFields foo = this.generateRandomBean(i);
			foo.setCol1(i+1);
			li.add(foo);
		}
		int total = li.size();

		// 分页大小
		int pageSize = getResult().getPage().getEveryPage();
		// 页码
		int pageIndex = getResult().getPage().getCurrentPage();

		li = li.subList(Math.max(0, Math.min((pageIndex - 1) * pageSize, total - 1)),
				Math.max(0, Math.min(pageIndex * pageSize, li.size())));

		ResultMng.fillResultByList(getCommonQueryBean(), getCommQueryServletRequest(), li,
				getResult());
		result.setContent(li);
		result.getPage().setTotalPage((total - 1) / result.getPage().getEveryPage() + 1);
		result.init();
		return result;
	}
	int temp = 1;
	private GridFields generateRandomBean(int i) {
		GridFields foo = new GridFields();
		if((i+1)<=i*RandomUtils.nextInt()){
			foo.setCol2("合并值-"+temp);
		}else{
			temp+=1;
			foo.setCol2(RandomStringUtils.randomAlphabetic(8).replaceAll("(\\w)", "$1 "));
		}
		foo.setCol3(RandomUtils.nextDouble()*1000d);
		foo.setCol4(RandomUtils.nextFloat()*1000f);
		foo.setCol5(RandomStringUtils.randomAlphabetic(8));
		foo.setCol6(RandomStringUtils.randomAlphabetic(8));
		foo.setCol7(RandomStringUtils.randomAlphabetic(8));
		foo.setCol8(new Date());
		foo.setCol9(RandomStringUtils.randomAlphabetic(8));
        foo.setCol10(RandomUtils.nextInt(100));
		return foo;
	}

}
