package com.zengk.library.component;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;

/**
 * Created by Administrator on 2018\7\19 0019.
 */

public class ComponentHelper {
    private Activity mActivity;
    private Context mContext;
    private PackageManager mPkgMgr;

    public ComponentHelper(Context context){
        if (context instanceof Activity){
            mActivity = (Activity)context;
        }
        mContext = context;
    }
}
