var i =0;
$(".add").click(function(){
    var newPapers = '<div id="div'+i+'"><label>题目：</label><input type="text" name="paperTit"/><label>答案：</label><input type="text" name="answer"/> <label>分数：</label><input type="text" name="mark"/>   <input type="button" value="删除" class="delete" onclick="deletePaper('+i+')"><br></div>';
    $(".papers").append(newPapers);
    i++;
});
function deletePaper(id){
    $("#div"+id).remove();
}
//保存试卷
$("#savePapers").click(function(){
    var paper = {};
    var title = $('input[name="title"]').val();
    var author = $('input[name="author"]').val();
    var questions = [];
    for(i=0;i<$('input[name="paperTit"]').length;i++){
        var question = {};
        var a = $('input[name="paperTit"]')[i];
        console.log(typeof a);
        question.question =  $('input[name="paperTit"]')[i].value;
        question.answer =  $('input[name="answer"]')[i].value;
        question.mark =  $('input[name="mark"]')[i].value;
        questions.push(question);
    };
    paper.title = title;
    paper.author = author;
    paper.questions = questions;
//    console.log(paper);
   $.ajax({
   		type:"post",
   		url:"/paper",
   		dataType: "json",
        data: JSON.stringify(paper),
        headers: {'Content-Type': 'application/json'},
   		success:function(res){
   		    if(res.success){
   		        alert("保存成功");
   		    }else{
   		        alert("保存失败，报错信息："+ res.message);
   		    }
   		}
   	});
});
//点击试卷管理
//function getPaperInfo(){
//     $.ajax({
//           		type:"get",
//           		url:"/paper/0",
//           		dataType: "json",
//                headers: {'Content-Type': 'application/json'},
//           		success:function(data){
//           		   var a = JSON.parse(xhr.responseText);
//                   for (i = 0; i < a.length; i++) {
//                       listPaper(a[i]);
//                   }
//           		}
//         });
//}
function getPaperInfo(method, url, data) {
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4) {
            if ((xhr.status >= 200 && xhr.status < 300 ) || xhr.status == 304) {
                var a = JSON.parse(xhr.responseText);
//                console.log(a);
                for (i = 0; i < a.length; i++) {
                    listPaper(a[i]);
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
function listPaper(data){
        var tr = document.createElement("tr");
        var td1 = document.createElement("td");
        var td2 = document.createElement("td");
        var td3 = document.createElement("td");
        var td4 = document.createElement("td");
        td1.innerHTML = data.paperId;
        td2.innerHTML = data.title;
        td3.innerHTML = data.author;
        td4.innerHTML = '<input type = "button" value="删除" onclick="deletePaper('+data.paperId+')"/>';
        tr.appendChild(td1);
        tr.appendChild(td2);
        tr.appendChild(td3);
        tr.appendChild(td4);
        $(".tableList").append(tr);
}
//删除试卷
function deletePaper(id) {
    $.ajax({
    		type:"DELETE",
    		url:"/paper/"+id,
    		success:function(data){
    			window.location.reload();
    		}
    });
}
