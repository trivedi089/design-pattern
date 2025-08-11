package main.BehaviouralPatterns.VisitorPattern;

// Shape hierarchy
interface Shape {
    void draw();
}

class Circle implements Shape {
    public void draw() {
        System.out.println("Drawing Circle");
    }

    // New operation: calculate area — have to add here
    public double area() {
        return Math.PI * 5 * 5; // radius 5
    }
}

class Rectangle implements Shape {
    public void draw() {
        System.out.println("Drawing Rectangle");
    }

    public double area() {
        return 10 * 5; // width * height
    }
}

// Client
public class WithoutVisitorPattern {
    public static void main(String[] args) {
        Shape circle = new Circle();
        Shape rectangle = new Rectangle();

        circle.draw();
        System.out.println("Circle area: " + ((Circle) circle).area());

        rectangle.draw();
        System.out.println("Rectangle area: " + ((Rectangle) rectangle).area());
    }
}