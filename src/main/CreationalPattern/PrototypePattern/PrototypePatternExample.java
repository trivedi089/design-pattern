package main.CreationalPattern.PrototypePattern;

class Vehiclee implements Cloneable {
    String type;
    String engine;

    public Vehiclee(String type, String engine) {
        this.type = type;
        this.engine = engine;
    }

    @Override
    public Vehiclee clone() {
        try {
            return (Vehiclee) super.clone(); // shallow copy
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return "Vehicle{" + "type='" + type + '\'' + ", engine='" + engine + '\'' + '}';
    }
}

public class PrototypePatternExample {
    public static void main(String[] args) {
        Vehiclee car1 = new Vehiclee("Car", "V8");
        Vehiclee car2 = car1.clone(); // Prototype pattern

        System.out.println(car1);
        System.out.println(car2);

        // Modify the clone
        car2.engine = "Electric";
        System.out.println("After modification:");
        System.out.println(car1);
        System.out.println(car2);
    }
}




//class Vehicle {
//    String type;
//
//    Vehicle(String type) {
//        this.type = type;
//    }
//
//    // Manual "clone" method
//    public Vehicle copy() {
//        return new Vehicle(this.type);
//    }
//}
//
//public class Test {
//    public static void main(String[] args) {
//        Vehicle v1 = new Vehicle("Car");
//        Vehicle v2 = v1.copy(); // works without Cloneable
//    }
//}