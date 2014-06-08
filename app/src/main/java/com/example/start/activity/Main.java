package com.example.start.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import com.example.start.R;
import com.example.start.fragments.FaceFragment;

public class Main extends CoreActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.face_layout);
    }

    @Override
    protected void onResume() {
        super.onResume();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.fragmentContainer, FaceFragment.newInstance());
        ft.commit();
    }

}

