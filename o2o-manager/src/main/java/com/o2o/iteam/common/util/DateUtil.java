package com.o2o.iteam.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * User: 重庆-石恒
 * qq:  374696376
 * Date: 2016/11/24
 * Time:17:14
 * Descrption:
 */
public class DateUtil {
  public static final String FORMAT_yyyyMMdd = "yyyyMMdd";
  public static final String FORMAT_yyyy_MM_dd = "yyyy-MM-dd";
  public static final String FORMAT_yyyyMMddHHmmss = "yyyyMMddHHmmss";
  public static final String FORMAT_yyyy_MM_dd_HH_mm_ss = "yyyy-MM-dd HH:mm:ss";
  public static final String FORMAT_yyyyMMddHHmmssSSS = "yyyyMMddHHmmssSSS";
  public static final String FORMAT_yyyy_MM_dd_HH_mm_ss_SSS = "yyyy-MM-dd HH:mm:ss.SSS";
  public static final String FORMAT_HH_mm_ss_SSS = "HH:mm:ss.SSS";
  public static final String FORMAT_HHmmssSSS = "HHmmssSSS";

  public DateUtil() {
  }

  public static Date currentDate() {
    return new Date();
  }

  public static long currentTime() {
    return (new Date()).getTime();
  }

  public static String currentStr(String format) {
    SimpleDateFormat df = new SimpleDateFormat(format);
    return df.format(new Date());
  }

  public static Date strToDate(String time, String format) {
    try {
      SimpleDateFormat e = new SimpleDateFormat(format);
      Date date = e.parse(time);
      return date;
    } catch (ParseException var4) {
      var4.printStackTrace();
      return null;
    }
  }

  public static String dateToStr(Date date, String format) {
    SimpleDateFormat df = new SimpleDateFormat(format);
    return df.format(date);
  }

  public static String currentTime(long time, String format) {
    SimpleDateFormat sFormat = new SimpleDateFormat(format);
    return sFormat.format(Long.valueOf(time));
  }
}
