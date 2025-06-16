interface PaymentProcessor {
    void processPayment(double amount);
}

class PayPalGateway {
    public void sendPayment(double amount) {
        System.out.println("Paid $" + amount + " using PayPal.");
    }
}

class StripeGateway {
    public void makePayment(double amount) {
        System.out.println("Paid $" + amount + " using Stripe.");
    }
}

class RazorpayGateway {
    public void doTransaction(double amount) {
        System.out.println("Paid $" + amount + " using Razorpay.");
    }
}

class PayPalAdapter implements PaymentProcessor {
    private PayPalGateway paypal;

    public PayPalAdapter(PayPalGateway paypal) {
        this.paypal = paypal;
    }

    public void processPayment(double amount) {
        paypal.sendPayment(amount);
    }
}

class StripeAdapter implements PaymentProcessor {
    private StripeGateway stripe;

    public StripeAdapter(StripeGateway stripe) {
        this.stripe = stripe;
    }

    public void processPayment(double amount) {
        stripe.makePayment(amount);
    }
}

class RazorpayAdapter implements PaymentProcessor {
    private RazorpayGateway razorpay;

    public RazorpayAdapter(RazorpayGateway razorpay) {
        this.razorpay = razorpay;
    }

    public void processPayment(double amount) {
        razorpay.doTransaction(amount);
    }
}

public class AdapterPatternExample {
    public static void main(String[] args) {
        PaymentProcessor paypal = new PayPalAdapter(new PayPalGateway());
        paypal.processPayment(150.00);

        PaymentProcessor stripe = new StripeAdapter(new StripeGateway());
        stripe.processPayment(250.00);

        PaymentProcessor razorpay = new RazorpayAdapter(new RazorpayGateway());
        razorpay.processPayment(350.00);
    }
}
