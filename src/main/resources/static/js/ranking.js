let rankData;
const parentList = document.querySelectork("#rankList");

axios
    .get("/home/showRankUser")
    .then(function (response) {
        rankData = response.data;
        console.log(response.data);
    }).catch(function (error) {
        console.log(error);
    });

for (let i = 0; i < rankData.length; i++) {
    let listName = document.createElement('ul');
    let listScore = document.createElement('ul');
    listName.innerHTML(rankData[1].userName)
    listScore.innerHTML(rankData[1].recordScore);

    parentList.appendChild(list);
}

