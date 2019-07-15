package com.shinhoandroid.test0715;

import android.app.Application;

import com.shinhoandroid.baselib.RouterConfig;

/**
 * @author Liupengfei
 * @describe TODO
 * @date on 2019/7/15 14:55
 */
public class MyApplication extends Application {

    private static MyApplication myApplication;
    //初始化
    public static MyApplication getAppInstance() {
        return myApplication;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        myApplication = this ;
        RouterConfig.init(this,true);
    }
}
