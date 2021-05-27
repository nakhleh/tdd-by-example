package main

import (
	"fmt"
	"github.com/nakhleh/tdd-by-example/currency"
)

func main() {
	d := currency.NewDollar(2)
	fmt.Printf("Hello, have $%v\n", d.Amount)
}