function myFunction() {
    var x = document.getElementById("username").value;
    document.getElementById("usernameResult").innerHTML = x;

    var formData = {
        username : $("#username").val()
    }

    $.ajax({
        type : "POST",
        contentType : "application/json",
        url : "mobile/rest/checkUsernameInRegistration",
        data : JSON.stringify(formData),
        dataType: 'json',
        success : function(result) {
            if(result.data == "true") {
                $("#usernameInDataBase").html("<strong>TRUE</strong>");
            } else if(result.data == "false") {
                $("#usernameInDataBase").html("<strong>FALSE</strong>");
            } else {
                $("#usernameInDataBase").html("<strong>Error</strong>");
            }
            console.log(result);

        },
        error : function(e) {
            alert("Error!")
            console.log("ERROR: ", e);
        }
    });

}