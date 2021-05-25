package com.mph.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.mph.entity.Role;

@Repository
public class RoleDaoImpl implements RoleDao {

	@Autowired
	private SessionFactory sessionFactory;

//	public void setSession(SessionFactory sessionFactory)
//	{
//		this.sessionFactory = sessionFactory;
//	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		try 
		{
		   return sessionFactory.getCurrentSession();
		} 
		catch (HibernateException e) 
		{
		    return sessionFactory.openSession();
		}
	}

	@Override
	public List<Role> getAllRoles() {
		return getSession().createQuery("select r from User_Role r").list();
	}

	@Override
	public Role getRolebyId(long id) {
		return (Role) getSession().createQuery("select r from User_Role r where roleId =:id").setParameter("id", id).uniqueResult();
	}

	@Override
	public List<Role> addRole(Role role) {
		//getSession().save(role);
		Query q = getSession().createSQLQuery("insert into User_Role values(:id, :name)");
		q.setParameter("id", role.getRoleId());
		q.setParameter("name", role.getRoleName());
		q.executeUpdate();
		return getAllRoles();
	}

	@Override
	public List<Role> updateRole(Role role) {
		getSession().evict(getRolebyId(role.getRoleId()));
		getSession().update(role);
		return getAllRoles();
	}

	@Override
	public List<Role> deleteRole(long id) {
		getSession().evict(getRolebyId(id));
		getSession().createQuery("delete from User_Role r where roleId =:id").setParameter("id", id).executeUpdate();
		return getAllRoles();
	}

}
