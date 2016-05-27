package com.example.ddstar.f_rxjava;

/**
 * Created by DDstar on 2016/5/27.
 */
public abstract class AsyncJob<T> {
    public abstract void start(CallBack<T> callBack);
}
