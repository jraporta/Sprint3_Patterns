package org.example;

public class VisaPaymentCallback implements PaymentCallback{

    @Override
    public void execute() {
        System.out.println("Notify via SMS to recipient.");
    }

}
