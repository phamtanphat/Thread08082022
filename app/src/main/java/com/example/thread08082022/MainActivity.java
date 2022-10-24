package com.example.thread08082022;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // Tạo thread
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                printMessage("A ");
            }
        });

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                printMessage("B ");
            }
        });

        threadB.start();
        threadA.start();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Log.d("BBB","State A " + threadA.getState().toString());
                Log.d("BBB","State B " + threadB.getState().toString());
            }
        },1);
    }

    private synchronized void printMessage(String message) {
        for (int i = 0; i < 1000; i++) {
            Log.d("BBB", message + i);
        }
    }
}
