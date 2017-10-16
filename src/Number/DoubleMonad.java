package Number;

import java.util.Arrays;
import java.util.function.DoubleUnaryOperator;

public abstract class DoubleMonad {
    public abstract double onScalar(double right);

    @SuppressWarnings("unused") // vvv For completeness
    public double[] onVector(double[] right) {
        return each(right);
    }

    public double[] each(double[] right) {
        return Arrays.stream(right).map(this::onScalar).toArray();
    }

    public static DoubleMonad fromOperator(DoubleUnaryOperator operator) {
        return new DoubleMonad() {
            @Override
            public double onScalar(double right) {
                return operator.applyAsDouble(right);
            }
        };
    }
}
