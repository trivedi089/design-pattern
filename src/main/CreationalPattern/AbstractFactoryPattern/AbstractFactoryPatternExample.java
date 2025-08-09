package main.CreationalPattern.AbstractFactoryPattern;

//Product Interface
interface Shape {
    void draw();
}

//Concrete Products
class Circle implements Shape {
    public void draw() {
        System.out.println("Drawing Circle");
    }
}

class Rectangle implements Shape {
    public void draw() {
        System.out.println("Drawing Rectangle");
    }
}

//Factory Interface
interface ShapeFactory {
    Shape createShape();
}

//Concrete Factories
class CircleFactory implements ShapeFactory {
    public Shape createShape() {
        return new Circle();
    }
}

class RectangleFactory implements ShapeFactory {
    public Shape createShape() {
        return new Rectangle();
    }
}

//Client Code
public class AbstractFactoryPatternExample {

    public static void main(String[] args) {
        ShapeFactory factory = new CircleFactory(); // Choose factory at runtime
        Shape shape = factory.createShape();
        shape.draw();

        factory = new RectangleFactory();
        shape = factory.createShape();
        shape.draw();
    }
}
