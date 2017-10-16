public class Conveniencer {
    public Dyadic add = Dyadic.commutative((left, right) -> left + right);
    public Dyadic times = Dyadic.commutative((left, right) -> left * right);
    public Dyadic minus = Dyadic.fromInverse(add, operand -> -operand);
    public Dyadic divide = Dyadic.fromInverse(times, operand -> 1 / operand);
}
