package com.zengk.library.dialog;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.SystemClock;
import android.view.View;
import android.widget.Toast;

/**
 * Created by Administrator on 2018\7\22 0022.
 */

public class NormalDialog {
    //普通对话框
    public void create01(final Context context){

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("确认删除");
        builder.setMessage("亲, 您确定要删除吗? 不能返回的");

        //设置点击确认的要干的事儿
        builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {

                Toast.makeText(context, "您点击了确认", Toast.LENGTH_SHORT).show();

            }
        });

        //设置点击取消 的要干的事儿
        builder.setNegativeButton("取消", null);

//		AlertDialog dialog = builder.create();
//		dialog.show();

        // 这样才可以 显示  对话框
        builder.show();

    }

    //单选对话框
    public void create02(final Context context){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        final String[] items ={"玩毛线","弹棉花","打dota","夜生活"};
        builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {

                Toast.makeText(context, items[which]+"被点中了  ... 是 第 : " + which +"个", Toast.LENGTH_SHORT).show();
            }
        });

        //显示对话框
        builder.show();
    }

    String[] items = {"深圳","广州","惠州","佛山","中山"};
    boolean[] checkedItems ={true,true,false,false,false};
    //多选对话框
    public void create03(final Context context){

        AlertDialog.Builder builder = new AlertDialog.Builder(context);

        builder.setMultiChoiceItems(items, checkedItems, new DialogInterface.OnMultiChoiceClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {

                Toast.makeText(context, "选中了  :" +items[which]+", 状态是  : " + isChecked , Toast.LENGTH_SHORT).show();
                checkedItems[which]=isChecked;
            }
        });

        builder.show();

    }

    //无实时进度的对话框
    public void create04(Context context){

        final ProgressDialog dialog = ProgressDialog.show(context, null, "姐们,正在拼命 加载中....");

        //让 在子线程中睡    3 秒钟

        new Thread(){

            public void run() {

                SystemClock.sleep(3000);

                dialog.dismiss();

            };

        }.start();

    }

    //有实时进度的对话框
    public void create05(Context context){

    }
}
