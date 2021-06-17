package currency;

class Sum implements Expression {
    Expression car;
    Expression cdr;

    Sum(Expression first, Expression second) {
        this.car = first;
        this.cdr = second;
    }

    @Override
    public Expression plus(Expression adder) {
        // TODO - implement
        return null;
    }

    public Money reduce(Bank bank, String currency) {
        int amount = this.car.reduce(bank, currency).amount + this.cdr.reduce(bank, currency).amount;
        return new Money(amount, currency);
    }
}