package com.zengk.library.datastore.xml;

import android.content.Context;
import android.text.TextUtils;
import android.util.Xml;
import android.widget.Toast;

import org.xmlpull.v1.XmlSerializer;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 * Created by Administrator on 2018\7\22 0022.
 */

public class XmlSerializerDemo {
    private void example(Context context ){

        /*
         * <student city="guangzhou">
             <name>李四</name>
             <number>20150832</number>
             <sex>male</sex>
           </student>
         */
        String filename = context.getFilesDir() + "student.xml";
        String name = "李四";
        String number = "20150832";
        String sex = "male";
        try {
            //filename suffix with .xml
            File file = new File(filename);
            XmlSerializer newSerializer = Xml.newSerializer();

            OutputStream out = new FileOutputStream(file);
            newSerializer.setOutput(out, "utf-8");
            newSerializer.startDocument("utf-8", true);

            newSerializer.startTag(null, "student");
            newSerializer.attribute(null, "city", "guangzhou");

            newSerializer.startTag(null, "name");
            newSerializer.text(name);
            newSerializer.endTag(null, "name");

            newSerializer.startTag(null, "number");
            newSerializer.text(number);
            newSerializer.endTag(null, "number");

            newSerializer.startTag(null, "sex");
            newSerializer.text(sex);
            newSerializer.endTag(null, "sex");

            newSerializer.endTag(null, "student");
            newSerializer.endDocument();

            out.close();
            Toast.makeText(context, "保存成功 ", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(context, "保存失败 ", Toast.LENGTH_SHORT).show();
        }
    }
}
