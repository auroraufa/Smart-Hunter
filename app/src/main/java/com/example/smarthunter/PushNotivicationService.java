package com.example.smarthunter;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class PushNotivicationService extends Service {
    public PushNotivicationService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}