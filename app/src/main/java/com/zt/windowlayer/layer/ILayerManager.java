package com.zt.windowlayer.layer;

/**
 * Created by Tony on 16/9/27.
 */
public interface ILayerManager {
    /**
     * 添加一个itent对应的悬浮窗, 如果intent对应的悬浮窗已经存在, 就resume该悬浮窗
     */
    void addLayer(android.content.Intent intent) throws android.os.RemoteException;

    /**
     * 如果intent对应的悬浮窗已经存在, 就resume该悬浮窗, 否则不操作
     */
    void resumeLayer(android.content.Intent intent) throws android.os.RemoteException;

    /**
     * 如果intent对应的悬浮窗已经存在, 就pause该悬浮窗, 否则不操作
     */
    void pauseLayer(android.content.Intent intent) throws android.os.RemoteException;

    /**
     * 如果intent对应的悬浮窗已经存在, 就移除该悬浮窗, 否则不操作
     */
    void removeLayer(android.content.Intent intent) throws android.os.RemoteException;

    /**
     * 如果intent对应的悬浮窗已经存在, 就把intent发给这个悬浮窗, 否则不操作
     */
    void newIntent(android.content.Intent intent) throws android.os.RemoteException;

    /**
     * 如果intent对应的悬浮窗已经存在, 就返回true, 否则返回false
     */
    boolean hasLayer(android.content.Intent intent) throws android.os.RemoteException;
}
