package com.zengk.library.utils;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

/**
 * Created by pc on 18-7-19.
 */

public class FormatUtil {


    /**
     * 将字节数组转成16进制的字符串
     * @param data
     * @return
     */
    public static String buildHexString(byte[] data) {
        if (data == null || data.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < data.length; i++) {
            sb.append(String.format("%02x", data[i]).toUpperCase());
            if (i != data.length - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    /**
     * 格式化小数，保存指定有效数字
     * @param dnum
     * @return
     */
    public String formatFloat(double dnum){
        //e.g: dnum=1.456463434  -> str=1.45
        DecimalFormat decimalFormat = new DecimalFormat("#0.00" , new DecimalFormatSymbols(Locale.ENGLISH));
        String str = decimalFormat.format(dnum);
        return str;
    }
}
