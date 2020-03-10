package com.example.event_app;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class fetchevent extends AppCompatActivity
{
    DatabaseReference databaseevent;
    ListView listviewevent;
    List<eventinfo> eventList;
    ProgressBar p;
    public static String eventname="Eventname";
    public static String eventid="Eventid";
    public static String edate="23";
    public static String etime="5pm";
    public static String evenue="JSS";
    public static String edes="des";
    public static String email;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fetchevent);
        databaseevent= FirebaseDatabase.getInstance().getReference("Events");
        listviewevent=(ListView) findViewById(R.id.listviewevent);
        p=(ProgressBar) findViewById(R.id.pbLoading);
        Intent p=getIntent();
         email=p.getStringExtra("Email");
        eventList=new ArrayList<>();
        listviewevent.setOnItemClickListener(new AdapterView.OnItemClickListener() //for action when any item in list is clicked
        {
            @Override
            public void onItemClick(AdapterView <?> parent, View view, int position, long id)
            {
                eventinfo e=eventList.get(position);//position denotes position of item in list
                Intent i =new Intent(getApplicationContext(),ftchevent2.class);
                i.putExtra("Email",email);
                i.putExtra(eventname,e.getNme());
                i.putExtra(eventid,e.getId());
                i.putExtra(edate,e.getDte());
                i.putExtra(evenue,e.getVnue());
                i.putExtra(etime,e.getTme());
                i.putExtra(edes,e.getDscription());
                startActivity(i);
            }
        });

    }
    @Override
    protected void onStart()
    {
        final ProgressDialog progressDialog = new ProgressDialog(fetchevent.this);
        progressDialog.setMessage("Loading Events list");
        progressDialog.setTitle("");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.show();
        progressDialog.setCancelable(false);
        super.onStart();
        databaseevent.addValueEventListener(new ValueEventListener()
                                            {
                                                @Override
                                                public void onDataChange(@NonNull DataSnapshot dataSnapshot)
                                                {
                                                    eventList.clear();
                                                    for (DataSnapshot aristsnapshort:dataSnapshot.getChildren())
                                                    {
                                                        eventinfo info=aristsnapshort.getValue(eventinfo.class);
                                                        eventList.add(info);
                                                    }
                                                    arrayaddapter add=new arrayaddapter(fetchevent.this,eventList);
                                                    listviewevent.setAdapter(add);
                                                    progressDialog.dismiss();

                                                }

                                                @Override
                                                public void onCancelled(@NonNull DatabaseError databaseError)
                                                {

                                                }

                                            }
        );
    }
    public void home(View v)
    {
        Toast.makeText(fetchevent.this,"ALREADY ON HOME",Toast.LENGTH_LONG).show();
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
