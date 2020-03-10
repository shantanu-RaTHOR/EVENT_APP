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

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import static com.example.event_app.fetchevent.email;

public class ftchstudent_l_o extends AppCompatActivity
{
    DatabaseReference databaseparti;
    ListView listvieweparti;
    TextView head;
    List<PartiInfo> patiList;
    public static  String email;
    String eventname="EVENTNAME";
    String partiname="PARTICIPANT";
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ftchstudent_l_o);
        Intent i=getIntent();
        String s=i.getStringExtra(fetchevento.eventname);
        email=i.getStringExtra("Email");
        head=(TextView) findViewById(R.id.head);
        head.setText(s+"'s Participants");
        databaseparti= FirebaseDatabase.getInstance().getReference("Participant").child(s);
        listvieweparti=(ListView) findViewById(R.id.listviewpartio);
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
                                                    arrayaddapterstu add=new arrayaddapterstu(ftchstudent_l_o.this,patiList);
                                                    listvieweparti.setAdapter(add);

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
    public void Home(View v)
    {
        Intent i =new Intent(getApplicationContext(),secactivity.class);
        i.putExtra("Email",email);
        startActivity(i);
    }
}


