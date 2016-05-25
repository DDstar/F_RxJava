package com.example.ddstar.f_rxjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    /**
     * 任务
     * 我们有个 Web API，
     * 能根据给定的查询请求搜索到整个互联网上猫的图片。
     * 每个图片包含可爱指数的参数（描述图片可爱度的整型值）。
     * 我们的任务将会下载到一个猫列表的集合，选择最可爱的那个，
     * 然后把它保存到本地。
     */
}
