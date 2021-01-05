function saveLogement(form) {
    const logement = {
        id:form.logementId.value,
        name:form.logementNom.value,
        type:form.logementType.value,
    }


    // prepare the post request
    fetch("http://localhost:8080/logement", {
        method:"POST",
        headers: {"Accept": "application/json, text/plain, */*",
        "Content-type":"application/json"},
        body: JSON.stringify({id:logement.id, nom:logement.name, type:logement.type})
        })

    // then take the retunr result from the post request
        .then(result =>result.json())

    // set the input fields with the return logement values

        .then(data => {
            console.log(data)
            document.querySelector("#logementId").value = data.id;
            document.querySelector("#logementNom").value = data.nom;
            document.querySelector(".logementType").value = data.type;
        })


}