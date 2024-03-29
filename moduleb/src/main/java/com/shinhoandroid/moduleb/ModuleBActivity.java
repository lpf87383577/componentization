package com.shinhoandroid.moduleb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.shinhoandroid.baselib.RouterPath;

@Route(path = RouterPath.MALL_B)
public class ModuleBActivity extends AppCompatActivity {

    @Autowired()
    public String key1;

    @Autowired(name = "key1")
    public String data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module_b);
        ARouter.getInstance().inject(this);

        String str = getIntent().getExtras().getString("key1");

        Log.e("lpf--000---",key1);
        Log.e("lpf--111---",data);
        Log.e("lpf--222---",str);
        //跳转moduleHome
        findViewById(R.id.bt1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 1. 普通跳转
                ARouter.getInstance().build(RouterPath.MALL_HOME).navigation();
            }
        });

        //跳转moduleA
        findViewById(R.id.bt2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 1. 带参数跳转
                ARouter.getInstance().build(RouterPath.MALL_A).navigation();

            }
        });
    }
}
