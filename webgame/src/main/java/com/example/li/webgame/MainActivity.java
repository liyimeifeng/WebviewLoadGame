package com.example.li.webgame;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Lee on 2017/6/2 0002.
 */

public class MainActivity extends AppCompatActivity{

    private Button mButton,mButton_LoadfromSD,mButton_LoadfromAsset;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        getSupportActionBar().setTitle("Mainactivity");

        mButton = (Button) findViewById(R.id.button);
        mButton_LoadfromSD = (Button) findViewById(R.id.button_load_fromSD);
        mButton_LoadfromAsset = (Button)findViewById(R.id.button_load_fromAsset);

        intentJumpTo(mButton,WebActivity.class);
        intentJumpTo(mButton_LoadfromSD,WebFromSDActivity.class);
        intentJumpTo(mButton_LoadfromAsset,TencentWebActivity.class);
    }

    public void intentJumpTo(View button, final Class targetActivity){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,targetActivity);
                startActivity(intent);
            }
        });
    }

}
