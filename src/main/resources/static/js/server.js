function onClickSubmit() {
    var identificationNumber = document.getElementById(
        "identificationNumber"
    ).value;
    var userName = document.getElementById("userName").value;
    console.log(identificationNumber);
    console.log(userName);
    axios
        .post("/home/join", {
            identificationNumber: identificationNumber,
            userName: userName,
        })
        .then(function (response) {
            console.log(response);
        })
        .catch(function (err) {
            console.log(err);
        });
}