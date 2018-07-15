package com.koujiang.framework.time;

import com.sun.jna.Platform;
/**
 * NativeFactory概要说明：修改系统时间的工厂接口类
 * @author pengqunfei
 */
public class NativeFactory {

	public static JNative newNative(){
		if(Platform.isWindows()){
			return new WindowsImpl();
		}
		return new LinuxImpl();
	}
}
