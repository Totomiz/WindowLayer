package com.zt.windowlayer.layer;

import android.app.Activity;
import android.app.Application;
import android.content.ContextWrapper;
import android.content.Intent;

/**
 * Created by Tony on 16/9/27.
 */
public class ApplicationWrapper extends ContextWrapper {
    private Application mAplication;

    public ApplicationWrapper() {
        super(null);
    }

    /* package */void attach(Application application) {
        if (getBaseContext() == null) {
            mAplication = application;
            attachBaseContext(application);
        }
    }

    public Application getApplication() {
        return mAplication;
    }

    @Override
    public void startActivity(Intent intent) {
        if (!(getBaseContext() instanceof Activity)) {
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        }
        super.startActivity(intent);
    }
}
