package com.shinhoandroid.modulea;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.shinhoandroid.baselib.BaseFragmentPagerAdapter;
import com.shinhoandroid.baselib.HelloService;
import com.shinhoandroid.baselib.RouterPath;

import java.util.ArrayList;
import java.util.List;

@Route(path = RouterPath.MALL_A)
public class ModuleAActivity extends AppCompatActivity {

    List<Fragment> fragmentList;
    ViewPager vp;

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

        vp = findViewById(R.id.vp);
        fragmentList = new ArrayList<>();

        Fragment fragment = (Fragment)ARouter.getInstance().build(RouterPath.MALL_HOME_fragment).navigation();

        fragmentList.add(fragment);
        BaseFragmentPagerAdapter pagerAdapter = new BaseFragmentPagerAdapter(getSupportFragmentManager(), fragmentList);

        vp.setAdapter(pagerAdapter);

        ARouter.getInstance().navigation(HelloService.class).sayHello("你好");

    }
}
