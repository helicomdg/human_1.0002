const apiBaseUrl = "http://localhost:8081/human_2_0_war_exploded/api/klant";

function getKlanten() {
    return fetch(apiBaseUrl + "/all")
        .then((response) => response.json())
        .catch((error) => console.error(error));
}

function getKlantById(id) {
    return fetch(apiBaseUrl + "/get/" + id)
        .then((response) => response.json())
        .catch((error) => console.error(error));
}

function createKlant(klant) {
    return fetch(apiBaseUrl + "/post", {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify(klant),
    })
        .then((response) => response.json())
        .catch((error) => console.error(error));
}

function updateKlant(id, klant) {
    return fetch(apiBaseUrl + "/put/" + id, {
        method: "PUT",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify(klant),
    })
        .then((response) => response.json())
        .catch((error) => console.error(error));
}

function deleteKlant(id) {
    return fetch(apiBaseUrl + "/delete/" + id, {
        method: "DELETE",
    }).catch((error) => console.error(error));
}manAPI('http://localhost:8081/human_2_0_war_exploded/api/klant');