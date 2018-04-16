package com.stpoa.ashit.stpoa;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class NewAccountActivity extends AppCompatActivity implements View.OnClickListener{

    LinearLayout CreateNewAccount;
    private Button UserRegister;
    private EditText userName,motherName,fatherName,dateOfBirth,mobileNumber,
                    emailId,caste,userPassword;
    private TextView gender,registationLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_account);

        UserRegister = (Button) findViewById(R.id.register);
        userName     = (EditText) findViewById(R.id.user_name);
        motherName   = (EditText) findViewById(R.id.mobile_number);
        fatherName   = (EditText) findViewById(R.id.father_name);
        dateOfBirth  = (EditText) findViewById(R.id.date_of_birth);
        mobileNumber = (EditText) findViewById(R.id.mobile_number);
        emailId      = (EditText) findViewById(R.id.email_id);
        userPassword = (EditText) findViewById(R.id.password);
        caste        = (EditText) findViewById(R.id.caste);
        gender       = (TextView) findViewById(R.id.gender);
        registationLogin    =   (TextView) findViewById(R.id.reg_login);

        UserRegister.setOnClickListener(this);
        registationLogin.setOnClickListener(this);

        CreateNewAccount = (LinearLayout) findViewById(R.id.create_new_account);
        Snackbar.make(CreateNewAccount, "Welcome to Create New Account Page", Snackbar.LENGTH_LONG).show();

        /*UserRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO: Register new user in database then redirect to view law page, else show error msg

                startActivity(new Intent(NewAccountActivity.this,View_Laws_Activity.class));
            }
        });*/
    }

    private void registerUser(){
        String email = emailId.getText().toString().trim();
        String password = userPassword.getText().toString().trim();
        String fullName = userName.getText().toString().trim();
        String FatherName = fatherName.getText().toString().trim();
        String MotherName = motherName.getText().toString().trim();

        //checking userName isEmpty
        if(TextUtils.isEmpty(fullName)){
            Toast.makeText(this,"Please enter your full name",Toast.LENGTH_LONG).show();
            return;
        }

        //checking motherName isEmpty
        if(TextUtils.isEmpty(MotherName)){
            Toast.makeText(this,"Please enter your mother name",Toast.LENGTH_LONG).show();
            return;
        }

        //checking fatherName isEmpty
        if(TextUtils.isEmpty(FatherName)){
            Toast.makeText(this,"Please enter your father name",Toast.LENGTH_LONG).show();
            return;
        }

        //checking email isEmpty
        if(TextUtils.isEmpty(email)){
            Toast.makeText(this,"Please enter emailId",Toast.LENGTH_LONG).show();
            return;
        }

        //checking password isEmpty
        if(TextUtils.isEmpty(password)){
            Toast.makeText(this,"Please enter password",Toast.LENGTH_LONG).show();
            return;
        }
    }
    @Override
    public void onClick(View view) {
        if(view == UserRegister){
            registerUser();
        }
        if(view == registationLogin){
            //will open login activity here
            startActivity(new Intent(NewAccountActivity.this, LoginActivity.class));
        }
    }
}
