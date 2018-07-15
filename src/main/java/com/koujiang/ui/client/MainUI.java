package com.koujiang.ui.client;

import java.io.File;

import org.eclipse.swt.SWT;
import org.eclipse.swt.SWTError;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Composite;

import com.koujiang.framework.constant.StyleFinal;

public class MainUI extends Composite {
	
	public MainUI(Composite parent, int style) {
		super(parent, style);
		createContent(this);
	}

	private void createContent(Composite parent) {
		
		parent.setBackground(StyleFinal.COLOR_INFO);
		parent.setLayout(new FormLayout());
		
		Composite head = new Composite(parent, SWT.NONE);
		FormData headData = new FormData();
		headData.top = new FormAttachment(0);
		headData.left = new FormAttachment(0);
		headData.height = 100;
		headData.right = new FormAttachment(100);
		head.setLayoutData(headData);
		head.setFont(StyleFinal.FONT_9_NORMAL);
		createHeadComp(head);
		
		Composite body = new Composite(parent, SWT.NONE);
		body.setBackground(StyleFinal.COLOR_DEFAULT);
		FormData bodyData = new FormData();
		bodyData.top = new FormAttachment(head);
		bodyData.left = new FormAttachment(0);
		bodyData.right = new FormAttachment(100);
		bodyData.bottom = new FormAttachment(100);
		body.setLayoutData(bodyData);
		body.setFont(StyleFinal.FONT_9_NORMAL);
		createBodyComp(body);
	}
	
	private void createHeadComp(Composite head) {
	}

	private void createBodyComp(Composite body) {
		body.setLayout(new FillLayout());
		
		Browser browser = null;
		try {
			browser = new Browser(body, SWT.NONE);
			
			String fileDir = System.getProperty("user.dir")+"\\advertisement\\picture";
			String url = fileDir+File.separator+"index.html";
			browser.setUrl(url);
		} catch (SWTError e) {
			System.out.println("Could not instantiate Browser: " + e.getMessage());
		}
//		browser.set
//		browser.setUrl("https://www.baidu.com");
		
	}
}