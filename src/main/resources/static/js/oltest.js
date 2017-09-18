/**
 * Created by langshiquan on 17/9/17.
 */
 //显示未完成试卷
function unComplete() {
    var id = UrlParm.parm("id");
    console.log(id);
    $.ajax({
        type: "GET",
        url: "/paper/" + id,
        success: function (data) {
            var paper = eval("(" + data + ")");
            console.log(paper[0]);
            var head = document.getElementById("head");
            var postExam = document.getElementById("postExam");
            var author = document.getElementById("author");
            var papers = document.getElementById("paper");
//            console.log(paper[0].questions);
            var questions = paper[0].questions;
            head.innerText = paper[0].title;
            author.innerText += paper[0].author;
            for (i = 0; i < questions.length - 1; i++) {
                var div1 = document.createElement("div");
                var div2 = document.createElement("div");
                var label = document.createElement("label");
                var div3 = document.createElement("input");
                var div4 = document.createElement("div");
                var div5 = document.createElement("input");
                div1.className = "title";
                div2.className = "mark";
                div3.className = "answer";
                div4.className = "exercise";
                div1.innerText = "题目：";
                div2.innerText = "分数：";
                label.innerText = "答案：";
                div5.value = "交卷";
                div3.type = "text";
                div5.type = "submit";
                div4.appendChild(div1);
                div4.appendChild(div2);
                div4.appendChild(label);
                div4.appendChild(div3);
                papers.appendChild(div4);
                papers.appendChild(div5);
            }
            var titles = document.querySelectorAll(".title");
            var answer = document.querySelectorAll(".answer");
            var mark = document.querySelectorAll(".mark");
            for (j = 0; j < questions.length; j++) {
//                console.log(questions[j]);
                titles[j].innerText += questions[j].question;
//                answer[j].innerText += questions[j].answer;
                mark[j].innerText += questions[j].mark;
            }
        }
    });
}