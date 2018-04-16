package com.stpoa.ashit.stpoa;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ForgetPasswordActivity extends AppCompatActivity {

    private EditText inputnewPassword;
    private Button resetPassword;

    FirebaseAuth mAuth;

    public ProgressDialog fProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);

        inputnewPassword = (EditText) findViewById(R.id.user_New_password);
        resetPassword = (Button)findViewById(R.id.ResetButton);

        mAuth = FirebaseAuth.getInstance();

        fProgressDialog = new ProgressDialog(this);
    }

    public void change(View v){

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null){

            fProgressDialog.setMessage("Password will Reset, Please Wait");
            fProgressDialog.show();

            user.updatePassword(inputnewPassword.getText().toString())
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()){

                                fProgressDialog.dismiss();
                                Toast.makeText(getApplicationContext(),"Password is Reset", Toast.LENGTH_LONG).show();
                                mAuth.signOut();
                                finish();
                                Intent i = new Intent(ForgetPasswordActivity.this, LoginActivity.class);
                                startActivity(i);
                            } else {

                                fProgressDialog.dismiss();
                                Toast.makeText(getApplicationContext(), "Password is Not Reset", Toast.LENGTH_LONG).show();
                            }
                        }
                    });
        }
    }

    private void signout(){
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        mAuth.signOut();
    }
}
