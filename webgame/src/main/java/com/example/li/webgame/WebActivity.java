package com.example.li.webgame;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;


/**
 * Created by Lee on 2017/6/2 0002.
 */

public class WebActivity extends AppCompatActivity {

    private WebView webView;
    //    private String url = "http://t.weflycloud.com/cq/screen/";
    //    private String url = "http://g.weflycloud.com/dzp/screen/web/cqh/"; //大转盘横版
    private String url = "http://g.weflycloud.com/dzp/screen/web/cqv/" ;//大转盘竖版
    //    private String url = "192.168.0.60";     //水果忍者游戏
    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_web);
        getSupportActionBar().setTitle("webview");
        init();
    }

    private void init(){
        webView = (WebView) findViewById(R.id.webview);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setLayerType(View.LAYER_TYPE_SOFTWARE, null);    //关闭硬件加速

        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView webView, String s) {
                webView.loadUrl(url);
                return true;  //true在本webview中显示，false调用系统浏览器
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        webView.destroy();
    }
}
