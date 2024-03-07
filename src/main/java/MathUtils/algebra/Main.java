import MathUtils.algebra.Const;
import MathUtils.algebra.Evaluation;
import MathUtils.algebra.Fraction;
import MathUtils.algebra.Var;
import MathUtils.algebra.exponentials.Sqrt;
import MathUtils.algebra.logarithmics.Ln;
import MathUtils.algebra.operators.MultOperator;
import MathUtils.algebra.operators.SumOperator;
import MathUtils.exceptions.FunctionEvaluationException;

void main() {

    MultOperator m = new MultOperator(
            new SumOperator(
                    new Sqrt(
                            new SumOperator(
                                    new MultOperator(
                                            new Const(2),
                                            new Var("t")
                                    ),
                                    new MultOperator(
                                            new Const(5),
                                            new Var("t")
                                    )
                            )
                    ),
                    new Const(45)
            ),
            new Ln(
                    new MultOperator(
                            new Fraction(1, 8),
                            new Var("t")
                    )
            )
    );

    System.out.println(m);

    try {
        System.out.println(m.eval(new Evaluation("t", 1)));
    } catch (FunctionEvaluationException e) {
        throw new RuntimeException(e);
    }

}