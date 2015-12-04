package com.codingz.simplebook.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.codingz.simplebook.idao.IStatusbDAO;
import com.codingz.simplebook.model.Statusb;
import com.codingz.simplebook.model.Type;

@Repository
public class StatusbDAO extends HibernateDaoSupport implements IStatusbDAO {
	
	protected Session session;

	@Autowired
	public void setDummySessionFactory(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
		session = this.getHibernateTemplate().getSessionFactory().openSession();
	}

	@Override
	public Statusb findById(Long id) throws Exception {
		Statusb statusb = this.getHibernateTemplate().get(Statusb.class, id);
		return statusb;
	}

	@Override
	public List<Statusb> findAll() throws Exception {
		List<Statusb> statusbList = session.createCriteria(Statusb.class).list();
		session.flush();
		session.clear();
		return statusbList;
	}

	@Override
	public boolean save(Statusb statusb) throws Exception {
		this.getHibernateTemplate().save(statusb);
		return true;
	}

}
