package com.bridgelabz.invoiceGenerator;

public enum RideCategories {
    NORMAL(10,1,5.0),PREMIUM(15,2,20.0);

    public int costPerKM;
    public int costPerMinute;
    public  double minimumFare;
    RideCategories(int costPerKM,int costPerMinute,double minimumFare){
        this.costPerKM=costPerKM;
        this.costPerMinute=costPerMinute;
        this.minimumFare=minimumFare;
    }
}
