package MathUtils.algebra.logarithmics;

import MathUtils.algebra.Const;
import MathUtils.algebra.primitives.MathElement;

/**
 * Representa la función del logaritmo natural o neperiano
 */
public final class Ln extends Log {

    public Ln(MathElement argument) {
        super(argument, new Const(Math.E));
    }

}
