package org.example;

public class Paypal implements PaymentMethod{
    @Override
    public void pay(double amount, PaymentCallback paymentCallback) {
        System.out.printf("Completed a %.2f payment using Paypal.%n", amount);
        paymentCallback.execute();
    }
}
