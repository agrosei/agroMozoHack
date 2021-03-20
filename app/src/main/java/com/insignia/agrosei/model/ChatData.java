package com.insignia.agrosei.model;

public class ChatData {
    String Etext;
    String Eid;

    public ChatData(String etext,String eid) {
        Etext = etext;
        Eid = eid;
    }

    public String getEtext() {
        return Etext;
    }

    public void setEtext(String etext) {
        Etext = etext;
    }

    public String getEid() {
        return Eid;
    }

    public void setEid(String eid) {
        Eid = eid;
    }
}


