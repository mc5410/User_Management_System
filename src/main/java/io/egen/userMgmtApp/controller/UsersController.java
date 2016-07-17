package io.egen.userMgmtApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.egen.userMgmtApp.service.UsersService;
import io.egen.userMgmtApp.exception.UserAlreadyExistsException;
import io.egen.userMgmtApp.entity.Users;
import io.egen.userMgmtApp.exception.UserNotFoundException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value="/users")
@Api(tags="users")
public class UsersController {
	
	@Autowired
	private UsersService usersService;
	
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Create a new User", notes = "Create the new User in the system if it is not present in system")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 500, message = "Internal Server Error") })
	public Users createUser(@RequestBody Users user) throws UserAlreadyExistsException   {
		return usersService.createUser(user);
	}
	
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Find All Users", notes = "Returns the list of Users in the user management system.")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 500, message = "Internal Server Error") })
	public List<Users> findAllUsers() {
		return usersService.findAllUsers();
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "Find the user by id", notes = " Find any user in the user mgmt system using the Id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
							@ApiResponse(code = 404, message = " User Not found"),
							@ApiResponse(code = 500, message = "Internal Server Error") })
	public Users findUserById(@PathVariable("id") String id) throws UserNotFoundException {
		return usersService.findUserById(id);
		
	}
	
	
	@RequestMapping(value = "{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Update User", notes = "Update an existing User")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Internal Server Error") })
	public Users updateUser(@PathVariable("id") String id, @RequestBody Users user)
			throws UserNotFoundException {
		return usersService.updateUser(id, user);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Delete User", notes = "Delete an existing User")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Internal Server Error") })
	public void deleteUser(@PathVariable("id") String id)
			throws UserNotFoundException {
		usersService.deleteUser(id);
	}
		
	

}
