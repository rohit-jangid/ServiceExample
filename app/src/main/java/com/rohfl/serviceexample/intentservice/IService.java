package com.rohfl.serviceexample.intentservice;

import static com.rohfl.serviceexample.MainActivity.CHANNEL_ID;

import android.app.IntentService;
import android.app.Notification;
import android.content.Intent;
import android.media.MediaPlayer;
import android.provider.Settings;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

import com.rohfl.serviceexample.R;

public class IService extends IntentService {
    /**
     */
    public IService() {
        super("samplintentservice");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
//        so this creates another thread
        String message = intent.getStringExtra("message");

        Notification notification = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setContentTitle("Nothingg")
                .setContentText(message)
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .build();

        startForeground(1, notification);
    }
}
