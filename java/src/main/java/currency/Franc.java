package currency;

class Franc {    
    int amount;

    Franc(int amount) {
        this.amount = amount;
    }

    Franc times(int multiplier) {
        return new Franc(this.amount * multiplier);
    }

    public boolean equals (Object object) {
        Franc Franc = (Franc) object;
        return this.amount == Franc.amount;
    }
}