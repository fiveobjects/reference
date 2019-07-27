function fnGetDateListInDateRange(startDate, endDate, addDays) {

    startDate = new Date(startDate);
    endDate = new Date(endDate);
    //
    if (startDate > endDate) {
        return "-1";
    }
    //
    var outputDate = new Array();
    var tmpDate = new Date(startDate);
    do {
        outputDate.push(new Date(tmpDate));
        tmpDate.setDate(tmpDate.getDate() + parseInt(addDays));
    } while (tmpDate <= endDate);
    //
    return outputDate;
}
var dates = fnGetDateListInDateRange('01/10/2019', '10/01/2019', 15);
console.log(dates);
console.log(dates[0] + ', ' + dates[dates.length - 1]);
