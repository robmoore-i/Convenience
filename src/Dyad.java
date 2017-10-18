import java.util.Arrays;
import java.util.function.BiFunction;

public abstract class Dyad<L, R, O> {
    public abstract O scalar_scalar(L left, R right);

    public abstract O[] scalar_vector(L left, R[] right);

    public abstract O[] vector_scalar(L[] left, R right);

    public abstract O[] vector_vector(L[] left, R[] right) throws LengthError;

    public O[] eachBoth(L[] left, R[] right) throws LengthError {
        if (left.length != right.length) {
            throw new LengthError();
        }
        Object[] result = new Object[left.length];
        for (int i = 0; i < left.length; i++) {
            result[i] = scalar_scalar(left[i], right[i]);
        }
        return (O[]) result;
    }

    public static <P, Q, R> Dyad<P, Q, R> fromOperator(BiFunction<P, Q, R> f) {
        return new Dyad<P, Q, R>() {
            public R scalar_scalar(P left, Q right) {
                return f.apply(left, right);
            }

            @Override
            public R[] scalar_vector(P left, Q[] right) {
                return (R[]) Arrays.stream(right).map(operand -> f.apply(left, operand)).toArray();
            }

            @Override
            public R[] vector_scalar(P[] left, Q right) {
                return (R[]) Arrays.stream(left).map(operand -> f.apply(operand, right)).toArray();
            }

            @Override
            public R[] vector_vector(P[] left, Q[] right) throws LengthError {
                return eachBoth(left, right);
            }
        };
    }
}
