package com.bridgelabz.invoiceGenerator;

import java.util.List;

public class InvoiceService {
    private final List<RideRepository> repositories;
    public InvoiceService(List<RideRepository> repositories) {
        this.repositories=repositories;
    }



    public InvoiceSummary getSummary(String userID) throws InvoiceGeneratorException {
        InvoiceSummary invoiceSummary = null;
        for (RideRepository repo:repositories) {
            if(repo.userId.equalsIgnoreCase(userID)){
                invoiceSummary=new InvoiceGenerator().calculateFare(repo.rides);
            }
        }
        return invoiceSummary;
    }
}
