package com.example.ddstar.f_rxjava;

/**
 * Created by DDstar on 2016/5/30.
 */
public interface Func<T, R> {
    R call(T t);
}
