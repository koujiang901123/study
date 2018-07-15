package com.koujiang.framework.exception;

import java.io.PrintStream;
import java.io.PrintWriter;

/**
 * <br>(c) Copyright 2017 koujiang901123@sina.com
 * <br>@description	:描述：业务异常，在软件业务进行中，出现用户恶意破坏需要抛出的异常给用户提示
 * <br>@file_name	:UserBusinessException.java
 * <br>@system_name	:terminals-ui
 * <br>@author		:koujiang 
 * <br>@create_time	:2018年5月15日 上午11:37:37
 * <br>@mender		:(Please add the modifier name)
 * <br>@Modified	:(Please add modification date)
 * <br>@varsion		:v1.0.0
 */
public class UserBusinessException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private String errorMethod;
	private String errorCategory;
	private Throwable cause;
	
	public UserBusinessException(String errorCategory, String errorMethod, String message){
		super(message);
		this.errorCategory = errorCategory;
		this.errorMethod = errorMethod;
	}
	
	public UserBusinessException(String message, Throwable ex) {
		super(message, ex);
		this.cause = ex;
	}

	public UserBusinessException(String message) {
		super(message);
	}

	public UserBusinessException(Throwable ex) {
		this.cause = ex;
	}

	public Throwable getCause() {
		return (this.cause == null ? null :this.cause);
	}
	public String getMessage(){   
		String message = super.getMessage();   
		Throwable cause = getCause();   
		if(cause != null){   
		    message = message + ";businessException 源 is " + cause;   
		}
		return message;   
	}
	
	public String getSuperMessage() {
		return super.getMessage();
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

	public String getErrorCategory() {
		return errorCategory;
	}

	public void setErrorCategory(String errorCategory) {
		this.errorCategory = errorCategory;
	}

	public String getErrorMethod() {
		return errorMethod;
	}

	public void setErrorMethod(String errorMethod) {
		this.errorMethod = errorMethod;
	}
	
}
