package com.busycount.databinding.rv;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.busycount.databinding.BR;

/**
 * ViewHolder
 * <p>
 * 2019/1/5 | Count.C | Created
 */

public class ViewHolder extends RecyclerView.ViewHolder {

    private ViewDataBinding binding;

    public ViewDataBinding getBinding() {
        return binding;
    }

    public void bindClick(RvItemClick rvItemClick){
        binding.setVariable(BR.rvItemClick, rvItemClick);
    }

    public void setBinding(ViewDataBinding binding) {
        this.binding = binding;
    }

    public ViewHolder(View itemView) {
        super(itemView);
    }

}