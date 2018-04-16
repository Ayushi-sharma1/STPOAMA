package com.stpoa.ashit.stpoa;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import java.security.acl.Group;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    Button button_login_reg;
    Group nav_view;
    NavigationView mNavigationView;


    @Override
    protected void onStart() {
        super.onStart();
        //Checking User Authentication to hide nev drawer items.
        if (checkAuth()){
            showNavMenuItem();
        }
        else{
            hideNavMenuItem();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        String spinnerArray[] = {"English","Hindi"};
        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item,spinnerArray);
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerArrayAdapter);

        button_login_reg = (Button) findViewById(R.id.button_Login_Reg);
        button_login_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, LoginActivity.class));
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close){

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                InputMethodManager inputMethodManager = (InputMethodManager)
                        getSystemService(Context.INPUT_METHOD_SERVICE);
                inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
            }


            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                InputMethodManager inputMethodManager = (InputMethodManager)
                        getSystemService(Context.INPUT_METHOD_SERVICE);
                inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
            }
        };

        drawer.addDrawerListener(toggle);
        toggle.syncState();

        mNavigationView = (NavigationView) findViewById(R.id.nav_view);
        mNavigationView.setNavigationItemSelectedListener(this);



        //Checking User Authentication to hide nev drawer items.
        if (checkAuth()){
            showNavMenuItem();
        }
        else{
            hideNavMenuItem();
        }

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    public boolean onOptionitemSelected(MenuItem item) {

        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_view_law) {
            startActivity(new Intent(HomeActivity.this, View_Laws_Activity.class));
        } else if (id == R.id.nav_login) {
            startActivity(new Intent(HomeActivity.this, LoginActivity.class));
        } else if (id == R.id.nav_update_laws) {
            startActivity(new Intent(HomeActivity.this, UpdateLawsActivity.class));
        } else if (id == R.id.nav_feedback) {
            startActivity(new Intent(HomeActivity.this, FeedbackActivity.class));
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private boolean checkAuth(){
        if (FirebaseAuth.getInstance().getCurrentUser() == null) {
            return false;
        } else {
            return true;
        }
    }

    //if the user is not authorized.
    private void hideNavMenuItem()
    {
        mNavigationView = (NavigationView) findViewById(R.id.nav_view);
        Menu nav_Menu = mNavigationView.getMenu();
        nav_Menu.findItem(R.id.admin_menu).setVisible(false);
    }

    private void showNavMenuItem(){
        mNavigationView = (NavigationView) findViewById(R.id.nav_view);
        Menu nav_Menu = mNavigationView.getMenu();
        nav_Menu.findItem(R.id.admin_menu).setVisible(true);
    }

    private void signout(){
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        mAuth.signOut();
    }
}
