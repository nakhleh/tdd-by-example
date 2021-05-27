package currency

type Dollar struct {
	Amount int
}

func NewDollar(value int) *Dollar {
	d := new(Dollar)
	d.Amount = value
	return d
}

func (d *Dollar) times(multiplier int) {
	d.Amount *= multiplier
}

