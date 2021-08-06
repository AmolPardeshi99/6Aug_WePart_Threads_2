package com.example.a6aug_wepart_threads_2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.Toast;

import com.google.android.material.progressindicator.CircularProgressIndicator;

public class MainActivity extends AppCompatActivity {


    private CircularProgressIndicator progressIndicator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressIndicator = findViewById(R.id.progressBar);
        WorkerThread workerThread  = new WorkerThread("async",mainHandler);
        workerThread.start();

    }

    private Handler mainHandler = new Handler(Looper.getMainLooper()){

        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);

            int progress = (int) msg.obj;
            progressIndicator.setProgress(progress);
            if (progress==100)
                Toast.makeText(MainActivity.this,"Your Task is completed !",Toast.LENGTH_SHORT).show();
        }
    };
}