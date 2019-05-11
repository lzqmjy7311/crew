package com.huateng.fp.demo.getter;

/**
 *
 */


import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.huateng.commquery.process.call.BaseCallGetter;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.exception.AppException;
import com.huateng.fp.demo.bean.FieldBean;

/**
 * Title: HelloWorldHistoryGetter Description: Copyright: Copyright (c) 2008
 * Company: Shanghai Huateng Software Systems Co., Ltd.
 *
 * @author shen_antonio
 * @version 1.1, 2008-5-26
 */
public class FieldCacheGetter extends BaseCallGetter {

    @Override
	public Result call() throws AppException {
        List returnList = new ArrayList();
        int N = 2000;
        FieldBean fb = null;
        for (int i = 0 ; i < N; i ++) {
            fb = new FieldBean();
            fb.setId(""+i);
            fb.setTextString("string"+i);
            fb.setLabelString("label");
            fb.setTextInteger(i);
            fb.setTextDate(new Date());
            fb.setTextTimestamp(new Timestamp(System.currentTimeMillis()));
            returnList.add(fb);
        }

        ResultMng.fillResultByList(getCommonQueryBean(), getCommQueryServletRequest(), returnList, getResult());
        result.setContent(returnList);
        result.getPage().setTotalPage(1);
        result.init();
        return result;
    }

}
