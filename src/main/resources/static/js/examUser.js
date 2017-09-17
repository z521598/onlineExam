/**
 * Created by langshiquan on 17/9/17.
 */

function init() {
    $.ajax({
        type: "GET",
        url: "/exam/getExamOrPaperForUser",
        success: function (data) {
            var papers = eval("(" + data + ")");
            console.log(papers);
            for (var i = 0; i < papers.length; i++) {
                var tr = document.createElement("tr");
                var td1 = document.createElement("td");
                var td2 = document.createElement("td");
                var td3 = document.createElement("td");
                var td4 = document.createElement("td");
                var td5 = document.createElement("td");
                var title = papers[i].title;
                var totalMark = papers[i].totalMark;
                var examStatus = papers[i].examStatus;
                if(examStatus === "NO"){
                    var realMark = 0;
                    var status = "未完成";
                }else{
                    var realMark = "xxx";
                    var status = "已完成";
                }
                td1.innerText = title;
                td2.innerText = totalMark;
                td3.innerText = realMark;
                td4.innerText = status;
                tr.appendChild(td1);
                tr.appendChild(td2);
                tr.appendChild(td3);
                tr.appendChild(td4);
                tr.appendChild(td5);
                var userTable = document.getElementById("userTable");
                userTable.appendChild(tr);
            }


        }
    });
}
