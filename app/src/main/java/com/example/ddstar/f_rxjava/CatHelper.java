package com.example.ddstar.f_rxjava;

import android.net.Uri;

import java.util.Collections;
import java.util.List;

/**
 * Created by DDstar on 2016/5/26.
 */
public class CatHelper {

    public interface CutestCatCallBack {
        void onCatSaveSuccess(Uri uriAds);

        void onError(Exception e);
    }
    API api;
    APIWrapper apiWarpper;
    public void saveCutestCAt(String query, final CallBack<Uri> callBack){
        apiWarpper.queryCats(query, new CallBack<List<Cat>>() {
            @Override
            public void onResult(List<Cat> result) {
                Cat cutestCat = findCutestCat(result);
                apiWarpper.store(cutestCat,callBack);
            }

            @Override
            public void onError(Exception e) {
                callBack.onError(e);
            }
        });
    }

//    public void saveCutestCAt(String query, final CutestCatCallBack ccCallback) {
//        //异步请求，获取猫列表
//        List<Cat> catList = api.queryCats(query, new API.CatsQueryCallBack() {
//            @Override
//            public void onCatsListResiver(List<Cat> listCat) {
//                Cat cutestCat = findCutestCat(listCat);
//                 api.store(cutestCat, new API.StoreCallBack() {
//                    @Override
//                    public void oncatResiver(Uri catUri) {
//                        ccCallback.onCatSaveSuccess(catUri);
//                    }
//
//                    @Override
//                    public void onError(Exception e) {
//                        ccCallback.onError(e);
//                    }
//                });
//
//            }
//
//            @Override
//            public void onError(Exception e) {
//                ccCallback.onError(e);
//            }
//        });
//    }

    //找到最可爱的猫
    private Cat findCutestCat(List<Cat> catList) {
        return Collections.max(catList);
    }
}
