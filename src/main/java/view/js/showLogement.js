const urlString = window.location.search;
const urlParams = new URLSearchParams(urlString);

showExistingLogement();

function showExistingLogement(){
    if (urlParams.get('id')!=null){
        fetch('http://localhost:8080/logement?id=' + urlParams.get('id'))
            .then(response => response.json())
            .then(data => {
                document.querySelector('#afficheLogement').innerHTML = `
                    <p>Id : ${data.id}</p>
                    <p>Nom : ${data.nom}</p>
                    <p>Type : ${data.type}</p>
                    <p>Adresse : ${data.adresse}</p>
                    <p>Code Postal : ${data.codePostal}</p>
                    <p>Ville : ${data.ville}</p>
                    <p>Services à rendre : ${data.services}</p>
                    <p>Contraintes du logement : ${data.contraintes}</p>
                `;
            })

    }
}


function saveService(form) {

    logementId = urlParams.get('id');
    console.log(logementId)

    // prepare the post request
    fetch("http://localhost:8080/logement", {
        method:"POST",
        headers: {"Accept": "application/json, text/plain, */*",
            "Content-type":"application/json"},
        body: JSON.stringify({id:logementId, services:form.serviceLogement.value})
    })

        // then take the retunr result from the post request
        .then(result =>result.json())

        // set the input fields with the return logement values

        .then(data => {
            document.querySelector("#serviceLogement").value = data.services;


            //showMessageService();
        })
}