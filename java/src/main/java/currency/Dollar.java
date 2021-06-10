package currency;

class Dollar extends Money {    
    Dollar(int amount, String currency) {
        super(amount, currency);
    }

    Money times(int multiplier) {
        return Money.dollar(this.amount * multiplier);
    }

    @Override
    String currency() {
        return this.currency;
    }
}