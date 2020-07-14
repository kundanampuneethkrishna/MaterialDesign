package com.example.materialdesign;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.util.Pair;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    Toolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;

    FragmentTransaction transaction;
    FragmentManager manager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar =findViewById(R.id.toolbar);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);

        ActionBarDrawerToggle drawerToggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,0,0);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);

        drawerToggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.colorPrimary));
        manager=getSupportFragmentManager();
        transaction=manager.beginTransaction();
        Home home = new Home();
        transaction.replace(R.id.main_body,home);
        transaction.commit();
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        transaction=manager.beginTransaction();
        switch (item.getItemId()){
            case R.id.home:

                Home home = new Home();
                transaction.replace(R.id.main_body,home);
                transaction.commit();
                drawerLayout.closeDrawer(GravityCompat.START);
                break;
            case R.id.design:
                Design design= new Design();
                transaction.replace(R.id.main_body,design);
                transaction.commit();
                drawerLayout.closeDrawer(GravityCompat.START);
                break;
        }
        return false;
    }
}