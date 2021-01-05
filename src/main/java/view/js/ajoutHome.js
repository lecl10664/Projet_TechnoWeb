function saveHome(form) {
    const home = {
        id:form.homeId.value,
        name:form.homeName.value,
        type:form.homeType.value,
    }

    console.log(home);

    // prepare the post request
    fetch("http://localhost:3306/projet_web_tech", {
        method:"POST",
        headers: {"Accept": "application/json, text/plain, */*",
        "Content-type":"application/json"},
        body: JSON.stringify({id:home.id, nom:home.name, type:home.type})
        })


}