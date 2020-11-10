package com.bridgelabz.invoiceGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RideRepository {

    Map<String, ArrayList> userRides=null;

    public RideRepository(){
        this.userRides=new HashMap<>();
    }

    public void addRide(String userId,Ride[] rides){
        ArrayList<Ride> rideArrayList =this.userRides.get(userId);
        if(rideArrayList==null){
            this.userRides.put(userId,new ArrayList<>((Arrays.asList(rides))));
        }
    }

    public Ride[] getRides(String userID){
        return (Ride[]) this.userRides.get(userID).toArray(new Ride[0]);
    }

}
