package MathUtils.line;

import MathUtils.point.Point2D;
import MathUtils.vector.Vector2D;

// TODO: 8/12/2023 implementar todo aquí
// TODO: 9/12/2023 Hacer las citas al libro de Stewart Epígrafe 12.5
public class Line2D extends Line<Line2D, Point2D, Vector2D> {

    /**
     * Crea una nueva recta
     *
     * @param displacement punto que define el desplazamiento de la recta
     * @param direction    dirección en la cual apunta la recta
     */
    public Line2D(Point2D displacement, Vector2D direction) {
        super(displacement, direction);
    }

    @Override
    public Point2D eval(double t) {
        double X = displacement.getX() + direction.getX() * t;
        double Y = displacement.getY() + direction.getY() * t;
        return new Point2D(X, Y);
    }

    @Override
    public boolean isIntersectedBy(Line2D line) {
        return false;
    }

    @Override
    public String getParametricEquation() {
        return "x = " + displacement.getX() + " + " + direction.getX() + "t, " +
               "y = " + displacement.getY() + " + " + direction.getY() + "t";
    }

    @Override
    public String getSymmetricEquation() {
        return null;
    }

    @Override
    public String getGeneralEquation() {
        return null;
    }

}
