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
    private <T> T[] takePositive(int n, T[] a, int l, Object[] r) {
        int ia = 0;
        int ir = 0;
        while (ir < n) {
            r[ir] = a[ia % l];
            ir++;
            ia++;
        }
        return (T[]) r;
    }

    private <T> T[] takeNegative(int n, T[] a, int l, Object[] r) {
        int ia = l - 1;
        int ir = n - 1;
        while (ir >= 0) {
            r[ir] = a[ia];
            ir--;
            ia = (ia - 1) - l * Math.floorDiv(ia - 1, l);
        }
        return (T[]) r;
    }

    public <T> T[] take(int n, T[] a) {
        int l = a.length;
        int nAbs = Math.abs(n);
        Object[] r = new Object[nAbs];
        if (n > 0) {
            return takePositive(n, a, l, r);
        } else {
            return takeNegative(Math.abs(n), a, l, r);
        }
    }

    private <T> T[] dropPositive(int n, T[] a, int l, Object[] r) {
        System.arraycopy(a, n, r, 0, l - n);
        return (T[]) r;
    }

    private <T> T[] dropNegative(int n, T[] a, int l, Object[] r) {
        System.arraycopy(a, 0, r, 0, l - n);
        return (T[]) r;
    }

    public <T> T[] drop(int n, T[] a) {
        int l = a.length;
        int nAbs = Math.abs(n);
        Object[] r = new Object[l - nAbs];
        if (n == 0) {
            return a;
        } else if (n > 0) {
            return dropPositive(n, a, l, r);
        } else {
            return dropNegative(nAbs, a, l, r);
        }
    }
}
