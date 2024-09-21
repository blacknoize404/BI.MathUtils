/**
 * Librería orientada a las matemáticas, estadísticas, construcción y cálculo computacional en general.
 */
module MathUtils {
    requires org.jetbrains.annotations;
    requires java.desktop;
    exports MathUtils.vector;
    exports MathUtils.algebra;
    exports MathUtils.algebra.exponentials;
    exports MathUtils.algebra.operators;
    exports MathUtils.algebra.logarithmics;
    exports MathUtils.algebra.primitives;
    exports MathUtils.algebra.trigonometrics;
    exports MathUtils.exceptions;
    exports MathUtils.point;
    exports MathUtils.line;
    exports MathUtils.informatics;
    exports MathUtils.statistics;
    exports MathUtils;
    exports MathUtils.series;
    exports MathUtils.algebra.operators.primitives;
}