<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>User Management System</title>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="js/listUser.js"></script>
<link rel="stylesheet" href="css/listUsers.css">
</head>
<body>
<h1>User Management System</h1>
<div class="wrapper">
<div class ="profile"> 

<table id="userdata" border="2">
        <thead>
            <tr>
                <th>User Id</th>
                <th>First Name</th>
                <th>Middle Name</th>
                <th>Last Name</th>
                <th>Age</th>
                <th>Gender</th>
                <th>Phone</th>
                <th>Zip Code</th>
                
            </tr>
        </thead>
        
        <tbody>

        </tbody>
    </table>
   </div>

   </div>
   
          <div id = "newdiv">

    <a class="button" href="users.jsp">Add User</a>        
    
   		 </div> 
                  
    


</body>
</html>