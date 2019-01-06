package com.busycount.databinding.rv;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

/**
 * CommonAdapter
 * <p>
 * 2019/1/5 | Count.C | Created
 */
public class CommonAdapter<T> extends RecyclerView.Adapter<ViewHolder> {

    private RvItemClick<T> rvItemClick;

    private List<T> mDatas;

    private int layoutId;

    private int brId;

    public CommonAdapter(List<T> mDatas, int layoutId, int brId) {
        this.mDatas = mDatas;
        this.layoutId = layoutId;
        this.brId = brId;
    }

    public CommonAdapter(List<T> mDatas, int layoutId, int brId, RvItemClick<T> rvItemClick) {
        this.mDatas = mDatas;
        this.layoutId = layoutId;
        this.brId = brId;
        this.rvItemClick = rvItemClick;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        ViewDataBinding binding = DataBindingUtil.inflate(inflater, layoutId, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(binding.getRoot());
        viewHolder.setBinding(binding);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.getBinding().setVariable(brId, mDatas.get(i));
        viewHolder.getBinding().executePendingBindings();//防止闪烁
        if (rvItemClick != null) {
            viewHolder.bindClick(rvItemClick);
        }
    }


    @Override
    public int getItemCount() {
        return mDatas == null ? 0 : mDatas.size();
    }

    public void update(List<T> mDatas) {
        this.mDatas = mDatas;
        notifyDataSetChanged();
    }
}
