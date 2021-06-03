package currency

import (
	"testing"
	"reflect"
)

func TestDollarMultiply(t *testing.T) {
	five := NewDollar(5)
	if *five.times(2) != *NewDollar(10) {
		t.Fatalf(`5 x 2 dollars should be 10`)
	}
	if *five.times(3) != *NewDollar(15) {
		t.Fatalf(`5 x 3 dollars should be 15`)
	}
}


func TestFrancMultiply(t *testing.T) {
	five := NewFranc(5)
	if *five.times(2) != *NewFranc(10) {
		t.Fatalf(`5 x 2 francs should be 10`)
	}
	if *five.times(3) != *NewFranc(15) {
		t.Fatalf(`5 x 3 francs should be 15`)
	}
}

func TestEquality(t *testing.T) {
	if *NewDollar(5) != *NewDollar(5) {
		t.Fatalf("5 dollars should equal 5 dollars")
	}
	if *NewDollar(5) == *NewDollar(6) {
		t.Fatalf("5 dollars should not equal 6 dollars")
	}
	if *NewFranc(5) != *NewFranc(5) {
		t.Fatalf("5 francs should equal 5 francs")
	}
	if *NewFranc(5) == *NewFranc(6) {
		t.Fatalf("5 francs should not equal 6 francs")
	}
	if *NewFranc(5) == *NewDollar(5) {
		t.Fatalf("5 dollars should not equal 5 francs")
	}
	// Note that == already checks type as well as value, so nothing to do here
	// reflect.DeepEqual() would show them being equal however... but that's for later
//	if reflect.DeepEqual(*NewFranc(5), *NewDollar(5)) {
//		t.Fatalf("5 dollars should not equal 5 francs")
//	}
}


