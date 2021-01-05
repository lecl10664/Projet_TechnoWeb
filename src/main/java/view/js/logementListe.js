showLogement();

function showLogement() {
    fetch("http://localhost:8080/logementListe")
        .then(response => response.json())
        .then(data => {
            let tableInfo = "";
            data.forEach(element => tableInfo+=
                "<tr>" +
                "<td>" + element.id +"</td>" +
                "<td>" + element.nom + "</td>" +
                "<td>" + element.type + "</td>" +
                "<td><button>Voir le logement</button></td>" +
                "</tr>")
            document.querySelector("#listTable").innerHTML = tableInfo;
        })
}