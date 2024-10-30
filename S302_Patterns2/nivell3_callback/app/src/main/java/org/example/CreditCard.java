package org.example;

public class CreditCard implements PaymentMethod{

    @Override
    public void pay(double amount, PaymentCallback callback) {
        if (amount > 300){
            System.out.println("Could not complete the payment. The amount requested is above your limit.");
        }else{
            System.out.printf("Completed a %.2f payment with your credit card.%n", amount);
        }
        callback.execute();
    }
}
