package com.shinhoandroid.modulehome;

import android.content.Context;
import android.util.Log;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.shinhoandroid.baselib.HelloService;

/**
 * @author Liupengfei
 * @describe TODO
 * @date on 2019/7/16 15:23
 */

@Route(path = "/home/hello")
public class HelloSay implements HelloService {

    @Override
    public void sayHello(String str) {
        Log.e("lpf--",str);
    }

    @Override
    public void init(Context context) {

    }
}
