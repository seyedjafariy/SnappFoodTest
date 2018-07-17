package com.worldsnas.snappfoodtest.viewholder.banner;

import android.view.View;

import com.worldsnas.snappfoodtest.base.BaseViewHolder;
import com.worldsnas.snappfoodtest.servermodel.BaseModel;
import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.ButterKnife;
import io.reactivex.subjects.PublishSubject;

public class BannerVH extends BaseViewHolder<BannerVHAction, BaseModel, BannerVM> {

//    @BindView(R.id.drawee_row_banner)
    SimpleDraweeView mDraweeRowBanner;

    public BannerVH(View itemView, BannerVM viewModel) {
        super(itemView, viewModel);
        ButterKnife.bind(this, itemView);
    }

    @Override
    public void bind() {

    }

    @Override
    public void itemOnClick(PublishSubject<BannerVHAction> actionSubject) {

    }
}
