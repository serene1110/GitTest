package com.example.eventbustest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;

public class Main2Activity extends AppCompatActivity {
    private Button bt_main2_1;
    private Button bt_main2_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        bt_main2_1 = findViewById(R.id.bt_main2_1);
        bt_main2_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().post(new MessageEvent("更改后的文本信息1"));
                finish();
            }
        });

        bt_main2_2 = findViewById(R.id.bt_main2_2);
        bt_main2_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().post(new MessageEvent("更改后的文本信息2"));
                finish();
            }
        });
    }
}
