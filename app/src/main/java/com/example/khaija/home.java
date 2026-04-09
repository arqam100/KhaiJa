package com.example.khaija;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentTransaction;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.fragments.About;
import com.example.fragments.Contact;
import com.example.fragments.Tablayout;
import com.google.android.material.navigation.NavigationView;

public class home extends AppCompatActivity {

    NavigationView nv;
    ActionBarDrawerToggle toggle;
    DrawerLayout drawerLayout;
    FragmentTransaction transaction;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        nv = (NavigationView) findViewById(R.id.navmenu);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);

        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fcontainer, new Tablayout());
        transaction.addToBackStack(null);
        transaction.commit();


        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

                switch (item.getItemId()) {


                    case R.id.menu_call:
                        Toast.makeText(home.this, "Contact Us ", Toast.LENGTH_LONG).show();
                        Contact contact = new Contact();
                        transaction.replace(R.id.fcontainer, contact);
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.menu_about:
                        Toast.makeText(home.this, "About Us", Toast.LENGTH_LONG).show();
                        About about = new About();
                        transaction.replace(R.id.fcontainer, about);
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.menu_logOut:
                        Intent p=new Intent(home.this,signin.class);
                        p.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        p.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(p);
                }
                transaction.addToBackStack(null);
                transaction.commit();


                return true;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.orders:
                startActivity(new Intent(home.this,OrderActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(home.this)
                .setTitle("Exit")
                .setIcon(R.drawable.warning)
                .setMessage("Are You Sure To Exit?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                })
                .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                }).show();

    }
}


