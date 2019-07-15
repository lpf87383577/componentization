package com.shinhoandroid.modulea.alonerun;

import android.app.Application;

import com.shinhoandroid.baselib.RouterConfig;

/**
 * @author Liupengfei
 * @describe TODO
 * @date on 2019/7/15 15:44
 */
public class ModuleAApplication extends Application {


    @Override
    public void onCreate() {
        super.onCreate();
        RouterConfig.init(this,true);
    }
}
