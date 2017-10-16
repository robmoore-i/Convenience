import java.util.function.BinaryOperator;

public abstract class StringDyad {
    public abstract String apply(String left, String right);

    public String[] eachBoth(String[] left, String[] right) throws LengthError {
        if (left.length != right.length) {
            throw new LengthError();
        }
        String[] result = new String[left.length];
        for (int i = 0; i < left.length; i++) {
            result[i] = apply(left[i], right[i]);
        }
        return result;
    }

    public static StringDyad fromOperator(BinaryOperator<String> operator) {
        return new StringDyad() {
            @Override
            public String apply(String left, String right) {
                return operator.apply(left, right);
            }
        };
    }
}
