package MathUtils.point;

import MathUtils.point.Point;
import MathUtils.vector.Vector2D;


public final class Point2D extends Point<Point2D, Vector2D> {

    private double x;

    private double y;

    public static Point2D ZERO() {
        return new Point2D(0,0);
    }

    public Point2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public Vector2D AsVector() {
        return new Vector2D(x, y);
    }

    @Override
    public boolean isEqualTo(Point2D point) {
        return point.x == getX() && point.y == getY();
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }


    @Override
    public String toString() {
        return "Point2D{" +
                "x = " + x + ", " +
                "y = " + y +
                '}';
    }
}
