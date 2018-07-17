package com.mygreenbank.mygreenbank;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import java.util.Locale;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private DrawerLayout mDrawLayout;
    private ActionBarDrawerToggle mToggle;
    private NavigationView mNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ProgramState.getPlots("Plots.save",this);

        setNavigationViewListener();
        mDrawLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        mNavigationView = (NavigationView) findViewById(R.id.nav_view);
        mToggle = new ActionBarDrawerToggle(this, mDrawLayout, R.string.open, R.string.close);

        mDrawLayout.addDrawerListener(mToggle);
        mToggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void setNavigationViewListener(){
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(mToggle.onOptionsItemSelected(item)){
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onButtonClick(View v){
        if(v.getId() == R.id.measure){
            Intent i = new Intent(MainActivity.this, TreeCalculation.class);
            startActivity(i);

        }
        if(v.getId() == R.id.createPlot){
            Intent i = new Intent(MainActivity.this, CreatePlot.class);
            startActivity(i);

        }
        if(v.getId() == R.id.managePlot){
            Intent i = new Intent(MainActivity.this, ManagePlot.class);
            startActivity(i);

        }
        if(v.getId() == R.id.settings){
            Intent i = new Intent(MainActivity.this, Settings.class);
            startActivity(i);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.home:
                Intent h = new Intent(MainActivity.this, MainActivity.class);
                startActivity(h);
                return true;
            case R.id.menu_tree_calculation:
                Intent i = new Intent(MainActivity.this, TreeCalculation.class);
                startActivity(i);
                return true;
            case R.id.menu_create_plot:
                Intent j = new Intent(MainActivity.this, CreatePlot.class);
                startActivity(j);
                return true;
            case R.id.menu_manage_plot:
                Intent k = new Intent(MainActivity.this, ManagePlot.class);
                startActivity(k);
                return true;
            case R.id.menu_settings:
                Intent l = new Intent(MainActivity.this, Settings.class);
                startActivity(l);
                return true;
        }
        mDrawLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}
