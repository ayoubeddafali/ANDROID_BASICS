package com.android.neo.tp.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyHelloService extends Service {
    public MyHelloService() {
        //sendBroadcast(new Intent("testing this lll"));

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        this.sendBroadcast(new Intent("HelloService").setAction("myAction"));
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");

    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("DEBUG", "ON DESTROY SERVICE");
    }

}
