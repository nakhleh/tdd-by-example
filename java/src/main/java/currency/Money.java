package currency;

public class Money implements Expression {
    protected int amount;
    protected String currency;
    
    static Money dollar(int amount) {
        return new Money(amount, "USD");
    }
    static Money franc(int amount) {
        return new Money(amount, "CHF");
    }

    Money(int amount, String currency) {
        this.currency = currency;
        this.amount = amount;
    }

    Money plus(Money adder) {
        return new Money(this.amount + adder.amount, this.currency);
    }

    Money times(int multiplier) {
        return new Money(this.amount * multiplier, this.currency);
    }

    String currency() {
        return this.currency;
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
