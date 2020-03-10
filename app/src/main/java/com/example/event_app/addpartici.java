package com.example.event_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import static com.example.event_app.fetchevent.email;
import static com.example.event_app.fetchevent.eventid;
import static com.example.event_app.fetchevent.eventname;

public class addpartici extends AppCompatActivity
{
    TextView enme,Email;
    EditText pname;
    EditText pyear;
    EditText pbranch;
    EditText proll;
    DatabaseReference mycrevent;
    String e;
    String eventname;
    DatabaseReference databasep;
    String year;
    String branch;
    String roll;
    String id;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addpartici);
        Email=(TextView) findViewById(R.id.email);
        enme=(TextView) findViewById(R.id.ename);
        pname=(EditText) findViewById(R.id.namep);
        pyear=(EditText) findViewById(R.id.yearp);
        pbranch=(EditText) findViewById(R.id.branchp);
        proll=(EditText) findViewById(R.id.rollp);
        Intent i=getIntent();
         email=i.getStringExtra("Email");
        e=email.substring(0,(email.length()-10));
         eventname=i.getStringExtra(ftchevent2.eventnme);
        databasep= FirebaseDatabase.getInstance().getReference("Participant").child(eventname);
        mycrevent= FirebaseDatabase.getInstance().getReference("MY PARTICIPATED EVENTS").child(e);

        enme.setText(eventname);
        Email.setText(email);

    }
    public void addp(View v)
    {
      String  name=pname.getText().toString().trim();
      String year=pyear.getText().toString().trim();
      String branch=pbranch.getText().toString().trim();
      String roll=proll.getText().toString().trim();
        if((!TextUtils.isEmpty(name))&&(!TextUtils.isEmpty(year))&&(!TextUtils.isEmpty(branch))&&(!TextUtils.isEmpty(roll)))
        {
            String id= databasep.push().getKey();
            PartiInfo in=new PartiInfo(id,name,year,branch,roll);
            databasep.child(id).setValue(in);
            id=mycrevent.push().getKey();
            myeventsp inn=new myeventsp(id,eventname);
            mycrevent.child(id).setValue(inn);
            Toast.makeText(this,"Participant added",Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(this,"PLEASE FILL ALL DETAILS",Toast.LENGTH_LONG).show();
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
