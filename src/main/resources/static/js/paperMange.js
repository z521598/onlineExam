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