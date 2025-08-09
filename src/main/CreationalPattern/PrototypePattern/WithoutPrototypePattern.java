package main.CreationalPattern.PrototypePattern;

class Vehicle {
    String type;
    String engine;

    public Vehicle(String type, String engine) {
        this.type = type;
        this.engine = engine;
    }
}

public class WithoutPrototypePattern {

    public static void main(String[] args) {
        Vehicle car1 = new Vehicle("Car", "V8");
        Vehicle car2 = new Vehicle("Car", "V8"); // Redundant setup
    }
}
