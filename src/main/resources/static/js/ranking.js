let rankData;
const parentList = document.querySelector("#rankList");

axios
    .get("/home/showRankUser")
    .then(function (response) {
        rankData = response.data;
        console.log(response.data);
        for (let i = 0; i < rankData.length; i++) {
            let listName = document.createElement('ul');

            let spanName = document.createElement('span');
            spanName.innerText = rankData[i].userName;

            let spanScore = document.createElement('span');
            spanScore.innerText = rankData[i].recordScore;

            listName.appendChild(spanName);
            listName.appendChild(spanScore);

            parentList.appendChild(listName);
        }
    }).catch(function (error) {
        console.log(error);
    });