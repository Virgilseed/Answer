package com.seed.answer.utils;

import android.util.Log;

import com.seed.answer.BuildConfig;

/**
 * Created by Administrator on 2016/7/18 0018.
 */
public class LogUtil {

    private LogUtil(){}

    private static LogUtil logUtil;

    public static void log_i(String tag, String content){
        if(BuildConfig.DEBUG){
            Log.i(tag,content);
        }
    }

    public static void log_e(String tag, String content){
        if(BuildConfig.DEBUG){
            Log.e(tag,content);
        }
    }

    public static void log_d(String tag, String content){
        if(BuildConfig.DEBUG){
            Log.d(tag,content);
        }
    }

}
