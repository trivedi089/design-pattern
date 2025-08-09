package main.CreationalPattern.FactoryMethodPattern;

interface Shape {
    void draw();
}

//Concrete Classes
class Circle1 implements Shape {
    public void draw() {
        System.out.println("Drawing Circle");
    }
}

class Rectangle1 implements Shape {
    public void draw() {
        System.out.println("Drawing Rectangle");
    }
}

//Factory class
class ShapeFactory {
    public Shape getShape(String type) {
        if (type.equalsIgnoreCase("circle")) {
            return new Circle1();
        } else if (type.equalsIgnoreCase("rectangle")) {
            return new Rectangle1();
        }
        return null;
    }
}

//client code
public class FactoryPatternExample {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();

        Shape shape1 = shapeFactory.getShape("circle");
        shape1.draw();

        Shape shape2 = shapeFactory.getShape("rectangle");
        shape2.draw();
    }
}

