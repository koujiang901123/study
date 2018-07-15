package com.koujiang.framework.time;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Structure;

public class WindowsImpl implements JNative {
	
	/**
	 * <br>(c) Copyright 2017 koujiang901123@sina.com
	 * <br>@description	:window系统时间的结构体类
	 * <br>@file_name	:WindowsImpl.java
	 * <br>@system_name	:terminals-ui
	 * <br>@author		:koujiang 
	 * <br>@create_time	:2018年5月14日 下午9:05:30
	 * <br>@mender		:(Please add the modifier name)
	 * <br>@Modified	:(Please add modification date)
	 * <br>@varsion		:v1.0.0
	 */
	public static class SYSTEMTIME extends Structure{
		public short wYear;
		public short wMonth;
		public short wDayOfWeek;
		public short wDay;
		public short wHour;
		public short wMinute;
		public short wSecond;
		public short wMilliseconds;
		@Override
		protected List<String> getFieldOrder() {
			return Arrays.asList(new String[]{"wYear", "wMonth", "wDayOfWeek", "wDay","wHour","wMinute","wSecond","wMilliseconds"});
		}
	}

	public interface Kernel32 extends Library{
		public boolean SetLocalTime(SYSTEMTIME st);
		
		public int GetCurrentProcessId();
	}
	
	public static Kernel32 kernel32Instance = null;
	
	public WindowsImpl(){
		kernel32Instance = (Kernel32)Native.loadLibrary("kernel32",Kernel32.class);
	}
	
	public void setLocalTime(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		SYSTEMTIME st = new SYSTEMTIME();
        st.wYear = (short)c.get(Calendar.YEAR);
        st.wMonth = (short)(c.get(Calendar.MONTH) + 1);
        st.wDay = (short)c.get(Calendar.DAY_OF_MONTH );
        st.wDayOfWeek = (short)c.get(Calendar.DAY_OF_WEEK);
        st.wHour = (short)c.get(Calendar.HOUR_OF_DAY);
        st.wMinute = (short)c.get(Calendar.MINUTE);
        st.wSecond = (short)c.get(Calendar.SECOND);
        st.wMilliseconds = (short)c.get(Calendar.MILLISECOND);
        kernel32Instance.SetLocalTime(st);
	}

}
