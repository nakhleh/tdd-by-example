package currency;

public interface Expression {
    Money reduce(Bank bank, String currency);
}
