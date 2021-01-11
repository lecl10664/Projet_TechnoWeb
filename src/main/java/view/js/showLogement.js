const urlString = window.location.search;
const urlParams = new URLSearchParams(urlString);

showExistingLogement();

function showExistingLogement(){
    if (urlParams.get('id')!=null){
        fetch('http://localhost:8080/logement?id=' + urlParams.get('id'))
            .then(response => response.json())
            .then(data => {
                document.querySelector("title").innerHTML = `${data.nom}`;
                document.querySelector('#nom').innerHTML = `${data.nom}`;
                document.querySelector('#ville').innerHTML = `${data.ville}, France`;
                if (data.type === 'Maison') {
                    document.querySelector('#imgLogement').setAttribute("src", "img/maison.jpg");
                } else {
                    document.querySelector('#imgLogement').setAttribute("src", "img/appartement.jpg");
                }
                document.querySelector('#type').innerHTML = `${data.type}`;
                document.querySelector('#adresse').innerHTML = `${data.adresse}, ${data.ville} ${data.codePostal}, France`;
                document.querySelector('#services').innerHTML = `${data.services}`;
                document.querySelector('#contraintes').innerHTML = `${data.contraintes}`;


                /*document.querySelector('#afficheLogement').innerHTML = `
                   <p>Id : ${data.id}</p>
                   <p>Nom : ${data.nom}</p>
                   <p>Type : ${data.type}</p>
                   <p>Adresse : ${data.adresse}</p>
                   <p>Code Postal : ${data.codePostal}</p>
                   <p>Ville : ${data.ville}</p>
                   <p>Services à rendre : ${data.services}</p>
                   <p>Contraintes du logement : ${data.contraintes}</p>
                `;*/
            })

    }
}
