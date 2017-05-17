package com.lavesh.boot.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.lavesh.boot.demo.model.User;

@Repository
public class UserRepositoryImpl implements UserRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void create(User user) {
		entityManager.persist(user);
	}

	@Override
	public void update(User user) {
		entityManager.merge(user);
	}

	@Override
	public User getUserById(long id) {
		return entityManager.find(User.class, id);
	}

	@Override
	public void delete(long id) {
		User user = this.getUserById(id);
		if(user != null)
			entityManager.remove(user);
	}

	@Override
	public List<User> getAllUsers() {
		return entityManager.createQuery("select u from User u",User.class).getResultList();
	}

	@Override
	public User getUserByEmail(String email) {
		try {
			String query = "select u from User u where u.email=:email";
			return entityManager.createQuery(query, User.class).setParameter("email", email).getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
