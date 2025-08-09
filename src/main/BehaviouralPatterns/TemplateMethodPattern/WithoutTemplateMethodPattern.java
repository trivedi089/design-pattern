package main.BehaviouralPatterns.TemplateMethodPattern;

class Coffee{

    public void prepare(){
        System.out.println("Boiling Water");
        System.out.println("Brewing Coffee");
        System.out.println("Pouring into Cup");
        System.out.println("Adding sugar and milk");
    }
}

class Tea{

    //Repeated steps (boiling, pouring)
    public void prepare(){
        System.out.println("Boiling Water");
        System.out.println("Steeping the tea");
        System.out.println("Pouring into Cup");
        System.out.println("Adding lemon");
    }
}
public class WithoutTemplateMethodPattern {

    public static void main(String[] args){
        Coffee coffee = new Coffee();
        coffee.prepare();

        Tea tea = new Tea();
        tea.prepare();
    }
}
