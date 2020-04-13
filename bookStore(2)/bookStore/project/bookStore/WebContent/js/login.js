const baseUrl = "http://localhost:8080/bookStore/user_";
var option = document.getElementById("login");
option.onclick = function () {
    var userName = document.getElementById("user").value;
    var userPass = document.getElementById("password").value;
    if (userName && userPass) {
        $.ajax({
            url: baseUrl + "login",
            type: 'post',
            dataType: 'json',
            data: {
                "userName": userName,
                "password": userPass
            },
            success: function (data) {
            	console.log(data)
                if (data.code == "1") {
                    if (userName == "admin") { //如果用户是管理员，则进入管理页面
                        window.location.href = "adminHome.html"
                    } else { //用户是普通用户，进入书店主页
                        //返回了用户Id== 》保存在浏览器缓存中
                        var sessionId = {
                            "id": data.userId
                        }
                        console.log("1");
                        saveData(data.userId);
                        window.location.href = "home.html"
                    }
                }
            }
        })
    }

}

function saveData(data) {
	console.log(data);
	console.log("2");
   // var listData = localStorage.getItem("currentUser");
    //console.log(listData);
    localStorage.setItem("currentUser", data);
    /*if (!listData) {
    	console.log("3");
        localStorage.setItem("currentUser", data);
    } else {
        listData == null
    }*/
}