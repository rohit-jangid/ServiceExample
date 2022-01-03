package com.rohfl.serviceexample;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.rohfl.serviceexample.foregroundservice.ForegroundService;
import com.rohfl.serviceexample.intentservice.IService;

public class MainActivity extends AppCompatActivity {

    public static final String CHANNEL_ID = "channelid";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button start = findViewById(R.id.start);
        Button stop = findViewById(R.id.stop);
        EditText editText = findViewById(R.id.edit_text);

        notificationChannel();

        start.setOnClickListener(v -> {
//            Intent i = new Intent(this, ForegroundService.class);
//            i.putExtra("message", editText.getText().toString().trim());
//            startService(i);
            Intent i = new Intent(this, IService.class);
            i.putExtra("message", editText.getText().toString().trim());
            ContextCompat.startForegroundService(this,i);
        });

        stop.setOnClickListener(v -> {
//            Intent i = new Intent(this, ForegroundService.class);
            Intent i = new Intent(this, IService.class);
            stopService(i);
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Intent i = new Intent(this, IService.class);
        stopService(i);
    }

    private void notificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel serviceChannel = new NotificationChannel(
                    CHANNEL_ID,
                    "Foreground channel",
                    NotificationManager.IMPORTANCE_DEFAULT
            );
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(serviceChannel);
        }
    }
}