//请求用户信息
//ajax('get','/user/0',null);
function getUserInfo(method, url, data) {
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4) {
            if ((xhr.status >= 200 && xhr.status < 300 ) || xhr.status == 304) {
                var a = JSON.parse(xhr.responseText);
                console.log(a);
                for (i = 0; i < a.length; i++) {
                    appendUser(a[i]);
                }

            } else {
                alert('请求失败');
                console.log(xhr.status);
            }
        }
    }
    //创建请求
    xhr.open(method, url, true);
    //发送请求
    xhr.send(data);
    // xhr.responseText;//响应文本
}
//向表格中添加用户
function appendUser(data) {
    var tr = document.createElement("tr");
    var td1 = document.createElement("td");
    var td2 = document.createElement("td");
    var td3 = document.createElement("td");
    var td4 = document.createElement("td");
    var td5 = document.createElement("td");
    var td6 = document.createElement("td");
    td1.innerHTML = data.username;
    td2.innerHTML = data.name;
    td3.innerHTML = data.sex;
    td4.innerHTML = data.idCard;
    td5.innerHTML = formatDate(data.birthday);
    td6.innerHTML = '<input type = "button" value="删除" onclick="deleteUser('+data.id+')"/>';
    tr.appendChild(td1);
    tr.appendChild(td2);
    tr.appendChild(td3);
    tr.appendChild(td4);
    tr.appendChild(td5);
    tr.appendChild(td6)
    $(".userTable").append(tr);
}
function formatDate(date) {
    var d = new Date(date),
        month = '' + (d.getMonth() + 1),
        day = '' + d.getDate(),
        year = d.getFullYear();

    if (month.length < 2) month = "0" + month;
    if (day.length < 2) day = "0" + day;

    return [year, month, day].join("-");
}

function deleteUser(id) {
    $.ajax({
    		type:"DELETE",
    		url:"/user/"+id,
    		success:function(data){
    			window.location.reload();
    		}
    });
}