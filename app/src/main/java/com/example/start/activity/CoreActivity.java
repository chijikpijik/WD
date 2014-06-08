package com.example.start.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

public abstract class CoreActivity extends FragmentActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(android.R.style.Theme_Holo_Light);
    }
}
