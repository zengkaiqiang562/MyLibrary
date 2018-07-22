package com.zengk.library.component;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.telephony.SmsManager;

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

    /**
     * 拨打电话的intent
     *
     * note: 1. 配置文件增加权限android.permission.CALL_PHONE
     *       2. 手机上的app在设置中要打开相关权限
     *
     * @param num 要拨打的电话号码
     * @return 返回打电话的intent
     */
    public Intent callPhone(String num){
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel://" + num));
        return intent;
    }

    /**
     * 发短信给指定的号码
     * note: 1. 需要添加权限android.permission.SEND_SMS
     *       2. 手机上的app在设置中要打开相关权限
     * @param address
     * @param message
     */
    public void sendPhoneMessge(String address, String message){
        SmsManager smsMgr = SmsManager.getDefault();
        /**
         destinationAddress :发给谁,
         scAddress : 从哪儿发的
         text : 发的内容
         sentIntent :短信 发送 出去的报告
         deliveryIntent : 对方成功接收到短信的报告
         */
        smsMgr.sendTextMessage(address, null, message, null, null);
    }
}
