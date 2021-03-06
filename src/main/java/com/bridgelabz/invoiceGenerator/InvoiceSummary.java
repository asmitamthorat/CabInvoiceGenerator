package com.bridgelabz.invoiceGenerator;

public class InvoiceSummary {
    final int numOfRides;
    final double totalFare;
    final double averageFare;

    public InvoiceSummary(int numOfRides, double totalFare) {
        this.numOfRides=numOfRides;
        this.totalFare=totalFare;
        this.averageFare=this.totalFare/this.numOfRides;

    }

    @Override
    public String toString() {
        return "InvoiceSummary{" +
                "numOfRides=" + numOfRides +
                ", totalFare=" + totalFare +
                ", averageFare=" + averageFare +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvoiceSummary that = (InvoiceSummary) o;
        return numOfRides == that.numOfRides &&
                Double.compare(that.totalFare, totalFare) == 0 &&
                Double.compare(that.averageFare, averageFare) == 0;
    }
}
