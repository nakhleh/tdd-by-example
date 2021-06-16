package currency;

class Sum implements Expression {
    Money car;
    Money cdr;

    Sum(Money first, Money second) {
        this.car = first;
        this.cdr = second;
    }

    public Money reduce(String currency) {
        return new Money(this.car.amount + this.cdr.amount, currency);
    }
}