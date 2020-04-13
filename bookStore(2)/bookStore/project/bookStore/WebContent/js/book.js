const baseUrl = "http://localhost:8080/bookStore/book_";

function init() {
    initBooks();
}

function initBooks() {
    localStorage.removeItem("shopProducts");
    $.ajax({
        url: baseUrl + "allBooks",
        type: 'GET',
        dataType: 'json',
        success: function (data) {
            //console.log(data)
            showBooks(data.list)
        }
    })
}

function showBooks(list) {
    if (list.length > 0) {
        for (var i = 0; i < list.length; i++) {
            var wraps = document.createElement("div");
            wraps.className = 'item';
            var p0 = document.createElement("p");
            var p1 = document.createElement("p");
            var p2 = document.createElement("p");
            var p3 = document.createElement("p");
            var p4 = document.createElement("p");
            var div1 = document.createElement("div");
            var span1 = document.createElement("span");
            var span2 = document.createElement("span");
            span1.id = "count";
            span1.innerHTML = "1"
            p0.innerHTML = 'bookName: ' + list[i].bookName;
            p1.innerHTML = 'AuthorName: ' + list[i].authorName;
            p2.innerHTML = 'ISBN: ' + list[i].iSBN;
            p3.innerHTML = 'genre: ' + list[i].genre;
            p4.innerHTML = 'price: $ ' + list[i].price;
            div1.innerHTML = '<input  type="button" value="-" onClick="less(' + i + ')"><span id="count' + i + '">0</span><input type="button" value="+" onClick="add(' + i + ')">';
            span2.innerHTML = '<i class="layui-icon layui-icon-add-circle" style="font-size: 18px; color: #ffd032;" onclick="shop(' + i + ',' + list[i].bookID + ')">Add to cart</i>'
            wraps.appendChild(p0)
            wraps.appendChild(p1)
            wraps.appendChild(p2)
            wraps.appendChild(p3)
            wraps.appendChild(p4)
            wraps.appendChild(div1)
            wraps.appendChild(span2)
            wraps.setAttribute("id", list[i].bookID);
            wraps.addEventListener("click", showDetail);
            $("#allBooks")[0].appendChild(wraps);
        }
    }
}

$("#find").click(function () {
    var keyWords = $("#search")[0].value;
    if (keyWords !== '') {
        $.ajax({
            url: baseUrl + "search",
            type: 'post',
            data:{
                "ISBN": keyWords
            },
            dataType: 'json',
            success: function (data) {
                showResult(data.book)
            }
        })
    } else {
        initBooks()
    }

})

function showResult(list) {
    console.log(list)
    $("#allBooks")[0].innerHTML = '';
    var wraps = document.createElement("div");
	wraps.className = 'item';
	for (var i in list) {
		if (i !== "bookID") {
		var p0 = document.createElement("p");
		wraps.appendChild(p0)
		p0.innerHTML = i + ':' + list[i];
		wraps.setAttribute("id", list[i]);
		
		} else {
			var div1 = document.createElement("div");
			var span1 = document.createElement("span");
			var span2 = document.createElement("span");
			span1.id = "count";
			span1.innerHTML = "1";
		}
	}
		wraps.addEventListener("click", showDetail);
		$("#allBooks")[0].appendChild(wraps);
}

function showDetail() {
    var e = e || window.event;
    console.log($(e.target).parent()[0].id)
    window.location.href = "bookDetail.html?bookId=" + $(e.target).parent()[0].id;
}

function saveData(data) {
    var listData = localStorage.getItem("shopProducts");
    if (!listData) {
        localStorage.setItem("shopProducts", data);
    }
}
var products = [];

function shop(i, id) {
    console.log(i, id)
    this.event.stopPropagation();
    var total = 0;
    //加入购物车的时候 需要当前bookId,数目
    var count = parseInt(document.getElementById('count' + i).innerHTML);
    console.log(count)
    var product = {
        "bookId": id,
        "count": count
    };
    var isExsit = products.some((item) => {
        return item.bookId == product.bookId
    })
    if (products.length < 1 || !isExsit) {
        products.push(product);
    } else {
        products.forEach((item) => {
            if (item.bookId == product.bookId) {
                item.count = product.count;
                return;
            }
        })
    }
    console.log(products)
    console.log(JSON.stringify(products))
    saveData(JSON.stringify(products));
    products.forEach((item) => {
        total += parseInt(item.count);
    })
    if (total !== 0) {
        $("#dot")[0].style.display = "inline-block";
        $("#dot")[0].innerHTML = total;
    } else {
        $("#dot")[0].style.display = "none";
    }
}

function less(i) {
    this.event.stopPropagation();
    var count = document.getElementById('count' + i);
    var num = parseInt(count.innerHTML);
    num--;
    count.innerHTML = num;
    if (num == 0) return;
    return false;
}

function add(i) {
    this.event.stopPropagation();
    var count = document.getElementById('count' + i);
    var num = parseInt(count.innerHTML);
    if (num >= 100) return;
    num++;
    count.innerHTML = num;
    return false;
}

//code for bookDetail
function initDetail() {
    var bookId = location.search.split("=")[1];
    $.ajax({
        url: baseUrl + "bookDetail",
        type: 'get',
        dataType: 'json',
        data: {
            "id": bookId
        },
        success: function (data) {
            console.log(data)
            if (data.code == "1") {
                var list = data.book;
                $("#bookName")[0].innerHTML = list.bookName;
                $("#authorName")[0].innerHTML = list.authorName;
                $("#iSBN")[0].innerHTML = list.iSBN;
                $("#publisher")[0].innerHTML = list.publisher;
                $("#genre")[0].innerHTML = list.genre;
                $("#price")[0].innerHTML = list.price;
                $("#pages")[0].innerHTML = list.pages;
            }
        }
    })
}

function showHighLight() {
    var tableEle = document.getElementsByTagName("tr");
    for (var i = 0; i < tableEle.length; i++) {
        console.log(tableEle[i])
        if (i % 2 == 0) {
            tableEle[i].className = "greyLine";
        }
    }
}
$("#backHome").click(function () {
    window.location.href = "home.html";
})
//code for cart  
function initCart() {
    //从缓存中取出用户ID和加入购物车的信息
    //此处用户ID 为 localStorage.getItem("currentUser")，可以打印出来查看
    console.log(localStorage.getItem("currentUser"));
    var userId = JSON.parse(localStorage.getItem("currentUser"));
    //var userId = 1;
    //这是取当前加入购物车的信息
    var products = JSON.parse(localStorage.getItem("shopProducts"));
    console.log(products);
    if (products !== null) {
        //products = [{bookId: 3 count: 1}]
        //遍历Products,根据Id找到书籍信息
        var cartProducts = [];
        products.forEach((item) => {
            console.log(item.bookId)
            if (item.count != 0) {
                $.ajax({
                    url: baseUrl + "bookDetail",
                    type: 'get',
                    dataType: 'json',
                    async: false,
                    data: {
                        "id": item.bookId
                    },
                    success: function (data) {
                        console.log(data.book);
                        data.book['count'] = item.count;
                        cartProducts.push(data.book)
                    }
                })
            }
        })
        console.log(cartProducts)
        showCart(cartProducts)
    }
}

function showCart(list) {
    var total = 0;
    if (list.length > 0) {
        for (var i = 0; i < list.length; i++) {
            var wraps = document.createElement("tr");
            wraps.className = 'item';
            var td0 = document.createElement("td");
            var td1 = document.createElement("td");
            var td2 = document.createElement("td");
            var td3 = document.createElement("td");
            td0.innerHTML = list[i].bookName;
            td1.innerHTML = list[i].count;
            td2.innerHTML = "$" + list[i].price;
            td3.innerHTML = "$" + list[i].price * list[i].count;
            total += list[i].price * list[i].count;
            wraps.appendChild(td0)
            wraps.appendChild(td1)
            wraps.appendChild(td2)
            wraps.appendChild(td3)
            wraps.setAttribute("id", list[i].id);
            $("#cartContent")[0].appendChild(wraps);
        }
        var p = document.createElement("p");
        p.innerHTML = "The total price is:$" + total;
        $("#cartContent")[0].appendChild(p)
    }
}
$("#settle").click(function () {
    //从缓存中取出用户ID和加入购物车的信息
    var userId = JSON.parse(localStorage.getItem("currentUser"));
    var products = JSON.parse(localStorage.getItem("shopProducts"));
    console.log(products);
    if(products){
        $.ajax({
            url: "http://localhost:8080/bookStore/order_addShop",
            type: 'post',
            dataType: 'json',
           // console.log(products),
            data: {
                "id": userId,
              //  "bookData": products
                "bookId": products[0].bookId,
                "count": products[0].count
            },
            success: function (data) {
                if (data.code == "1") {
                    //订单提交成功，页面跳入订单展示页面
                    window.location.href = "order.html"
                }
            }
        })
    }else{
        window.location.href = "home.html";
    }
  
})
//code for order
function initOrder() {
    var userId = "1";
    $.ajax({
        url: "http://localhost:8080/bookStore/order_order",
        type: 'post',
        dataType: 'json',
        data: {
            "id": userId //待商定
        },
        success: function (data) {
            if (data.code == "1") {
                var list = data.list;
                console.log(list)
                showOrder(list)
            }
        }
    })
}

function showOrder(list) {
    var total = 0;
    if (list.length > 0) {
        for (var i = 0; i < list.length; i++) {
            var wraps = document.createElement("tr");
            wraps.className = 'item';
            var td0 = document.createElement("td");
            var td1 = document.createElement("td");
            var td2 = document.createElement("td");
            td0.innerHTML = list[i].orderNumber;
            td1.innerHTML = "$" + list[i].price;
            td2.innerHTML = list[i].orderDate;
            total += list[i].price * list[i].num;
            wraps.appendChild(td0)
            wraps.appendChild(td1)
            wraps.appendChild(td2)
            wraps.setAttribute("id", list[i].id);
            $("#cartContent")[0].appendChild(wraps);
        }
    }
}

$("#findOrder").click(function () {
	var orderNumber = $("#orderNumber")[0].value;
	if (orderNumber !== '') {
	window.location.href = "logistics.html?orderNumber=" + orderNumber;
	} else {
	initBooks()
	}

})
//code for logistics
function initLog() {
    var orderNumber = location.search.split("=")[1];
    $.ajax({
        url: "http://localhost:8080/bookStore/order_orderNumber",
        type: 'post',
        dataType: 'json',
        data: {
            "id": orderNumber
        },
        success: function (data) {
            if (data.code == "1") {
                console.log(data)
                showLog(data, orderNumber)
            }
        }
    })
}

function showLog(list, orderNumber) {
	var total = 0;
	if (list) {
	$("#orderNumber")[0].innerHTML = orderNumber;
	var wraps = document.createElement("tr");
	wraps.className = 'item';
	var td0 = document.createElement("td");
	var td1 = document.createElement("td");
	td0.innerHTML = list.orderDate;
	td1.innerHTML = list.location;
	wraps.appendChild(td0)
	wraps.appendChild(td1)
	$("#logContent")[0].appendChild(wraps);
	}
}
