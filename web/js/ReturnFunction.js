function add(a, b) {
    if (arguments.length == 1) {
        if (typeof a == "number") {
            return function (b) {
                if (typeof b == "number") {
                    return a + b;
                }
            };
        } else {
            return "undefined";
        }
    } else if (arguments.length == 2) {
        if (typeof a == "number" && typeof b == "number") {
            return a + b;
        } else {
            return "undefined";
        }
    } else {
        return "undefined";
    }
}

console.log(add(10, 15));
var f = add(20);
console.log(f(18));
console.log(add("xyz"));
console.log(add(10, "5"));
console.log(add(4)(6));