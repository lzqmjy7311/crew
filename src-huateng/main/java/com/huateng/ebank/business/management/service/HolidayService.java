package com.huateng.ebank.business.management.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.huateng.ebank.business.common.DAOUtils;
import com.huateng.ebank.business.common.ErrorCode;
import com.huateng.ebank.business.common.PageQueryCondition;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.entity.dao.mng.HolidayDAO;
import com.huateng.ebank.entity.data.mng.Holiday;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.orm.HQLDAO;
import com.huateng.ebank.framework.util.ApplicationContextUtils;
import com.huateng.ebank.framework.util.ExceptionUtil;

/**
 * Holiday service
 * @author shen_antonio
 *
 */
public class HolidayService {
	private static final Logger logger = Logger.getLogger(HolidayService.class);

	/**
	 * get instance.
	 *
	 * @return
	 */
	public synchronized static HolidayService getInstance() {
		return (HolidayService)ApplicationContextUtils.getBean(HolidayService.class.getName());
	}

	/**
	 * Query Holiday List
	 * for get holidy year , sum work days , sum holiday days
	 * @param pageSize
	 * @param pageIndex
	 * @return
	 * @throws CommonException
	 */
	public PageQueryResult queryHolidayList(Integer pageSize , Integer pageIndex)throws CommonException{
		HQLDAO hqlDAO = DAOUtils.getHQLDAO();
		PageQueryCondition pageQueryCondition = new PageQueryCondition();
		pageQueryCondition.setPageIndex(pageIndex.intValue());
		pageQueryCondition.setPageSize(pageSize.intValue());
		pageQueryCondition.setQueryString("from Holiday po where 1=1 order by po.year");
		PageQueryResult pageQueryResult = hqlDAO.pageQueryByQL(pageQueryCondition);
		List resultList = pageQueryResult.getQueryResult();
		List targetList = new ArrayList();
		Iterator resultListIt = resultList.iterator();
		while(resultListIt.hasNext()){
			Holiday holiday = (Holiday)(((Object[])resultListIt.next())[0]);
			String holidayDef = holiday.getHolidayDef();
			int workDay = 0;
			int holidayDay = 0;
			Map map = new HashMap();
			map.put("year", holiday.getYear());
			char[] holidayDefCharAry = holidayDef.toCharArray();
			for(int i=0;i<holidayDefCharAry.length;i++){
				if(holidayDefCharAry[i]=='1'){
					workDay++;
				}else{
					holidayDay++;
				}
			}
			map.put("sunWorkDay", new Integer(workDay));
			map.put("sunHoliDay", new Integer(holidayDay));
			map.put("holidayDef", holidayDef);
			targetList.add(map);
		}
		pageQueryResult.setQueryResult(targetList);
		return pageQueryResult;
	}

	/**
	 * Query Holiday Info
	 * @param year
	 * @return
	 * @throws CommonException
	 */
	public Map queryHolidayDetail(String year)throws CommonException{
		HolidayDAO holidayDAO = DAOUtils.getHolidayDAO();
		List list = holidayDAO.findByYear(Integer.parseInt(year));
		if(list.size()!=1){
			ExceptionUtil.throwCommonException("节假日信息错误", ErrorCode.ERROR_CODE_NORMAL);
		}
		Holiday holiday = (Holiday)list.get(0);
		String holidayDef = holiday.getHolidayDef();
		int workDay = 0;
		int holidayDay = 0;
		Map map = new HashMap();
		map.put("year", holiday.getYear());
		char[] holidayDefCharAry = holidayDef.toCharArray();
		for(int i=0;i<holidayDefCharAry.length;i++){
			if(holidayDefCharAry[i]=='1'){
				workDay++;
			}else{
				holidayDay++;
			}
		}
		map.put("sunWorkDay", new Integer(workDay));
		map.put("sunHoliDay", new Integer(holidayDay));
		map.put("holidayDef", holidayDef);
		return map;
	}

	/**
	 * update holiday info
	 * @param year
	 * @param holidayDef
	 * @throws CommonException
	 */
	public void updateHoliday(String year,String holidayDef)throws CommonException{
		HolidayDAO holidayDAO = DAOUtils.getHolidayDAO();
		List list = holidayDAO.findByYear(Integer.parseInt(year));
		if(list.size()!=1){
			ExceptionUtil.throwCommonException("节假日信息错误", ErrorCode.ERROR_CODE_NORMAL);
		}
		Holiday holiday = (Holiday)list.get(0);
		holiday.setHolidayDef(holidayDef);
		holidayDAO.save(holiday);
//del by zhaozhiguo 
//		InterestService interestService = InterestService.getInstance();
//		interestService.refresh();
	}

	/**
	 * add holiday info
	 * @param year
	 * @param holidayDef
	 * @throws CommonException
	 */
	public void addHoliday(String year,String holidayDef)throws CommonException{
		HolidayDAO holidayDAO = DAOUtils.getHolidayDAO();
		List list = holidayDAO.findByYear(Integer.parseInt(year));
		if(list.size()!=0){
			ExceptionUtil.throwCommonException("该年节假日信息已录入，不能重复录入", ErrorCode.ERROR_CODE_NORMAL);
		}else{
			Holiday holiday = new Holiday();
			holiday.setYear(Integer.parseInt(year));
			holiday.setHolidayDef(holidayDef);
			holidayDAO.save(holiday);
//del by zhaozhiguo 
//			InterestService interestService = InterestService.getInstance();
//			interestService.refresh();
		}
	}

	/**
	 * Get total weekend holidays of a year
	 * @author HuangWeijing
	 * @param year
	 * @return
	 */
	public String getWeekendInfo(int year){
		//Judge Wether a year is a leap year...
		boolean isLeapYear = ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0);
		int totalDayCnt = isLeapYear? 366 : 365;

		//Set Calendar to the first date of one year
		Calendar iteratorDate = Calendar.getInstance();
		iteratorDate.set(Calendar.YEAR, year);
		iteratorDate.set(Calendar.MONTH, Calendar.JANUARY);
		iteratorDate.set(Calendar.DAY_OF_MONTH, 1);

		String weekendInfoString = "";
		for(int i=1; i<= totalDayCnt; i++)
		{
			//Set holiday if the day is sunday or saturday
			weekendInfoString += (iteratorDate.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY ||
					iteratorDate.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) ? "0"	: "1";
			iteratorDate.add(Calendar.DAY_OF_MONTH, 1);
		}
		return weekendInfoString;
	}
}
