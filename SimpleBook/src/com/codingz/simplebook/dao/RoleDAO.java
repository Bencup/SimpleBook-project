package com.codingz.simplebook.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.codingz.simplebook.idao.IRoleDAO;
import com.codingz.simplebook.model.Role;
import com.codingz.simplebook.model.User;



@Repository
public class RoleDAO extends HibernateDaoSupport implements IRoleDAO {
	
	protected Session session;

	@Autowired
	public void setDummySessionFactory(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
		session = this.getHibernateTemplate().getSessionFactory().openSession();
	}


	@Override
	public Role findById(Long id) throws Exception {
		Role role = this.getHibernateTemplate().get(Role.class, id);
		return role;
	}

	@Override
	public List<Role> findAll() throws Exception {
		List<Role> roleList = session.createCriteria(Role.class).list();
		session.flush();
		session.clear();
		return roleList;
	}

	@Override
	public boolean save(Role role) throws Exception {
		this.getHibernateTemplate().save(role);
		return true;
	}

	@Override
	public boolean update(Role role) throws Exception {
		this.getHibernateTemplate().update(role);
		return true;
	}

	@Override
	public boolean delete(Role role) throws Exception {
		this.getHibernateTemplate().delete(role);
		return true;
	}

}
