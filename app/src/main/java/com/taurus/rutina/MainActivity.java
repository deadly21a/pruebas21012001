package com.taurus.rutina;

import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends Activity {
  private WebView webView;

  @Override public void onCreate(Bundle b){
    super.onCreate(b);

    Window w=getWindow();
    w.setStatusBarColor(Color.rgb(5,5,10));
    w.setNavigationBarColor(Color.rgb(5,5,10));
    if(Build.VERSION.SDK_INT>=30){
      w.setDecorFitsSystemWindows(true);
    } else {
      w.getDecorView().setSystemUiVisibility(0);
    }

    webView=new WebView(this);
    webView.setBackgroundColor(Color.rgb(5,5,10));
    setContentView(webView);

    if(Build.VERSION.SDK_INT>=23){
      webView.setOnApplyWindowInsetsListener((v,insets)->{
        int top=insets.getSystemWindowInsetTop();
        v.setPadding(0,top,0,0);
        return insets;
      });
    }

    WebSettings s=webView.getSettings();
    s.setJavaScriptEnabled(true);
    s.setDomStorageEnabled(true);
    s.setAllowFileAccess(true);
    s.setLoadsImagesAutomatically(true);
    s.setUseWideViewPort(false);
    s.setLoadWithOverviewMode(false);
    s.setTextZoom(100);

    webView.setWebViewClient(new WebViewClient());
    webView.loadUrl("file:///android_asset/index.html");
  }

  @Override public void onBackPressed(){
    if(webView.canGoBack()) webView.goBack(); else super.onBackPressed();
  }
}
