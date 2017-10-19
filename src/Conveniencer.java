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

    // ARRAY MONADS //
    public <T> Monad<T[], T[]> reverse() {
        return monad(a -> {
            int l = a.length;
            Object[] reversed = new Object[l];
            for (int i = 0; i < l; i++) {
                reversed[i] = a[l - 1 - i];
            }
            return (T[]) reversed;
        });
    }

    public <T> Monad<T[], T[]> distinct() {
        return monad(a -> (T[]) Arrays.stream(a).distinct().toArray());
    }

    public <T> Monad<T[], T> first() {
        return monad(ts -> ts[0]);
    }

    public <T> Monad<T[], T[]> behead() {
        return monad(ts -> {
            Object[] r = new Object[ts.length - 1];
            System.arraycopy(ts, 1, r, 0, ts.length - 1);
            return (T[]) r;
        });
    }

    public <T> Monad<T[], T> last() {
        return monad(ts -> ts[ts.length - 1]);
    }

    public <T> Monad<T[], T[]> curtail() {
        return monad(ts -> {
            Object[] r = new Object[ts.length - 1];
            System.arraycopy(ts, 0, r, 0, ts.length - 1);
            return (T[]) r;
        });
    }

    public <T> Monad<T, T[]> enrray() {
        return monad(t -> (T[]) new Object[]{t});
    }

    // ARRAY DYADS //
    public <T> Dyad<Integer, T[], T[]> take() {
        return dyad((n, a) -> {
            int l = a.length;
            int nAbs = Math.abs(n);
            Object[] r = new Object[nAbs];
            if (n > 0) {
                return takePositive((int) n, a, l, r);
            } else {
                return takeNegative(Math.abs((int) n), a, l, r);
            }
        });
    }

    public <T> Dyad<Integer, T[], T[]> drop() {
        return dyad((n, a) -> {
            if (n == 0) {
                return a;
            } else {
                int l = a.length;
                int nAbs = Math.abs(n);
                Object[] r = new Object[l - nAbs];
                System.arraycopy(a, n > 0 ? n : 0, r, 0, l - nAbs);
                return (T[]) r;
            }
        });
    }

    public <T> Dyad<T[], T[], T[]> join() {
        return dyad((a, b) -> {
            Object[] r = new Object[a.length + b.length];
            System.arraycopy(a, 0, r, 0, a.length);
            System.arraycopy(b, 0, r, a.length, b.length);
            return (T[]) r;
        });
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
}
