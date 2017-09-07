package com.zt.windowlayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.zt.windowlayer.layer.LayerManager;
import com.zt.windowlayer.layer.LayerManagerImpl;

public class MainActivity extends AppCompatActivity {
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

                manager.addLayer(new Intent(getApplication(),CustomWindow.class));
            }
        });
    }
}
