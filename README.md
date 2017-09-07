# 封装创建一个窗口，通常程序获取系统窗体管理器，封装后，改变了新的使用方式
1.在其他地创建一个layerManager，如下

```
    private LayerManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView btn = (TextView) findViewById(R.id.jump);
//        manager=LayerManager.obtainLocal(getApplication());
        manager=  LayerManagerImpl.getInstance(getApplication());
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            //这里跳转窗体
                manager.addLayer(new Intent(getApplication(),CustomWindow.class));
            }
        });
    }
```

2.创建窗体类，继承abslayer,可以看成一个activity,但是不需要注册，却用法同activity类似。如下

```
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
```
3.注意手机要给应用添加悬浮窗权限，清单文件添加使用权限

```
<uses-permission android:name="android.permission.SYSTEM_ALERT_WINDOW" />
```
