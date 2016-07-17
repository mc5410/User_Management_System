package io.egen.test.controller;

import java.util.Properties;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import io.egen.test.TestConfig;
import io.egen.userMgmtApp.controller.UsersController;
import io.egen.userMgmtApp.entity.Users;
import io.egen.userMgmtApp.exception.UserNotFoundException;
import io.egen.userMgmtApp.service.UsersService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={TestConfig.class})
@WebAppConfiguration
public class UserControllerTest {
	
	@Mock
	private UsersService service;
	
	@InjectMocks
	private UsersController controller;
	
	@Autowired
    WebApplicationContext wac;
	
	private MockMvc mockmvc;
	
	private Users user;
	
	private Users user1;
		
	
	@Before
	public void setup(){
				
		MockitoAnnotations.initMocks(this);
		this.mockmvc = MockMvcBuilders.webAppContextSetup(this.wac).dispatchOptions(true).build();
				
		user = new Users();
		user.setFirstName("dummy1");
		user.setMiddleName("dummy2");
		user.setLastName("dummy3");
		user.setAge("23");
		user.setGender("M");
		user.setPhone("9999999999");
		user.setZipcode("12345");
		user.setId(UUID.randomUUID().toString());
		
		user1 = new Users();
		user1.setFirstName("dummy1");
		user1.setMiddleName("dummy2");
		user1.setLastName("dummy3");
		user1.setAge("23");
		user1.setGender("M");
		user1.setPhone("9999999999");
		user1.setZipcode("12345");

		
	mockmvc = MockMvcBuilders.standaloneSetup(controller).setHandlerExceptionResolvers(exceptionResolver())
		                                         .build();
	}
	
	@Bean
	public SimpleMappingExceptionResolver exceptionResolver() {
	    SimpleMappingExceptionResolver exceptionResolver = new SimpleMappingExceptionResolver();
	 
	    Properties exceptionMappings = new Properties();
	 
	    exceptionMappings.put("UserNotFoundException", "error/404");
	    exceptionMappings.put("java.lang.Exception", "error/error");
	    exceptionMappings.put("java.lang.RuntimeException", "error/error");
	 
	    exceptionResolver.setExceptionMappings(exceptionMappings);
	 
	    Properties statusCodes = new Properties();
	 
	    statusCodes.put("error/404", "404");
	    statusCodes.put("error/error", "200");
	 
	    exceptionResolver.setStatusCodes(statusCodes);
	 
	    return exceptionResolver;
	}
	
	
	
	@Test
	public void findAllUsersTest() throws Exception{
		
		mockmvc.perform(MockMvcRequestBuilders.get("/users")).andExpect(MockMvcResultMatchers.status().isOk());
		
		Mockito.verify(service).findAllUsers();
		
	}
	
	
	@Test
	public void findUserByIdTest() throws Exception{
		
		mockmvc.perform(MockMvcRequestBuilders.get("/users/"+user.getId())).andExpect(MockMvcResultMatchers.status().isOk());
		
		Mockito.verify(service).findUserById(user.getId());
		
	}
	
	
	
	@SuppressWarnings("unchecked")
	@Test(expected=org.mockito.exceptions.verification.junit.ArgumentsAreDifferent.class)
	public void findUserByIdNotFoundTest() throws Exception {
		Mockito.when(service.findUserById(user.getId())).thenThrow(UserNotFoundException.class);
		
		mockmvc.perform(MockMvcRequestBuilders.get("/users/lolsada")).andExpect(MockMvcResultMatchers.status().isOk());
		
		Mockito.verify(service).findUserById(user.getId());
		
	}
	
	@Test
	public void createUserTest() throws Exception{
		
		 MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/users/",user);
	        ResultActions result = mockmvc.perform(request);
	        result.andExpect(MockMvcResultMatchers.status().isOk());
		
	}
	
	
	
	
	@Test
	public void updateUserTest() throws Exception{
		
		 MockHttpServletRequestBuilder request = MockMvcRequestBuilders.put("/users/"+user.getId(),user).contentType(MediaType.APPLICATION_JSON_VALUE);
	        ResultActions result = mockmvc.perform(request);
	        result.andExpect(MockMvcResultMatchers.status().isOk());
	}
	

	
	@Test
	public void deleteUserTest() throws Exception{
				
		 MockHttpServletRequestBuilder request = MockMvcRequestBuilders.delete("/users/"+user.getId());
	        ResultActions result = mockmvc.perform(request);
	        result.andExpect(MockMvcResultMatchers.status().isOk());
		
	}
	
	
	@SuppressWarnings("unchecked")
	@Test(expected=org.mockito.exceptions.verification.junit.ArgumentsAreDifferent.class)
	public void deletUserExceptionTest() throws Exception {
		Mockito.when(service.findUserById(user.getId())).thenThrow(UserNotFoundException.class);
		
		mockmvc.perform(MockMvcRequestBuilders.delete("/users/lolsada")).andExpect(MockMvcResultMatchers.status().isOk());
		
		Mockito.verify(service).deleteUser(user.getId());
	}
	
	
	 
	

}
