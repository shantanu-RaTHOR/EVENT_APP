package com.example.event_app;

public class PartiInfo
{
    private String id;
    private String name;
    private String year;
    private String branch;
    private String roll;
    String eventname;
    public  PartiInfo()
    {}
    public PartiInfo(String id,String name,String year,String branch,String roll)
    {
        this.id=id;
        this.name=name;
        this.year=year;
        this.branch=branch;
        this.roll=roll;
    }

    public String getEventname()
    {
        return eventname;
    }

    public String getId()
    {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getYear()
    {
        return year;
    }

    public String getBranch() {
        return branch;
    }

    public String getRoll()
    {
        return roll;
    }
}
