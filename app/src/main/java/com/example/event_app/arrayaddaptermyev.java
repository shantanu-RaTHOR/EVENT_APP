package com.example.event_app;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class arrayaddaptermyev extends ArrayAdapter<PartiInfo>
{
    private Activity context;
    private List<PartiInfo> partiList;

    public  arrayaddaptermyev(Activity context, List<PartiInfo> partiList)
    {
        //super (context,R.layout.listlayout,eventList);
        super(context,R.layout.listlayoutstu, partiList);
        this.context=context;
        this.partiList=partiList;

    }
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        LayoutInflater inflater=context.getLayoutInflater();
        View listviewitem=inflater.inflate(R.layout.listlayoutstu,null,true);
        TextView textViewname=(TextView)  listviewitem.findViewById(R.id.parti_name);
        PartiInfo art=partiList.get(position);
        textViewname.setText((art.getEventname()));
        return listviewitem;

    }

}

