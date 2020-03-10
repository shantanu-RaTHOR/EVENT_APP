package com.example.event_app;

public class myeventsp
{
    String eventname;
    String id2;
    public  myeventsp()
    {}
    public myeventsp(String id2,String eventname)
    {
        this.eventname=eventname;
    }

    public String getEventname()
    {
        return eventname;
    }

    public String getId2()
    {
        return id2;
    }
}
