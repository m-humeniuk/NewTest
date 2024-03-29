package com.example.ngumeniuk.newtest.vrFragment.presenter;

import android.graphics.Bitmap;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.ngumeniuk.newtest.App;
import com.example.ngumeniuk.newtest.vrFragment.model.ResourceBitmapDataSource;
import com.example.ngumeniuk.newtest.vrFragment.view.VrView;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


@InjectViewState
public class VrPresenter extends MvpPresenter<VrView> {

    @Inject
    ResourceBitmapDataSource dataSource;


    public VrPresenter() {
        App.appComponent.inject(this);
    }

    public void loadImage() {
            dataSource.getBitmap()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(getViewState()::showBitmap);
    }

}
