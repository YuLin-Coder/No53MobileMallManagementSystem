package com.java.utils;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	
	/**
	 * 日期格式化
	 * @param date
	 * @param format
	 * @return
	 */
	public static String formatDate(Date date, String format) {
		String result = "";
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		if (date != null) {
			result = sdf.format(date);
		}
		return result;
	}
	
	/**
	 * 格式化字符串
	 * @param str
	 * @param format
	 * @return
	 * @throws ParseException 
	 * @throws Exception
	 */
	public static Date formatString(String str, String format) throws ParseException{
		if (StringUtil.isEmpty(str)) {
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.parse(str);
	}
	
	/**
	 * 获取当前格式化日期yyyy-MM-dd hh:mm:ss
	 * @return
	 */
	public static String getCurrentDateStr(){
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(date);
	}
	
	/**
	 * 获取当前自定义格式化日期
	 * @param format
	 * @return
	 */
	public static String getCurrentDateCustomFormat(String format){
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date);
	}
	
	public static void main(String[] args) throws ParseException{
		System.out.println(getCurrentDateStr());
		System.out.println(getCurrentDateCustomFormat("yyyyMMddHHmmss"));
		System.out.println(getCurrentDateCustomFormat("yyyy-MM-dd HH:mm:ss"));
	}
}
