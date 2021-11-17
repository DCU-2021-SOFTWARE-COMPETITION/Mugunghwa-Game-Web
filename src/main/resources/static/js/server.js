function onClickSubmit() {
    var identificationNumber = document.getElementById(
        "identificationNumber"
    ).value;
    var userName = document.getElementById("userName").value;
    console.log(identificationNumber);
    console.log(userName);
    if ((identificationNumber.length >= 6 && identificationNumber.length <= 8) && (userName.length >= 2 && userName.length <= 8)) {
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
    else {
        alert("이름 : 2~8자리, 학번 : 6~8자리로 입력해주세요!");
    }
}