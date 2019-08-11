package com.example.android.quakereport;

public class Earthquake {

    private double magnitude;
    private String location;
    private Long date;
    String url;


    public Earthquake (double mag, String plc, Long dte, String link){
        this.magnitude = mag;
        this.location = plc;
        this.date = dte;
        this.url = link;
    }

    public String getUrl() {
        return url;
    }

    public double getMagnitude() {
        return magnitude;
    }


    public Long getDate() {
        return date;
    }

    public String getLocation() {
        return location;
    }
}
