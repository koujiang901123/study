package com.koujiang.frame;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;

import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.widgets.Display;

/**
 * <br>(c) Copyright 2018 by
 * <br>@description	:图片缩放
 * <br>@file_name	:ImageZoom.java
 * <br>@system_name	:terminals-ui
 * <br>@author		:koujiang 
 * <br>@create_time	:2018年5月29日 下午8:43:18
 * <br>@mender		:(Please add the modifier name)
 * <br>@Modified	:(Please add modification date)
 * <br>@varsion		:v1.0.0
 */
public final class ImageZoom {

	public static Image getImage(Blob image, int wide, int high){
		try {
			if(null != image){
		    	Blob blob = image;
		    	InputStream in = blob.getBinaryStream();
		    	Image newImage = new Image(Display.getCurrent(),in);
				in.close();
			    return getImage(newImage, wide, high);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static Image getImage(Image image, int wide, int high){
		try {
			if(null != image){
				ImageData imageData = image.getImageData();
				image = new Image(null, imageData.scaledTo(wide, high));
			    return image;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
