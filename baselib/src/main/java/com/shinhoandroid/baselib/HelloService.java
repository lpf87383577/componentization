package com.shinhoandroid.baselib;

import com.alibaba.android.arouter.facade.template.IProvider;

/**
 * @author Liupengfei
 * @describe TODO
 * @date on 2019/7/16 15:21
 */
public interface HelloService extends IProvider {

    void sayHello(String str);
}
