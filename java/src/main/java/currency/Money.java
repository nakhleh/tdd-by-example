package currency;

public abstract class Money {
    protected int amount;
    protected String currency;
    
    static Money dollar(int amount) {
        return new Dollar(amount, "USD");
    }
    static Money franc(int amount) {
        return new Franc(amount, "CHF");
    }

    Money(int amount, String currency) {
        this.currency = currency;
        this.amount = amount;
    }

    abstract Money times(int multiplier);

    abstract String currency();

    public boolean equals (Object object) {
        var money = (Money) object;
        return this.amount == money.amount && 
               getClass().equals(money.getClass());
    }
}
