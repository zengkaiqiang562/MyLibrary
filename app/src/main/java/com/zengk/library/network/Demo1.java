package com.zengk.library.network;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Message;
import android.view.View;

import com.zengk.library.utils.IOUtil;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Administrator on 2018\7\24 0024.
 */

public class Demo1 extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    /*
     * 通过抓包工具可以获取http网络请求以及响应的格式数据
     * HttpURLConnection中对相应的属性数据有封装好接口以供调用
     *      conn.setRequestMethod("GET");
     *      conn.setConnectTimeout(5000);
     *      conn.getContentLength();
     *      conn.getContentType();
     *      conn.setRequestProperty(String field, String newValue);
     *      conn.getHeaderField
     */

    /**
     * 获取网络图片的基础代码，不用开源框架实现
     */
    public void getNetWorkPic(){

        final String path = "http://www.itheima.com/uploads/2015/08/198x57.png";

        new Thread(){

            public void run() {

                try {

                    //构建一个 url对象的实例
                    URL url = new URL(path);

                    //使用当前的url 与服务器建立  器连接
                    HttpURLConnection conn =  (HttpURLConnection) url.openConnection();

                    //设置请求的方式
                    conn.setRequestMethod("GET");

                    //设置 超时的 时间 为 5 秒
                    conn.setConnectTimeout(5000);

                    // 200, 302 , 304, 404, 500
                    int code = conn.getResponseCode();

                    //拿到 服务器 返回的数据的 长度
                    int length = conn.getContentLength();  //
                    //有图片类型image/png, 文本类型text/html，等
                    String type = conn.getContentType();    //  数据类型 image/png

                    System.out.println("length :"+ length);
                    System.out.println("type :"+ type);

                    if(code==200){
                        //进来则表示 , 成功的 接受到了服务器的 响应的数据,  服务器 响应成功

                        //这个 in 就代表着 返回的 图片数据
                        InputStream in = conn.getInputStream();

                        Bitmap bitmap = BitmapFactory.decodeStream(in);

                        //通过handler在UI线程更新图片显示
                    }else{
                        //进来 的话,则说明网络连接 不好使, Handler发一个消息, 通知 主线程 给用户 提示
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            };

        }.start();
    }


    /**
     * 获取网页的html文本的源代码内容
     * @param
     */
    public void getNetWorkHtmlContent(View v){
        final String path = "http://www.maizuo.com";

        new Thread(){
            public void run() {

                try {
                    URL url = new URL(path);

                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();

                    //get方式请求
                    conn.setRequestMethod("GET");

                    //设置请求属性，告诉服务器获取pc机的html源码
                    //User-Agent: Mozilla/5.0 (compatible; MSIE 10.0; Windows NT 6.2; WOW64; Trident/6.0)
                    conn.setRequestProperty("User-Agent", "Mozilla/5.0 (compatible; MSIE 10.0; Windows NT 6.2; WOW64; Trident/6.0)");

                    //超时 时间
                    conn.setConnectTimeout(5000);

                    int code = conn.getResponseCode();

                    String type = conn.getContentType();
                    System.out.println("type :" + type);

                    if(code==200){

                        InputStream in = conn.getInputStream();

                        //将 流的数据 转换成 字符数据
                        //自己 动手 弄
                        String value = IOUtil.decodeStream(in);

                        //使用handler通知UI线程更新显示
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            };

        }.start();
    }
}

