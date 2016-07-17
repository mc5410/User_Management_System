package io.egen.test.service;

import java.util.UUID;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import io.egen.test.TestConfig;
import io.egen.userMgmtApp.dao.UsersDao;
import io.egen.userMgmtApp.entity.Users;
import io.egen.userMgmtApp.exception.UserAlreadyExistsException;
import io.egen.userMgmtApp.exception.UserNotFoundException;
import io.egen.userMgmtApp.service.UsersService;
import io.egen.userMgmtApp.service.UsersServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={TestConfig.class})
public class UserServiceTest {
	
	@Mock
	private UsersDao dao;
	
	@InjectMocks
	private UsersService service = new UsersServiceImpl();
	
	@Mock
	private Users user;
	
	@Before
	public void setup(){
		
		MockitoAnnotations.initMocks(this);
		user = new Users();
		user.setFirstName("dummy1");
		user.setMiddleName("dummy2");
		user.setLastName("dummy3");
		user.setAge("23");
		user.setGender("M");
		user.setPhone("9999999999");
		user.setZipcode("12345");
		user.setId(UUID.randomUUID().toString());
	}
	
	@Test
	public void findAllUsersTest(){
		
		service.findAllUsers();
		Mockito.verify(dao).findAllUsers();
		
	}
	
	@Test
	public void findUserById() throws UserNotFoundException{
		
		Mockito.when(dao.findUserById(user.getId())).thenReturn(user); 
		
		Users actual = service.findUserById(user.getId());
		
	    Assert.assertEquals(user, actual);
		
	}
	
	@Test(expected=UserNotFoundException.class)
	public void findUserByIdExceptionTest() throws UserNotFoundException{
		
		Mockito.when(dao.findUserById(user.getId())).thenReturn(null);
		
		Users actual = service.findUserById(user.getId());
		
		Assert.assertEquals(null, actual);
	}
	
	@Test(expected=UserNotFoundException.class)
	public void updateUserExceptionTest() throws UserNotFoundException{
		
		Mockito.when(dao.updateUser(user)).thenReturn(null);
		service.updateUser(user.getId(), user);
		
	}
	
	@Test
	public void updateUserTest() throws UserNotFoundException{
		
		Mockito.when(dao.findUserById(user.getId())).thenReturn(user);
		service.updateUser(user.getId(), user);
		Mockito.verify(dao).updateUser(user);
		
	}
	
	@Test
	public void createUserTest() throws UserAlreadyExistsException{
		
		Mockito.when(dao.createUser(user)).thenReturn(user);
		Users actual = service.createUser(user);
		Assert.assertEquals(user, actual);
	}
	
	@Test(expected=UserNotFoundException.class)
	public void deleteUserExceptionTest() throws UserNotFoundException {
		
		Mockito.when(dao.findUserById(user.getId())).thenReturn(null);
		service.deleteUser(user.getId());
	}
	
	@Test
	public void deleteUserTest() throws UserNotFoundException{
		
		Mockito.when(dao.findUserById(user.getId())).thenReturn(user);
		service.deleteUser(user.getId());
		Mockito.verify(dao).deleteUser(user);
	}
	
	

}
