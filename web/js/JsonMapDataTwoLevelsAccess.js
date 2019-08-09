raw = '{ "a": { "x": "12", "y": "2", "z": "17" }, "b": { "x": "8", "y": "2", "z": "21" }, "c": { "x": "9", "y": "3", "z": "17" } }';
data = JSON.parse(raw);
Object.keys(data).forEach(key => {
    value = data[key];
    console.log("Values inside: " + key)
    Object.keys(value).forEach(key => console.log(key + "=" + value[key]));
})
