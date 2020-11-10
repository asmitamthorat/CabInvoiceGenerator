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

   @Test
    public void givenMultipleRides_shouldReturnInvoiceSummary() throws InvoiceGeneratorException{
       rides=new Ride[]{
               new Ride(CabRide.NORMAL,2.0,5),
               new Ride(CabRide.PREMIUM,0.1,1)
       };
       InvoiceSummary summary=invoiceGenerator.calculateFare(rides);
       InvoiceSummary expectedInvoiceSummary =new InvoiceSummary(2,45);
       Assert.assertEquals(expectedInvoiceSummary,summary);
   }

   @Test
    public void givenUserIdAndRides_ShouldReturnInvoiceSummary() throws InvoiceGeneratorException{
       String userId="abc";
       rides=new Ride[]{
               new Ride(CabRide.NORMAL,2.0,5),
               new Ride(CabRide.PREMIUM,0.1,1)
       };
       InvoiceSummary summary=invoiceGenerator.calculateFare(rides);
       InvoiceSummary expectedInvoiceSummary =new InvoiceSummary(2,45);
       Assert.assertEquals(expectedInvoiceSummary,summary);
   }

    @Test
    public void givenWrongUserIdAndRides_ShouldThrowsException() throws InvoiceGeneratorException{
       try{
           String userId="abcd";
           rides=new Ride[]{
                   new Ride(CabRide.NORMAL,2.0,5),
                   new Ride(CabRide.PREMIUM,0.1,1)
           };
           InvoiceSummary summary=invoiceGenerator.calculateFare(rides);
           InvoiceSummary expectedInvoiceSummary =new InvoiceSummary(2,45);
           Assert.assertEquals(expectedInvoiceSummary,summary);
       }catch (InvoiceGeneratorException invoiceGeneratorException){
           Assert.assertEquals("Wrong user Name",invoiceGeneratorException.getMessage());
       }

    }


    @Test
    public void givenMinimumFare_ShouldThrowsException() throws InvoiceGeneratorException{
        try{
            String userId="abc";
            rides=new Ride[]{
                    new Ride(CabRide.NORMAL,0.1,1)

            };
            InvoiceSummary summary=invoiceGenerator.calculateFare(rides);
            InvoiceSummary expectedInvoiceSummary =new InvoiceSummary(1,5);
            Assert.assertEquals(expectedInvoiceSummary,summary);
        }catch (InvoiceGeneratorException invoiceGeneratorException){
            Assert.assertEquals("assigning minimum fare",invoiceGeneratorException.getMessage());
        }

    }




}
