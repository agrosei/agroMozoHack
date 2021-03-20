package com.insignia.agrosei.model;

public class CropData {
    String Ecrop,Etime,Eimg;
    int Eprogress;

    public CropData(String ecrop, String etime, int eprogress,String eimg) {
        Ecrop = ecrop;
        Etime = etime;
        Eprogress = eprogress;
        Eimg = eimg;
    }

    public String getEimg() {
        return Eimg;
    }

    public void setEimg(String eimg) {
        Eimg = eimg;
    }

    public String getEcrop() {
        return Ecrop;
    }

    public void setEcrop(String ecrop) {
        Ecrop = ecrop;
    }

    public String getEtime() {
        return Etime;
    }

    public void setEtime(String etime) {
        Etime = etime;
    }

    public int getEprogress() {
        return Eprogress;
    }

    public void setEprogress(int eprogress) {
        Eprogress = eprogress;
    }
}
