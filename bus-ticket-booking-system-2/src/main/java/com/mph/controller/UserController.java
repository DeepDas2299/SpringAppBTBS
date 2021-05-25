package com.mph.controller;

import java.util.List;

import javax.validation.Valid;
import com.mph.entity.User;
import com.mph.entity.ValidationEmail;
import com.mph.service.UserService;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RequestMapping("/user")
@RestController
@CrossOrigin(origins = "*", allowCredentials = "false", methods = {RequestMethod.GET,RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT},allowedHeaders = "*")
/**
 * @author Deep Das
 * @version 1.0
 */
public class UserController {
	@Autowired
	UserService userService;
	
	private static final Logger logger = Logger.getLogger("UserController.class");
	/**
	 * This method is used to get all Users.
	 * 
	 * @return ResponseEntity This returns a list of Users.
	 */
	@GetMapping("/all")
	public ResponseEntity<List<User>> getAllUsers() {

		List<User> userList = userService.getAllUsers();
		PropertyConfigurator.configure(UserController.class.getClassLoader().getResource("log4j.properties"));
		
		logger.info("Getting All Users");
		if (userList == null)
			return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<User>>(userList, HttpStatus.OK);
	}
	/**
	 * This method is used to get the User by Id.
	 * 
	 * @param id This parameter is used to get the User by id.
	 * @return ResponseEntity This returns a User with the given by id.
	 */
	@GetMapping("/{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") long id) {
		logger.info("Getting User with ID : " + id);
		User user = userService.getUserById(id);
		if (user != null)
			return new ResponseEntity<User>(user, HttpStatus.OK);
		return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
	}
	/**
	 * This method is used to get the User by Email.
	 * @param  emailToValidate This parameter is used to validate the User by Email.
	 * @return ResponseEntity This returns a User with the given by Email.
	 */
	@PostMapping("/email")
	public ResponseEntity<User> getUserByEmail(@RequestBody ValidationEmail emailToValidate) {
		logger.info("Getting User by Email : " + emailToValidate.getEmail());
		User userRes = userService.getUserbyEmail(emailToValidate.getEmail());
		// System.out.println(user.getUid());
		if (userRes != null)
			return new ResponseEntity<User>(userRes, HttpStatus.OK);
		return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
	}
	/**
	 * This method is used to add the Users.
	 * @param user This is passed down as the request body
	 * @return This returns a ResponseEntity  with a list of Users.
	 */
	@PostMapping("/add")
	public ResponseEntity<List<User>> addUser(@Valid @RequestBody User user) {
		logger.info("Adding User : " + user.getFname() + " " + user.getLname());
		List<User> userList = userService.addUser(user);
		if (userList == null)
			return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<User>>(userList, HttpStatus.OK);
	}
	/**
	 * This method is used to update the Users.
	 * 
	 * @param user This is passed down as the request body
	 * @return This returns a ResponseEntity  with a list of Users.
	 */
	@PutMapping("/update")
	public ResponseEntity<List<User>> updateUser(@RequestBody User user) {
		logger.info("Updating User : " + user.getUid());
		List<User> userList = userService.updateUser(user);
		if (userList == null)
			return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<User>>(userList, HttpStatus.OK);
	}
	/**
	 * This method is used to delete the User.
	 * 
	 * @param id This parameter is used to delete the User by id.
	 * @return ResponseEntity This returns a list of Users.
	 */
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<List<User>> deleteUser(@PathVariable("id") long id) {
		logger.info("Deleting User : " + id);
		List<User> userList = userService.deleteUser(id);
		if (userList == null)
			return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<User>>(userList, HttpStatus.OK);
	}

}