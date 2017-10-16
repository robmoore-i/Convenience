import java.util.Arrays;
import java.util.function.IntUnaryOperator;

public class Conveniencer {
    public int add(int left, int right) {
        return left + right;
    }

    public int[] add(int left, int[] right) {
        return Arrays.stream(right).map(operand -> left + operand).toArray();
    }

    public int[] add(int[] left, int right) {
        return add(right, left);
    }
}
