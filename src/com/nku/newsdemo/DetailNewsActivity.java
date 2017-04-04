package com.nku.newsdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View.OnCreateContextMenuListener;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class DetailNewsActivity extends Activity{
	private WebView webView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.detail_news);
		
		webView = (WebView) findViewById(R.id.webView);
		String str = getIntent().getStringExtra("content_url");
		webView.loadUrl(str);
		webView.getSettings().setJavaScriptEnabled(true);
		//有网时直接通过网络访问，没网时加载本地的缓存
		webView.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
		
	}
	
	
}
