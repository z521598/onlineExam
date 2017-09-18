/**
 * Created by langshiquan on 17/9/17.
 */
function init() {
    var id = UrlParm.parm("id");
    $.ajax({
        type: "GET",
        url: "/paper/" + id,
        success: function (data) {
            var paper = eval("(" + data + ")");
//            console.log(paper[0].title)
            var head = document.getElementById("head");
            var author = document.getElementById("author");
            var papers = document.getElementById("paper");
//            console.log(paper[0].questions);
            var questions = paper[0].questions;
            head.innerText = paper[0].title;
            author.innerText += paper[0].author;
            for (i = 0; i < questions.length - 1; i++) {
                var div1 = document.createElement("div");
                var div2 = document.createElement("div");
                var div3 = document.createElement("div");
                var div4 = document.createElement("div");
                div1.className = "title";
                div2.className = "answer";
                div3.className = "mark";
                div4.className = "exercise";
                div1.innerText = "题目：";
                div2.innerText = "答案：";
                div3.innerText = "分数：";
                div4.appendChild(div1);
                div4.appendChild(div2);
                div4.appendChild(div3);
                papers.appendChild(div4);
            }
            var titles = document.querySelectorAll(".title");
            var answer = document.querySelectorAll(".answer");
            var mark = document.querySelectorAll(".mark");
            for (j = 0; j < questions.length; j++) {
                console.log(questions[j]);
                titles[j].innerText += questions[j].question;
                answer[j].innerText += questions[j].answer;
                mark[j].innerText += questions[j].mark;
            }
        }
    });
}