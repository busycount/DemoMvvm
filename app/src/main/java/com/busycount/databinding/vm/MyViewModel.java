package com.busycount.databinding.vm;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

/**
 * MyViewModel
 * <p>
 * 2019/1/6 | Count.C | Created
 */
public class MyViewModel extends ViewModel {

    private MutableLiveData<Integer> progress = new MutableLiveData<>();


    public MutableLiveData<Integer> getProgress() {
        return progress;
    }
}
