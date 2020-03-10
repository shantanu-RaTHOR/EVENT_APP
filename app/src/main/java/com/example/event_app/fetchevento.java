package com.example.event_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import static com.example.event_app.fetchevent.email;

public class fetchevento extends AppCompatActivity
{
    DatabaseReference databaseevent;
    ListView listviewevent;
    List<eventinfo> eventList;
    public static String eventname="Eventname";
    public static String eventid="Eventid";
    public static  String email;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fetchevento);
        databaseevent= FirebaseDatabase.getInstance().getReference("Events");
        listviewevent=(ListView) findViewById(R.id.listviewevento);
        Intent i=getIntent();
        email=i.getStringExtra("Email");
        eventList=new ArrayList<>();
        listviewevent.setOnItemClickListener(new AdapterView.OnItemClickListener() //for action when any item in list is clicked
        {
            @Override
            public void onItemClick(AdapterView <?> parent, View view, int position, long id)
            {
                eventinfo e=eventList.get(position);//position denotes position of item in list
                Intent i =new Intent(getApplicationContext(),ftchstudent_l_o.class);
                i.putExtra("Email",email);
                i.putExtra(eventname,e.getNme());
                i.putExtra(eventid,e.getId());
                startActivity(i);
            }
        });

    }
    @Override
    protected void onStart()
    {
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
                                                    arrayaddaptero add=new arrayaddaptero(fetchevento.this,eventList);
                                                    listviewevent.setAdapter(add);

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
        Intent i =new Intent(getApplicationContext(),mycrevents.class);
        i.putExtra("Email",email);
        startActivity(i);
    }
    public void crevent(View v)
    {
        Intent i =new Intent(getApplicationContext(),addevent.class);
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
