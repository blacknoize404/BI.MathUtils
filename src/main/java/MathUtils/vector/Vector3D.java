package MathUtils.vector;

import MathUtils.Angle;
import MathUtils.exceptions.ZeroVectorException;
import MathUtils.point.Point3D;

public class Vector3D extends Vector<Vector3D> {
    private double x;
    private double y;
    private double z;
    private Point3D from;
    private Point3D to;

    public static Vector3D ZERO() {
        return new Vector3D(0, 0, 0);
    }

    public static Vector3D FORWARD() {
        return new Vector3D(1, 0, 0);
    }

    public static Vector3D BACKWARD() {
        return new Vector3D(-1, 0, 0);
    }

    public static Vector3D LEFT() {
        return new Vector3D(0, -1, 0);
    }

    public static Vector3D RIGHT() {
        return new Vector3D(0, 1, 0);
    }

    public static Vector3D UP() {
        return new Vector3D(0, 0, 1);
    }

    public static Vector3D DOWN() {
        return new Vector3D(0, 0, -1);
    }

    public Vector3D(Number x, Number y, Number z) {
        this.from = new Point3D(0, 0, 0);
        this.to = new Point3D(x, y, z);
        updateComponents();
    }

    public Vector3D(Point3D to) {
        this.from = new Point3D(0, 0, 0);
        this.to = to;
        updateComponents();
    }

    public Vector3D(Point3D from, Point3D to) {
        this.from = from;
        this.to = to;
        updateComponents();
    }

    // TODO: 26/11/2023 Los valores no son exactos y se pierde precisión en las conversiones
    public Vector3D(Number length, Number xAngle, Number yAngle, Number zAngle) {

        this.from = new Point3D(0, 0, 0);
        double xRadian = Angle.fromAngle(xAngle.doubleValue()).getRadian();
        double yRadian = Angle.fromAngle(yAngle.doubleValue()).getRadian();
        double zRadian = Angle.fromAngle(zAngle.doubleValue()).getRadian();
        this.to = new Point3D(Math.cos(xRadian), Math.cos(yRadian), Math.cos(zRadian));
        this.multiply(length);
        updateComponents();
    }

    public static Vector3D of(double x, double y, double z) {
        return new Vector3D(x, y, z);
    }

    @Override
    public boolean isZero() {
        return getX() == 0 &&
                getY() == 0 &&
                getZ() == 0;
    }

    @Override
    public Vector3D abs() {
        return Vector3D.of(Math.abs(x), Math.abs(y), Math.abs(z));
    }

    @Override
    public Vector3D sum(Vector3D a) {
        this.from = this.to;
        this.to = new Point3D(
                x + a.getX(),
                y + a.getY(),
                z + a.getZ()
        );
        updateComponents();
        return this;
    }

    @Override
    public Vector3D subtract(Vector3D a) {
        this.from = this.to;
        this.to = new Point3D(
                x - a.getX(),
                y - a.getY(),
                z - a.getZ());
        updateComponents();
        return this;
    }

    @Override
    public Vector3D multiply(Number scalar) {
        this.to.setX(this.to.getX() * scalar.doubleValue());
        this.to.setY(this.to.getY() * scalar.doubleValue());
        this.to.setZ(this.to.getZ() * scalar.doubleValue());
        updateComponents();
        return this;
    }

    @Override
    public Vector3D divide(Number scalar) {
        this.to.setX(this.to.getX() / scalar.doubleValue());
        this.to.setY(this.to.getY() / scalar.doubleValue());
        this.to.setZ(this.to.getZ() / scalar.doubleValue());
        updateComponents();
        return this;
    }

    @Override
    public double getLength() {
        // FIXME: 26/11/2023 Esto devuelve un valor con precisión perdida
        //  elevarlo al cuadrado no devolverá el mismo resultado.
        return Math.pow(
                Math.pow(to.getX() - from.getX(), 2) +
                Math.pow(to.getY() - from.getY(), 2) +
                Math.pow(to.getZ() - from.getZ(), 2),
                (double) 1 / 2
        );
    }

    @Override
    public double getDotProduct(Vector3D a) {
        return getX() * a.getX() +
                getY() * a.getY() +
                getZ() * a.getZ();
    }

    @Override
    public Vector3D getCrossProduct(Vector3D a) {
        double xNormal = getY() * a.getZ() - getZ() * a.getY();
        double yNormal = getZ() * a.getX() - getX() * a.getZ();
        double zNormal = getX() * a.getY() - getY() * a.getX();

        return new Vector3D(xNormal, yNormal, zNormal);
    }

    @Override
    public boolean isEqualTo(Vector3D a) {
        // Tuve que hacer este procedimiento para evitar perder precisión
        // al calcular su raíz y luego elevarlo al cuadrado.
        double lengthSquared =
                Math.pow(to.getX() - from.getX(), 2D) +
                        Math.pow(to.getY() - from.getY(), 2D) +
                        Math.pow(to.getZ() - from.getZ(), 2D);

        return this.getScalarProduct(a) == lengthSquared;
    }

    // TODO: 9/12/2023 Documentar estas funciones
    @Override
    public Angle getAngleBetween(Vector3D a) throws ZeroVectorException {
        if (isZero() || a.isZero()) throw new ZeroVectorException();

        return Angle.fromRadians((long) Math.acos(getScalarProduct(a) / (getLength() * a.getLength())));
    }

    public Angle getAngleBetweenX() throws ZeroVectorException {

        if (isZero()) throw new ZeroVectorException();

        return Angle.fromRadians(
                (long) Math.acos(
                        this.getX() / getLength()
                )
        );
    }

    public Angle getAngleBetweenY() throws ZeroVectorException {

        if (isZero()) throw new ZeroVectorException();

        return Angle.fromRadians(
                (long) Math.acos(
                        this.getY() / getLength()
                )
        );

    }

    public Angle getAngleBetweenZ() throws ZeroVectorException {

        if (isZero()) throw new ZeroVectorException();

        return Angle.fromRadians(
                (long) Math.acos(
                        this.getZ() / getLength()
                )
        );

    }

    private void updateComponents() {
        setX(to.getX() - from.getX());
        setY(to.getY() - from.getY());
        setZ(to.getZ() - from.getZ());
    }


    @Override
    public Vector3D clone() {

        try {
            Vector3D cloned = (Vector3D) super.clone();
            cloned.from = cloned.from.clone();
            cloned.to = cloned.to.clone();
            return cloned;
        } catch (CloneNotSupportedException e) {
            // this shouldn't happen, since we are Cloneable
            throw new InternalError(e);
        }

    }

    public double getX() {
        return x;
    }

    public void setX(Number x) {
        this.x = x.doubleValue();
    }

    public double getY() {
        return y;
    }

    public void setY(Number y) {
        this.y = y.doubleValue();
    }

    public double getZ() {
        return z;
    }

    public void setZ(Number z) {
        this.z = z.doubleValue();
    }

    @Override
    public String toString() {
        return "Vector3D <" + x + "; " + y + "; " + z + ">, from=" + from + "; to=" + to;
    }

}
