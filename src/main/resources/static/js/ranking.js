let rankData;

axios
    .get("/home/showRankUser")
    .then(function (response) {
        rankData = response.data;
        console.log(response.data);
    }).catch(function (error) {
        console.log(error);
    });