package Number;

import Main.LengthError;

import java.util.Arrays;
import java.util.function.DoubleBinaryOperator;

public abstract class DoubleDyad {
    public abstract double scalar_scalar(double left, double right);

    public abstract double[] scalar_vector(double left, double[] right);

    public abstract double[] vector_scalar(double[] left, double right);

    public abstract double[] vector_vector(double[] left, double[] right) throws LengthError;

    public double[] eachBoth(double[] left, double[] right) throws LengthError {
        if (left.length != right.length) {
            throw new LengthError();
        }
        double[] result = new double[left.length];
        for (int i = 0; i < left.length; i++) {
            result[i] = scalar_scalar(left[i], right[i]);
        }
        return result;
    }

    public static DoubleDyad fromOperator(DoubleBinaryOperator operator) {
        return new DoubleDyad() {
            public double scalar_scalar(double left, double right) {
                return operator.applyAsDouble(left, right);
            }

            @Override
            public double[] scalar_vector(double left, double[] right) {
                return Arrays.stream(right).map(operand -> operator.applyAsDouble(left, operand)).toArray();
            }

            @Override
            public double[] vector_scalar(double[] left, double right) {
                return Arrays.stream(left).map(operand -> operator.applyAsDouble(operand, right)).toArray();
            }

            @Override
            public double[] vector_vector(double[] left, double[] right) throws LengthError {
                return eachBoth(left, right);
            }
        };
    }
}
