package com.nku.newsdemo;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

public class HttpUtils {

	public static void setPicBitmap(final ImageView imPic,final String pic_url){
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				URL url;
				try {
					url = new URL(pic_url);
					HttpURLConnection conn = (HttpURLConnection) url.openConnection();
					conn.connect();
					InputStream is = conn.getInputStream();
					Bitmap bitmap = BitmapFactory.decodeStream(is);
					imPic.setImageBitmap(bitmap);
					is.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		}).start();
	}
}
