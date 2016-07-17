package io.egen.userMgmtApp.service;

import io.egen.userMgmtApp.exception.UserNotFoundException;

import java.util.List;

import io.egen.userMgmtApp.entity.Users;
import io.egen.userMgmtApp.exception.UserAlreadyExistsException;

public interface UsersService  {
	
	Users createUser(Users users) throws UserAlreadyExistsException;
		
	List<Users> findAllUsers();
	
	Users findUserById(String id) throws UserNotFoundException;
	
	Users updateUser(String id, Users user) throws UserNotFoundException;
	
	void deleteUser(String id) throws UserNotFoundException;

}
