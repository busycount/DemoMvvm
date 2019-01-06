package com.busycount.databinding;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import com.busycount.databinding.bean.Data;
import com.busycount.databinding.databinding.ActivityMainBinding;
import com.busycount.databinding.rv.CommonAdapter;
import com.busycount.databinding.rv.RvItemClick;
import com.busycount.databinding.utils.Utils;
import com.busycount.keyboard.OnNumKeyListener;
import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    CommonAdapter<String> adapter;
    CommonAdapter<Data.DataBean.DatasBean.SkuMapBean.ColourSkuVoListBean.SkuVoListBean> adapterDetail;
    Data.DataBean.DatasBean.SkuMapBean skuMapBean;
    Data.DataBean.DatasBean.SkuMapBean.ColourSkuVoListBean colourSkuVoListBean;
    Data.DataBean.DatasBean.SkuMapBean.ColourSkuVoListBean.SkuVoListBean skuVoListBean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        initData();
        configRv();
        configDetail();
        configNum();
    }

    private StringBuilder sb = new StringBuilder();

    private void configNum() {
        binding.include2.numKeyBoard.setOnNumKeyListener(new OnNumKeyListener() {
            @Override
            public void onKeyNum(char c) {
                if (skuVoListBean != null) {
                    sb.append(c);
                    skuVoListBean.setAddNum(Integer.valueOf(sb.toString()));
                }
            }

            @Override
            public void onKeyDelete() {
                sb.setLength(0);
                if (skuVoListBean != null) {
                    skuVoListBean.setAddNum(0);
                }
            }

            @Override
            public void onKeyDone() {
                if (skuVoListBean != null) {
                    int length = sb.length();
                    if (length > 1) {
                        sb.setLength(sb.length() - 1);
                        skuVoListBean.setAddNum(Integer.valueOf(sb.toString()));
                    } else {
                        sb.setLength(0);
                        skuVoListBean.setAddNum(0);
                    }
                }
            }
        });
    }

    private void initData() {
        Data data = new Gson().fromJson(Utils.getData(this), Data.class);
        skuMapBean = data.getData().getDatas().get(0).getSkuMap();
        colourSkuVoListBean = skuMapBean.getColourSkuVoList().get(0);
    }

    private void configRv() {
        adapter = new CommonAdapter<>(skuMapBean.getColourSet(), R.layout.item1, BR.str, new RvItemClick<String>() {
            @Override
            public void onClicked(String s) {
                int index = skuMapBean.getColourSet().indexOf(s);
                if (index != -1) {
                    colourSkuVoListBean = skuMapBean.getColourSkuVoList().get(index);
                    adapterDetail.update(colourSkuVoListBean.getSkuVoList());
                }
            }
        });
        binding.rvList.setLayoutManager(new LinearLayoutManager(this));
        binding.rvList.setAdapter(adapter);
    }

    private void configDetail() {
        adapterDetail = new CommonAdapter<>(colourSkuVoListBean.getSkuVoList(), R.layout.item2, BR.skuVoListBean, new RvItemClick<Data.DataBean.DatasBean.SkuMapBean.ColourSkuVoListBean.SkuVoListBean>() {
            @Override
            public void onClicked(Data.DataBean.DatasBean.SkuMapBean.ColourSkuVoListBean.SkuVoListBean skuVoListBean) {
                configSale(skuVoListBean);
            }
        });
        binding.include.rvDetail.setLayoutManager(new LinearLayoutManager(this));
        binding.include.rvDetail.setAdapter(adapterDetail);
    }

    private void configSale(Data.DataBean.DatasBean.SkuMapBean.ColourSkuVoListBean.SkuVoListBean skuVoListBean) {
        this.skuVoListBean = skuVoListBean;
        binding.include2.setSkuVoListBean1(skuVoListBean);
    }
}
