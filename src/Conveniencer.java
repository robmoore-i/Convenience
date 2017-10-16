import java.util.Arrays;

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

    public int[] add(int[] left, int[] right) {
        assert left.length == right.length;
        int[] result = new int[left.length];
        for (int i = 0; i < left.length; i++) {
            result[i] = left[i] + right[i];
        }
        return result;
    }
}
