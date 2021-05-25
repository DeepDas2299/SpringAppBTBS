package com.mph.dao;

import java.util.List;

import com.mph.entity.User;
/**
 * @author Farnaz S
 * @version 1.0
 */
public interface UserDao {
	/**
	 * This method is used to get user by Id.
	 * 
	 * @param id This is the parameter to getUserById method.
	 * @return user This returns user of long data type .
	 */
	public User getUserbyId(long id);
	/**
	 * This method is used to get user by Email.
	 * 
	 * @param email This is the parameter to getUserByEmail method.
	 * @return user This returns user of String data type .
	 */
	public User getUserbyEmail(String email);
	/**
	 * This method is used to get all users.
	 * 
	 * @return List This returns a list of users.
	 */
	public List<User> getAllUsers();
	/**
	 * This method is used to  add all user.
	 *  @param user this is the parameter to addUser method
	 * @return List This returns a list of user.
	 */
	public List<User> addUser(User user);
	/**
	 * This method is used to  update all user.
	 *   @param user this is the parameter to updateUser method
	 * @return List This returns a list of user.
	 */
	public List<User> updateUser(User user);
	/**
	 * This method is used to  delete all user.
	 *  @param id  this is the parameter to deleteUser method
	 * @return List This returns a list of user.
	 */
	public List<User> deleteUser(long id);
	/**
	 * This method is used to get user by Id.
	 * 
	 * @param roleId This is the parameter to getUserByRole  method.
	 * @return user This returns a list of  role.
	 */
	public List<User> getUserByRole(long roleId);

}
