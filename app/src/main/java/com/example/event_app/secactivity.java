package com.example.event_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import static com.example.event_app.fetchevent.email;

public class secactivity extends AppCompatActivity
{
    String email;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secactivity);
        Intent p=getIntent();
        email=p.getStringExtra("Email");
    }
    public void organ(View v)
    {
        Intent i=new Intent((getApplicationContext()),fetchevento.class);
        i.putExtra("Email",email);
       startActivity(i);
    }
    public void parti(View v)
    {
        Intent i=new Intent((getApplicationContext()),fetchevent.class);
        i.putExtra("Email",email);
        startActivity(i);
    }



}
