package com.stpoa.ashit.stpoa;

import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;

public class UpdateLawsActivity extends AppCompatActivity {

    RelativeLayout updateLaws;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_laws);

        updateLaws = (RelativeLayout) findViewById(R.id.update_laws);
        Snackbar.make(updateLaws, "Welcome to Update Laws Page",Snackbar.LENGTH_LONG).show();
    }
}
