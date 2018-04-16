package com.stpoa.ashit.stpoa;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
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

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity implements View. OnClickListener{

    private EditText editTextemail, editTextpassword;
    private Button login;
    private TextView createAccount,forgetPassword;
    private LinearLayout loginLayout;

    @VisibleForTesting
    public ProgressDialog mProgressDialog;

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextemail = (EditText) findViewById(R.id.user_email);
        editTextpassword = (EditText) findViewById(R.id.user_password);
        login = (Button) findViewById(R.id.user_login_button);
        createAccount = (TextView) findViewById(R.id.user_new_account);
        forgetPassword = (TextView) findViewById(R.id.Forget_Password);
        /*mAuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if (!(FirebaseAuth.getCurrentUser() == null)){
                    setResult(Activity.RESULT_OK,new Intent());
                    LoginActivity.this.finish();
                }
            }
        };*/

        login.setOnClickListener(this);
        createAccount.setOnClickListener(this);


        loginLayout = (LinearLayout) findViewById(R.id.login_layout);
        Snackbar.make(loginLayout,"Welcom to LogIn Page",Snackbar.LENGTH_LONG).show();

        forgetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, ForgetPasswordActivity.class));
            }
        });

        mAuth = FirebaseAuth.getInstance();
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser!=null) {
            startActivity(new Intent(LoginActivity.this, View_Laws_Activity.class));
            LoginActivity.this.finish();
        }
    }

    private void userlogin(){
        showProgressDialog();
        String email    = editTextemail.getText().toString().trim();
        String password = editTextpassword.getText().toString().trim();

        //checking email is empty
        if(TextUtils.isEmpty(email)){
            editTextemail.setError("Enter Email");
            hideProgressDialog();
            return;
        }
        //checking password is empty
        if(TextUtils.isEmpty(password)){
            editTextpassword.setError("Enter Password");
            hideProgressDialog();
            return;
        }
        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Toast.makeText(LoginActivity.this,"Login Successful",Toast.LENGTH_LONG).show();
                    startActivity(new Intent(LoginActivity.this,View_Laws_Activity.class));
                    LoginActivity.this.finish();
                } else {
                    Toast.makeText(LoginActivity.this,"Login Faild",Toast.LENGTH_LONG).show();
                }
                hideProgressDialog();
            }
        });

    }

    @Override
    public void onClick(View view) {

        if(view == login){
            userlogin();
        }

        if(view == createAccount){
            startActivity(new Intent(this, NewAccountActivity.class));
        }
    }

    private void showProgressDialog(){
        if (mProgressDialog == null){
            mProgressDialog = new ProgressDialog(this);
            mProgressDialog.setMessage("Please Wait");
            mProgressDialog.setIndeterminate(true);
        }
        mProgressDialog.show();
    }

    private void hideProgressDialog(){
        if (mProgressDialog !=null && mProgressDialog.isShowing()){
            mProgressDialog.dismiss();
        }
    }

    /*
    @Override
    protected void onDestroy() {
        super.onDestroy();
        signout();
    }

    @Override
    protected void onStop() {
        super.onStop();
        signout();
    }
    */
    private void signout(){
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        mAuth.signOut();
    }

}