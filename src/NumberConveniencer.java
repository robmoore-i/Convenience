import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleUnaryOperator;

public class NumberConveniencer {
    // Dyads

    public DoubleDyad add = DoubleDyad.fromOperator((left, right) -> left + right);
    public DoubleDyad times = DoubleDyad.fromOperator((left, right) -> left * right);
    public DoubleDyad minus = DoubleDyad.fromOperator((left, right) -> left - right);
    public DoubleDyad divide = DoubleDyad.fromOperator((left, right) -> left / right);

    public DoubleDyad dyad(DoubleBinaryOperator operator) {
        return DoubleDyad.fromOperator(operator);
    }

    // Monads

    public DoubleMonad neg = DoubleMonad.fromOperator(operand -> -operand);
    public DoubleMonad reciprocal = DoubleMonad.fromOperator(operand -> 1 / operand);
    public DoubleMonad sqrt = DoubleMonad.fromOperator(Math::sqrt);

    public DoubleMonad monad(DoubleUnaryOperator operator) {
        return DoubleMonad.fromOperator(operator);
    }
}
