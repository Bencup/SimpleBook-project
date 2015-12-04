package com.codingz.simplebook.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.codingz.simplebook.idao.IUserDAO;
import com.codingz.simplebook.model.User;
import com.codingz.simplemember.model.Member;

@Repository
public class UserDAO extends HibernateDaoSupport implements IUserDAO {

	protected Session session;

	@Autowired
	public void setDummySessionFactory(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
		session = this.getHibernateTemplate().getSessionFactory().openSession();
	}

	@Override
	public User findById(Long id) throws Exception {
		// findById
		User user = this.getHibernateTemplate().get(User.class, id);
		return user;
	}

	@Override
	public List<User> findAll() throws Exception {
		// findAll
		List<User> userList = session.createCriteria(User.class).list();
		session.flush();
		session.clear();
		return userList;
	}

	@Override
	public boolean save(User user) throws Exception {
		// save
		this.getHibernateTemplate().save(user);
		return true;
	}

	@Override
	public boolean update(User user) throws Exception {
		// update
		this.getHibernateTemplate().update(user);
		return true;
	}

	@Override
	public boolean delete(User user) throws Exception {
		// delete
		this.getHibernateTemplate().delete(user);
		return true;
	}

	@Override
	public User findByUsername(String username) throws Exception {
		
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(User.class);
		detachedCriteria.add(Restrictions.eq("username", username));
		List<User> userList = this.getHibernateTemplate().findByCriteria(detachedCriteria);
		User user = userList.get(0);
		return user;
	}

}
