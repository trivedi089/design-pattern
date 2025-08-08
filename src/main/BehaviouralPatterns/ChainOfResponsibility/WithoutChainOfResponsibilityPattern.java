package main.BehaviouralPatterns.ChainOfResponsibility;

class RequestProcessor{

    public void process(String request){

        if(!request.contains("auth")){
            System.out.println("Authentication failed...");
            return;
        }

        if(!request.contains("admin")){
            System.out.println("Authorization failed");
            return;
        }

        if(request.length()<=5){
            System.out.println("Validation failed...");
            return;
        }

        System.out.println("Request successully processed");
    }
}

public class WithoutChainOfResponsibilityPattern {

    public static void main(String[] args){
        RequestProcessor requestProcessor = new RequestProcessor();

        requestProcessor.process("auth admin request123");
        requestProcessor.process("---- Second Request ----");
    }
}
