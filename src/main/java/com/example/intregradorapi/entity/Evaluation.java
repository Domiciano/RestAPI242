package com.example.intregradorapi.entity;


public class Evalutation {

    private long id;
    private Readings readings;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Readings getReadings() {
        return readings;
    }

    public void setReadings(Readings readings) {
        this.readings = readings;
    }
}
