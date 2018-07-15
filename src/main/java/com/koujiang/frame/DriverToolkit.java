package com.koujiang.frame;

import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.widgets.Control;

import com.koujiang.framework.swtdesigner.SWTResourceManager;

public class DriverToolkit {

	public static void setBackgroundImage(final Control control,final String image){
		control.addControlListener(new ControlAdapter() {
			@Override
			public void controlResized(ControlEvent e) {
				control.setBackgroundImage(ImageZoom.getImage(SWTResourceManager.getImage(image),
						control.getBounds().width,control.getBounds().height));
			}
		});
	}
}
