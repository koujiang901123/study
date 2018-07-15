package com.koujiang.framework;

import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class CalculationLocation {
	
	/**
	 * description getPoint:查找面板的在整个屏幕中的位置
	 * <br>author ：koujiang
	 * <br>@param parent
	 * <br>@return 
	 * <br>return :Point
	 * <br>update ：2018年6月2日 下午1:37:23
	 * <br>mender ：(Please add the modifier name)
	 * <br>Modified ：(Please add modification date)
	 * <br>varsion ：v1.0.0
	 */
	private static Point getPoint(Composite parent){
		Point point = new Point(0, 0);
		point.x += parent.getBounds().x;
		point.y += parent.getBounds().y;
		if(parent.getParent() != null && !(parent instanceof Shell) ){
			Point pt = getPoint(parent.getParent());
			point.x += pt.x;
			point.y += pt.y;
		}
		return point;
	}
	
	/**
	 * description getLocation:计算面板左下角的位置
	 * <br>author ：koujiang
	 * <br>@param compo
	 * <br>@param weight
	 * <br>@param height 
	 * <br>return :void
	 * <br>update ：2018年6月2日 下午2:12:39
	 * <br>mender ：(Please add the modifier name)
	 * <br>Modified ：(Please add modification date)
	 * <br>varsion ：v1.0.0
	 */
	public static Point getLocation(Control compo) {
		Point point = getPoint(compo.getParent());
		//得到文本框坐标地址信息
		Rectangle txtRec = compo.getBounds();
		//文本框对应shell对象
		Shell txtShell = compo.getShell();
		//得到文本框shell地址信息
		Rectangle txtShellRec = txtShell.getBounds();
		
		//得到文本框所在主面板的边框
		int borderWidth = (txtShellRec.width - txtShell.getClientArea().width)/2;
		
		//得到总shell的总内容高度
		int screnHeight = Display.getCurrent().getClientArea().height;
		
		//得到文本框所在主面板top边框高度
		int borderHight = txtShellRec.height - txtShell.getClientArea().height - borderWidth;
		
		//设置最终shell位置
		int x = point.x + txtRec.x + borderWidth;
		int y = point.y + txtRec.y + borderHight + txtRec.height;
		
		//如果弹出的面板的位置比总shell高度
		if(y > screnHeight){
			y = y - txtRec.height - borderHight - txtRec.y;
		}
		return new Point(x, y);
	}
	
}
