package com.zt.windowlayer;

import android.content.pm.ActivityInfo;
import android.content.res.Resources;
import android.graphics.PixelFormat;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;

/**
 * Created by TPIAN on 16/6/22.
 */
public class LayoutParamsUtils {
    //        WindowManager.LayoutParams  windowParams =  new WindowManager.LayoutParams();
    //        windowParams.gravity = Gravity.LEFT | Gravity.CENTER;
    //        windowParams.type = WindowManager.LayoutParams.TYPE_PHONE;
    //        windowParams.flags = WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE| View.SYSTEM_UI_FLAG_FULLSCREEN;
    //        windowParams.format = PixelFormat.TRANSPARENT;
    //        windowParams.width = WindowManager.LayoutParams.MATCH_PARENT;
    //        windowParams.height =  WindowManager.LayoutParams.MATCH_PARENT;
    //return windowParams
    //魅族metal会充电弹条,而竞品开启后不会,PHONE级别
    public static WindowManager.LayoutParams buildLayoutParams() {
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.width = -1;
        lp.height = -1;
        lp.type = WindowManager.LayoutParams.TYPE_PHONE;
        lp.flags |= WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED | WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN | WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD;
        lp.format = PixelFormat.TRANSPARENT;
        lp.screenOrientation = 1;
        lp.systemUiVisibility = getFullScreenSystemUiVisibility();
        return lp;
    }

    public static WindowManager.LayoutParams buildPhoneLayoutParams() {
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.width = -1;
        lp.height = -1;
        lp.type = WindowManager.LayoutParams.TYPE_PHONE;
        lp.flags |= WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED | WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN | WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD;
        lp.format = PixelFormat.TRANSPARENT;
        lp.screenOrientation = 1;
        lp.systemUiVisibility = getFullScreenSystemUiVisibility();
        return lp;
    }

    //移除时黑屏 Alert级别
    //    public static WindowManager.LayoutParams buildLayoutParams() {
    //        WindowManager.LayoutParams params = new WindowManager.LayoutParams(WindowManager.LayoutParams.MATCH_PARENT,
    //                WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.TYPE_SYSTEM_ALERT,
    //                WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD |
    //                        WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED | WindowManager.LayoutParams.FLAG_DIM_BEHIND
    //                        | WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED,
    //                PixelFormat.TRANSPARENT);
    //
    //        params.dimAmount = 1;
    //        params.x = 0;
    //        params.y = 0;
    //        return params;
    //    }

    //    public static WindowManager.LayoutParams buildLayoutParams() {
    //        WindowManager.LayoutParams params = new WindowManager.LayoutParams(WindowManager.LayoutParams.WRAP_CONTENT,
    //                WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.TYPE_SYSTEM_ERROR,
    //                WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD
    //                        | WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED
    //                        | WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED
    //                        | WindowManager.LayoutParams.FLAG_WATCH_OUTSIDE_TOUCH
    //                        | WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL,
    //                PixelFormat.TRANSLUCENT);
    //
    //        params.x = 0;
    //        params.y = 0;
    //        params.gravity = Gravity.CENTER_VERTICAL | Gravity.START;
    //        params.systemUiVisibility = getFullScreenSystemUiVisibility();
    //        return params;
    //    }

    //会在最上层， PixelFormat.OPAQUE会没有移除时的减淡动效, PixelFormat.TRANSPARENT会有
    public static WindowManager.LayoutParams buildLayoutParams(Resources resources) {
        WindowManager.LayoutParams params = new WindowManager.LayoutParams(WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.TYPE_SYSTEM_ERROR,
                WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD
                        | WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN
                        | WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED
                        | WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN
                        //                        | WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED
                        | WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
                //                        | WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM
                ,
                PixelFormat.TRANSPARENT);
        params.screenOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;
        params.gravity = Gravity.CENTER_VERTICAL | Gravity.START | Gravity.LEFT;
        //        Display defaultDisplay = systemService.getDefaultDisplay();
        //        DisplayMetrics metrics=new DisplayMetrics();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        //        defaultDisplay.getMetrics(defaultDisplay);
        params.width = displayMetrics.widthPixels;
        params.height = displayMetrics.heightPixels;

        params.x = 0;
        params.y = 0;
        //        params.systemUiVisibility = getFullScreenSystemUiVisibility();
        return params;
    }

    protected static int getFullScreenSystemUiVisibility() {
        int systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            systemUiVisibility |= View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY |
                    View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION;
        }
        return systemUiVisibility;
    }

}
