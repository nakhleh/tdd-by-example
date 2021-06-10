package currency;

class Franc extends Money {    
    Franc(int amount, String currency) {
        super(amount, currency);
    }

    Money times(int multiplier) {
        return Money.franc(this.amount * multiplier);
    }

    @Override
    String currency() {
        return this.currency;
    }
}