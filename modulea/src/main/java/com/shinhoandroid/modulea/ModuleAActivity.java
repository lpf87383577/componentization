package com.shinhoandroid.modulea;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.shinhoandroid.baselib.RouterPath;

@Route(path = RouterPath.MALL_A)
public class ModuleAActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module_a);

        //跳转moduleHome
        findViewById(R.id.bt1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 1. 普通跳转
                ARouter.getInstance().build(RouterPath.MALL_HOME).navigation();
            }
        });

        //跳转moduleB
        findViewById(R.id.bt2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 1. 带参数跳转
                ARouter.getInstance().build(RouterPath.MALL_B)
                        .withString("key1","我来自A组件").navigation();
            }
        });
    }
}
