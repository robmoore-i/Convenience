import java.util.function.BiFunction;
import java.util.function.Function;

public class Conveniencer {
    // Dyads

    public Dyad<Double, Double, Double> add = Dyad.fromOperator((BiFunction<Double, Double, Double>) (left, right) -> left + right);
    public Dyad<Double, Double, Double> times = Dyad.fromOperator((BiFunction<Double, Double, Double>) (left, right) -> left * right);
    public Dyad<Double, Double, Double> minus = Dyad.fromOperator((BiFunction<Double, Double, Double>) (left, right) -> left - right);
    public Dyad<Double, Double, Double> divide = Dyad.fromOperator((BiFunction<Double, Double, Double>) (left, right) -> left / right);

    public <L, R, O> Dyad<L, R, O> dyad(BiFunction<L, R, O> f) {
        return Dyad.fromOperator(f);
    }

    // Monads

    public Monad<Double, Double> neg = Monad.fromOperator((Function<Double, Double>) operand -> -operand);
    public Monad<Double, Double> reciprocal = Monad.fromOperator((Function<Double, Double>) operand -> 1 / operand);
    public Monad<Double, Double> sqrt = Monad.fromOperator(Math::sqrt);
    public Monad<Double, Double> abs = Monad.fromOperator((Function<Double, Double>) Math::abs);

    public <I, O> Monad<I, O> monad(Function<I, O> f) {
        return Monad.fromOperator(f);
    }
}
