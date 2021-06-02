package currency

import (
	"testing"
)

func TestMultiply(t *testing.T) {
	five := NewDollar(5)
	var product = five.times(2)
	if product.Amount != 10 {
		t.Fatalf(`5 x 2 dollars = %v, want 10`, product.Amount)
	}
	product = five.times(3)
	if product.Amount != 15 {
		t.Fatalf(`5 x 3 dollars = %v, want 15`, product.Amount)
	}
}

func TestEquality(t *testing.T) {
	firstFive := NewDollar(5)
	secondFive := NewDollar(5)
	six := NewDollar(6)
	if *firstFive != *secondFive {
		t.Fatalf(`5 dollars (%v) not equal to 5 dollars(%v)`, firstFive, secondFive)
	}
	if *firstFive == *six {
		t.Fatalf(`5 dollars (%v) equal to 6 dollars(%v)`, firstFive, six)
	}
}