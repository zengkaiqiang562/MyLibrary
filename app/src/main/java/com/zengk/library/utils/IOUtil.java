package com.zengk.library.utils;

import android.content.Context;
import android.content.res.AssetManager;

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

    public File getContextFilesDir(){
        File filesDir = mContext.getFilesDir();
        return  filesDir;
    }

    public File getContextCacheDir(){
        File filesDir = mContext.getCacheDir();
        return  filesDir;
    }

    public InputStream getAssets(String filename){
        AssetManager assetMgr = mContext.getAssets();
        InputStream inputStream = null;
        try {
            inputStream = assetMgr.open(filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  inputStream;
    }

}
