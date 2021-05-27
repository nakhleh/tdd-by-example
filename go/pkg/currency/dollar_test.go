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