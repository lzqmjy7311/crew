package com.huateng.fp.demo.getter;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;
import com.huateng.fp.demo.bean.GroupFields;

public class GroupFieldsGetter extends BaseGetter {

	@Override
	public Result call() throws AppException {
		List<GroupFields> returnList = new ArrayList<GroupFields>();
		returnList.add(this.generateBean());
		
        int total = returnList.size();

        //分页大小
        int pageSize = getResult().getPage().getEveryPage();
        //页码
        int pageIndex = getResult().getPage().getCurrentPage();
        
        returnList = returnList.subList(Math.max(0,Math.min((pageIndex-1)*pageSize, total-1)), Math.max(0,Math.min(pageIndex*pageSize, returnList.size())));
        
        ResultMng.fillResultByList(getCommonQueryBean(), getCommQueryServletRequest(), returnList, getResult());
        result.setContent(returnList);
        result.getPage().setTotalPage((total - 1) / result.getPage().getEveryPage() + 1);
        result.init();
        return result;
	}

	private GroupFields generateBean() {
		GroupFields foo = new GroupFields();
		foo.setText("这是一段文本");
		foo.setTextInput("文本输入框");
		foo.setIntegerText(1234);
		foo.setDoubleText(3.1415d);
		foo.setCurrencyText(1234.56d);
		foo.setTextArea("");
		foo.setRadio("yes");
		foo.setCheck("1");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			foo.setDateSelect(sdf.parse("2010-10-01 17:15:45"));
			foo.setYyyymmSelect("201107");
			foo.setPreDateSelect(sdf.parse("2012-11-11 00:00:00"));
			foo.setPostDateSelect(sdf.parse("2012-11-11 00:00:00"));
			foo.setDateStringSelect("2010-09-01");
			foo.setTimestamp(Timestamp.valueOf("2012-11-07 15:34:00"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		foo.setStaticCombobox("male");
		
		
		Map<String, String> leftMap = new HashMap<String, String>(){
			{
				put("01", "ASP");
				put("02", "JAVA");
				put("03", "NET");
				put("04", "JSP");
				put("05", "C++");
			}
		};
		StringBuffer leftBuf = new StringBuffer();
		for(Entry<String, String> entry:leftMap.entrySet()){
			leftBuf.append(entry.getKey()).append("=").append(entry.getValue()).append(";");
		}
		foo.setLeft(leftBuf.toString());
		
		
		Map<String, String> rightMap = new HashMap<String, String>(){
			{
				put("06", "XML");
				put("07", "FTL");
			}
		};
		StringBuffer rigthBuf = new StringBuffer();
		for(Entry<String, String> entry:rightMap.entrySet()){
			rigthBuf.append(entry.getKey()).append("=").append(entry.getValue()).append(";");
		}
		foo.setRight(rigthBuf.toString());
		
		return foo;
	}

}
