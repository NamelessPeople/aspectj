package com.github.namelesspeople.aspectjdemo;

import android.Manifest;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.github.namelesspeople.aspectjdemo.permission.annotation.NeedPermission;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.image).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                way();
            }
        });
    }


    @NeedPermission(value = {Manifest.permission.READ_CONTACTS, Manifest.permission.WRITE_CONTACTS})
    private void way(){
        Log.e("ssss","way");
    }


}
