package io.egen.userMgmtApp.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.egen.userMgmtApp.dao.UsersDao;
import io.egen.userMgmtApp.entity.Users;
import io.egen.userMgmtApp.exception.UserAlreadyExistsException;
import io.egen.userMgmtApp.exception.UserNotFoundException;

@Service
@Transactional
public class UsersServiceImpl implements UsersService{
	
	@Autowired
	private UsersDao dao;

	@Override
	public Users createUser(Users users) throws UserAlreadyExistsException {
		
		return dao.createUser(users);
	}

	@Override
	public Users findUserById(String id) throws UserNotFoundException {
		
		Users exists = dao.findUserById(id);
		
		if(exists == null){
			throw new UserNotFoundException();
		}
		else{
			return exists;
		}
	}

	@Override
	public Users updateUser(String id, Users user) throws UserNotFoundException {
		
		Users existing = dao.findUserById(id);
		
		if(existing == null){
			throw new UserNotFoundException();
		}
		else{
			return dao.updateUser(user);
		}
	}

	@Override
	public void deleteUser(String id) throws UserNotFoundException {
		
		Users exists = dao.findUserById(id);
		
		if(exists == null){
			
			throw new UserNotFoundException();
		}
		else{
			 dao.deleteUser(exists);
		}
		
	}

	@Override
	public List<Users> findAllUsers() {
		
		return dao.findAllUsers();
		
	}

}
