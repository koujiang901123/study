package com.koujiang.framework.time;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.NativeLong;
import com.sun.jna.Structure;

/**
 * <br>(c) Copyright 2017 koujiang901123@sina.com
 * <br>@description	:Linux时间设置类
 * <br>@file_name	:LinuxImpl.java
 * <br>@system_name	:terminals-ui
 * <br>@author		:koujiang 
 * <br>@create_time	:2018年5月14日 下午9:05:05
 * <br>@mender		:(Please add the modifier name)
 * <br>@Modified	:(Please add modification date)
 * <br>@varsion		:v1.0.0
 */
public class LinuxImpl implements JNative {

	/**
	 * <br>(c) Copyright 2017 koujiang901123@sina.com
	 * <br>@description	:tm概要说明：Linux下的时间设置结构题
	 * <br>@file_name	:LinuxImpl.java
	 * <br>@system_name	:terminals-ui
	 * <br>@author		:koujiang 
	 * <br>@create_time	:2018年5月14日 下午9:05:19
	 * <br>@mender		:(Please add the modifier name)
	 * <br>@Modified	:(Please add modification date)
	 * <br>@varsion		:v1.0.0
	 */
	public static class tm extends Structure {

		public static class ByReference extends tm implements
				Structure.ByReference {
		}

		public static class ByValue extends tm implements Structure.ByValue {
		}

		public int tm_sec;// seconds 0-61
		public int tm_min;// minutes 1-59
		public int tm_hour;// hours 0-23
		public int tm_mday;// day of the month 1-31
		public int tm_mon;// months since jan 0-11
		public int tm_year;// years from 1900
		public int tm_wday;// days since Sunday, 0-6
		public int tm_yday;// days since Jan 1, 0-365
		public int tm_isdst;// Daylight Saving time indicator
		@Override
		protected List<String> getFieldOrder() {
			return Arrays.asList(new String[]{"tm_sec", "tm_min", "tm_hour", "tm_mday","tm_mon","tm_year","tm_wday","tm_yday","tm_isdst"});
		}
	}

	public static class timeval extends Structure {
		public static class ByReference extends timeval implements
				Structure.ByReference {
		}

		public static class ByValue extends timeval implements
				Structure.ByValue {
		}

		public NativeLong tv_sec; /* 秒数 */
		public NativeLong tv_usec; /* 微秒数 */
		@Override
		protected List<String> getFieldOrder() {
			return Arrays.asList(new String[]{"tv_sec", "tv_usec"});
		}
	}

	public static class timezone extends Structure {
		public static class ByReference extends timezone implements
				Structure.ByReference {
		}

		public static class ByValue extends timezone implements
				Structure.ByValue {
		}

		public int tz_minuteswest;
		public int tz_dsttime;
		@Override
		protected List<String> getFieldOrder() {
			return Arrays.asList(new String[]{"tz_minuteswest", "tz_dsttime"});
		}
	}

	public interface CLibrary extends Library {

		int gettimeofday(timeval.ByReference tv, timezone.ByReference tz);

		int settimeofday(timeval.ByReference tv, timezone.ByReference tz);

	}

	public static CLibrary cLibraryInstance = null;

	public LinuxImpl() {
		cLibraryInstance = (CLibrary) Native.loadLibrary("c", CLibrary.class);
	}

	/**
	 * 设置系统时间的接口方法
	 */
	public void setLocalTime(Date date) {
		long ms = date.getTime();

		long s = ms / 1000; // 秒
		long us = (ms % 1000) * 1000; // 微秒

		timeval.ByReference tv = new timeval.ByReference();
		timezone.ByReference tz = new timezone.ByReference();
		cLibraryInstance.gettimeofday(tv, tz);

		tv.tv_sec = new NativeLong(s);
		tv.tv_usec = new NativeLong(us);
		cLibraryInstance.settimeofday(tv, tz);
	}

}
