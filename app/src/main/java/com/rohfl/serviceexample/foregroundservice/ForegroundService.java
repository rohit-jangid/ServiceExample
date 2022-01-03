package com.rohfl.serviceexample.foregroundservice;

import static com.rohfl.serviceexample.MainActivity.CHANNEL_ID;

import com.rohfl.serviceexample.MainActivity;
import com.rohfl.serviceexample.R;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.provider.Settings;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

public class ForegroundService extends Service {

    MediaPlayer mediaPlayer;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
//        mediaPlayer.stop();
//        mediaPlayer.release();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        String message = intent.getStringExtra("message");

        Intent notificationIntent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,
                0, notificationIntent, 0);


        Notification notification = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setContentTitle("Playing Music")
                .setContentIntent(pendingIntent)
                .setContentText(message)
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .build();

//        mediaPlayer = MediaPlayer.create(this,
//                Settings.System.DEFAULT_RINGTONE_URI);
//
//        mediaPlayer.setLooping(true);
//        mediaPlayer.start();

        startForeground(1, notification);

        return START_NOT_STICKY;
    }


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
