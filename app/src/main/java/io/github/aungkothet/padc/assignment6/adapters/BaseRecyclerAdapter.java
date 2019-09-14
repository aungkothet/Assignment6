package io.github.aungkothet.padc.assignment6.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import io.github.aungkothet.padc.assignment6.views.holders.BaseViewHolder;


public abstract class BaseRecyclerAdapter<T extends BaseViewHolder<W>, W> extends RecyclerView.Adapter<T> {

    //why abstract? ==> we don't need to create any object about this class. Just need it's working flow.
    // T is generic data type for BaseViewHolder Type

    private List<W> mData; // W is generic Data Type for Binding data to viewHolder

    BaseRecyclerAdapter(){
        mData = new ArrayList<>();
    }

    @Override
    public int getItemCount() {
        return  mData.size();
    }

    @Override
    public void onBindViewHolder(@NonNull T viewHolder, int position) {
        viewHolder.bindData(mData.get(position));
    }

    public void setViewData(List<W> data){
        this.mData = data;
        notifyDataSetChanged();
    }

}