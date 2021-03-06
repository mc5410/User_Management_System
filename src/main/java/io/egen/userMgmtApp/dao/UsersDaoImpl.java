package io.egen.userMgmtApp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import io.egen.userMgmtApp.entity.Users;

@Repository
@Transactional
public class UsersDaoImpl implements UsersDao{
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public Users findUserById(String id) {
		
		Users user = em.find(Users.class, id);
		
		return user;
	}

	@Override
	public Users createUser(Users users) {
		
		em.persist(users);
		 return users;
	}

	@Override
	public List<Users> findAllUsers() {
		
		String query = "SELECT u FROM Users u ORDER BY u.id ASC";
		List<Users> Users = em.createQuery(query, Users.class).getResultList();
		return Users;
	}

	@Override
	public Users updateUser(Users user) {
		
		return em.merge(user);
	}

	@Override
	public void deleteUser(Users user) {
		
		em.remove(user);
		
		
	}

	@Override
	public Users findUserByInfo(Users user) {
			
		TypedQuery<Users> qlString = em.createNamedQuery("Users.findUserByInfo", Users.class);
		qlString.setParameter("firstName", user.getFirstName());
		qlString.setParameter("middleName", user.getMiddleName());
		qlString.setParameter("lastName", user.getLastName());
		
		List<Users> users = qlString.getResultList();
		if ( users != null && users.size() == 1 ) {
			return users.get(0);
		} else {
			return null;
		}
	}

}
