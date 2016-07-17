package io.egen.test.dao;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

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
import io.egen.userMgmtApp.dao.UsersDaoImpl;
import io.egen.userMgmtApp.entity.Users;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={TestConfig.class})
public class UserDaoTest {
	
	@Mock
	private EntityManager em;
	
	@InjectMocks
	private UsersDao dao = new UsersDaoImpl();
	
	@Mock
	private TypedQuery<Users> query;
	
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
		
		List<Users> expected = Arrays.asList(user);
		Mockito.when(em.createQuery("SELECT u FROM Users u ORDER BY u.id ASC", Users.class)).thenReturn(query); 
		Mockito.when(query.getResultList()).thenReturn(expected);
		List<Users> users = dao.findAllUsers();
		Assert.assertEquals(expected, users);
		
	}
	
	@Test
	public void findUserByIdTest(){
		
		Mockito.when(em.find(Users.class, user.getId())).thenReturn(user);
		Users actual = dao.findUserById(user.getId());
		Assert.assertEquals(user, actual);
	}
	
	@Test
	public void createUserTest(){
		
		Mockito.when(em.find(Users.class, user.getId())).thenReturn(user);
		dao.createUser(user);
		Mockito.verify(em).persist(user);
	}
	
	@Test
	public void updateUserTest(){
		dao.updateUser(user);
		Mockito.verify(em).merge(user);
	}
	
	
	@Test
	public void deleteUserTest(){
		
		dao.deleteUser(user);
		Mockito.verify(em).remove(user);
	}
	
	
	
	 
	
	

}
