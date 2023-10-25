package com.example.springdemo.Utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.TimeZone;

public class DateUtil {
    /**
     * 时间戳转换成日期格式字符串
     * @param seconds 时间戳
     * @param format 格式
     * @return 日期格式字符串
     */
    public static String timeStamp2Date(Long seconds,String format) {
        if(seconds == null){
            return "";
        }
        if(format == null || format.isEmpty()){
            format = "yyyy-MM-dd HH:mm:ss";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        sdf.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
        return sdf.format(new Date(seconds));
    }
    /**
     * 日期格式字符串转换成时间戳
     * @param date_str 字符串日期
     * @param format 如：yyyy-MM-dd HH:mm:ss
     * @return 时间戳
     */
    public static Long date2TimeStamp(String date_str, String format) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.parse(date_str).getTime();
    }

    public static ZoneId getZone() {
        return ZoneId.of("GMT+8:00");
    }

    public static ZoneOffset getZoneOffset() {
        return getZone().getRules().getOffset(LocalDateTime.now());
    }

    public static long getTodayStartTime() {
        return LocalDate.now().atStartOfDay().toInstant(getZoneOffset()).toEpochMilli();
    }

    public static long getTodayEndTime() {
        return LocalDate.now().atStartOfDay().plusDays(1).minusNanos(1).toInstant(getZoneOffset()).toEpochMilli();
    }

    public static long getTimeByMonth(int month) {
        return  LocalDateTime.now().plusMonths(month).toInstant(getZoneOffset()).toEpochMilli();
    }

    public static String TimeStamp2IOS8601(Long timeStamp) {
        TimeZone tz = TimeZone.getTimeZone("GMT+8:00");
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
        df.setTimeZone(tz);
        return df.format(new Date(timeStamp));
    }

    public static void main(String[] args) {
    }
}