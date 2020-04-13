const baseUrl = "http://localhost:8080/bookStore/book_";

var tdWrap = document.getElementById('bookData')

function initAdmin() {
    $.ajax({
        url: baseUrl + "allBooks",
        type: "get",
        dataType: "json",
        success: function (res) {
            buildData(res.list)
        }
    })
}

function buildData(list) {
    console.log(list);
    tdWrap.innerHTML = '';
    if (list.length > 0) {
        for (var i = 0; i < list.length; i++) {
            var trs = document.createElement("tr");
            var td0 = document.createElement("td");
            var td1 = document.createElement("td");
            var td2 = document.createElement("td");
            var td3 = document.createElement("td");
            var td4 = document.createElement("td");
            var td5 = document.createElement("td");
            var td6 = document.createElement("td");
            td0.innerHTML = list[i].bookID;
            td1.innerHTML = list[i].bookName;
            td2.innerHTML = list[i].authorName;
            td3.innerHTML = list[i].iSBN;
            td4.innerHTML = list[i].genre;
            td5.innerHTML = list[i].number;
            td6.innerHTML = '<a class="btn-xsg layui-bg-red" onclick="del(' + list[i].bookID + ')">delete</a>'
            trs.appendChild(td0)
            trs.appendChild(td1)
            trs.appendChild(td2)
            trs.appendChild(td3)
            trs.appendChild(td4)
            trs.appendChild(td5)
            trs.appendChild(td6)
            tdWrap.appendChild(trs)
        }
    } else {
        tdWrap.innerHTML = 'No Result';
    }
}

function del(delId) {
    console.log(delId)
    $.ajax({
        url: baseUrl + "deleteBook",
        type: "post",
        data: {
         	"id" : delId
        },
        success: function (res) {
            $.ajax({
                url: baseUrl + "allBooks",
                type: "get",
                dataType: 'json',
                success: function (res) {
                    buildData(res.list)
                }
            })
        }
    })
}

function preDeal(){
    var e =e || window.event;
    var reg= /^[0-9]*$/;
    if( reg.test(e.target.value)  || e.target.value < 10){
        e.target.value = e.target.value.replace(e.target.value,'');
    }
}
layui.use('form', function () {
    var form = layui.form;
    form.on('submit(formBook)', function (data) {
        console.log(data.field)
        $.ajax({
            url: baseUrl + "addBook",
            type: 'post',
            dataType: 'json',
            data: data.field,
            success: function (res) {
                console.log(res)
                console.log(res.code)
                if (res.code == "1") {
                    window.location.href = "bookManage.html"
                }
            }
        })
        return false;
    });
});
//code for report
function initReport() {
    $.ajax({
        url: baseUrl + "genre",
        type: 'get',
        dataType: 'json',
        success: function (data) {
            if (data.code == "1") {
                var list = data.list;
                showReport(list,"genreName")
            }
        }
    })
    $.ajax({
        url: baseUrl + "author",
        type: 'get',
        dataType: 'json',
        success: function (data) {
            if (data.code == "1") {
                var list = data.list;
                console.log(list)
                showReport(list,"authorName")
            }
        }
    })
}

function showReport(list,ids) {
    var total = 0;
    if (list.length > 0) {
        for (var i = 0; i < list.length; i++) {
            var wraps = document.createElement("tr");
            wraps.className = 'item';
            var td0 = document.createElement("td");
            var td1 = document.createElement("td");
            td0.innerHTML = list[i][ids];
            td1.innerHTML = list[i].number;
            wraps.appendChild(td0)
            wraps.appendChild(td1)
            $("#"+ids)[0].appendChild(wraps);
        }
    }
}
//code for expenditures
function fillReport(){
    $.ajax({
        url: baseUrl + "expense",
        type: 'get',
        dataType: 'json',
        success: function (data) {
            if (data.code == "1") {
                var list = data.list;
                console.log(list)
                timeLine(list)
            }
        }
    })
}

function timeLine(list){
    var wrap = $("#fillData");
    list.forEach(item=>{
        var ali =document.createElement("li");
        ali.className = "layui-timeline-item";
        var icon =document.createElement("i");
        icon.className="layui-icon layui-timeline-axis";
        icon.innerHTML = "&#xe63f;";
        var adiv =  document.createElement("div");
        adiv.className ="layui-timeline-content layui-text";
        var ah3=document.createElement("h3");
        ah3.className = "layui-timeline-title";
        ah3.innerHTML = "publisher:"+item.publisher;
        var ap=document.createElement("p");
        ap.innerHTML = "expenditures: $"+item.price;
        adiv.appendChild(ah3)
        adiv.appendChild(ap)
        ali.appendChild(icon)
        ali.appendChild(adiv)
        wrap[0].appendChild(ali)
    })
  
}