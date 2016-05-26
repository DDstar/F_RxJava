package com.example.ddstar.f_rxjava;

import android.graphics.Bitmap;

/**
 * Created by DDstar on 2016/5/26.
 */
public class Cat implements Comparable<Cat> {

    Bitmap image;
    int cutNess;


    @Override
    public int compareTo(Cat another) {
        return Integer.compare(cutNess, another.cutNess);
    }
}
