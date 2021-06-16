package currency;

public class Bank {
    Money reduce(Expression exp, String currency) {
        return (Money) exp.reduce(currency);
    }
}
