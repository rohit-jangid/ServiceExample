package com.rohfl.serviceexample.intentservice;

import android.app.IntentService;
import android.content.Intent;

import androidx.annotation.Nullable;

public class IService extends IntentService {
    /**
     * @param name
     * @deprecated
     */
    public IService(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

    }
}
