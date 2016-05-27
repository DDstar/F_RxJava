package com.example.ddstar.f_rxjava;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        doWork();
    }

    private void doWork() {
        new CatHelper().saveCutsetCat("www.baidu.cat.com").start(new CallBack<Uri>() {
            @Override
            public void onResult(Uri result) {

            }

            @Override
            public void onError(Exception e) {

            }
        });
//        catHelper.saveCutestCat("www.baidu.cat.com", new CallBack<Uri>() {
//            @Override
//            public void onResult(Uri result) {
//
//            }
//
//            @Override
//            public void onError(Exception e) {
//
//            }
//        });
//        catHelper.saveCutestCAt("www.baidu.cats.com", new CatHelper.CutestCatCallBack() {
//            @Override
//            public void onCatSaveSuccess(Uri uriAds) {
//
//            }
//
//            @Override
//            public void onError(Exception e) {
//
//            }
//        });
    }
    /**
     * 任务
     *
     * 我们有个 Web API，
     * 能根据给定的查询请求搜索到整个互联网上猫的图片。
     * 每个图片包含可爱指数的参数（描述图片可爱度的整型值）。
     * 我们的任务将会下载到一个猫列表的集合，选择最可爱的那个，
     * 然后把它保存到本地。
     */
}
