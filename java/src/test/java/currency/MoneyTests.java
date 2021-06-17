package currency;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


public class MoneyTests {
    static Bank bank;

    @BeforeAll
    static void setUp() {
        bank = new Bank();
        bank.addRate("CHF", "USD", 2);
    }

    @Test
    public void testCurrency() {
        assertEquals("USD", Money.dollar(1).currency());
        assertEquals("CHF", Money.franc(1).currency());
    }

    @Test
    public void testSimpleAddition() {
        Money five = Money.dollar(5);
        Expression sum = five.plus(five);
        Money reduced = bank.reduce(sum, "USD");
        assertEquals(Money.dollar(10), reduced);
    }

    @Test
    public void testMixedAddition() {
        Expression sum = Money.dollar(4).plus(Money.franc(12));
        Money result = bank.reduce(sum, "USD");
        assertEquals(Money.dollar(10), result);        
    }

    @Test
    public void testSumPlusMoney() {
        Expression sum = Money.dollar(1).plus(Money.dollar(10));
        sum = sum.plus(Money.franc(200));
        Money result = bank.reduce(sum, "USD");
        assertEquals(Money.dollar(111), result);
    }

    @Test
    public void testPlusReturnsSum() {
        Money five = Money.dollar(5);
        Expression result = five.plus(five);
        Sum sum = (Sum) result;
        assertEquals(five, sum.car);
        assertEquals(five, sum.cdr);
    }

    @Test
    public void testReduceSum() {
        Expression sum = new Sum(Money.dollar(2), Money.dollar(3));
        Money result = bank.reduce(sum, "USD");
        assertEquals(Money.dollar(5), result);
    }

    @Test
    public void testSumTimes() {
        Expression expr = new Sum(Money.dollar(2), Money.franc(6)).times(2);
        Money result = bank.reduce(expr, "USD");
        assertEquals(Money.dollar(10), result);
    }

    @Test
    public void testReduceMoney() {
        Expression sum = Money.dollar(10);
        Money result = bank.reduce(sum, "USD");
        assertEquals(Money.dollar(10), result);
    }
    
    @Test
    public void testReduceMoneyToDifferentCurrency() {
        Money dollars = bank.reduce(Money.franc(20), "USD");
        assertEquals(Money.dollar(10), dollars);
    }

    @Test
    public void testIdentityRate() {
        assertEquals(1, bank.getRate("USD", "USD"));
    }

    @Test
    public void testMultiplication() {
        Money five = Money.dollar(5);
        assertEquals(Money.dollar(10), five.times(2));
        assertEquals(Money.dollar(15), five.times(3));
    }

    @Test
    public void testEquality() {
        assertTrue(Money.dollar(5).equals(Money.dollar(5)));
        assertFalse(Money.dollar(5).equals(Money.dollar(6)));
        assertFalse(Money.franc(5).equals(Money.dollar(5)));
    }

 }
