package com.koujiang.ui.client;

import java.awt.Toolkit;
import java.io.FileInputStream;
import java.io.IOException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

/**
 * Hello world!
 *
 */
public class App {

	
	public static boolean isDebug = false;
	
	//TODO：正式运行时 启用		获取屏幕的宽和高
	public static int width = Toolkit.getDefaultToolkit().getScreenSize().width;
	public static int height = Toolkit.getDefaultToolkit().getScreenSize().height;
	
    public static void main( String[] args ) {
    	Display.setAppName("Client");
    	Display.setAppVersion("1.0.0");
    	
    	Display display = Display.getDefault();
		final Shell shell = new Shell(display, SWT.SHELL_TRIM);
		shell.setLayout(new FormLayout());
		shell.setBackgroundMode(SWT.INHERIT_FORCE);
		
		FormData data = new FormData();
		data.top = new FormAttachment(0);
		data.left = new FormAttachment(0);
		data.right = new FormAttachment(100);
		data.bottom = new FormAttachment(100);
		MainUI ui = new MainUI(shell,SWT.NONE);
		ui.setLayoutData(data);
		
		shell.setMaximized(true);
		shell.open();
		shell.layout();
		
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();
    }
	
}
