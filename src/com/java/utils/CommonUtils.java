package com.java.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;


/**
 * 一些公用的方法
 * 
 * @author Kaisa
 *
 */
public class CommonUtils {
	/**
	 * 获得32位的UUID
	 * 
	 * @return
	 */
	public static String getUUID() {
		String uuid = UUID.randomUUID().toString().replace("-", "");
		return uuid;
	}

	/**
	 * 获得当前时间返回字符串
	 * 
	 * @return yyyy-MM-dd HH:mm:ss,如 2017-01-01 01:01:01
	 */
	public static String getNowTime() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return df.format(new Date()).toString();
	}
	
}
