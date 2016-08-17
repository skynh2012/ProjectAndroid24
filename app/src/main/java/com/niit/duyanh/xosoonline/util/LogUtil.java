package com.niit.duyanh.xosoonline.util;

import android.util.Log;

import com.niit.duyanh.xosoonline.common.Common;

/**
 * Created by DuyAnh on 07/08/2016.
 */
public class LogUtil {

    /**
     * Log.d debug
     *
     * @param tag
     * @param message
     */
    public static void LogD(String tag, String message) {
        if (Common.isDebug) {
            Log.d(tag, message);
        }
    }

    /**
     * Log.e debug
     *
     * @param tag
     * @param message
     */
    public static void LogE(String tag, String message) {
        if (Common.isDebug) {
            Log.e(tag, message);
        }
    }
}
