package main.BehaviouralPatterns.StrategyPattern;


class PaymentService{
    public void pay(String method){
        if(method=="CREDIT CARD"){
            System.out.println("Payment method :"+method);
        }else if(method=="DEBIT CARD"){
            System.out.println("Payment method :"+method);
        }else if(method=="CASH"){
            System.out.println("Payment method : "+ method);
        }
    }
}
public class WithoutStrategyPattern {
    public static void main(String[] args){
        PaymentService paymentService = new PaymentService();
        paymentService.pay("CREDIT CARD");
        paymentService.pay("CASH");
    }
}
