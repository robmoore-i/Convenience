package convenience;

import java.util.function.Function;
import java.util.stream.Stream;

public abstract class Monad<I, O> {
    public abstract O one(I right);

    public Stream<O> each(Stream<I> right) {
        return right.map(this::one);
    }

    public static <S, T> Monad fromOperator(Function<S, T> f) {
        return new Monad<S, T>() {
            @Override
            public T one(S right) {
                return f.apply(right);
            }
        };
    }
}
