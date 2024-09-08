package org.example;

import java.util.Optional;

public class PaymentGateway {

    public void executePaymentWith(double amount, PaymentMethod paymentMethod){
        System.out.println("Establishing a cyphered connection with your bank...");
        Optional.ofNullable(paymentMethod).ifPresent((x) -> x.pay(amount));
    }




}
