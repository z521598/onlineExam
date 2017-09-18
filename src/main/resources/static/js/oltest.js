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
//            console.log(paper[0]);
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
                div1.className = "title";
                div2.className = "mark";
                div3.className = "answer";
                div4.className = "exercise";
                div1.innerText = "题目：";
                div2.innerText = "分数：";
                label.innerText = "答案：";
                div3.type = "text";
                div4.appendChild(div1);
                div4.appendChild(div2);
                div4.appendChild(label);
                div4.appendChild(div3);
                papers.appendChild(div4);
            }
            var div5 = document.createElement("input");
            div5.value = "交卷";
            div5.type = "submit";
            papers.appendChild(div5);
            var titles = document.querySelectorAll(".title");
            var answer = document.querySelectorAll(".answer");
            var mark = document.querySelectorAll(".mark");
            for (j = 0; j < questions.length; j++) {
                titles[j].innerText += questions[j].question;
                mark[j].innerText += questions[j].mark;
            }
        }
    });
}
//交卷
//$("#subPaper").click(function(){
//   var paper = {};
//   var exercise = document.querySelectorAll(".exercise");
//   var title = $('#head').val();
//   var author = $('#author').val();
//   var questions = [];
//   for (i = 0; i < exercise.length; i++) {
//       var question = {};
//       var a = exercise[i];
//       question.question = $exercise[i].innerText.split(":")[1];;
//       question.answer = $exercise[i].innerText.split(":")[1];;
//       question.mark = $exercise[i].innerText.split(":")[1];;
//       questions.push(question);
//   }
//   ;
//   paper.title = title;
//   paper.author = author;
//   paper.questions = questions;
////    console.log(paper);
//   $.ajax({
//       type: "post",
//       url: "/paper",
//       dataType: "json",
//       data: JSON.stringify(paper),
//       headers: {'Content-Type': 'application/json'},
//       success: function (res) {
//           if (res.success) {
//               alert("保存成功");
//           } else {
//               alert("保存失败，报错信息：" + res.message);
//           }
//       }
//   });
//});