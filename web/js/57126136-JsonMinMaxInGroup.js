let data = JSON.parse('{ "2019-07-17":{ "7":66, "8":66, "9":66, "11":70, "12":70, "16":70 }, "2019-07-18":{ "10":68, "11":68, "12":75, "14":75, "15":75, "18":70 } }');
/* result = Object.fromEntries(Object.entries(data).map(([k, v]) => {
    var values = Object.entries(v).reduce((r, [l, id], i, { [i - 1]: last }) => {
        if (last && +last[0] + 1 === +l && last[1] === id) {
            r[r.length - 1].end = +l;
        } else {
            r.push({ start: +l, end: +l + 1, id });
        }
        return r;
    }, []);
    return [k, values];
})); */

console.log(result);