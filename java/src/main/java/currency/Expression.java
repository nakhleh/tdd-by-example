package currency;

public interface Expression {
    Expression plus(Expression adder);
    Money reduce(Bank bank, String currency);
}
