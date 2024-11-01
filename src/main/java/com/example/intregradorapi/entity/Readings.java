package com.example.intregradorapi.entity;

import java.util.List;

public class Readings {

    private List<Point> accelerometer;
    private List<Point> gyroscope;


    public List<Point> getAccelerometer() {
        return accelerometer;
    }

    public void setAccelerometer(List<Point> accelerometer) {
        this.accelerometer = accelerometer;
    }

    public List<Point> getGyroscope() {
        return gyroscope;
    }

    public void setGyroscope(List<Point> gyroscope) {
        this.gyroscope = gyroscope;
    }
}
