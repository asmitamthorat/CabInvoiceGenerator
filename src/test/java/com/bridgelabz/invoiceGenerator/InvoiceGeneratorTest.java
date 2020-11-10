package com.bridgelabz.invoiceGenerator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class InvoiceGeneratorTest {
   InvoiceGenerator invoiceGenerator=null;
   RideRepository rideRepository=null;
   Ride[] rides;

   @Before
    public void setUp(){
       invoiceGenerator=new InvoiceGenerator();
       rideRepository=new RideRepository();
       invoiceGenerator.setRideRepository(rideRepository);
   }

   @Test
    public void givenDistanceAndTime_ShouldReturnTotalFare() throws InvoiceGeneratorException{
       rides=new Ride[]{
                new Ride(CabRide.NORMAL,2.0,5)
       };
       InvoiceSummary summary =invoiceGenerator.calculateFare(rides);
       InvoiceSummary expectedInvoiceSummary=new InvoiceSummary(1,25.0);
       Assert.assertEquals(expectedInvoiceSummary,summary);
   }

}
