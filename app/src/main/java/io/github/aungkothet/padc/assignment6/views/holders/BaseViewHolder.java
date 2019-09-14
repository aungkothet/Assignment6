package io.github.aungkothet.padc.assignment6.views.holders;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public abstract class BaseViewHolder<T> extends RecyclerView.ViewHolder {

    protected T mData;// T is generic DataType which must bind data to the view holder

    public abstract void bindData(T data);

    public BaseViewHolder(@NonNull View itemView) {
        super(itemView);
    }
}
