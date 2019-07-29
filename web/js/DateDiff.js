function dateDiff(diffMs) {
    var diffDays = Math.floor(diffMs / 86400000); // days
    var diffHrs = Math.floor((diffMs % 86400000) / 3600000); // hours
    var diffMins = Math.round(((diffMs % 86400000) % 3600000) / 60000); // minutes
    var diffSecs = Math.round((((diffMs % 86400000) % 3600000) % 60000) / 1000); // seconds

    console.log(diffMs + ", " + diffDays + ", " + diffHrs + ", " + diffMins + ", " + diffSecs);
}

dateDiff(new Date("Mon Jul 15 2018 20:35:00") - new Date("Mon Jul 15 2018 19:37:33"));
dateDiff(new Date("2019-07-29 09:10:10") - new Date("2019-07-29 08:30:00"));


