package io.egen.userMgmtApp.dao;

import java.util.List;

import io.egen.userMgmtApp.entity.Users;

public interface UsersDao {
	
	public Users findUserById(String id);
	
	public Users findUserByInfo(Users user);
	
	public Users createUser(Users users);
	
	public List<Users> findAllUsers();
	
	public Users updateUser(Users user);
	
	public void deleteUser(Users user);

}
