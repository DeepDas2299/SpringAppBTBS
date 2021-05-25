package com.mph.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.mph.dao.UserDao;
import com.mph.entity.User;
import com.mph.exception.DataAlreadyExistsException;
import com.mph.exception.DataNotFoundException;

@Service
@Transactional(isolation = Isolation.READ_COMMITTED)
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;

	@Override
	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}

	@Override
	public User getUserById(long id) {
		return userDao.getUserbyId(id);
	}

	@Override
	public List<User> addUser(User user) {
		if (getUserbyEmail(user.getEmailId()) != null)
			throw new DataAlreadyExistsException("User with email : " + user.getEmailId() + " already exists");
		else
			return userDao.addUser(user);
	}

	@Override
	public List<User> updateUser(User user) {
		if (getUserById(user.getUid()) == null)
			throw new DataNotFoundException("User with ID : " + user.getUid() + " not found" );
		else
			return userDao.updateUser(user);
	}

	@Override
	public List<User> deleteUser(long id) {
		if (getUserById(id) == null)
			throw new DataNotFoundException("User with ID : " + id + " not found" );
		else
			return userDao.deleteUser(id);
	}

	@Override
	public User getUserbyEmail(String email) {

		return userDao.getUserbyEmail(email);
	}

	@Override
	public List<User> getUserByRole(long roleId) {
		return userDao.getUserByRole(roleId);
	}

}
