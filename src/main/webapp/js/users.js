

function validate(evt) {
	  var theEvent = evt || window.event;
	  var key = theEvent.keyCode || theEvent.which;
	  key = String.fromCharCode( key );
	  var regex = /[0-9]|\./;
	  if( !regex.test(key) ) {
	    theEvent.returnValue = false;
	    if(theEvent.preventDefault) theEvent.preventDefault();
	  }
	}

    $(document).ready(function() {

    	$(function(){
    	    var $select = $(".dropdwn");
    	    for (i=1;i<=100;i++){
    	        $select.append($('<option></option>').val(i).html(i))
    	    }
    	});
    	
		$('.form-validation').submit(function(e) {
			var frm = $('.form-validation');
			e.preventDefault();

		    var data = {}
		    var Form = this;

		    //Gather Data also remove undefined keys(buttons)
		    $.each(this, function(i, v){
		            var input = $(v);
		            var count = 0;
		        if(input.attr("name") != "gender"){
		        data[input.attr("name")] = input.val();
		        		}
		        else{
		        	if(count == 0){
		        	data["gender"] = $('input[name=gender]:checked', '.form-validation').val();
		        	count ++;}
		        	
		        }
		        delete data["undefined"];
		        
		    });
		    
		   
		    
    	
        $.ajax({
            beforeSend: function (xhr){ 
            	  xhr.setRequestHeader("Content-Type","application/json; charset=utf-8");
                  xhr.setRequestHeader("Accept","application/json");
              },
            contentType : 'application/json; charset=utf-8',
            type: frm.attr('method'),
            url: frm.attr('action'),
            dataType : 'json',
            data : JSON.stringify(data),
            success : function(callback){
            	
            	window.location = "users.jsp";
            	alert("success");
                $(this).html("User Added");
                
            },
            error : function(callback){
            	console.log(callback);
                $(this).html("Error!");
            }
        });
 });
		
    });
    	
    
    
    
    
	$('.form-validation').keyup(function(e) {

        var errorField = $('.form-input-firstName-row');
        var error = $('#firstName').val();
        
		if(error == "")	{
	
        errorField.addClass('form-invalid-data');
        errorField.find('.form-invalid-data-info').text('Please enter your name');
		}

		else {
			
        var successField = $('.form-input-firstName-row');

        successField.addClass('form-valid-data');
        
		}
        
    	});