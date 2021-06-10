package currency;

public class Money {
    protected int amount;

    
    public boolean equals (Object object) {
        var money = (Money) object;
        return this.amount == money.amount;
    }
}
