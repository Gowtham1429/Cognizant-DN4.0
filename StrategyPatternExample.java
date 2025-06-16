interface PaymentStrategy {
    void pay(int amount);
}

class CreditCardPayment implements PaymentStrategy {
    public void pay(int amount) {
        System.out.println("Paid ₹" + amount + " using Credit Card.");
    }
}

class PayPalPayment implements PaymentStrategy {
    public void pay(int amount) {
        System.out.println("Paid ₹" + amount + " using PayPal.");
    }
}

class PaymentContext {
    private PaymentStrategy strategy;

    public void setPaymentStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void payAmount(int amount) {
        if (strategy != null) {
            strategy.pay(amount);
        } else {
            System.out.println("Payment strategy not set!");
        }
    }
}

public class StrategyPatternExample {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();

        context.setPaymentStrategy(new CreditCardPayment());
        context.payAmount(500);

        context.setPaymentStrategy(new PayPalPayment());
        context.payAmount(1200);
    }
}
