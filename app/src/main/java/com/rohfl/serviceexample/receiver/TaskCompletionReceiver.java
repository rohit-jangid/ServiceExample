package com.rohfl.serviceexample.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class TaskCompletionReceiver extends BroadcastReceiver {

    public static final String PROCESS_RESPONSE = "PROCESS_RESPONSE";

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context.getApplicationContext(), "Received", Toast.LENGTH_SHORT).show();
    }
}
