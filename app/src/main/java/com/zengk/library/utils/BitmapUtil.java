package com.zengk.library.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.InputStream;

/**
 * Created by Administrator on 2018\7\24 0024.
 */

public class BitmapUtil {
    /**
     * 将图片的流数据转成Bitmap
     * @param in
     * @return
     */
    public static Bitmap getBitmapFromInputStream(InputStream in){
        Bitmap bitmap = BitmapFactory.decodeStream(in);
        return bitmap;
    }
}
