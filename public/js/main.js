async function main() {
    const windparkData = await (await fetch("/windpark/data/json")).json()
    console.log(windparkData);

    const output = document.getElementById("output");

    for (let windpark of windparkData) {
        output.innerHTML += getWindpark(windpark)
    }
    for(let windpark of windparkData) {
        for(let we in windpark.windengines) {
            console.log(windpark.ownId, we, windpark.windengines[we])
            generateChart(document.getElementById(`we${windpark.ownId}-${we}`), windpark.windengines[we]);
        }
    }
}

function getWindpark(windpark) {
    return `
<div class="row">
    <div class="col s12 m10 offset-m1">
        <h1>Windpark ${windpark.ownId}</h1>

        <div class="grid">
            ${getWindengines(windpark)}
        </div>
    </div>
</div>`
}

function getWindengines(windpark) {
    let ret = "";
    for(let we in windpark.windengines) {
        ret += getWindengine(windpark.ownId, we);
    }
    return ret;
}

function getWindengine(wpID, weID) {
    return `
<div class="card">
    <div class="card-content">
        <span class="card-title">Windengine: ${weID}</span>
        <canvas id="we${wpID}-${weID}"></canvas>
    </div>
</div>`
}

function generateChart(elemnt, data) {
    let ctx = elemnt.getContext('2d');

    const options = {
        type: 'line',
        data: {
            datasets: [{
                label: 'Windspeed',
                data: transformData(data, 'windspeed'),
                borderColor: 'red',
                fill: false,
            }, {
                label: 'Temperature',
                data: transformData(data, 'temperature'),
                borderColor: 'blue',
                fill: false,
            }, {
                label: 'Rotationspeed',
                data: transformData(data, 'rotationspeed'),
                borderColor: 'yellow',
                fill: false,
            }, {
                label: 'Blindpower',
                data: transformData(data, 'blindpower'),
                borderColor: 'green',
                fill: false,
            }]
        },
        options: {
            scales: {
                xAxes: [{
                    type: 'time',
                    time: {
                        //parser: 'YYYY-MM-DD HH:mm:ss:SSS',
                    }
                }],
            },
            elements: {
                line: {
                    tension: 0, // disables bezier curves
                }
            },
            animation: {
                duration: 0, // general animation time
            },
            hover: {
                animationDuration: 0, // duration of animations when hovering an item
            },
            responsiveAnimationDuration: 0, // animation duration after a resize
        }
    }

    new Chart(ctx, options);
}

function transformData(windengineData, attr) {
    const ret = []
    //for (let key of Object.keys(windengineData).sort()) {
    for (let key in windengineData) {
        ret.push({
            x: windengineData[key].timestamp,
            y: windengineData[key][attr]
        })
    }
    return ret;
}

window.onload = main;