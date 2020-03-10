package com.example.event_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import static com.example.event_app.fetchevent.email;

public class info extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);



    }
    public void home(View v)
    {
        Intent i =new Intent(getApplicationContext(),fetchevent.class);
        i.putExtra("Email",email);
        startActivity(i);
    }
    public void info(View v)
    {
        Intent i =new Intent(getApplicationContext(),info.class);
        i.putExtra("Email",email);
        startActivity(i);
    }
    public void organ(View v)
    {

        Intent i =new Intent(getApplicationContext(),fetchevento.class);
        i.putExtra("Email",email);
        startActivity(i);
    }
    public void  myevent(View v)
    {
        Intent i =new Intent(getApplicationContext(),myevent.class);
        i.putExtra("Email",email);
        startActivity(i);
    }
    public void Home(View v)
    {
        Intent i =new Intent(getApplicationContext(),secactivity.class);
        i.putExtra("Email",email);
        startActivity(i);
    }




}
