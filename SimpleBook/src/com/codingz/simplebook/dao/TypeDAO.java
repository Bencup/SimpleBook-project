package com.codingz.simplebook.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.codingz.simplebook.idao.ITypeDAO;
import com.codingz.simplebook.model.Type;
import com.codingz.simplemember.model.Member;

@Repository
public class TypeDAO extends HibernateDaoSupport implements ITypeDAO {
	
	protected Session session;

	@Autowired
	public void setDummySessionFactory(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
		session = this.getHibernateTemplate().getSessionFactory().openSession();
	}

	@Override
	public Type findById(Long id) throws Exception {
		Type type = this.getHibernateTemplate().get(Type.class, id);
		return type;
	}

	@Override
	public List<Type> findAll() throws Exception {
		List<Type> typeList = session.createCriteria(Type.class).list();
		session.flush();
		session.clear();
		return typeList;
	}

	@Override
	public boolean save(Type type) throws Exception {
		this.getHibernateTemplate().save(type);
		return true;
	}

}
