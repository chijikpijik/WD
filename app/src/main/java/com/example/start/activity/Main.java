package com.example.start.activity;

import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import com.example.start.R;
import com.example.start.fragments.DrawerFragment;
import com.example.start.fragments.FaceFragment;

public class Main extends CoreActivity {

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle drawerToggle;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_drawer_layout);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

//        drawerLayout.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);


        drawerToggle = new ActionBarDrawerToggle(
                this,
                drawerLayout,
                R.drawable.abc_tab_selected_pressed_holo,
                R.string.open_nav,
                R.string.close_nav){
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                invalidateOptionsMenu();
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                invalidateOptionsMenu();
            }
        };
        drawerLayout.setDrawerListener(drawerToggle);

        getSupportFragmentManager().beginTransaction().replace(R.id.left_drawer, DrawerFragment.newInstance())
                .commit();

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.content_frame, FaceFragment.newInstance());
        ft.commit();
    }

}

