package MathUtils.algebra.operators;

import MathUtils.algebra.Evaluation;
import MathUtils.exceptions.FunctionEvaluationException;
import MathUtils.algebra.primitives.MathElement;
import MathUtils.algebra.primitives.Operator;

import java.util.Iterator;

public final class MultOperator extends Operator {

    public MultOperator(Number constant, MathElement secondElement, MathElement... elements) {
        super(constant, secondElement, elements);
    }

    public MultOperator(MathElement first, Number constant, Number... elements) {
        super(first, constant, elements);
    }

    public MultOperator(Number firstConstant, Number secondConstant, Number... constants) {
        super(firstConstant, secondConstant, constants);
    }

    public MultOperator(MathElement first, MathElement second, MathElement... elements) {
        super(first, second, elements);
    }

    @Override
    public double eval(Evaluation... variables) throws FunctionEvaluationException {
        if (elements.isEmpty()) throw new FunctionEvaluationException("No hay argumentos");

        Iterator<MathElement> it = elements.iterator();

        double result = it.next().eval(variables);

        while (it.hasNext()) {
            if (result == 0) return 0;
            double w = it.next().eval(variables);
            result *= w;
        }

        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Iterator<MathElement> iterator = elements.iterator();
        while (iterator.hasNext()) {
            sb.append(iterator.next().toString());
            if (iterator.hasNext()) {
                sb.append(" * ");
            }
        }

        return sb.toString();
    }
}
