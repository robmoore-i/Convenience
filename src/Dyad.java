import java.util.Arrays;
import java.util.function.BiFunction;

public abstract class Dyad<L, R, O> {
    public abstract O one_to_one(L left, R right);

    public abstract O[] one_to_many(L left, R[] right);

    public abstract O[] many_to_one(L[] left, R right);

    public abstract O[] many_to_many(L[] left, R[] right) throws LengthError;

    public O[] each_both(L[] left, R[] right) throws LengthError {
        if (left.length != right.length) {
            throw new LengthError();
        }
        Object[] result = new Object[left.length];
        for (int i = 0; i < left.length; i++) {
            result[i] = one_to_one(left[i], right[i]);
        }
        return (O[]) result;
    }

    public static <P, Q, R> Dyad<P, Q, R> fromOperator(BiFunction<P, Q, R> f) {
        return new Dyad<P, Q, R>() {
            public R one_to_one(P left, Q right) {
                return f.apply(left, right);
            }

            @Override
            public R[] one_to_many(P left, Q[] right) {
                return (R[]) Arrays.stream(right).map(operand -> f.apply(left, operand)).toArray();
            }

            @Override
            public R[] many_to_one(P[] left, Q right) {
                return (R[]) Arrays.stream(left).map(operand -> f.apply(operand, right)).toArray();
            }

            @Override
            public R[] many_to_many(P[] left, Q[] right) throws LengthError {
                return each_both(left, right);
            }
        };
    }
}
