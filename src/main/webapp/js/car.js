const apiBaseUrl = "http://localhost:8081/human_2_0_war_exploded/api/car";

function getCars() {
    return fetch(apiBaseUrl + "/all")
        .then((response) => response.json())
        .catch((error) => console.error(error));
}

function getCarsById(id) {
    return fetch(apiBaseUrl + "/get/" + id)
        .then((response) => response.json())
        .catch((error) => console.error(error));
}

function createCar(car) {
    return fetch(apiBaseUrl + "/post", {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify(car),
    })
        .then((response) => response.json())
        .catch((error) => console.error(error));
}

function updateCar(id, car) {
    return fetch(apiBaseUrl + "/put/" + id, {
        method: "PUT",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify(car),
    })
        .then((response) => response.json())
        .catch((error) => console.error(error));
}

function deleteCar(id) {
    return fetch(apiBaseUrl + "/delete/" + id, {
        method: "DELETE",
    }).catch((error) => console.error(error));
}manAPI('http://localhost:8081/human_2_0_war_exploded/api/car');