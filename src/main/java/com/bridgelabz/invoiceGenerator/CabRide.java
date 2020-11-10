package com.bridgelabz.invoiceGenerator;

public enum CabRide {
    NORMAL(10.0,1.0,5.0),PREMIUM(15.0,2.0,20.0);

    public final double costPerKM;
    public final double costPermin;
    public final double minFarePerRide;

    CabRide(double costPerKM,double costPermin,double minFarePerRide){
        this.costPerKM=costPerKM;
        this.costPermin=costPermin;
        this.minFarePerRide=minFarePerRide;
    }

    public double calCostOfCabRide(Ride ride){
        double rideCost=ride.distance*costPerKM+ride.time*costPermin;
        return Math.max(rideCost,minFarePerRide);
    }
}
