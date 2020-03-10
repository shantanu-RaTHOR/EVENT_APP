package com.example.event_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import static com.example.event_app.fetchevent.email;
import static com.example.event_app.fetchevent.eventname;

public class addevent extends AppCompatActivity
{
    EditText name,date,time,venue,description;
    Button buttonadd;
    DatabaseReference databaseevent;
    DatabaseReference mycrevent;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addevent);
        name=(EditText) findViewById(R.id.Name);
        date=(EditText) findViewById(R.id.date);
        time=(EditText) findViewById(R.id.time);
        venue=(EditText) findViewById(R.id.venue);
        Intent i=getIntent();
        String email=i.getStringExtra("Email");
        description=(EditText) findViewById(R.id.description);


    }
    public void getevent(View v)
    {
        String nme=name.getText().toString().trim();
        String dte=date.getText().toString().trim();
        String tme=time.getText().toString().trim();
        String vnue=venue.getText().toString().trim();
        String dscription=description.getText().toString().trim();
        databaseevent= FirebaseDatabase.getInstance().getReference("Events");
        String e=email.substring(0,(email.length()-10));
        mycrevent= FirebaseDatabase.getInstance().getReference("MY CREATED EVENTS").child(e);
        if((!TextUtils.isEmpty(dte))&&(!TextUtils.isEmpty(nme))&&(!TextUtils.isEmpty(tme))&&(!TextUtils.isEmpty(vnue))&&(!TextUtils.isEmpty(dscription)))
        {
            String id= databaseevent.push().getKey();
            eventinfo in=new eventinfo(nme,dte,tme,vnue,dscription,id);
            databaseevent.child(id).setValue(in);
            id=mycrevent.push().getKey();
            myeventsp inn=new myeventsp(id,nme);
            mycrevent.child(id).setValue(inn);
            Toast.makeText(this,"Event added",Toast.LENGTH_LONG).show();

        }
        else
        {
            Toast.makeText(this,"Fill all the information",Toast.LENGTH_LONG).show();
        }
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
        i.putExtra("Email", email);
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




