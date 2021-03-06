package com.example.ddstar.f_rxjava;

/**
 * Created by DDstar on 2016/5/27.
 */
public abstract class AsyncJob<T> {

    public abstract void start(CallBack<T> callBack);

    public <R> AsyncJob<R> map(final Func<T, R> trFunc) {
        final AsyncJob<T> curTask = this;
        return new AsyncJob<R>() {
            @Override
            public void start(final CallBack<R> callBack) {
                curTask.start(new CallBack<T>() {
                    @Override
                    public void onResult(T result) {
                        R resutlR = trFunc.call(result);
                        callBack.onResult(resutlR);
                    }

                    @Override
                    public void onError(Exception e) {
                        callBack.onError(e);
                    }
                });
            }
        };
    }

    public <R> AsyncJob<R> flapMap(final Func<T, AsyncJob<R>> func) {
        final AsyncJob<T> srcJob = this;
        return new AsyncJob<R>() {
            @Override
            public void start(final CallBack<R> callBack) {
                srcJob.start(new CallBack<T>() {
                    @Override
                    public void onResult(T result) {
                        AsyncJob<R> resultAR = func.call(result);
                        resultAR.start(new CallBack<R>() {
                            @Override
                            public void onResult(R result) {
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
    }


}
