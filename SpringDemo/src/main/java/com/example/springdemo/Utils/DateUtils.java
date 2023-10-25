/**
 * @(#)EnumUtil.java, 2015年8月28日.
 *
 * Copyright 2015 Netease, Inc. All rights reserved. NETEASE PROPRIETARY/CONFIDENTIAL. Use is
 * subject to license terms.
 */
package com.example.springdemo.Utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

/**
 * 工具类：[日期]、[字符串]、[时间]三者的转换工具类
 * <p>
 * 三者的转换是非常常用的，所以定义此工具类。三者的简要说明如下：
 * <li>[日期]：日期对象
 * <li>[字符串]：指的是日期的字符串表示
 * <li>[时间]：long型的值
 *
 * @author hzyurui
 */
public class DateUtils {
    public static final String DATETIMEFORMAT = "yyyyMMddHHmmss";
    public static final String DATEFORMAT = "yyyyMMdd";
    public static final String DATEMDFORMAT = "MMdd";
    public static final String DATEYFORMAT = "yyyy";
    public static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE_TIME_FORMAT_2 = "yyyy-MM-dd HH:mm";
    public static final String DATE_TIME_FORMAT_3 = "yyyy年MM月dd日 HH时mm分ss秒";
    public static final String TIME_FORMAT = "HH:mm:ss";
    public static final String DATE_FORMAT = "yyyy-MM-dd";
    public static final String DATE_FORMAT_POINT = "yyyy.MM.dd";
    public static final long TIME_OF_SECOND = 1000L;
    public static final long TIME_OF_MINUTE = 60000L;
    public static final long TIME_OF_HOUR = 3600000L;
    public static final long TIME_OF_DAY = 86400000L;
    private static final Logger logger = LoggerFactory.getLogger(DateUtils.class);
    private static final long CURRENR_TIME = 0;

    private DateUtils() {}

    /**
     * 将[日期]按照给定的[日期格式]转成[字符串]
     *
     * @param date
     *            日期
     * @param format
     *            日期格式
     */
    public static String parseDateToString(Date date, String format) {
        if (date == null) {
            return null;
        }
        if (StringUtils.isEmpty(format)) {
            format = DATE_TIME_FORMAT;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

    /**
     * 将[时间]按照指定的[日期格式]转成[字符串]
     *
     * @param time
     *            时间
     * @param format
     *            日期格式
     */
    public static String parseLongToString(long time, String format) {
        SimpleDateFormat mydate = new SimpleDateFormat(format);
        return mydate.format(new Date(time));
    }

    /**
     * 时间戳转换成日期（0，则返回空字符串）
     *
     * @param time
     * @param format
     * @return
     */
    public static String parseLongToString2(long time, String format) {
        if (0 == time) {
            return "";
        }
        SimpleDateFormat mydate = new SimpleDateFormat(format);
        return mydate.format(new Date(time));
    }

    /**
     * 将[字符串]按照指定的[日期格式]转成[时间]
     *
     * @param time
     *            字符串
     * @param format
     *            日期格式
     */
    public static long parseStringToLong(String time, String format) {
        SimpleDateFormat mydate = new SimpleDateFormat(format);
        try {
            Date date = mydate.parse(time);
            if (date != null) {
                return date.getTime();
            }
        } catch (ParseException e) {
            logger.error("Date parse error:", e);
        }
        return 0;
    }

    /**
     * 将[字符串]按照指定的[日期格式]转成[日期]
     *
     * @param time
     *            字符串
     * @param format
     *            日期格式
     */
    public static Date parseStringToDate(String time, String format) {
        SimpleDateFormat mydate = new SimpleDateFormat(format);
        try {
            Date date = mydate.parse(time);
            if (date != null) {
                return date;
            }
        } catch (ParseException e) {
            logger.error("Date parse error:", e);
        }
        return null;
    }

    /**
     * 添加天数
     *
     * @param date
     *            日期
     * @param amount
     *            增加天数
     */
    public static Date addDay(Date date, int amount) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        calendar.add(Calendar.DAY_OF_MONTH, amount);

        return calendar.getTime();
    }

    /**
     * 获取某天的开始时间
     *
     * @param date
     *            日期
     */
    public static Date getStartTime(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }

    /**
     * 获取某天零点的时间戳 xxxx-xx-xx 00:00:00:000
     *
     * @param date
     *            日期
     */
    public static long getStartTimeInMillis(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTimeInMillis();
    }

    public static long getStartTimeInMillis(long time) {
        return getStartTimeInMillis(new Date(time));
    }

    public static long getEndTimeInMillis(long time) {
        return getEndTimeInMillis(new Date(time));
    }

    /**
     * 获取某天的结束时间
     *
     * @param date
     *            日期
     */
    public static Date getEndTime(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        return calendar.getTime();
    }

    /**
     * 获取某天的结束时间
     *
     * @param date
     *            日期
     */
    public static long getEndTimeInMillis(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTimeInMillis();
    }

    /**
     * 获取某天的结束时间前一秒
     * <p>
     * 预留到最后一秒
     *
     * @param date
     *            日期
     */
    public static Date getEndTimeWithLastSecond(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    /**
     * 获取某天的结束时间前N秒
     * <p>
     * 预留到最后N秒
     *
     * @param date
     *            日期
     */
    public static Date getEndTimeWithLastSecond(Date date, int second) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 60 - second);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    /**
     * 获取当前时间在一天中的分钟数
     */
    public static int getCurrentMinutesOfDay(Calendar c) {
        /**
         * 获取当前小时数
         */
        int hour = c.get(Calendar.HOUR_OF_DAY);
        /**
         * 获取当前小时的分钟数
         */
        int minute = c.get(Calendar.MINUTE);
        return hour * 60 + minute;

    }

    /**
     * 获取某天开始的时间戳
     *
     * @param month
     *            0-11
     */
    public static long getStartTimeOfDayInMillis(int year, int month, int date) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTimeInMillis();
    }

    /**
     * 获取某天结束的时间戳
     *
     * @param month
     *            0-11
     */
    public static long getEndTimeOfDayInMillis(int year, int month, int date) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, date);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        return calendar.getTimeInMillis();
    }

    /**
     * 获取某月开始的时间戳
     *
     * @param month
     *            0-11
     */
    public static long getStartTimeOfMonthInMillis(int year, int month) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTimeInMillis();
    }

    /**
     * 获取某月结束的时间戳
     *
     * @param month
     *            0-11
     */
    public static long getEndTimeOfMonthInMillis(int year, int month) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        return calendar.getTimeInMillis();
    }

    /**
     * 获取指定个月后的时间戳
     */
    public static long getMonthsDelayTime(long currentTime, int months) {
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(currentTime);
        c.add(Calendar.MONTH, months);
        return c.getTimeInMillis();
    }

    /**
     * 获取指定个天后的时间戳
     */
    public static long getDaysDelayTime(long currentTime, int days) {
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(currentTime);
        c.add(Calendar.DAY_OF_YEAR, days);
        return c.getTimeInMillis();
    }

    /**
     * 获取指定分钟后的时间戳
     */
    public static long getHoursDelayTime(long currentTime, int mins) {
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(currentTime);
        c.add(Calendar.HOUR_OF_DAY, mins);
        return c.getTimeInMillis();
    }

    /**
     * 获取指定分钟后的时间戳
     */
    public static long getMinutesDelayTime(long currentTime, int mins) {
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(currentTime);
        c.add(Calendar.MINUTE, mins);
        return c.getTimeInMillis();
    }

    /**
     * 获取指定时间的星期一
     */
    public static long getStartTimeOfWeek(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTimeInMillis();
    }

    /**
     * 获取指定时间剩余毫秒数
     */
    public static long getLeftTimeMilesForDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTimeInMillis() - date.getTime();
    }

    /**
     * 获取指定时间+mins分钟后的整分时间
     */
    public static long getStartTimeOfMinitue(long currentTime, int mins) {
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(currentTime);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        c.add(Calendar.MINUTE, mins);
        return c.getTimeInMillis();
    }

    /**
     * 获取指定时间的周一
     *
     * @param currentTime
     *            时间戳
     */
    public static String getWeekFirstDay(long currentTime) {
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(currentTime);
        c.setFirstDayOfWeek(Calendar.MONDAY);
        c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek());
        return parseDateToString(c.getTime(), DATEFORMAT);
    }

    /**
     * 获取当前周在第几天
     *
     * @param currentTime
     *            时间戳
     */
    public static int dayForWeek(long currentTime) {
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(currentTime);
        int dayForWeek;
        if (c.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
            dayForWeek = 7;
        } else {
            dayForWeek = c.get(Calendar.DAY_OF_WEEK) - 1;
        }
        return dayForWeek;
    }

    /**
     * 获取当前的小时数
     *
     * @param currentTime
     *            时间戳
     */
    public static int getHour(long currentTime) {
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(currentTime);
        return c.get(Calendar.HOUR_OF_DAY);
    }

    /**
     * 获取当前的时间
     */
    public static long getCurrentTime() {
        if (CURRENR_TIME > 0) {
            return CURRENR_TIME;
        } else {
            return System.currentTimeMillis();
        }
    }

    /**
     * 设置当前的时间
     *
     * @param currentTime
     *            当前时间
     */
    public static void setCurrentTime(long currentTime) {
        /**
         * noting to do
         */
    }

    /**
     * 获取今天特定时间的时间戳
     * 
     * @param timeStr
     * @return
     */
    public static Long getToDaySpecificTime(String timeStr) {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
        String dateStr = sdf.format(new Date());
        String fullStr = dateStr + " " + timeStr;
        return parseStringToLong(fullStr, DATE_TIME_FORMAT);
    }

    /**
     * 获取今天的日期字符串
     * 
     * @return
     */
    public static String getToDayStr() {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
        return sdf.format(new Date());
    }

    /**
     * 获取明天特定时间的时间戳
     * 
     * @param timeStr
     * @return
     */
    public static Long getTomorrowSpecificTime(String timeStr) {
        return getToDaySpecificTime(timeStr) + TIME_OF_DAY;
    }

    /**
     * 获取指定时间的上一周/月的字符串日期
     * @param time 指定时间
     * @param calendarType 周 月 (Calendar.Month)
     * @param num 几周 月
     * @return 几周或月后的时间戳
     */
    public static String getXTimeAfter(Long time, int calendarType, int num) {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date(time));
        c.add(calendarType, num);
        return parseLongToString(c.getTimeInMillis(), DATE_FORMAT);
    }

    /**
     * 获取指定时间的上一周/月的时间戳
     * @param time 指定时间
     * @param type 周 月 (Calendar.Month)
     * @param num 几周 月
     * @return 几周或月后的时间戳
     */
    public static Long getXTimeMillisAfter(Long time, int type, int num) {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date(time));
        c.add(type, num);
        return c.getTimeInMillis();
    }

    /**
     * 获取指定时间在x月后的最后一天
     *
     * @param time 时间
     * @param num x
     * @return
     */
    public static String getLastDateInMonth(Long time, int num) {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date(time));
        c.add(Calendar.MONTH, num);
        c.set(Calendar.DATE, c.getActualMaximum(Calendar.DATE));
        return parseLongToString(c.getTimeInMillis(), DATE_FORMAT);
    }
}
