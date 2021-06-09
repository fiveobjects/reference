function showChart(input, result) {
    var days = result.map(function (item) {
        return item.publish_date;
    });
    var exchangeRate = result.map(function (item) {
        return item.exchange_rate;
    });
    var convertedAmount = result.map(function (item) {
        return item.converted_amount;
    });
    log(result);
    log(days, exchangeRate, convertedAmount);
    $j('#r-chart1').remove(); // this is my <canvas> element
    $j('#r-chart').append('<canvas id="r-chart1"></canvas>');
    var context = $j('#r-chart1');
    // TODO Include principal and interest
    var config = {
        type: 'line',
        data: {
            labels: days,
            datasets: [{
                data: exchangeRate,
                label: 'Exchange Rate',
                fill: false,
                backgroundColor: window.chartColors.blue,
                borderColor: window.chartColors.blue,
                yAxisID: 'y-axis-1'
            }, {
                data: convertedAmount,
                label: 'ConvertedAmount',
                fill: false,
                backgroundColor: window.chartColors.green,
                borderColor: window.chartColors.green,
                yAxisID: 'y-axis-2',
            }]
        },
        options: {
            responsive: true,
            hoverMode: 'index',
            stacked: false,
            title: {
                display: true,
                text: 'Chart.js Line Chart - Multi Axis'
            },
            scales: {
                yAxes: [{
                    type: 'linear', // only linear but allow scale type registration. This allows extensions to exist solely for log scale for instance
                    display: true,
                    position: 'left',
                    id: 'y-axis-1',
                }, {
                    type: 'linear', // only linear but allow scale type registration. This allows extensions to exist solely for log scale for instance
                    display: true,
                    position: 'right',
                    id: 'y-axis-2',

                    // grid line settings
                    gridLines: {
                        drawOnChartArea: false, // only want the grid lines for one axis to show up
                    },
                }],
            }
        }
    };
    var chart = new Chart(context, config);
}