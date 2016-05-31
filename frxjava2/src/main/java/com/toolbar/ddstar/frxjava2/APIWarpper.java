package com.toolbar.ddstar.frxjava2;

import android.net.Uri;

import java.util.List;

/**
 * Created by DDstar on 2016/5/30.
 */
public class APIWarpper {
    API api;

    /**
     * 请求列表的包装方法
     */
    void queryCatList(String catListAds, final CallBack<List<Cat>> listCallBack) {
        api.queryCatList(catListAds, new API.CatsListCallBack() {
            @Override
            public void onResult(List<Cat> catList) {
                listCallBack.onResult(catList);
            }

            @Override
            public void onError(Exception e) {
                listCallBack.onError(e);
            }
        });
    }

    /**
     * 获取最可爱猫的包装方法
     */
    void store(Cat cat, final CallBack<Uri> uriCallBack) {
        api.store(cat, new API.CutestCalCallBack() {
            @Override
            public void onResult(Uri catAds) {
                uriCallBack.onResult(catAds);
            }

            @Override
            public void onError(Exception e) {
                uriCallBack.onError(e);
            }
        });
    }
}
