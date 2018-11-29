package com.example.eventbustest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;


/*
没有区分不同的message，待补充……
 */
public class MainActivity extends AppCompatActivity {

    private Button button;
    private TextView tv_main_1;
    private TextView tv_main_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //注册EventBus
        EventBus.getDefault().register(this);

        button = findViewById(R.id.button);
        tv_main_1 = findViewById(R.id.tv_main_1);
        tv_main_2 = findViewById(R.id.tv_main_2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);
            }
        });

    }

    //在这里处理事件，处理消息的方法名字可以随便取。
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void Event1(MessageEvent messageEvent){
        tv_main_1.setText(messageEvent.getMessage());
        tv_main_2.setText(messageEvent.getMessage());
    }

    //在这里处理事件，处理消息的方法名字可以随便取。
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void Event2(MessageEvent messageEvent){
        tv_main_1.setText(messageEvent.getMessage());
        tv_main_2.setText(messageEvent.getMessage());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        //解注册EventBus
        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }
    }
}
