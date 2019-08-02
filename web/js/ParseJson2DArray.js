var attrs = ["id", "carname", "year", "registration"];
var jsonString =
    '{\n' +
    '    "labels": [\n' +
    '        {\n' +
    '            "name": "test",\n' +
    '            "age": 33,\n' +
    '            "contact": "test",\n' +
    '            "cars": [\n' +
    '                {"id": 2222, "carname": "ford", "year": 2000, "registration": "cd60"},\n' +
    '                {"id": 3333, "carname": "BMW", "year": 2012, "registration": "fs41"}\n' +
    '            ]\n' +
    '        }\n' +
    '    ]\n' +
    '}\n' +
    '';

var obj = JSON.parse(jsonString);
console.log(obj)
for (var i = 0; i < obj.labels.length; i++) {
    for (var j = 0; j < obj.labels[i]['cars'].length; j++) {
        for (var k = 0; k < attrs.length; k++) {
            console.log(obj.labels[0]['cars'][j][attrs[k]])
        }
        console.log("=========")
    }
}

[...obj.labels].forEach(element => {
    element['cars'].forEach(car => {
        for (var i = 0; i < attrs.length; i++) {
            console.log(car[attrs[i]]);
        }
    });
});
[...obj.labels].forEach(element => {
    element['cars'].forEach(car => Object.keys(car).map(attr => console.log(attr + " " + car[attr])));
});


