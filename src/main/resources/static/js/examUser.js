/**
 * Created by langshiquan on 17/9/17.
 */

function init() {
    $.ajax({
        type: "GET",
        url: "/exam/getExamOrPaperForUser",
        success: function (data) {
            var papers = eval("(" + data + ")");
            for (var i = 0; i < papers.length; i++) {

            }


        }
    });
}
