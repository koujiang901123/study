package com.koujiang.framework.util;

import java.net.URLDecoder;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.koujiang.framework.exception.UserBusinessException;
/**
 * <br>(c) Copyright 2016 by
 * <br>@description	:解析工具
 * <br>@file_name	:AnalysisUtil.java
 * <br>@system_name	:TOSInterfaces
 * <br>@author		:koujiang 
 * <br>@create_time	:2016年7月21日 上午9:22:37
 * <br>@mender		:(Please add the modifier name)
 * <br>@Modified	:(Please add modification date)
 * <br>@varsion		:v1.0.0
 */
public class AnalysisUtil {
	
	//SerializeWriter：相当于StringBuffer
    //JSONArray：相当于List<Object>
    //JSONObject：相当于Map<String, Object>
    //JSON反序列化没有真正数组，本质类型都是List<Object> 
		
	//下面是FastJson的简介：常用的方法！  
	//  Fastjson API入口类是com.alibaba.fastjson.JSON，常用的序列化操作都可以在JSON类上的静态方法直接完成。  
	//  public static final Object parse(String text); // 把JSON文本parse为JSONObject或者JSONArray   
	//  public static final JSONObject parseObject(String text)； // 把JSON文本parse成JSONObject      
	//  public static final <T> T parseObject(String text, Class<T> clazz); // 把JSON文本parse为JavaBean   
	//  public static final JSONArray parseArray(String text); // 把JSON文本parse成JSONArray   
	//  public static final <T> List<T> parseArray(String text, Class<T> clazz); //把JSON文本parse成JavaBean集合   
	//  public static final String toJSONString(Object object); // 将JavaBean序列化为JSON文本   
	//  public static final String toJSONString(Object object, boolean prettyFormat); // 将JavaBean序列化为带格式的JSON文本   
	//  public static final Object toJSON(Object javaObject); 将JavaBean转换为JSONObject或者JSONArray（和上面方法的区别是返回值是不一样的） 
	
	public static <T> T jsonToBean(String jsonstr, Class<T> cla) throws UserBusinessException, Exception {
		return JSONObject.parseObject(jsonstr, cla);
	}
	
	public static <T> List<T> jsonToList(String jsonstr, Class<T> cla) throws UserBusinessException, Exception {
		return JSONObject.parseArray(jsonstr, cla);
	}
	
	/**
	 * description jsonToMap:json String Analysis into Map
	 * <br>author ：koujiang
	 * <br>@param jsonstr	json string
	 * <br>@return	Map<key, value>[Map<String, Object>]
	 * <br>@throws UserBusinessException
	 * <br>@throws Exception 
	 * <br>return :Map<String,Object>
	 * <br>update ：2016年7月20日 下午6:09:29
	 * <br>mender ：(Please add the modifier name)
	 * <br>Modified ：(Please add modification date)
	 * <br>varsion ：v1.0.0
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, Object> jsonToMap(String jsonstr) throws UserBusinessException, Exception {
		if(jsonstr != null && jsonstr.trim().length() > 0) {
			//获取传入参数
			String parameters = URLDecoder.decode(jsonstr,"UTF-8");
			//传入参数Map
			return (Map<String, Object>) JSONObject.parse(parameters);
		} else {
			return null;
		}
	}
	
	/**
	 * description mapToJson:map Analysis into json string
	 * <br>author ：koujiang
	 * <br>@param resmap
	 * <br>@return
	 * <br>@throws UserBusinessException
	 * <br>@throws Exception 
	 * <br>return :String
	 * <br>update ：2016年7月20日 下午6:23:47
	 * <br>mender ：(Please add the modifier name)
	 * <br>Modified ：(Please add modification date)
	 * <br>varsion ：v1.0.0
	 */
	public static String mapToJson(Map<String, Object> resmap) {
		if(resmap != null && !resmap.isEmpty()) {
			//传入参数Map
			return JSON.toJSONString(resmap);
		} else {
			return null;
		}
	}
	
}
