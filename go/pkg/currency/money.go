package currency

type Money struct {
	amount int
}

type Dollar struct {
	Money
}

func NewDollar(value int) *Dollar {
	d := new(Dollar)
	d.amount = value
	return d
}

func (d *Dollar) times(multiplier int) *Dollar {
	return &Dollar{ Money{amount: d.amount * multiplier} }
}

type Franc struct {
	Money 
}

func NewFranc(value int) *Franc {
	d := new(Franc)
	d.amount = value
	return d
}

func (d *Franc) times(multiplier int) *Franc {
	return &Franc{ Money{amount: d.amount * multiplier} }
}

