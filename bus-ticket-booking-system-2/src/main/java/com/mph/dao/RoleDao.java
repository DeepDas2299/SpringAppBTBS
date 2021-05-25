package com.mph.dao;

import java.util.List;

import com.mph.entity.Role;

/**
 * @author Farnaz S
 * @version 1.0
 */
public interface RoleDao {
	/**
	 * This method is used to get all Roles.
	 * 
	 * @return List This returns a list of Roles.
	 */
	public List<Role> getAllRoles();
	/**
	 * This method is used to get role by Id.
	 * 
	 * @param id This is the parameter to getRoleById method.
	 * @return Role This returns a list of Role.
	 */
	public Role getRolebyId(long id);
	/**
	   * This method is used to add role.
	   * @param role this is the parameter to addRole method
	   * @return List This returns a list of role.
	   */
	public List<Role> addRole(Role role);
	/**
	   * This method is used to update role.
	   * @param role this is the parameter to updateRole method
	   * @return List This returns a list of role.
	   */
	public List<Role> updateRole(Role role);
	/**
	   * This method is used to delete role.
	   * @param id this is the parameter to deleteRole method
	   * @return List This returns a list of role.
	   */
	public List<Role> deleteRole(long id);
}
