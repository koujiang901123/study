package com.by.selfservice.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;

import sun.audio.AudioData;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import sun.audio.ContinuousAudioDataStream; 

/**
 * <br>(c) Copyright 2018 by
 * <br>@description	:
 * <br>@file_name	:MusicPlay.java
 * <br>@system_name	:terminals-ui
 * <br>@author		:koujiang 
 * <br>@create_time	:2018年6月11日 下午7:45:24
 * <br>@mender		:(Please add the modifier name)
 * <br>@Modified	:(Please add modification date)
 * <br>@varsion		:v1.0.0
 */
@SuppressWarnings("restriction")
public class MusicPlay {
	
	public static MusicPlay musicPlay;
	
	private AudioStream  as; //单次播放声音用 
	ContinuousAudioDataStream cas;//循环播放声音 
    // 构造函数 
	public MusicPlay(URL url) {
        try { 
            //打开一个声音文件流作为输入 
            as = new AudioStream (url.openStream()); 
        } catch (FileNotFoundException e) { 
            e.printStackTrace(); 
        } catch (IOException e) { 
            e.printStackTrace(); 
        } 
    }
    
	//打开一个声音文件流作为输入 
	public MusicPlay(String audio) {
    	try {
    		if(musicPlay != null) {
    			musicPlay.stop();
    		}
    		FileInputStream inputStream = new FileInputStream(new File(audio));
            as = new AudioStream (inputStream);
        } catch (Exception e) { 
            e.printStackTrace(); 
        }
    }
    
    // 一次播放 开始 
	public void start() {
		if(musicPlay != null) {
			musicPlay.stop();
		}
		musicPlay = this;
        if( as==null ){ 
            return; 
        }else{ 
            AudioPlayer.player.start (as); 
        } 
    } 
    // 一次播放 停止 
	public void stop() {
		musicPlay = null;
        if( as==null ){ 
            return; 
        }else{ 
            AudioPlayer.player.stop(as); 
        }        
    } 
    
    // 循环播放 开始 
	public void continuousStart() { 
        AudioData data = null; 
        try { 
            data = as.getData(); 
        } catch (IOException e) { 
            e.printStackTrace(); 
        } 
        cas = new ContinuousAudioDataStream (data); 
        AudioPlayer.player.start(cas); 
    } 
    // 循环播放 停止 
	public void continuousStop() { 
        if(cas != null) { 
            AudioPlayer.player.stop (cas); 
        }    
    } 

}
