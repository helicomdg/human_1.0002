/*// Create a new XMLHttpRequest object
var xhr = new XMLHttpRequest();

// Set the HTTP method and URL
xhr.open('GET', 'get_cars.php');

// Set the content type
xhr.setRequestHeader('Content-Type', 'application/json');

// Set the response type
xhr.responseType = 'json';

// Send the request
xhr.send();

// Handle the response
xhr.onload = function() {
    if (xhr.status === 200) {
        // Retrieve the car data from the response
        var cars = xhr.response;

        // Create an HTML table to display the car data
        var table = document.createElement('table');

        // Create the table header
        var header = table.createTHead();
        var row = header.insertRow();
        var makeCell = row.insertCell();
        var modelCell = row.insertCell();
        var yearCell = row.insertCell();
        var colorCell = row.insertCell();
        makeCell.innerHTML = 'Make';
        modelCell.innerHTML = 'Model';
        yearCell.innerHTML = 'Year';
        colorCell.innerHTML = 'Color';

        // Create the table body
        var body = table.createTBody();
        for (var i = 0; i < cars.length; i++) {
            var car = cars[i];
            var row = body.insertRow();
            var makeCell = row.insertCell();
            var modelCell = row.insertCell();
            var yearCell = row.insertCell();
            var colorCell = row.insertCell();
            makeCell.innerHTML = car.make;
            modelCell.innerHTML = car.model;
            yearCell.innerHTML = car.year;
            colorCell.innerHTML = car.color;
        }

        // Append the table to the body of the HTML document
        document.body.appendChild(table);
    } else {
        console.log('Error retrieving car data.');
    }
}*/

// fetch("https://").then((data)=>{
//     // console.log(data);
//     return data.json();
// }).then((objectData)=>{
//     console.log(objectData[0].title);
//     let tableData="";
//     objectData.map((values)=>{
//         tableData+=
//             `<tr>
//             <td>${values.title}</td>
//         </tr>`;
//     });
//     document.getElementById(" ").innerHTML=tableData;
// }).catch((err)=>{
//     console.log(err);
// })

