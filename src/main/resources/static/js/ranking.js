axios
    .get("/home/showRankUser", {
        params: {
            userName,
            recordScore,
        },
    }).then(function (response) {
        console.log(response.data);
    }).catch(function (error) {
        console.log(error);
    });