package currency;

public class Money {
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

    Money times(int multiplier) {
        return new Money(this.amount * multiplier, this.currency);
    }

    String currency() {
        return "";
    };

    public String toString() {
        return this.amount + " " + this.currency;
    }

    public boolean equals (Object object) {
        var money = (Money) object;
        return this.amount == money.amount && 
               this.currency == money.currency;
    }
}
