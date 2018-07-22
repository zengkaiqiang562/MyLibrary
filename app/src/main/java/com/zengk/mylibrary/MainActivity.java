package com.zengk.mylibrary;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.zengk.library.component.ComponentHelper;

/**
 * Created by Administrator on 2018\7\19 0019.
 */

public class MainActivity extends Activity {
    ComponentHelper mHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        mHelper = new ComponentHelper(this);
    }

    private void initViews(){
        Button btn = (Button) findViewById(R.id.btn1);
        btn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
//                Intent intent = mHelper.callPhone("10011");
//                startActivity(intent);
                mHelper.sendPhoneMessge("13142023082", "哈哈哈哈ahahahahaha");
            }
        });
    }
}
