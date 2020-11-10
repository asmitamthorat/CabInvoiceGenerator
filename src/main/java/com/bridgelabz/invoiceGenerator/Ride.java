package com.bridgelabz.invoiceGenerator;

public class Ride {
    double distance;
    int time;
    RideCategories preminum;

    public Ride(double distance, int time, RideCategories preminum) {
        this.distance=distance;
        this.time=time;
        this.preminum=preminum;

    }
}
