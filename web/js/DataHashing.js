var data = [{ 'DateOut': 6 }, { 'DateOut': 12 }, { 'DateOut': 6 }];
var hash = {};
for (let i = 0; i < data.length; i++) {
    (hash[data[i]['DateOut'] || []).push(data[i]);
    console.log(hash)
}
console.log(hash);