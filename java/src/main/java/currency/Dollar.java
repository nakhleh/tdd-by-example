package currency;

class Dollar extends Money {    
    Dollar(int amount, String currency) {
        super(amount, currency);
    }

//    @Override
    String currency() {
        return this.currency;
    }
}