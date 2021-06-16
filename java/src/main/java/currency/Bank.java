package currency;

import java.util.HashMap;
import java.util.Objects;

public class Bank {
    HashMap<CurrencyPair, Integer> rates = new HashMap<>();
    
    Money reduce(Expression exp, String currency) {
        return (Money) exp.reduce(this, currency);
    }

    void addRate(String from, String to, int exchangeRate) {
        this.rates.put(new CurrencyPair(from, to), exchangeRate);
    }

    int getRate(String from, String to) {
        if (from.equals(to)) {
            return 1;
        }
        var key = new CurrencyPair(from, to);
        var rate = this.rates.get(key);
        return rate.intValue();
    }

    private class CurrencyPair {
        String from;
        String to;
        CurrencyPair(String from, String to) {
            this.from = from;
            this.to = to;
        }
        public boolean equals(Object object) {
            var pair = (CurrencyPair) object;
            return this.from.equals(pair.from) && this.to.equals(pair.to);
        }
        @Override
        public int hashCode() {
            return Objects.hash(from, to);
        }
    }
}

