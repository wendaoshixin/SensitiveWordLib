package com.leimans.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.leimans.sensitivewordlib.dfa.Demo2;

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
               new Demo2().test2(getAssets().open("sensitivewords.txt"));
            }catch (Exception e){
                e.printStackTrace();
            }
        };
        new Thread(task).start();

    }
}