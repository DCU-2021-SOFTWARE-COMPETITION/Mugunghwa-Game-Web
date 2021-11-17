axios.get("/home/showRankUser")
    .then(function (response) {
        console.log(Response.data);
    }).catch(function (error) {
        console.log(error);
    });
