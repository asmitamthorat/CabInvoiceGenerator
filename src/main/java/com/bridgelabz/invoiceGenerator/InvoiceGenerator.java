package com.bridgelabz.invoiceGenerator;

public class InvoiceGenerator {
    public double calculateFare(double distance, int time) {
        Double totalFare= distance*RideCategories.NORMAL.costPerKM+time*RideCategories.NORMAL.costPerMinute;
        if(totalFare<RideCategories.NORMAL.minimumFare){
            totalFare=RideCategories.NORMAL.minimumFare;
        }
        return totalFare;
    }

    public InvoiceSummary calculateFare(Ride[] rides) throws InvoiceGeneratorException {

        double totalFare = 0;
        for (Ride ride:rides) {
            totalFare +=this.calculateFare(ride.distance,ride.time,ride.preminum);
        }
        return new InvoiceSummary(rides.length,totalFare);
    }

    public double calculateFare(double distance, int time,RideCategories subscriptionMode) throws InvoiceGeneratorException {

        double totalFare = 0;
        double fare=0;
        if (subscriptionMode==RideCategories.PREMIUM) {
            fare= distance*RideCategories.PREMIUM.costPerKM+time*RideCategories.PREMIUM.costPerMinute;
            fare= Math.max(fare,RideCategories.PREMIUM.minimumFare);
        }
        if(subscriptionMode==RideCategories.NORMAL){
            fare=calculateFare( distance, time);
        }
        totalFare=totalFare+fare;
        return totalFare;
    }
}
