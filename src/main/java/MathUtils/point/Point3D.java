package MathUtils.point;

import MathUtils.vector.Vector3D;

public final class Point3D extends Point<Point3D, Vector3D> {

    private double x;

    private double y;

    private double z;

    public static Point3D ZERO() {
        return new Point3D(0,0,0);
    }

    public Point3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public Vector3D AsVector() {
        return new Vector3D(x, y, z);
    }

    @Override
    public boolean isEqualTo(Point3D point) {
        return point.x == getX() && point.y == getY() && point.z == getZ();
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

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    @Override
    public String toString() {
        return "Point3D{" +
                "x = " + x + ", " +
                "y = " + y + ", " +
                "z = " + z +
                '}';
    }
}
