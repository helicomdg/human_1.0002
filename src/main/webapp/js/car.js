const form = document.querySelector('#create-car-form');

form.addEventListener('submit', async (event) => {
    event.preventDefault();

    const make = document.querySelector('#make').value;
    const model = document.querySelector('#model').value;
    const year = document.querySelector('#year').value;

    const response = await fetch('http://localhost:8081/human_2_0_war_exploded/api/car', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ make, model, year })
    });

    if (response.ok) {
        alert('Car created successfully!');
    } else {
        alert('Failed to create car!');
    }
});
