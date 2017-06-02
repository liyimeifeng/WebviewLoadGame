package com.example.li.webgame;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.io.File;

public class WebFromSDActivity extends AppCompatActivity {

    private WebView webview;
    private String fileName = "index.html";
//    private String filePath = "file:///storage/emulated/0/" +"html5-fruit-ninja/index.html";
    private String filePath = "file://" + Environment.getExternalStorageDirectory().getAbsolutePath() + "/video-js/demo.html";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_from_sd);
        getSupportActionBar().setTitle("webgame");
        init();
        getSupportActionBar().hide();
    }

    private void init(){
        getWindow().setFlags(//强制打开GPU渲染
                WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED,
                WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED);
        webview = (WebView)findViewById(R.id.webview_from_SD);
        webview.getSettings().setJavaScriptEnabled(true);
        webview.getSettings().setAllowFileAccess(true);      //允许访问文件数据
        webview.getSettings().setSupportZoom(true);          //支持放大网页
        webview.getSettings().setBuiltInZoomControls(true);  //支持缩小网页
//        webview.loadUrl(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator+ fileName);
//        webview.loadUrl( filePath);
        webview.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                view.loadUrl(filePath);
                return true;
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (webview != null) webview.destroy();
    }
}
