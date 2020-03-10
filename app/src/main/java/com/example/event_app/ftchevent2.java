package com.example.event_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import static com.example.event_app.fetchevent.email;

public class ftchevent2 extends AppCompatActivity
{
    DatabaseReference databaseevent;
    ListView listviewevent;
    List<eventinfo> eventList;
    String name,venue,date,time,des,email;
    TextView nme,vnue,dte,tme,ds;
     static String eventnme;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ftchevent2);
        Intent i=getIntent();
        email=i.getStringExtra("Email");
        name=i.getStringExtra(fetchevent.eventname);
        date=i.getStringExtra(fetchevent.edate);
        time=i.getStringExtra(fetchevent.etime);
        venue=i.getStringExtra(fetchevent.evenue);
        des=i.getStringExtra(fetchevent.edes);
        nme=(TextView) findViewById(R.id.name);
        vnue=(TextView) findViewById(R.id.venue);
        dte=(TextView) findViewById(R.id.date);
        tme=(TextView) findViewById(R.id.time);
        ds=(TextView) findViewById(R.id.des);
        setvalue();

    }
    public void setvalue()
    {
        nme.setText(name);
        dte.setText("Date-"+date);
        tme.setText("Time-"+time);
        ds.setText(des);
        vnue.setText("Venue-"+venue);
    }
    public void register(View v)
    {
        Intent i =new Intent(getApplicationContext(),addpartici.class);
        i.putExtra(eventnme,name);
        i.putExtra("Email",email);
        startActivity(i);
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
