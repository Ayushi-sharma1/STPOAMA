package com.stpoa.ashit.stpoa;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SearchView;

import com.google.firebase.auth.FirebaseAuth;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class View_Laws_Activity extends AppCompatActivity {
    ListView listView;
    Button logOut;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view__laws_);

        listView = (ListView) findViewById(R.id.listview);
        String[] values = new String[]{"chapter 1", "chapter 2", "chapter 3", "chapter 4","chapter 4a", "chapter 5"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, values);

        listView.setAdapter(adapter);


        //now we will  creat onitemclick listener for each item
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (position == 0) {
                Intent myIntent = new Intent(view.getContext(), Law1.class);
                startActivityForResult(myIntent, 0);
                }
                if (position == 1) {
                Intent myIntent = new Intent(view.getContext(), Chapter2.class);
                    startActivityForResult(myIntent, 0);
                }
                if (position == 2) {
                    Intent myIntent = new Intent(view.getContext(), Chapter3.class);
                    startActivityForResult(myIntent, 0);
                }
                if (position == 3) {
                    Intent myIntent = new Intent(view.getContext(), Chapter4.class);
                    startActivityForResult(myIntent, 0);
                }
                if (position == 4) {
                    Intent myIntent = new Intent(view.getContext(), Chapter4a.class);
                    startActivityForResult(myIntent, 0);
                }
                if (position == 5) {
                    Intent myIntent = new Intent(view.getContext(), Chapter5.class);
                    startActivityForResult(myIntent, 0);
                }
            }
        });

        logOut = (Button) findViewById(R.id.log_Out);
        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logOut.setVisibility(Button.VISIBLE);
                signout();
                startActivity(new Intent(View_Laws_Activity.this,HomeActivity.class));
                View_Laws_Activity.this.finish();
            }
        });

    }

    private void signout() {
        FirebaseAuth mauth =FirebaseAuth.getInstance();
        mauth.signOut();
    }
}



   





