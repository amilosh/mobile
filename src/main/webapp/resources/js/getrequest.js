$( document ).ready(function() {
	
	// GET REQUEST
	$("#getAllCustomerId").click(function(event){
		event.preventDefault();
		ajaxGet();
	});
	
	// DO GET
	function ajaxGet(){
		$.ajax({
			type : "GET",
			url : window.location + "api/customer/all",
			success: function(result){
				if(result.status == "Done"){
					$('#getResultDiv ul').empty();
					var custList = "";
					$.each(result.data, function(i, user){
						var user = "- User with Id = " + i + ", username = " + user.username + "<br>";
						$('#getResultDiv .list-group').append(user)
			        });
					console.log("Success: ", result);
				}else{
					$("#getResultDiv").html("<strong>Error</strong>");
					console.log("Fail: ", result);
				}
			},
			error : function(e) {
				$("#getResultDiv").html("<strong>Error</strong>");
				console.log("ERROR: ", e);
			}
		});	
	}
})