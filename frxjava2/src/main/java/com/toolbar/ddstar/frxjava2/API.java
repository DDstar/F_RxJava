package com.toolbar.ddstar.frxjava2;

import android.net.Uri;

import java.util.List;

/**
 * Created by DDstar on 2016/5/30.
 */
public interface API {
    public interface CatsListCallBack {
        void onResult(List<Cat> catList);

        void onError(Exception e);
    }

    public interface CutestCalCallBack {
        void onResult(Uri catAds);

        void onError(Exception e);
    }


    /**
     * 获取猫的列表
     *
     * @param serveAsd
     * @return
     */
    void queryCatList(String serveAsd, CatsListCallBack catsListCallBack);
//    List<Cat> queryCatList(String serveAsd,CatsListCallBack catsListCallBack);

    /**
     * 获取最可爱的猫的地址
     *
     * @param cat
     * @return
     */
    void store(Cat cat,CutestCalCallBack cutestCalCallBack);
//    Uri store(Cat cat);
}
