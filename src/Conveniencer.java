import java.util.function.DoubleBinaryOperator;
import java.util.function.UnaryOperator;

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

    public Monad neg = Monad.fromOperator(operand -> -operand, Double.class);
    public Monad reciprocal = Monad.fromOperator(operand -> 1 / operand, Double.class);
    public Monad sqrt = Monad.fromOperator(Math::sqrt, Double.class);

    public <T> Monad<T> monad(UnaryOperator<T> operator, Class<T> cast) {
        return Monad.fromOperator(operator, cast);
    }
}
