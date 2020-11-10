package com.bridgelabz.invoiceGenerator;

public class InvoiceGenerator {

    private RideRepository rideRepository;

    void setRideRepository(RideRepository rideRepository){
        this.rideRepository=rideRepository;
    }



    public InvoiceSummary calculateFare(Ride[] rides) throws InvoiceGeneratorException {

        double totalFare = 0;
        for (Ride ride:rides) {
            totalFare +=ride.cabRide.calCostOfCabRide(ride);
        }
        if(totalFare<5){
            throw new InvoiceGeneratorException(InvoiceGeneratorException.ExceptionType.LESS_FARE,"assigning minimum fare");
        }
        return new InvoiceSummary(rides.length,totalFare);
    }

    public void addRides(String userID,Ride[] rides) throws InvoiceGeneratorException{
        if(userID=="abc"){
            rideRepository.addRide(userID,rides);
        }
        if(userID==null){
            throw  new InvoiceGeneratorException(InvoiceGeneratorException.ExceptionType.USERNAME_NULL,"Null UserName");
        }
        if(userID!="abc"){
            throw new InvoiceGeneratorException(InvoiceGeneratorException.ExceptionType.INVALID_LOGIN,"Wrong user Name");
        }
    }

    public InvoiceSummary getInvoiceSummary(String userID) throws InvoiceGeneratorException{
        return this.calculateFare(rideRepository.getRides(userID));
    }


}
