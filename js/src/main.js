const Dollar = require('./Dollar');

function main() {
    const money = new Dollar(2);
    console.log(`Hello world, have $${money.amount}`);
}

main();
