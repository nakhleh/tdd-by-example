package currency;

public interface Expression {
    Expression plus(Expression adder);
    Expression times(int multiplier);
    Money reduce(Bank bank, String currency);
}
