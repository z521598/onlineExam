/**
 * Created by langshiquan on 17/9/17.
 */
function getUserInfo() {
    $.ajax({
        type: "GET",
        url: "/user/getUser",
        success: function (data) {
            console.log(data);
            var user = eval("(" + data + ")");
            $("#username").val(user.username);
            $("#id").val(user.id);
            $("#password").val(user.password);
            $("#name").val(user.name);
            $("#birthday").val(formatDate(user.birthday));
            $("#idCard").val(user.idCard);
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