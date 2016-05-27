package com.example.ddstar.f_rxjava;

import android.net.Uri;

import java.util.List;

/**
 * Created by DDstar on 2016/5/27.
 */
public class APIWrapper1 {
    API api;

    public AsyncJob<List<Cat>> queryCats(final String query) {
        return new AsyncJob<List<Cat>>() {
            @Override
            public void start(final CallBack<List<Cat>> callBack) {
                api.queryCats(query, new API.CatsQueryCallBack() {
                    @Override
                    public void onCatsListResiver(List<Cat> listCat) {
                        callBack.onResult(listCat);
                    }

                    @Override
                    public void onError(Exception e) {
                        callBack.onError(e);
                    }
                });
            }
        };
    }

    public AsyncJob<Uri> store(final Cat cat) {
        return new AsyncJob<Uri>() {
            @Override
            public void start(final CallBack<Uri> callBack) {
                api.store(cat, new API.StoreCallBack() {
                    @Override
                    public void oncatResiver(Uri catUri) {
                        callBack.onResult(catUri);
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
