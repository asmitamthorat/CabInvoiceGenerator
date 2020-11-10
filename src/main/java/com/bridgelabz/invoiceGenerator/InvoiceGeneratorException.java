package com.bridgelabz.invoiceGenerator;

public class InvoiceGeneratorException extends Exception {
    public ExceptionType type;

    public enum ExceptionType{
        LESS_FARE,INVALID_LOGIN,USERNAME_NULL;
    }

    public InvoiceGeneratorException(ExceptionType type,String msg){
        super(msg);
        this.type=type;
    }
}
