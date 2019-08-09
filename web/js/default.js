let data1 = [{ source: 'b', foo: 'bar' }, { source: 'd', foo: 'baz' }];
let data2 = ['b', 'c', 'e'];
let indices = [];
let data3 = [...data1];
data1.forEach(token => indices.push(token.source));
data2.forEach(token => {
    if (!indices.includes(token)) {
        data3.push({ source: token, foo: 'default' })
    }
});
console.log(data3);