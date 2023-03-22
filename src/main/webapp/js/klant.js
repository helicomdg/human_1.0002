// Get All
const klantTableBody = document.querySelector('#klant-table-body');
fetch('http://localhost:8081/human_2_0_war_exploded/api/klant/getKlanten')
    .then(response => response.json())
    .then(klant => {
        klant.forEach(klant => {
            const row = document.createElement('tr');
            row.innerHTML = `
        <td>${klant.id}</td>
        <td>${klant.first_name}</td>
        <td>${klant.last_name}</td>
        <td>${klant.email}</td>
        
        <td>
            <button class="btn btn-warning btn-sm">Update</button>
            <button class="delete-btn btn btn-danger btn-sm" data-id="${klant.id}">Delete</button>
        </td>
      `;
            klantTableBody.appendChild(row);
        });
    })
    .catch(error => {
        console.error('Error fetching Klant:', error);
        alert('An error occurred while fetching the Klant. Please try again later.');
    });


// Delete
klantTableBody.addEventListener('click', event => {
    if (event.target.classList.contains('delete-btn')) {
        const id = event.target.dataset.id;
        fetch(`http://localhost:8081/human_2_0_war_exploded/api/klant/delete/${id}`, {
            method: 'DELETE'
        })
            .then(() => {
                alert(`Klant ${id} removed successfully!`);
                event.target.closest('tr').remove();
            })
            .catch(error => {
                console.error(`Error removing Klant ${id}:`, error);
                alert(`An error occurred while removing Klant ${id}. Please try again later.`);
            });
    }
});

