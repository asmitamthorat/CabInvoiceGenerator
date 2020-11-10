package com.bridgelabz.invoiceGenerator;

public class RideRepository {
    final String userId;
    final Ride[] rides;

    public RideRepository(String userId, Ride[] rides) {
        this.userId=userId;
        this.rides=rides;
    }
}
