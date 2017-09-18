/**
 * Created by langshiquan on 17/9/18.
 */
function init() {
    $.ajax({
        type: "GET",
        url: "/exam/0",
        success: function (data) {
            var exams = eval("(" + data + ")");
            console.log(exams);
            for (var i = 0; i < exams.length; i++) {
                var tr = document.createElement("tr");
                var td1 = document.createElement("td");
                var td2 = document.createElement("td");
                var td3 = document.createElement("td");
                var td4 = document.createElement("td");
                var title = exams[i].paper.title;
                var totalMark = exams[i].paper.totalMark;
                var realTotalMark = exams[i].totalMark;
                var userName = exams[i].name;
                td1.innerText = title;
                td2.innerText = totalMark;
                td3.innerText = realTotalMark;
                td4.innerText = userName;
                tr.appendChild(td1);
                tr.appendChild(td2);
                tr.appendChild(td3);
                tr.appendChild(td4)
                var examTable = document.getElementById("examTable");
                examTable.appendChild(tr);
            }


        }
    });
}
