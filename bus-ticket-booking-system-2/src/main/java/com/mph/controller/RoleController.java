package com.mph.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
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

import com.mph.entity.Role;
import com.mph.service.RoleService;

@RestController
@RequestMapping("/role")
@CrossOrigin(origins = "*", allowCredentials = "false", methods = {RequestMethod.GET,RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT},allowedHeaders = "*")
/**
 * @author Deep Das
 * @version 1.0
 */
public class RoleController {

	@Autowired
	RoleService roleService;
	private static final Logger logger = Logger.getLogger("RoleController.class");
	/**
	 * This method is used to get all roles.
	 * 
	 * @return ResponseEntity This returns a list of roles.
	 */
	@GetMapping("/all")
	public ResponseEntity<List<Role>> getAllRoles() {
		logger.info("Getting All Roles");
		List<Role> roleList = roleService.getAllRoles();
		if (roleList.isEmpty())
			return new ResponseEntity<List<Role>>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<Role>>(roleList, HttpStatus.OK);
	}
	/**
	 * This method is used to get the role by Id.
	 * 
	 * @param id This parameter is used to get the role by id.
	 * @return ResponseEntity This returns a role with the given by id.
	 */
	@GetMapping("/{id}")
	public ResponseEntity<Role> getRole(@PathVariable("id") long id) {
		logger.info("Getting Role by ID : " + id);
		Role role = roleService.getRoleById(id);
		if (role != null)
			return new ResponseEntity<Role>(role, HttpStatus.OK);
		return new ResponseEntity<Role>(HttpStatus.NO_CONTENT);
	}
	/**
	 * This method is used to add the role.
	 * @param role This is passed down as the request body
	 * @return This returns a ResponseEntity  with a list of roles.
	 */

	@PostMapping("/add")
	public ResponseEntity<List<Role>> addRole(@Valid @RequestBody Role role) {
		logger.info("Getting Role : " + role.getRoleName());
		List<Role> roleList = roleService.addRole(role);
		return new ResponseEntity<List<Role>>(roleList, HttpStatus.OK);
	}
	/**
	 * This method is used to update the role.
	 * 
	 * @param role This is passed down as the request body
	 * @return This returns a ResponseEntity  with a list of role.
	 */
	@PutMapping("/update")
	public ResponseEntity<List<Role>> updateRole(@RequestBody Role role) {
		logger.info("Updating Role : " + role.getRoleId());
		List<Role> roleList = roleService.updateRole(role);
		return new ResponseEntity<List<Role>>(roleList, HttpStatus.OK);
	}
	/**
	 * This method is used to delete the role.
	 * 
	 * @param id This parameter is used to delete the role by id.
	 * @return ResponseEntity This returns a list of roles.
	 */
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<List<Role>> deleteRole(@PathVariable("id") long id) {
		logger.info("Deleting Role : " + id);
		List<Role> roleList = roleService.deleteRole(id);
		return new ResponseEntity<List<Role>>(roleList, HttpStatus.OK);
	}
}