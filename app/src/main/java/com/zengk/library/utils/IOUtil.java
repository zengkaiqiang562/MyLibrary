package com.zengk.library.utils;

import android.content.Context;
import android.content.res.AssetManager;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Administrator on 2018\7\22 0022.
 */

public class IOUtil {
    private static final String TAG = IOUtil.class.getSimpleName();

    private Context mContext;
    public IOUtil(Context context){
        mContext = context;
    }

    public static File getContextFilesDir(Context context){
        File filesDir = context.getFilesDir();
        return  filesDir;
    }

    public static File getContextCacheDir(Context context){
        File filesDir = context.getCacheDir();
        return  filesDir;
    }

    public static InputStream getAssets(Context context, String filename){
        AssetManager assetMgr = context.getAssets();
        InputStream inputStream = null;
        try {
            inputStream = assetMgr.open(filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  inputStream;
    }

    /**
     * 用于将一个 流的数据 转换成字符串返回
     * @param in
     * @return
     * @throws IOException
     */
    public static String decodeStreamToString(InputStream in, String charsetName) throws IOException {

        //底层流
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        int len=0;
        byte[] buf = new byte[1024];
        while((len=in.read(buf))>0){
            baos.write(buf, 0, len);
        }

        baos.close();
        //返回字符数据
        //toString(String charsetName),如果inputStream流为文本数据，并且乱码时，调toString时可设置编码格式
        return charsetName == null ? baos.toString() : baos.toString(charsetName);
    }

}
