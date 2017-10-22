import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Stream;

public abstract class Monad<I, O> {
    public abstract O one(I right);

    public O[] each(I[] right) {
        return (O[]) eachStream(right).toArray();
    }

    public Stream<O> eachStream(I[] right) {
        return Arrays.stream(right).map(this::one);
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
