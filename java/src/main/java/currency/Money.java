package currency;

public abstract class Money {
    protected int amount;

    static Money dollar(int amount) {
        return new Dollar(amount);
    }
    static Money franc(int amount) {
        return new Franc(amount);
    }

    abstract Money times(int multiplier);

    public boolean equals (Object object) {
        var money = (Money) object;
        return this.amount == money.amount && 
               getClass().equals(money.getClass());
    }
}
