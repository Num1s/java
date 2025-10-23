package Classworks;

abstract class Payment {
    public abstract void processPayment(double amount);
}

interface Refundable {
    void refund(double amount);
}

class CreditCardPayment extends Payment {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing credit card payment of $" + amount);
        System.out.println("Verifying card details...");
        System.out.println("Charging the credit card...");
        System.out.println("Credit card payment successful!");
    }
}

class PayPalPayment extends Payment implements Refundable {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing PayPal payment of $" + amount);
        System.out.println("Verifying PayPal account...");
        System.out.println("Completing PayPal transaction...");
        System.out.println("PayPal payment successful!");
    }

    @Override
    public void refund(double amount) {
        System.out.println("Initiating refund of $" + amount + " through PayPal...");
        System.out.println("Refund successful! Amount returned to customer’s PayPal account.");
    }
}

public class PaymentActivity {
    public static void main(String[] args) {
        Payment credit = new CreditCardPayment();
        credit.processPayment(120.50);

        System.out.println();

        PayPalPayment paypal = new PayPalPayment();
        paypal.processPayment(75.00);
        paypal.refund(75.00);
    }
}

