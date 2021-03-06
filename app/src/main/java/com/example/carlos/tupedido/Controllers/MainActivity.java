package com.example.carlos.tupedido.Controllers;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.carlos.tupedido.DB.DBhelper;
import com.example.carlos.tupedido.Model.OrderLocal;
import com.example.carlos.tupedido.R;
import com.example.carlos.tupedido.Interfaces.MainActivityInterface;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.Dao;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener,MainActivityInterface{

    SharedPreferences sharedPreferences;
    TextView userName;
    String user;
    private DBhelper helper;
    private Dao<OrderLocal, Integer> ordersDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initSharedPreferences();
        userName = findViewById(R.id.UserName);
        if(userName!=null)
            userName.setText(user);

        helper = OpenHelperManager.getHelper(getApplicationContext(), DBhelper.class);
        try{
            ordersDao = helper.getOrdersDao();

            for(OrderLocal order : ordersDao){
                System.out.println("hola "+order.getDevice());
            }

        }catch (Exception e){
            Log.e("error", e.getMessage());
        }


    }
    @Override
    public void initSharedPreferences(){
        sharedPreferences = getSharedPreferences("PreferencesTuPedido", Context.MODE_PRIVATE);
        user = sharedPreferences.getString("user", null);
        boolean persistence = sharedPreferences.getBoolean("persistence", false);
        if (((user == null) || (user.equals("")) || (!persistence) )){
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        }else {
            setContentView(R.layout.activity_main);
            Toolbar toolbar = findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
            /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            });*/

            DrawerLayout drawer = findViewById(R.id.drawer_layout);
            ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                    this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
            drawer.addDrawerListener(toggle);
            toggle.syncState();
            NavigationView navigationView = findViewById(R.id.nav_view);
            navigationView.setNavigationItemSelectedListener(this);
            getSupportFragmentManager().beginTransaction().replace(R.id.content_main,new HomeFragment()).commit();
        }
    }

    @Override
    public void logOut() {
        sharedPreferences = getSharedPreferences("PreferencesTuPedido", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("persistence", false);
        editor.commit();
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }


    @Override
    public void onBackPressed() {
        initSharedPreferences();
        /*DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        userName = findViewById(R.id.UserName);
        if(userName!=null)
            userName.setText(user);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent myIntent = new Intent(getApplicationContext(), ProfileActivity.class);
        getApplicationContext().startActivity(myIntent);

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        Fragment fragment = null;
        boolean FragmentTransaction = false;

        if (id == R.id.nav_home) {
            fragment = new HomeFragment();
            FragmentTransaction = true;
        }else if (id == R.id.nav_products) {
            fragment = new ProductsFragment();
            FragmentTransaction = true;
        }else if (id == R.id.nav_drinks){
            fragment = new DrinksFragment();
            FragmentTransaction = true;
        } else if (id == R.id.nav_myorders) {
            fragment = new MyOrdersFragment();
            FragmentTransaction = true;
        } else if (id == R.id.nav_promotions) {
            fragment = new PromoFragment();
            FragmentTransaction = true;
        } else if (id == R.id.nav_exit) {
            logOut();
        }

        if (FragmentTransaction) {
            getSupportFragmentManager().beginTransaction().replace(R.id.content_main,fragment).commit();
            item.setChecked(true);
            getSupportActionBar().setTitle(item.getTitle());
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
