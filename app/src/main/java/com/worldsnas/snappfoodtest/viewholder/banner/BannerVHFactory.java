package com.worldsnas.snappfoodtest.viewholder.banner;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.worldsnas.snappfoodtest.R;
import com.worldsnas.snappfoodtest.base.ViewHolderFactory;

import javax.inject.Inject;

public class BannerVHFactory implements ViewHolderFactory<BannerVH>{

    @Inject
    BannerVHFactory() {
    }

    @Override
    public BannerVH create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_banner, parent, false);
        return new BannerVH(view, new BannerVM());
    }
}
