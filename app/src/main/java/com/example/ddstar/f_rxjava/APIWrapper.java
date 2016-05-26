package com.example.ddstar.f_rxjava;

import android.net.Uri;

import java.util.List;

/**
 * Created by DDstar on 2016/5/26.
 */
public class APIWrapper {
    API api;
    public void queryCats(String query, final CallBack<List<Cat>> callBack){
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
    public void store(Cat cat, final CallBack<Uri> callBack){
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
}
