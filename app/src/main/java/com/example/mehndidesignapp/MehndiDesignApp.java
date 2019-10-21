package com.example.mehndidesignapp;

import android.app.Application;

import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

public class MehndiDesignApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();


        // to retrieve text in app offline
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);

        // to retrieve images in app offline
        Picasso.Builder builder = new Picasso.Builder(this);
        builder.downloader(new OkHttp3Downloader(this,Integer.MAX_VALUE));
        Picasso built = builder.build();
        built.setIndicatorsEnabled(false);
        built.setLoggingEnabled(true);
        Picasso.setSingletonInstance(built);

    }
}
