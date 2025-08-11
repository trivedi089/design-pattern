package main.BehaviouralPatterns.VisitorPattern;


// Visitor interface
interface ShapeVisitor {
    void visit(Circle1 circle);
    void visit(Rectangle1 rectangle);
}

// Shape interface
interface Shape1 {
    void accept(ShapeVisitor visitor);
}

// Concrete Shapes
class Circle1 implements Shape1 {
    public void accept(ShapeVisitor visitor) {
        visitor.visit(this);
    }
}

class Rectangle1 implements Shape1 {
    public void accept(ShapeVisitor visitor) {
        visitor.visit(this);
    }
}

// Concrete Visitors (operations)
class AreaCalculator implements ShapeVisitor {
    public void visit(Circle1 circle) {
        double area = Math.PI * 5 * 5;
        System.out.println("Circle area: " + area);
    }

    public void visit(Rectangle1 rectangle) {
        double area = 10 * 5;
        System.out.println("Rectangle area: " + area);
    }
}

class DrawingVisitor implements ShapeVisitor {
    public void visit(Circle1 circle) {
        System.out.println("Drawing Circle");
    }

    public void visit(Rectangle1 rectangle) {
        System.out.println("Drawing Rectangle");
    }
}

// Client
public class VisitorPatternExample {
    public static void main(String[] args) {
        Shape1[] shapes = { new Circle1(), new Rectangle1() };

        ShapeVisitor drawVisitor = new DrawingVisitor();
        ShapeVisitor areaVisitor = new AreaCalculator();

        for (Shape1 shape : shapes) {
            shape.accept(drawVisitor);
            shape.accept(areaVisitor);
        }
    }
}
