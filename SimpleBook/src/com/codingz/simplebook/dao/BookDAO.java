package com.codingz.simplebook.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.codingz.simplebook.idao.IBookDAO;
import com.codingz.simplebook.model.Book;

@Repository
public class BookDAO extends HibernateDaoSupport implements IBookDAO {
	
	protected Session session;

	@Autowired
	public void setDummySessionFactory(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
		session = this.getHibernateTemplate().getSessionFactory().openSession();
	}	
	

	@Override
	public Book findById(Long id) throws Exception {
		// findById
				Book book = this.getHibernateTemplate().get(Book.class, id);
				return book;
	}

	@Override
	public List<Book> findAll() throws Exception {
		// findAll
				List<Book> bookList = session.createCriteria(Book.class).list();
				session.flush();
				session.clear();
				return bookList;
	}

	@Override
	public boolean save(Book book) throws Exception {
		// save
				this.getHibernateTemplate().save(book);
				return true;
	}

	@Override
	public boolean update(Book book) throws Exception {
		// update
				this.getHibernateTemplate().update(book);
				return true;
	}

	@Override
	public boolean delete(Book book) throws Exception {
		// delete
				this.getHibernateTemplate().delete(book);
				return true;
	}

}
