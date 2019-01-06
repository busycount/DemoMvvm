package com.busycount.databinding.utils;

import android.databinding.BindingConversion;
import android.view.View;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * BindingHelper
 * <p>
 * 2019/1/6 | Count.C | Created
 */
public class BindingHelper {

//    @BindingAdapter("bind:image")
//    public static void loadImage(ImageView imageView, String url) {
    //Glide.with(context).load(url).into(imageView);
//    }

    public static int visible(boolean isVisible) {
        return isVisible ? View.VISIBLE : View.GONE;
    }

    @BindingConversion
    public static String convertDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(date);
    }

}
