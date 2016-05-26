package com.example.ddstar.f_rxjava;

import android.net.Uri;

import java.util.List;

/**
 * Created by DDstar on 2016/5/26.
 */
public interface API {
    /**
     * 异步回调
     *
     * @return
     */
    interface CatsQueryCallBack {
        void onCatsListResiver(List<Cat> listCat);

        void onError(Exception e);
    }

    /**
     *
     */
    interface StoreCallBack {
        void oncatResiver(Uri catUri);

        void onError(Exception e);
    }


    //所有猫的列表
    List<Cat> queryCats(String query, CatsQueryCallBack cqCallBack);

    //最可爱的猫的地址
    void store(Cat cat,StoreCallBack  storeCallBack);
}
