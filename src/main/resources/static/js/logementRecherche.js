const urlString = window.location.search;
const urlParams = new URLSearchParams(urlString);

resultatRecherche();

function resultatRecherche() {
    fetch('http://localhost:8080/logementRecherche?ville=' + urlParams.get('ville'))
        .then(response => response.json())
        .then(data => {
            let tableInfo = "";
            data.forEach(element => tableInfo+=`
                <tr>
                <td>${element.id}</td>
                <td>${element.nom}</td>
                <td>${element.type}</td>
                <td>${element.adresse}</td>
                <td>${element.codePostal}</td>
                <td>${element.ville}</td>
                <td><button onclick='navigate(${element.id})'>Voir le logement</button></td>
                </tr>
            `  )
            document.querySelector("#listTable").innerHTML = tableInfo;
            document.querySelector("#titreRecherche").innerHTML =
                `Logement disponibles à ${urlParams.get('ville')}`;
        })
}

function navigate(logementId) {
    window.location.href='/projet_techno_web/view/logement.html?id=' + logementId;
}