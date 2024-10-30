package org.example;

public class App {

    public static void main(String[] args) {

        PaymentMethod visa = new CreditCard();
        PaymentMethod paypal = new Paypal();
        PaymentMethod bank = new BankTransfer();
        PaymentGateway paymentGateway = new PaymentGateway();

        paymentGateway.executePaymentWith(85, visa, new VisaPaymentCallback());
        paymentGateway.executePaymentWith(385, visa, new VisaPaymentCallback());
        paymentGateway.executePaymentWith(30, paypal, () -> System.out.println("Send email to paypal recipient."));
        paymentGateway.executePaymentWith(285, bank, () -> {});
    }
}
