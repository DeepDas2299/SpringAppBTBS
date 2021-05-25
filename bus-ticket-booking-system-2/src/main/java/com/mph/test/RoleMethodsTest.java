package com.mph.test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.mph.controller.RoleController;
import com.mph.dao.RoleDao;
import com.mph.dao.RoleDaoImpl;
import com.mph.entity.Role;
import com.mph.service.RoleService;



public class RoleMethodsTest {

	static RoleDao roleDao;
	@BeforeClass
	public static void setup() {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-dao-test.xml");
		roleDao = (RoleDaoImpl)context.getBean("roleDao");
		
	}
	@Test
	public void testGetRoles() {
		
		List<Role> roles = roleDao.getAllRoles();
		assertTrue((roleDao.getAllRoles()).size() >= 1);
		
	}
	@Test
	public void testGetRole()
	{
		
		assertEquals((roleDao.getRolebyId(101L).getRoleName()),"admin");
	}
	@Test
	public void addRole()
	{
		roleDao.addRole(new Role(103L,"dummy"));
		assertEquals(roleDao.getRolebyId(103L).getRoleName(),"dummy");
	}
	@Test
	public void deleteRole()
	{
		roleDao.deleteRole(103L);
		assertNull(roleDao.getRolebyId(103L));
	}

}
