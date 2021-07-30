package com.example.sofitconsultancytask.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.sofitconsultancytask.Fragments.HomeFragment;
import com.example.sofitconsultancytask.Fragments.PostsFragment;
import com.example.sofitconsultancytask.Fragments.ServicesFragment;
import com.example.sofitconsultancytask.R;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    Toolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle actionBarDrawerToggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.navigationViewBar);
        actionBarDrawerToggle=new ActionBarDrawerToggle(this, drawerLayout ,toolbar, R.string.app_name, R.string.app_name);
        actionBarDrawerToggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.bringToFront();

        if (savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
        }


    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.home:
            {
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).addToBackStack(null).commit();
                break;
            }
            case R.id.services:
            {
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ServicesFragment()).addToBackStack(null).commit();
                break;
            }
            case R.id.posts:
            {
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new PostsFragment()).addToBackStack(null).commit();
                break;
            }
        }
        return true;
    }
}