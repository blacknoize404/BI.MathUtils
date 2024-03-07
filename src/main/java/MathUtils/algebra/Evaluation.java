package MathUtils.algebra;

/**
 * Representa el concepto de sustitución de la letra de una variable por su valor
 * para así poder evaluar funciones con variables.
 */
public class Evaluation {

    final String var;

    final Number value;

    public Evaluation(String var, Number value) {
        this.var = var;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Evaluation{" + var + " = " + value + "}";
    }
}
