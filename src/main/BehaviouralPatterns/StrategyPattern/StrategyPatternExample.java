package main.BehaviouralPatterns.StrategyPattern;

interface PaymentStrategy{
    void pay2();
}

class CreditCardPayment implements PaymentStrategy{
    @Override
    public void pay2(){
        System.out.println("Paying through Credit Card");
    }
}

class DebitCardPayment implements PaymentStrategy{
    @Override
    public void pay2(){
        System.out.println("Paying through Debit Card");
    }
}

class CashPayment implements PaymentStrategy{
    @Override
    public void pay2(){
        System.out.println("Paying through cash");
    }
}

class PaymentService2{

    private PaymentStrategy paymentStrategy;

    public PaymentService2(PaymentStrategy paymentStrategy){
        this.paymentStrategy=paymentStrategy;
    }

    public void pay(){
        paymentStrategy.pay2();
    }
}

public class StrategyPatternExample {

    public static void main(String[] args){

        PaymentStrategy paymentStrategy = new CreditCardPayment();
        PaymentStrategy paymentStrategy1 = new DebitCardPayment();

        PaymentService2 paymentService2 = new PaymentService2(paymentStrategy);
        paymentService2.pay();
        PaymentService2 paymentService3 = new PaymentService2(paymentStrategy1);
        paymentService3.pay();

    }
}
