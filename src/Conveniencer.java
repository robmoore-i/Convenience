import java.util.function.BiFunction;
import java.util.function.Function;

public class Conveniencer {
    public <I, O> Monad<I, O> monad(Function<I, O> f) {
        return Monad.fromOperator(f);
    }

    public <L, R, O> Dyad<L, R, O> dyad(BiFunction<L, R, O> f) {
        return Dyad.fromOperator(f);
    }

    // NUMERIC MONADS //
    public Monad<Double, Double> neg = Monad.fromOperator((Function<Double, Double>) operand -> -operand);
    public Monad<Double, Double> reciprocal = Monad.fromOperator((Function<Double, Double>) operand -> 1 / operand);
    public Monad<Double, Double> sqrt = Monad.fromOperator(Math::sqrt);
    public Monad<Double, Double> floor = Monad.fromOperator(Math::floor);
    public Monad<Double, Double> ceiling = Monad.fromOperator(Math::ceil);
    public Monad<Double, Double> log = Monad.fromOperator(Math::log);
    public Monad<Double, Double> exp = Monad.fromOperator(Math::exp);
    public Monad<Double, Double> abs = Monad.fromOperator((Function<Double, Double>) Math::abs);
    public Monad<Double, Double> signum = Monad.fromOperator((Function<Double, Double>) Math::signum);

    // NUMERIC DYADS //
    public Dyad<Double, Double, Double> add = Dyad.fromOperator((BiFunction<Double, Double, Double>) (left, right) -> left + right);
    public Dyad<Double, Double, Double> times = Dyad.fromOperator((BiFunction<Double, Double, Double>) (left, right) -> left * right);
    public Dyad<Double, Double, Double> minus = Dyad.fromOperator((BiFunction<Double, Double, Double>) (left, right) -> left - right);
    public Dyad<Double, Double, Double> divide = Dyad.fromOperator((BiFunction<Double, Double, Double>) (left, right) -> left / right);

    // STRING MONADS //

    // STRING DYADS //

    // GENERAL MONADS //

    // GENERAL DYADS //
    public <T> T[] take(int n, T[] a) {
        int l = a.length;
        int nAbs = Math.abs(n);
        Object[] r = new Object[nAbs];
        int ia = n > 0 ? 0 : l - 1;
        int ir = n > 0 ? 0 : nAbs - 1;
        int inc = n > 0 ? 1 : -1;
        if (n > 0) {
            while (ir < nAbs) {
                r[ir] = a[ia % l];
                ir += inc;
                ia += inc;
            }
        } else {
            while (ir >= 0) {
                int mod = ia - l * Math.floorDiv(ia, l);
                r[ir] = a[mod];
                ir += inc;
                ia += inc;
            }
        }
        return (T[]) r;
    }
}
