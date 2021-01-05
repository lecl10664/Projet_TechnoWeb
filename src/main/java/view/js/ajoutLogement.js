function saveLogement(form) {
    const logement = {
        id:form.logementId.value,
        name:form.logementName.value,
        type:form.logementType.value,
    }

    console.log(logement);

    // prepare the post request
    fetch("http://localhost:3306/projet_web_tech", {
        method:"POST",
        headers: {"Accept": "application/json, text/plain, */*",
        "Content-type":"application/json"},
        body: JSON.stringify({id:logement.id, nom:logement.name, type:logement.type})
        })

    // then take the retunr result from the post request
        .then(result =>result.json())

    // set the input fields with the return logement values

        .then(data => {
            document.querySelector("#logementId")

        })


}