package convenience;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.stream.Stream;

public abstract class Dyad<L, R, O> {
    public abstract O one_to_one(L left, R right);

    public abstract Stream<O> one_to_many(L left, Stream<R> right);

    public abstract Stream<O> many_to_one(Stream<L> left, R right);

    public abstract Stream<O> many_to_many(Stream<L> left, Stream<R> right) throws LengthError;

    public Stream<O> each_both(Object[] left, Object[] right) throws LengthError {
        if (left.length != right.length) {
            throw new LengthError();
        }
        Object[] result = new Object[left.length];
        for (int i = 0; i < left.length; i++) {
            result[i] = one_to_one((L) left[i], (R) right[i]);
        }
        return Arrays.stream(result).map(x -> (O) x);
    }

    public static <P, Q, R> Dyad<P, Q, R> fromOperator(BiFunction<P, Q, R> f) {
        return new Dyad<P, Q, R>() {
            public R one_to_one(P left, Q right) {
                return f.apply(left, right);
            }

            @Override
            public Stream<R> one_to_many(P left, Stream<Q> right) {
                return right.map(operand -> f.apply(left, operand));
            }

            @Override
            public Stream<R> many_to_one(Stream<P> left, Q right) {
                return left.map(operand -> f.apply(operand, right));
            }

            @Override
            public Stream<R> many_to_many(Stream<P> left, Stream<Q> right) throws LengthError {
                return each_both(left.toArray(), right.toArray());
            }
        };
    }
}
