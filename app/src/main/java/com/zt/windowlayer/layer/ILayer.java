package com.zt.windowlayer.layer;

import android.content.Intent;
import android.view.View;

/**
 * Created by Tony on 16/9/27.
 */
public interface ILayer {
    void onCreate(Intent intent);

    void onResume(Intent intent);

    void onPause();

    void onDestroy();

    void onNewIntent(Intent intent);

    void setContentView(View view);

    void setContentView(int resId);

    View getDecorView();

    LayerManager getLayerManager();
}
