package main.StructuralPattern.DecoratorPattern;

//component
interface Coffeee{
    double cost();
    String description();
}

//concrete Component
class SimpleCoffee implements Coffeee{

    @Override
    public double cost() {
        return 10.0;
    }

    @Override
    public String description() {
        return "Simple Coffee";
    }
}

//Base Decorator
abstract class CoffeeDecorator implements Coffeee{

    protected Coffeee decoratedCoffeee;

    public CoffeeDecorator(Coffeee coffeee){
        this.decoratedCoffeee=coffeee;
    }

    public double cost() { return decoratedCoffeee.cost(); }
    public String description() { return decoratedCoffeee.description(); }
}

//concrete decorators
class MilkDecorator extends CoffeeDecorator {
    public MilkDecorator(Coffeee coffee) { super(coffee); }
    public double cost() { return super.cost() + 1.5; }
    public String description() { return super.description() + ", Milk"; }
}

class SugarDecorator extends CoffeeDecorator {
    public SugarDecorator(Coffeee coffee) { super(coffee); }
    public double cost() { return super.cost() + 0.5; }
    public String description() { return super.description() + ", Sugar"; }
}


public class DecoratorPatternExample {

    public static void main(String[] args) {
        Coffeee coffee = new SimpleCoffee();
        coffee = new MilkDecorator(coffee);  // Add milk
        coffee = new SugarDecorator(coffee); // Add sugar

        System.out.println(coffee.description() + " -> $" + coffee.cost());
    }
}
