package MathUtils.vector;

import MathUtils.Angle;
import MathUtils.exceptions.ZeroVectorException;
import MathUtils.point.Point2D;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

// TODO: 9/12/2023 Documentar las partes faltantes
public class Vector2D extends Vector<Vector2D> implements Cloneable {
    private Double x;
    private Double y;
    private Point2D from;
    private Point2D to;

    @Contract(" -> new")
    public static @NotNull Vector2D ZERO() {
        return new Vector2D(0, 0);
    }

    public Vector2D(Number x, Number y) {
        this.from = new Point2D(0d, 0d);
        this.to = new Point2D(x, y);
        updateComponents();
    }

    public Vector2D(Point2D to) {
        this.from = new Point2D(0d, 0d);
        this.to = to;
        updateComponents();
    }

    public Vector2D(Point2D from, Point2D to) {
        this.from = from;
        this.to = to;
        updateComponents();
    }

    // TODO: 9/12/2023 Crear un constructor de un vector que se pueda construir
    //  por sus ángulos respectivos en los ejes
    // TODO: 9/12/2023 Testear esta función y documentar las fuentes 
    public Vector2D(Angle xAngle, Angle yAngle) {
//        this.from = from;
//        this.to = to;
//        updateComponents();
    }

    @Override
    public boolean isZero() {
        return getX() == 0 && getY() == 0;
    }

    @Override
    public Vector2D sum(Vector2D a) {
        this.to = new Point2D(
                x + a.getX(),
                y + a.getY()
        );
        updateComponents();
        return this;
    }

    @Override
    public Vector2D subtract(Vector2D a) {
        this.to = new Point2D(
                x - a.getX(),
                y - a.getY()
        );
        updateComponents();
        return this;
    }

    @Override
    public Vector2D multiply(Number scalar) {
        this.to.setX(this.to.getX() * scalar.doubleValue());
        this.to.setY(this.to.getY() * scalar.doubleValue());
        updateComponents();
        return this;
    }

    @Override
    public Vector2D divide(Number scalar) {
        this.to.setX(this.to.getX() / scalar.doubleValue());
        this.to.setY(this.to.getY() / scalar.doubleValue());
        updateComponents();
        return this;
    }

    @Override
    public double getLength() {
        return Math.sqrt(
                Math.pow(to.getX() - from.getX(), 2) +
                        Math.pow(to.getY() - from.getY(), 2));
    }

    @Override
    public double getDotProduct(@NotNull Vector2D a) {
        return getX() * a.getX() + getY() * a.getY();
    }

    @Override
    public Vector3D getCrossProduct(@NotNull Vector2D a) {
        return new Vector3D(0, 0, getX() * a.getY() - getY() * a.getX());
    }

    // TODO: 26/11/2023 Terminar esto
    @Override
    public boolean isEqualTo(Vector2D a) {

        // Tuve que hacer este procedimiento para evitar perder precisión
        // al calcular su raíz y luego elevarlo al cuadrado.
        double lengthSquared =
                Math.pow(to.getX() - from.getX(), 2D) +
                        Math.pow(to.getY() - from.getY(), 2D);

        return this.getScalarProduct(a) == lengthSquared;
    }

    @Override
    public Angle getAngleBetween(Vector2D a) throws ZeroVectorException {
        if (isZero() || a.isZero()) throw new ZeroVectorException();

        return Angle.fromRadians((long) Math.acos(getScalarProduct(a) / (getLength() * a.getLength())));
    }

    private void updateComponents() {
        setX(to.getX() - from.getX());
        setY(to.getY() - from.getY());
    }

    private Point2D getFrom() {
        return from;
    }

    private void setFrom(Point2D from) {
        this.from = from;
        updateComponents();
    }

    public Point2D getTo() {
        return to;
    }

    public void setTo(Point2D to) {
        this.to = to;
        updateComponents();
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

    public Point2D AsPoint() {
        return new Point2D(x, y);
    }

    @Override
    public Vector2D clone() {

        try {
            Vector2D cloned = (Vector2D) super.clone();
            cloned.from = cloned.from.clone();
            cloned.to = cloned.to.clone();
            return cloned;
        } catch (CloneNotSupportedException e) {
            // this shouldn't happen, since we are Cloneable
            throw new InternalError(e);
        }

    }

    @Override
    public String toString() {
        return "Vectorial.Vector2D <" + x + "; " + y + ">, from=" + from + "; to=" + to;
    }

}
