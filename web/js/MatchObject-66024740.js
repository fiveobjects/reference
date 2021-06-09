data = [
    {
        "id": 1,
        "name": "project one"
    },
    {
        "id": 2,
        "name": "project two"
    },
    {
        "id": 3,
        "name": "project three"
    }
];
let object_to_find = { id: 3, name: 'project three' }

// Returns the first match
let result1 = data.find(function (value) {
    return value.id == object_to_find.id && value.name == object_to_find.name;
});

// Get filtered array
let result2 = data.filter(function (value) {
    return value.id == object_to_find.id && value.name == object_to_find.name;
});

// Returns true if some values pass the test
let result3 = data.some(function (value) {
    return value.id == object_to_find.id && value.name == object_to_find.name;
});

console.log("result1: " + result1.id + ", " + result1.name);
console.log("result2 size: " + result2.length);
console.log("result3: " + result3);