package com.busycount.databinding;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.util.Log;

/**
 * MyLifeListener
 * <p>
 * 2019/5/22 | Count.C | Created
 */
public class MyLifeListener implements LifecycleObserver {

    private static final String TAG = MyLifeListener.class.getSimpleName();

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onStart() {
        Log.d(TAG, "onStart: ");
    }


    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onStop() {
        Log.d(TAG, "onStop: ");
    }
}
