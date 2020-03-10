package com.example.event_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;

public class signup extends AppCompatActivity
{
    EditText edittextemail,edittextpassword;
    private FirebaseAuth mAuth;
    ProgressBar p;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        edittextemail=(EditText) findViewById(R.id.edittextemail);
        edittextpassword=(EditText) findViewById(R.id.edittextpassword);
        p=(ProgressBar) findViewById(R.id.pbLoading);
        FirebaseApp.initializeApp(this);
        mAuth = FirebaseAuth.getInstance();
    }
    private  void registeruser()
    {
        String email = edittextemail.getText().toString().trim();
        String password;
        password = edittextpassword.getText().toString().trim();
        if (email.isEmpty())
        {
            p.setVisibility(ProgressBar.INVISIBLE);
            edittextemail.setError("mail is empty");
            edittextemail.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {
            p.setVisibility(ProgressBar.INVISIBLE);
            edittextemail.setError("Enter a valid mail");
            edittextemail.requestFocus();
            return;
        }
        if (password.isEmpty())
        {
            p.setVisibility(ProgressBar.INVISIBLE);
            edittextpassword.setError("Passwoed is empty");
            edittextpassword.requestFocus();
            return;
        }
        if (password.length() < 6)
        {
            p.setVisibility(ProgressBar.INVISIBLE);
            edittextpassword.setError("Passwoed should be 6 chars");
            edittextpassword.requestFocus();
            return;
        }
        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful())
                {
                    Toast.makeText(getApplicationContext(),"user registered succesfully",Toast.LENGTH_LONG).show();
                    p.setVisibility(ProgressBar.INVISIBLE);


                }
                else
                {
                    if(task.getException() instanceof FirebaseAuthUserCollisionException)
                    {
                        Toast.makeText(getApplicationContext(),"User already registered,",Toast.LENGTH_LONG).show();
                    }
                    else
                        Toast.makeText(getApplicationContext(),"Error occcured",Toast.LENGTH_LONG).show();

                }
            }


        });
    }
    public void signup(View v)
    {
        registeruser();
        p.setVisibility(ProgressBar.VISIBLE);
    }
    public void login(View v)
    {
        startActivity(new Intent(this, MainActivity.class));
    }




}
