package com.koujiang.framework.constant;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;

import com.koujiang.framework.swtdesigner.SWTResourceManager;

/**
 * <br>(c) Copyright 2017 koujiang901123@sina.com
 * <br>@description	:页面风格
 * <br>@file_name	:StyleFinal.java
 * <br>@system_name	:terminals-ui
 * <br>@author		:koujiang 
 * <br>@create_time	:2018年5月14日 下午6:03:31
 * <br>@mender		:(Please add the modifier name)
 * <br>@Modified	:(Please add modification date)
 * <br>@varsion		:v1.0.0
 */
public class StyleFinal {
	
	/**（默认样式）Default  白色**/
	public static Color COLOR_DEFAULT = SWTResourceManager.getColor(255, 255, 255);
	/**（首选项）Primary**/
	public static Color COLOR_PRIMARY = SWTResourceManager.getColor(51, 122, 183);
	/**（成功）Success**/
	public static Color COLOR_SUCCESS = SWTResourceManager.getColor(92, 184, 92);
	/**（一般信息）Info**/
	public static Color COLOR_INFO = SWTResourceManager.getColor(91, 192, 222);
	/**（警告）Warning**/
	public static Color COLOR_WARNING = SWTResourceManager.getColor(240, 173, 78);
	/**（危险）Danger  红色**/
	public static Color COLOR_DANGER = SWTResourceManager.getColor(217, 83, 79);
	/**黑色**/
	public static Color COLOR_BLACK = SWTResourceManager.getColor(SWT.COLOR_BLACK);
	
	/**
	 * 系统字体样式 
	 */
	public static final String FONTSTYLE = "微软雅黑";
	
	public static Font FONT_7_NORMAL = SWTResourceManager.getFont("微软雅黑", 7, SWT.NORMAL);
	public static Font FONT_8_NORMAL = SWTResourceManager.getFont("微软雅黑", 8, SWT.NORMAL);
	public static Font FONT_9_NORMAL = SWTResourceManager.getFont("微软雅黑", 9, SWT.NORMAL);
	public static Font FONT_10_NORMAL = SWTResourceManager.getFont("微软雅黑", 10, SWT.NORMAL);
	public static Font FONT_11_NORMAL = SWTResourceManager.getFont("微软雅黑", 11, SWT.NORMAL);
	public static Font FONT_12_NORMAL = SWTResourceManager.getFont("微软雅黑", 12, SWT.NORMAL);
	public static Font FONT_13_NORMAL = SWTResourceManager.getFont("微软雅黑", 13, SWT.NORMAL);
	public static Font FONT_15_NORMAL = SWTResourceManager.getFont("微软雅黑", 15, SWT.NORMAL);
	public static Font FONT_16_NORMAL = SWTResourceManager.getFont("微软雅黑", 16, SWT.NORMAL);
	public static Font FONT_18_NORMAL = SWTResourceManager.getFont("微软雅黑", 18, SWT.NORMAL);
	public static Font FONT_20_NORMAL = SWTResourceManager.getFont("微软雅黑", 20, SWT.NORMAL);
	public static Font FONT_22_NORMAL = SWTResourceManager.getFont("微软雅黑", 22, SWT.NORMAL);
	public static Font FONT_24_NORMAL = SWTResourceManager.getFont("微软雅黑", 24, SWT.NORMAL);
	public static Font FONT_24_ITALIC = SWTResourceManager.getFont("微软雅黑", 24, SWT.ITALIC);
	public static Font FONT_25_NORMAL = SWTResourceManager.getFont("微软雅黑", 25, SWT.NORMAL);
	public static Font FONT_26_NORMAL = SWTResourceManager.getFont("微软雅黑", 26, SWT.NORMAL);
	public static Font FONT_30_NORMAL = SWTResourceManager.getFont("微软雅黑", 30, SWT.NORMAL);
	public static Font FONT_40_NORMAL = SWTResourceManager.getFont("微软雅黑", 40, SWT.NORMAL);
	
	/**
	 * 系统主页背景色 
	 */
	public static final Color MAINBEIJING = SWTResourceManager.getColor(177, 200, 231);
	
	/**
	 * 所有面板前景色
	 */
	public static final Color PANELCOLOR = SWTResourceManager.getColor(SWT.COLOR_WHITE);
	
	public static final Color BLUE = SWTResourceManager.getColor(SWT.COLOR_BLUE);
	public static final Color GREEN = SWTResourceManager.getColor(SWT.COLOR_GREEN);
	
	public static final Color DEEP_GREEN = SWTResourceManager.getColor(0, 121, 31);
	
	public static final Color DIALOG_BACKGROUND = SWTResourceManager.getColor(190, 205, 220);
	
	public static final Color YELLOW = SWTResourceManager.getColor(SWT.COLOR_YELLOW);
	
	public static final Color PINK= SWTResourceManager.getColor(255, 204, 204);
	
	public static final Color BLACK= SWTResourceManager.getColor(0, 0, 0);
	
	/**
	 * 禁用颜色
	 */ 
	public static final Color FORBIDDEN = SWTResourceManager.getColor(SWT.COLOR_GRAY);
	
	/**
	 * 选项卡选中时候颜色
	 */
	public static final Color SELECTBACKGROUND = SWTResourceManager.getColor(189, 217, 254);
	
	/**
	 * 选项卡字体颜色
	 */
	public static final Color TABCOLOR = SWTResourceManager.getColor(0, 109, 174);
	
	/**
	 * 选项卡背景色
	 */
	public static final Color TABBACKGROUND = SWTResourceManager.getColor(230, 241, 254);
	
	/**
	 * 必输项颜色
	 */
	public static final Color MUSTITEM = SWTResourceManager.getColor(SWT.COLOR_RED);
	/**
	 * 普通项颜色
	 */
	public static final Color COMMON = SWTResourceManager.getColor(SWT.COLOR_BLACK);
	/**
	 * 不需用户输入label背景色
	 */
	public static final Color NOMUSTITEM = SWTResourceManager.getColor(SWT.COLOR_BLUE);
	/**
	 * 按钮宽度
	 */
	public static final int BT_WIDTH = 80;
	/**
	 * 按钮高度
	 */
	public static final int BT_HEIGHT = 30;
	/**
	 * 文本框长度
	 */
	public static final int TXT_HEIGHT = 21;
	
	/**
	 * 小键盘的回车事件
	 */
	public static final int CR = SWT.KEYPAD_CR;
}