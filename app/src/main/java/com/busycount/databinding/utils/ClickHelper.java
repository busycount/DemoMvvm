package com.busycount.databinding.utils;

import android.util.Log;
import android.view.View;

/**
 * ClickHelper
 * <p>
 * 2019/1/6 | Count.C | Created
 */
public class ClickHelper {
    private static final String TAG = "ClickHelper";

    public void onClick(View view) {
        Log.d(TAG, "onClick: " + view.getId());
    }
}
