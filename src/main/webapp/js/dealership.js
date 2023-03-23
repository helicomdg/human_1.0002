const apiBaseUrl = "http://localhost:8081/human_2_0_war_exploded/api/shop";

function getDealerships() {
    return fetch(apiBaseUrl + "/all")
        .then((response) => response.json())
        .catch((error) => console.error(error));
}

function getCarDealershipById(id) {
    return fetch(apiBaseUrl + "/get/" + id)
        .then((response) => response.json())
        .catch((error) => console.error(error));
}

function createCarDealership(carDealership) {
    return fetch(apiBaseUrl + "/post", {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify(carDealership),
    })
        .then((response) => response.json())
        .catch((error) => console.error(error));
}

function updateCarDealership(id,carDealership) {
    return fetch(apiBaseUrl + "/put/" + id, {
        method: "PUT",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify(carDealership),
    })
        .then((response) => response.json())
        .catch((error) => console.error(error));
}

function deleteCarDealership(id) {
    return fetch(apiBaseUrl + "/delete/" + id, {
        method: "DELETE",
    }).catch((error) => console.error(error));
}manAPI('http://localhost:8081/human_2_0_war_exploded/api/shop');