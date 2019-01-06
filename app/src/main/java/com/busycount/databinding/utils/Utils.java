package com.busycount.databinding.utils;

import android.content.Context;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * Utils
 * <p>
 * 2019/1/5 | Count.C | Created
 */
public class Utils {

    public static String getData(Context context) {
        InputStream input = null;
        try {
            input = context.getAssets().open("getPage.json");
            return convertStreamToString(input);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    private static String convertStreamToString(java.io.InputStream is) {
        String s = null;
        try {
            Scanner scanner = new Scanner(is, "UTF-8").useDelimiter("\\A");
            if (scanner.hasNext()) {
                s = scanner.next();
            }
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return s;
    }

}
