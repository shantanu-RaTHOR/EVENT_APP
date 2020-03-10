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
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import static android.widget.Toast.LENGTH_LONG;

public class MainActivity extends AppCompatActivity
{

    FirebaseAuth mAuth;
    EditText edittextemail1,edittextpassword1;
    String email,password;
    ProgressBar pb;
    TextView fetchdata;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edittextemail1= (EditText) findViewById(R.id.email);
        pb = (ProgressBar) findViewById(R.id.pbLoading);
        edittextpassword1= (EditText) findViewById(R.id.password);
        FirebaseApp.initializeApp(this);
        mAuth = FirebaseAuth.getInstance();


    }
    private void  userlogin()
    {
        email = edittextemail1.getText().toString().trim();
        password = edittextpassword1.getText().toString().trim();
        if (email.isEmpty())
        {
            pb.setVisibility(ProgressBar.INVISIBLE);
            edittextemail1.setError("mail is empty");
            edittextemail1.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {
            pb.setVisibility(ProgressBar.INVISIBLE);
            edittextemail1.setError("Enter a valid mail");
            edittextemail1.requestFocus();
            return;
        }
        if (password.isEmpty())
        {
            pb.setVisibility(ProgressBar.INVISIBLE);
            edittextpassword1.setError("Passwoed is empty");
            edittextpassword1.requestFocus();
            return;
        }
        if (password.length() < 6)
        {
            pb.setVisibility(ProgressBar.INVISIBLE);
            edittextpassword1.setError("Passwoed should be 6 chars");
            edittextpassword1.requestFocus();
            return;
        }
        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>()
        {

            @Override
            public void onComplete(@NonNull Task<AuthResult> task)
            {
                if(task.isSuccessful())
                {

                    Intent intent= new Intent(MainActivity.this,secactivity.class);
                    intent.putExtra("Email",email);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    //so that user donot come back to previous acctivity using back button
                    pb.setVisibility(ProgressBar.INVISIBLE);
                    startActivity(intent);
                }
                else
                {
                    pb.setVisibility(ProgressBar.INVISIBLE);
                    Toast.makeText(getApplicationContext(),task.getException().getMessage(), LENGTH_LONG).show();
                }
            }
        });
    }

    public void login(View v)
    {
        userlogin();
        pb.setVisibility(ProgressBar.VISIBLE);

    }
    public void signup(View v)
    {
        startActivity(new Intent(this,signup.class));
    }




}
