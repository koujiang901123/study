package com.koujiang.framework.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * Authenti概要说明：验证公用类
 * 
 * @author hfh
 */
public class Authenti {

	/***
	 * verDigi方法慨述:正则表达式验证数字 
	 * @param strValue 字符串
	 * @return boolean true是，false否
	 */
	public static boolean verDigi(String strValue) {
		boolean isDig = false;
		if(null==strValue||"".equals(strValue)){
			return true;
		}
		Pattern p = Pattern.compile("^[+-]?\\d+$");
		Matcher ma = p.matcher(strValue);
		isDig = ma.matches();
		return isDig;
	}
	
	public static boolean isFounma(String strValue){
		boolean flag = true;
		Pattern p = Pattern.compile("[-/\\+\\*]");
		Matcher ma = p.matcher(strValue);
		flag = ma.matches();
		return flag;
	}

	/**
	 * support Numeric format:
	 * "33" "+33" "033.30" "-.33" ".33" " 33." " 000.000 "
	 * 
	 * @param str
	 *            String
	 * @return boolean
	 */
	public static boolean isNumeric(String str) {
		int begin = 0;
		boolean once = true;
		if (str == null || str.trim().equals("")) {
			return false;
		}
		str = str.trim();
		if (str.startsWith("+") || str.startsWith("-")) {
			if (str.length() == 1) {
				return false;
			}
			begin = 1;
		}
		for (int i = begin; i < str.length(); i++) {
			if (!Character.isDigit(str.charAt(i))) {
				if (str.charAt(i) == '.' && once) {
					once = false;
				} else {
					return false;
				}
			}
		}
		if (str.length() == (begin + 1) && !once) {
			return false;
		}
		return true;
	}

	/**
	 * support Integer format:
	 * "33" "003300" "+33" " -0000 "
	 * 
	 * @param str
	 *            String
	 * @return boolean
	 */
	public static boolean isInteger(String str) {
		int begin = 0;
		if (str == null || str.trim().equals("")) {
			return false;
		}
		str = str.trim();
		if (str.startsWith("+") || str.startsWith("-")) {
			if (str.length() == 1) {
				return false;
			}
			begin = 1;
		}
		for (int i = begin; i < str.length(); i++) {
			if (!Character.isDigit(str.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	/**
	 * use Exception support Numeric format:
	 * "33" "+33" "033.30" "-.33" ".33" " 33." " 000.000 "
	 * 
	 * @param str
	 *            String
	 * @return boolean
	 */
	public static boolean isNumericEx(String str) {
		try {
			Double.parseDouble(str);
			if(str.indexOf("E") > 0 || str.indexOf("e") > 0) {		//科学计数法的字符不为数字
				return false;
			}
			if(str.matches("^[0]+\\d+$")){							//所有字符为数字且是个整数的时候，但是第一位是0就不为数字
				return false;
			}
			/*if(str.matches("^[0-9]+(\\.[0-9]*)?$")) {
				return true;
			}
			return false;*/
			return true;
		} catch (NumberFormatException ex) {
			return false;
		}
	}
	
	/**
	 * use Exception support less than 11 digits(<11)
	 * support Integer format:
	 * "33" "003300" "+33" " -0000 " "+ 000"
	 * 
	 * @param str
	 *            String
	 * @return boolean
	 */
	public static boolean isIntegerEx(String str) {
		str = str.trim();
		try {
			Integer.parseInt(str);
			return true;
		} catch (NumberFormatException ex) {
			if (str.startsWith("+")) {
				return isIntegerEx(str.substring(1));
			}
			return false;
		}
	}

	/**
	 *  将字符串转换为数字，不为数字时返回为0
	 * @param s 字符串
	 * @return int 返回的数字
	 */
	public static int checkID(String s) {
		if ((s == null) || (s.length() == 0) || !s.matches("^[0-9]*$")) {
			return 0;
		} else {
			if (s.length() < 10) {
				return Integer.parseInt(s);
			} else {
				return 0;
			}
		}
	}

	/**
	 *  检测传入的是否有数字。如果有则返回“”
	 * @param s 传入字符串
	 * @return String 返回字符串
	 */
	public static String checkString(String s) {
		if ((s == null) || (s.length() == 0) || s.matches("^[0-9]*$")) {
			return "";
		} else {
			return s;
		}

	}
	
	/****
	 * isLetters方法慨述:匹配由26个英文字母组成的字符串
	 * @param strValue参数值
	 * @return boolean是否匹配
	 * @throws
	 */
	public static boolean isLetters(String strValue){
		boolean isDig = false;
		Pattern p = Pattern.compile("^[A-Za-z]+$");
		Matcher ma = p.matcher(strValue);
		isDig = ma.matches();
		return isDig;
	}
	/**
	 * isEn方法慨述:验证字符串只包含数字和字母
	 * @param value
	 * @return boolean 
	 * @throws
	 */
	public static boolean isEn(String value){
		boolean isDig = false;
		Pattern p = Pattern.compile("^[A-Za-z0-9]+$");
		Matcher ma = p.matcher(value);
		isDig = ma.matches();
		return isDig;
	}
	
	public static void main(String[] args){
		String value = "1233.33";
		boolean falst = Authenti.isNumericEx(value);
		System.out.println("=="+falst);
	}

}
