// const url = 'http://localhost:8081/human_2_0_war_exploded/api/dealership';
//
// function createCarDealership() {
//     const name = document.getElementById('name').value;
//     const address = document.getElementById('address').value;
//     const phoneNumber = document.getElementById('phoneNumber').value;
//     const carDealership = { name, address, phoneNumber };
//
//     fetch(url, {
//         method: 'POST',
//         headers: {
//             'Content-Type': 'application/json'
//         },
//         body: JSON.stringify(carDealership)
//     })
//         .then(response => response.json())
//         .then(data => {
//             document.getElementById('result').innerHTML = `Car Dealership created: ${data.id}`;
//         })
//         .catch(error => {
//             console.error(error);
//             document.getElementById('result').innerHTML = `Error creating Car Dealership`;
//         });
// }
//
// function getCarDealerships() {
//     fetch(url)
//         .then(response => response.json())
//         .then(data => {
//             const dealerships = data.map(dealership => {
//                 return `<li>${dealership.name} - ${dealership.address} - ${dealership.phoneNumber}</li>`;
//             }).join('');
//             document.getElementById('result').innerHTML = `<ul>${dealerships}</ul>`;
//         })
//         .catch(error => {
//             console.error(error);
//             document.getElementById('result').innerHTML = `Error getting Car Dealerships`;
//         });
// }
//
// function updateCarDealership(id, carDealership) {
//     fetch(`${url}/${id}`, {
//         method: 'PUT',
//         headers: {
//             'Content-Type': 'application/json'
//         },
//         body: JSON.stringify(carDealership)
//     })
//         .then(response => response.json())
//         .then(data => {
//             document.getElementById('result').innerHTML = `Car Dealership updated: ${data.id}`;
//         })
//         .catch(error => {
//             console.error(error);
//             document.getElementById('result').innerHTML = `Error updating Car Dealership`;
//         });
// }

// Get the DOM elements we'll need
const dealershipsTable = document.getElementById('dealershipsTable');
const createForm = document.getElementById('createForm');
const updateForm = document.getElementById('updateForm');
const deleteForm = document.getElementById('deleteForm');

// Function to render the list of dealerships
const renderDealerships = (dealerships) => {
    // Clear the table
    dealershipsTable.innerHTML = '';

    // Add the headers
    const headersRow = document.createElement('tr');
    headersRow.innerHTML = '<th>ID</th><th>Name</th><th>City</th><th>State</th>';
    dealershipsTable.appendChild(headersRow);

    // Add the rows
    for (const dealership of dealerships) {
        const row = document.createElement('tr');
        row.innerHTML = `<td>${dealership.id}</td><td>${dealership.name}</td><td>${dealership.city}</td><td>${dealership.state}</td>`;
        dealershipsTable.appendChild(row);
    }
};

// Function to fetch the list of dealerships from the API and render them
const getDealerships = () => {
    fetch('http://localhost:8081/human_2_0_war_exploded/api/dealership')
        .then(response => response.json())
        .then(data => renderDealerships(data));
};

// Function to create a new dealership using the API
const createDealership = (event) => {
    event.preventDefault();
    const formData = new FormData(event.target);
    const dealership = {
        name: formData.get('name'),
        city: formData.get('city'),
        state: formData.get('state'),
    };
    fetch('http://localhost:8081/human_2_0_war_exploded/api/dealership', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(dealership)
    })
        .then(response => response.json())
        .then(data => {
            getDealerships();
            createForm.reset();
        });
};

// Function to update an existing dealership using the API
const updateDealership = (event) => {
    event.preventDefault();
    const formData = new FormData(document.querySelector("#updateDealershipForm"));
    const id = formData.get("id");
    const name = formData.get("name");
    const address = formData.get("address");
    const phone = formData.get("phone");
    const email = formData.get("email");

fetch(`http://localhost:8081/human_2_0_war_exploded/api/dealership/${id}`, {
    method: "PUT",
    headers: {
        "Content-Type": "application/json",
    },
    body: JSON.stringify({ name, address, phone, email }),
})
    .then((response) => response.json())
    .then((data) => {
        console.log("Dealership updated successfully:", data);
        // Reload the page to display the updated dealership
        location.reload();
    })
    .catch((error) => console.error("Error updating dealership:", error));
};
