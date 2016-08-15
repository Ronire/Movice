package com.lv.activity;

import com.lv.movice.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebActivity extends Activity {
 private WebView webview ;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_web);
		webview=(WebView) findViewById(R.id.webview);
		
	Intent intent=getIntent(); 
	String url=intent.getStringExtra("url");
	System.out.println(url+"-------------");
	webview.getSettings().setJavaScriptEnabled(true);
	
	//让WebView适应屏幕
	webview.getSettings().setUseWideViewPort(true);
	webview.getSettings().setLoadWithOverviewMode(true);
	
	webview.setWebViewClient(new WebViewClient(){
		                                                
		@Override
		public boolean shouldOverrideUrlLoading(WebView view, String url) {
		  view.loadUrl(url);
			return true;
		}
	});
	webview.loadUrl(url);
	
	}

	
}
