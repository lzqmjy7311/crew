package com.huateng.fp.demo.getter;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletRequest;

import org.apache.commons.lang.StringUtils;

import com.huateng.commquery.config.bean.base.ICommonQueryBaseBean;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;
import com.huateng.exception.HuatengException;

@SuppressWarnings("unchecked")
public class CQDemoGetter extends BaseGetter {
	public static String getBrhName(ICommonQueryBaseBean element, String value, ServletRequest request) throws HuatengException {
		if (StringUtils.isEmpty(value)) {
			return "";
		}
		String ss = "";
		int i = 0;
		for (String s : value.split(",")) {
			if (i > 0) {
				ss += ",";
			}
			i++;
			ss += "华腾银行" + s;
		}
		return ss;

	}

	public static class Foo {
		String brcode;
		String brname;
		String brcodeTypeName;

		public Foo() {
		}

		public Foo(String brcode, String brname, String brcodeTypeName) {
			this.brcode = brcode;
			this.brname = brname;
			this.brcodeTypeName = brcodeTypeName;
		}

		public Foo(int brcode, String brname, String brcodeTypeName) {
			this(String.valueOf(brcode), brname, brcodeTypeName);
		}

		public String getBrcode() {
			return brcode;
		}

		public void setBrcode(String brcode) {
			this.brcode = brcode;
		}

		public String getBrname() {
			return brname;
		}

		public void setBrname(String brname) {
			this.brname = brname;
		}

		public String getBrcodeTypeName() {
			return brcodeTypeName;
		}

		public void setBrcodeTypeName(String brcodeTypeName) {
			this.brcodeTypeName = brcodeTypeName;
		}
	}

	@Override
	public Result call() throws AppException {
		String id = this.getCommQueryServletRequest().getParameter("id");
		List<Foo> list = new ArrayList<Foo>();
		if ("true".equals(id)) {
			for (int i = 0; i < 30; i++) {
				list.add(new Foo(i, "华腾银行" + i, i == 0 ? "总行" : "分行"));
			}
		} else {
			for (int i = 0; i < 30; i++) {
				list.add(new Foo(i, "华腾银行" + i, i == 0 ? "总行" : "分行"));
			}
		}
		ResultMng.fillResultByList(getCommonQueryBean(), getCommQueryServletRequest(), list, getResult());
		result.setContent(list);
		result.getPage().setTotalPage(1);
		result.init();
		return result;
	}
}
