class Dollar {

    constructor(amount) {
        this.amount = amount;
    }

    times(value) {
        this.amount *= value;
    }

}

module.exports = Dollar;
