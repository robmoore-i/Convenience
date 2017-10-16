import java.util.Arrays;
import java.util.function.DoubleBinaryOperator;

public class Conveniencer {
    public double[] neg(double[] right) {
        return Arrays.stream(right).map(operand -> -operand).toArray();
    }

    public double[] reciprocal(double[] right) {
        return Arrays.stream(right).map(operand -> 1 / operand).toArray();
    }

    public double[] eachBoth(double[] left, double[] right, DoubleBinaryOperator operator) throws LengthError {
        if (left.length != right.length) {
            throw new LengthError();
        }
        double[] result = new double[left.length];
        for (int i = 0; i < left.length; i++) {
            result[i] = operator.applyAsDouble(left[i], right[i]);
        }
        return result;
    }

    public double add(double left, double right) {
        return left + right;
    }

    public double[] add(double left, double[] right) {
        return Arrays.stream(right).map(operand -> left + operand).toArray();
    }

    public double[] add(double[] left, double right) {
        return add(right, left);
    }

    public double[] add(double[] left, double[] right) throws LengthError {
        return eachBoth(left, right, (x, y) -> x + y);
    }

    public double minus(double left, double right) {
        return add(left, -right);
    }

    public double[] minus(double left, double[] right) {
        return add(left, neg(right));
    }

    public double[] minus(double[] left, double right) {
        return add(left, -right);
    }

    public double[] minus(double[] left, double[] right) throws LengthError {
        return add(left, neg(right));
    }

    public double times(double left, double right) {
        return left * right;
    }

    public double[] times(double left, double[] right) {
        return Arrays.stream(right).map(operand -> left * operand).toArray();
    }

    public double[] times(double[] left, double right) {
        return times(right, left);
    }

    public double[] times(double[] left, double[] right) throws LengthError {
        return eachBoth(left, right, (x, y) -> x * y);
    }

    public double divide(double left, double right) {
        return left / right;
    }

    public double[] divide(double left, double[] right) {
        return times(left, reciprocal(right));
    }

    public double[] divide(double[] left, double right) {
        return Arrays.stream(left).map(operand -> operand / right).toArray();
    }

    public double[] divide(double[] left, double[] right) throws LengthError {
        return eachBoth(left, right, (x, y) -> x / y);
    }
}
