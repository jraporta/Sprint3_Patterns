package org.example;

@FunctionalInterface
public interface PaymentMethod {
    public void pay(double amount);
}
