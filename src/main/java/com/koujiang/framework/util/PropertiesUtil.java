package com.koujiang.framework.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
/**
 * <br>(c) Copyright 2017 koujiang901123@sina.com
 * <br>@description	:PropertiesUtil
 * <br>@file_name	:PropertiesUtil.java
 * <br>@author		:koujiang 
 * <br>@create_time	:2017年11月23日 下午10:34:55
 * <br>@mender		:(Please add the modifier name)
 * <br>@Modified	:(Please add modification date)
 * <br>@varsion		:v1.0.0
 */
public class PropertiesUtil {
	
	public static Properties loadProperties(File file) {
		try {
			if(file != null) {
				return loadProperties(new FileInputStream(file));
			}
		} catch (FileNotFoundException e) {
			throw new RuntimeException("文件未找到(请检查文件路径)!");
		}
		return null;
	}
	
	public static Properties loadProperties(InputStream in) {
		try {
			if(in != null) {
				Properties properties = new Properties();
				properties.load(in);
				return properties;
			}
		} catch (IOException e) {
			throw new RuntimeException("文件读取错误!");
		}
		return null;
	}
	
	public static Properties loadProperties(String pathname) {
		return loadProperties(getReadFile(pathname));
	}
	
	/**
	 * description transformToMap:将Properties转换成Map
	 * <br>author ：koujiang
	 * <br>@param properties
	 * <br>@return 
	 * <br>return :Map<String,String>
	 * <br>update ：2017年3月2日 下午5:14:40
	 * <br>mender ：(Please add the modifier name)
	 * <br>Modified ：(Please add modification date)
	 * <br>varsion ：v1.0.0
	 */
	public static Map<String, String> transformToMap(Properties properties) {
		if(properties != null) {
			Set<Object> keySet = properties.keySet();
			if(keySet != null && !keySet.isEmpty()) {
				Map<String, String> map = new HashMap<String, String>();
				for (Object key : keySet) {
					map.put(key.toString(), properties.getProperty(key.toString()));
				}
				return map;
			}
		}
		return null;
	}
	
	/**
	 * description getFile:依据路径获取文件
	 * <br>author ：koujiang
	 * <br>@param pathname
	 * <br>@return 
	 * <br>return :File
	 * <br>update ：2017年3月2日 下午4:54:09
	 * <br>mender ：(Please add the modifier name)
	 * <br>Modified ：(Please add modification date)
	 * <br>varsion ：v1.0.0
	 */
	private static File getFile(String pathname) {
		File file = new File(pathname);
		return file;
	}
	
	/**
	 * description getReadFile:获取可读文件(并验证文件是否存在、是否是一个标准文件、是否是可读)
	 * <br>author ：koujiang
	 * <br>@param pathname
	 * <br>@return 
	 * <br>return :File
	 * <br>update ：2017年3月2日 下午5:00:00
	 * <br>mender ：(Please add the modifier name)
	 * <br>Modified ：(Please add modification date)
	 * <br>varsion ：v1.0.0
	 */
	private static File getReadFile(String pathname) {
		File file = getFile(pathname);
		if(!file.exists()) throw new RuntimeException("此抽象路径名表示的文件或目录不存在");
		if(!file.isFile()) throw new RuntimeException("此抽象路径名表示的文件不是一个标准文件");
		if(!file.canRead()) throw new RuntimeException("不可以读取此抽象路径名表示的文件");
		return file;
	}
}
