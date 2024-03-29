package com.shinhoandroid.modulehome;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.shinhoandroid.baselib.RouterPath;

@Route(path = RouterPath.MALL_HOME)
public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        findViewById(R.id.bt1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 1. 普通跳转
                ARouter.getInstance().build(RouterPath.MALL_A).navigation();
            }
        });

        findViewById(R.id.bt2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 1. 带参数跳转
                ARouter.getInstance().build(RouterPath.MALL_B)
                        .withString("key1","我来自Home组件").navigation();
            }
        });


    }
}
