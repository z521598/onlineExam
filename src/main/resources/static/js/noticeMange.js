/**
 * Created by langshiquan on 17/9/18.
 */
function init(method, url, data) {
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4) {
            if ((xhr.status >= 200 && xhr.status < 300 ) || xhr.status == 304) {
                var a = JSON.parse(xhr.responseText);
                for (i = 0; i < a.length; i++) {
                    appendNotice(a[i]);
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

//向表格中添加通知
function appendNotice(data) {
    var tr = document.createElement("tr");
    var td1 = document.createElement("td");
    var td2 = document.createElement("td");
    var td3 = document.createElement("td");
    td1.innerHTML = data.content;
    td2.innerHTML = formatDate(data.endTime);
    td3.innerHTML = '<input type = "button" value="删除" onclick="deleteNotice(' + data.id + ')"/>';
    tr.appendChild(td1);
    tr.appendChild(td2);
    tr.appendChild(td3);
    $(".noticeTable").append(tr);
}

//向表格中添加通知
function appendNoticeForUser(data) {
    var tr = document.createElement("tr");
    var td1 = document.createElement("td");
    td1.innerHTML = data.content;
    tr.appendChild(td1);
    $(".noticeTable").append(tr);
}
function deleteNotice(id) {
    $.ajax({
        type: "DELETE",
        url: "/notice/" + id,
        success: function (data) {
            window.location.reload();
        }
    });

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

function userHomeNotice(method, url, data) {
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4) {
            if ((xhr.status >= 200 && xhr.status < 300 ) || xhr.status == 304) {
                var a = JSON.parse(xhr.responseText);
                for (i = 0; i < a.length; i++) {
                    appendNoticeForUser(a[i]);
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