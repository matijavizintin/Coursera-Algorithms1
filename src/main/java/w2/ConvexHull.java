package w2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

/**
 * Created by Matija Vižintin
 * Date: 05. 07. 2015
 * Time: 12.40
 */
public class ConvexHull {

    public List<Point2D> calculate(Point2D[] points) {
        // sort by y coordinate
        Arrays.sort(points, new YCoordinateComparator());

        // sort by polar angle in reference to first point
        Arrays.sort(points, points[0].comparator());

        // push first 2 on stack
        Stack<Point2D> stack = new Stack<>();
        stack.push(points[0]);
        stack.push(points[1]);

        // go through all points
        for (int i = 2; i < points.length; i++) {
            Point2D top = stack.pop();
            while (!stack.empty() && calcTurn(stack.peek(), top, points[i]) < 1) {        // until we find a ccw turn pop from stack
                top = stack.pop();
            }

            // push on stack
            stack.push(top);
            stack.push(points[i]);
        }

        return stack;
    }

    /**
     * Method returns:
     * + 1 for ccw turn
     * - 1 for cw turn
     *   0 for collinear points
     *
     * @param a         Point2D
     * @param b         Point2D
     * @param c         Point2D
     * @return          int
     */
    private int calcTurn(Point2D a, Point2D b, Point2D c) {
        double area = (b.getX() - a.getX()) * (c.getY() - a.getY()) - (b.getY() - a.getY()) * (c.getX() - a.getX());

        if (area > 0) {
            return 1;
        } else if (area < 0) {
            return -1;
        } else {
            return 0;
        }
    }

    // y-coordinate comparator
    private class YCoordinateComparator implements Comparator<Point2D> {

        @Override public int compare(Point2D o1, Point2D o2) {
            return Integer.compare(o1.getY(), o2.getY());
        }
    }
}

// inner class that represents a point
class Point2D {
    private int x;
    private int y;

    public Point2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    // returns comparator that compare other points in reference to this
    public PolarAngleComparator comparator() {
        return new PolarAngleComparator(this);
    }

    @Override public String toString() {
        return "Point2D{" +
               "x=" + x +
               ", y=" + y +
               '}';
    }

    // polar angle comparator
    private class PolarAngleComparator implements Comparator<Point2D> {
        private Point2D reference;

        public PolarAngleComparator(Point2D reference) {
            this.reference = reference;
        }

        @Override public int compare(Point2D p1, Point2D p2) {
            Double atan1 =  Math.atan2(p1.y - reference.y, p1.x - reference.x);
            Double atan2 =  Math.atan2(p2.y - reference.y, p2.x - reference.x);

            return atan1.compareTo(atan2);
        }
    }
}
