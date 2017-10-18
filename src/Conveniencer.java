import java.util.function.DoubleBinaryOperator;
import java.util.function.Function;

public class Conveniencer {
    // Dyads

    public Dyad add = Dyad.fromOperator((left, right) -> left + right);
    public Dyad times = Dyad.fromOperator((left, right) -> left * right);
    public Dyad minus = Dyad.fromOperator((left, right) -> left - right);
    public Dyad divide = Dyad.fromOperator((left, right) -> left / right);

    public Dyad dyad(DoubleBinaryOperator operator) {
        return Dyad.fromOperator(operator);
    }

    // Monads

    public Monad<Double, Double> neg = Monad.fromOperator((Function<Double, Double>) operand -> -operand);
    public Monad<Double, Double> reciprocal = Monad.fromOperator((Function<Double, Double>) operand -> 1 / operand);
    public Monad<Double, Double> sqrt = Monad.fromOperator(Math::sqrt);

    public <I, O> Monad<I, O> monad(Function<I, O> f) {
        return Monad.fromOperator(f);
    }
}
