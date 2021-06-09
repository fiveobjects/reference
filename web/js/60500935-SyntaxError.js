var num = 105;
squareDigits(num);
function squareDigits(num) {
    var digit = Math.pow(10, (num.toString().length));
    result = []
    for (; digit >= 1; digit / 10) {
        var rem = num % digit;

        for (i = 0; ; i++) {
            result[i] = Math.pow(rem, 2);
        }

    }
    console.log(result.join(''));
}