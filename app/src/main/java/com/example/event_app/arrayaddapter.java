package com.example.event_app;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class arrayaddapter extends ArrayAdapter<eventinfo>
{
    private Activity context;
    private List<eventinfo> eventList;

    public  arrayaddapter(Activity context, List<eventinfo> eventList)
    {
        super(context,R.layout.listlayout, eventList);
        this.context=context;
        this.eventList=eventList;

    }
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        LayoutInflater inflater=context.getLayoutInflater();
        View listviewitem=inflater.inflate(R.layout.listlayout,null,true);
        TextView textViewname=(TextView)  listviewitem.findViewById(R.id.eventname);
        eventinfo art=eventList.get(position);
        textViewname.setText((art.getNme()));
        return listviewitem;

    }

}
