package com.worldsnas.snappfoodtest.base;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

public interface ViewHolderFactory<V extends BaseViewHolder> {
    V create(ViewGroup parent);
}
