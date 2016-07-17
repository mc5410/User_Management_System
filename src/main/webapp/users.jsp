<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="css/form-validation.css">
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css">
<title>Add new user</title>
</head>
<body>
<form class="form-validation" method="post" action="api/users/">

            <div class="form-title-row">
                <h1>Add a User</h1>
            </div>

            <div class="form-row form-input-firstName-row">

                <label>
                    <span>First Name</span>
                    <input id="firstName" type="text" name="firstName">
                </label>

                <span class="form-valid-data-sign"><i class="fa fa-check"></i></span>

                <span class="form-invalid-data-sign"><i class="fa fa-close"></i></span>
                <span class="form-invalid-data-info"></span>

            </div>
            
                        <div class="form-row form-input-middleName-row">

                <label>
                    <span>Middle Name</span>
                    <input type="text" name="middleName">
                </label>

            </div>
            
                        <div class="form-row form-input-lastName-row">

                <label>
                    <span>Last Name</span>
                    <input type="text" name="lastName">
                </label>

                <span class="form-valid-data-sign"><i class="fa fa-check"></i></span>

                <span class="form-invalid-data-sign"><i class="fa fa-close"></i></span>
                <span class="form-invalid-data-info"></span>

            </div>


            <div class="form-row">

                <label>
                    <span>Age</span>
                    <select class ="dropdwn" name="age">
                        <option>Choose an option</option>
                    </select>
                </label>

            </div>

            <div class="form-row">

                <label class="form-checkbox">
                    <span>Gender</span>
                    <input type="Radio" name="gender" value="M" > M
                    <input type="Radio" name="gender" value="F"> F
                </label>

            </div>
            
            <div class="form-row">
            
			<label>
                    <span>Phone Number</span>
			<input type='tel' name = "phone" pattern='\d{10}' title='Phone Number (Format: 9999999999)'> 
			
			</label>
			
			</div>
			
            <div class="form-row">

                <label>
                    <span>Zip Code</span>
                    <input type="text" onkeypress='validate(event)' name="zipcode">
                </label>

            </div>
			
			
            <div class="form-row">

                <button type="submit">Submit</button>
                
          <a class="button" href="listUser.jsp">User List</a>

            </div>

        </form>




<script src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="js/users.js"></script>

</body>
</html>