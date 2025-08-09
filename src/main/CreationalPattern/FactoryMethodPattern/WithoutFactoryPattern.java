package main.CreationalPattern.FactoryMethodPattern;

class Circle {
    void draw() {
        System.out.println("Drawing Circle");
    }
}

class Rectangle {
    void draw() {
        System.out.println("Drawing Rectangle");
    }
}

public class WithoutFactoryPattern {
    public static void main(String[] args) {
        Circle circle = new Circle();   // direct creation
        circle.draw();

        Rectangle rectangle = new Rectangle(); // direct creation
        rectangle.draw();
    }
}
