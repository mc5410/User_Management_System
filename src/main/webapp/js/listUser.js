
$(document).ready(function() {
    
		$.ajax({
		type: "GET",
		url: "api/users/",
		contentType:"application/json; charset=utf-8",
		dataType:"json",
		success: function(data){ 
		        if(data){
		            var len = data.length;
		            var txt = "";
		            if(len > 0){
		                for(var i=0;i<len;i++){
		                    
		                        txt += "<tr><td>"+data[i].id+"</td><td>"+data[i].firstName+"</td><td>"+data[i].middleName+"</td><td>"+data[i].lastName+"</td><td>"+data[i].age+"</td><td>"+data[i].gender+"</td><td>"+data[i].phone+"</td><td>"+data[i].zipcode+"</td></tr>";
		                    
		                }
		                if(txt != ""){
		                    $("#userdata").append(txt).removeClass("hidden");
		                }
		            }
		        }
		    },
		    error: function(jqXHR, textStatus, errorThrown){
		        alert('error: ' + textStatus + ': ' + errorThrown);
		    }
		});
		return false;
		
});