package com.mph.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

/**
 * This Entity is for the Role class
 * @author Divya G
 * @version 1.0
 */
@Entity(name="User_Role")
public class Role {
	@Id
	private long roleId;
	@NotBlank(message = "role cannot be empty")
	private String roleName;
	
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Role(long roleId, String roleName) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
	}

	public long getRoleId() {
		return roleId;
	}

	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", roleName=" + roleName + "]";
	}
	
}
