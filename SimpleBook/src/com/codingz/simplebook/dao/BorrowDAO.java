package com.codingz.simplebook.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.codingz.simplebook.idao.IBorrowDAO;
import com.codingz.simplebook.model.Borrow;

@Repository
public class BorrowDAO extends HibernateDaoSupport implements IBorrowDAO {
	
	protected Session session;

	@Autowired
	public void setDummySessionFactory(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
		session = this.getHibernateTemplate().getSessionFactory().openSession();
	}

	@Override
	public Borrow findById(Long id) throws Exception {
		// findById
				Borrow borrow = this.getHibernateTemplate().get(Borrow.class, id);
				return borrow;
	}

	@Override
	public List<Borrow> findAll() throws Exception {
		// findAll
		List<Borrow> borrowList = session.createCriteria(Borrow.class).list();
		session.flush();
		session.clear();
		return borrowList;
	}

	@Override
	public boolean save(Borrow borrow) throws Exception {
		// save
		this.getHibernateTemplate().save(borrow);
		return true;
	}

	@Override
	public boolean update(Borrow borrow) throws Exception {
		// update
		this.getHibernateTemplate().update(borrow);
		return true;
	}

	@Override
	public boolean delete(Borrow borrow) throws Exception {
		// delete
		this.getHibernateTemplate().delete(borrow);
		return true;
	}

	@Override
	public List<Borrow> findBorrowByUserId(Long userId) throws Exception {
		Criteria criteria = session.createCriteria(Borrow.class);
		criteria.add(Restrictions.eq("user.id", userId));
		return criteria.list();
	}

}
