let rankData;
const parentList = document.querySelector("#rankList");

axios
    .get("/home/showRankUser")
    .then(function (response) {
        rankData = response.data;
        console.log(response.data);
        loadList();
    }).catch(function (error) {
        console.log(error);
    });

function loadList() {
    for (let i = 0; i < rankData.length; i++) {
        let listName = document.createElement('li');

        let spanRanking = document.createElement('div');
        spanRanking.innerText = `${i + 1} 위`;

        let spanName = document.createElement('div');
        spanName.innerText = rankData[i].userName;

        let spanScore = document.createElement('div');
        spanScore.innerText = `${rankData[i].recordScore}초`;

        listName.appendChild(spanRanking);
        listName.appendChild(spanName);
        listName.appendChild(spanScore);

        parentList.appendChild(listName);
    }
}