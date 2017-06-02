package com.example.li.webgame;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.tencent.smtt.sdk.WebView;

public class TencentWebActivity extends AppCompatActivity {

    private String filePath = "file://" + Environment.getExternalStorageDirectory().getAbsolutePath() + "/video-js/demo.html";
    private WebView mwebeview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tencent_web);
        mwebeview = (WebView) findViewById(R.id.tencent_webview);
        mwebeview.loadUrl(filePath);

    }
}
