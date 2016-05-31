package com.toolbar.ddstar.frxjava2;

import android.graphics.Bitmap;

/**
 * Created by DDstar on 2016/5/30.
 */
public class Cat implements Comparable<Cat> {
    Bitmap catAdrs;
    int cueNess;

    @Override
    public int compareTo(Cat another) {
        return Integer.compare(cueNess, another.cueNess);
    }
}
