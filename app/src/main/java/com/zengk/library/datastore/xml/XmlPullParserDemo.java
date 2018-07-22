package com.zengk.library.datastore.xml;

import android.content.Context;
import android.util.Log;
import android.util.Xml;
import android.widget.Toast;

import org.xmlpull.v1.XmlPullParser;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * Created by Administrator on 2018\7\22 0022.
 */

public class XmlPullParserDemo {

    public void example(Context context){
        /*
         *
        <student city="guangzhou">
            <name>李四</name>
            <number>20150832</number>
            <sex>male</sex>
        </student>

         *
         */
        String filename = context.getFilesDir() + "student.xml";
        File file = new File(filename);

        if(file==null||file.length()<=0){
            Toast.makeText(context, "要查询的学生的姓名 不存在 ", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            XmlPullParser parser =  Xml.newPullParser();
            InputStream in = new FileInputStream(file);
            parser.setInput(in, "UTF-8");

            int type = parser.getEventType();

            String cityValue = null;
            String nameValue = null;
            String number = null;
            String sex = null;
            while(type!=XmlPullParser.END_DOCUMENT){

                if(XmlPullParser.START_TAG==type){
                    if("student".equals(parser.getName())){
                        int count = parser.getAttributeCount();
                        if(count>0){
                            cityValue = parser.getAttributeValue(0);
                        }
                    }else if("name".equals(parser.getName())){
                        nameValue = parser.nextText();
                    }else if("number".equals(parser.getName())){
                        number = parser.nextText();
                    }else if("sex".equals(parser.getName())){
                        sex = parser.nextText();
                    }
                }
                type=parser.next();
            }
            Log.d("zkq", nameValue+" "+number +" "+sex+" "+cityValue);

        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(context, "解析失败  ", Toast.LENGTH_SHORT).show();
        }
    }
}
