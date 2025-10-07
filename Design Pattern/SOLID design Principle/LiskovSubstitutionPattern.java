// Liskov Substitution Principle - A subclass should be substitutable for its superclass
// If you have some API that takes a base class, you should be able to pass a subclass to it without breaking the code

class Rectangle {
    protected int width;
    protected int height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getArea() {
        return width * height;
    }

    @Override
    public String toString() {
        return "Rectangle [width=" + width + ", height=" + height + "]";
    }
}


class RectangleFactory {
    public static Rectangle newRectangle(int width, int height) {
        return new Rectangle(width, height);
    }

    public static Rectangle newSquare(int size) {
        return new Rectangle(size, size);
    }
}

class Square extends Rectangle {
    public Square() {
        super(0, 0);
    }

    public Square(int size) {
        super(size, size);
    }

    @Override
    public String toString() {
        return "Square [width=" + width + ", height=" + height + "]";
    }

    // Following violates Liskov Substitution Principle
    @Override
    public void setWidth(int width) {
        super.setWidth(width);
        super.setHeight(width);
    }

    @Override
    public void setHeight(int height) {
        super.setHeight(height);
        super.setWidth(height);
    }
}

public class LiskovSubstitutionPattern {

    // Following violates Liskov Substitution Principle
    // If you pass a square to this method, it will break the code
    // Because a square is not a rectangle
    // So, you should pass a rectangle to this method
    // And a square is a rectangle, so it should be substitutable for a rectangle
    // So, you should pass a square to this method
    // And a rectangle is not a square, so it should not be substitutable for a square
    // So, you should not pass a rectangle to this method
    static void useIt(Rectangle rectangle) {
        int width = rectangle.getWidth();
        rectangle.setHeight(10);
        System.out.println("Expected area of " + (width * 10) + ", but got " + rectangle.getArea());
    }

    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(10, 10);
        useIt(rectangle);
        Rectangle square = new Square();
        square.setWidth(5);
        useIt(square);
    }
}
