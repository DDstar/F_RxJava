package com.toolbar.ddstar.frxjava2;

import android.net.Uri;

import java.util.Collections;
import java.util.List;

/**
 * Created by DDstar on 2016/5/30.
 */
public class CatHelper {
    public interface CutestCallBack {
        void onResult(Uri cutestCatAds);

        void onError(Exception e);
    }


    APIWrapper1 apiWrapper1;

    public AsyncJob<Uri> saveCuestCat(final String catsListPath) {
        AsyncJob<List<Cat>> listAsyncJob = apiWrapper1.queryCatList(catsListPath);
        final AsyncJob<Cat> catAsyncJob = listAsyncJob.map(new FunTR<List<Cat>, Cat>() {
            @Override
            public Cat funCall(List<Cat> catList) {
                Cat cutestCat = findCutestCat(catList);
                return cutestCat;
            }
        });

        AsyncJob<Uri> uriAsyncJob =catAsyncJob.flatMap(new FunTR<Cat, AsyncJob<Uri>>() {
            @Override
            public AsyncJob<Uri> funCall(Cat cat) {
                return apiWrapper1.store(cat);
            }
        });
//        AsyncJob<List<Uri>> uriAsyncJob = catAsyncJob.map(new FunTR<Cat, AsyncJob<Uri>>() {
//            @Override
//            public AsyncJob<Uri> funCall(Cat cat) {
//                return apiWrapper1.store(cat);
//            }
//        });
        return uriAsyncJob;
//        AsyncJob<Uri> uriAsyncJob = new AsyncJob<Uri>() {
//            @Override
//            public void start(final CallBack<Uri> callBack) {
//                catAsyncJob.start(new CallBack<Cat>() {
//                    @Override
//                    public void onResult(Cat cat) {
//                        apiWrapper1.store(cat).start(new CallBack<Uri>() {
//                            @Override
//                            public void onResult(Uri uri) {
//                                callBack.onResult(uri);
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
//        return uriAsyncJob;
    }
//    public AsyncJob<Uri> saveCuestCat(final String catsListPath) {
//        final AsyncJob<List<Cat>> listAsyncJob = apiWrapper1.queryCatList(catsListPath);
//        final AsyncJob<Cat> catAsyncJob = new AsyncJob<Cat>() {
//            @Override
//            public void start(final CallBack<Cat> callBack) {
//                listAsyncJob.start(new CallBack<List<Cat>>() {
//                    @Override
//                    public void onResult(List<Cat> catList) {
//                        Cat cutestCat = findCutestCat(catList);
//                        callBack.onResult(cutestCat);
//                    }
//
//                    @Override
//                    public void onError(Exception e) {
//                        callBack.onError(e);
//                    }
//                });
//            }
//        };
//        AsyncJob<Uri> uriAsyncJob = new AsyncJob<Uri>() {
//            @Override
//            public void start(final CallBack<Uri> callBack) {
//                catAsyncJob.start(new CallBack<Cat>() {
//                    @Override
//                    public void onResult(Cat cat) {
//
//                        apiWrapper1.store(cat).start(new CallBack<Uri>() {
//                            @Override
//                            public void onResult(Uri uri) {
//                                callBack.onResult(uri);
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
//
//                    }
//                });
//            }
//        };
//        return uriAsyncJob;
//    }


//    public AsyncJob<Uri> saveCuestCat(final String catsListPath) {
//        return new AsyncJob<Uri>() {
//            @Override
//            public void start(final CallBack<Uri> callBack) {
//                apiWrapper1.queryCatList(catsListPath).start(new CallBack<List<Cat>>() {
//                    @Override
//                    public void onResult(List<Cat> catList) {
//                        Cat cutestCat = findCutestCat(catList);
//                        apiWrapper1.store(cutestCat).start(new CallBack<Uri>() {
//                            @Override
//                            public void onResult(Uri uri) {
//                                callBack.onResult(uri);
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
//
//            }
//        };
//    }


//    APIWarpper apiWarpper;
//
//    public void saveCuestCat(String catListAds, final CallBack<Uri> uriCallBack){
//        apiWarpper.queryCatList(catListAds, new CallBack<List<Cat>>() {
//            @Override
//            public void onResult(List<Cat> catList) {
//                Cat cutestCat = findCutestCat(catList);
//                apiWarpper.store(cutestCat,uriCallBack);
//            }
//
//            @Override
//            public void onError(Exception e) {
//                uriCallBack.onError(e);
//            }
//        });
//    }


//    API api;

//    public void saveCuestCat(String listCatAds, final CutestCallBack cutestCallBack) {
//        api.queryCatList(listCatAds, new API.CatsListCallBack() {
//            @Override
//            public void onResult(List<Cat> catList) {
//                Cat cutestCat = findCutestCat(catList);
//                api.store(cutestCat, new API.CutestCalCallBack() {
//                    @Override
//                    public void onResult(Uri catAds) {
//                        cutestCallBack.onResult(catAds);
//                    }
//
//                    @Override
//                    public void onError(Exception e) {
//                        cutestCallBack.onError(e);
//                    }
//                });
////                cutestCallBack.onResult(api.store(cutestCat)
////                );
//            }
//
//            @Override
//            public void onError(Exception e) {
//                cutestCallBack.onError(e);
//            }
//        });
//    }

//    public Uri saveCuestCat(String listCatAds) {
//        List<Cat> catList = api.queryCatList(listCatAds);
//        Cat cat = findCutestCat(catList);
//        return api.store(cat);
//    }

    public Cat findCutestCat(List<Cat> catList) {
        return Collections.max(catList);
    }
}
