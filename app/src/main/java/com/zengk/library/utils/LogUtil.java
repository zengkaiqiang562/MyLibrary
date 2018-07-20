package com.zengk.library.utils;

import android.util.Log;

/**
 * Created by pc on 18-7-19.
 */

public class LogUtil {
    public static void logd(String tag, String msg) {
        Log.d(tag, msg);
    }

    public static void logi(String tag, String msg) {
        Log.i(tag, msg);
    }

    public static void logw(String tag, String msg) {
        Log.w(tag, msg);
    }

    public static void loge(String tag, String msg) {
        Log.e(tag, msg);
    }
}
