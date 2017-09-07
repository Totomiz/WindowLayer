package com.zt.windowlayer;

import android.content.Intent;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.zt.windowlayer.layer.AbsLayer;
import com.zt.windowlayer.layer.LayerManager;

/**
 * Created by tony.zhang on 2017-09-07 18:22
 * Email:461609086@qq.com
 */

public class CustomWindow extends AbsLayer {
    LayerManager manager;

    @Override
    public void onCreate(Intent intent) {
        setContentView(R.layout.custom_layout);
        TextView viewById = (TextView) findViewById(R.id.tv);
        manager=LayerManager.obtainLocal(getApplication());
        viewById.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void onResume(Intent intent) {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public String getLayerName() {
        return "aa";
    }

    @Override
    public WindowManager.LayoutParams createLayoutParams() {
        return LayoutParamsUtils.buildPhoneLayoutParams();
    }
}
