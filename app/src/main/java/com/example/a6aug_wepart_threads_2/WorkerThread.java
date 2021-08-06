package com.example.a6aug_wepart_threads_2;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;

public class WorkerThread extends HandlerThread {

    private Handler mainHandler;
    public WorkerThread(String name,Handler mainHandler) {
        super(name);
        this.mainHandler = mainHandler;

    }

    @Override
    protected void onLooperPrepared() {
        super.onLooperPrepared();
        int progress = 0;

        for (int i=0; i<10; i++){
            try {
                Thread.sleep(2000);
                progress +=10;

                Message message = Message.obtain();
                message.obj = progress;
                mainHandler.sendMessage(message);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
