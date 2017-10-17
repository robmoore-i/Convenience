import java.util.Arrays;
import java.util.function.DoubleUnaryOperator;
import java.util.function.UnaryOperator;

public abstract class Monad<T> {
    public abstract T onScalar(T right);
    @SuppressWarnings("unused") // vvv For completeness
    public T[] onVector(T[] right) {
        return each(right);
    }

    public T[] each(T[] right) {
        return (T[]) Arrays.stream(right).map(this::onScalar).toArray();
    }

    public static <S> Monad fromOperator(UnaryOperator<S> operator, Class<S> cast) {
        return new Monad<S>() {
            @Override
            public S onScalar(S right) {
                return operator.apply(cast.cast(right));
            }
        };
    }
}
