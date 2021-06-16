package currency;

public interface Expression {
    Money reduce(String currency);
}
