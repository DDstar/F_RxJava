package com.toolbar.ddstar.frxjava2;

import android.net.Uri;

import java.util.List;

/**
 * Created by DDstar on 2016/5/30.
 */
public class APIWrapper1 {
    API api;

    /**
     * 获取猫的列表
     */
    public AsyncJob<List<Cat>> queryCatList(final String catListPath) {
        return new AsyncJob<List<Cat>>() {
            @Override
            public void start(final CallBack<List<Cat>> callBack) {
                api.queryCatList(catListPath, new API.CatsListCallBack() {
                    @Override
                    public void onResult(List<Cat> catList) {
                        callBack.onResult(catList);
                    }

                    @Override
                    public void onError(Exception e) {
                        callBack.onError(e);
                    }
                });
            }
        };
    }

    /**
     * 获取最可爱的猫的地址
     */
    public AsyncJob<Uri> store(final Cat cat) {
        return new AsyncJob<Uri>() {
            @Override
            public void start(final CallBack<Uri> callBack) {
                api.store(cat, new API.CutestCalCallBack() {
                    @Override
                    public void onResult(Uri catAds) {
                        callBack.onResult(catAds);
                    }

                    @Override
                    public void onError(Exception e) {
                        callBack.onError(e);
                    }
                });
            }
        };
    }

}
