package com.zengk.library.json;

import android.app.Activity;

import com.zengk.library.utils.IOUtil;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Administrator on 2018\7\25 0025.
 */

public class Demo1 extends Activity {

    private void parseJson(){
        InputStream inputStream = IOUtil.getAssets(this, "src/main/assets/tianqi.txt");
        try {
            String strJson = IOUtil.decodeStreamToString(inputStream, null);
            JSONObject obj = new JSONObject(strJson);

            String descValue = obj.getString("desc");
            if("OK".equals(descValue)){

                JSONObject dataObj = obj.getJSONObject("data");

                //获得 预报的  json数组
                JSONArray forcastArray = dataObj.getJSONArray("forecast");
//				String vl1 = forcastArray.getString(0);

            }
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
