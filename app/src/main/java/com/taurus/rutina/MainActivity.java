package com.taurus.rutina;
import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
public class MainActivity extends Activity {
  private WebView webView;
  @Override public void onCreate(Bundle b){
    super.onCreate(b);
    webView=new WebView(this);
    setContentView(webView);
    WebSettings s=webView.getSettings();
    s.setJavaScriptEnabled(true);
    s.setDomStorageEnabled(true);
    s.setAllowFileAccess(true);
    s.setLoadsImagesAutomatically(true);
    webView.setWebViewClient(new WebViewClient());
    webView.loadUrl("file:///android_asset/index.html");
  }
  @Override public void onBackPressed(){ if(webView.canGoBack()) webView.goBack(); else super.onBackPressed(); }
}
