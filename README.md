# User_Management_System

## A Restful web service for User Management Application
----
	* Spring MVC to expose services
	* HSQLDB - [info] (http://hsqldb.org/ and http://hsqldb.org/doc/2.0/guide/guide.pdf as your in-memory database)
	* Hibernate as ORM
----
## Assumptions
		
 *User has the following properties
	*	id (UUID)
	*	firstName (alphabets)
	*	middleName (alphabets but it is optional)
	*	lastName (alphabets)
	*	age (valid non zero positive number)
	*	gender (M or F)
	*	phone (10-digit positive number)
	*	zip (optional field)
	
 *The User's ID uniquely identifies a user.
 ----
## Services
 
 	1. **createUser** : POST /api/users/
 	2. **getAllUsers** : GET /api/users/
 	3. **findUserById** : GET /api/users/{id}
 	4. **updateUser** : PUT /api/users/{id}
 	5. **deleteUser** : DELETE /api/users/{id}
 	
 	These are the services provided by the REST API. 
 	
 	These services can be used from POSTMAN or else I've only had time to make
 	the front-end for the services addUser, getAllUsers using JQuery and AJAX in
 	Java Server Page.
 
 

	


