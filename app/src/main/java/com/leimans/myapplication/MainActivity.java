package com.leimans.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.leimans.sensitivewordlib.Demo;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.test_btn).setOnClickListener(view -> test());

    }

    private void test(){
        Runnable task=()->{
            try {
               new Demo().testAsset(getAssets().open("sensi_words.txt"),false);
            }catch (Exception e){
                e.printStackTrace();
            }
        };
        new Thread(task).start();

    }
}