package main.BehaviouralPatterns.ChainOfResponsibility;

import javax.management.relation.Role;

abstract class Handler{
    protected Handler next;

    public Handler setNext(Handler next){
        this.next=next;
        return next;
    }

    public abstract void handle(String request);
}

class AuthHandler extends Handler{

    public void handle(String request){
        if(request.contains("auth")){
            System.out.println("Authentication passed.");
            if(next != null)    next.handle(request);
        }else{
            System.out.println("Authentication Failed");
        }
    }
}

class RoleHandler extends Handler{

    public void handle(String request){
        if(request.contains(("admin"))){
            System.out.println("Authorization passed");
            if(next !=null) next.handle(request);
        }else{
            System.out.println("Authorization failed");
        }
    }
}

class ValidatorHandler extends Handler{

    public void handle(String request){
        if(request.length()>5){
            System.out.println("Validation passed");
            if(next !=null) next.handle(request);
        }else{
            System.out.println("Validation Failed");
        }
    }
}


public class ChainOfResponsibilityExample {

    public static void main(String[] args){

        AuthHandler auth = new AuthHandler();
        RoleHandler role = new RoleHandler();
        ValidatorHandler validator = new ValidatorHandler();

        auth.setNext(role).setNext(validator);

        System.out.println("---- First Request ----");
        auth.handle("auth admin request123");

        System.out.println("---- Second Request ----");
        auth.handle("bad request");
    }
}
