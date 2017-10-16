import java.util.Arrays;
import java.util.function.IntBinaryOperator;

public class Conveniencer {
    public int[] neg(int[] right) {
        return Arrays.stream(right).map(operand -> -operand).toArray();
    }

    public int[] eachBoth(int[] left, int[] right, IntBinaryOperator operator) throws LengthError {
        if (left.length != right.length) {
            throw new LengthError();
        }
        int[] result = new int[left.length];
        for (int i = 0; i < left.length; i++) {
            result[i] = operator.applyAsInt(left[i], right[i]);
        }
        return result;
    }

    public int add(int left, int right) {
        return left + right;
    }

    public int[] add(int left, int[] right) {
        return Arrays.stream(right).map(operand -> left + operand).toArray();
    }

    public int[] add(int[] left, int right) {
        return add(right, left);
    }

    public int[] add(int[] left, int[] right) throws LengthError {
        return eachBoth(left, right, (x, y) -> x + y);
    }

    public int minus(int left, int right) {
        return add(left, -right);
    }

    public int[] minus(int left, int[] right) {
        return add(left, neg(right));
    }

    public int[] minus(int[] left, int right) {
        return add(left, -right);
    }

    public int[] minus(int[] left, int[] right) throws LengthError {
        return add(left, neg(right));
    }

    public int times(int left, int right) {
        return left * right;
    }

    public int[] times(int left, int[] right) {
        return Arrays.stream(right).map(operand -> left * operand).toArray();
    }

    public int[] times(int[] left, int right) {
        return times(right, left);
    }

    public int[] times(int[] left, int[] right) throws LengthError {
        return eachBoth(left, right, (x, y) -> x * y);
    }
}
