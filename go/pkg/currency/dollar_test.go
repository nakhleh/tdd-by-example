package currency

import (
	"testing"
)

func TestMultiply(t *testing.T) {
	dollar := NewDollar(2)
	dollar.times(5)
	if dollar.Amount != 10 {
		t.Fatalf(`2 x 5 dollars = %v, want 10`, dollar.Amount)
	}
}