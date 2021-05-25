package com.mph.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mph.entity.User;

@Repository
public class UserDaoImpl implements UserDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public User getUserbyId(long id) {
		return (User) getSession().createQuery("select u from BTBS_USER u where user_id =:id").setParameter("id", id).uniqueResult();
	}

	@Override
	public List<User> getAllUsers() {
		return getSession().createQuery("select u from BTBS_USER u").list();
	}

	@Override
	public List<User> addUser(User user) {
		getSession().save(user);
		return getAllUsers();
	}

	@Override
	public List<User> updateUser(User user) {
		getSession().merge(user);
		return getAllUsers();
	}

	@Override
	public List<User> deleteUser(long id) {
		getSession().evict(getUserbyId(id));
		getSession().createQuery("delete from BTBS_USER where user_id =:id").setParameter("id", id).executeUpdate();
		return getAllUsers();
	}

	@Override
	public User getUserbyEmail(String email) {
		return (User) getSession().createQuery("select u from BTBS_USER u where emailId = '" + email + "'").uniqueResult();
		
	}

	@Override
	public List<User> getUserByRole(long roleId) {
		return getSession().createQuery("select u from BTBS_USER u where ROLE_ID = :rid").setParameter("rid", roleId).list();
	}

}
