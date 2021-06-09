fruits = ['apple', 'apple', 'apple', 'pear', 'pear', 'orange', 'apple', 'orange']
let groups = fruits.reduce(function (result, value) {
    let match = result.find(function (pair) {
        return pair.name == value;
    });
    if (match) {
        match["number"] += 1;
    } else {
        result.push({ "name": value, "number": 1 });
    }
    return result;
}, []);
console.log("Groups: " + JSON.stringify(groups));