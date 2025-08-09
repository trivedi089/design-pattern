package main.StructuralPattern;

// Base coffee
class Coffee{
    public double cost(){
        return 5.0;
    }
    public String description(){
        return "simple coffee";
    }
}

// Coffee with Milk
class CoffeeWithMilk extends Coffee{

    @Override
    public double cost() {
        return super.cost()+10.0;
    }

    @Override
    public String description() {
        return super.description()+" with Milk";
    }
}

// Coffee with Milk and Sugar (new subclass needed)
class CoffeeWithMilkAndSugar extends Coffee{

    @Override
    public double cost() {
        return super.cost()+20.0;
    }

    @Override
    public String description() {
        return super.description()+" with Milk and sugar";
    }
}
public class WithoutDecoratorPattern {

    public static void main(String[] args){
        Coffee coffee = new Coffee();
        System.out.println(coffee.description());
        CoffeeWithMilk coffeeWithMilk = new CoffeeWithMilk();
        System.out.println(coffeeWithMilk.description());
        CoffeeWithMilkAndSugar coffeeWithMilkAndSugar = new CoffeeWithMilkAndSugar();
        System.out.println(coffeeWithMilkAndSugar.description());
    }
}
