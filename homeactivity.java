package com.sari3food.sari3fooooooooood;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.transition.Scene;

import android.transition.Transition;
import android.transition.TransitionInflater;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;


import java.util.ArrayList;

import static com.sari3food.sari3fooooooooood.R.*;

public class homeactivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{


    private tabadapter adapter;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    NavigationView nav;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_homeactivity);

        final Transition fadeTransition =
                TransitionInflater.from(this).
                        inflateTransition(R.transition.fade_transition);




        final Scene aScene;
        final Scene anotherScene;


// Create the scene root for the scenes in this app
        ViewGroup   sceneRoot = (ViewGroup) findViewById(R.id.scene_root);

// Create the scenes
        aScene = Scene.getSceneForLayout(sceneRoot, layout.first_scene, this);
        anotherScene =
                Scene.getSceneForLayout(sceneRoot, layout.second_scene, this);


        this.configureToolBar();
        this.configureDrawerLayout();

        nav = findViewById(id.navview);
        nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
               switch (item.getItemId()) {
                   case id.item1:
                       TransitionManager.go(aScene, fadeTransition);
                       viewPager = (ViewPager) findViewById(id.viewPager);
                       tabLayout = (TabLayout) findViewById(id.tabLayout);
                       adapter = new tabadapter(getSupportFragmentManager());
                       adapter.addFragment( new Tab1Fragment(), "وضع القائمة");
                       adapter.addFragment(new Tab2Fragment(), "وضع الخريطة");

                       viewPager.setAdapter(adapter);
                       tabLayout.setupWithViewPager(viewPager);





                       break;

                   case  id.item2 :
                       TransitionManager.go(anotherScene, fadeTransition);

                       break;

               }
                return false;
            }
        } );
    }

    private void configureToolBar() {
        this.toolbar = (Toolbar) findViewById(id.toolbar1);
        setSupportActionBar(toolbar);

    }

    private void configureDrawerLayout() {
        this.drawerLayout =  findViewById(id.toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, string.navigation_drawer_open, string.navigation_drawer_close);

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }
    @Override
    public void onBackPressed() {
        // 5 - Handle back click to close menu
        if (this.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            this.drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
    private void configureNavigationView() {
        this.nav = (NavigationView) findViewById(id.navview);
        this.nav.setScrollContainer(true);
        nav.setNavigationItemSelectedListener((NavigationView.OnNavigationItemSelectedListener) this);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case id.menu_email:
                Toast.makeText(this, "EMail", Toast.LENGTH_LONG).show();
                break;
            default:
                break;
        }
        return true;
    }

}
