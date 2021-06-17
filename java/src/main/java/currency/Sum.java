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
        return new Sum(this, adder);
    }

    @Override
    public Expression times(int multiplier) {
        return new Sum(this.car.times(multiplier), this.cdr.times(multiplier));
    }

    public Money reduce(Bank bank, String currencyTo) {
        int amount = this.car.reduce(bank, currencyTo).amount + this.cdr.reduce(bank, currencyTo).amount;
        return new Money(amount, currencyTo);
    }

}