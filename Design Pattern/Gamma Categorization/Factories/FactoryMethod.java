// A Factory method is a statuc method that creates objects
// A factory method can take of object creation logic, returning an instance of the class.
// A factory method can be external or reside inside the object as an inner class.
// Hierarchical factory method is a factory method that creates a family of related objects.
class Point {
    private double x, y;

    private Point(double x, double y) {
        this.x = x;
        this.y = y;
    };

    public static class Factory {
    
        public static Point newCartesianPoint(double x, double y) {
            return new Point(x, y);
        }
    
        public static Point newPolarPoint(double rho, double theta) {
            return new Point(rho * Math.cos(theta), rho * Math.sin(theta));
        }
        
    }
}

public class FactoryMethod {
    public static void main(String[] args) {
        Point cartesianPoint = Point.Factory.newCartesianPoint(1, 2);
        Point polarPoint = Point.Factory.newPolarPoint(1, 2);
        System.out.println(cartesianPoint);
        System.out.println(polarPoint);
    }
}