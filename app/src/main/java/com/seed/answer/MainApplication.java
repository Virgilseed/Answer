package com.seed.answer;

import android.app.Application;

import com.tencent.bugly.Bugly;

/**
 * @version V1.0 <描述当前版本功能>
 * @author: ZhangJun
 * @date: 2018/1/22
 * @ChangeLog: <重大改动>
 */


public class MainApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Bugly.init(getApplicationContext(), "a77bf8f5e9", false);
    }
}
