package MathUtils.algebra;

import MathUtils.algebra.primitives.Expression;

/**
 * Representa a una constante
 */
public final class Const extends Expression<Number> {

    public Const(Number value) {
        super(value);
    }

    @Override
    public double eval(Evaluation... variables) {
        if (argument.doubleValue() % 1 == 0) return argument.intValue();
        return argument.doubleValue();
    }

}
