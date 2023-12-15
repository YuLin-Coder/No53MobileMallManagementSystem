package com.java.utils;

import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符串工具类
 * @author 
 *
 */
public class StringUtil {
	public static void main(String[] args){
	}
	
	/**
	 * 判断是否是空
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str){
		if(str==null||"".equals(str.trim())){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * 判断是否不是空
	 * @param str
	 * @return
	 */
	public static boolean isNotEmpty(String str){
		if((str!=null)&&!"".equals(str.trim())){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * 判断是否是空
	 * @param str
	 * @return
	 */
	public static String covertNull(String str){
		if(str==null||"NULL".equalsIgnoreCase(str)){
			return "";
		}else{
			return str;
		}
	}
	
	/**
	 * 返回文件的扩展名
	 * @param str
	 * @return
	 */
	public static String getFileExtName(String str){
		if(str==null||"NULL".equalsIgnoreCase(str)){
			return "";
		}else{			
			return str.substring(str.lastIndexOf(".")+1);
		}
	}
    

    public static boolean isURL(String url){
    	 //String rex="[a-zA-z]+://[^\s]*";   
    	 String regex = "^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]" ;
    	 Pattern patt = Pattern. compile(regex );
    	 Matcher matcher = patt.matcher(url);
    	 boolean isMatch = matcher.matches();
    	 return isMatch;
    	 
    }
    
    /**
     * 删除所有的HTML标签
     *
     * @param source 需要进行除HTML的文本
     * @return
     */
    public static String CleanHTML(String source) {

	     if(source == null) {
	          return "";
	     }
	
	     String s = source;
	     /** 删除普通标签  */
	     s = s.replaceAll("<(S*?)[^>]*>.*?|<.*? />", "");
	     /** 删除转义字符 */
	     s = s.replaceAll("&.{2,6}?;", "");
	     return s;
    }
    
    public static String SetOnlyKey()
    {
    	String s="";
    	for (int i = 0; i < 100; i++) 
            s = UUID.randomUUID().toString();
        return s;
    }
    
    public  static String GetProject()
	{
		return "C:/Java/telephone";
	}
}
