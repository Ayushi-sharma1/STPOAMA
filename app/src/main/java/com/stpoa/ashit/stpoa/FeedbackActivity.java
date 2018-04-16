package com.stpoa.ashit.stpoa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

public class FeedbackActivity extends AppCompatActivity {
    RatingBar ratingBar;
    Button sumbit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        final RatingBar ratingBar = (RatingBar) findViewById(R.id.ratingbar);
        Button submit=(Button) findViewById(R.id.submit_feedback);


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String rating=String.valueOf(ratingBar.getRating());
                Toast.makeText(getApplicationContext(),rating,Toast.LENGTH_LONG).show();

            }
        });
    }
}
