package com.mph.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.mph.dao.RoleDao;
import com.mph.dao.UserDao;
import com.mph.entity.Role;
import com.mph.exception.DataAlreadyExistsException;
import com.mph.exception.DataNotFoundException;

@Service
@Transactional(isolation = Isolation.READ_COMMITTED)
public class RoleServiceImpl implements RoleService {

	@Autowired
	RoleDao roleDao;
	@Autowired
	UserDao userDao;

	@Override
	public List<Role> getAllRoles() {
		return roleDao.getAllRoles();
	}

	@Override
	public Role getRoleById(long id) {
		return roleDao.getRolebyId(id);
	}

	@Override
	public List<Role> addRole(Role role) {
		if(getRoleById(role.getRoleId()) != null)
			throw new DataAlreadyExistsException("Role with ID : " + role.getRoleId() + " already exists");
		else
			return roleDao.addRole(role);
	}

	@Override
	public List<Role> updateRole(Role role) {
		if(getRoleById(role.getRoleId()) == null)
			throw new DataNotFoundException("Role with ID : " + role.getRoleId() + " not found" );
		else
			return roleDao.updateRole(role);
	}

	@Override
	public List<Role> deleteRole(long id) {
		if(getRoleById(id) == null)
			throw new DataNotFoundException("Role with ID : " + id + " not found" );
		else
		{
			userDao.getUserByRole(id).forEach(user -> {
				user.setRole(null);
				userDao.updateUser(user);
			});
			return roleDao.deleteRole(id);
		}
	}

}
