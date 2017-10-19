import java.util.Arrays;
import java.util.function.Function;

public abstract class Monad<I, O> {
    public abstract O one(I right);
    @SuppressWarnings("unused") // vvv For completeness
    public O[] many(I[] right) {
        return each(right);
    }

    public O[] each(I[] right) {
        return (O[]) Arrays.stream(right).map(this::one).toArray();
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
