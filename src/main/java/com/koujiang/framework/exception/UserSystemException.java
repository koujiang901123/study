package com.koujiang.framework.exception;

import java.io.PrintStream;
import java.io.PrintWriter;

/**
 * <br>(c) Copyright 2017 koujiang901123@sina.com
 * <br>@description	:描述：系统异常，即出现软件编码错误或者网络错误等客户无法补救出现的异常
 * <br>@file_name	:UserSystemException.java
 * <br>@system_name	:terminals-ui
 * <br>@author		:koujiang 
 * <br>@create_time	:2018年5月15日 上午11:38:06
 * <br>@mender		:(Please add the modifier name)
 * <br>@Modified	:(Please add modification date)
 * <br>@varsion		:v1.0.0
 */
public class UserSystemException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	private Throwable cause;
	
	public UserSystemException(String message, Throwable ex) {
		super(message, ex);
		this.cause = ex;
	}

	public UserSystemException(String message) {
		super(message);
	}

	public UserSystemException(Throwable ex) {
		this.cause = ex;
	}
	
	public Throwable getCause() {
		return (this.cause == null ? null :this.cause);
	}
	
	public String getMessage(){   
		String message = super.getMessage();   
		Throwable cause = getCause();   
		if(cause != null){
		    message = message + ";systemException 源 is "+cause;   
		}
		return message;   
	}
	
	public void printStackTrace(PrintStream ps){
		if(getCause() == null){
			super.printStackTrace(ps);      
		}else{
			ps.println(this);   
			getCause().printStackTrace(ps);   
		}   
	}  
	public void printStackTrace(PrintWriter pw){
		if(getCause() == null){   
			super.printStackTrace(pw);   
		}else{
			pw.println(this);   
			getCause().printStackTrace(pw);   
		}
	}
	public void printStackTrace(){
		printStackTrace(System.err);   
	}
	
}