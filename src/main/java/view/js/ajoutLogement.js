function saveLogement(form) {
    const logement = {
        id:form.logementId.value,
        name:form.logementNom.value,
        type:form.logementType.value,
        adresse:form.logementAdresse.value,
        codePostal:form.logementCodePostal.value,
        ville:form.logementVille.value,
        services:form.servicesLogement.value,
        contraintes:form.contraintesLogement.value,
    }
console.log(logement);

    // prepare the post request
    fetch("http://localhost:8080/ajoutLogement", {
        method:"POST",
        headers: {"Accept": "application/json, text/plain, */*",
        "Content-type":"application/json"},
        body: JSON.stringify({
            id:logement.id,
            nom:logement.name,
            type:logement.type,
            adresse:logement.adresse,
            codePostal:logement.codePostal,
            ville:logement.ville,
            services:logement.services,
            contraintes:logement.contraintes,
        })
        })

    // then take the retunr result from the post request
        .then(result =>result.json())

    // set the input fields with the return logement values

        .then(data => {
            document.querySelector("#logementId").value = data.id;
            document.querySelector("#logementNom").value = data.nom;
            document.querySelector("#logementType").value = data.type;
            document.querySelector("#logementAdresse").value = data.adresse;
            document.querySelector("#logementCodePostal").value = data.codePostal;
            document.querySelector("#logementVille").value = data.ville;
            document.querySelector("#servicesLogement").value = data.services;
            document.querySelector("#contraintesLogement").value = data.contraintes;

            showMessage(data.nom);
        })
}

function showMessage(message) {
    document.querySelector("#SuccessMessage").innerHTML=`
        <p>Le logement ${message} a été ajouté avec succés</p> 
    `;

    // on cache le message après 3 secondes
    setTimeout(function (){
        document.querySelector("#SuccessMessage").innerHTML="";
    }, 3000)
}
