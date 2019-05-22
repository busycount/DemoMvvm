package com.busycount.databinding;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;

import com.busycount.databinding.databinding.ActivityMain2Binding;
import com.busycount.databinding.utils.ClickHelper;
import com.busycount.databinding.vm.MyViewModel;

import java.util.Date;

public class Main2Activity extends AppCompatActivity {

    ActivityMain2Binding binding;
    private MyViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main2);
        viewModel = ViewModelProviders.of(this).get(MyViewModel.class);
        viewModel.getProgress().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable Integer integer) {
                binding.setProgress(integer);
            }
        });

        getLifecycle().addObserver(new MyLifeListener());

        binding.setTime(new Date());
        binding.setIsVisible(true);
        binding.setClickHelper(new ClickHelper());
        binding.seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser) {
                    viewModel.getProgress().setValue(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
