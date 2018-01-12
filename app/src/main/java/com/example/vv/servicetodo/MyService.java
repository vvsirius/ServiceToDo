package com.example.vv.servicetodo;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyService extends Service {

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Toast.makeText(this, "Service started!", Toast.LENGTH_SHORT).show();
        new ServiceThread().start();
        return START_NOT_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "Service destroyed!", Toast.LENGTH_SHORT).show();
        //Нужно реализовать!!
    }

    class ServiceThread extends Thread{
        boolean working = true;
        @Override
        public void run() {
            for (int i = 10; i >=0 && working; i--) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Toast.makeText(MyService.this, i + "", Toast.LENGTH_SHORT).show();
            }
        }
    }

    String timeToLunch(){
        String time1 = "19:00:00";
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        Date date1 = null;
        try {
            date1 = format.parse(time1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date date2 = new Date();
        return (date2.getTime() - date1.getTime())/(60 * 1000) + "seconds";
    }
}
