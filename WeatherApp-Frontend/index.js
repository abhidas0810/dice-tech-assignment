function getForecast(apiEndpoint) {
    console.log("inside getForecast");
    var city = document.getElementById("cityInput").value;
    var xhr = new XMLHttpRequest();
    let endpoint = null;
    if (apiEndpoint=="/custom-forecast-summary") {
        endpoint = "https://dice-tech-assignment-production.up.railway.app/custom/forecast/summary";
    } else {
        endpoint = "https://dice-tech-assignment-production.up.railway.app/custom/hourly/summary";
    }
    xhr.open("GET", endpoint + "?city=" + city, true);
    xhr.setRequestHeader("Content-Type", "application/json");
    xhr.setRequestHeader("customClientId", "abhishek");
    xhr.setRequestHeader("customClientSecret", "123");
    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4) {
            if (xhr.status === 200) {
                var response = JSON.parse(xhr.responseText);
                displayForecast(response);
            } else {
                displayError("Error: " + xhr.statusText);
            }
        }
    };
    xhr.send();
}

function displayForecast(data) {
    console.log(data);
    var forecastResult = document.getElementById("forecastResult");
    forecastResult.innerHTML = ""; 
    var ul = document.createElement("ul");
    for (var key in data) {
        if (data.hasOwnProperty(key)) {
            var li = document.createElement("li");
            li.textContent = key + ": " + data[key];
            ul.appendChild(li);
        }
    }
    forecastResult.appendChild(ul);
}

function displayError(message) {
    var forecastResult = document.getElementById("forecastResult");
    forecastResult.innerHTML = "<p>" + message + "</p>";
}
