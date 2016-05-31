package com.toolbar.ddstar.frxjava2;

/**
 * Created by DDstar on 2016/5/30.
 */
public interface CallBack<T> {
    void onResult(T t);

    void onError(Exception e);
}
