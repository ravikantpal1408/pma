
var chartDataDecoded = decodeHtml(chartData);
var parsedChartData = JSON.parse(chartDataDecoded);

// for pie chart 
new Chart(document.getElementById('myPieChart'), {
    type: 'pie',
    // The data for our dataset
    data: {
        labels:  parsedChartData.map(e=>e.label),
        datasets: [{
            label: 'Project Dataset',
            backgroundColor: ['#3e95cd', '#8e5ea2', '#3cba9f'],
            borderColor: 'rgb(255, 99, 132)',
            data: parsedChartData.map(e=>e.value)
        }]
    },

    // Configuration options go here
    options: {}
});


function decodeHtml(html) {
    var txt = document.createElement("textarea");
    txt.innerHTML = html;
    return txt.value;
}