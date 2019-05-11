package com.gbicc.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {
	public static String format(Date date) {
		SimpleDateFormat DF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return date == null ? null : DF.format(date);
	}

	public static Date parse(String date) throws ParseException {
		SimpleDateFormat DF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return date == null ? null : DF.parse(date);
	}

	public static String formatDate(Date date) {
		SimpleDateFormat DATE_DF = new SimpleDateFormat("yyyy-MM-dd");
		return date == null ? null : DATE_DF.format(date);
	}

	public static Date parseDate(String date) throws ParseException {
		SimpleDateFormat DATE_DF = new SimpleDateFormat("yyyy-MM-dd");
		return date == null ? null : DATE_DF.parse(date);
	}

	public static String formatYmdDate(Date date) {
		SimpleDateFormat YMD_DF = new SimpleDateFormat("yyyyMMdd");
		return date == null ? null : YMD_DF.format(date);
	}

	public static Date parseYmdDate(String date) throws ParseException {
		SimpleDateFormat YMD_DF = new SimpleDateFormat("yyyyMMdd");
		return date == null ? null : YMD_DF.parse(date);
	}

	public static String formatDateWithMMdd(Date date) {
		SimpleDateFormat MD_DF = new SimpleDateFormat("MM-dd");
		return MD_DF.format(date);
	}

	/**
	 * 
	 * 监控周期单位为月，不足整月的采用小数表示，表示规则如下： 1 :1个月 2 :2个月 0.5 :半个月（两周） 0.25 :一周 0.75 :三周
	 * 2.5 :两个半月（两个月多两周）
	 */
	public static Date addMonth(Date s, double mon) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(s);
		int m = new Double(mon).intValue();
		calendar.add(Calendar.MONTH, m);
		/*
		 * 以下代码在理论上是没有问题的，但在 JDK 6 环境下会出现 bug,bug 重现代码如下： SimpleDateFormat df
		 * =new SimpleDateFormat("yyyy-MM-dd");
		 * System.out.println(df.format(A.addMonth
		 * (df.parse("2017-04-29"),12.0))); //输出：2018-04-28
		 * System.out.println(df.format(A.addMonth(df.parse("2017-04-29"),12)));
		 * //输出：2017-04-29 while(mon>=1){ calendar.add(Calendar.MONTH, 1);
		 * mon--; }
		 */
		calendar.add(Calendar.WEEK_OF_MONTH, getWeekOfMonth(mon - m));
		return calendar.getTime();
	}

	private static int getWeekOfMonth(double month) {
		if (month <= 0) {
			return 0;
		} else if (month > 0 && month <= 0.25) {
			return 1;
		} else if (month > 0.25 && month <= 0.5) {
			return 2;
		} else if (month > 0.5 && month <= 0.75) {
			return 3;
		} else if (month > 0.75 && month <= 1) {
			return 4;
		} else {
			return 4;
		}
	}

	public static Date addMonth(Date s, int mon) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(s);
		calendar.add(Calendar.MONTH, mon);
		return calendar.getTime();
	}

	public static Date addDay(Date s, int day) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(s);
		calendar.add(Calendar.DAY_OF_YEAR, day);
		return calendar.getTime();
	}

	/**
	 * 得到某年某周的第一天
	 *
	 * @param year
	 * @param week
	 * @return
	 */
	public static Date getFirstDayOfWeek(int year, int week) {
		week = week - 1;
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, Calendar.JANUARY);
		calendar.set(Calendar.DATE, 1);

		Calendar cal = (Calendar) calendar.clone();
		cal.add(Calendar.DATE, week * 7);

		return getFirstDayOfWeek(cal.getTime());
	}

	/**
	 * 得到某年某周的最后一天
	 *
	 * @param year
	 * @param week
	 * @return
	 */
	public static Date getLastDayOfWeek(int year, int week) {
		week = week - 1;
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, Calendar.JANUARY);
		calendar.set(Calendar.DATE, 1);
		Calendar cal = (Calendar) calendar.clone();
		cal.add(Calendar.DATE, week * 7);

		return getLastDayOfWeek(cal.getTime());
	}

	/**
	 * 取得当前日期所在周的第一天
	 *
	 * @param date
	 * @return
	 */
	public static Date getFirstDayOfWeek(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setFirstDayOfWeek(Calendar.SUNDAY);
		calendar.setTime(date);
		calendar.set(Calendar.DAY_OF_WEEK, calendar.getFirstDayOfWeek()); // Sunday
		return calendar.getTime();
	}

	/**
	 * 取得当前日期所在周的最后一天
	 *
	 * @param date
	 * @return
	 */
	public static Date getLastDayOfWeek(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setFirstDayOfWeek(Calendar.SUNDAY);
		calendar.setTime(date);
		calendar.set(Calendar.DAY_OF_WEEK, calendar.getFirstDayOfWeek() + 6); // Saturday
		return calendar.getTime();
	}

	/**
	 * 取得当前日期所在周的前一周最后一天
	 *
	 * @param date
	 * @return
	 */
	public static Date getLastDayOfLastWeek(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return getLastDayOfWeek(calendar.get(Calendar.YEAR),
				calendar.get(Calendar.WEEK_OF_YEAR) - 1);
	}

	/**
	 * 返回指定日期的月的第一天
	 *
	 * @param year
	 * @param month
	 * @return
	 */
	public static Date getFirstDayOfMonth(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
				1);
		return calendar.getTime();
	}

	/**
	 * 返回指定年月的月的第一天
	 *
	 * @param year
	 * @param month
	 * @return
	 */
	public static Date getFirstDayOfMonth(Integer year, Integer month) {
		Calendar calendar = Calendar.getInstance();
		if (year == null) {
			year = calendar.get(Calendar.YEAR);
		}
		if (month == null) {
			month = calendar.get(Calendar.MONTH);
		}
		calendar.set(year, month, 1);
		return calendar.getTime();
	}

	/**
	 * 返回指定日期的月的最后一天
	 *
	 * @param year
	 * @param month
	 * @return
	 */
	public static Date getLastDayOfMonth(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
				1);
		calendar.roll(Calendar.DATE, -1);
		return calendar.getTime();
	}

	/**
	 * 返回指定年月的月的最后一天
	 *
	 * @param year
	 * @param month
	 * @return
	 */
	public static Date getLastDayOfMonth(Integer year, Integer month) {
		Calendar calendar = Calendar.getInstance();
		if (year == null) {
			year = calendar.get(Calendar.YEAR);
		}
		if (month == null) {
			month = calendar.get(Calendar.MONTH);
		}
		calendar.set(year, month - 1, 1);
		calendar.roll(Calendar.DATE, -1);
		return calendar.getTime();
	}

	/**
	 * 返回指定日期的上个月的最后一天
	 *
	 * @param year
	 * @param month
	 * @return
	 */
	public static Date getLastDayOfLastMonth(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(calendar.get(Calendar.YEAR),
				calendar.get(Calendar.MONTH) - 1, 1);
		calendar.roll(Calendar.DATE, -1);
		return calendar.getTime();
	}

	/**
	 * 返回指定日期的季的第一天
	 *
	 * @param year
	 * @param quarter
	 * @return
	 */
	public static Date getFirstDayOfQuarter(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return getFirstDayOfQuarter(calendar.get(Calendar.YEAR),
				getQuarterOfYear(date));
	}

	/**
	 * 返回指定年季的季的第一天
	 *
	 * @param year
	 * @param quarter
	 * @return
	 */
	public static Date getFirstDayOfQuarter(Integer year, Integer quarter) {
		Calendar calendar = Calendar.getInstance();
		Integer month = new Integer(0);
		if (quarter == 1) {
			month = 1 - 1;
		} else if (quarter == 2) {
			month = 4 - 1;
		} else if (quarter == 3) {
			month = 7 - 1;
		} else if (quarter == 4) {
			month = 10 - 1;
		} else {
			month = calendar.get(Calendar.MONTH);
		}
		return getFirstDayOfMonth(year, month);
	}

	/**
	 * 返回指定日期的季的最后一天
	 *
	 * @param year
	 * @param quarter
	 * @return
	 */
	public static Date getLastDayOfQuarter(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return getLastDayOfQuarter(calendar.get(Calendar.YEAR),
				getQuarterOfYear(date));
	}

	/**
	 * 返回指定年季的季的最后一天
	 *
	 * @param year
	 * @param quarter
	 * @return
	 */
	public static Date getLastDayOfQuarter(Integer year, Integer quarter) {
		Calendar calendar = Calendar.getInstance();
		Integer month = new Integer(0);
		if (quarter == 1) {
			month = 3 - 1;
		} else if (quarter == 2) {
			month = 6 - 1;
		} else if (quarter == 3) {
			month = 9 - 1;
		} else if (quarter == 4) {
			month = 12 - 1;
		} else {
			month = calendar.get(Calendar.MONTH);
		}
		return getLastDayOfMonth(year, month);
	}

	/**
	 * 返回指定日期的上一季的最后一天
	 *
	 * @param year
	 * @param quarter
	 * @return
	 */
	public static Date getLastDayOfLastQuarter(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return getLastDayOfLastQuarter(calendar.get(Calendar.YEAR),
				getQuarterOfYear(date));
	}

	/**
	 * 返回指定年季的上一季的最后一天
	 *
	 * @param year
	 * @param quarter
	 * @return
	 */
	public static Date getLastDayOfLastQuarter(Integer year, Integer quarter) {
		Calendar calendar = Calendar.getInstance();
		Integer month = new Integer(0);
		if (quarter == 1) {
			month = 12 - 1;
		} else if (quarter == 2) {
			month = 3 - 1;
		} else if (quarter == 3) {
			month = 6 - 1;
		} else if (quarter == 4) {
			month = 9 - 1;
		} else {
			month = calendar.get(Calendar.MONTH);
		}
		return getLastDayOfMonth(year, month);
	}

	/**
	 * 返回指定日期的季度
	 *
	 * @param date
	 * @return
	 */
	public static int getQuarterOfYear(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.MONTH) / 3 + 1;
	}

	/**
	 * 根据基准年 口径（年，半年，季，月） 期数 获取第一期最后一天
	 * 
	 * @param jzYear
	 * @param caliber
	 * @param repno
	 * @return
	 */
	public static Date getFirstDeadline(int jzYear, String caliber, int repno) {
		Date firstDeadline = new Date();

		if (caliber.equals("707")) {// 年报
			firstDeadline = getLastDayOfMonth(jzYear, 12);

		} else if (caliber.equals("708")) {// 半年报
			// 1期
			if (repno == 1) {
				firstDeadline = getLastDayOfMonth(jzYear, 6);

			} else if (repno == 2) {// 2期
				firstDeadline = getLastDayOfMonth(jzYear, 12);

			}

		} else if (caliber.equals("709")) {// 季报
			// 1期
			if (repno == 1) {
				firstDeadline = getLastDayOfMonth(jzYear, 3);

			} else if (repno == 2) {// 2期
				firstDeadline = getLastDayOfMonth(jzYear, 6);

			} else if (repno == 3) {// 3期
				firstDeadline = getLastDayOfMonth(jzYear, 9);

			} else if (repno == 4) {// 4期
				firstDeadline = getLastDayOfMonth(jzYear, 12);

			}

		} else if (caliber.equals("710")) {// 月报
			// 1期
			if (repno == 1) {
				firstDeadline = getLastDayOfMonth(jzYear, 1);

			} else if (repno == 2) {// 2期
				firstDeadline = getLastDayOfMonth(jzYear, 2);

			} else if (repno >= 3 & repno <= 12) {// 3-12期
				firstDeadline = getLastDayOfMonth(jzYear, repno);

			}

		}
		return firstDeadline;
	}

	/**
	 * 根据基准年 口径（年，半年，季，月） 期数 获取该第三期最后一天
	 * 
	 * @param jzYear
	 * @param caliber
	 * @param repno
	 * @return
	 */
	public static Date getThreeDeadline(int jzYear, String caliber, int repno) {

		Date threeDeadline = new Date();
		if (caliber.equals("707")) {// 年报

			threeDeadline = getLastDayOfMonth(jzYear - 2, 12);

		} else if (caliber.equals("708")) {// 半年报
			// 1期
			if (repno == 1) {

				threeDeadline = getLastDayOfMonth(jzYear - 1, 6);
			} else if (repno == 2) {// 2期

				threeDeadline = getLastDayOfMonth(jzYear - 1, 12);
			}

		} else if (caliber.equals("709")) {// 季报
			// 1期
			if (repno == 1) {

				threeDeadline = getLastDayOfMonth(jzYear - 1, 9);
			} else if (repno == 2) {// 2期

				threeDeadline = getLastDayOfMonth(jzYear - 1, 12);
			} else if (repno == 3) {// 3期

				threeDeadline = getLastDayOfMonth(jzYear, 3);
			} else if (repno == 4) {// 4期

				threeDeadline = getLastDayOfMonth(jzYear, 6);
			}

		} else if (caliber.equals("710")) {// 月报
			// 1期
			if (repno == 1) {

				threeDeadline = getLastDayOfMonth(jzYear - 1, 11);
			} else if (repno == 2) {// 2期

				threeDeadline = getLastDayOfMonth(jzYear - 1, 12);
			} else if (repno >= 3 & repno <= 12) {// 3-12期

				threeDeadline = getLastDayOfMonth(jzYear, repno - 2);
			}

		}
		return threeDeadline;
	}

	/**
	 * 根据基准年 口径（年，半年，季，月） 期数 获取该第二期最后一天
	 * 
	 * @param jzYear
	 * @param caliber
	 * @param repno
	 * @return
	 */
	public static Date getSecondDeadline(int jzYear, String caliber, int repno) {
		Date secondDeadline = new Date();
		if (caliber.equals("707")) {// 年报
			secondDeadline = getLastDayOfMonth(jzYear - 1, 12);

		} else if (caliber.equals("708")) {// 半年报
			// 1期
			if (repno == 1) {
				secondDeadline = getLastDayOfMonth(jzYear - 1, 12);
			} else if (repno == 2) {// 2期
				secondDeadline = getLastDayOfMonth(jzYear, 6);
			}

		} else if (caliber.equals("709")) {// 季报
			// 1期
			if (repno == 1) {
				secondDeadline = getLastDayOfMonth(jzYear - 1, 12);
			} else if (repno == 2) {// 2期
				secondDeadline = getLastDayOfMonth(jzYear, 3);
			} else if (repno == 3) {// 3期
				secondDeadline = getLastDayOfMonth(jzYear, 6);
			} else if (repno == 4) {// 4期
				secondDeadline = getLastDayOfMonth(jzYear, 9);
			}

		} else if (caliber.equals("710")) {// 月报
			// 1期
			if (repno == 1) {
				secondDeadline = getLastDayOfMonth(jzYear - 1, 12);
			} else if (repno == 2) {// 2期
				secondDeadline = getLastDayOfMonth(jzYear, 1);
			} else if (repno >= 3 & repno <= 12) {// 3-12期
				secondDeadline = getLastDayOfMonth(jzYear, repno - 1);
			}

		}
		return secondDeadline;
	}

	/**
	 *
	 * @param jzYear
	 * @param caliber
	 * @param repno
	 * @return
	 */
	public static String getCurentDeadline(String caliber, int repno) {
		Date firstDeadline = new Date();
		SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM");
		String currentDate = simple.format(new Date());
		String[] time = currentDate.split("-");
		Integer jzYear = Integer.valueOf(time[0]);
		Integer mouth = Integer.valueOf(time[1]);

		if (caliber.equals("707")) {// 年报
			firstDeadline = getLastDayOfMonth(jzYear - repno + 1, 12);

		} else if (caliber.equals("708")) {// 半年报
			// 上半年
			if (mouth <= 6) {
				if (repno == 1) {
					firstDeadline = getLastDayOfMonth(jzYear, 6);
				} else if (repno == 2) {
					firstDeadline = getLastDayOfMonth(jzYear - 1, 12);
				} else if (repno == 3) {
					firstDeadline = getLastDayOfMonth(jzYear - 1, 6);
				} else if (repno == 4) {
					firstDeadline = getLastDayOfMonth(jzYear - 2, 12);
				} else if (repno == 5) {
					firstDeadline = getLastDayOfMonth(jzYear - 2, 6);
				} else if (repno == 6) {
					firstDeadline = getLastDayOfMonth(jzYear - 3, 12);
				} else if (repno == 7) {
					firstDeadline = getLastDayOfMonth(jzYear - 3, 6);
				}

			} else {
				if (repno == 1) {
					firstDeadline = getLastDayOfMonth(jzYear, 12);
				} else if (repno == 2) {
					firstDeadline = getLastDayOfMonth(jzYear, 6);
				} else if (repno == 3) {
					firstDeadline = getLastDayOfMonth(jzYear - 1, 12);
				} else if (repno == 4) {
					firstDeadline = getLastDayOfMonth(jzYear - 1, 6);
				} else if (repno == 5) {
					firstDeadline = getLastDayOfMonth(jzYear - 2, 12);
				} else if (repno == 6) {
					firstDeadline = getLastDayOfMonth(jzYear - 2, 6);
				} else if (repno == 7) {
					firstDeadline = getLastDayOfMonth(jzYear - 3, 12);
				}

			}

		} else if (caliber.equals("709")) {// 季报
			Integer quanter = mouthInquarter(mouth);
			// 1季度
			if (quanter == 1) {
				if (repno == 1) {// 1期
					firstDeadline = getLastDayOfMonth(jzYear, 3);
				} else if (repno == 2) {// 2期
					firstDeadline = getLastDayOfMonth(jzYear - 1, 12);
				} else if (repno == 3) {// 3期
					firstDeadline = getLastDayOfMonth(jzYear - 1, 9);
				} else if (repno == 4) {// 4期
					firstDeadline = getLastDayOfMonth(jzYear - 1, 6);
				} else if (repno == 5) {// 5期
					firstDeadline = getLastDayOfMonth(jzYear - 1, 3);
				} else if (repno == 6) {// 6期
					firstDeadline = getLastDayOfMonth(jzYear - 2, 12);
				} else if (repno == 7) {// 7期
					firstDeadline = getLastDayOfMonth(jzYear - 2, 9);
				}

			} else if (quanter == 2) {// 2季度
				if (repno == 1) {// 1期
					firstDeadline = getLastDayOfMonth(jzYear, 6);
				} else if (repno == 2) {// 2期
					firstDeadline = getLastDayOfMonth(jzYear, 3);
				} else if (repno == 3) {// 3期
					firstDeadline = getLastDayOfMonth(jzYear - 1, 12);
				} else if (repno == 4) {// 4期
					firstDeadline = getLastDayOfMonth(jzYear - 1, 9);
				} else if (repno == 5) {// 5期
					firstDeadline = getLastDayOfMonth(jzYear - 1, 6);
				} else if (repno == 6) {// 6期
					firstDeadline = getLastDayOfMonth(jzYear - 1, 3);
				} else if (repno == 7) {// 7期
					firstDeadline = getLastDayOfMonth(jzYear - 2, 12);
				}

			} else if (quanter == 3) {// 3季度
				if (repno == 1) {// 1期
					firstDeadline = getLastDayOfMonth(jzYear, 9);
				} else if (repno == 2) {// 2期
					firstDeadline = getLastDayOfMonth(jzYear, 6);
				} else if (repno == 3) {// 3期
					firstDeadline = getLastDayOfMonth(jzYear, 3);
				} else if (repno == 4) {// 4期
					firstDeadline = getLastDayOfMonth(jzYear - 1, 12);
				} else if (repno == 5) {// 5期
					firstDeadline = getLastDayOfMonth(jzYear - 1, 9);
				} else if (repno == 6) {// 6期
					firstDeadline = getLastDayOfMonth(jzYear - 1, 6);
				} else if (repno == 7) {// 7期
					firstDeadline = getLastDayOfMonth(jzYear - 1, 3);
				}

			} else if (quanter == 4) {// 4季度
				if (repno == 1) {
					firstDeadline = getLastDayOfMonth(jzYear, 12);
				}

				else if (repno == 2) {// 2期
					firstDeadline = getLastDayOfMonth(jzYear, 9);
				} else if (repno == 3) {// 3期
					firstDeadline = getLastDayOfMonth(jzYear, 6);
				} else if (repno == 4) {// 4期
					firstDeadline = getLastDayOfMonth(jzYear, 3);
				} else if (repno == 5) {// 5期
					firstDeadline = getLastDayOfMonth(jzYear - 1, 12);
				} else if (repno == 6) {// 6期
					firstDeadline = getLastDayOfMonth(jzYear - 1, 9);
				} else if (repno == 7) {// 7期
					firstDeadline = getLastDayOfMonth(jzYear - 1, 6);
				}
			}

		} else if (caliber.equals("710")) {// 月报
			if ((mouth - repno) >= 0) {
				firstDeadline = getLastDayOfMonth(jzYear, mouth - repno + 1);
			} else {
				firstDeadline = getLastDayOfMonth(jzYear - 1, mouth - repno + 1
						+ 12);

			}

		}
		SimpleDateFormat simple1 = new SimpleDateFormat("yyyyMMdd");
		String firstDeadlines = simple1.format(firstDeadline);
		return firstDeadlines;
	}

	/**
	 *
	 * @param jzYear
	 * @param caliber
	 * @param repno
	 * @return
	 */
	public static String getDeadlineByStratDate(String startdate,
			String caliber, int repno) {
		Date firstDeadline = new Date();
		Integer jzYear = 0;
		Integer mouth = 0;
		if (startdate == null || "".equals(startdate)) {// 起始日期为空
			SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM");
			String currentDate = simple.format(new Date());
			String[] time = currentDate.split("-");
			jzYear = Integer.valueOf(time[0]);
			mouth = Integer.valueOf(time[1]);
		} else {
			jzYear = Integer.valueOf(startdate.substring(0, 4));
			mouth = Integer.valueOf(startdate.substring(4, 6));
		}

		if (caliber.equals("1")) {// 年报
			firstDeadline = getLastDayOfMonth(jzYear - repno + 1, 12);

		} else if (caliber.equals("2")) {// 半年报
			// 上半年
			if (mouth <= 6) {
				if (repno == 1) {
					firstDeadline = getLastDayOfMonth(jzYear, 6);
				} else if (repno == 2) {
					firstDeadline = getLastDayOfMonth(jzYear - 1, 12);
				} else if (repno == 3) {
					firstDeadline = getLastDayOfMonth(jzYear - 1, 6);
				} else if (repno == 4) {
					firstDeadline = getLastDayOfMonth(jzYear - 2, 12);
				} else if (repno == 5) {
					firstDeadline = getLastDayOfMonth(jzYear - 2, 6);
				} else if (repno == 6) {
					firstDeadline = getLastDayOfMonth(jzYear - 3, 12);
				} else if (repno == 7) {
					firstDeadline = getLastDayOfMonth(jzYear - 3, 6);
				}

			} else {
				if (repno == 1) {
					firstDeadline = getLastDayOfMonth(jzYear, 12);
				} else if (repno == 2) {
					firstDeadline = getLastDayOfMonth(jzYear, 6);
				} else if (repno == 3) {
					firstDeadline = getLastDayOfMonth(jzYear - 1, 12);
				} else if (repno == 4) {
					firstDeadline = getLastDayOfMonth(jzYear - 1, 6);
				} else if (repno == 5) {
					firstDeadline = getLastDayOfMonth(jzYear - 2, 12);
				} else if (repno == 6) {
					firstDeadline = getLastDayOfMonth(jzYear - 2, 6);
				} else if (repno == 7) {
					firstDeadline = getLastDayOfMonth(jzYear - 3, 12);
				}

			}

		} else if (caliber.equals("3")) {// 季报
			Integer quanter = mouthInquarter(mouth);
			// 1季度
			if (quanter == 1) {
				if (repno == 1) {// 1期
					firstDeadline = getLastDayOfMonth(jzYear, 3);
				} else if (repno == 2) {// 2期
					firstDeadline = getLastDayOfMonth(jzYear - 1, 12);
				} else if (repno == 3) {// 3期
					firstDeadline = getLastDayOfMonth(jzYear - 1, 9);
				} else if (repno == 4) {// 4期
					firstDeadline = getLastDayOfMonth(jzYear - 1, 6);
				} else if (repno == 5) {// 5期
					firstDeadline = getLastDayOfMonth(jzYear - 1, 3);
				} else if (repno == 6) {// 6期
					firstDeadline = getLastDayOfMonth(jzYear - 2, 12);
				} else if (repno == 7) {// 7期
					firstDeadline = getLastDayOfMonth(jzYear - 2, 9);
				} else if (repno == 8) {// 8期
					firstDeadline = getLastDayOfMonth(jzYear - 2, 6);
				} else if (repno == 9) {// 9期
					firstDeadline = getLastDayOfMonth(jzYear - 2, 3);
				} else if (repno == 10) {// 10期
					firstDeadline = getLastDayOfMonth(jzYear - 3, 12);
				} else if (repno == 11) {// 11期
					firstDeadline = getLastDayOfMonth(jzYear - 3, 9);
				} else if (repno == 12) {// 12期
					firstDeadline = getLastDayOfMonth(jzYear - 3, 6);
				}

			} else if (quanter == 2) {// 2季度
				if (repno == 1) {// 1期
					firstDeadline = getLastDayOfMonth(jzYear, 6);
				} else if (repno == 2) {// 2期
					firstDeadline = getLastDayOfMonth(jzYear, 3);
				} else if (repno == 3) {// 3期
					firstDeadline = getLastDayOfMonth(jzYear - 1, 12);
				} else if (repno == 4) {// 4期
					firstDeadline = getLastDayOfMonth(jzYear - 1, 9);
				} else if (repno == 5) {// 5期
					firstDeadline = getLastDayOfMonth(jzYear - 1, 6);
				} else if (repno == 6) {// 6期
					firstDeadline = getLastDayOfMonth(jzYear - 1, 3);
				} else if (repno == 7) {// 7期
					firstDeadline = getLastDayOfMonth(jzYear - 2, 12);
				} else if (repno == 8) {// 8期
					firstDeadline = getLastDayOfMonth(jzYear - 2, 9);
				} else if (repno == 9) {// 9期
					firstDeadline = getLastDayOfMonth(jzYear - 2, 6);
				} else if (repno == 10) {// 10期
					firstDeadline = getLastDayOfMonth(jzYear - 2, 3);
				} else if (repno == 11) {// 11期
					firstDeadline = getLastDayOfMonth(jzYear - 3, 12);
				} else if (repno == 12) {// 12期
					firstDeadline = getLastDayOfMonth(jzYear - 3, 9);
				}

			} else if (quanter == 3) {// 3季度
				if (repno == 1) {// 1期
					firstDeadline = getLastDayOfMonth(jzYear, 9);
				} else if (repno == 2) {// 2期
					firstDeadline = getLastDayOfMonth(jzYear, 6);
				} else if (repno == 3) {// 3期
					firstDeadline = getLastDayOfMonth(jzYear, 3);
				} else if (repno == 4) {// 4期
					firstDeadline = getLastDayOfMonth(jzYear - 1, 12);
				} else if (repno == 5) {// 5期
					firstDeadline = getLastDayOfMonth(jzYear - 1, 9);
				} else if (repno == 6) {// 6期
					firstDeadline = getLastDayOfMonth(jzYear - 1, 6);
				} else if (repno == 7) {// 7期
					firstDeadline = getLastDayOfMonth(jzYear - 1, 3);
				} else if (repno == 8) {// 8期
					firstDeadline = getLastDayOfMonth(jzYear - 2, 12);
				} else if (repno == 9) {// 9期
					firstDeadline = getLastDayOfMonth(jzYear - 2, 9);
				} else if (repno == 10) {// 10期
					firstDeadline = getLastDayOfMonth(jzYear - 2, 6);
				} else if (repno == 11) {// 11期
					firstDeadline = getLastDayOfMonth(jzYear - 2, 3);
				} else if (repno == 12) {// 12期
					firstDeadline = getLastDayOfMonth(jzYear - 3, 12);
				}

			} else if (quanter == 4) {// 4季度
				if (repno == 1) {
					firstDeadline = getLastDayOfMonth(jzYear, 12);
				}

				else if (repno == 2) {// 2期
					firstDeadline = getLastDayOfMonth(jzYear, 9);
				} else if (repno == 3) {// 3期
					firstDeadline = getLastDayOfMonth(jzYear, 6);
				} else if (repno == 4) {// 4期
					firstDeadline = getLastDayOfMonth(jzYear, 3);
				} else if (repno == 5) {// 5期
					firstDeadline = getLastDayOfMonth(jzYear - 1, 12);
				} else if (repno == 6) {// 6期
					firstDeadline = getLastDayOfMonth(jzYear - 1, 9);
				} else if (repno == 7) {// 7期
					firstDeadline = getLastDayOfMonth(jzYear - 1, 6);
				} else if (repno == 8) {// 8期
					firstDeadline = getLastDayOfMonth(jzYear - 1, 3);
				} else if (repno == 9) {// 9期
					firstDeadline = getLastDayOfMonth(jzYear - 2, 12);
				} else if (repno == 10) {// 10期
					firstDeadline = getLastDayOfMonth(jzYear - 2, 9);
				} else if (repno == 11) {// 11期
					firstDeadline = getLastDayOfMonth(jzYear - 2, 6);
				} else if (repno == 12) {// 12期
					firstDeadline = getLastDayOfMonth(jzYear - 2, 3);
				}
			}

		} else if (caliber.equals("4")) {// 月报
			if ((mouth - repno) >= 0) {
				firstDeadline = getLastDayOfMonth(jzYear, mouth - repno + 1);
			} else {
				firstDeadline = getLastDayOfMonth(jzYear - 1, mouth - repno + 1
						+ 12);

			}

		}
		SimpleDateFormat simple1 = new SimpleDateFormat("yyyyMMdd");
		String firstDeadlines = simple1.format(firstDeadline);
		return firstDeadlines;
	}

	/**
	 * 月份所在季度
	 * 
	 * @param mouth
	 * @return
	 */
	public static Integer mouthInquarter(int mouth) {
		int i = 0;
		if (mouth >= 1 && mouth <= 3) {
			i = 1;
		} else if (mouth >= 4 && mouth <= 6) {
			i = 2;
		} else if (mouth >= 7 && mouth <= 9) {
			i = 3;
		} else if (mouth >= 10 && mouth <= 12) {
			i = 4;
		}
		return i;
	}

	@SuppressWarnings("deprecation")
	public static Date lastDate(Date date) {
		if (date == null) {
			return null;
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int lastDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		Date day = calendar.getTime();
		day.setDate(lastDay);
		return day;
	}

	public static boolean isLastDateOfMonth(Date date) {
		SimpleDateFormat YMD_DF = new SimpleDateFormat("yyyyMMdd");
		Date _date = lastDate(date);
		if (YMD_DF.format(_date).equals(YMD_DF.format(date))) {
			return true;
		}
		return false;
	}

	/**
	 * 获取当前时间下，上一季度的数据获取时间
	 * 
	 * @param date
	 * @return
	 */
	public static String getNowDateLastQ(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int yue = calendar.get(Calendar.MONTH) + 1;
		String dateStr = calendar.get(Calendar.YEAR) + "";
		if (yue < 4) {
			dateStr = dateStr + "-01";
		} else if (yue < 7) {
			dateStr = dateStr + "-04";
		} else if (yue < 10) {
			dateStr = dateStr + "-07";
		} else {
			dateStr = dateStr + "-10";
		}
		dateStr = dateStr + "-01";
		System.out.println("getNowDateLastQ---" + dateStr);
		return dateStr;
	}

	/**
	 * 获取当前时间下，一季度的数据获取时间
	 * 
	 * @param length
	 *            //往前推几个季度
	 * @param date
	 * @return
	 */
	public static String getNowDateLastLastQ(Date date, int length) {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat YMD_DF = new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat DATE_DF = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat DF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			String lqdate = getNowDateLastQ(date);
			Date df = DATE_DF.parse(lqdate);
			calendar.setTime(df);
		} catch (ParseException e) {
			try {
				calendar.setTime(YMD_DF.parse(getNowDateLastQ(date)));
			} catch (ParseException ee) {
				try {
					calendar.setTime(DF.parse(getNowDateLastQ(date)));
				} catch (ParseException eee) {
					eee.printStackTrace();
				}
				ee.printStackTrace();
			}
			e.printStackTrace();
		}
		calendar.add(Calendar.MONTH, -3 * length);
		return DATE_DF.format(calendar.getTime());
	}

	/**
	 * 获取当前时间下，上一月的数据获取时间
	 * 
	 * @param date
	 * @return
	 */
	public static String getNowDateLastM(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int yue = calendar.get(Calendar.MONTH) + 1;
		String dateStr = calendar.get(Calendar.YEAR) + "";
		if (yue < 10) {
			dateStr = dateStr + "-0" + yue;
		} else {
			dateStr = dateStr + "-" + yue;
		}
		dateStr = dateStr + "-01";
		return dateStr;
	}

	/**
	 * 获取当前时间下，上上一月的数据获取时间
	 * 
	 * @param date
	 * @return
	 */
	public static String getNowDateLastLastM(Date date, int length) {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat DATE_DF = new SimpleDateFormat("yyyy-MM-dd");
		try {
			calendar.setTime(DATE_DF.parse(getNowDateLastM(date)));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		calendar.add(Calendar.MONTH, -1 * length);
		return DATE_DF.format(calendar.getTime());
	}

	/**
	 * 获取当前时间下，昨天数据获取时间
	 * 
	 * @param date
	 * @return
	 */
	public static String getNowDateLastD(Date date) {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat DATE_DF = new SimpleDateFormat("yyyy-MM-dd");
		calendar.setTime(date);
		calendar.add(Calendar.DATE, -1);
		return DATE_DF.format(calendar.getTime());
	}

	/**
	 * 获取年初
	 * 
	 * @param date
	 * @return
	 */
	public static String getNowDateYEARFirstDate(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.YEAR) + "-01-01";
	}

	/**
	 * 根据时间，获取季度string
	 * 
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public static String getDateYQStr(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int yue = calendar.get(Calendar.MONTH) + 1;
		String dateStr = "";
		if (yue == 1) {
			dateStr = calendar.get(Calendar.YEAR) - 1 + "年4Q";
		} else if (yue == 4) {
			dateStr = calendar.get(Calendar.YEAR) + "年1Q";
		} else if (yue == 7) {
			dateStr = calendar.get(Calendar.YEAR) + "年2Q";
		} else if (yue == 10) {
			dateStr = calendar.get(Calendar.YEAR) + "年3Q";
		}
		return dateStr;
	}

	/**
	 * 获取两个日期相隔天数
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static int dateOfDays(Date date1, Date date2) {
		Calendar calendar1 = Calendar.getInstance();
		calendar1.setTime(date1);
		int day1 = calendar1.get(Calendar.DAY_OF_YEAR);
		Calendar calendar2 = Calendar.getInstance();
		calendar2.setTime(date2);
		int day2 = calendar2.get(Calendar.DAY_OF_YEAR);
		return day2 - day1;
	}

	
	/**
     * 获取当前时间下，明天数据获取时间
     * @param date
     * @return
     */
	public static Date getNowDateTorDate(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, 1);
		return calendar.getTime();
	}
	
	public static void main(String[] args) throws Exception {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(isLastDateOfMonth(df.parse("2016-02-29")));
		System.out.println(df.format(DateUtils.addMonth(df.parse("2012-02-29"),
				4 * 12.0)));
		System.out.println(df.format(DateUtils.addMonth(df.parse("2012-02-29"),
				4 * 12)));
	}
}