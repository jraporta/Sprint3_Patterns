package org.example;

public class BankTransfer implements PaymentMethod{
    @Override
    public void pay(double amount) {
        System.out.printf("Completed a %.2f payment doing a Bank Transfer.%n", amount);
    }
}