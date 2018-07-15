package com.koujiang.framework.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.koujiang.framework.time.JNative;
import com.koujiang.framework.time.NativeFactory;
import com.koujiang.framework.util.validation.VNETookit;


/**
 * <br>(c) Copyright 2017 koujiang901123@sina.com
 * <br>@description	:日期助手
 * <br>@file_name	:DateHelper.java
 * <br>@author		:koujiang 
 * <br>@create_time	:2017年11月22日 下午1:57:37
 * <br>@mender		:(Please add the modifier name)
 * <br>@Modified	:(Please add modification date)
 * <br>@varsion		:v1.0.0
 */

public class DateHelper {
	
	/**
	 * yyyy格式
	 */
	public static final String YYYY = "yyyy";
	/**
	 * yyyy-mm格式
	 */
	public static final String YYYYMM = "yyyy-MM";
	/**
	 * yyyy-mm-dd格式
	 */
	public static final String YYYYMMDD = "yyyy-MM-dd";
	
	/**
	 * yyyy-MM-dd HH:mm:ss格式
	 */
	public static final String YYYYMMDDHHMMSS = "yyyy-MM-dd HH:mm:ss";
	
	/**
	 * yyyyMMddHHmmss 格式
	 */
	public static final String YYYYMMDDHHMMSSNODATE = "yyyyMMddHHmmss";
	/**
	 * yyyy-MM-dd HH:mm:ss SSS格式
	 */
	public static final String YYYYMMDDHHMMSSsss = "yyyy-MM-dd HH:mm:ss SSS";
	
	/**
	 * YYYYMMDD格式
	 */
	public static final SimpleDateFormat SDF_YYYYMMDD = new SimpleDateFormat(YYYYMMDD);
	
	/**
	 * YYYYMMDDHHMMSS格式
	 */
	public static final SimpleDateFormat SDF_YYYYMMDDHHMMSS = new SimpleDateFormat(YYYYMMDDHHMMSS);
	/**
	 * 将日期格式为指定格式的字符串。“yyyy-MM-dd HH:mm:ss:SSS”
	 * @param baseDate 日期对象型的日期数据
	 * @param strFormat 格式化字符串
	 * @return 格式化好的字符串
	 */
	public static String formatDateTime(Date baseDate,String strFormat){
		SimpleDateFormat df = new SimpleDateFormat(strFormat);
		return df.format(baseDate);
	}
	
	/**
	 * 将字符串型的日期格式化为指定格式的字符串.'yyyy-MM-dd HH:mm:ss:SSS'
	 * @param baseDate 字符串的日期数据
	 * @param strFormat 格式化字符串
	 * @return 格式化好的字符串
	 */
	public static String formatDateTime(String baseDate,String strFormat){
		SimpleDateFormat df = new SimpleDateFormat(strFormat);
		Date tmpDate = null;
		try{
			tmpDate = df.parse(baseDate);
		}catch(Exception e){
			
		}
		return df.format(tmpDate);
	}
	
	/**
	 * description formatDateTime:将指定日期字符串从一种格式转换到另一中格式的字符串
	 * <br>author ：koujiang
	 * <br>@param baseDate
	 * <br>@param strFormat1
	 * <br>@param strFormat2
	 * <br>@return 
	 * <br>return :String
	 * <br>update ：2017年12月12日 下午4:16:02
	 * <br>mender ：(Please add the modifier name)
	 * <br>Modified ：(Please add modification date)
	 * <br>varsion ：v1.0.0
	 */
	public static String formatDateTime(String baseDate,String strFormat1,String strFormat2){
		SimpleDateFormat df1 = new SimpleDateFormat(strFormat1);
		SimpleDateFormat df2 = new SimpleDateFormat(strFormat2);
		Date tmpDate = null;
		try{
			tmpDate = df1.parse(baseDate);
		}catch(Exception e){
			
		}
		return df2.format(tmpDate);
	}
	
	/**
	 * 得到以"yyyy-MM-dd HH:mm:ss"格式的日期字符串
	 * @return 得到当前时间字符串
	 */
	public static String getCurrentDateTime(){
		String str_curDate = "";
		Calendar curDate = Calendar.getInstance();
		str_curDate = DateHelper.formatDateTime(curDate.getTime(),"yyyy-MM-dd HH:mm:ss");
		return str_curDate;
	}
	
	/**
	 * getLoaclCurrentDateTime方法慨述:获取本地的当前时间
	 * <br>创 建  人：彭群飞 
	 * <br>创建时间：2014-8-30 下午04:43:26 
	 * <br>@return String
	 */
	public static String getLoaclCurrentDateTime(){
		String str_curDate = "";
		Calendar curDate = Calendar.getInstance();
		str_curDate = DateHelper.formatDateTime(curDate.getTime(),"yyyy-MM-dd HH:mm:ss");
		return str_curDate;
	}
	
	/**
	 * 得到自定义字符格式的日期字符串
	 * @param strFormat 日期格式
	 * @return 字符串的日期值
	 */
	public static String getCurrentDateTime(String strFormat){
		Calendar curDate = Calendar.getInstance();
		return DateHelper.formatDateTime(curDate.getTime(),strFormat);
	}
	
	/**
	 * 得到当前日期
	 * @return Date类型的日期值
	 */
	public static Date getDateTime(){
		Calendar curDate = Calendar.getInstance();
		return curDate.getTime();
	}
	
	/**
	 * 得到当前日期加减n天后的日期，返回为String (yyyy-MM-dd)
	 * @param n   正表后几天，负表示前几天
	 * @return    以yyyy-MM-dd 格式的字符串 日期值
	 */
	public static String nDaysAfterStringDate(int n){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Calendar curDate = Calendar.getInstance();
		curDate.add(Calendar.DAY_OF_MONTH,+n);
		return df.format(curDate.getTime());
	}
	
	/**
	 * 得到当前日期加减n天后的日期，返回为String (自己指定)
	 * @param n   正表后几天，负表示前几天
	 * @return    以自己指定 格式的字符串 日期值
	 */
	public static String nDaysAfterStringDate(int n,String format){
		SimpleDateFormat df = new SimpleDateFormat(format);
		Calendar curDate = Calendar.getInstance();
		curDate.add(Calendar.DAY_OF_MONTH,+n);
		return df.format(curDate.getTime());
	}
	
	/**
	 * 得到当前日期加减n天后的日期，返回Date
	 * @param n  正表后几天，负表示前几天
	 * @return   Date的日期值
	 */
	public static Date nDaysAfterDate(int n){
		Calendar curDate = Calendar.getInstance();
		curDate.add(Calendar.DAY_OF_MONTH,+n);
		return curDate.getTime();
	}
	
	/**
	 * 给定一个日期型字符串，返回加减n天后的日期型字符串
	 * @param baseDate  字符串型
	 * @param n   正表后几天，负表示前几天
	 * @return 字符串型的日期值
	 */
	public static String nDaysAfterOneDateString(String baseDate,int n){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date tmpDate = null;
		try{
			tmpDate = df.parse(baseDate);
		}catch(Exception e){
			
		}
		long nDay = (tmpDate.getTime() / (24 * 60 * 60 * 1000) +1 + n)*(24*60*60*1000);
		tmpDate.setTime(nDay);
		return df.format(tmpDate);
	}
	
	/**
	 * 给定一个日期，返回加减n天后的日期，返回Date
	 * @param baseDate 日期型
	 * @param n  正表后几天，负表示前几天
	 * @return Date型的日期值
	 */
	public static Date nDayAfterOneDate(Date baseDate,int n){
		long nDay = (baseDate.getTime() / (24 * 60 * 60 * 1000) + 1 +n) *(24*60*60*1000);
		baseDate.setTime(nDay);
		return baseDate;
	}

	/**
	 * 返回当前日期加减n个月后的日期，返回String(yyyy-MM-dd)
	 * @param n 正表后几月，负表示前几月
	 * @return 字符串型的日期值
	 */
	public static String nMonthAfterDateString(int n){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Calendar rightNow = Calendar.getInstance();
		rightNow.add(Calendar.MONTH,+n);
		return df.format(rightNow.getTime());
	}
	
	/**
	 * 返回当期日期加减n个月后的日期，返回Date
	 * @param n 正表后几月，负表示前几月
	 * @return Date型的日期值
	 */
	public static Date nMonthAfterDate(int n){
		Calendar rightNow = Calendar.getInstance();
		rightNow.add(Calendar.MONTH, +n);
		return rightNow.getTime();
	}
	
	/**
	 * 给定义日期加减n个月后的日期，返回Date
	 * @param basicDate
	 * @param n 正表后几月，负表示前几月
	 * @return Date型的日期值
	 */
	public static Date nMonthsAfterOneDate(Date basicDate, int n) {
		Calendar rightNow = Calendar.getInstance();
		rightNow.setTime(basicDate);
		rightNow.add(Calendar.MONTH, +n);
		return rightNow.getTime();
	}
	
	/**
	 * description nMonthsAfterOneDate:给定义日期加减n个月后的日期，返回String{(if format == null) format = yyyy-MM-dd HH:mm:ss)}
	 * <br>author ：koujiang
	 * <br>@param basicDate
	 * <br>@param format
	 * <br>@param n	(+1:在这个时间上增加一个月; -1：在这个时间上减少一个月)
	 * <br>@return 
	 * <br>return :String
	 * <br>update ：2014-8-12 下午07:34:13
	 * <br>mender ：(Please add the modifier name)
	 * <br>Modified ：(Please add modification date)
	 * <br>varsion ：v1.0.0
	 */
	public static String nMonthsAfterOneDate(String basicDate, String format, int n) {
		Calendar c = Calendar.getInstance();
		if(VNETookit.isNull(format)) 
			format = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat df = new SimpleDateFormat(format);
		Date rightNow = null;
		try {
			rightNow = df.parse(basicDate);
		} catch (ParseException e) {
		}
		c.setTime(rightNow);
		c.add(Calendar.MONTH, +n);
		return df.format(c.getTime());
	}
	
	/**
	 * description nDaysAfterOneDate:给定义日期加减n天后的日期，返回String{(if format == null) format = yyyy-MM-dd HH:mm:ss)}
	 * <br>author ：koujiang
	 * <br>@param baseDate
	 * <br>@param n
	 * <br>@return 
	 * <br>return :String
	 * <br>update ：2014-12-24 下午06:53:29
	 * <br>mender ：(Please add the modifier name)
	 * <br>Modified ：(Please add modification date)
	 * <br>varsion ：v1.0.0
	 */
	public static String nDaysAfterOneDate(String basicDate, String format, int n){
		Calendar c = Calendar.getInstance();
		if(VNETookit.isNull(format)) 
			format = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat df = new SimpleDateFormat(format);
		Date rightNow = null;
		try {
			rightNow = df.parse(basicDate);
		} catch (ParseException e) {
		}
		c.setTime(rightNow);
		c.add(Calendar.DATE, +n);
		return df.format(c.getTime());
	}
	
	/**
	 * description nHourAfterOneDate:给定义日期加减n小时后的日期，返回String{(if format == null) format = yyyy-MM-dd HH:mm:ss)}
	 * <br>author ：koujiang
	 * <br>@param basicDate
	 * <br>@param format
	 * <br>@param n
	 * <br>@return 
	 * <br>return :String
	 * <br>update ：2014-12-26 上午10:19:57
	 * <br>mender ：(Please add the modifier name)
	 * <br>Modified ：(Please add modification date)
	 * <br>varsion ：v1.0.0
	 */
	public static String nHourAfterOneDate(String basicDate, String format, int n){
		Calendar c = Calendar.getInstance();
		if(VNETookit.isNull(format)) 
			format = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat df = new SimpleDateFormat(format);
		Date rightNow = null;
		try {
			rightNow = df.parse(basicDate);
		} catch (ParseException e) {
		}
		c.setTime(rightNow);
		c.add(Calendar.HOUR, +n);
		return df.format(c.getTime());
	}
	
	/**
	 * description nMinuteAfterOneDate:给定义日期加减n分钟后的日期，返回String{(if format == null) format = yyyy-MM-dd HH:mm:ss)}
	 * <br>author ：koujiang
	 * <br>@param basicDate
	 * <br>@param format
	 * <br>@param n
	 * <br>@return 
	 * <br>return :String
	 * <br>update ：2014-12-26 上午10:16:56
	 * <br>mender ：(Please add the modifier name)
	 * <br>Modified ：(Please add modification date)
	 * <br>varsion ：v1.0.0
	 */
	public static String nMinuteAfterOneDate(String basicDate, String format, int n){
		Calendar c = Calendar.getInstance();
		if(VNETookit.isNull(format)) 
			format = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat df = new SimpleDateFormat(format);
		Date rightNow = null;
		try {
			rightNow = df.parse(basicDate);
		} catch (ParseException e) {
		}
		c.setTime(rightNow);
		c.add(Calendar.MINUTE, +n);
		return df.format(c.getTime());
	}
	
	/**
	 * description nSecondAfterOneDate:给定义日期加减n秒的日期，返回String{(if format == null) format = yyyy-MM-dd HH:mm:ss)}
	 * <br>author ：koujiang
	 * <br>@param basicDate
	 * <br>@param format
	 * <br>@param n
	 * <br>@return 
	 * <br>return :String
	 * <br>update ：2014-12-26 上午10:14:12
	 * <br>mender ：(Please add the modifier name)
	 * <br>Modified ：(Please add modification date)
	 * <br>varsion ：v1.0.0
	 */
	public static String nSecondAfterOneDate(String basicDate, String format, int n) {
		Calendar c = Calendar.getInstance();
		if(VNETookit.isNull(format))
			format = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat df = new SimpleDateFormat(format);
		Date rightNow = null;
		try {
			rightNow = df.parse(basicDate);
		} catch (ParseException e) {
		}
		c.setTime(rightNow);
		c.add(Calendar.SECOND, +n);
		return df.format(c.getTime());
	}
	
	/**
	 * 给定时间加减n分钟的时间，返回String(yyyy-MM-dd HH:mm:ss)
	 * <br>创 建  人：彭群飞 
	 * <br>创建时间：2013-4-20 上午09:33:59 
	 * <br>修 改  人：(修改了该文件，请填上修改人的名字) 
	 * <br>修改日期：(请填上修改该文件时的日期) 
	 * <br>@param basicDate yyyy-MM-dd 
	 * <br>@param n 分钟数，（+）表示向后多少分钟，（-）表示向前多少分钟
	 * <br>@return String
	 * @throws Exception 
	 */
	public static String nMinuteAfter(String basicTime,int n) throws Exception{
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String str_return = "";
		try {
			Date tmpDate = df.parse(basicTime);
			long ll_time =(tmpDate.getTime()/1000/60 + n)*1000*60;
			str_return = df.format(new Date(ll_time)); 
		} catch (ParseException e) {
			throw new Exception("日期格式不正确！");
		}
		return str_return;
	}
	
	/**
	 * 给定义日期加减n个月后的日期，返回String(yyyy-MM-dd)
	 * @param basicDate
	 * @param n 正表后几月，负表示前几月
	 * @return 字符串的日期值
	 */
	public static String nMonthsAfterOneDateString(Date basicDate, int n) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Calendar rightNow = Calendar.getInstance();
		rightNow.setTime(basicDate);
		rightNow.add(Calendar.MONTH, +n);
		return df.format(rightNow.getTime());
	}
	
	/**
	 * 计算两个日期间隔天数（secondDate - firstDate）
	 * @param firstDate 为Date型
	 * @param secondDate  为Date型
	 * @return 间隔天数
	 */
	public static int nDaysBetweenTwoDate(Date firstDate, Date secondDate) {
		int nDay =(int) ((secondDate.getTime() - firstDate.getTime()) / (24 * 60 * 60 * 1000));
		return nDay;
	}
	
	/**
	 * 计算两个日期间隔天数（secondDate - firstDate）
	 * @param firstDate 为String型
	 * @param secondDate  为String型
	 * @return 间隔天数
	 */
	public static int nDaysBetweenTwoDate(String firstString, String secondString) throws Exception {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date firstDate = null;
		Date secondDate = null;
		
		try {
			firstDate = df.parse(firstString);
			secondDate = df.parse(secondString);
		} catch (Exception e) {
			throw new Exception("日期格式不正确！");
		}
		int nDay =(int) ((secondDate.getTime() - firstDate.getTime()) / (24 * 60 * 60 * 1000));
		return nDay;
	}
	
	/**
	 * description nDaysBetweenTwoDate:计算两个日期间隔天数（secondDate - firstDate）
	 * <br>author ：koujiang
	 * <br>@param first
	 * <br>@param second
	 * <br>@param format
	 * <br>@return
	 * <br>@throws Exception 
	 * <br>return :int
	 * <br>update ：2015-7-3 上午11:39:54
	 * <br>mender ：(Please add the modifier name)
	 * <br>Modified ：(Please add modification date)
	 * <br>varsion ：v1.0.0
	 */
	public static int nDaysBetweenTwoDate(String first, String second, String format) throws Exception {
		SimpleDateFormat df = new SimpleDateFormat(format);
		Date firstDate = null;
		Date secondDate = null;
		
		try {
			firstDate = df.parse(first);
			secondDate = df.parse(second);
		} catch (Exception e) {
			throw new Exception("日期格式不正确！");
		}
		int nDay =(int) ((secondDate.getTime() - firstDate.getTime()) / (24 * 60 * 60 * 1000));
		return nDay;
	}
	
	/**
	 * 得到指定日期是星期几
	 * @param baseDate 字串型的日期格式
	 * @return 星期几
	 */
	public static int getWeekDateString(String baseDate){
		Calendar c = Calendar.getInstance();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date rightNow = null;
		try {
			rightNow = df.parse(baseDate);
		} catch (ParseException e) {
		}
		c.setTime(rightNow);
		return c.get(Calendar.DAY_OF_WEEK) -1;
	}
	
	public static String getWeekDateString() {
		Date date=new Date();
		SimpleDateFormat dateFm = new SimpleDateFormat("EEEE");
		return dateFm.format(date);
	}
	
	/**
	 * 得到指定日期是星期几
	 * @param baseDate 日期型日期格式
	 * @return 星期几
	 */
	public static int getWeekDate(Date baseDate){
		Calendar c = Calendar.getInstance();
		c.setTime(baseDate);
		return c.get(Calendar.DAY_OF_WEEK) -1;
	}
	
	/**
	 * setLocalDate方法慨述:修改本地时间
	 * @param dateTime 字符型的时间格式 yyyy-MM-dd HH:mm:ss
	 */
	public static void setLocalDate(Date newDate) throws Exception{
		String dateTime = DateHelper.formatDateTime(newDate, "yyyy-MM-dd HH:mm:ss");
		//判断传入的日期格式是否正确
		if(dateTime.length() != 19){
			throw new Exception("日期格式不正确!");
		}
		String osName = System.getProperty("os.name");   
		String cmd = "";   
		//如果系统为Windows
		if (osName.matches("^(?i)Windows.*$")){
			// 格式：yyyy-MM-dd  
			String date = dateTime.substring(0, 10); 
		    cmd = " cmd /c date "+date;   
		    Runtime.getRuntime().exec(cmd);  
		    // 格式 HH:mm:ss   
		    String time = dateTime.substring(11);
		    cmd = "  cmd /c time "+time;   
		    Runtime.getRuntime().exec(cmd);  
		}else{ // Linux 系统   
			dateTime = DateHelper.formatDateTime(dateTime, "yyyyMMdd HH:mm:ss");
			// 格式：yyyyMMdd
			String year = dateTime.substring(0,4);
			String month = dateTime.substring(5,7);
			String day = dateTime.substring(8,10);
			String date = year+month+day;
			cmd = "  date -s "+date;   
			Runtime.getRuntime().exec(cmd);   
			// 格式 HH:mm:ss
			String time = dateTime.substring(9);
			cmd = "  date -s "+time;
			Runtime.getRuntime().exec(cmd); 
		}
	}
	
	/**
	 * setLocalDate方法慨述:调用kernerl32.dll文件设置系统时间
	 * @param dateTime 字符串日期值
	 */
	public static void setLocalDate(String dateTime) throws Exception{
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date tmpDate = null;
		try{
			tmpDate = df.parse(dateTime);
			JNative jNative = NativeFactory.newNative();
			jNative.setLocalTime(tmpDate);
		}catch(Exception e){
			throw e;
		}
	}
	
	/**
	 * getMonthOfTheFirstDay方法慨述: 得到当前月的第一天
	 * @return String 当前月第一天 
	 */
	public static String getMonthOfTheFirstDay(){
		Calendar calendar = Calendar.getInstance();   
		calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));   
		java.text.SimpleDateFormat df = new java.text.SimpleDateFormat("yyyy-MM-dd");
	    return df.format(calendar.getTime());  
	}
	
	/**
	 * getMonthOfTheFirstDay方法慨述: 得到当前月的第一天
	 * @param format 时间格式
	 * @return String  时间
	 */
	public static String getMonthOfTheFirstDay(String format){
		Calendar calendar = Calendar.getInstance();   
		calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));   
		java.text.SimpleDateFormat df = new java.text.SimpleDateFormat(format);
	    return df.format(calendar.getTime());
	}
	
	/**
	 * getMonthOfTheLastDay方法慨述: 得到当前月最后一天
	 * @return String 当前月最后一天
	 */
	public static String getMonthOfTheLastDay(){
		Calendar calendar = Calendar.getInstance();   
		calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));   
		java.text.SimpleDateFormat df = new java.text.SimpleDateFormat("yyyy-MM-dd");
	    return df.format(calendar.getTime()); 
	}
	
	/**
	 * getMonthOfTheFirstDay方法慨述: 得到当前月最后一天
	 * @param format 时间格式
	 * @return String  时间
	 */
	public static String getMonthOfTheLastDay(String format){
		Calendar calendar = Calendar.getInstance();   
		calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));   
		java.text.SimpleDateFormat df = new java.text.SimpleDateFormat(format);
	    return df.format(calendar.getTime());
	}
	
	/**
	 * getMonthOfTheLastDay方法慨述: 将指定日期得到当前月第一天
	 * <br>创 建  人：张杰 
	 * <br>创建时间：2013-10-23 下午07:02:45 
	 * <br>修 改  人：(修改了该文件，请填上修改人的名字) 
	 * <br>修改日期：(请填上修改该文件时的日期) 
	 * <br>@param date
	 * <br>@return String
	 * @throws ParseException 
	 */
	public static String getMonthOfTheFirstDay(String date,String format){
		SimpleDateFormat dfs = new SimpleDateFormat(format);
		Calendar calendar = Calendar.getInstance();   
		try {
			java.util.Date Date = dfs.parse(date);
			calendar.setTime(Date);
			calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));   
		} catch (ParseException e) {
			e.printStackTrace();
		}
		java.text.SimpleDateFormat df = new java.text.SimpleDateFormat("yyyy-MM-dd");
		return df.format(calendar.getTime()); 
	}
	
	/**
	 * getMonthOfTheLastDay方法慨述: 将指定日期得到当前月最后一天
	 * <br>创 建  人：张杰 
	 * <br>创建时间：2013-10-23 下午07:02:45 
	 * <br>修 改  人：(修改了该文件，请填上修改人的名字) 
	 * <br>修改日期：(请填上修改该文件时的日期) 
	 * <br>@param date
	 * <br>@return String
	 * @throws ParseException 
	 */
	public static String getMonthOfTheLastDay(String date,String format){
		SimpleDateFormat dfs = new SimpleDateFormat(format);
		Calendar calendar = Calendar.getInstance();   
		try {
			java.util.Date Date = dfs.parse(date);
			calendar.setTime(Date);
			calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));   
		} catch (ParseException e) {
			e.printStackTrace();
		}
		java.text.SimpleDateFormat df = new java.text.SimpleDateFormat("yyyy-MM-dd");
		return df.format(calendar.getTime()); 
	}
	
	/**
	 * getDate方法慨述:判断年、月、天数
	 * @param date 字符串日期值
	 * @return Integer 传入年、月的天数
	 */
	public static Integer getDate(String date){
		String year = date.split("-")[0];
		String month = date.split("-")[1];
		int year1 = (Integer.valueOf(year) - 4) % 12;
		   //定义变量，存储该月多少天
		   int daysOfMonth = 0;
		   //计算该月多少天
		   switch (Integer.valueOf(month)) {
		   case 1:
		   case 3:
		   case 5:
		   case 7:
		   case 8:
		   case 10:
		   case 12:
			   daysOfMonth=31;
		    return daysOfMonth;
		   case 2:
		    if (year1 % 400 == 0 || (year1 % 4 == 0 && year1 % 100 != 0)) {
		     
		     daysOfMonth = 29;
		     return daysOfMonth;
		     
		    } else {
		     daysOfMonth = 28;
		     return daysOfMonth;
		    }
		   default:
		    daysOfMonth = 30;
		    return daysOfMonth;
		   }
	}
	
	/**
	 * zhdateKeyUp方法慨述:日期文本按上键执行方法
	 */
	public static String zhdateKeyUp(String date){
		String[] hzdate = date.split("-");
		Integer day = getDate(date);
		if(Integer.valueOf(hzdate[2])+1>day){
			hzdate[1]=(Integer.valueOf(hzdate[1])+1)+"";
			if(Integer.valueOf(hzdate[1])+1<=10){
				hzdate[1]="0"+hzdate[1];
			}
			if(Integer.valueOf(hzdate[1])>12){
				hzdate[0]=(Integer.valueOf(hzdate[0])+1)+"";
				hzdate[1]="01";
			}
			hzdate[2]="01";
		}else{
			if(Integer.valueOf(hzdate[2])+1<10){
				hzdate[2]="0"+(Integer.valueOf(hzdate[2])+1);
			}else{
				hzdate[2]=(Integer.valueOf(hzdate[2])+1)+"";
			}
			
		}
		return hzdate[0]+"-"+hzdate[1]+"-"+hzdate[2];
	}
	
	/**
	 * getDay方法慨述:计算日期
	 * @param hzdate 字符串日期数组
	 * @return String[] 
	 */
	public static String[] getDay(String[] hzdate){
		if(Integer.valueOf(hzdate[2])-1<=0){
			hzdate[1]=(Integer.valueOf(hzdate[1])-1)+"";
			if(Integer.valueOf(hzdate[1])<10){
				hzdate[1]="0"+hzdate[1];
			}
			if(Integer.valueOf(hzdate[1])<=0){
				hzdate[0]=(Integer.valueOf(hzdate[0])-1)+"";
				hzdate[1]="12";
			}
			Integer day = getDate(hzdate[0]+"-"+hzdate[1]);
			hzdate[2]=day+"";
		}else{
			if(Integer.valueOf(hzdate[2])-1<10){
				hzdate[2]="0"+(Integer.valueOf(hzdate[2])-1);
			}else{
				hzdate[2]=(Integer.valueOf(hzdate[2])-1)+"";
			}
		}
		return hzdate;
	}
	
	/**
	 * minuteInterval方法慨述:得到指定格式两个时间的间隔分钟数(date2 - date1)
	 * @param strFormat 格式"yyyy-MM-dd HH:mm:ss"
	 * @param date1  时间"HH:mm"
	 * @param date2 时间"HH:mm"
	 * @return long 返回间隔分钟数
	 */
	public static long minuteInterval(String strFormat,String date1,String date2){
		SimpleDateFormat dfs = new SimpleDateFormat(strFormat);
		long between = 0;
		try {
			java.util.Date begin=dfs.parse(date1);
			java.util.Date end = dfs.parse(date2);
			between=(end.getTime()- begin.getTime())/1000/60; //除以1000是为了转换成秒,除以60转换为分
		} catch (ParseException e) {
		}
		return between;
	}
	
	/**
	 * minuteInterval方法慨述: 得到两个日期 间隔的分钟数 (d1 - d2)
	 * <br>创 建  人：王光银 
	 * <br>创建时间：2013-5-16 下午10:13:38 
	 * <br>修 改  人：(修改了该文件，请填上修改人的名字) 
	 * <br>修改日期：(请填上修改该文件时的日期) 
	 * @param d1
	 * @param d2
	 * @return int
	 */
	public static long minuteInterval(Date d1, Date d2) {
		return (d1.getTime() - d2.getTime()) / 1000 / 60;
	}
	
	/**
	 *得到传入日期的年份，4位
	 * @param strFormat 传入日期字符串的日期格式 格式"yyyy-MM-dd HH:mm:ss"
	 * @param strDate 字符串日期
	 * @return String 4位年份
	 */
	@SuppressWarnings("static-access")
	public static String getYear(String strFormat,String strDate){
		SimpleDateFormat dfs = new SimpleDateFormat(strFormat);
		int year = 0 ;
		try {
			java.util.Date Date = dfs.parse(strDate);
			java.util.Calendar calendar = Calendar.getInstance();
			calendar.setTime(Date);
			year = calendar.get(calendar.YEAR);
		} catch (ParseException e) {
		}
		return year+"";
	}
	
	/**
	 * 方法慨述:根据日期得到年份，4位
	 * @param date 日期
	 * @return String 4位年份 
	 */
	@SuppressWarnings("static-access")
	public static String getYear(Date date){
		int year = 0 ;
		java.util.Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		year = calendar.get(calendar.YEAR);
		
		return year+"";
	}
	
	/**
	 * 方法慨述:得到传入日期的月份,2位
	 * @param strFormat 传入日期字符串的日期格式 格式"yyyy-MM-dd HH:mm:ss"
	 * @param strDate 字符串日期
	 * @return String 2位月份
	 */
	@SuppressWarnings("static-access")
	public static String getMonth(String strFormat,String strDate){
		SimpleDateFormat dfs = new SimpleDateFormat(strFormat);
		String month = "" ;
		try {
			java.util.Date Date = dfs.parse(strDate);
			java.util.Calendar calendar = Calendar.getInstance();
			calendar.setTime(Date);
			int value = calendar.get(calendar.MONTH)+1;
			if(value < 10){
				month = "0"+value;
			}else{
				month = value+"";
			}
		} catch (ParseException e) {
		}
		return month;
	}
	
	/**
	 * 方法慨述:得到传入日期的小时,2位
	 * @param strFormat 传入日期字符串的日期格式 格式"yyyy-MM-dd HH:mm:ss"
	 * @param strDate 字符串日期
	 * @return String 2位小时
	 */
	@SuppressWarnings("static-access")
	public static String getHour(String strFormat,String strDate){
		SimpleDateFormat dfs = new SimpleDateFormat(strFormat);
		String hour = "" ;
		try {
			java.util.Date Date = dfs.parse(strDate);
			java.util.Calendar calendar = Calendar.getInstance();
			calendar.setTime(Date);
			int value = calendar.get(calendar.HOUR_OF_DAY);
			if(value < 10){
				hour = "0"+value;
			}else{
				hour = value+"";
			}
		} catch (ParseException e) {
		}
		return hour;
	}
	
	/**
	 * 方法慨述:得到传入日期的分钟,2位
	 * @param strFormat 传入日期字符串的日期格式 格式"yyyy-MM-dd HH:mm:ss"
	 * @param strDate 字符串日期
	 * @return String 2位分钟
	 */
	@SuppressWarnings("static-access")
	public static String getMinute(String strFormat,String strDate){
		SimpleDateFormat dfs = new SimpleDateFormat(strFormat);
		String minute = "" ;
		try {
			java.util.Date Date = dfs.parse(strDate);
			java.util.Calendar calendar = Calendar.getInstance();
			calendar.setTime(Date);
			int value = calendar.get(calendar.MINUTE);
			if(value < 10){
				minute = "0"+value;
			}else{
				minute = value+"";
			}
		} catch (ParseException e) {
		}
		return minute;
	}
	
	/**
	 * 方法慨述:得到传入日期的分钟,2位
	 * @param strFormat 传入日期字符串的日期格式 格式"yyyy-MM-dd HH:mm:ss"
	 * @param strDate 字符串日期
	 * @return String 2位分钟
	 */
	@SuppressWarnings("static-access")
	public static String getSecond(String strFormat,String strDate){
		SimpleDateFormat dfs = new SimpleDateFormat(strFormat);
		String second = "" ;
		try {
			java.util.Date Date = dfs.parse(strDate);
			java.util.Calendar calendar = Calendar.getInstance();
			calendar.setTime(Date);
			int value = calendar.get(calendar.SECOND);
			if(value < 10){
				second = "0"+value;
			}else{
				second = value+"";
			}
		} catch (ParseException e) {
		}
		return second;
	}
	
	/**
	 * 方法慨述:得到传入日期的月份,2位
	 * @param Date 日期
	 * @return String 2位月份
	 */
	@SuppressWarnings("static-access")
	public static String getMonth(Date date){
		String month = "" ;
		java.util.Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int value = calendar.get(calendar.MONTH)+1;
		if(value < 10){
			month = "0"+value;
		}else{
			month = value+"";
		}
		return month;
	}
	
	/**
	 * 方法慨述:得到传入日期的天数,2位
	 * @param strFormat 传入日期字符串的日期格式 格式"yyyy-MM-dd HH:mm:ss"
	 * @param strDate 字符串日期
	 * @return String 2位天
	 */
	@SuppressWarnings("static-access")
	public static String getDay(String strFormat,String strDate){
		SimpleDateFormat dfs = new SimpleDateFormat(strFormat);
		String day = "" ;
		try {
			java.util.Date Date = dfs.parse(strDate);
			java.util.Calendar calendar = Calendar.getInstance();
			calendar.setTime(Date);
			int value = calendar.get(calendar.DAY_OF_MONTH);
			if(value < 10){
				day = "0"+value;
			}else{
				day = value+"";
			}
		} catch (ParseException e) {
		}
		return day;
	}
	
	/**
	 * 方法慨述:得到传入日期的天数,2位
	 * @param strDate 日期
	 * @return String 2位天
	 */
	@SuppressWarnings("static-access")
	public static String getDay(Date date){
		String day = "" ;
		java.util.Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int value = calendar.get(calendar.DAY_OF_MONTH);
		if(value < 10){
			day = "0"+value;
		}else{
			day = value+"";
		}
		return day;
	}
	
	/**
	 * description before:测试此日期是否在指定日期之前
	 * <br>author ：koujiang
	 * <br>@param strFormat
	 * <br>@param onedate
	 * <br>@param twoDate 
	 * <br>return :boolean 如果onedate在时间twoDate前面也就是实现前就返回true否者为false
	 * <br>				onedate < twoDate --> true 否者返回 false
	 * <br>例如:onedate='2014-11-27 12:00:00', twoDate='2014-11-25 08:00:00',则返回false
	 * <br>update ：2014-9-25 下午05:35:18
	 * <br>mender ：(Please add the modifier name)
	 * <br>Modified ：(Please add modification date)
	 * <br>varsion ：v1.0.0
	 */
	public static boolean before(String strFormat, String onedate, String twoDate) {
		SimpleDateFormat dfs = new SimpleDateFormat(strFormat);
		try {
			java.util.Date Date1 = dfs.parse(onedate);
			java.util.Date Date2 = dfs.parse(twoDate);
			return Date1.before(Date2);
		} catch (ParseException e) {
		}
		return false;
	} 
	
	/**
	 * description getLastMonthOfTheFirstSecond:获取下个月的第一秒
	 * <br>author ：koujiang
	 * <br>@param date
	 * <br>@param format
	 * <br>@return 
	 * <br>return :String
	 * <br>update ：2015-4-24 下午07:33:09
	 * <br>mender ：(Please add the modifier name)
	 * <br>Modified ：(Please add modification date)
	 * <br>varsion ：v1.0.0
	 */
	public static String getLastMonthOfTheFirstSecond(String date,String format){
		SimpleDateFormat dfs = new SimpleDateFormat(format);
		Calendar calendar = Calendar.getInstance();   
		try {
			java.util.Date Date = dfs.parse(date);
			calendar.setTime(Date);
			calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));   
		} catch (ParseException e) {
			e.printStackTrace();
		}
		java.text.SimpleDateFormat df = new java.text.SimpleDateFormat(DateHelper.YYYYMMDD);
		String format2 = df.format(calendar.getTime());
		return DateHelper.nDaysAfterOneDate(format2, DateHelper.YYYYMMDD, 1) +" 00:00:00";
	}
}