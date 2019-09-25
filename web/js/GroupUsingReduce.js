var array = []
array.push({ payslipId: 1759 });
array.push({ payDate: "2019-04-19T00:00:00+00:00" });
array.push({ periodsPerYear: 52 });
array.push({ taxPeriod: 2 });
array.push({ payslipId: 1760 });
array.push({ payDate: "2019-04-19T00:00:00+00:00" });
array.push({ periodsPerYear: 52 });
array.push({ taxPeriod: 2 });

result = array.reduce((aggr, item) => {
    itemKey = Object.keys(item)[0];
    if (Number.isInteger(item[itemKey])) {
        if (!aggr[itemKey]) {
            aggr[itemKey] = 0;
        }
        aggr[itemKey] = parseInt(aggr[itemKey]) + parseInt(item[itemKey]);
    }
    return aggr;
}, {});