package com.toolbar.ddstar.frxjava2;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new CatHelper().saveCuestCat("").start(new CallBack<Uri>() {
            @Override
            public void onResult(Uri uri) {
                //获取到结果
            }

            @Override
            public void onError(Exception e) {

            }
        });
//        new CatHelper().saveCuestCat("", new CallBack<Uri>() {
//            @Override
//            public void onResult(Uri uri) {
//                //收到结果
//            }
//
//            @Override
//            public void onError(Exception e) {
//
//            }
//        });
//        new CatHelper().saveCuestCat("", new CatHelper.CutestCallBack() {
//            @Override
//            public void onResult(Uri cutestCatAds) {
//                Uri cuestCatAds = cutestCatAds;//收到结果
//            }
//
//            @Override
//            public void onError(Exception e) {
//
//            }
//        });
//        Uri cuestCatAds = new CatHelper().saveCuestCat("");//收到结果
    }
}
