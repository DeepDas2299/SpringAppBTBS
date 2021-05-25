package com.mph.service;

import java.util.List;

import com.mph.entity.User;

/**
 * @author Pranathi G
 * @version 1.0
 */
public interface UserService {
	/**
	 * This method is used to get all Users.
	 * 
	 * @return List This returns a list of users.
	 */
	public List<User> getAllUsers();

	/**
	 * This method is used to get User by Email.
	 * 
	 * @param email this is the parameter to getUserbyEmail method
	 * @return User This returns a list of users.
	 */
	public User getUserbyEmail(String email);

	/**
	 * This method is used to get User By Id.
	 * 
	 * @param id This is the parameter to getUserById method.
	 * @return User This returns a list of users.
	 */
	public User getUserById(long id);

	/**
	 * This method is used to add users.
	 * 
	 * @param user this is the parameter to addUser method
	 * @return List This returns a list of users.
	 */
	public List<User> addUser(User user);

	/**
	 * This method is used to update Users.
	 * 
	 * @param user this is the parameter to updateUser method
	 * @return List This returns a list of users.
	 */
	public List<User> updateUser(User user);

	/**
	 * This method is used to delete users.
	 * 
	 * @param id this is the parameter to deleteUser method
	 * @return List This returns a list of users.
	 */
	public List<User> deleteUser(long id);

	/**
	 * This method is used to get User By Role.
	 * 
	 * @param roleId This is the parameter to getUserByRole method.
	 * @return User This returns a list of users.
	 */
	public List<User> getUserByRole(long roleId);
}