package com.example.event_app;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
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

public class myevent extends AppCompatActivity
{
    String email;
    DatabaseReference databaseparti;
    ListView listvieweparti;
    TextView head;
    List<PartiInfo> patiList;
    String eventname="EVENTNAME";
    String partiname="PARTICIPANT";
    DatabaseReference databaseevent;
    ListView listviewevent;
    List<eventinfo> eventList;
    ProgressBar p;
    TextView accnm;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myevent);
        Intent i=getIntent();
        email=i.getStringExtra("Email");
        accnm=(TextView) findViewById(R.id.acc);
        accnm.setText("Acc.:-"+email);
        String e=email.substring(0,(email.length()-10));
        databaseparti= FirebaseDatabase.getInstance().getReference("MY PARTICIPATED EVENTS").child(e);
        listvieweparti=(ListView) findViewById(R.id.listviewevent1);
        patiList=new ArrayList<>();


    }
    @Override
    protected void onStart()
    {
        super.onStart();
        databaseparti.addValueEventListener(new ValueEventListener()
                                            {
                                                @Override
                                                public void onDataChange(@NonNull DataSnapshot dataSnapshot)
                                                {
                                                    patiList.clear();
                                                    for (DataSnapshot aristsnapshort:dataSnapshot.getChildren())
                                                    {
                                                        PartiInfo info=aristsnapshort.getValue(PartiInfo.class);
                                                        patiList.add(info);
                                                    }
                                                    arrayaddaptermyev add=new arrayaddaptermyev(myevent.this,patiList);
                                                    listvieweparti.setAdapter(add);

                                                }

                                                @Override
                                                public void onCancelled(@NonNull DatabaseError databaseError)
                                                {

                                                }
                                            }
        );
    }
    public void Home(View v)
    {
        Intent i =new Intent(getApplicationContext(),secactivity.class);
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

    }


}
