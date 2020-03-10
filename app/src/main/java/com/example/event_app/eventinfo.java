package com.example.event_app;

import java.util.List;

public class eventinfo
{

    String dte;
    String vnue;
    String dscription;
    String tme;
    String nme;
    String id;
    public eventinfo(fetchevent fetchevent, List<eventinfo> eventList)
    {

    }
    public eventinfo()
    {}


    public eventinfo(String nme,String dte, String tme, String vnue, String dscription,String id)
    {
        this.nme=nme;
        this.dte=dte;
        this.vnue=vnue;
        this.dscription=dscription;
        this.tme=tme;
        this.id=id;
    }
    public String getNme()
    {
        return  nme;
    }
    public String getDte()
    {
        return  dte;
    }
    public String getTme()
    {
        return tme;
    }
    public String getVnue()
    {
        return vnue;
    }
    public String getDscription()
    {
        return dscription;
    }

    public String getId()
    {
        return id;
    }
}
