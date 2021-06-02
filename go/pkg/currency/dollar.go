package currency

type Dollar struct {
	amount int
}

func NewDollar(value int) *Dollar {
	d := new(Dollar)
	d.amount = value
	return d
}

func (d *Dollar) times(multiplier int) *Dollar {
	return &Dollar{amount: d.amount * multiplier}
}

