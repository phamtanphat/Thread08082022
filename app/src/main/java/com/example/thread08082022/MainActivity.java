package com.example.thread08082022;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    int a, b, c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        a = b = c;
        MyFlag myFlag = new MyFlag(1);

       // Tạo thread
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (myFlag){
                    for (int i = 1; i <= 10; i++) {
                        if (myFlag.count == 1) {
                            a = i;
                            Log.d("BBB","A : " + a);
                        }
                    }
                }
            }
        });

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (myFlag){
                    for (int i = 1; i <= 10; i++) {
                        if (myFlag.count == 2) {
                            b = i;
                            Log.d("BBB","B : " + b);
                        }
                    }
                }
            }
        });

        Thread threadC = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (myFlag){
                    for (int i = 1; i <= 10; i++) {
                        if (myFlag.count == 3) {
                            c = a + b;
                            Log.d("BBB","C : " + c);
                        }
                    }
                }
            }
        });

        threadB.start();
        threadA.start();
        threadC.start();

    }
}
