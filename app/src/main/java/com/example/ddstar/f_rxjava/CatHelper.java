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
    APIWrapper1 apiWrapper1;

    public AsyncJob<Uri> saveCutsetCat(final String query) {
        //调用Api建立获取猫的列表的任务
        final AsyncJob<List<Cat>> catListJob = apiWrapper1.queryCats(query);
        //新建获取最可爱的猫的任务
        final AsyncJob<Cat> cutestCatJob = new AsyncJob<Cat>() {
            @Override
            public void start(final CallBack callBack) {
                //在启动寻找最可爱的猫的任务时启动获取猫的列表
                catListJob.start(new CallBack<List<Cat>>() {
                    @Override
                    public void onResult(List<Cat> result) {
                        //获取到猫列表以后调用寻找最可爱猫的方法，
                        // 将结果返回给获取最可爱的猫的回调
                        callBack.onResult(findCutestCat(result));
                    }

                    @Override
                    public void onError(Exception e) {
                        callBack.onError(e);
                    }
                });
            }
        };
        //新建获取最可爱猫的地址的任务
        AsyncJob<Uri> catUriJob = new AsyncJob<Uri>() {
            @Override
            public void start(final CallBack<Uri> callBack) {
                //在启动寻找最可爱的猫地址时
                // 启动寻找最可爱的猫的任务
                //并等待回调
                cutestCatJob.start(new CallBack<Cat>() {
                    @Override
                    public void onResult(Cat result) {
                        //获取到最可爱的猫对象时调用Api方法获取最可爱猫的地址
                        apiWrapper1.store(result).start(new CallBack<Uri>() {
                            @Override
                            public void onResult(Uri result) {
                                callBack.onResult(result);
                            }

                            @Override
                            public void onError(Exception e) {
                                callBack.onError(e);
                            }
                        });
                    }

                    @Override
                    public void onError(Exception e) {
                        callBack.onError(e);
                    }
                });

            }
        };
        return  catUriJob;
    }

//    public AsyncJob<Uri> saveCutsetCat(final String query) {
//        return new AsyncJob<Uri>() {
//            @Override
//            public void start(final CallBack<Uri> callBack) {
//                apiWrapper1.queryCats(query).start(new CallBack<List<Cat>>() {
//                    @Override
//                    public void onResult(List<Cat> result) {
//                        Cat cutestCat = findCutestCat(result);
//                        apiWrapper1.store(cutestCat).start(new CallBack<Uri>() {
//                            @Override
//                            public void onResult(Uri result) {
//                                callBack.onResult(result);
//                            }
//
//                            @Override
//                            public void onError(Exception e) {
//                                callBack.onError(e);
//                            }
//                        });
//                    }
//
//                    @Override
//                    public void onError(Exception e) {
//                        callBack.onError(e);
//                    }
//                });
//            }
//        };
//    }

//    public void saveCutestCAt(String query, final CallBack<Uri> callBack){
//        apiWarpper.queryCats(query, new CallBack<List<Cat>>() {
//            @Override
//            public void onResult(List<Cat> result) {
//                Cat cutestCat = findCutestCat(result);
//                apiWarpper.store(cutestCat,callBack);
//            }
//
//            @Override
//            public void onError(Exception e) {
//                callBack.onError(e);
//            }
//        });
//    }

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
