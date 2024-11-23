package algorithms.DivideAndConquer;

import java.util.*;

class Point {

    public double x;
    public double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return   "(" + x + ", " + y + ")";
    }
}

class XSorter implements Comparator<Point> {

    @Override
    public int compare(Point o1, Point o2) {
        return Double.compare(o1.x, o2.x);
    }
}

class YSorter implements Comparator<Point> {

    @Override
    public int compare(Point o1, Point o2) {
        return Double.compare(o1.y, o2.y);
    }
}

public class ClosestPairOfPoints {

    private List<Point> points;

    public ClosestPairOfPoints(List<Point> points) {
        this.points = points;
    }

    public double solveProblem() {
        List<Point> sortedXPoints = new ArrayList<Point>();
        List<Point> sortedYPoints = new ArrayList<Point>();

        for (Point p : points) {
            sortedXPoints.add(p);
            sortedYPoints.add(p);
        }

        // we have to sort the items based on X and Y
        Collections.sort(sortedXPoints, new XSorter());
        Collections.sort(sortedYPoints, new YSorter());

        return findClosestPoint(sortedYPoints, sortedYPoints,sortedXPoints.size());
    }

    private double findClosestPoint(List<Point> sortedXPoints, List<Point> sortedYPoints, int numOfPoints) {
        if (numOfPoints <= 3) {
            return bruteForceSearch(sortedXPoints);
        }

        int middleIndex = numOfPoints / 2;
        Point middlePoint = sortedYPoints.get(middleIndex);

        // DIVIDE PHASE - we keep dividing the dataset into left and right subarrays
        List<Point> leftSubPointsSortedX = new ArrayList<>();
        List<Point> rightSubPointsSortedX = new ArrayList<>();

        for (int i=0; i<numOfPoints; i++) {
            if (sortedXPoints.get(i).x <= middlePoint.x) {
                leftSubPointsSortedX.add(sortedXPoints.get(i));
            } else {
                rightSubPointsSortedX.add(sortedYPoints.get(i));
            }
        }

        // then we have to find the closest pair of pts in the left and right subarrays
        double deltaLeft = findClosestPoint(leftSubPointsSortedX, sortedYPoints, middleIndex);
        double deltaRight = findClosestPoint(rightSubPointsSortedX, sortedYPoints, numOfPoints - middleIndex);
        double delta = Math.min(deltaLeft, deltaRight);

        List<Point> pointStrip = new ArrayList<>();

        // linear search for the items that fall within the strip
        for (int i=0; i<numOfPoints; i++) {
            if (Math.abs(sortedYPoints.get(i).x - middlePoint.x) < delta) {
                pointStrip.add(sortedYPoints.get(i));
            }
        }
        double minDistanceStrip = findMinimumDistanceInStrip(pointStrip, delta);
        return Math.min(delta, minDistanceStrip);
    }

    private double bruteForceSearch(List<Point> points) {
        double minDistance = Double.MAX_VALUE;
        for (int i=0; i<points.size()-1; i++) {
            // j= i+1 because we want to check the distance between the points just once
            // d(a,b) = d(b,a)
            for (int j=i+1; j<points.size(); j++) {
                double actualDistance = distance(points.get(i), points.get(j));
                if (actualDistance < minDistance) {
                    minDistance = actualDistance;
                }
            }
        }
        return minDistance;
    }

    private  double distance(Point p1, Point p2) {
        double xDistance = p1.x - p2.x;
        double yDistance = p1.y - p2.y;
        return Math.sqrt(xDistance * xDistance + yDistance * yDistance);
    }

    private double findMinimumDistanceInStrip(List<Point> points, double delta) {
        double minDistance = delta;
        for (int i=0; i<points.size(); i++) {
            for (int j=i+1; j<points.size() && (points.get(j).y - points.get(i).y) < minDistance; j++) {
                minDistance = distance(points.get(i), points.get(j));
            }
        }
        return minDistance;
    }

    public static void main(String[] args) {
        List<Point> points = Arrays.asList(
                new Point(2.5, 3),
                new Point(3, 3),
                new Point(1, 1),
                new Point(1, 2),
                new Point(2, 1),
                new Point(2, 2)
        );
        ClosestPairOfPoints solver = new ClosestPairOfPoints(points);
        System.out.println(solver.solveProblem());

    }
}
