package com.toolbar.ddstar.frxjava2;

/**
 * Created by DDstar on 2016/5/30.
 */
public abstract class AsyncJob<T> {
    public abstract void start(CallBack<T> callBack);

    /**
     * 映射新增加映射方法
     *
     * @param mapfun
     * @param <R>
     * @return
     */
    public <R> AsyncJob<R> map(final FunTR<T, R> mapfun) {
        final AsyncJob<T> source = this;
        return new AsyncJob<R>() {
            @Override
            public void start(final CallBack<R> callBack) {
                source.start(new CallBack<T>() {
                    @Override
                    public void onResult(T t) {
                        R funCallReturn = mapfun.funCall(t);
                        callBack.onResult(funCallReturn);
                    }

                    @Override
                    public void onError(Exception e) {
                        callBack.onError(e);
                    }
                });
            }
        };
    }
    public <R> AsyncJob<R> flatMap(final FunTR<T, AsyncJob<R>> flapMapfun) {
        final AsyncJob<T> source = this;
        return new AsyncJob<R>() {
            @Override
            public void start(final CallBack<R> callBack) {
                source.start(new CallBack<T>() {
                    @Override
                    public void onResult(T t) {
                        AsyncJob<R> rAsyncJob = flapMapfun.funCall(t);
                        rAsyncJob.start(new CallBack<R>() {
                            @Override
                            public void onResult(R r) {
                                callBack.onResult(r);
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
