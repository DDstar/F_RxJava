package com.example.ddstar.f_rxjava;

/**
 * Created by DDstar on 2016/5/26.
 */
public interface CallBack<T> {
    void onResult(T result);
    void onError(Exception e);
}
