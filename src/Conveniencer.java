import java.util.Arrays;
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
    public Monad<Double, Double> neg = monad((Function<Double, Double>) operand -> -operand);
    public Monad<Double, Double> reciprocal = monad((Function<Double, Double>) operand -> 1 / operand);
    public Monad<Double, Double> sqrt = monad(Math::sqrt);
    public Monad<Double, Double> floor = monad(Math::floor);
    public Monad<Double, Double> ceiling = monad(Math::ceil);
    public Monad<Double, Double> log = monad(Math::log);
    public Monad<Double, Double> exp = monad(Math::exp);
    public Monad<Double, Double> abs = monad((Function<Double, Double>) Math::abs);
    public Monad<Double, Double> signum = monad((Function<Double, Double>) Math::signum);

    // NUMERIC DYADS //
    public Dyad<Double, Double, Double> add = dyad((BiFunction<Double, Double, Double>) (left, right) -> left + right);
    public Dyad<Double, Double, Double> times = dyad((BiFunction<Double, Double, Double>) (left, right) -> left * right);
    public Dyad<Double, Double, Double> minus = dyad((BiFunction<Double, Double, Double>) (left, right) -> left - right);
    public Dyad<Double, Double, Double> divide = dyad((BiFunction<Double, Double, Double>) (left, right) -> left / right);

    // GENERAL MONADS //
    public <T> Monad<T[], T[]> reverse() {
        return monad(this::reverse);
    }

    public <T> Monad<T[], T[]> distinct() {
        return monad(this::distinct);
    }

    // GENERAL DYADS //
    public <T> Dyad<Integer, T[], T[]> take() {
        return dyad(this::take);
    }

    public <T> Dyad<Integer, T[], T[]> drop() {
        return dyad(this::drop);
    }

    // PRIVATE HELPERS //
    private <T> T[] takePositive(int n, T[] a, int l, Object[] r) {
        int i = 0;
        while (i < n) {
            r[i] = a[i % l];
            i++;
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

    private <T> T[] take(int n, T[] a) {
        int l = a.length;
        int nAbs = Math.abs(n);
        Object[] r = new Object[nAbs];
        if (n > 0) {
            return takePositive(n, a, l, r);
        } else {
            return takeNegative(Math.abs(n), a, l, r);
        }
    }

    private <T> T[] drop(int n, T[] a) {
        if (n == 0) {
            return a;
        } else {
            int l = a.length;
            int nAbs = Math.abs(n);
            Object[] r = new Object[l - nAbs];
            System.arraycopy(a, n > 0 ? n : 0, r, 0, l - nAbs);
            return (T[]) r;
        }
    }

    private <T> T[] reverse(T[] a) {
        int l = a.length;
        Object[] reversed = new Object[l];
        for (int i = 0; i < l; i++) {
            reversed[i] = a[l - 1 - i];
        }
        return (T[]) reversed;
    }

    private <T> T[] distinct(T[] a) {
        return (T[]) Arrays.stream(a).distinct().toArray();
    }
}
