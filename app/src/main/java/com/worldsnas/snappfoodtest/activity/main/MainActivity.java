package com.worldsnas.snappfoodtest.activity.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.AppCompatImageButton;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.Toolbar;

import com.worldsnas.snappfoodtest.R;
import com.worldsnas.snappfoodtest.base.BaseDaggerCompatActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.disposables.CompositeDisposable;


public class MainActivity extends BaseDaggerCompatActivity<MainActivityState, MainActivityViewModel> {

    @Inject
    CompositeDisposable mDisposable;
    @BindView(R.id.img_main_logo)
    AppCompatImageView mImgMainLogo;
    @BindView(R.id.img_btn_main_search)
    AppCompatImageButton mImgBtnMainSearch;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.txt_main_search)
    AppCompatTextView TxtMainSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        createViewModel(MainActivityViewModel.class);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        String url = "https://medium.com/square-corner-blog/advocating-against-android-fragments-81fd0b462c97";

        startObserving();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mDisposable.clear();
    }

    @Override
    public void handleState(MainActivityState state) {

    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}
