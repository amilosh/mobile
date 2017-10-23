$( document ).ready(function() {


	
	// SUBMIT FORM
    $("#customerForm").submit(function(event) {
		// Prevent the form from submitting via the browser.
		event.preventDefault();
		ajaxPost();
	});
    
    
    function ajaxPost(){
    	
    	// PREPARE FORM DATA
    	var formData = {
            username : $("#username").val()
    	}
    	
    	// DO POST
    	$.ajax({
			type : "POST",
			contentType : "application/json",
			url : "${pageContext.request.contextPath}" + "/api/customer/save",
			data : JSON.stringify(formData),
			dataType : 'json',
			success : function(result) {
				if(result.status == "Done"){
					$("#postResultDiv").html("<p style='background-color:#7FA7B0; color:white; padding:20px 20px 20px 20px'>" + 
												"Post Successfully! <br>" +
												"---> Customer's Info: username = " + result.data.username);
				}else{
					$("#postResultDiv").html("<strong>Error</strong>");
				}
				console.log(result);
			},
			error : function(e) {
				alert("Error!")
				console.log("ERROR: ", e);
			}
		});
    	
    	// Reset FormData after Posting
    	resetData();

    }
    
    function resetData(){
    	$("#username").val("");
    }
})

function myFunction() {
    var x = document.getElementById("username").value;
    document.getElementById("demo").innerHTML = "You wrote: " + x;

    // PREPARE FORM DATA
    var formData = {
        username : $("#username").val()
    }

    // DO POST
    $.ajax({
        type : "POST",
        contentType : "application/json",
        //url : window.location + "api/customer/save",
        //url : '${pageContext.request.contextPath}' + "/api/customer/save",
        url : "http://localhost:8080/api/customer/save",
        data : JSON.stringify(formData),
        dataType : 'json',
        success : function(result) {
            if(result.status == "Done"){
                $("#postResultDiv").html("<p style='background-color:#7FA7B0; color:white; padding:20px 20px 20px 20px'>" +
                "Post Successfully! <br>" +
                "---> Customer's Info: username = " + result.data.username);
            }else{
                $("#postResultDiv").html("<strong>Error</strong>");
            }
            console.log(result);
        },
        error : function(e) {
            alert("Error!");
            console.log("ERROR: ", e);
        }
    });

}