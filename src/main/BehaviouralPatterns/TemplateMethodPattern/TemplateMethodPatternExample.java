package main.BehaviouralPatterns.TemplateMethodPattern;


abstract class Beverage{

    public final void prepare(){
        boilWater();
        brew();
        pourInCup();
        addCondiments();
    }

    public void boilWater(){
        System.out.println("Boiling Water");
    }

    public void pourInCup(){
        System.out.println("Pouring into Cup");
    }

    protected abstract void brew();
    protected abstract void addCondiments();
}

class Coffeee extends Beverage{

    @Override
    protected void brew(){
        System.out.println("Boiling water");
    }

    @Override
    protected void addCondiments(){
        System.out.println("Adding sugar and milk");
    }
}

class Chai extends Beverage{

    @Override
    protected void brew(){
        System.out.println("Steeping the tea");
    }

    @Override
    protected void addCondiments() {
        System.out.println("Adding lemon");
    }
}
public class TemplateMethodPatternExample {

    public static void main(String[] args){

        Beverage coffee = new Coffeee();
        coffee.prepare();

        System.out.println("----");

        Beverage tea = new Chai();
        tea.prepare();
    }
}
